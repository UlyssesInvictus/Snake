   import java.util.ArrayList;  
	import java.util.Map;
   import java.util.Scanner;
   import java.io.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.awt.geom.*;
   import java.awt.RenderingHints.*;
   import javax.swing.*;
   import java.lang.*;	
	
	/** The JPanel that runs the main game*/
    public class SnakePanel extends JPanel   {
   /**Size of frame*/
      private final int FRAME = 400;
   /**Color of background*/
      private Color BACKGROUND;
   /**Image that graphics are painted on to*/
      private BufferedImage myImage;
   /**Graphics class for graphics*/
      private Graphics2D myBuffer;
   /**Main game snake*/
      private Snake snake;
   /**Main game food; can be eaten and regenerated*/
      private Food mainFood;
   /**Keeps the Snake from turning too fast*/
      private long lastPressProcessed = 0;
   /**Is the game over?*/
      private boolean isGameOver = false;
   /**Size of in-game wall*/
      private int wall;
   /**Current score*/
      private double score = 0;
   /**Current level*/
      private int level = 1;
   /**Difficulty*/
      private String diff;
   /**List of highscore names*/
      private ArrayList<String> hsnames;
   /**List of highscore scores*/
      private ArrayList<Integer> hsscores;
   /**On a screen between levels?*/
      private boolean betweenLevels = false;
   /**Used as a stopwatch*/
      private long anyTime = 0;
   /**Start time*/
      private long startTime;
   /**Timers for animation and other time-related processes*/
      private Timer action, snakespeed, leftTimer, rightTimer;
   /**Is the game muted?*/
      private boolean isMuted = false;
   /**Music that plays during game*/
      public Sound scottwinter;
   /**Sound that plays on level up*/
      private Sound stageclear;
	/**Sound that plays when food is eaten*/
		private Sound chomp;
	/**Map of the possible input keys and their actual input keys*/
		private Map<Integer, Integer> myKeys;
   /**Constructor of the game panel*/
       public SnakePanel(int speed, Map<Integer, Integer> keys, Color sc, Color fc, Color bgc)      {
			myKeys = keys;			
			BACKGROUND = bgc;		
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.createGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);      	
         wall = FRAME;      	
         snake = new Snake(sc);
         for(int k = 0;k < 10;k++)
            snake.addSegment(new Segment(200, 200 + 4 * k, Color.green));      	
         mainFood = new Food(200, 100, 12, fc);      	
         action = new Timer(1, new Listener());
         action.start();      	
         snakespeed = new Timer(speed, new SpeedListener());
         snakespeed.start();
         leftTimer = new Timer(speed + 30, new LeftListener());
         leftTimer.setInitialDelay(speed + 50);
         rightTimer = new Timer(speed + 30, new RightListener());
         rightTimer.setInitialDelay(speed + 50);      	
         startTime = System.currentTimeMillis();      	
         if(speed==40)
            diff = "easy";
         else if(speed==18)
            diff = "medium";
         else if(speed==15)
            diff = "hard";
         else
            diff = "insane";
         Scanner scoreScan = new Scanner(System.in);
         hsnames = new ArrayList<String>();
         hsscores = new ArrayList<Integer>();
         try{
            scoreScan = new Scanner(new File("HS"+diff+".txt"));}
             catch(Exception e)
            {}
         while(scoreScan.hasNext())         {
            hsnames.add(scoreScan.nextLine());
            hsscores.add(Integer.parseInt(scoreScan.nextLine()));         }      	
         scottwinter = new Sound("Scott Pilgrim_Another Winter.wav");
         stageclear = new Sound("Scott Pilgrim_Stage Clear.wav");
			chomp = new Sound("chomp.wav");
			scottwinter.loop();      	
         addKeyListener(new Key());
         setFocusable(true);      }
   /**Paint the screen*/
       public void paintComponent(Graphics g)      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);      }
   /**Codes for keyboard input*/
       public class Key extends KeyAdapter      {
          public void keyPressed(KeyEvent e)         { 	
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_RIGHT) && action.isRunning() && !rightTimer.isRunning())
               snake.turnRight();
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_LEFT) && action.isRunning() && !leftTimer.isRunning())
               snake.turnLeft();	
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_RIGHT) && action.isRunning())
               rightTimer.start();
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_LEFT) && action.isRunning())
               leftTimer.start();					
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_ESCAPE))             {              
               if(action.isRunning())               {
                  action.stop();
                  snakespeed.stop();
                  if(JOptionPane.showConfirmDialog(null,"Are you sure you want to return to the menu?", "GAME PAUSED", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
                     {
							scottwinter.exit();
							stageclear.exit();
							SnakeDriver.reload(new MenuPanel(false), "Finale Project: Snake!");							}
                  else if(!isGameOver)                  {
                     action.start();
                     snakespeed.start();                  }               }
               else if(JOptionPane.showConfirmDialog(null,"Are you sure you want to return to the menu?", "GAME PAUSED", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
      				{
						scottwinter.exit(); 
						stageclear.exit();           
						SnakeDriver.reload(new MenuPanel(false), "Finale Project: Snake!");						}            }
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_P))            {
               myBuffer.setColor(Color.red);
               myBuffer.drawString("PAUSED", FRAME / 2 - 20, FRAME / 2);
               repaint();
               if(action.isRunning())               {
                  action.stop();
                  snakespeed.stop();               }
               else if(!isGameOver)               {
                  action.start();            
                  snakespeed.start();               }            }
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_R))            {
               if(action.isRunning())               {
                  action.stop();
                  snakespeed.stop();
                  if(JOptionPane.showConfirmDialog(null,"Are you sure you want to reset?", "GAME PAUSED", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
                     {
							scottwinter.exit();
							stageclear.exit();
							SnakeDriver.reload(new SnakePanel(snakespeed.getDelay(), myKeys, snake.getColor(), mainFood.getColor(), BACKGROUND), "Finale Project: Snake!");
							}
                  else if(!isGameOver)                  {
                     action.start();
                     snakespeed.start();                  }               }
               else if(JOptionPane.showConfirmDialog(null,"Are you sure you want to reset?", "GAME PAUSED", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
      				{            
						scottwinter.exit();
						stageclear.exit();
						SnakeDriver.reload(new SnakePanel(snakespeed.getDelay(), myKeys, snake.getColor(), mainFood.getColor(), BACKGROUND), "Finale Project: Snake!");
						}
            }
				 if(e.getKeyCode() == myKeys.get(KeyEvent.VK_SPACE))            {
               isMuted = !isMuted;
               if(isMuted)
                  scottwinter.stop();
               else
                  scottwinter.loop();            }         }
          public void keyReleased(KeyEvent e)         {
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_RIGHT) && action.isRunning())
               rightTimer.stop();
            if(e.getKeyCode() == myKeys.get(KeyEvent.VK_LEFT) && action.isRunning())
               leftTimer.stop();         }      }
   /**Events that occur every second*/
       public class Listener implements ActionListener      {
          public void actionPerformed(ActionEvent e)         {
            if(betweenLevels)            {
               if(level > 4)               {
                  isGameOver = true;
                  myBuffer.setColor(Color.black);
                  myBuffer.fillRect(0, 0, FRAME, FRAME);
                  myBuffer.setColor(Color.red);
						score+=Math.max(0, 800000 - (System.currentTimeMillis() - startTime));
                  myBuffer.drawString("YOU WIN! Final Score: " + (int)score, FRAME / 2 - 40, FRAME / 2);
                  snakespeed.stop();
                  repaint();
						stageclear.play();			}
               else{
                  myBuffer.setColor(Color.black);
                  myBuffer.fillRect(0, 0, FRAME, FRAME);
                  myBuffer.setColor(Color.red);
                  myBuffer.drawString("Level: " + level, FRAME / 2 - 80, FRAME / 2);
                  if(System.currentTimeMillis() - anyTime > 5000)                  {
                     betweenLevels = false;
                     snakespeed.start();
							scottwinter.loop();                  }                }            }	
            if(!isGameOver && !betweenLevels)            {
               myBuffer.setColor(BACKGROUND);
               myBuffer.fillRect(0, 0, FRAME, FRAME);	            	
               myBuffer.setColor(Color.black);
               myBuffer.setStroke(new BasicStroke(7));
               myBuffer.drawRect((FRAME - wall) / 2, (FRAME - wall) / 2, wall, wall);
               myBuffer.setStroke(new BasicStroke(1));            	
               drawFood();            		
               drawSnake();            	
               if(mainFood.getCircle().intersects(snake.getHead().getX(), snake.getHead().getY(), 4, 4))
                  eatFood(mainFood);
               if(score > level * 3000 - level * 250)               {
                  myBuffer.setStroke(new BasicStroke(7));
                  myBuffer.setColor(BACKGROUND);
                  myBuffer.drawRect(FRAME / 2 - 10, (FRAME - wall) / 2, 20, 0);
                  myBuffer.setStroke(new BasicStroke(1));               }            		
               if(score > level * 3000 - level * 250 && snake.getHead().getX() > FRAME / 2 - 10 && snake.getHead().getX() < FRAME / 2 + 10 && snake.getHead().getY() < (FRAME - wall) / 2 + 5)
               {
                  anyTime = System.currentTimeMillis();
                  increaseLevel();
                  betweenLevels = true;
                  snakespeed.stop();
                  mainFood = new Food((int)(Math.random() * (wall - 23) + ((FRAME - wall) / 2 + 5)), (int)(Math.random() * (wall - 23) + ((FRAME - wall) / 2 + 5)), 12, mainFood.getColor());       
					}            		
               isGameOver = isDead();            }		
            else if(!betweenLevels)
               gameOver();
            myBuffer.setColor(Color.red);
            myBuffer.drawString("Score: "+(int)score, FRAME - 80, FRAME - 6);
            myBuffer.drawString("Level: "+level, 20, FRAME - 6);
            repaint();  				 }      }
   /**Moves snake and increments score; change in speed of timer changes speed of snake*/
       public class SpeedListener implements ActionListener      {
          public void actionPerformed(ActionEvent e)         {
            snake.move();
            score+=0.2;         }      }
   /**Turns snake left constantly after start by keyboard until stop by keyboard*/
       public class LeftListener implements ActionListener      {
          public void actionPerformed(ActionEvent e)         {
            snake.turnLeft();         }      }	
   /**Turns snake right constantly after start by keyboard until stop by keyboard*/
       public class RightListener implements ActionListener      {
          public void actionPerformed(ActionEvent e)         {
            snake.turnRight();         }      }	 
   /**Draw the snake on the screen*/		
       public void drawSnake()      {
         myBuffer.setColor(snake.getColor()); 
         myBuffer.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
         myBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
         for(Segment seg : snake.getSegments())         {
            myBuffer.fillRect(seg.getX(), seg.getY(), 4, 4);
            myBuffer.setColor(Color.black);
            myBuffer.drawRect(seg.getX(), seg.getY(), 4, 4);
            myBuffer.setColor(snake.getColor());         }
         myBuffer.setColor(Color.red);
         myBuffer.setStroke(new BasicStroke(1)); 
         myBuffer.drawLine((int)(snake.getSegment(0).getRect().getCenterX()), (int)(snake.getSegment(0).getRect().getCenterY()), (int)(10 * Math.cos(snake.getDir()) + snake.getHead().getRect().getCenterX()), (int)(10 * Math.sin(snake.getDir()) + snake.getHead().getRect().getCenterY()));
      }
   /**Draw the food on the screen*/
       public void drawFood()      {
         myBuffer.setColor(mainFood.getColor());
         if(mainFood.getX()>=0)
            myBuffer.fillOval(mainFood.getX(), mainFood.getY(), mainFood.getWorth(), mainFood.getWorth());      }
   /**Eat the food, update score, and generate new food
   *@param f	The Food to be eaten   */
       public void eatFood(Food f)      {
         score+=mainFood.getWorth() * 10;
         Segment tail = snake.getSegments().get(snake.getLength() - 1);
         for(int k = 0;k < f.getWorth();k++)
            snake.addSegment(new Segment(tail.getX(), tail.getY(), snake.getColor()));
         if(score < level * 3000 - level * 250)
            mainFood = new Food((int)(Math.random() * (wall - 23) + ((FRAME - wall) / 2 + 5)), (int)(Math.random() * (wall - 23) + ((FRAME - wall) / 2 + 5)), 12, mainFood.getColor());
         else
            mainFood = new Food(-1, -1, 0, Color.black);				chomp.play();      }
   /**Carries out game over situation*/
       public void gameOver()      {
         myBuffer.setColor(Color.black);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
         myBuffer.setColor(Color.red);
         myBuffer.drawString("GAME OVER", FRAME / 2 - 40, FRAME / 2);			
         myBuffer.drawString("High Scores:", FRAME / 2 - 40, FRAME / 2 + 20);
         repaint();      	
         String name = JOptionPane.showInputDialog(null, "Name?", "Game over...", JOptionPane.QUESTION_MESSAGE);     	
         int pos = 0;
         for(int k = 0;k < hsscores.size();k++)
            if(hsscores.get(k) > score)
               pos++;
         hsscores.add(pos, (int)score);
         hsnames.add(pos, name);      	
         for(int k = 0;k < 6;k++)
            myBuffer.drawString(hsnames.get(k), FRAME / 2 - 120, FRAME / 2 + 40 + k * 20);
         for(int k = 0;k < 6;k++)
            myBuffer.drawString("" + hsscores.get(k), FRAME / 2 + 65, FRAME / 2 + 40 + k * 20);      	
			saveScores();         repaint(); 	 action.stop();         snakespeed.stop();      }
   /**Tests if the snake is dead and the game is over
   *@return Is the snake dead?   */
       public boolean isDead()      {
         if(snake.getHead().getX() < (FRAME - wall) / 2 + 4 || snake.getHead().getX() > FRAME - ((FRAME - wall) / 2) - 8 || snake.getHead().getY() < (FRAME - wall) / 2 + 4 || snake.getHead().getY() > FRAME - (FRAME - wall) / 2 - 8)     
            return true;//4 is half-thickness of wall
         for(int k = 2;k < snake.getLength(); k++)
            if(snake.getSegment(0).getRect().intersects(snake.getSegment(k).getRect()))
               return true;
         return false;      }
   /**Increases the level*/
       public void increaseLevel()      {
         level++;
         while(snake.getLength() > 0)
            snake.removeSegment();
         for(int k = 0;k < 10;k++)
            snake.addSegment(new Segment(200, wall - 50 + 4 * k, Color.black));
         snake.setDir(Math.PI * 3.0 / 2.0);
      	scottwinter.stop();
         stageclear.play();      }
	/**Save high scores to file*/
		public void saveScores()		{
         PrintStream outfile = null;
         try{
            outfile = new PrintStream(new FileOutputStream("HS" + diff + ".txt"));         }
             catch(FileNotFoundException e)            {
               JOptionPane.showMessageDialog(null,"The file could not be created.");            }
         System.setOut(outfile);
         for(int k = 0;k < hsnames.size(); k++)				{
				System.out.println(hsnames.get(k));
				System.out.println(hsscores.get(k));				}         outfile.close();		}   }
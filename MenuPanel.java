   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
	import java.util.*;
/**MenuPanel that opens when the game runs.*/
    public class MenuPanel extends javax.swing.JPanel
   {
    /**OptionPanel that opens options screen*/	 
      private OptionPanel optPan;
    /**SnakePanel that runs game screen*/
      private SnakePanel snakePan;
	/**Map of the possible input keys and their actual input keys*/
		public static Map<Integer, Integer> myKeys;
	/**Snake color*/
		public static Color sc = Color.green;
	/**Food color*/
		public static Color fc = Color.black;
	/**Background color*/
		public static Color bgc = Color.yellow.brighter().brighter();
    /** Creates new MainPanel with buttons*/
       public MenuPanel(boolean firstOpen)      {
			setLayout(new GridLayout(5,0));
			JLabel title = new JLabel("SNAKE", JLabel.CENTER);
			add(title);
		JButton snakeButton = new javax.swing.JButton("SNAKE");
			add(snakeButton);
         JButton optButton = new javax.swing.JButton("Options");
      	add(optButton);
			JButton tutorialButton = new JButton("Instruction");
			add(tutorialButton);
			JButton creditsButton = new JButton("Credits");
			add(creditsButton);
		optButton.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     optButtonActionPerformed(evt);              }               });
         snakeButton.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     snakeButtonActionPerformed(evt);                  }               });
         tutorialButton.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     tutButtonActionPerformed(evt);                  }               });
         creditsButton.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     credButtonActionPerformed(evt);                  }               });
			if(firstOpen)			{						
			myKeys = new HashMap<Integer, Integer>();
			myKeys.put(KeyEvent.VK_LEFT, KeyEvent.VK_LEFT);
			myKeys.put(KeyEvent.VK_RIGHT, KeyEvent.VK_RIGHT);
			myKeys.put(KeyEvent.VK_P, KeyEvent.VK_P);
			myKeys.put(KeyEvent.VK_ESCAPE, KeyEvent.VK_ESCAPE);
			myKeys.put(KeyEvent.VK_R, KeyEvent.VK_R);
			myKeys.put(KeyEvent.VK_SPACE, KeyEvent.VK_SPACE);			}
      }
   /**Actions of option button*/
       private void optButtonActionPerformed(java.awt.event.ActionEvent evt)       {
		optPan = new OptionPanel(myKeys, sc, fc, bgc);
		SnakeDriver.reload(optPan, "Final Project: SNAKE!");      }
   /**Actions of game button*/
       private void snakeButtonActionPerformed(java.awt.event.ActionEvent evt)      {
		DiffPanel diff = new DiffPanel(myKeys, sc, fc, bgc);
		SnakeDriver.reload(diff, "Final Project: SNAKE!");      }
    /**Displays tutorial*/
       private void tutButtonActionPerformed(java.awt.event.ActionEvent evt)       {
		String s = "Press the left arrow key to turn counter-clockwise and the right to turn clockwise;";
		s+="\n you move forward automatically.";
		s+="\n Press p to pause, r to reset the game, the escape key to return to the main menu, and the space bar to mute/unmute music.";
		s+="\nThese keys can be changed in the option menu.";
		s+="\nEat food (the circles) to increase your score and grow in length.";
		s+="\nIf you hit the wall or hit yourself, it's game over!";
		s+="\nIf you reach your level * 3000 points an opening will appear in the wall.";
		s+="\nGo through it to get to the next level.";
		s+="\nThere are 4 levels in total, but you're not supposed to be able to beat them all.";		
		s+="\nThe faster you beat the levels, the more points you get.";
		s+="\nGet as many points as you can and enter the highscores!";
		s+="\nChoose your difficulty when you press the play button.";
		JOptionPane.showMessageDialog(null, s, "Instructions", JOptionPane.INFORMATION_MESSAGE);      }  
       private void credButtonActionPerformed(java.awt.event.ActionEvent evt)      {
		String s = "I don't always spent copious amounts of time working on projects,";
		s+="\nbut when I do it's to make Snake.";
		s+="\nStay thirsty my friends.";
		s+="\n--Le Raynor Kuang";	
		s+="\n(And many additional thanks to the Internet, for always being there for me,";
		s+="\nto NetBeans for making my life easier with GUI's,";
		s+="\nto Mr. Rose for being a great teacher,";
		s+="\nand to Scott Pilgrim the Game, from which I took this awesome music)";
		JOptionPane.showMessageDialog(null, s, "Instructions", JOptionPane.INFORMATION_MESSAGE);      }
		 public static void setKeys(Map<Integer, Integer> keys)		{
		myKeys = keys;		}
		 public static void setColors(Color snakec, Color foodc, Color backc)		{
		sc = snakec;
		fc = foodc;
		bgc = backc;		}
       public void paint(Graphics g)      {
         ImageIcon snakeTitle = new ImageIcon("snaketitle.png");
         super.paint(g);
         g.drawImage(snakeTitle.getImage(), 300 - (snakeTitle.getIconWidth() / 2), 10, getParent());   }   }
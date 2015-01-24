   import javax.swing.*;
   import java.util.Map;
   import java.awt.*;
   import java.awt.event.*;
    public class DiffPanel extends JPanel   {
	/**Buttons for difficulty choice*/
      JButton easy, medium, hard, insane;
	/**Description of each difficulty*/
      JTextArea description;
	/**subPanel with buttons*/
      JPanel cPanel;
	/**SnakePanel to be loaded for game*/
      SnakePanel snake;
   /**Map of the possible input keys and their actual input keys*/
      private Map<Integer, Integer> myKeys;
   /**Snake, Food, and background colors*/
      private Color sc, fc, bgc;
	/**Creates a difficulty panel where you can choose difficulty of the Snake game
	*@param keys	The user chosen controls
	*@param snakec		Color of snake
	*@param foodc		Color of food
	*@param backc		Color of background*/
       public DiffPanel(Map<Integer, Integer> keys, Color snakec, Color foodc, Color backc)      {
         myKeys = keys;
         sc = snakec;
         fc = foodc;
         bgc = backc;
         setLayout(new BorderLayout());      	
         description = new JTextArea("");         
         add(description, BorderLayout.CENTER);      	
         cPanel = new JPanel();
         cPanel.setLayout(new GridLayout(4, 1));
         add(cPanel, BorderLayout.WEST);      	
         easy = new JButton("Easy");
         easy.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     snake = new SnakePanel(40, myKeys, sc, fc, bgc);
                     SnakeDriver.reload(snake, "Final Project: Snake!");                  }               });
         easy.addMouseListener(new EasyListener());
         cPanel.add(easy);      	
         medium = new JButton("Medium");
         medium.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     snake = new SnakePanel(18, myKeys, sc, fc, bgc);
                     SnakeDriver.reload(snake, "Final Project: Snake!");                  }               });
         medium.addMouseListener(new MediumListener()); 
         cPanel.add(medium);
      	
         hard = new JButton("Hard");
         hard.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     snake = new SnakePanel(15, myKeys, sc, fc, bgc);
                     SnakeDriver.reload(snake, "Final Project: Snake!");                  }               });
         hard.addMouseListener(new HardListener()); 
         cPanel.add(hard);
      	
         insane = new JButton("Insane");
         insane.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     snake = new SnakePanel(5,myKeys, sc, fc, bgc);
                     SnakeDriver.reload(snake, "Final Project: Snake!");                  }               });
         insane.addMouseListener(new InsaneListener()); 
         cPanel.add(insane);
      }
		/**Gives description of easy level*/
       public class EasyListener implements MouseListener      {
          public void mouseEntered(MouseEvent evt)          {
            String s = "Well, everyone needs to start somewhere.";
            s+="\nPlaying this level is kind of a waste of all the time I spent making this game,";
            s+="\nbut whatever, you're the player.";
            s+="\nWuss.";
            description.setText(s);         }
          public void mouseExited(MouseEvent evt)         {
            description.setText("");         }
          public void mouseClicked(MouseEvent evt) {}
          public void mousePressed(MouseEvent evt){}
          public void mouseReleased(MouseEvent evt) {}      }
		/**Gives description of medium level*/
       public class MediumListener implements MouseListener      {
          public void mouseEntered(MouseEvent evt)         {
			String s = "Good job.";
			s+="\nYou are completely standard.";
			s+="\nIn no way special, at all.";
			s+="\nI totally expected you to pick this difficulty.";
			s+="\nJust like everyone else.";
			s+="\nI just, I dunno, thought you'd be more of a rebel.";
			s+="\nBut it's okay, it's fine.";
			s+="\nPlaying medium is completely fine.";
			s+="\nIf you're happy with where you are in life.";
            description.setText(s);         }
          public void mouseExited(MouseEvent evt)         {
            description.setText("");         }
          public void mouseClicked(MouseEvent evt) {}
          public void mousePressed(MouseEvent evt) {}
          public void mouseReleased(MouseEvent evt) {}      }
		/**Gives description of hard level*/
       public class HardListener implements MouseListener      {
          public void mouseEntered(MouseEvent evt)          {
			String s = "Now that's more like it.";
			s+="\nGoing for the gold,";
			s+="\nshooting for the stars.";
			s+="\nYou're a real champ.";
			s+="\nCruising through life, you like to take the fast lane.";
			s+="\nYou stop for nothing.";
			s+="\nThis is truly the difficulty kings play Snake on.";
			s+="\nBut what about gods?";
			s+="\nThere's still one more difficulty setting...";
            description.setText(s);         }
          public void mouseExited(MouseEvent evt)          {
            description.setText("");         }
          public void mouseClicked(MouseEvent evt) {}
          public void mousePressed(MouseEvent evt) {}
          public void mouseReleased(MouseEvent evt) {}      }
		/**Gives description of insane level*/
       public class InsaneListener implements MouseListener      {
          public void mouseEntered(MouseEvent evt)          {
			String s = "I worship thee, O great one.";
			s+="\nThis isn't Sparta.";
			s+="\nThis is INSANITY.";
			s+="\nOf the legends, you rise above them all.";
			s+="\nBecause you are EPIC.";
			s+="\nYou're Evel Knievel, the Flash, Rambo, and a Ninja all rolled into one.";
			s+="\nBut at heart, to actually attempt this";
			s+="\nYou must be CRAZY.";
			s+="\nYou're more jittey than the Joker,";
			s+="\nmore loony than the Mad Hatter.";
			s+="\nI really wouldn't want to be trapped in a dark room with you.";
			s+="\nAnyways, good luck on this.";
			s+="\nYou'll need it.";
            description.setText(s);         }
          public void mouseExited(MouseEvent evt)          {
            description.setText("");         }
          public void mouseClicked(MouseEvent evt) {}
          public void mousePressed(MouseEvent evt) {}
          public void mouseReleased(MouseEvent evt) {}      }   }
   import javax.swing.*;
/** The Driver of Snake, where it all begins.
* IMPORTANT--> See Snake class and OptionPanel class for data structure
* All of this was done by Raynor Kuang
* Version: 6/1/2011*/
    public class SnakeDriver   {
   	/**Frame of the game.*/
      private static JFrame frame;
   	/**Runs the game.*/
       public static void main(String[] args)      {
         initialize();      }
   	/**Actually initializes the program.*/
       private static void initialize()      {
         frame = new JFrame("Final Project: Snake!");
         frame.setSize(600, 650);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         MenuPanel m = new MenuPanel(true);
         frame.setContentPane(m);
         m.requestFocus();
         frame.setVisible(true);      }
   	/**Reloads the frame with a new panel.
   	*@param j	JPanel run in the game frame
   	*@param s	Title of the panel   	*/
       public static void reload(JPanel j, String s)      {
         frame.remove(frame.getContentPane());
         frame.setTitle(s);
         frame.setContentPane(j);
         j.requestFocus();
         frame.setVisible(true);      }   }
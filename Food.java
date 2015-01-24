   import java.awt.*;
   import java.awt.geom.*;
/**The Food class; eaten by the Snake*/
    public class Food   {
   /**Coordinates of food*/
      public int myX, myY;
   /**Worth of food*/
      public int myWorth;
   /**Circle bounded by square with upper left corner myX, myY*/
      public Ellipse2D.Double myCirc; 
   /**Color of food*/
      public Color myColor;
   /**Constructor for the food
   *@param x	x-coordinate of food
   *@param y	y-coordinate of food
   *@param worth	worth of food*/
       public Food(int x, int y, int worth, Color c)      {
         myX = x;         myY = y;         myWorth = worth;
         myCirc = new Ellipse2D.Double(x, y, worth, worth);			myColor = c;      }
   /**Returns x-coordinate of food
   *@return the x coordinate of the food*/
       public int getX()      {
         return myX;      }
   /**Returns y-coordinate of food
   *@return the y coordinate of the food*/
       public int getY()      {
         return myY;      }
   /**Returns the circle defining the food
   *@return the circle bounded by the square with the upper left corner of the food's coordinates*/
       public Ellipse2D getCircle()      {
         return myCirc;      }
   /**Returns the worth of the food
   *@return the worth of the food*/
       public int getWorth()      {
         return myWorth;      }
   /**Sets color of food
   *@param c	Color of food*/
       public void setColor(Color c)      {
         myColor = c;      }
   /**Returns color of food
   *@return		Color of food*/
       public Color getColor()      {
         return myColor;      }   }
   import java.awt.*;
	/**The segment class that makes up the Snake.	*/
    public class Segment    {
   /**Color of the segment*/
      public Color myColor;
   /**Coordinates of the segment*/
      public int myX, myY;
   /**Size of the segment*/
      public int mySize;
   /**Square with upper left corner of the segment's coordinates*/
      public Rectangle myRect;
   /** Segment constructor
   * @param x		The x-coordinate, in pixels, of myLoc
   * @param y		The y-coordinate, in pixels, of myLoc
   * @param color	The color of this segment.   */		
       public Segment(int x, int y, Color color)      {
         myX = x;
         myY = y;
         myColor = color;
         myRect = new Rectangle(x, y, 4, 4);      }	
   /**Get the color of the segment
   *@return the current color of the segment*/
       public Color getColor()      {
         return myColor;      }
   /**Get the x-coordinate of the segment
   *@return the x-coordinate of the segment*/
       public int getX()      {
         return myX;      }
   /**Get the y-coordinate of the segment
   *@return the y-coordinate of the segment*/
       public int getY()      {
         return myY;      }
   /**Get the size of the segment
   *@return the current size of the segment*/
       public int getSize()      {
         return mySize;      }
   /**Returns the square representing the segment
   *@return the square with upper left corner of the segment's coordinates*/
       public Rectangle getRect()      {
         return myRect;      }
   /**Set the color of the segment
   *@param c the new color of the segment*/
       public void setColor(Color c)      {
         myColor = c;      }
   /**Set the x-coordinate of the segment
   *@param x	the new x-coordinate of the segment*/
       public void setX(int x)      {
         myX = x;
         myRect.setBounds(x, myY, 4, 4);      }
   /**Set the y-coordinate of the segment
   *@param y 	the new y-coordinate of the segment*/
       public void setY(int y)      {
         myY = y;
         myRect.setBounds(myX, y, 4, 4);      }
   /**Set the size of the segment
   *@param size	 the new size of the segment*/
       public void setSize(int size)      {
         mySize = size;      }   }
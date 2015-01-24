   import java.awt.*;
   import java.lang.*;
   import java.util.*;
/**A Snake class.  SEE segments FIELD FOR DATA STRUCTURE*/
    public class Snake   {
   /**The segments that make up the snake.
   * Segments can be added, removed, and gotten from index using this data structure   */
      public ArrayList<Segment> segments;
   /**Speed factor of snake*/
      public double mySpeed;
   /**Direction of snake*/
      public double myDir;
   /**Color of snake*/
      public Color myColor;
   /**Length of snake i.e. number of segments*/
      public int myLength;
   /**Creates a snake of color c
   * @param c	The color of the snake*/
       public Snake(Color c)      {
         segments = new ArrayList<Segment>();
         mySpeed = 4;
         myDir = Math.PI * 3.0 / 2.0;
         myColor = c;//Color taken from slider bar
         myLength = 0;      }
   /**Moves the snake in its current direction*/
       public void move()      {
         segments.remove(myLength - 1);
         int dx = (int)(mySpeed * Math.cos(myDir));
         int dy = (int)(mySpeed * Math.sin(myDir));
         Segment newHead = new Segment(segments.get(0).getX() + dx, segments.get(0).getY() + dy, myColor);
         segments.add(0, newHead);      } 
   /**Add a segment to the snake and increment length
   *@param seg		The segment to be added*/
       public void addSegment(Segment seg)      {
         segments.add(seg);
         myLength++;      }
   /**Remove a segment and decrement length
   *@return 	The removed segment*/
       public Segment removeSegment()      {
         myLength--;
         return segments.remove(myLength);      }
   /**Returns the direciton of the snake
   *@return 	The current direction*/
       public double getDir()      {
         return myDir;      }
   /**Returns the length of the snake
   *@return 	The current length*/
       public int getLength()      {
         return myLength;      }
   /**Returns the color of the snake
   *@return 	The current color*/
       public Color getColor()      {
         return myColor;      }
   /**Sets the snake's color
   *@param c	The new color of the snake*/
       public void setColor(Color c)      {
         myColor = c;
         for(Segment seg : segments)
            seg.setColor(c);      }
   /**Returns the Segments of the snake
   *@return		The segments field making up the snake*/
       public ArrayList<Segment> getSegments()      {
         return segments;      }
   /**Returns the Segment of number k in the segments field
   *@param k	number of the segment
   *@return A segment of number k*/
       public Segment getSegment(int k)      {
         return segments.get(k);      }
   /**Returns first Segment in the snake; identical to calling getSegment(0)
   *@return The first Segment in the segments field
   *@see Segment getSegments(int k)*/
       public Segment getHead()      {
         return segments.get(0);      }	
   /**Turns snake right*/		
       public void turnRight()      {
         myDir+=(Math.PI / 8.25);      }
   /**Turns snake left*/
       public void turnLeft()      {
         myDir-=(Math.PI / 8.25);      }
   /**Changes the snake's direction
   *@param dir		The new direction of the snake*/
       public void setDir(double dir)      {
         myDir = dir;      }
   /**Returns snake's distance from a point
   *@param x	x-coordinate of point
   *@param y	y-coordinate of point
   *@return 	distance of snake from point*/
       public double getDistance(int x, int y)      {
         int xDist = segments.get(0).getX() - x;
         int yDist = segments.get(0).getY() - y;
         return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));      }   }
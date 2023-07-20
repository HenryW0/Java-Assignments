import java.awt.*;
import java.awt.geom.*;

/**
* Class for CarShape to complete AnimationTester1 GUI
* @author Henry Wahhab (Code obtained from https://horstmann.com/oodp3/code/ch04/animation/CarShape.java.html)
* @version 1.0 4/1/23
*/

/**
A car that can be moved around. Class obtained from https://horstmann.com/oodp3/code/ch04/animation/CarShape.java.html
*/

public class CarShape implements MoveableShape
{
	private int x;
    private int y;
    private int width;
    
	/**
	Constructs a car item.
	@param x the left of the bounding rectangle
	@param y the top of the bounding rectangle
	@param width the width of the bounding rectangle
	*/
	public CarShape(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	/**
	 * Returns the x position of the car
	 * @return the x coordinate 
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Sets the x position to the specified parameter
	 * @param xp - the x position that the coordinate will be set to
	 * precondition: the parameter is a valid integer
	 */
	public void setX(int xp)
	{
		x = xp;
	}
	
	/**
	 * Sets width of car to the specified value
	 * @param w - the width that the car will be set to
	 * precondition: w is a positive integer
	 */
	public void setWidth(int w)
	{
		width = w;
	}
	
	/**
	 * Translates the car one unit forward in the x direction
	 */
	public void move()
	{
		this.x ++ ;
	}

	/**
	 * Draws all parts of the car
	 * @param g2 - The Graphics2D object that is used for drawing
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6,  width - 1, width / 6);
		
		Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
		
		Ellipse2D.Double rearTire  = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);
		 
		// The bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
		
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
		      
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
		        
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
		      
		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		        
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		       
		g2.setStroke(new BasicStroke(2));
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}

	/**
	 * Paints the Icon using the draw method for CarShapes
	 * @param c - The component used 
	 * @param g - Graphics object that is used to draw 
	 * @param xp - the X coordinate 
	 * @param yp - the Y coordinate
	 * precondition: All parameters are valid
	 */
	public void paintIcon(Component c, Graphics g, int xp, int yp) {
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}

	/**
	 * Returns the width of the icon
	 * @return the width of the car
	 */
	public int getIconWidth() {
		return width;
	}

	/**
	 * Returns the height of the icon
	 * @return the height of the car
	 */
	public int getIconHeight() {
		return y + width / 3;
	}     
}
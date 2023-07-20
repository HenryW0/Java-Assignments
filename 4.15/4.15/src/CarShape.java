import java.awt.*;
import java.awt.geom.*;
import javax.swing.Icon;

/**
* Class for CarShape to complete ZoomTester GUI
* @author Henry Wahhab (Code obtained from https://horstmann.com/oodp3/code/ch04/animation/CarShape.java.html)
* @version 1.0 4/1/23
*/

/**
A car that can be moved around. Class obtained from https://horstmann.com/oodp3/code/ch04/animation/CarShape.java.html
*/

public class CarShape implements Icon
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
	 * Sets the width of the car
	 * @param w - the width that the car will be set to
	 * precondition: the parameter is a positive integer
	 */
	public void setWidth(int w)
	{
		width = w;
	}
	
	/**
	 * Translate the car by 1 unit in the x direction
	 */
	public void move()
	{
		this.x ++;
	}

	/**
	 * Draws car image with all of the corresponding parts
	 * @param g2 - the graphics object used to draw
	 * @param x - the coordinate for the car's location on the x axis
	 * @param y - the coordinate for the car's location on the y axis
	 * precondition: all of the parameters are valid
	 */
	public void draw(Graphics2D g2, int x, int y)
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
		       
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}

	@Override
	public void paintIcon(Component c, Graphics g, int xp, int yp) {
		Graphics2D g2 = (Graphics2D) g;
		draw(g2, xp, yp);
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return width / 3;
	}     
}
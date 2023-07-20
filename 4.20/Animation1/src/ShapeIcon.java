import java.awt.*;
import javax.swing.*;

/**
 * Assignment Solution for the ShapeIcon class
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
 * An icon that contains a MoveableShape
 */

public class ShapeIcon implements Icon
{
	private MoveableShape shape;
	private int width; 
	private int height;
	
	/**
	 * Constructs a ShapeIcon using a MoveableShape
	 * @param shape - the MoveableShap the icon will hold
	 * @param width - the width of the icon
	 * @param height - the height of the icon
	 * precondition: All parameters are valid
	 */
	public ShapeIcon(MoveableShape shape, int width, int height)
	{
		this.shape = shape;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Returns the width of the ShapeIcon
	 */
	public int getIconWidth()
	{
		return width;
	}
	
	/**
	 * Returns the height of the ShapeIcon
	 */
	public int getIconHeight()
	{
		return height;
	}
	
	/**
	 * Paints the Icon using the draw method for the specific MoveableShape
	 * @param c - The component used 
	 * @param g - Graphics object that is used to draw 
	 * @param xp - the X coordinate 
	 * @param yp - the Y coordinate
	 * precondition: All parameters are valid
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}
}

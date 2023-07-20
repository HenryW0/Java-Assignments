import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
* Assignment Solution for ClockIcon to complete ClockTester GUI
* @author Henry Wahhab
* @version 1.0 4/1/23
*/

/**
A Clock that displays the current hour, minute, and second in analog format. 
*/

public class ClockIcon implements Icon
{
	private int diameter;
	
	/**
	 * Constructs a Clock object with a diameter
	 * @param d - the diameter of the analog clock that will be drawn
	 * precondition: d is a positive integer 
	 */
	public ClockIcon(int d)
	{
		diameter = d;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
		g2.draw(circle);

		int r = diameter / 2;
		
		GregorianCalendar cal = new GregorianCalendar();
		
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		double hourAngle = Math.toRadians(360.0 / 12); 
		
		Line2D.Double hourHand= new Line2D.Double(circle.getCenterX(), circle.getCenterY(), 
		circle.getCenterX() + ((2.0/3) * r * Math.cos(hourAngle * (get12HourTime(cal) - 3))), 
		circle.getCenterY() + ((2.0/3) * r * Math.sin(hourAngle * (get12HourTime(cal) - 3)))); //Remember that down is positive for y-direction
		
		g2.setStroke(new BasicStroke(3));
		g2.draw(hourHand);
		g2.setStroke(new BasicStroke(1));
		
		double minAngle = Math.toRadians(360.0 / 60);
		
		Line2D.Double minHand= new Line2D.Double(circle.getCenterX(), circle.getCenterY(), 
		circle.getCenterX() + (0.9 * r * Math.cos(minAngle * (min - 15))), 
		circle.getCenterY() + (0.9 * r * Math.sin(minAngle * (min - 15))));
		
		g2.draw(minHand);
		
		g2.setColor(Color.RED);
		
		Line2D.Double secHand= new Line2D.Double(circle.getCenterX(), circle.getCenterY(), 
		circle.getCenterX() + (0.8 * r * Math.cos(minAngle * (sec - 15))), 
		circle.getCenterY() + (0.8 * r * Math.sin(minAngle * (sec - 15))));
	
		g2.draw(secHand);
	}


	/**
	 * Helper method for calculating the time in 12-Hour format
	 * @param c - a Calendar Object
	 * @return the time in 12-Hour format
	 */
	private int get12HourTime(Calendar c)
	{
		int h = c.get(Calendar.HOUR_OF_DAY);
		if (h > 12) {return h - 12;}
		else {return h;}
	}
	
	@Override
	public int getIconWidth() 
	{
		return diameter;
	}
	
	@Override
	public int getIconHeight() 
	{
		return diameter;
	}

}

import java.awt.*;
import javax.swing.*;


/**
 * Assignment Solution for the AnimationTester2 class
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
 * Draws a MoveableShape (a car in this case) that travels to the right until out of the frame and comes back from the left side of the window
 */

public class AnimationTester2
{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 300;
	
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;

	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Car Wrap Around");

		MoveableShape shape = new CarShape(0, 50, CAR_WIDTH);
		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		
		JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		final int DELAY = 100;
		Timer t = new Timer(DELAY, event -> 
		{	
			shape.move(); 
			
			if(shape.getX() > ICON_WIDTH)
			{
				shape.setX(0);
			}
			
			label.repaint();
		});
		
		t.start();
	}
	
}

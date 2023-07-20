import java.awt.*;
import javax.swing.*;

/**
 * Assignment Solution for the AnimationTester1 class
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
 * Draws multiple MoveableShapes (cars) that move to the right as an animated GUI 
 */

public class AnimationTester1 
{
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 700;
	
	private static final int ICON_WIDTH = FRAME_WIDTH;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	private static final int GAP = 5;
	private static Color[] colors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.BLACK, Color.PINK, Color.ORANGE};
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setTitle("Car Race");
		
		
		MoveableShape[] shapes = new MoveableShape[colors.length];
		JLabel[] labels = new JLabel[colors.length];
		ShapeIcon currShapeIcon;
		
		for(int i = 0; i < colors.length; i ++)
		{	
			shapes[i] = new CarShape(GAP, GAP, CAR_WIDTH, colors[i]);
			currShapeIcon = new ShapeIcon(shapes[i], ICON_WIDTH, ICON_HEIGHT);
			labels[i] = new JLabel(currShapeIcon);
			frame.add(labels[i]);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
		
		final int DELAY = 100;
		Timer t = new Timer(DELAY, event -> 
		{
			for (int j = 0; j < colors.length; j ++)
			{
				shapes[j].move();
				labels[j].repaint();
			}
		});
		
		t.start();
	}
	
}

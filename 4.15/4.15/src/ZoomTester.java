import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
* Assignment Solution for ZoomTester
* @author Henry Wahhab
* @version 1.0 4/1/23
*/

/**
Tests the Zoom In and Zoom Out buttons using a JLabel that contains the CarShape as an Icon
*/

public class ZoomTester {

	private static JLabel label;
	
	public static void main(String[] args)
	{	
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 300;
		int carWidth = FRAME_WIDTH / 2;
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		CarShape car = new CarShape(0, 0, carWidth);
		
		JButton zoomIn = new JButton("Zoom In");
		JButton zoomOut = new JButton("Zoom Out");
		
		label = new JLabel(car);
		frame.setLayout(new BorderLayout());
		frame.add(label, BorderLayout.CENTER);
		frame.setTitle("Zoom GUI");
		
		frame.add(zoomIn, BorderLayout.PAGE_START);
		frame.add(zoomOut, BorderLayout.PAGE_END);
		
		zoomIn.addActionListener(createZoomButtonListener(car, 50));
		zoomOut.addActionListener(createZoomButtonListener(car, -50));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
		
	}
	
	public static ActionListener createZoomButtonListener(CarShape c, int zoom)
	{
		return (event) -> {c.setWidth(c.getIconWidth() + zoom); label.repaint();};
	}
	
}

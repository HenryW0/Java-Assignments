import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;

/**
* Assignment Solution for SlideTester 5.4
* @author Henry Wahhab
* @version 1.0 4/1/23
*/

/**
Tests Zooming In and Out using a Slider with the CarShape as an Icon
*/

public class SlideTester {

	private static JLabel label;
	
	public static void main(String[] args)
	{	
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 300;
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		CarShape car = new CarShape(0, 0, FRAME_WIDTH / 2);
		
		JSlider slide = new JSlider();
		slide.addChangeListener(createSlideListener(car));
		slide.setMajorTickSpacing(10);
		slide.setMinorTickSpacing(1);
		slide.setPaintTicks(true);
		
		label = new JLabel(car);
		frame.setLayout(new BorderLayout());
		frame.add(label, BorderLayout.CENTER);
		frame.add(slide, BorderLayout.NORTH);
		frame.setTitle("Zoom Slider GUI");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}
	
	public static ChangeListener createSlideListener(CarShape c)
	{
		return (event) -> {c.stateChanged(event); label.repaint();};
	}
	
}

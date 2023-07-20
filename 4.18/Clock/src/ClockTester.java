import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
* Assignment Solution for ClockTester
* @author Henry Wahhab
* @version 1.0 4/1/23
*/

/**
A GUI program that tests the paintIcon method for a ClockIcon that updates in real-time
*/

public class ClockTester 
{	
	public static void main(String[] args)
	{	
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 500;
		
		JFrame frame = new JFrame();
		Icon icon = new ClockIcon((int) (0.8 * FRAME_WIDTH));
		JLabel clock = new JLabel(icon);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		frame.setLayout(new BorderLayout());
		frame.add(clock, BorderLayout.CENTER);
		frame.setTitle("Analog Clock");
		
		int DELAY = 99; //Updating after every 100ms to reduce clock being delayed
		Timer t = new Timer(DELAY, createTimerListener(clock));
		t.start();		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	public static ActionListener createTimerListener(final JLabel label)
	{
		return event -> {label.repaint();};
	}
}

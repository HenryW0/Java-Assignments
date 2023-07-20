import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Assignment Solution for MVCTester 
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
  The MVC Tester containing both the View and Controller portions
*/

public class MVCTester 
{
	
	public static void main(String[] args)
	{
		
		//The view portion of the MVC pattern is the textArea since it is purely for displaying purposes
		//The controller portion of the MVC pattern is the textField and the button since it handles all user inputs
		
		ArrayList<String> data = new ArrayList<String>();
	    
	    final Model model = new Model(data);
	    final JTextArea textArea = new JTextArea(20, 40);
	    final JTextField textField = new JTextField();
	    
	    ChangeListener listener = new
	    	ChangeListener()
		    {
			    public void stateChanged(ChangeEvent event)
			    {
			    	textArea.setText(""); //Clear text
			    	for (int i = 0; i < model.getData().size(); i ++)
			    	{
			    		textArea.append(model.getData().get(i) + "\n");
			    	}
			    }
		    };
		
		model.attach(listener);

	    
	    JFrame frame = new JFrame();
	    frame.setLayout(new BorderLayout());
	    JButton addButton = new JButton("add");
	    
	    
	    addButton.addActionListener(new
	    	ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent event)
	    		{
	    			model.update(textField.getText());
	    		}
	    	});
	    
	    frame.add(addButton, BorderLayout.NORTH);
	    frame.add(textArea, BorderLayout.CENTER);
	    frame.add(textField, BorderLayout.SOUTH);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	    
	}	
}

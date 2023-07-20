import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Assignment Solution for Model part of MVC
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
  A Model class for the MVC pattern containing String data
*/

public class Model 
{
	private ArrayList<String> data;
	private ChangeListener listen;
	
	/**
	 * Creates a Model object containing String data
	 * @param s - an ArrayList of strings
	 */
	public Model(ArrayList<String> s)
	{
		data = s;
	}
	
	/**
    Constructs a Model object
    @return the strings in an ArrayList
	*/
	public ArrayList<String> getData()
	{
		return data;
	    //return (ArrayList<String>) (data.clone());
	}
	
	/**
    Attach a listener to the Model
    @param c the listener
	*/
	public void attach(ChangeListener c)
	{
		listen = c;
	}
	
	/**
    Add data in the model 
    @param location the index of the field to change
    @param value the new value
 */
	public void update(String s)
	{
	    data.add(s);
	    listen.stateChanged(new ChangeEvent(this));
	}
	
}

import java.util.ArrayList;

/**
 * Code from https://horstmann.com/oodp2/solutions/solutions.html
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
   A class for testing an implementation of the Observer pattern.
*/
public class ObserverTester
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(Double.valueOf(33.0));
      data.add(Double.valueOf(44.0));
      data.add(Double.valueOf(22.0));
      data.add(Double.valueOf(22.0));

      DataModel model = new DataModel(data);

      TextFrame textFrame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);

      model.attach(barFrame);
      model.attach(textFrame);

   }
}
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * Code from https://horstmann.com/oodp2/solutions/solutions.html
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
  A class that implements an Observer object that displays a barchart view of
  a data model.
*/

public class BarFrame extends JFrame implements ChangeListener
{
   /**
      Constructs a BarFrame object
      @param dataModel the data that is displayed in the barchart
   */
   public BarFrame(DataModel dataModel)
   {
      this.dataModel = dataModel;
      a = dataModel.getData();

      setLocation(0,200);
      setLayout(new BorderLayout());

      MouseListener mouse = new MouseListener()
      {

		@Override
		public void mouseClicked(MouseEvent e) {
			//do nothing
		}

		/**
		 * When the mouse is pressed on the frame, 
		 * @param e - The MouseEvent that occurred
		 */
		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			Insets insets = getInsets();
			
			double yLoc = p.getY() - insets.top; //Top Inset is 30 so this must be subtracted
			double xLoc = p.getX() - insets.left; //Left Inset is 7 so this must also be subtracted
			
			
			//System.out.println(xLoc);
			//System.out.println(yLoc);
			
			double min = yLoc;
			double interval = (ICON_HEIGHT / a.size());
			int index = 0;
			
			for (int i = 1; i < a.size(); i ++)
			{
				
				double diff = yLoc - (i * interval);
				
				if (diff >= 0 && diff < min)
				{
					min = yLoc - (i * interval);
					index = i;
				}
			}
			
			double max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }
			
			dataModel.update(index, (xLoc / ICON_WIDTH) * max);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//do nothing
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//do nothing
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//do nothing
		} 
      };
      
      Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }
         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.red);

            double max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }

            double barHeight = getIconHeight() / a.size();

            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();

               double barLength = getIconWidth() * value / max;

               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
      };

      addMouseListener(mouse);
      add(new JLabel(barIcon));
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   /**
      Called when the data in the model is changed.
      @param e the event representing the change
   */
   public void stateChanged(ChangeEvent e)
   {
      a = dataModel.getData();
      repaint();
   }

   private ArrayList<Double> a;
   private DataModel dataModel;

   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 200;
}
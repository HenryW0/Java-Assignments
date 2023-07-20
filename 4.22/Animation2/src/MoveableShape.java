import java.awt.*;

/**
 * Assignment Solution for the MoveableShape interface for AnimationTester2
 * @author Henry Wahhab
 * @version 1.0 4/1/23
 */

/**
 * Interface for MoveableShape that contains a draw, move, setX, and getX method
 */

public interface MoveableShape 
{
	void draw(Graphics2D g2);
	void move();
	void setX(int p);
	int getX();
}

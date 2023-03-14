import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleApplet extends Applet
{	public void pain(Graphics g)
	{	//recover Graphics2D
		
		Graphics2D g2 = (Graphics2D)g;
		
		//construct a rectangle and draw it
		
		Rectangle cerealBox = new Rectangle(5, 10, 20, 30);
		g2.draw(cerealBox);
		
		// move rectangle 15 units sideways and 25 units down
		
		cerealBox.translate(15, 25);
		
		// draw moved rectangle
		
		g2.draw(cerealBox);
	}
}


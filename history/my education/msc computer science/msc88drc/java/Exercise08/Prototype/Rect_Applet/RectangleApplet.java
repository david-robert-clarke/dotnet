import java.applet.Applet;
import java.awt.*;

public class RectangleApplet extends Applet
{
    public void paint(Graphics g)
    {// recover Graphics2D
        Graphics2D g2 = (Graphics2D)g;

        // construct a rectangle and draw it
        Rectangle rect = new Rectangle(200, 200, 100, 50);
        g2.draw(rect);
    }
}


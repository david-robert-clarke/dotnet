import java.applet.Applet;
import java.awt.*;

public class RectangleApplet extends Applet
{
    public void paint(Graphics g)
    {// recover Graphics2D
        Graphics2D g1 = (Graphics2D)g;
        Graphics2D g2 = (Graphics2D)g;
        

        // construct a rectangle and draw it
        Rectangle rect = new Rectangle(200, 200, 100, 50);
        g2.setColor(Color.red);
        g2.fill(rect);

        // create text at the top of the screen
        final int theSize = 20;
        String message = "Bouncing Ball";
        Font theFont = new Font("Serif", Font.BOLD, theSize);
        g2.setColor(Color.black);
        g2.setFont(theFont);
        g2.drawString(message, 200, 20);
                
    }
}


import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Car extends Applet
{
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        // 1 ball and 2 paddles
        Ellipse2D.Double ball = new Ellipse2D.Double(240, 240, 10, 10);
        Rectangle leftPaddle = new Rectangle(10, 200, 10, 50);
        Rectangle rightPaddle = new Rectangle(480, 200, 10, 50);

        // set the color to be used to red, draw and fill ball
        g2.setColor(Color.red);
        g2.fill(ball);
        
        // set the color to be used to red, draw and fill paddle
        g2.setColor(Color.blue);
        g2.fill(leftPaddle);

        // set the color to be used to red, draw and fill ball
        g2.setColor(Color.blue);
        g2.fill(rightPaddle);

        // create title text at the top of the screen
        final int theSize = 20;
        String message = "Bouncing Ball";
        Font theFont = new Font("Dialog", Font.BOLD, theSize);
        g2.setColor(Color.black);
        g2.setFont(theFont);
        g2.drawString(message, 200, 20);
    }
}

        


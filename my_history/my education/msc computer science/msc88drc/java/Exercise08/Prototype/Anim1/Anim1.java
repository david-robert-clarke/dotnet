import java.applet.*;
import java.awt.*;
import java.net.*;

public class Anim1 extends Applet implements Runnable
{
    int x_pos = 0;
    int y_pos = 0;
    int radius = 5;
    int x_velocity = 10;
    int y_velocity = 20;
    

    public void init()
    {
        setBackground (Color.white);
    }

    public void start()
    {
        Thread fred = new Thread(this);
        fred.start();
    }

    public void stop()
    {
    }

    public void destroy()
    {
    }

    public void run()
    {
        while(true)
            {
	x_pos += x_velocity;
	y_pos += y_velocity;

	if (x_pos > 500 || x_pos < 0)
	    {
	        x_velocity *= -1;
	    }
	
	if (y_pos > 500 || y_pos < 0)
	    {
	        y_velocity *= -1;
	    }

	repaint();
	try
	    {
	        Thread.sleep(50);
	    }
	catch(InterruptedException ex)
	    {
	        // do nothing
	    }
            }
    }

    public void paint(Graphics g)
    {

        g.setColor(Color.black);
        g.fillOval(x_pos-radius, y_pos-radius, 2*radius,
	   2*radius);
    }
    
}

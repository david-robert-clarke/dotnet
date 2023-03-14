import java.applet.*;
import java.awt.*;
import java.net.*;

public class Anim1 extends Applet implements Runnable
{
    int x_pos = 0;
    int y_pos = 0;
    public static int width;
    public static int height;

    public void init()
    {
        width = getBounds.width;
        height = getBounds().height;
        setBackground (Color.white);
        Ball b = new Ball(5,5);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        while(true)
            {
	// mointors the balls progress
	b.progress();

	// repaint the scene
	repaint();
	
	// sleep for x amount of milliseconds
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
        b.paint(g)
    }
    
}

import java.applet.*;
import java.awt.*;
import java.net.*;

public class BouncingBall extends Applet implements Runnable
{
    // global variables
    int x_pos = 0;
    int y_pos = 0;
    Ball sphere;
    Image buffer;     //double buffering
    Graphics bufferg; //double buffering
    
    // Parameters width and height represent the height and width of the applet
    // They are declared public static so that they can be made accessible to 
    // the Ball program
    public static int width;
    public static int height;

    // all objects, variables, constants placed here are initialised when the
    // applet is loaded up
    public void init()
    {
        // Get parameters from the HTML file
        width = getBounds().width;
        height = getBounds().height;
        setBackground (Color.black);
        sphere = new Ball(1,2);
        Thread thread = new Thread(this);
        thread.start();
        buffer = createImage(width,height); //double buffering
        bufferg = buffer.getGraphics();     //double buffering
    }

    public void run()
    {
        while(true)
            {
	// mointors the balls progress
	sphere.nextStep();

	// sleep for 10 milliseconds
	try
	    {
	        Thread.sleep(5);
	    }
	catch(InterruptedException ex)
	    {
	        // do nothing
	    }
	
	// repaint the ball
	repaint();
            }
    }

    public void paint(Graphics g)
    {
        sphere.paint(g);
        doubleBuffering(g);
    }

    public void doubleBuffering(Graphics g)
    {
        //clear the room
        bufferg.setColor(getBackground());//getBackground());
        bufferg.fillRect(0,0,getBounds().width,getBounds().height);
        //paint picture of 
        bufferg.setColor(Color.white);
        bufferg.fillOval(sphere.getX(),sphere.getY(),10,10);
        g.drawImage(buffer,0,0,this);
    }

    public boolean keyDown (Event e, int key) 
    { 
        // if user presses space bar (value = 32!) when ball is moving
        if (key == 32 && sphere.getXStep() != 0 
            && sphere.getYStep() != 0)
            { 
	// Copy current X and Y step size into the corresponding
	// paused parameters
	sphere.setPauseXStep(sphere.getXStep());
	sphere.setPauseYStep(sphere.getYStep());
	
	// Stop ball (x_speed = 0)
	sphere.setXStep(0); sphere.setYStep(0);
            }
        else
            // the ball is stationary and we want to direct the ball in the 
            // direction it was set to before it was paused
            {
	sphere.setXStep(sphere.getPauseXStep());
	sphere.setYStep(sphere.getPauseYStep());
            }	
        // DON'T FORGET (although it has no meaning here) 
        return true;
    }
}

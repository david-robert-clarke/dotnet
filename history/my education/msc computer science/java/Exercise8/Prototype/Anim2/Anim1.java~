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
    AudioClip bounce;
    AudioClip gth;
    Image backImage;
    private Image dbImage;
    private Graphics dbg;
    

    public void init()
    {
        // Load an audio file which is in the same directory as the class files of the applet 
bounce = getAudioClip (getCodeBase(), "fart3.au");
    gth = getAudioClip (getCodeBase(), "pixies.au");
    backImage = getImage (getCodeBase(), "K.jpg");

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
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        gth.play();
        
        while(true)
            {
	x_pos += x_velocity;
	y_pos += y_velocity;

	if (x_pos > 500 || x_pos < 0)
	    {
	        x_velocity *= -1;
	        bounce.play();
	    }
	
	if (y_pos > 500 || y_pos < 0)
	    {
	        y_velocity *= -1;
	        bounce.play();
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
	
	Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            }
    }

    public void paint(Graphics g)
    {

        g.drawImage(backImage, 0, 0, this);
        g.setColor(Color.red);
        g.fillOval(x_pos-radius, y_pos-radius, 2*radius,
	   2*radius);
    }

    public void update(Graphics g)
    {
        if (dbImage == null)
            {
	dbImage = createImage(this.getSize().width, 
		      this.getSize().height);
	dbg = dbImage.getGraphics();
            }
        
        // clear screen in background
        dbg.setColor (getBackground());
        dbg.fillRect (0, 0, this.getSize().width,
	      this.getSize().height);

        // draw elements in background
        dbg.setColor(getForeground());
        paint(dbg);
        
        // draw image on the screen
        g.drawImage (dbImage, 0, 0, this);
    }

    public boolean keyDown (Event e, int key) 
    { 
        // user presses left or right cursor keys 
        if (key == Event.LEFT || key == Event.RIGHT)
            { 
	x_velocity *= -1;
	
            }

        else if (key == Event.UP || key == Event.DOWN)
            { 
	y_velocity *= -1;
	
            }
        // user presses space bar (value = 32!)
        else if (key == 32)
            { 
	// Stop ball (x_speed = 0)
	x_velocity = 0;
	y_velocity = 0;
	
            }
        else
            { 
	/* Additionally the method prints out the ASCII - value if an other key is pressed. This is not necessary but a possibility for you to test which value a key has.*/ 
	System.out.println ("Charakter: " + (char)key + " Integer Value: " + key);
	
            }
        
        // DON'T FORGET (although it has no meaning here) 
        return true;
        
    }

    public boolean keyDown (Event e, int key) 
    { 
        if (key == 32)
            {
	x_velocity = 20;
	y_velocity = 20;
            }

        return true;
    }
    
}

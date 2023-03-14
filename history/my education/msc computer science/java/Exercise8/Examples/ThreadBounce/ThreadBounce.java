/* This displays an animation of a bouncing ball.
   There are two Go buttons, and the animation runs when either button is clicked.
   
   The animation is sparked as a separate thread when "Go threaded" is clicked.
   
   The animation is run in the same thread when "Go not threaded" is clicked.
   
   The window also has a speed control scrollbar. 
   
   When the threaded animation is running, the speed can be altered as the 
   animation is running. Multiple bouncing balls can also be created, 
   run by separate threads, when "Go threaded" is clicked.
   
   However, if the non-threaded animation is running, no further animation can 
   be started, nor the speed altered, until the animation (ie 
   the complete bounce) has finished - as the event loop is blocked.
   
   This illustrates the difference between threading and not threading event 
   handlers.
   
   SBJ Mar 1999
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class ThreadBounce extends Applet
                          implements ActionListener, AdjustmentListener, Runnable
{   
    
    private int tick = 100;          // A pause length: speed control!
    private final int lowestY = 250;
    private final int x = 100;
    private final int initialY = 70;
    
    private Button goThreaded = new Button("Go threaded");
    private Button goNotThreaded = new Button("Go not threaded");
    private Scrollbar speed = new Scrollbar(Scrollbar.HORIZONTAL,tick,1,20,500);
    
    public void init() {
        add(goNotThreaded);
        goNotThreaded.addActionListener(this);
        add(goThreaded);
        Panel speedControl = new Panel();
        speedControl.add(new Label("Speed:  Faster",Label.RIGHT));
        goThreaded.addActionListener(this);
        speedControl.add(speed);
        speed.addAdjustmentListener(this);
        speedControl.add(new Label("Slower"));
        add(speedControl);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goThreaded) new Thread(this).start();
        if (e.getSource() == goNotThreaded) doAnimation();
    }
    
    public void adjustmentValueChanged(AdjustmentEvent e) {
        tick = speed.getValue();
    }
    
    public void run() {
        doAnimation();
    }
    
    public void doAnimation() {
    
        Graphics g = getGraphics();
        int y = initialY, step = 1;
        Color background = getBackground();
        g.setColor(Color.black);
        
        while (y <= lowestY) {
            g.fillOval(x, y, 20, 20);
            pause(tick);
            g.setColor(background);
            g.fillOval(x, y, 20, 20);
            g.setColor(Color.black);
            y = y+step;
            step++;
        }
    
        g.fillOval(x, lowestY, 20, 20);  // Extra image for lowest point
        
        g.setColor(Color.red);           // Say "Boing!"
        g.drawString("Boing!", x-10, lowestY+30);
        pause(tick*2);  // *2 so the text can be read!
        g.setColor(background);
        g.drawString("Boing!", x-10, lowestY+30);
    
        g.fillOval(x, lowestY, 20, 20);  // Erase the extra image

        g.setColor(Color.black);       
       
        while (step>0) {
            step--;
            y = y-step;
            g.fillOval(x, y, 20, 20);
            pause(tick);
            g.setColor(background);
            g.fillOval(x, y, 20, 20);
            g.setColor(Color.black);
       }
    }
    
    private void pause(int pauseLength) {
        try { Thread.sleep(pauseLength); } catch (InterruptedException e) {}
    }
}

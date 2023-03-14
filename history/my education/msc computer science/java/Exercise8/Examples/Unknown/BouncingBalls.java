import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class BouncingBalls extends Applet {
    public static int width;
    public static int height;
    private Vector balls = new Vector();

    public void init ( ) {
	height = getBounds().height;
	width = getBounds().width;
	addMouseListener(new MouseHandler());
	Ball b = 
	balls.addElement(new Ball(128, 127));
	Thread t = new BallThread();
	t.start( );
    } // init

    private class MouseHandler extends MouseAdapter  {
	public void mousePressed(MouseEvent e) {
	    balls.addElement(new Ball(e.getX(), e.getY()));
	}  // mousePressed
    } // MouseHandler

    private class BallThread extends Thread {
	public void run( ) {
	    while (true) {
		Enumeration e = balls.elements();
		while (e.hasMoreElements()) {
		    Ball b = (Ball)(e.nextElement());
		    b.move();
		}
		repaint( );
		try { Thread.sleep(50);
		} catch (InterruptedException exc) { }
	    }
	}
    }

    public void paint(Graphics g) {
	Enumeration e = balls.elements();
	while (e.hasMoreElements()) {
	    Ball b = (Ball)(e.nextElement());
	    b.paint(g);
	}
    }
} // BouncingBalls

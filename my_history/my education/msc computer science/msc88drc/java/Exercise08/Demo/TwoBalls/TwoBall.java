/* Program 19.9: Bounce2

This example has been improved over what was in the book.  It uses
t.suspend() and t.resume() instead of t.start() and t.stop().  It has also  added start() and stop() methods to the applet (which are different
from the thread's start and stop methods). The applet's start and 
stop methods suspend() and resume() the thread when the user has 
moved off the page so CPU cycles aren't wasted drawing pictures the
user never sees.
*/

import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Event;
import java.awt.Dimension;

public class TwoBall extends Applet implements Runnable {

  Ball b1, b2;
  boolean bouncing;
  Thread t;
  
  public void init () {
  
    b1 = new Ball(10, 32, size(), Color.red, 1.3, 2.4);
    b1.start();
    b2 = new Ball(155, 75, size(), Color.yellow, 0.8, 1.2);
    b2.start();
    bouncing = true;
    t = new Thread(this);
    t.start();
     
  }
  
  public void start() {

    if (!bouncing) {
      t.resume();
      b1.resume();
      b2.resume();
      bouncing = true;
    }  
  
  }
  
  public void stop() {

    if (bouncing) {
      t.suspend();
      b1.suspend();
      b2.suspend();
      bouncing = false;
    }  
  
  }  
  
  public void paint (Graphics g) {
    g.setColor(b1.getColor());
    g.fillOval(b1.getX(), b1.getY(), b1.getWidth(), b1.getHeight());
    g.setColor(b2.getColor());
    g.fillOval(b2.getX(), b2.getY(), b2.getWidth(), b2.getHeight());
  }
  
  public boolean mouseUp(Event e, int x, int y) {
    if (bouncing) {
      b1.suspend();
      b2.suspend();
      t.suspend();
      bouncing = false;
    }
    else {
      b1.resume();
      b2.resume();
      t.resume();
      bouncing = true;
    }
    return true;
  }

  public void run() {

    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

    while (true) {  // infinite loop
      repaint();
      try {
        Thread.currentThread().sleep(10);
      }
      catch (Exception e) {
      
      }
    }
    
  }

}

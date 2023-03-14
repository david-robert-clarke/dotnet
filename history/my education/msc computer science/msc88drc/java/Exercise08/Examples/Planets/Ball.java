import java.awt.*;
import java.applet.*;

class Ball {
  private double x, y;               // x and y coordinates
  private double xv, yv;             // velocity in x and y directions
  private int r;                     // radius of ball
  private Image image;               // .gif image file to display ball
  private AudioClip sound;           // .au sound file for ball
  private Applet applet;             // assoicated applet
  
  Ball(double x, double y, double xv, double yv, int r,
       Image image, AudioClip sound, Applet applet) {
    this.x = x; this.y = y; 
    this.xv = xv; this.yv = yv; 
    this.r = r;
    this.image = image;
    this.sound = sound;
    this.applet = applet;
  }
  
  void show(Graphics g) { 
    // rescale to applet coordinates
    int xpix = (int) ((x + 0.5) * (applet.getSize().width  - 2*r));
    int ypix = (int) ((y + 0.5) * (applet.getSize().height - 2*r));
    g.drawImage(image, xpix, ypix, null);
  }
  
  void move() {
  /*************************************************
   * YOUR CODE TO MAKE BALL BOUNCE OFF WINDOW      *
   *************************************************/
    x += xv;
    y += yv;
  }

}

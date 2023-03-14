import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ball extends Applet implements Runnable {
  int x,y,dx,dy,diam,sizex,sizey; 
  
  public void init() {
    setBackground(Color.black);
   
    x=y=0; dx=dy=5; diam=20;

    // Getting Parameters form the HTML
    sizex=Integer.parseInt(getParameter("WIDTH"));
    sizey=Integer.parseInt(getParameter("HEIGHT"));

    (new Thread(Ball.this)).start();
  }

  public void run() {
    while (true) {
      try {
        Thread.currentThread().sleep(40);
      }
      catch (InterruptedException e) {};

      x+=dx; y+=dy;
      if ((x<=0)||(x+dx+diam>=sizex)) dx=-dx;
      if ((y<=0)||(y+dy+diam>=sizey)) dy=-dy;

      repaint();
    }
  }

  public void paint(Graphics g) {
    g.setColor(Color.white);
    g.fillArc(x,y,diam,diam,0,360);

    // Converting double to string
    g.drawString(String.valueOf(x),20,20);
    g.drawString(String.valueOf(y),20,40);
    g.drawString(""+dx,80,20);
    g.drawString(""+dy,80,40);
  }
}
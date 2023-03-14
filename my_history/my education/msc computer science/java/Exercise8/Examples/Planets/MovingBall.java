import java.applet.*;
import java.awt.*;

public class MovingBall extends Applet {
  final static Color back = Color.black;    // applet background color
  Ball b1, b2, b3;
    
  // parameters set in MovingBall.html
  private int pause;                       // delay between update and display 
  private Image image1, image2, image3;
  private AudioClip sound1, sound2, sound3;

  // used for buffered graphics operations
  Image oSI = null; 
  Graphics g1; 
    
  public void init() {
    // set default parameters from MovingBall.html
    pause = Integer.parseInt(getParameter("pause"));
	
    // prepare for buffered graphics
    oSI = createImage(getSize().width, getSize().height);
    g1 = oSI.getGraphics();
	
    sound1 = getAudioClip(getDocumentBase(), "splat.au");
    sound2 = getAudioClip(getDocumentBase(), "clink.au");
    sound3 = getAudioClip(getDocumentBase(), "gong.au");
    
    image1 = getImage(getDocumentBase(), "sun.gif");
    image2 = getImage(getDocumentBase(), "earth.gif");
    image3 = getImage(getDocumentBase(), "mars.gif");
    
    b1 = new Ball(-0.3, 0.4, 0.001, -0.0005, 10, image1, sound1, this);
    b2 = new Ball(-0.3, 0.4, 0.01, 0.005, 50, image2, sound2, this);
    b3 = new Ball(-0.3, 0.4, -0.01, 0.005, 100, image3, sound3, this);
  }

    
  // override update() to update positions of all bodies, then draw 
  public void update(Graphics g2) {
    g1.setColor(back);
    g1.fillRect(0, 0, getSize().width, getSize().height);

    // update Ball positions
    b1.move();
    b1.show(g1);

    b2.move();
    b2.show(g1);

    b3.move();
    b3.show(g1);

    // draw to screen
    paint(g2);
  }

    
  // override paint() to copy oSI to screen
  public void paint(Graphics g3) {

    // repaint() schedules an update() in the near future
    repaint();

    // wait for pause milliseconds	
    try { Thread.sleep(pause); }
    catch (InterruptedException ex) { showStatus(ex.toString()); }

    g3.drawImage(oSI, 0, 0, this);
  }
}

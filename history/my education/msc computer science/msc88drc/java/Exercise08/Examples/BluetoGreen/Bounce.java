/* 
 *  Bounce.java   -  Draws a bouncing ball.  
 *  The ball is drawn on a canvas from the class Drawarea.  This class also has a Thread,
 *  where the run method continually calls repaint to draw the ball in a different position.
 *  The main applet implements a set of control buttons at the bottom of the canvas.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Bounce extends Applet implements ActionListener
{
  Drawarea drawing = new Drawarea ( );
  Panel controls = new Panel ( ); 
  Panel first = new Panel ( );
  Panel second = new Panel ( );
  Panel third = new Panel ( );
  
  Button bluebutton, greenbutton, purplebutton, magentabutton ;
  Label  label3;
  Button pause, resume;
  Color purple = new Color ( 127, 0, 255 );
  Color ltblue = new Color ( 153, 204, 255 );
  
  public void init ( ) 
  {  
   //   first panel is left empty
 
    // create second panel with color buttons
    label3 = new Label ( "Select a color: " );
    second.add ( label3 );   
    bluebutton = new Button ( "blue" ) ;
    bluebutton.addActionListener ( this );
    second.add ( bluebutton );
    greenbutton = new Button ( "green" ) ;
    greenbutton.addActionListener ( this );
    second.add ( greenbutton );
    magentabutton = new Button ( "magenta" ) ;
    magentabutton.addActionListener ( this );
    second.add ( magentabutton );
    purplebutton = new Button ( "purple" ) ;
    purplebutton.addActionListener ( this );
    second.add ( purplebutton );
   
    // create third panel with pause and resume buttons
    pause= new Button ( "Pause" );
    pause.addActionListener ( this );
    third.add ( pause );
    resume = new Button ( "Resume" );
    resume.addActionListener ( this );
    third.add ( resume );

    //  create the control panel
    controls.setLayout ( new GridLayout ( 3, 1 ));
    controls.add ( first );
    controls.add ( second );
    controls.add ( third );
    controls.setBackground ( ltblue );
 
    // set the layout and contents of the whole applet   
    setLayout ( new BorderLayout ( ) );
    add ( drawing, BorderLayout.CENTER );
    add ( controls, BorderLayout.SOUTH );
      }
 
    // the applet start method 
    public void start() 
    {  drawing.start ( );
     }
  
    // the applet stop method 
    public void stop( ) 
    {  drawing.stop ( );
     }
  
    public void paint ( Graphics g ) 
    {  drawing.paint ( g );
     }
  
    public void actionPerformed ( ActionEvent event )
    {
       // respond to color buttons by setting the mycolor variable
       if ( event.getSource ( ) == bluebutton )
            {  drawing.mycolor = Color.blue;  }
       if ( event.getSource ( ) == greenbutton )
            {  drawing.mycolor = Color.green;  }
       if ( event.getSource ( ) == magentabutton )
            {  drawing.mycolor = Color.magenta;   }
       if ( event.getSource ( ) == purplebutton )
             {  drawing.mycolor = purple;  }

      // respond to pause button by calling the thread suspend method
      if ( event.getSource ( ) == pause )
         {  drawing.thread.suspend ( ) ;  }
         
      // respond to resume button by calling the thread resume method
      if ( event.getSource ( ) == resume )
      {  drawing.thread.resume ( ) ; }
   }   
}

class Drawarea extends Canvas implements Runnable
{
   // variables that are properties of the bouncing ball
   Color mycolor;
   int x, y, w, h;      // initial position x,y and size w,h
   int dx;                 // amount to move in the x direction each time
   int dy;                 // and amount to move in the y direction each time
  
  Thread thread;         
  Image buffer;            // variables for double buffering
  Graphics gbuffer;
  
  public Drawarea ( )
  {
     // initialization (except for values that depend on the size of the canvas)
     setBackground ( Color.black );
     mycolor = Color.cyan;
      x = 50;  y = 50;
      w = 10;  h = 10;
      dx = 2; dy = 3;
    }
 
  
   public void start() 
   {   // create a thread and start it running
       if ( thread == null ) 
           { thread = new Thread( this );
              thread.start();
            }
    }
  
   public void stop() 
   {  // stop the thread from running and destroy it
       if ( thread != null ) 
          { thread.stop();
             thread = null;
           }
    }
   
  // this run method is what the thread executes
   public void run() 
   { // continuous loop
      while ( thread != null ) 
      {
         repaint();
         try 
             // wait for 20 milliseconds before continuing to repaint
             { Thread.sleep(20);
              } catch ( InterruptedException e ) {   };    
       }
    }
  
  // give an update that does not blank out background (which would cause flicker)
   public void update (Graphics g)
   { paint (g);
   }
    
  public void paint ( Graphics g ) 
  {  // the first time, do initialization that depends on the size of the canvas
     if ( buffer == null )
     {      
        // Create an off-screen image for double buffering:
        buffer = createImage( getSize( ).width, getSize( ).height );
        // Get off-screen graphics context:
        gbuffer = buffer.getGraphics(); 
     }
     //  all drawing should take place on gbuffer
     // draw background to cover up previous image
     gbuffer.setColor ( getBackground ( ) );
     gbuffer.fillRect ( 0, 0,  getSize( ).width , getSize( ).height );

     // Calculate where new location will be without bouncing:
     int nx = x + dx, ny = y + dy;
    // Check if new location is out of bounds and change direction:
    if ( (nx < 0) || (nx + w > getSize( ).width) ) dx = -dx;
    if ( (ny < 0) || (ny + h > getSize( ).height) ) dy = -dy;
    
    // move to new location and draw the ball
    x = x + dx;    y = y + dy;
    gbuffer.setColor ( mycolor );
    gbuffer.fillOval ( x, y, w, h );
    
     // Draw the buffer in the canvas drawarea by using graphics g
     g.drawImage( buffer, 0, 0, this );
  }
}
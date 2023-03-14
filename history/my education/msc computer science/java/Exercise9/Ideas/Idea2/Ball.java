import java.applet.*;
import java.awt.*;
import java.lang.Math;
/**
   A class to maintain all of the information for a single Ball Object
   
   @author David Clarke
**/

public class Ball
{    
    private final double d90InRad = 1.57;  
    private double aOP;
    private int x;
    private int y;
    private float xTemp,yTemp;
    private int xStep;
    private int yStep;
    private int diameter;
    private Color color;
    private Graphics graphics; 
    private Applet applet;

    /**
     * Constructor to create a Ball Object using the specified information.
     * 
     * @param x1 the starting position of the ball along the x-axis
     * @param y1 the starting position of the ball along the y-axis
     * @param degrees the starting angle of the ball in degrees
     * @param diam the diameter of the ball
     * @param c the colour of the ball
     * @param a the painting surface
     **/
    public Ball(int x1, int y1, int degrees, int diam, Color c, Applet a)
    {
        x = x1;
        y = y1;
        aOP = Math.toRadians((double)degrees);
        xTemp = (float)(Math.cos(aOP));
        xStep = Math.round(xTemp * 3);
        yTemp =(float)(Math.cos(d90InRad-aOP));
        yStep = Math.round(yTemp * 3);
        diameter = diam;
        color = c;
        applet = a; 
        graphics = applet.getGraphics(); 
    }

    /**
     * Set the step size of the ball in the x direction
     *
     * @param sX the x-step parameter
     **/
    public void setXStep(int sX)
    {
        xStep = sX;
    }
    
    /**
     * Set the step size of the ball in the y direction
     *
     * @param sY the y-step parameter
     **/
    public void setYStep(int sY)
    {
        yStep = sY;
    }

    /**
     * Get the x-coordinate of the ball
     *
     * @return the balls x-coordinate
     **/
    public int getX()
    {
        return x;
    }

    /**
     * Get the y-coordinate of the ball
     *
     * @return the balls y-coordinate
     **/
    public int getY()
    {
        return y;
    }

    /**
     * Get the step size of the ball in the x direction
     *
     * @return the x-step parameter
     **/
    public int getXStep()
    {
        return xStep;
    }

    /**
     * Get the step size of the ball in the y direction
     *
     * @return the y-step parameter
     **/
    public int getYStep()
    {
        return yStep;
    }
    
    /**
     * Get the diameter of the ball
     *
     * @return the balls diameter
     **/
    public int getDiameter()
    {
        return diameter;
    }

    /**
     * Deletes the current ball drawing. Calculates the Ball objects next 
     * position. Draws the next ball. 
     **/
    public void nextStep()
    {
        // paint over the current ball before calculating its' next move
        graphics.setColor(Color.orange);
        graphics.fillOval(x, y, diameter, diameter);

        // ball has a negative xStep size
        if (x < 0) 
          {
              xStep*= -1;
          }
        // ball has a positive xStep size
        else if  ( (x+(diameter)) >= BouncingBall.roomWidth)
            {
	xStep*= -1;	
            }
        //the ball has a negative yStep size
        if (y < 0)
          {
              yStep*= -1;
          }
        //the ball has a positive yStep size
        else if ( (y+(diameter)) >= BouncingBall.roomHeight)
            {
               yStep*= -1;
            }
            
        x += xStep;
        y += yStep;

        draw();
    }
    
    /**
     * Creates a graphical representation of a ball
     **/
    public void draw()
    {
        graphics.setColor(color);
        graphics.fillOval(x, y, diameter, diameter);
    }

    /**
     * Get a string representation of this ball
     *
     * @return a multi-line string containing all of the balls details.
     */
    public String toString()
    {
        String this1 = "x: " + x + "\t" +  "y: " + y;
        String this2 = "XStep = " + xStep + "\t" + "YStep = " + yStep;
        String this3 = "Diameter: " + diameter +  "\t" + "Color: " + color;
        return (this1 + "\n" + this2 + "\n" + this3);
    }
}

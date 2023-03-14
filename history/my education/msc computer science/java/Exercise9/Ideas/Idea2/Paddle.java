import java.applet.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.lang.Math;
/**
   A class to maintain all of the information for a single Paddle Object
   
   @author David Clarke
**/
public class Paddle
{ 
    private int x;
    private int y;
    private int height, width;
    private Color color; 
    private Graphics graphics; 
    private Applet applet;

    /**
     * Constructor to create a Paddle Object using the specified information.
     * 
     * @param x1 the starting position of the paddle along the x-axis
     * @param y1 the starting position of the paddle along the y-axis
     * @param wid the width of the paddle
     * @param hi the height of the paddle
     * @param a the painting surface
     **/
    public Paddle(int x1, int y1, int wid, int hi, Applet a)
    {
        x = x1;
        y = y1;
        height = hi;
        width = wid;
        color = Color.red;
        applet = a; 
        graphics = applet.getGraphics(); 
    }

    /**
     * creates a graphical representation of a paddle
     **/
    public void draw()
    {
        Graphics2D g2 = (Graphics2D)graphics;
        graphics.setColor(color);
        graphics.fill3DRect(x, y, height, width, true);
    }
    
    /**
     * Get a string representation of this paddle
     *
     * @return a multi-line string containing all of the paddle details.
     */
    public String toString()
    {
        String this1 = "x = " + x + "\t" + "y = " + y;
        String this2 = "Height: " + height + "\t" + "Width: " + width;
        String this3 = "Color : " + color;
        return (this1 + "\n" + this2 + "\n" + this3);
    }
}


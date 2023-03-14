import java.awt.*;
import java.lang.Math;

public class Ball
{    
    //instance variables
    private int x;
    private int y;
    private int xStep;
    private int yStep;
    private int pauseXStep, pauseYStep; 
    private Color color;
    private int radius;

    /**
     * Default constructor which sets up a white Ball that has a radius of 5
     **/
    public Ball(int x1, int y1)
    {
        x = x1;
        y = y1;
        xStep = 1;
        yStep = 1;
        pauseXStep = 0;
        pauseYStep = 0;
        color = Color.blue;
        radius = 5;
    }
    
    //**********SET METHODS***********
       
    /**
     * Set the x-position of the Ball
     *
     * @param x the current x-position   
     **/
        public void setX(int x1)
    {
        x = x1;
    }
    
    /**
     * Set the y-position of the Ball
     *
     * @param y the current y-position  
     **/
    public void  setY(int y1)
    {
        y = y1;
    }

    /**
     * Set the x step size parameter
     *
     * @param xStep the step size in the x direction 
     **/
    public void setXStep(int xStep1)
    {
        xStep = xStep1;
    }

    /**
     * Set the y step size parameter
     *
     * @param yStep the step size in the y direction 
     **/
    public void setYStep(int yStep1)
    {
        yStep = yStep1;
    }

    /**
     * Set the paused x-step size parameter
     *
     * @param xStep the step size in the x direction 
     **/
    public void setPauseXStep(int pauseX)
    {
        pauseXStep = pauseX;
    }

    /**
     * Set the paused y-step size parameter
     *
     * @param yStep the step size in the y direction 
     **/
    public void setPauseYStep(int pauseY)
    {
        pauseYStep = pauseY;
    }

    //*******GET METHODS********    

    /**
     * Get the x-position of the Ball
     *
     * @return x the current x-position as an integer.    
     **/
        public int getX()
    {
        return x;
    }
    
    /**
     * Get the y-position of the Ball
     *
     * @return y the current y-position as an integer.    
     **/
    public int getY()
    {
        return y;
    }

    /**
     * Get the x-step size parameter
     *
     * @return xStep the size of the step in the x direction as an integer.  
     **/
    public int getXStep()
    {
        return xStep;
    }
    
    /**
     * Get the y-step size parameter
     *
     * @return yStep the size of the step in the y direction as an integer.  
     **/
    public int getYStep()
    {
        return yStep;
    }

    /**
     * Get the paused x-step size parameter
     *
     * @return  xStep the step size in the x direction as an Integer
     **/
    public int getPauseXStep()
    {
        return pauseXStep;
    }

    /**
     * Get the paused y-step size parameter
     *
     * @return  yStep the step size in the y direction as an Integer
     **/
    public int getPauseYStep()
    {
        return pauseYStep;
    }

    //calculates the the next position of the ball 
    public void nextStep()
    {
        /*
          Each ball can reach a maximum x and y velocity of 10
        */
        //the ball has a negative xStep size
        if (x < 0) 
          {
              xStep*= -1;
              
              if(Math.abs(xStep) < 11)
	  {
	      xStep+= 1;
	  }
          }
        //the ball has a positive xStep size
        else if  ( x >= BouncingBall.width)
            {
	xStep*= -1;
	
	if(Math.abs(xStep) < 11)
	  {
	      xStep-= 1;
	  }	
            }
        //the ball has a negative xStep size
        if (y < 0)
          {
              yStep*= -1;

              if(Math.abs(yStep) < 11)
	  {
	      yStep+= 1;
	  }
          }
        //the ball has a positive yStep size
        else if (y >= BouncingBall.height)
            {
               yStep*= -1;

               if(Math.abs(yStep) < 11)
	   {
	       yStep-= 1;
	   }
            }
            
        x += xStep;
        y += yStep;
    }
      
    //creates a graphical representation of a ball
    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y, 2*radius, 2*radius);
    }
}

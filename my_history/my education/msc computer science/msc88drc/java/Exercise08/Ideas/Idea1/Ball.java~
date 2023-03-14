import java.awt.*;

public class Ball
{    
    // instance variables
    int x = (BouncingBall.width)/2;
    int y = (BouncingBall.height)/2 ;
    int xStep, yStep;  
    Color color = Color.blue;
    int radius = 5;

    public Ball(int xVel, int yVel)
    {
        xStep = xVel;
        yStep = yVel;
    }
      
    public void progress()
    {
      if (x < 0 || x >= BouncingBalls.width)
          {
              xStep *= -1;
          }
      if (y < 0 || y >= BouncingBalls.height)
          {
              yStep *= -1;
          }
	
      x += xStep;
      y += yStep;
    }

      
    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x_pos-radius, y_pos-radius, 2*radius, 2*radius);
    }
}

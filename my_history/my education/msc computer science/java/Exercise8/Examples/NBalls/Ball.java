import java.awt.*;

public class Ball {

    int x, y;     // current location
    int dx, dy;   // motion delta
    int diameter = 10;
    Color color = Color.red;

    public Ball (int x, int y) {
	this.x = x;
	this.y = y;
	dx = x % 10 + 1;
	dy = y % 10 + 1;
	color = new Color(x % 256, y % 256, (x+y) % 256);
    }

    public void move  () {
	if (x < 0 || x >= BouncingBalls.width)
	    dx = - dx;
	if (y < 0 || y >= BouncingBalls.height)
	    dy = - dy;
	x += dx;
	y += dy;
    }

    public void paint (Graphics g) {
	g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

} // Ball

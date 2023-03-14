import java.awt.*;
import java.applet.*;

class Obstacle
{
    public Rectangle r; 
    Graphics g;

    public Obstacle(int x,int y,int w,int h)
    {
        r=new Rectangle(x,y,w,h);
    }

    public void paint(Graphics gr)
    {	
        g=gr;
        g.setColor(Color.lightGray);
        g.draw3DRect(r.x,r.y,r.width,r.height,true);
    }		
}

class CollideBall
{
    int width, height;
    public static final int diameter=20;
    //coordinates and value of increment
    double x, y, xinc, yinc, coll_x, coll_y;
    boolean collide;
    Color color;
    Graphics g;
    Rectangle r;
	
    //the constructor
    public CollideBall(int w, int h, int x, int y, double xinc, double yinc, Color c)
    {
        width=w;
        height=h;
        this.x=x;
        this.y=y;
        this.xinc=xinc;
        this.yinc=yinc;		
        color=c;		
        r=new Rectangle(150,80,130,90);
    }
	
    public double getCenterX() {return x+diameter/2;}
    public double getCenterY() {return y+diameter/2;}

    public void alterRect(int x, int y, int w, int h)
    {
        r.move(x,y);
        r.resize(w,h);
    }
	
    public void move()
    {
        if (collide)
            {			
	double xvect=coll_x-getCenterX();
	double yvect=coll_y-getCenterY();

	if((xinc>0 && xvect>0) || (xinc<0 && xvect<0))
	    xinc=-xinc;

	if((yinc>0 && yvect>0) || (yinc<0 && yvect<0))
	    yinc=-yinc;
	
	collide=false;
            }
	
        x+=xinc;
        y+=yinc;

        //when the ball bumps against a boundary, it bounces off
        if(x<6 || x>width-diameter)
            {
	xinc=-xinc;
	x+=xinc;
            }
	    
        if(y<6 || y>height-diameter)
            {
	yinc=-yinc;
	y+=yinc;
            }
		
        //cast ball coordinates to integers
        int x=(int)this.x;
        int y=(int)this.y;

        //bounce off the obstacle
        //left border
        if(x>r.x-diameter&&x<r.x-diameter+7&&xinc>0&&y>r.y-diameter&&y<r.y+r.height)
            {
	xinc=-xinc;
	x+=xinc;
            }
        //right border
        if(x<r.x+r.width&&x>r.x+r.width-7&&xinc<0&&y>r.y-diameter&&y<r.y+r.height)
            {
	xinc=-xinc;
	x+=xinc;
            }
        //upper border
        if(y>r.y-diameter&&y<r.y-diameter+7&&yinc>0&&x>r.x-diameter&&x<r.x+r.width)
            {
	yinc=-yinc;
	y+=yinc;
            }
        //bottom border
        if(y<r.y+r.height&&y>r.y+r.height-7&&yinc<0&&x>r.x-diameter&&x<r.x+r.width)
            {
	yinc=-yinc;
	y+=yinc;
            }

    }
	
    public void hit(CollideBall b)
    {
        if(!collide)
            {
	coll_x=b.getCenterX();
	coll_y=b.getCenterY();
	collide=true;
            }
    }
	
    public void paint(Graphics gr)
    {	
        g=gr;
        g.setColor(color);
        //the coordinates in fillOval have to be int, so we cast
        //explicitly from double to int
        g.fillOval((int)x,(int)y,diameter,diameter);
		
        g.setColor(Color.white);
        g.drawArc((int)x,(int)y,diameter,diameter,45,180);

        g.setColor(Color.darkGray);
        g.drawArc((int)x,(int)y,diameter,diameter,225,180);
    }	
}

public class BouncingBalls extends Applet implements Runnable 
{
    Thread runner;	
    Image Buffer;
    Graphics gBuffer;		
    CollideBall ball[];
    Obstacle o;    
    //how many balls?
    static final int MAX=10;
    boolean intro=true,drag,shiftW,shiftN,shiftE,shiftS;
    boolean shiftNW,shiftSW,shiftNE,shiftSE;
    int xtemp,ytemp,startx,starty;
    int west, north, east, south;
	
    public void init() 
    {			
        Buffer=createImage(size().width,size().height);
        gBuffer=Buffer.getGraphics();					
      
        ball=new CollideBall[MAX];
            
        int w=size().width-5;
        int h=size().height-5;		
      
        //our balls have different start coordinates, increment values
        //(speed, direction) and colors
        ball[0]=new CollideBall(w,h,50,20,1.5,2.0,Color.orange);
        ball[1]=new CollideBall(w,h,60,210,2.0,-3.0,Color.red);
        ball[2]=new CollideBall(w,h,15,70,-2.0,-2.5,Color.pink);
        ball[3]=new CollideBall(w,h,150,30,-2.7,-2.0,Color.cyan);
        ball[4]=new CollideBall(w,h,210,30,2.2,-3.5,Color.magenta);
        ball[5]=new CollideBall(w,h,360,170,2.2,-1.5,Color.yellow);
        ball[6]=new CollideBall(w,h,210,180,-1.2,-2.5,Color.blue);
        ball[7]=new CollideBall(w,h,330,30,-2.2,-1.8,Color.green);
        ball[8]=new CollideBall(w,h,180,220,-2.2,-1.8,Color.black);
        ball[9]=new CollideBall(w,h,330,130,-2.2,-1.8,Color.gray);


        o=new Obstacle(150,80,130,90);

        west=o.r.x;
        north=o.r.y;
        east=o.r.x+o.r.width;
        south=o.r.y+o.r.height;
    }	

    public void start()
    {
        if (runner == null) 
            {
	runner = new Thread (this);
	runner.start();
            }
    }

    public void stop()
    {
        if (runner != null) 
            {
         	runner.stop();
           	runner = null;
            }
    }

    public void run()
    {
        while(true) 
            {
	Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

	try {runner.sleep(15);}
            	catch (Exception e) { }			
						
	//move our balls around
	for(int i=0;i<MAX;i++)
	    ball[i].move();
				
	handleCollision();
			
	repaint();	                        
            }	
    }
	
    boolean collide(CollideBall b1, CollideBall b2)
    {
        double wx=b1.getCenterX()-b2.getCenterX();
        double wy=b1.getCenterY()-b2.getCenterY();

        //we calculate the distance between the centers two
        //colliding balls (theorem of Pythagoras)
        double distance=Math.sqrt(wx*wx+wy*wy);

        if(distance<b1.diameter)					
            return true;		
		
        return false;	
    }

    void changeCursor(int x, int y)
    {
        Rectangle r=new Rectangle(o.r.x+1,o.r.y+1,o.r.width-1,o.r.height-1);

        Frame BrowserFrame;
        Component ParentComponent;
        ParentComponent = getParent();
        while ( ParentComponent != null && 
	!(ParentComponent instanceof Frame)) 		      
            ParentComponent = ParentComponent.getParent();		
        BrowserFrame = (Frame) ParentComponent;
		
        if(shiftNW||shiftSE)
            BrowserFrame.setCursor(Frame.SE_RESIZE_CURSOR);
        else if(shiftNE||shiftSW)
            BrowserFrame.setCursor(Frame.SW_RESIZE_CURSOR);
        else if(shiftW)
            BrowserFrame.setCursor(Frame.W_RESIZE_CURSOR);
        else if(shiftN)
            BrowserFrame.setCursor(Frame.N_RESIZE_CURSOR);
        else if(shiftE)
            BrowserFrame.setCursor(Frame.W_RESIZE_CURSOR);
        else if(shiftS)
            BrowserFrame.setCursor(Frame.N_RESIZE_CURSOR);
        else if(r.inside(x,y))
            BrowserFrame.setCursor(Frame.MOVE_CURSOR);
        else 
            BrowserFrame.setCursor(Frame.DEFAULT_CURSOR);
    }
	
    public boolean mouseMove(Event evt,int x,int y)
    {
        //the corner areas of the obstacle
        Rectangle nw,sw,ne,se;

        nw=new Rectangle(o.r.x-2,o.r.y-2,4,4);

        if(nw.inside(x,y))
            shiftNW=true;
        else shiftNW=false;

        sw=new Rectangle(o.r.x-2,o.r.y+o.r.height-2,4,4);

        if(sw.inside(x,y))
            shiftSW=true;
        else shiftSW=false;

        ne=new Rectangle(o.r.x+o.r.width-2,o.r.y-2,4,4);

        if(ne.inside(x,y))
            shiftNE=true;
        else shiftNE=false;

        se=new Rectangle(o.r.x+o.r.width-2,o.r.y+o.r.height-2,4,4);

        if(se.inside(x,y))
            shiftSE=true;
        else shiftSE=false;		

        ///////////////////////////////////////

        if(x>o.r.x-2&&x<o.r.x+2&&y>o.r.y&&y<o.r.y+o.r.height)
            shiftW=true;
        else shiftW=false;
		
        if(x>o.r.x+o.r.width-2&&x<o.r.x+o.r.width+2
           &&y>o.r.y&&y<o.r.y+o.r.height)
            shiftE=true;
        else shiftE=false;
		
        if(y<o.r.y+2&&y>o.r.y-2&&x>o.r.x&&x<o.r.x+o.r.width)
            shiftN=true;
        else shiftN=false;
		
        if(y>o.r.y+o.r.height-2&&y<o.r.y+o.r.height+2
           &&x<o.r.x+o.r.width)
            shiftS=true;
        else shiftS=false;
		
        changeCursor(x,y);

        return true;
    }
	
    public boolean mouseDown(Event evt,int x,int y)
    {
        Rectangle r=new Rectangle(o.r.x+2,o.r.y+2,o.r.width-4,o.r.height-4);

        if(r.inside(x,y))
            {
	drag=true;
			
	startx=x;
	starty=y;
	xtemp=o.r.x;
	ytemp=o.r.y;
            }
        else drag=false;

        changeCursor(x,y);

        return true;
    }

    public boolean mouseDrag(Event evt,int x,int y)
    {
        intro=false;

        Rectangle bounds=new Rectangle(5,5,size().width-5,size().height-5);

        int endx, endy;		

        endx=x-startx;
        endy=y-starty;	

        //disable mouse actions past boundaries
        if(x<5)x=5;
        if(y<5)y=5;
        if(x>bounds.width)x=bounds.width;
        if(y>bounds.height)y=bounds.height;

        if(drag)
            {	
	//disallow to move past border
	int ox=endx+xtemp;
	int oy=endy+ytemp;
			
	if(ox<5)ox=5;
	if(oy<5)oy=5;

	if(ox>bounds.width-o.r.width)
	    ox=bounds.width-o.r.width;

	if(oy>bounds.height-o.r.height)
	    oy=bounds.height-o.r.height;	
			
	o.r.move(ox,oy);				

	west=o.r.x;
	north=o.r.y;
	east=o.r.x+o.r.width;
	south=o.r.y+o.r.height;						
            }		
		
        else
            {
	if(shiftNW){west=x;north=y;}
	else if(shiftNE){east=x;north=y;}
	else if(shiftSW){west=x;south=y;}
	else if(shiftSE){east=x;south=y;}
	else if(shiftW)west=x;
	else if(shiftE)east=x;
	else if(shiftN)north=y;
	else if(shiftS)south=y;											

	//disallow resizing below 40*40
	int MIN=40;

	if(east-west<MIN)
	    {
	        //shiftNW=shiftNE=shiftSW=shiftSE=shiftW=shiftE=false;
				
	        if(shiftW||shiftNW||shiftSW)
	            west=east-MIN;

	        if(shiftE||shiftNE||shiftSE)
	            east=west+MIN;
	    }

	if(south-north<MIN)
	    {
	        //shiftNW=shiftNE=shiftSW=shiftSE=shiftN=shiftS=false;
	        if(shiftN||shiftNW||shiftNE)
	            north=south-MIN;

	        if(shiftS||shiftSE||shiftSW)
	            south=north+MIN;
	    }
            }

        //report altering of obstacle to ball objects and obstacle
        for(int i=0;i<MAX;i++)
            ball[i].alterRect(o.r.x,o.r.y,o.r.width,o.r.height);
		
        o.r.move(west,north);
        o.r.resize(east-west, south-north);

        changeCursor(x,y);
		
        return true;
    }	
	
    private void handleCollision()
    {	
        //we iterate through all the balls, checking for collision
        for(int i=0;i<MAX;i++)
            for(int j=0;j<MAX;j++)
	{
	    if(i!=j)
	        {										
	            if(collide(ball[i], ball[j]))
		{			
		    ball[i].hit(ball[j]);
		    ball[j].hit(ball[i]);
		}
	        }
	}	
    }
	
    public void update(Graphics g)
    {
        paint(g);
    }
        
    public void paint(Graphics g) 
    {		
        gBuffer.setColor(Color.lightGray);
        gBuffer.fillRect(0,0,size().width,size().height);
		
        gBuffer.draw3DRect(5,5,size().width-10,size().height-10,false);			

        //paint the obstacle rectangle
        o.paint(gBuffer);

        //paint our balls
        for(int i=0;i<MAX;i++)
            ball[i].paint(gBuffer);	
		
        if(intro)
            {			
	gBuffer.setColor(Color.red);

	gBuffer.setFont(new Font("Helvetica", Font.PLAIN,  12));			
	gBuffer.drawString("You can move and resize the rectangle!",20,30);

	gBuffer.setFont(new Font("Helvetica", Font.PLAIN,  10));
	gBuffer.drawString("© 2000 Johannes Wallroth - www.programming.de",155,240);
            }
		
        g.drawImage (Buffer,0,0, this);				
    }	
}


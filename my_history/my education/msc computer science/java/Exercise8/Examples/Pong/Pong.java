import java.awt.*;
import java.applet.*;
import java.util.*;

//*************************************************************************************
//*************************************************************************************
//***************************  The Applet *********************************************
//*************************************************************************************
//*************************************************************************************
public class Pong extends Applet implements Runnable {

 OurCanvas table_canvas;
 Graphics g_buffer;
 Graphics g_applet;
 Graphics g_canvas;
 Thread animate;
 AudioClip hit_sound;
 AudioClip bounce_sound;
 AudioClip miss_sound;
 MediaTracker mt;
 Image paddle_img;
 Image paddle_mask_img;
 Image ball_img;
 Image ball_mask_img;
 Image img_buffer;
 private CheckboxGroup radio_ball_speed;
 private Checkbox radio_slow, radio_medium, radio_fast;
 private Panel p1;
 private Label time_label;
 private Label l1;
 BorderLayout p1bordermanager;
 long start_time;          //Save the millisecond we started at
 long current_millisec;         //Current milli-second;
 Date timer_date;
 String timer_string;

 int ball_speed   = 1;  //start at slow
 int paddle_speed = 2;
 int delta_y = ball_speed;
 int delta_x = ball_speed;
 int ball_x;
 int ball_y;

 int paddle_x = 10;
 int paddle_y = 0;
 int last_paddle_y =0;
 int last_ball_x;
 int last_ball_y;
 int table_width = 400;
 int table_height = 300;
 int top_edge;
 int bottom_edge;
 int right_edge;
 int paddle_dir = 0;

 int max_paddle_y;
 int min_paddle_y;
 int ball_width;
 int ball_height;
 int paddle_width;
 int paddle_height;
 int paddle_x_edge;
 int ball_x_offscreen;


 //************************ Start *************************************
 public void init()
  {

   super.init();
   this.resize(table_width+30, table_height);

   setLayout( new BorderLayout() );
   table_canvas = new OurCanvas();
   table_canvas.resize(table_width,table_height);
   add("North", table_canvas);
   requestFocus();

   Panel p1 = new Panel();
   p1bordermanager = new BorderLayout();
   p1.setLayout ( p1bordermanager);
   Panel p2 = new Panel();
   radio_ball_speed = new CheckboxGroup();
   p2.add(  l1 = new Label("Ball Speed:"));
   p2.add( radio_slow = new Checkbox ("Slow", radio_ball_speed, true) );
   p2.add( radio_medium = new Checkbox ("Med", radio_ball_speed, false) );
   p2.add( radio_fast = new Checkbox ("Fast", radio_ball_speed, false) );
   p1.add( "West", p2);
   timer_string = new String(" Time = 0:00  ");
   p1.add( "East", time_label = new Label(timer_string) );

   add("South", p1);

   bounce_sound = getAudioClip( getDocumentBase(), "bounce.au");
   hit_sound = getAudioClip( getDocumentBase(), "hit.au");
   miss_sound = getAudioClip( getDocumentBase(), "miss.au");

   g_applet = this.getGraphics();
   g_canvas= table_canvas.getGraphics();

   img_buffer = createImage( table_width, table_height);
   g_buffer = img_buffer.getGraphics();
   g_buffer.setColor(Color.black);
   g_buffer.fillRect(0,0,table_width,table_height);

   paddle_img = getPicImage("paddle.gif");
   paddle_mask_img = getPicImage("paddle_mask.gif");
   ball_img = getPicImage("ball.gif");
   ball_mask_img = getPicImage("ball_mask.gif");
   ball_width = ball_img.getWidth(null);
   ball_height = ball_img.getHeight(null);
   ball_x_offscreen = -1 * ball_width;
   paddle_width = paddle_img.getWidth(null);
   paddle_height = paddle_img.getHeight(null);
   max_paddle_y = table_height - paddle_height;
   min_paddle_y = 0;
   paddle_x_edge = paddle_x + paddle_width;
   top_edge = 0;
   bottom_edge = table_height - ball_height;
   right_edge = table_width - ball_width;

   timer_date = new Date();

  }


 public void start() {
   if (animate == null)
    {
     animate = new Thread (this);
     animate.setPriority(Thread.currentThread().getPriority() - 1);
     animate.start();
    }

  }

  //*******  Run- this method is called by the thread "animate" and starts an endless loop ***
  public void run() {
    int currentSecond =0;
    int lastSecond =0;
    int remainderSeconds = 0;
    int minutes = 0;
    StringBuffer displayMminutes = new StringBuffer("");
    StringBuffer seconds = new StringBuffer("");
    StringBuffer timerString = new StringBuffer("");

    start_volley();

    for (;;) {
      //If we rolled around to another second update Timer on screen
      current_millisec = System.currentTimeMillis() - start_time;
      currentSecond = (int)current_millisec/1000;
      if ( currentSecond != lastSecond) {
        timerString = new StringBuffer("");
        timerString.append(" Time = ");
        minutes = currentSecond / 60;
        remainderSeconds = currentSecond - (minutes * 60);
        timerString.append(minutes);
        timerString.append(":");
        if (remainderSeconds < 10) timerString.append("0");
        timerString.append(remainderSeconds);
        timerString.append(" ");
        time_label.setText(timerString.toString());
        lastSecond = currentSecond;
      }
      move_paddle();
      last_ball_x = ball_x;
      last_ball_y = ball_y;
      move_ball();
      collision_detect();
      if (ball_x < ball_x_offscreen) {
         miss_sound.play();
         start_volley();
      }
      table_paint();
      try { animate.sleep(6); } catch (InterruptedException e) {};
    }

  }



  //**********************  start_volley  ******************************
  public void start_volley()
  {
    start_time = System.currentTimeMillis();
    ball_x = 50; ball_y = 10; delta_x = ball_speed; delta_y = ball_speed;
  }


  //**************************  Move Paddle *******************************
  public void move_paddle()
   {
    last_paddle_y = paddle_y;
    paddle_y += paddle_dir;
    if ( paddle_y > max_paddle_y ) paddle_y = max_paddle_y;
    if ( paddle_y < min_paddle_y ) paddle_y = min_paddle_y;
    //paddle_y = ball_y - 10;  //Uncomment to watch the computer play itself
   }

  //**************************  Move Ball *******************************
  public void move_ball()
   {
     ball_x += delta_x;
     ball_y += delta_y;
   }

  //************************** Collision Detect **************************
  public void collision_detect()
   {

       //****** Detect collision between ball and paddle top or bottom
       if (ball_x < paddle_x_edge )
        {
         //****** Detect collision between ball and paddle front
         if (ball_x < (paddle_x_edge - 3) )
          {
           if  ( (ball_y + ball_height) >= paddle_y )
             {
               if (ball_y <= (paddle_y + paddle_height) )
                {
                 hit_sound.play();
                 flip_vert_direction();
                 move_ball();
                }
             }
          }
         else
          {
           if(  (ball_y + ball_height >= paddle_y)
             && (ball_y <= paddle_y + paddle_height)  )
            {
             hit_sound.play();
             flip_horz_direction();
             move_ball();
            }
          }
        }

     //****** Detect collision between ball and table edges
     if ( ball_x > ( right_edge) )
      {
       bounce_sound.play();
       flip_horz_direction();
      }
     if (  (ball_y > bottom_edge )  || (ball_y < top_edge)  )
      {
       bounce_sound.play();
       flip_vert_direction();
      }

   }


  //**************************  Bounce Ball of of top, and bottom edges **********
  public void flip_horz_direction()
    {
       delta_x *= -1;
       ball_x += delta_x;
    }



  //**************************  Bounce Ball of of right, and left edges **********
  public void flip_vert_direction()
    {
       delta_y *= -1;
       ball_y += delta_y;
    }



 //************************ Stop *************************************
 public void stop()
  {
    if (animate != null)
     {
       animate.stop();
       animate=null;
     }
  }



 //************************ Update *************************************
  public void update(Graphics g)
   {
    paint(g);
   }

 //************************ Paint *************************************
  public void table_paint()
  {
   g_buffer.drawImage(paddle_mask_img, paddle_x, last_paddle_y, null);
   g_buffer.drawImage(paddle_img, paddle_x, paddle_y, null);
   g_buffer.drawImage(ball_mask_img, last_ball_x, last_ball_y, null);
   g_buffer.drawImage(ball_img, ball_x, ball_y, null);

   g_canvas.drawImage(img_buffer, 0, 0, null);
  }



 //************************ KeyDown *************************************
  public boolean keyDown(Event evt, int key)
   {
    if ( key == Event.DOWN )
     {
       paddle_dir = paddle_speed;
     }
    if ( key == Event.UP )
     {
       paddle_dir = paddle_speed * -1;
     }
    return true;
   }

 //************************ KeyUp *************************************
  public boolean keyUp(Event evt, int key)
   {
    paddle_dir = 0;
    return true;
   }

 //************************ action *************************************
  public boolean action( Event e, Object o)
   {
     if (e.target instanceof Checkbox)
      {
        if (radio_slow.getState() == true) ball_speed = 1;
        if (radio_medium.getState() == true) ball_speed = 2;
        if (radio_fast.getState() == true) { ball_speed = 3;  }

        // Ball delta = sign of ball delta (-/+) * the new ball speed
        delta_x = (delta_x / Math.abs(delta_x) ) * ball_speed;
        delta_y = (delta_y / Math.abs(delta_y) ) * ball_speed;
      }
     return true;
   }


//*************** getPicImage **************************************
// Use MediaTracker to insure the images are fully loaded before
// we try to use them
 private Image getPicImage(String image_file_name)
 {
  Image img_work = null;
  mt = new MediaTracker(this);
  try
   {
    img_work = getImage(getDocumentBase(),image_file_name);
   }
  catch(Exception e1)
   {
    System.out.println(e1);
   }
  mt.addImage(img_work, 0);
  try
  {
   showStatus("Loading image " + image_file_name );
   mt.checkID(0, true);
   mt.waitForID(0);
  }
  catch(InterruptedException e2)
  {
   System.out.println(e2);
  }
  return img_work;
 }




} //---- End of Applet


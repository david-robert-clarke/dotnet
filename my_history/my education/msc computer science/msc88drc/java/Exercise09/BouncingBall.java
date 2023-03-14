import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.AbstractButton;

/**
   The interface for the Bouncing Ball program
   
   @author David Clarke
**/
public class BouncingBall extends JApplet implements ActionListener
{
  public static int roomWidth = 500; //room size attributes
  public static int roomHeight = 500;
  private MyPanel roomPanel;
  private JPanel xyPanel,speedGroupPanel,diameterColorPanel;
  private JPanel createPanel, controlPanel;
  private JTextField xField,yField,aField; 
  private JRadioButton slowButton, slowAverageButton,averageButton;
  private JRadioButton averageFastButton, fastButton;
  private JComboBox colorCombo, sizeCombo;
  private JButton createButton, pauseButton, playButton;
  private int p1XPos,p1YPos,p1Height,p1Width; //paddle1 attributes
  private int p2XPos,p2YPos,p2Height,p2Width; //paddle2 attributes
  private ArrayList balls;
  private boolean unPaused;

  // Declare a JPanel that represents the room within which the ball bounces
  public class MyPanel extends JPanel
  {
    public void paintComponent(Graphics g)
    {
      setSize(roomWidth, roomHeight);
      super.paintComponent(g);
      setBackground(Color.orange);       
    }
  }

  /**
   * On applet start up, all fields are initialised
   **/
  public void init()
  {
    roomPanel = new MyPanel();
      
    // Text Fields
    xField = new JTextField("250");
    xField.addActionListener(this); 
    xField.setToolTipText("Choose starting postion of ball along the x-axis.");
    yField = new JTextField("250");
    yField.addActionListener(this);
    yField.setToolTipText("Choose starting postion of ball along the y-axis.");
    aField = new JTextField("15");
    aField.addActionListener(this);
    aField.setToolTipText("Choose the balls initial angle of projection.");
       
    // Combo Boxes
    colorCombo = new JComboBox();
    colorCombo.addItem("blue");
    colorCombo.addItem("cyan");
    colorCombo.addItem("gray");
    colorCombo.addItem("darkGray");
    colorCombo.addItem("lightGray");
    colorCombo.addItem("green");
    colorCombo.addItem("magenta");
    colorCombo.addItem("black");
    colorCombo.addItem("pink");
    colorCombo.addItem("red");
    colorCombo.addItem("white");
    colorCombo.addItem("yellow");
    colorCombo.setToolTipText("Choose a colour for the new ball ");
    sizeCombo = new JComboBox();
    sizeCombo.addItem("5");
    sizeCombo.addItem("10");
    sizeCombo.addItem("15");
    sizeCombo.addItem("20");
    sizeCombo.addItem("25");
    sizeCombo.addItem("30");
    sizeCombo.setToolTipText("Choose the diameter of the new ball ");

    // Buttons
    createButton = new JButton("Create Ball");
    pauseButton = new JButton("Pause");
    playButton = new JButton("Play");
    createButton.addActionListener(this);
    pauseButton.addActionListener(this);
    playButton.addActionListener(this);
    createButton.setToolTipText("Click this button to add a new ball.");
    pauseButton.setToolTipText("Click this button to pause the action.");
    playButton.setToolTipText("Click this button to re-animate the balls.");
    pauseButton.setEnabled(false);
    playButton.setEnabled(false);
    unPaused = true;

    // Radio Buttons
    slowButton = new JRadioButton("Slowest");
    slowButton.setSelected(true);
    slowButton.addActionListener(this);
    slowAverageButton = new JRadioButton("Slow");
    slowAverageButton.addActionListener(this);
    averageButton = new JRadioButton("Average");
    averageButton.addActionListener(this);
    averageFastButton = new JRadioButton("Fast");
    averageFastButton.addActionListener(this);
    fastButton = new JRadioButton("Fastest");
    fastButton.addActionListener(this);
    ButtonGroup speedGroup = new ButtonGroup();
    speedGroup.add(slowButton);
    speedGroup.add(slowAverageButton);
    speedGroup.add(averageButton);
    speedGroup.add(averageFastButton);
    speedGroup.add(fastButton);

    // Add components to Panels
    xyPanel = new JPanel();
    xyPanel.setLayout(new GridLayout(1,6));
    xyPanel.add(new JLabel("  x:"));
    xyPanel.add(xField);
    xyPanel.add(new JLabel("  y:"));
    xyPanel.add(yField);
    xyPanel.add(new JLabel("Angle: "));
    xyPanel.add(aField);

    speedGroupPanel = new JPanel();
    speedGroupPanel.setLayout(new GridLayout(1,2));
    speedGroupPanel.add(new JLabel("Ball Velocity:"));
    speedGroupPanel.add(slowButton);
    speedGroupPanel.add(slowAverageButton);
    speedGroupPanel.add(averageButton);
    speedGroupPanel.add(averageFastButton);
    speedGroupPanel.add(fastButton);

    diameterColorPanel = new JPanel();
    diameterColorPanel.setLayout(new GridLayout(1,4));
    diameterColorPanel.add(new JLabel("Colour:"));
    diameterColorPanel.add(colorCombo);
    diameterColorPanel.add(new JLabel("Diameter: "));
    diameterColorPanel.add(sizeCombo);

    createPanel = new JPanel();
    createPanel.setLayout(new GridLayout(1,4));
    createPanel.add(new JLabel("Play/Pause:"));
    createPanel.add(pauseButton);
    createPanel.add(playButton); 
    createPanel.add(createButton);

    // Add components to "New Ball Properties" panel 
    controlPanel = new JPanel();
    controlPanel.setSize(15,15);
    controlPanel.setLayout(new GridLayout(4,1));
    controlPanel.add(xyPanel);
    controlPanel.add(speedGroupPanel);
    controlPanel.add(diameterColorPanel);
    controlPanel.add(createPanel);
    controlPanel.setBorder(new TitledBorder(new EtchedBorder(), 
					    "New Ball Properties"));

    // Add panels to content pane
    Container contentPane = getContentPane();
    contentPane.add(controlPanel,"South");   
    contentPane.add(roomPanel,"Center");

    // Initialise the number of balls
    balls = new ArrayList();

    // Create two paddles and render them
    p1XPos = 50;    p1YPos = 170;   
    p1Height = 150; p1Width = 20;
    p2XPos = 400;   p2YPos = 170;
    p2Height = 150; p2Width = 20;
        
    PaddleThread paddle1=new PaddleThread(p1XPos,p1YPos,p1Height,p1Width,this);
    paddle1.block();
    PaddleThread paddle2=new PaddleThread(p2XPos,p2YPos,p2Height,p2Width,this);
    paddle2.block();  
  }
    
  /** 
   * If an action is performed by any of the new ball menu items, deal with 
   * that particular action here
   **/
  public void actionPerformed (ActionEvent event)
  { 
    int xValue = 0;
    int yValue = 0;
    int aValue = 0;
    int dValue = 0;
    int vValue = 20;
    String boxName = (String)colorCombo.getSelectedItem();
    String ballSize = (String)sizeCombo.getSelectedItem();
    Color ballColor = Color.white;
    BallThread bThread; 
        
    try
    {
      xValue = Integer.parseInt(xField.getText());
      yValue = Integer.parseInt(yField.getText());
      aValue = Integer.parseInt(aField.getText());

      // if the x and y parameters are outside that of the room dimensions then
      // set their values to be within the rooms dimensions
      if(xValue > (roomWidth - Integer.parseInt(ballSize)))
      {
	xValue = roomWidth - Integer.parseInt(ballSize);
      }
      else if (xValue < 0)
      {
	xValue = 0 + Integer.parseInt(ballSize);
      }
      
      if(yValue > (roomHeight - Integer.parseInt(ballSize)))
      {
	yValue =  roomHeight - Integer.parseInt(ballSize);
      }
      else if(yValue < 0)
      {
	yValue = 0 + Integer.parseInt(ballSize);
      }

      // Looks at the current radio button selection to determine the speed  
      // of the ball
      if(slowButton.isSelected()){vValue = 20;}
      else if(slowAverageButton.isSelected()){vValue = 15;}
      else if(averageButton.isSelected()){vValue = 10;}
      else if(averageFastButton.isSelected()){vValue = 5;}
      else if(fastButton.isSelected()){vValue = 1;}

      // Looks at the current value displayed in the combo box
      if (boxName.equals("blue")){ballColor = Color.blue;}
      else if (boxName.equals("cyan")){ballColor = Color.cyan;}
      else if (boxName.equals("gray")){ballColor = Color.gray;}
      else if (boxName.equals("darkGray")){ballColor = Color.darkGray;}
      else if (boxName.equals("lightGray")) {ballColor = Color.lightGray;}
      else if (boxName.equals("green")){ballColor = Color.green;}
      else if (boxName.equals("magenta")){ballColor = Color.magenta;}
      else if (boxName.equals("black")){ballColor = Color.black;}
      else if (boxName.equals("pink")){ballColor = Color.pink;}
      else if (boxName.equals("red")){ballColor = Color.red;}
      else if (boxName.equals("white")){ballColor = Color.white;}
      else if (boxName.equals("yellow")){ballColor = Color.yellow;}

      // Looks at the current value displayed in the combo box
      if (ballSize.equals("5")){dValue = 5;}
      else if (ballSize.equals("10")){dValue = 10;}
      else if (ballSize.equals("15")){dValue = 15;}
      else if (ballSize.equals("20")){dValue = 20;}
      else if (ballSize.equals("25")){dValue = 25;}
      else if (ballSize.equals("30")){dValue = 30;}

      Object source = event.getSource();
      if (source == createButton)
      {
	pauseButton.setEnabled(true);
	playButton.setEnabled(true);
	        
	//create a new BallThread x, y, velocity, angle, diameter, colour
	bThread = new BallThread(xValue,yValue,vValue,aValue,dValue,
				 ballColor,this);
	bThread.bounce();
	balls.add(bThread); 

	if(balls.size() == 3) {createButton.setEnabled(false);}
      }
        
      if (source == playButton) {unPaused = true;}
      else if(source == pauseButton) {unPaused = false;}
    }
    catch  (NumberFormatException exception)
    {
      System.out.println("Invalid entry " + exception.getMessage());

      Object[] options = { "OK"};
      JOptionPane.showOptionDialog(null, "Some parameters are incorrect or "+  
				   "have not "+"been specified","Warning",
				   JOptionPane.DEFAULT_OPTION, 
				   JOptionPane.WARNING_MESSAGE,null, 
				   options, options[0]); //taken from Java API
    }

  }

  /**
   * Calculates whether a ball has collided with a paddle. The direction of 
   * the ball is changed accordingly
   **/
  public void paddleCollide()
  {
    // local variables
    BallThread temp;
    int x1, y1;
    int stepX,stepY;
    int diam1;
    int rad1;

    if (balls.size() > 0)
    {
      for(int i=0; i < balls.size(); i++)
      {
	temp = (BallThread) balls.get(i);
	stepX = temp.getXStep();
	stepY = temp.getYStep();
	x1 = temp.getX(); 
	y1 = temp.getY();
	diam1 = temp.getDiameter();
	rad1 = diam1/2;

	// if ball travelling from right to left
	if((temp.getXStep())<0)
	{
	  if((x1 <= (p1XPos + p1Width))&&(x1 >= p1XPos)|| 
	     (x1 <= (p2XPos + p2Width))&&(x1 >= p2XPos))
	  {
	    // if the ball is travelling from bottom to top
	    if((temp.getYStep())<0)
	    {
	      if((y1 <= (p1YPos + p1Height))&&(y1 >= p1YPos)|| 
		 (y1 <= (p2YPos + p2Height))&&(y1 >= p2YPos))
	      {
		temp.setXStep(stepX * -1);
	      }
	    }
	    // if the ball is travelling from top to bottom
	    else
	    {
	      if((y1+diam1) >= p1YPos && ((y1+diam1) <= p1YPos+p1Height)|| 
		 (y1+diam1 >= p2YPos) && (((y1+diam1) <= p2YPos+p2Height)))
	      {
		temp.setXStep(stepX * -1);
	      }	        
	    }
	      
	  }
	}
	// else ball is travelling from left to right
	else
	{
	  // if the ball is travelling from bottom to top
	  if((x1+diam1) >= p1XPos && ((x1+diam1) <= p1XPos+p1Width)|| 
	     (x1+diam1 >= p2XPos) && (((x1+diam1) <= p2XPos+p2Width)))
	  {
	    if((temp.getYStep())<0)
	    {
	      if((y1 <= (p1YPos + p1Height))&&(y1 >= p1YPos)|| 
		 (y1 <= (p2YPos + p2Height))&&(y1 >= p2YPos))
	      {
		temp.setXStep(stepX * -1);
	      }
	    }
	    // if the ball is travelling from top to bottom
	    else
	    {
	      if((y1+diam1) >= p1YPos && ((y1+diam1) <= p1YPos+p1Height)|| 
		 (y1+diam1 >= p2YPos) && (((y1+diam1) <= p2YPos+p2Height)))
	      {
		temp.setXStep(stepX * -1);
	      }	        
	    }
	  }
	  
	}
              
	// if ball travelling from bottom to top
	if((temp.getYStep())<0)
	{
	  if((y1 <= (p1YPos + p1Height))&&(y1 >= p1YPos)|| 
	     (y1 <= (p2YPos + p2Height))&&(y1 >= p2YPos))
	  {
	    // if the ball is travelling from bottom to top
	    if((temp.getXStep())<0)
	    {
	      if((x1 <= (p1XPos + p1Width))&&(x1 >= p1XPos)|| 
		 (x1 <= (p2XPos + p2Width))&&(x1 >= p2XPos))
	      {
		temp.setYStep(stepY * -1);
	      }
	    }
	    // if the ball is travelling from top to bottom
	    else
	    {
	      if((x1+rad1) >= p1XPos && ((x1+rad1) <= p1XPos+p1Width)|| 
		 (x1+rad1 >= p2XPos) && (((x1+rad1) <= p2XPos+p2Width)))
	      {
		temp.setYStep(stepY * -1);
	      }	        
	    }
	  }
	}
	// else ball is travelling from bottom to top
	else
	{
	  // if the ball is travelling from left to right
	  if((y1+rad1) >= p1YPos && ((y1+rad1) <= p1YPos+p1Height)|| 
	     (y1+rad1 >= p2YPos) && (((y1+rad1) <= p2YPos+p2Height)))
	  {
	    if((temp.getXStep())<0)
	    {
	      if((x1 <= (p1XPos + p1Width))&&(x1 >= p1XPos)|| 
		 (x1 <= (p2XPos + p2Width))&&(x1 >= p2XPos))
	      {
		temp.setYStep(stepY * -1);
	      }
	    }
	    // if the ball is travelling from right to left
	    else
	    {
	      if((x1+rad1) >= p1XPos && ((x1+rad1) <= p1XPos+p1Width)|| 
		 (x1+rad1 >= p2XPos) && (((x1+rad1) <= p2XPos+p2Width)))
	      {
		temp.setYStep(stepY * -1);
	      }	        
	    }
	  }
	}
      }
    }
  }

  /*
   * An inner class used to define and handle a thread for each ball
   */
  class BallThread extends Ball implements Runnable 
  {
    int velocity;
        
    public BallThread(int x, int y, int vel, int angle, int diameter,Color c,
		      Applet a) 
    {  
      super(x,y,angle,diameter,c,a);
      velocity = vel;
    } 
    public void bounce()                                                  
      // Start the thread 
    {    new Thread(this).start(); 
    } 
        
    public void run()
      // Thread execution 
    {  
      while(true)
      {
	while(unPaused)
	{  
	  nextStep();
	  paddleCollide(); //checkballposition for each ballthread
	  try { Thread.sleep(velocity); } 
	  catch(InterruptedException e) {}
	}
      }
    }
  } 
  /*
   *An inner class used to define and handle a thread for each paddle   
   */ 
  class PaddleThread extends Paddle implements Runnable 
  {
    public PaddleThread(int xP, int yP, int width, int height,Applet a) 
    {  
      super(xP,yP,width,height,a);
    } 
    public void block()                                                  
      // Start the thread 
    {    new Thread(this).start(); 
    } 
        
    public void run()
      // Thread execution 
    {  
      while(true)
      {
	draw();
	try { Thread.sleep(1); } 
	catch(InterruptedException e) {}
      }
    }
  } 
} 




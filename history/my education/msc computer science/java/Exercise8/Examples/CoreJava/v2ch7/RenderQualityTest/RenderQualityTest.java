/**
   @version 1.01 2001-07-24
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

/**
   This program demonstrates the effect of the various
   rendering hints.
*/
public class RenderQualityTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new RenderQualityTestFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame contains buttons to set rendering hints 
   and an image that is drawn with the selected hints.
*/
class RenderQualityTestFrame extends JFrame
{  
   public RenderQualityTestFrame()
   {  
      setTitle("RenderQualityTest");
      setSize(WIDTH, HEIGHT);

      buttonBox = new JPanel();
      buttonBox.setLayout(new GridLayout(9, 3));
      hints = new RenderingHints(null);

      makeButtons("KEY_ANTIALIASING",
         "VALUE_ANTIALIAS_ON",
         "VALUE_ANTIALIAS_OFF");
      makeButtons("KEY_RENDERING",
         "VALUE_RENDER_QUALITY",
         "VALUE_RENDER_SPEED");
      makeButtons("KEY_DITHERING",
         "VALUE_DITHER_ENABLE",
         "VALUE_DITHER_DISABLE");
      makeButtons("KEY_TEXT_ANTIALIASING",
         "VALUE_TEXT_ANTIALIAS_ON",
         "VALUE_TEXT_ANTIALIAS_OFF");
      makeButtons("KEY_FRACTIONALMETRICS",
         "VALUE_FRACTIONALMETRICS_ON",
         "VALUE_FRACTIONALMETRICS_OFF");
      makeButtons("KEY_ALPHA_INTERPOLATION",
         "VALUE_ALPHA_INTERPOLATION_QUALITY",
         "VALUE_ALPHA_INTERPOLATION_SPEED");
      makeButtons("KEY_COLOR_RENDERING",
         "VALUE_COLOR_RENDER_QUALITY",
         "VALUE_COLOR_RENDER_SPEED");
      makeButtons("KEY_INTERPOLATION",
         "VALUE_INTERPOLATION_NEAREST NEIGHBOR",
         "VALUE_INTERPOLATION_BILINEAR");
      makeButtons("KEY_STROKE_CONTROL",
         "VALUE_STROKE_NORMALIZE",
         "VALUE_STROKE_PURE");

      Container contentPane = getContentPane();
      canvas = new RenderQualityPanel();
      contentPane.add(canvas, BorderLayout.CENTER);
      contentPane.add(buttonBox, BorderLayout.NORTH);
   }

   /**
      Makes a set of buttons for a rendering hint key and values
      @param key the key name
      @param value1 the name of the first value for the key
      @param value2 the name of the second value for the key
   */
   void makeButtons(String key, String value1, String value2)
   {  
      try
      {
         final RenderingHints.Key k = (RenderingHints.Key)
            RenderingHints.class.getField(key).get(null);
         final Object v1 
            = RenderingHints.class.getField(value1).get(null);
         final Object v2
            = RenderingHints.class.getField(value2).get(null);
         JLabel label = new JLabel(key);
         buttonBox.add(label);
         ButtonGroup group = new ButtonGroup();
         JRadioButton b1 = new JRadioButton(value1, true);
         buttonBox.add(b1);
         group.add(b1);
         b1.addActionListener(new 
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  hints.put(k, v1);
                  canvas.setRenderingHints(hints);
               }
         });
         JRadioButton b2 = new JRadioButton(value2, false);
         buttonBox.add(b2);
         group.add(b2);
         b2.addActionListener(new 
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  hints.put(k, v2);
                  canvas.setRenderingHints(hints);
               }
         });
         hints.put(k, v1);
      }
      catch (Exception ex)
      {
      }
   }

   private RenderQualityPanel canvas;
   private JPanel buttonBox;
   private RenderingHints hints;
   private static final int WIDTH = 600;
   private static final int HEIGHT = 500;
}

/**
   This panel produces a drawing that hopefully shows some
   of the difference caused by rendering hints.
*/
class RenderQualityPanel extends JPanel
{  
   public RenderQualityPanel()
   {  
      color1 = new Color(0.7F, 0.7F, 0.0F, 0.5F);
      color2 = new Color(0.0F, 0.3F, 0.3F, 0.5F);
      try
      {
         image = ImageIO.read(new File("clouds.jpg"));
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHints(hints);

      g2.drawImage(image, 0, 0, null);
      g2.draw(new Ellipse2D.Double(0, 0,
         image.getWidth(null), image.getHeight(null)));
      g2.setFont(new Font("Serif", Font.ITALIC, 40));
      g2.drawString("Hello", 75, 75);
      g2.setPaint(color1);
      g2.translate(0,-80);
      g2.fill(new Rectangle2D.Double(100, 100, 200, 100));
      g2.setPaint(color2);
      g2.fill(new Rectangle2D.Double(120, 120, 200, 100));
   }

   /**
      Sets the hints and repaints.
      @param h the rendering hints
   */
   public void setRenderingHints(RenderingHints h)
   {  
      hints = h;
      repaint();
   }

   private RenderingHints hints = new RenderingHints(null);
   private Color color1;
   private Color color2;
   private Image image;
}

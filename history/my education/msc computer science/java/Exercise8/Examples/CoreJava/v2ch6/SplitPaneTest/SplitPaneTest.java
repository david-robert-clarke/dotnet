/**
   @version 1.01 2001-07-22
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   This program demonstrates the split pane component
   organizer.
*/
public class SplitPaneTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new SplitPaneFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame consists of two nested split panes to demonstrate
   planet images and data.
*/
class SplitPaneFrame extends JFrame
{  
   public SplitPaneFrame()
   {  
      setTitle("SplitPaneTest");
      setSize(WIDTH, HEIGHT);

      // set up components for planet names, images, descriptions

      final JList planetList = new JList(planets);
      final JLabel planetImage = new JLabel();
      final JTextArea description = new JTextArea();

      planetList.addListSelectionListener(new
         ListSelectionListener()
         {
            public void valueChanged(ListSelectionEvent event)
            {  
               Planet value 
                  = (Planet)planetList.getSelectedValue();

               // update image and description

               planetImage.setIcon(value.getImage());
               description.setText(value.getDescription());
            }
         });

      // set up split panes

      JSplitPane innerPane
         = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            planetList, planetImage);

      innerPane.setContinuousLayout(true);
      innerPane.setOneTouchExpandable(true);

      JSplitPane outerPane
         = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            innerPane, description);

      getContentPane().add(outerPane, BorderLayout.CENTER);
   }

   private Planet[] planets =
      {  
         new Planet("Mercury", 2440, 0),
         new Planet("Venus", 6052, 0),
         new Planet("Earth", 6378, 1),
         new Planet("Mars", 3397, 2),
         new Planet("Jupiter", 71492, 16),
         new Planet("Saturn", 60268, 18),
         new Planet("Uranus", 25559, 17),
         new Planet("Neptune", 24766, 8),
         new Planet("Pluto", 1137, 1),
      };
   private static final int WIDTH = 300;
   private static final int HEIGHT = 200;
}

/**
   Describes a planet.
*/
class Planet
{ 
   /**
      Constructs a planet.
      @param n the planet name
      @param r the planet radius
      @param m the number of moons
   */
   public Planet(String n, double r, int m)
   {  name = n;
      radius = r;
      moons = m;
      image = new ImageIcon(name + ".gif");
   }

   public String toString()
   {  
      return name;
   }

   /**
      Gets a description of the planet.
      @return the description
   */
   public String getDescription()
   {  
      return "Radius: " + radius + "\nMoons: " + moons + "\n";
   }

   /**
      Gets an image of the planet.
      @return the image
   */
   public ImageIcon getImage()
   {  
      return image;
   }

   private String name;
   private double radius;
   private int moons;
   private ImageIcon image;
}

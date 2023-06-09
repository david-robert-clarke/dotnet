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
   This program demonstrates the tabbed pane component organizer.
*/
public class TabbedPaneTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new TabbedPaneFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame shows a tabbed pane and radio buttons to 
   switch between wrapped and scrolling tab layout.
*/
class TabbedPaneFrame extends JFrame
{  
   public TabbedPaneFrame()
   {  
      setTitle("TabbedPaneTest");
      setSize(WIDTH, HEIGHT);

      final JTabbedPane tabbedPane = new JTabbedPane();
      // we set the components to null and delay their
      // loading until the tab is shown for the first time

      ImageIcon icon = new ImageIcon("yellow-ball.gif");

      tabbedPane.addTab("Mercury", icon, null);
      tabbedPane.addTab("Venus", icon, null);
      tabbedPane.addTab("Earth", icon, null);
      tabbedPane.addTab("Mars", icon, null);
      tabbedPane.addTab("Jupiter", icon, null);
      tabbedPane.addTab("Saturn", icon, null);
      tabbedPane.addTab("Uranus", icon, null);
      tabbedPane.addTab("Neptune", icon, null);
      tabbedPane.addTab("Pluto", icon, null);

      getContentPane().add(tabbedPane, "Center");

      tabbedPane.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {  

               // check if this tab still has a null component

               if (tabbedPane.getSelectedComponent() == null)
               {  
                  // set the component to the image icon

                  int n = tabbedPane.getSelectedIndex();
                  String title = tabbedPane.getTitleAt(n);
                  ImageIcon planetIcon 
                     = new ImageIcon(title + ".gif");
                  tabbedPane.setComponentAt(n, 
                     new JLabel(planetIcon));

                  // indicate that this tab has been 
                  // visited--just for fun

                  tabbedPane.setIconAt(n, 
                     new ImageIcon("red-ball.gif"));
               }
            }
         });

      JPanel buttonPanel = new JPanel();
      ButtonGroup buttonGroup = new ButtonGroup();
      JRadioButton wrapButton = new JRadioButton("Wrap tabs");
      wrapButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               tabbedPane.setTabLayoutPolicy(
                  JTabbedPane.WRAP_TAB_LAYOUT);
            }
         });
      buttonPanel.add(wrapButton);
      buttonGroup.add(wrapButton);
      wrapButton.setSelected(true);
      JRadioButton scrollButton 
         = new JRadioButton("Scroll tabs");
      scrollButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               tabbedPane.setTabLayoutPolicy(
                  JTabbedPane.SCROLL_TAB_LAYOUT);
            }
         });
      buttonPanel.add(scrollButton);
      buttonGroup.add(scrollButton);
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);
   }

   private static final int WIDTH = 400;
   private static final int HEIGHT = 300;
}


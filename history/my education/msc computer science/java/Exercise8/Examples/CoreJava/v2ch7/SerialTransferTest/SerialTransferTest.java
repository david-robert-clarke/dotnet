/**
   @version 1.00 2001-08-11
   @author Cay Horstmann
*/

import java.io.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
   This program demonstrates the transfer of serialized objects
   between virtual machines.
*/
public class SerialTransferTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new SerialTransferFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame contains a color chooser, and copy and 
   paste buttons.
*/
class SerialTransferFrame extends JFrame
{  
   public SerialTransferFrame()
   {  
      setTitle("SerialTransferTest");

      Container contentPane = getContentPane();

      chooser = new JColorChooser();
      contentPane.add(chooser, BorderLayout.CENTER);
      JPanel panel = new JPanel();

      JButton copyButton = new JButton("Copy");
      panel.add(copyButton);
      copyButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               copy();
            }
         });

      JButton pasteButton = new JButton("Paste");
      panel.add(pasteButton);
      pasteButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               paste();
            }
         });

      contentPane.add(panel, BorderLayout.SOUTH);
      pack();
   }

   /**
      Copies the chooser's color into the system clipboard.
   */
   private void copy()
   {  
      Clipboard clipboard
         = Toolkit.getDefaultToolkit().getSystemClipboard();
      Color color = chooser.getColor();
      SerialSelection selection = new SerialSelection(color);
      clipboard.setContents(selection, null);
   }

   /**
      Pastes the color from the system clipboard into the 
      chooser.
   */
   private void paste()
   {  
      Clipboard clipboard
         = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable contents = clipboard.getContents(null);
      if (contents == null) return;
      try
      {  
         DataFlavor flavor = new DataFlavor(
"application/x-java-serialized-object;class=java.awt.Color");
         if (contents.isDataFlavorSupported(flavor))
         {  
            Color color 
               = (Color)contents.getTransferData(flavor);
            chooser.setColor(color);
         }
      }
      catch(ClassNotFoundException exception)
      {  
         JOptionPane.showMessageDialog(this, exception);
      }
      catch(UnsupportedFlavorException exception)
      {  
         JOptionPane.showMessageDialog(this, exception);
      }
      catch(IOException exception)
      {  
         JOptionPane.showMessageDialog(this, exception);
      }
   }

   private JColorChooser chooser;
}

/**
   This class is a wrapper for the data transfer of 
   serialized objects.
*/
class SerialSelection implements Transferable 
{
   /**
      Constructs the selection.
      @param o any serializable object 
   */   
   SerialSelection(Serializable o) 
   {
      obj = o;
   }

   public DataFlavor[] getTransferDataFlavors() 
   {
      DataFlavor[] flavors = new DataFlavor[2];
      Class type = obj.getClass();
      String mimeType 
         = "application/x-java-serialized-object;class=" 
         + type.getName();
      try 
      {
         flavors[0] = new DataFlavor(mimeType);
         flavors[1] = DataFlavor.stringFlavor;
         return flavors;
      } 
      catch (ClassNotFoundException exception) 
      {
         return new DataFlavor[0];
      }
   }

   public boolean isDataFlavorSupported(DataFlavor flavor) 
   {
      return 
         DataFlavor.stringFlavor.equals(flavor)
         || "application".equals(flavor.getPrimaryType()) 
         && "x-java-serialized-object".equals(
            flavor.getSubType()) 
         && flavor.getRepresentationClass().isAssignableFrom(
            obj.getClass());   
   }

   public Object getTransferData(DataFlavor flavor) 
      throws UnsupportedFlavorException
   {
      if (!isDataFlavorSupported(flavor)) 
         throw new UnsupportedFlavorException(flavor);

      if (DataFlavor.stringFlavor.equals(flavor))
         return obj.toString();

      return obj;
   }
   
   private Serializable obj;
}

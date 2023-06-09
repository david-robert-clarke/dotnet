/**
   @version 1.01 2001-05-25
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   A program to test a progress monitor input stream.
*/
public class ProgressMonitorInputStreamTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new TextFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   A frame with a menu to load a text file and a text area
   to display its contents. The text area is constructed 
   when the file is loaded and set as the content pane of 
   the frame when the loading is complete. That avoids flicker
   during loading.
*/
class TextFrame extends JFrame
{  
   public TextFrame()
   {  
      setTitle("ProgressMonitorInputStreamTest");
      setSize(WIDTH, HEIGHT);

      // set up menu

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu fileMenu = new JMenu("File");
      menuBar.add(fileMenu);
      openItem = new JMenuItem("Open");
      openItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               try
               {
                  openFile();
               }
               catch(IOException exception)
               {  
                  exception.printStackTrace();
               }
            }
         });

      fileMenu.add(openItem);
      exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);
   }

   /**
      Prompts the user to select a file, loads the file into
      a text area, and sets it as the content pane of the frame.
   */
   public void openFile() throws IOException
   {  
      JFileChooser chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));
      chooser.setFileFilter(
         new javax.swing.filechooser.FileFilter()
            {  
               public boolean accept(File f)
               {  
                  String fname = f.getName().toLowerCase();
                  return fname.endsWith(".txt")
                     || f.isDirectory();
               }
               public String getDescription()
               { 
                  return "Text Files"; 
               }
            });

      int r = chooser.showOpenDialog(this);
      if (r != JFileChooser.APPROVE_OPTION) return;
      final File f = chooser.getSelectedFile();

      // set up stream and reader filter sequence
      
      FileInputStream fileIn = new FileInputStream(f);
      ProgressMonitorInputStream progressIn
         = new ProgressMonitorInputStream(this,
            "Reading " + f.getName(), fileIn);
      InputStreamReader inReader
         = new InputStreamReader(progressIn);
      final BufferedReader in = new BufferedReader(inReader);
      
      // the monitored activity must be in a new thread. 

      Thread readThread = new Thread()
      {  
         public void run()
         {             
            try
            {
               final JTextArea textArea = new JTextArea();  

               String line;
               while ((line = in.readLine()) != null)
               {
                  textArea.append(line);
                  textArea.append("\n");
               }
               in.close();

               // set content pane in the event dispatch thread
               EventQueue.invokeLater(new 
                  Runnable()
                  {  
                     public void run()
                     {  
                        setContentPane(new JScrollPane(textArea));
                        validate();
                     }
                  });
               
            }
            catch(IOException exception)
            {  
               exception.printStackTrace();
            }
         }
      };

      readThread.start();
   }

   private JMenuItem openItem;
   private JMenuItem exitItem;

   public static final int WIDTH = 300;
   public static final int HEIGHT = 200;
}


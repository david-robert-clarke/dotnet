import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;



public class Demo  extends JFrame 
{
  public Demo()
  {
    // Create the frame
    String title = "Frame Title";
    JFrame frame = new JFrame(title);
    
    // Create a component to add to the frame
    JComponent comp = new JTextArea();
    
    // Add the component to the frame's content pane;
    // by default, the content pane has a border layout
    frame.getContentPane().add(comp, BorderLayout.CENTER);
    
    // Show the frame
    int width = 300;
    int height = 300;
    frame.setSize(width, height);
    frame.setVisible(true);
  }
  
  public static void main(String args[])
  {
    Demo thisDemo = new Demo();
    /*
    Class driver = Class.forName("org.postgresql.Driver");
    DriverManager.registerDriver((Driver)driver.newInstance());
    
    // get the values required to connect to the database.
    
    String dbname = dbField.getText();
    String username = userField.getText();
    String pw = passwordField.getText();
    
    // the elements of the database connection url are
    // protocol (jdbc:), subprotocol (postgresql:), 
    // server (//dbhost), and database name (/<dbname>)
    
    String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
    
    Connection c = DriverManager.getConnection(dbUrl, username, pw);
    */
  }
  
}

   
   




package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   Log-In Screen for Staff and Managers 
   
   @author David Clarke 
**/
public class NewPasswordUI
{
    public static void main(String args[])
    {
        NewPasswordFrame frame = new NewPasswordFrame();
        frame.setTitle("Change Password");
        frame.setSize(300,300);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);        
    }
}

class NewPasswordFrame extends JFrame
{  
  private JLabel newPasswordLabel, passwordLabel, blankLabel;
  private JTextField newPasswordField, passwordField;
  private JButton okayButton, cancelButton;
  private String username, password;

  //constructor
  public NewPasswordFrame()
  {
    blankLabel = new JLabel();
    newPasswordLabel = new JLabel("New Password ");
    newPasswordField = new JPasswordField();
    passwordLabel = new JLabel("Re-enter New Password: ");
    passwordField = new JPasswordField();
    okayButton = new JButton("Confirm");
    okayButton.addActionListener(new ButtonListener0());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener1());
	

    //contentPane

    JPanel blankPanel = new JPanel();        
    blankPanel.add(blankLabel);
    blankPanel.add(blankLabel);

    JPanel loginPasswordPanel = new JPanel();
    loginPasswordPanel.setLayout(new GridLayout(4,2));
               
    loginPasswordPanel.add(newPasswordLabel);
    loginPasswordPanel.add(newPasswordField);
    loginPasswordPanel.add(passwordLabel);
    loginPasswordPanel.add(passwordField);

    loginPasswordPanel.add(blankLabel);
    loginPasswordPanel.add(blankLabel);
    loginPasswordPanel.add(blankLabel);
    loginPasswordPanel.add(blankLabel);
       
        
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));//column, tuples
    buttonPanel.add(okayButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(blankPanel, "North");
    contentPane.add(loginPasswordPanel, "Center");
    contentPane.add(buttonPanel, "South");
	
  }

  private class ButtonListener0 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      
      System.out.println("I'm in the okayButton Section");	
      username = newPasswordField.getText();
      password = passwordField.getText();
    }   
  }

  private class ButtonListener1 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {      
      System.out.println("I'm in the cancel button section");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }   
  }
  
}

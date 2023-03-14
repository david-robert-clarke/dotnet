package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   Log-In Screen for Staff and Managers 
   
   @author David Clarke 
**/
public class LogIn extends JFrame
{  
  private JLabel userNameLabel, passwordLabel, blankLabel;
  private JTextField userNameField, passwordField;
  private JButton okayButton, cancelButton;
  private String username, password;

  //constructor
  public LogIn()
  {
    blankLabel = new JLabel();
    userNameLabel = new JLabel("Login: ");
    userNameField = new JTextField();
    passwordLabel = new JLabel("Password: ");
    passwordField = new JPasswordField();
    okayButton = new JButton("OK");
    okayButton.addActionListener(new ButtonListener0());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener1());
	

    //contentPane

    JPanel blankPanel = new JPanel();        
    blankPanel.add(blankLabel);
    blankPanel.add(blankLabel);

    JPanel loginPasswordPanel = new JPanel();
    loginPasswordPanel.setLayout(new GridLayout(4,2));
               
    loginPasswordPanel.add(userNameLabel);
    loginPasswordPanel.add(userNameField);
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
      username = userNameField.getText();
      password = passwordField.getText();
      MyConnection connect = new MyConnection();

      //open up the staff interface
      StaffUI staffUI = new StaffUI();
      staffUI.setSize(500,500);
      staffUI.setTitle("Staff/Managerial Options");
      staffUI.setLocation(500,350);
      staffUI.show();
      staffUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      staffUI.setResizable(false);
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


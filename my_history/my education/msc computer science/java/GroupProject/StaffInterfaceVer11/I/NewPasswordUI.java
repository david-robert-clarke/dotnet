package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   Log-In Screen for Staff and Managers 
   
   @author David Clarke 
**/
public class NewPasswordUI extends JFrame
{  
  private String sid;
  private JLabel newPasswordLabel, confirmPasswordLabel, blankLabel;
  private JTextField newPasswordField, confirmPasswordField;
  private JButton okayButton, cancelButton;
  private String newPassword, confirmPassword;

  //constructor
  public NewPasswordUI(String staffID)
  {
    sid = staffID;
    blankLabel = new JLabel();
    newPasswordLabel = new JLabel("New Password ");
    newPasswordField = new JPasswordField();
    confirmPasswordLabel = new JLabel("Re-enter New Password: ");
    confirmPasswordField = new JPasswordField();
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
    loginPasswordPanel.add(confirmPasswordLabel);
    loginPasswordPanel.add(confirmPasswordField);

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

  private class ButtonListener0 implements ActionListener //confirm
  {
    public void actionPerformed (ActionEvent event)
    {      
      System.out.println("I'm in the okayButton Section");	
      newPassword = newPasswordField.getText();
      confirmPassword = confirmPasswordField.getText();
      
      if(newPassword.equals(confirmPassword))//both match
      {
	EditStaffPWQuery thisQuery = new EditStaffPWQuery(sid, newPassword);
	thisQuery.exeQuery();	
      }   
      
      //else print out error type in again, use at a later date

      dispose();
    }
  }
  

  private class ButtonListener1 implements ActionListener //cancel
  {
    public void actionPerformed (ActionEvent event)
    {      
      System.out.println("I'm in the cancel button section");
      dispose();//use this to dispose current window
    }   
  }
  
}

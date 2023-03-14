package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
   Swing application that allows the user to change and confirm the change
   of their password
   
   @author David Clarke 
**/
public class NewPasswordUI extends JFrame
{
  private JFrame frame;
  private String sid;
  private JLabel newPasswordLabel, confirmPasswordLabel;
  private JTextField newPasswordField, confirmPasswordField;
  private JButton okayButton, cancelButton;
  private String newPassword, confirmPassword;

  /**
   * Constructor to create a new password user interface
   *
   * @param supplierName the supplierName
   **/
  public NewPasswordUI(String staffID)
  {
    sid = staffID;
    newPasswordLabel = new JLabel("New Password ");
    newPasswordField = new JPasswordField();
    confirmPasswordLabel = new JLabel("Re-enter New Password: ");
    confirmPasswordField = new JPasswordField();
    okayButton = new JButton("Confirm");
    okayButton.addActionListener(new ButtonListener0());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener1());
	
    JPanel loginPasswordPanel = new JPanel();
    loginPasswordPanel.setLayout(new GridLayout(2,1));
               
    loginPasswordPanel.add(newPasswordLabel);
    loginPasswordPanel.add(newPasswordField);
    loginPasswordPanel.add(confirmPasswordLabel);
    loginPasswordPanel.add(confirmPasswordField);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));//column, tuples
    buttonPanel.add(okayButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(loginPasswordPanel, "Center");
    contentPane.add(buttonPanel, "South");
	
  }

  private class ButtonListener0 implements ActionListener //confirm
  {
    public void actionPerformed (ActionEvent event)
    {	
      newPassword = newPasswordField.getText();
      confirmPassword = confirmPasswordField.getText();
      
      if(newPassword.equals(confirmPassword))//both match
      {
	EditStaffPWQuery thisQuery = new EditStaffPWQuery(sid, newPassword);
	thisQuery.exeQuery();
	dispose();	
      }   
      else //else print out error, type in again
          {
              JOptionPane.showMessageDialog(frame,"Passwords do not match. Please Re-enter");
          }
    }
  }
  

  private class ButtonListener1 implements ActionListener //cancel
  {
    public void actionPerformed (ActionEvent event)
    {
      dispose();//use this to dispose current window
    }   
  }
  
}

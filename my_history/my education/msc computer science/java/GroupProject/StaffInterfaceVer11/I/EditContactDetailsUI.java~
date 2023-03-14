package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Edit Stock Interface
   
   This allows a staff member to update 
   <ul>
   <il>the retail price of the cds
   <il>the number of stocked items of a particulr cd
   <il>the wholesale price of stock for a particular supplier
   <il>the supplier
   </ul>
**/
class EditContactDetailsUI extends JFrame
{    
  //instance variables
  ArrayList cdEntry = new ArrayList();
  JLabel blankLabel0;
  JLabel blankLabel1;
  JLabel titleLabel;
  JLabel firstNameLabel;   
  JTextField firstNameTextField;
  JLabel lastNameLabel;
  JTextField lastNameTextField;
  JLabel streetLabel;
  JTextField streetTextField;
  JLabel cityLabel;
  JTextField cityTextField;
  JLabel postCodeLabel;
  JTextField postCodeTextField;
  JLabel homePhoneLabel;
  JTextField homePhoneTextField;
  JLabel mobilePhoneLabel;
  JTextField mobilePhoneTextField;

  JPanel editPanel;
  JPanel buttonPanel;
  JButton confirmButton, cancelButton;

  //constructor
  public EditContactDetailsUI()
  {

    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(17,1));
    titleLabel = new JLabel("Enter your new Personal details below");
    firstNameLabel = new JLabel("First Name");   
    firstNameTextField = new JTextField();
    lastNameLabel = new JLabel("Last Name");
    lastNameTextField = new JTextField();
    streetLabel = new JLabel("House No. and Street");
    streetTextField = new JTextField();
    cityLabel = new JLabel("City");
    cityTextField = new JTextField();
    postCodeLabel = new JLabel ("Post Code");
    postCodeTextField = new JTextField();
    homePhoneLabel = new JLabel("Home Phone Number:");
    homePhoneTextField = new JTextField();
    mobilePhoneLabel = new JLabel("Mobile Phone Number:");
    mobilePhoneTextField = new JTextField();

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
    editPanel.add(firstNameLabel);
    editPanel.add(firstNameTextField);
    editPanel.add(lastNameLabel);
    editPanel.add(lastNameTextField);
    editPanel.add(streetLabel);
    editPanel.add(streetTextField);
    editPanel.add(cityLabel);
    editPanel.add(cityTextField);
    editPanel.add(postCodeLabel);
    editPanel.add(postCodeTextField);
    editPanel.add(homePhoneLabel);
    editPanel.add(homePhoneTextField);
    editPanel.add(mobilePhoneLabel);
    editPanel.add(mobilePhoneTextField);
    editPanel.add(blankLabel1);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ButtonListener());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    buttonPanel.add(confirmButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      
      if(source == confirmButton)
      {
	System.out.println("confirm");
      }
      else if(source == cancelButton)
      {
	System.out.println("cancelled");
      }
      
    }      
  }

}

package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Edit Contact Details Interface
   
   This allows a staff member to update 
   <ul>
   <il>their first and last name
   <il>their address
   <il>their post code
   <il>their phone numbers
   </ul>
**/
class EditContactDetailsUI extends JFrame
{    
  //instance variables
  String sid;
  ArrayList staffEntry;

  String staffFirstName, staffLastName, staffAddress, staffCity;
  String staffPCode,staffMobPhone, staffHousePhone;
  
  //panel containing all the editable data
  JPanel editPanel;
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

  //panel that contains the confirm and cancel buttons
  JPanel buttonPanel;
  JButton confirmButton, cancelButton;

  //constructor
  public EditContactDetailsUI(String staffID)
  {
    sid = staffID;
    staffEntry = new ArrayList();

    //get an entry from the staff table that has this sid
    GetStaffEntryQuery thisQuery = new GetStaffEntryQuery(sid);
    staffEntry = thisQuery.exeQuery();

    staffFirstName = (String)staffEntry.get(0);
    staffLastName = (String)staffEntry.get(1);
    staffAddress = (String)staffEntry.get(2);
    staffCity = (String)staffEntry.get(3);
    staffPCode = (String)staffEntry.get(4);
    staffMobPhone = (String)staffEntry.get(5);
    staffHousePhone = (String) staffEntry.get(6);   
    

    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(17,1));
    titleLabel = new JLabel("Enter your NEW personal details below");
    firstNameLabel = new JLabel("First Name");   
    firstNameTextField = new JTextField(staffFirstName);
    lastNameLabel = new JLabel("Last Name");
    lastNameTextField = new JTextField(staffLastName);
    streetLabel = new JLabel("House No. and Street");
    streetTextField = new JTextField(staffAddress);
    cityLabel = new JLabel("City");
    cityTextField = new JTextField(staffCity);
    postCodeLabel = new JLabel ("Post Code");
    postCodeTextField = new JTextField(staffPCode);
    homePhoneLabel = new JLabel("Home Phone Number:");
    homePhoneTextField = new JTextField(staffHousePhone);
    mobilePhoneLabel = new JLabel("Mobile Phone Number:");
    mobilePhoneTextField = new JTextField(staffMobPhone);

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
    editPanel.add(mobilePhoneLabel);
    editPanel.add(mobilePhoneTextField);
    editPanel.add(homePhoneLabel);
    editPanel.add(homePhoneTextField);
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
	
	staffEntry.clear();//clear arraylist staffEntry
	//get data from form
	//save back into the arraylist staffEntry
	staffEntry.add(sid);
	staffEntry.add(firstNameTextField.getText());
	staffEntry.add(lastNameTextField.getText());
	staffEntry.add(streetTextField.getText());
	staffEntry.add(cityTextField.getText());
	staffEntry.add(postCodeTextField.getText());
	staffEntry.add(homePhoneTextField.getText());
	staffEntry.add(mobilePhoneTextField.getText());

	//make a new query that takes the arraylist and updates the
	//data in the staff table
	UpdateStaffEntryQuery thisQuery =new UpdateStaffEntryQuery(staffEntry);
	System.out.println("I'm after the query initialisation");
	thisQuery.exeQuery();
	System.out.println("I'm after the query execution");
	dispose();
	
	
      }
      else if(source == cancelButton)
      {
	dispose();
      }
      
    }      
  }

}

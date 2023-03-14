package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

/**
   The Add Staff Interface
   
   This allows a manager to add a new staff entry, 
   this class automatically updates the Staff Tables

**/
class EditStaffUI extends JFrame
{ 
  private JFrame frame;
  private String sid;
  private String staffFirstName;
  private String staffLastName;
  private String staffAddr1;
  private String staffAddr2; 
  private String staffPcode; 
  private String staffPhone;
  private String staffMPhone;
  private String staffPosition;
  private String staffPassword;
  private JLabel blankLabel0, blankLabel1;
  private JLabel titleLabel;
  private JLabel sidLabel;
  private JLabel staffFirstNameLabel;
  private JLabel staffLastNameLabel;
  private JLabel staffStreetLabel;
  private JLabel staffCityLabel;  
  private JLabel staffPCodeLabel;
  private JLabel staffPhoneNumberLabel;
  private JLabel staffMPhoneNumberLabel;
  private JLabel staffPositionLabel;
  private JLabel staffPasswordLabel;
  private JTextField sidTextField;
  private JTextField staffFirstNameTextField;  
  private JTextField staffLastNameTextField;
  private JTextField staffStreetTextField; 
  private JTextField staffCityTextField;
  private JTextField staffPCodeTextField;
  private JTextField staffPhoneNumberTextField;
  private JTextField staffMPhoneNumberTextField;
  private JTextField staffPositionTextField;
  private JTextField staffPasswordTextField;
  private JButton cancelButton;
  private JButton okayButton;
  
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  ArrayList staffEntry;

  //Constructor
  public EditStaffUI(String sLastName)
  {
    staffLastName = sLastName;
    GetStaffDetailsQuery sDQuery = new GetStaffDetailsQuery(sLastName);
    staffEntry = sDQuery.exeQuery();
    sid = (String)staffEntry.get(0);
    staffFirstName = (String)staffEntry.get(1);
    staffLastName = (String)staffEntry.get(2);
    staffAddr1 = (String)staffEntry.get(3);
    staffAddr2 = (String)staffEntry.get(4); 
    staffPcode = (String)staffEntry.get(5); 
    staffPhone = (String)staffEntry.get(6);
    staffMPhone = (String)staffEntry.get(7);
    staffPosition = (String)staffEntry.get(8);
    staffPassword = (String)staffEntry.get(9);
    
    //Use a query that gets all the staff info for a given 
    //staff
    //staffEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(15,1));
    titleLabel = new JLabel("Enter new Staff details:");  
    sidLabel = new JLabel("Staff Identification Number:");
    sidTextField = new JTextField(sid);
    sidTextField.setEnabled(false);
    staffFirstNameLabel = new JLabel("Staff First Name:");
    staffFirstNameTextField = new JTextField(staffFirstName);
    staffFirstNameTextField.setEnabled(false);
    staffLastNameLabel = new JLabel("Staff Last Name:");
    staffLastNameTextField = new JTextField(staffLastName);
    staffLastNameTextField.setEnabled(false);
    staffStreetLabel = new JLabel("Street Name:");
    staffStreetTextField = new JTextField(staffAddr1);
    staffCityLabel = new JLabel("City:");
    staffCityTextField = new JTextField(staffAddr2);
    staffPCodeLabel = new JLabel("Post Code:");
    staffPCodeTextField = new JTextField(staffPcode);
    staffPhoneNumberLabel = new JLabel("Home Number:");
    staffPhoneNumberTextField = new JTextField(staffPhone);
    staffMPhoneNumberLabel = new JLabel("Mobile Number:");
    staffMPhoneNumberTextField = new JTextField(staffMPhone);
    staffPositionLabel = new JLabel("Position:");
    staffPositionTextField = new JTextField(staffPosition);
    staffPasswordLabel = new JLabel("Password:");
    staffPasswordTextField = new JTextField(staffPassword);
    

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
    editPanel.add(sidLabel);
    editPanel.add(sidTextField);
    editPanel.add(staffFirstNameLabel);
    editPanel.add(staffFirstNameTextField);
    editPanel.add(staffLastNameLabel);
    editPanel.add(staffLastNameTextField);
    editPanel.add(staffStreetLabel);
    editPanel.add(staffStreetTextField);
    editPanel.add(staffCityLabel);
    editPanel.add(staffCityTextField);
    editPanel.add(staffPCodeLabel);
    editPanel.add(staffPCodeTextField);
    editPanel.add(staffPhoneNumberLabel);
    editPanel.add(staffPhoneNumberTextField);
    editPanel.add(staffMPhoneNumberLabel);
    editPanel.add(staffMPhoneNumberTextField);
    editPanel.add(staffPositionLabel);
    editPanel.add(staffPositionTextField);
    editPanel.add(staffPasswordLabel);
    editPanel.add(staffPasswordTextField);
    editPanel.add(blankLabel1);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    okayButton = new JButton("OK");
    okayButton.addActionListener(new ButtonListener());
    buttonPanel.add(cancelButton);
    buttonPanel.add(okayButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      
      if(source == okayButton)
      {
	
	//if the okay button has been pressed, take all information present
	//on the Edit CD details page and overwrite the details present in the
	//staffEntry ArrayList(excluding the iid),
	staffEntry.set(0,sidTextField.getText());
	staffEntry.set(1,staffFirstNameTextField.getText());
	staffEntry.set(2,staffLastNameTextField.getText());
	staffEntry.set(3,staffStreetTextField.getText());
	staffEntry.set(4,staffCityTextField.getText());
	staffEntry.set(5,staffPCodeTextField.getText());
	staffEntry.set(6,staffPhoneNumberTextField.getText());
	staffEntry.set(7,staffMPhoneNumberTextField.getText());
	staffEntry.set(8,staffPositionTextField.getText());
	staffEntry.set(9,staffPasswordTextField.getText());
	
	int numberOfErrors = 0;
	if(sidTextField.getText().equals(""))numberOfErrors++;
	if(staffFirstNameTextField.getText().equals(""))numberOfErrors++;
	if(staffLastNameTextField.getText().equals(""))numberOfErrors++;
	if(staffStreetTextField.getText().equals(""))numberOfErrors++;
	if(staffCityTextField.getText().equals(""))numberOfErrors++;
	if(staffPCodeTextField.getText().equals(""))numberOfErrors++;
	if(staffPhoneNumberTextField.getText().equals(""))numberOfErrors++;
	if(staffMPhoneNumberTextField.getText().equals(""))numberOfErrors++;
	if(staffPositionTextField.getText().equals(""))numberOfErrors++;
	if(staffPasswordTextField.getText().equals(""))numberOfErrors++;

	
	if(numberOfErrors ==0)
	{
	  //pass this arrayList directly to the UpdateStaffEntryQuery class
	  //new java query, which adds a tuple to the database      
	  UpdateStaffEntryQuery upStaff =new UpdateStaffEntryQuery(staffEntry);
	  upStaff.exeQuery();
	  
	  //Then exit this window
	  dispose();
	}
	else
	{
	  JOptionPane.showMessageDialog(frame,"Data Missing");
	}
	
      }
      else if(source == cancelButton)
      {
	dispose();
      }
      
    }      
  }
}

package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Add Staff Interface
   
   This allows a staff manager to add a new staff entry, 
   this class automatically updates the Staff Tables

**/
class AddStaffUI extends JFrame
{
  private JLabel staffFirstNameLabel;
  private JLabel staffLastNameLabel;
  private JLabel staffStreetLabel;
  private JLabel staffCityLabel;  
  private JLabel staffPCodeLabel;
  private JLabel staffPhoneNumberLabel;
  private JLabel staffMPhoneNumberLabel;
  private JLabel staffPositionLabel;
  private JLabel staffPasswordLabel;
  
  private JTextField staffFirstNameTextField;
  private JTextField staffLastNameTextField;
  private JTextField staffStreetTextField; 
  private JTextField staffCityTextField;
  private JTextField staffPCodeTextField;
  private JTextField staffPhoneNumberTextField;
  private JTextField staffMPhoneNumberTextField;
  private JTextField staffPositionTextField;
  private JTextField staffPasswordTextField;

  //ArrayList
  ArrayList staffEntry;

  //Labels
  JLabel blankLabel0, blankLabel1;
  JLabel titleLabel;

  //Panels
  JPanel editPanel;
  JPanel buttonPanel;

//Buttons
  JButton cancelButton, okayButton;

//constructor
  public AddStaffUI()
  {
    staffEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(13,1));
    titleLabel = new JLabel("Enter new Staff details:");    
    staffFirstNameLabel = new JLabel("Staff First Name:");
    staffFirstNameTextField = new JTextField();
    staffLastNameLabel = new JLabel("Staff Last Name:");
    staffLastNameTextField = new JTextField();
    staffStreetLabel = new JLabel("Street:");
    staffStreetTextField = new JTextField();;
    staffCityLabel = new JLabel("City:");
    staffCityTextField = new JTextField();
    staffPCodeLabel = new JLabel("Post Code:");
    staffPCodeTextField = new JTextField();
    staffPhoneNumberLabel = new JLabel("Home Number:");
    staffPhoneNumberTextField = new JTextField();
    staffMPhoneNumberLabel = new JLabel("Mobile Number:");
    staffMPhoneNumberTextField = new JTextField();
    staffPositionLabel = new JLabel("Position");
    staffPositionTextField = new JTextField();
    staffPasswordLabel = new JLabel("Password");
    staffPasswordTextField = new JTextField();

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
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
	//on the staff details page and overwrite the details present in the
	//staffEntry ArrayList(excluding the iid),

	staffEntry.add(staffFirstNameTextField.getText());
	staffEntry.add(staffLastNameTextField.getText());
	staffEntry.add(staffStreetTextField.getText());
	staffEntry.add(staffCityTextField.getText());
	staffEntry.add(staffPCodeTextField.getText());
	staffEntry.add(staffPhoneNumberTextField.getText());
	staffEntry.add(staffMPhoneNumberTextField.getText());
	staffEntry.add(staffPositionTextField.getText());
	staffEntry.add(staffPasswordTextField.getText());

	//pass this arrayList directly to the AddStaffQuery class
	//new java query, which adds a tuple to the database      
	AddStaffQuery addstaff = new AddStaffQuery(staffEntry);	
	addstaff.exeQuery();
	
	//Then exit this window
	dispose();
      }
      else if(source == cancelButton)
      {
	dispose();
      }
      
    }      
  }
}

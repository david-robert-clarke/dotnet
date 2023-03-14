package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

/**
   The Add Staff Interface
   
   This allows a staff manager to add a new staff entry, 
   this class automatically updates the Staff Tables
   @author Helen Loynes

**/
class AddStaffUI extends JFrame
{
  private String[] position = {"Staff","Manager"};

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
  private JComboBox staffComboBox;
  private JTextField staffPasswordTextField;

  //ArrayList
  private ArrayList staffEntry;

  //Frame
  private JFrame frame;

  //Panels
  private JPanel editPanel;
  private JPanel buttonPanel;

  //Buttons
  private JButton cancelButton, okayButton;

  //constructor
  public AddStaffUI()
  {
    staffEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(9,1));  
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
    //staffPositionTextField = new JTextField();
    staffPasswordLabel = new JLabel("Password");
    staffPasswordTextField = new JTextField();

    staffComboBox = new JComboBox(position);
    //staffComboBox.addActionListener(new ChoiceListener());

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
    editPanel.add(staffComboBox);
    editPanel.add(staffPasswordLabel);
    editPanel.add(staffPasswordTextField);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    okayButton = new JButton("OK");
    okayButton.addActionListener(new ButtonListener());
    buttonPanel.add(okayButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  //public class ChoiceListener implements ActionListener
  //{
  //public void actionPerformed(ActionEvent event)
  //{
      

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
	staffEntry.add(staffComboBox.getSelectedItem());
	staffEntry.add(staffPasswordTextField.getText());

	int numberOfErrors = 0;
	if(staffFirstNameTextField.getText().equals(""))numberOfErrors++;
	if(staffLastNameTextField.getText().equals(""))numberOfErrors++;
	if(staffStreetTextField.getText().equals(""))numberOfErrors++;
	if(staffCityTextField.getText().equals(""))numberOfErrors++;
	if(staffPCodeTextField.getText().equals(""))numberOfErrors++;
	if(staffPhoneNumberTextField.getText().equals(""))numberOfErrors++;
	if(staffMPhoneNumberTextField.getText().equals(""))numberOfErrors++;
	if(staffPasswordTextField.getText().equals(""))numberOfErrors++;
	
	if(numberOfErrors == 0)
	{
	  //pass this arrayList directly to the AddStaffQuery class
	  //new java query, which adds a tuple to the database      
	  AddStaffQuery addstaff = new AddStaffQuery(staffEntry);	
	  addstaff.exeQuery();
	  
	  //Then exit this window
	  dispose();
	}
	else
	{
	  JOptionPane.showMessageDialog(frame,"Blank Fields");
	}	
      }
      else if(source == cancelButton)
      {
	dispose();
      }
      
    }      
  }
}

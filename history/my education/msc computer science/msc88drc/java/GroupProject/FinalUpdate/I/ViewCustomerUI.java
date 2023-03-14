package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The View Customer Interface
   
   This allows a staff member to view an existing customer entry 
   
   @author Helen Loynes
**/
class ViewCustomerUI extends JFrame
{ 
  //Strings
  private String cid;
  private String cfirstname;
  private String clastname;
  private String email;
  private String home_addr1; 
  private String home_addr2;
  private String home_pcode;
  private String cphone;
  private String mob_phone;

  //JLabels
  private JLabel cidLabel;
  private JLabel customerFirstNameLabel;
  private JLabel customerLastNameLabel;
  private JLabel customerStreetLabel;
  private JLabel customerCityLabel;  
  private JLabel customerPCodeLabel;
  private JLabel customerPhoneNumberLabel;
  private JLabel customerMPhoneNumberLabel;

  //JTextFields
  private JTextField cidTextField;
  private JTextField customerFirstNameTextField;  
  private JTextField customerLastNameTextField; 
  private JTextField customerStreetTextField; 
  private JTextField customerCityTextField;
  private JTextField customerPCodeTextField;
  private JTextField customerPhoneNumberTextField;
  private JTextField customerMPhoneNumberTextField;

  //JButtons
  private JButton closeButton;
  
  //JPanels
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  ArrayList customerEntry;

  /**
   * Constructor to view details of an existing customer
   *
   * @param cName the customers last name
   **/
  public ViewCustomerUI(String cID)
  {
    cid = cID;
    GetCustomerDetailsQuery cDQuery = new GetCustomerDetailsQuery(cid);
    customerEntry = cDQuery.exeQuery();  
    cfirstname = (String)customerEntry.get(0);
    clastname = (String)customerEntry.get(1);
    home_addr1 = (String)customerEntry.get(2);
    home_addr2 = (String)customerEntry.get(3); 
    home_pcode = (String)customerEntry.get(4); 
    cphone = (String)customerEntry.get(5);
    mob_phone = (String)customerEntry.get(6);
    
    //Use a query that gets all the customer info for a given 
    //customer
    //customerEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    //blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(8,1));  
    cidLabel = new JLabel("Customer ID:");
    cidTextField = new JTextField(cid);
    cidTextField.setEnabled(false);
    customerFirstNameLabel = new JLabel("First Name:");
    customerFirstNameTextField = new JTextField(cfirstname);
    customerFirstNameTextField.setEnabled(false);
    customerLastNameLabel = new JLabel("Last Name:");
    customerLastNameTextField = new JTextField(clastname);
    customerLastNameTextField.setEnabled(false);
    customerStreetLabel = new JLabel("Street:");
    customerStreetTextField = new JTextField(home_addr1);
    customerStreetTextField.setEnabled(false);
    customerCityLabel = new JLabel("City:");
    customerCityTextField = new JTextField(home_addr2);
    customerCityTextField.setEnabled(false);
    customerPCodeLabel = new JLabel("Post Code:");
    customerPCodeTextField = new JTextField(home_pcode);
    customerPCodeTextField.setEnabled(false);
    customerPhoneNumberLabel = new JLabel("Home No:");
    customerPhoneNumberTextField = new JTextField(cphone);
    customerPhoneNumberTextField.setEnabled(false);
    customerMPhoneNumberLabel = new JLabel("Mobile No:");
    customerMPhoneNumberTextField = new JTextField(mob_phone);
    customerMPhoneNumberTextField.setEnabled(false);

    editPanel.add(cidLabel);
    editPanel.add(cidTextField);
    editPanel.add(customerFirstNameLabel);
    editPanel.add(customerFirstNameTextField);
    editPanel.add(customerLastNameLabel);
    editPanel.add(customerLastNameTextField);
    editPanel.add(customerStreetLabel);
    editPanel.add(customerStreetTextField);
    editPanel.add(customerCityLabel);
    editPanel.add(customerCityTextField);
    editPanel.add(customerPCodeLabel);
    editPanel.add(customerPCodeTextField);
    editPanel.add(customerPhoneNumberLabel);
    editPanel.add(customerPhoneNumberTextField);
    editPanel.add(customerMPhoneNumberLabel);
    editPanel.add(customerMPhoneNumberTextField);
    //editPanel.add(blankLabel1);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,3));
    closeButton = new JButton("Close");
    closeButton.addActionListener(new ButtonListener());
    buttonPanel.add(closeButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");   
  }

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      
      if(source == closeButton)
      {
	//exit this window
	dispose();
      }
    }      
  }
}

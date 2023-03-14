package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Add Supplier Interface
   
   This allows a staff member to add a new supplier entry, 
   this class automatically updates the Supplier Tables

**/
class EditSupplierUI extends JFrame
{  
  private String supName;
  private String supAddr1;
  private String supAddr2; 
  private String supPcode; 
  private String supPhone; 
  private JLabel blankLabel0, blankLabel1;
  private JLabel titleLabel;
  private JLabel supplierNameLabel;
  private JLabel  supplierStreetLabel;
  private JLabel  supplierCityLabel;  
  private JLabel  supplierPCodeLabel;
  private JLabel  supplierPhoneNumberLabel;  
  private JTextField supplierNameTextField;  
  private JTextField  supplierStreetTextField; 
  private JTextField  supplierCityTextField;
  private JTextField  supplierPCodeTextField;
  private JTextField  supplierPhoneNumberTextField;
  private JButton cancelButton;
  private JButton okayButton;
  
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  ArrayList supplierEntry;

  //Constructor
  public EditSupplierUI(String sName)
  {

    supName = sName;
    GetSupplierDetailsQuery sDQuery = new GetSupplierDetailsQuery(supName);
    supplierEntry = sDQuery.exeQuery();    
    supAddr1 = (String)supplierEntry.get(1);
    supAddr2 = (String)supplierEntry.get(2); 
    supPcode = (String)supplierEntry.get(3); 
    supPhone = (String)supplierEntry.get(4);
    
    //Use a query that gets all the supplier info for a given 
    //supplier
    //supplierEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(13,1));
    titleLabel = new JLabel("Enter new Supplier details:");    
    supplierNameLabel = new JLabel("Supplier Name");
    supplierNameTextField = new JTextField(supName);
    supplierNameTextField.setEnabled(false);
    supplierStreetLabel = new JLabel("Street Name:");
    supplierStreetTextField = new JTextField(supAddr1);
    supplierCityLabel = new JLabel("City:");
    supplierCityTextField = new JTextField(supAddr2);
    supplierPCodeLabel = new JLabel("Post Code:");
    supplierPCodeTextField = new JTextField(supPcode);
    supplierPhoneNumberLabel = new JLabel("Contact Number:");
    supplierPhoneNumberTextField = new JTextField(supPhone);

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
    editPanel.add(supplierNameLabel);
    editPanel.add(supplierNameTextField);
    editPanel.add(supplierStreetLabel);
    editPanel.add(supplierStreetTextField);
    editPanel.add(supplierCityLabel);
    editPanel.add(supplierCityTextField);
    editPanel.add(supplierPCodeLabel);
    editPanel.add(supplierPCodeTextField);
    editPanel.add(supplierPhoneNumberLabel);
    editPanel.add(supplierPhoneNumberTextField);
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
	//supplierEntry ArrayList(excluding the iid),
	supplierEntry.set(0,supplierNameTextField.getText());
	supplierEntry.set(1,supplierStreetTextField.getText());
	supplierEntry.set(2,supplierCityTextField.getText());
	supplierEntry.set(3,supplierPCodeTextField.getText());
	supplierEntry.set(4,supplierPhoneNumberTextField.getText());

	System.out.println((String)supplierEntry.get(0));
	System.out.println((String)supplierEntry.get(1));
	System.out.println((String)supplierEntry.get(2));
	System.out.println((String)supplierEntry.get(3));
	System.out.println((String)supplierEntry.get(4));

	
	//pass this arrayList directly to the UpdateSupplierQuery class
	//new java query, which adds a tuple to the database      
	UpdateSupplierQuery upSupplier =new UpdateSupplierQuery(supplierEntry);
	upSupplier.exeQuery();
	
	
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

package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

/**
   The Add Supplier Interface
   
   This allows a staff member to add a new supplier entry, 
   this class automatically updates the Supplier Tables

   @author David Clarke
**/
class AddSupplierUI extends JFrame
{
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

  //ArrayList
  ArrayList supplierEntry;
  
  //Frame
  JFrame frame;
  
  //Panels
  JPanel editPanel;
  JPanel buttonPanel;

  //Buttons
  JButton cancelButton, okayButton;

  /**
   * Constructor to create a new interface that allows the user to add a new
   * supplier
   **/
  public AddSupplierUI()
  {
    supplierEntry = new ArrayList();
    //editing fields
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(5,1));    
    supplierNameLabel = new JLabel("Supplier Name:");
    supplierNameTextField = new JTextField();
    supplierStreetLabel = new JLabel("Street Name:");
    supplierStreetTextField = new JTextField();
    supplierCityLabel = new JLabel("City:");
    supplierCityTextField = new JTextField();
    supplierPCodeLabel = new JLabel("Post Code:");
    supplierPCodeTextField = new JTextField();
    supplierPhoneNumberLabel = new JLabel("Contact Number:");
    supplierPhoneNumberTextField = new JTextField();

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

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      
      if(source == okayButton)
      {
	int numberOfErrors = 0;
	
	if(supplierNameTextField.getText().equals(""))numberOfErrors++;
	if(supplierStreetTextField.getText().equals(""))numberOfErrors++;
	if(supplierCityTextField.getText().equals(""))numberOfErrors++;
	if(supplierPCodeTextField.getText().equals(""))numberOfErrors++;
	if(supplierPhoneNumberTextField.getText().equals(""))numberOfErrors++;

	if(numberOfErrors == 0)
	{
	  //if the okay button has been pressed, take all information present
	  //on the Edit CD details page and overwrite the details present in the
	  //supplierEntry ArrayList(excluding the iid),
	  supplierEntry.add(supplierNameTextField.getText());
	  supplierEntry.add(supplierStreetTextField.getText());
	  supplierEntry.add(supplierCityTextField.getText());
	  supplierEntry.add(supplierPCodeTextField.getText());
	  supplierEntry.add(supplierPhoneNumberTextField.getText());
	  
	  //pass this arrayList directly to the AddCDTupleQuery class
	  //new java query, which adds a tuple to the database      
	  AddSupplierQuery addsupplier = new AddSupplierQuery(supplierEntry);
	  addsupplier.exeQuery();
	  
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
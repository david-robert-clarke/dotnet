package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

/**
   This allows a staff member to edit a single supplier entry

   @author David Clarke, Helen Loynes
**/
class EditSupplierUI extends JFrame
{ 
  //Strings 
  private String supID;
  private String supName;
  private String supAddr1;
  private String supAddr2; 
  private String supPcode; 
  private String supPhone;

  //JLabels
  private JLabel supplierIDLabel;
  private JLabel supplierNameLabel;
  private JLabel  supplierStreetLabel;
  private JLabel  supplierCityLabel;  
  private JLabel  supplierPCodeLabel;
  private JLabel  supplierPhoneNumberLabel;
 
  //JTextFields
  private JTextField supplierNameTextField; 
  private JTextField supplierIDTextField;
  private JTextField  supplierStreetTextField; 
  private JTextField  supplierCityTextField;
  private JTextField  supplierPCodeTextField;
  private JTextField  supplierPhoneNumberTextField;
  
  //JButtons
  private JButton cancelButton;
  private JButton okayButton;
  
  //JPanels
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  private ArrayList supplierEntry;

  //Frame
  private JFrame frame;

  /**
   * Constructor to create a new UI that allows supplier details editing
   *
   * @param sName the supplierName
   **/
  public EditSupplierUI(String sName)
  {

    supName = sName;
    GetSupplierDetailsQuery sDQuery = new GetSupplierDetailsQuery(supName);
    supplierEntry = sDQuery.exeQuery();
    supID = (String)supplierEntry.get(0);
    supAddr1 = (String)supplierEntry.get(2);
    supAddr2 = (String)supplierEntry.get(3); 
    supPcode = (String)supplierEntry.get(4); 
    supPhone = (String)supplierEntry.get(5);
 
    //editing fields
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(6,1));
    supplierIDLabel = new JLabel("SupplierID");
    supplierIDTextField = new JTextField(supID);
    supplierIDTextField.setEnabled(false);
    supplierNameLabel = new JLabel("Supplier:");
    supplierNameTextField = new JTextField(supName);
    supplierNameTextField.setEnabled(false);
    supplierStreetLabel = new JLabel("Street:");
    supplierStreetTextField = new JTextField(supAddr1);
    supplierCityLabel = new JLabel("City:");
    supplierCityTextField = new JTextField(supAddr2);
    supplierPCodeLabel = new JLabel("Post Code:");
    supplierPCodeTextField = new JTextField(supPcode);
    supplierPhoneNumberLabel = new JLabel("Contact No:");
    supplierPhoneNumberTextField = new JTextField(supPhone);
;
    editPanel.add(supplierIDLabel);
    editPanel.add(supplierIDTextField);
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

	//if the okay button has been pressed, take all information present
	//on the Edit CD details page and overwrite the details present in the
	//supplierEntry ArrayList(excluding the iid),
	supplierEntry.set(0,supplierNameTextField.getText());
	supplierEntry.set(1,supplierStreetTextField.getText());
	supplierEntry.set(2,supplierCityTextField.getText());
	supplierEntry.set(3,supplierPCodeTextField.getText());
	supplierEntry.set(4,supplierPhoneNumberTextField.getText());

	int numberOfErrors = 0;

	if(supplierNameTextField.getText().equals(""))numberOfErrors++;
	if(supplierStreetTextField.getText().equals(""))numberOfErrors++;
	if(supplierCityTextField.getText().equals(""))numberOfErrors++;
	if(supplierPCodeTextField.getText().equals(""))numberOfErrors++;
	if(supplierPhoneNumberTextField.getText().equals(""))numberOfErrors++;
	
	if(numberOfErrors ==0)
	{
	  //pass this arrayList directly to the UpdateSupplierQuery class
	  //new java query, which adds a tuple to the database
	  UpdateSupplierQuery upSupplier=new UpdateSupplierQuery(supplierEntry);
	  upSupplier.exeQuery();	
	
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

package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   This allows a manager to remove a new supplier entry, 
   this class automatically updates the Supplier Tables

   @author David Clarke
**/
class RemoveSupUI extends JFrame
{
  //Strings
  private String supid;
  private String supName;
  private JLabel supidLabel;
  private JLabel supNameLabel;
  private JLabel confirmDeleteLabel;
  
  //JTextFields
  private JTextField supidTextField;
  private JTextField supNameTextField;  
  private JButton cancelButton;
  private JButton okayButton;
  
  //JPanels
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  ArrayList supplierEntry;
  
  /**
   * Constructor to create a new UI that confirms supplier removal
   *
   * @param supplierName the supplierName
   **/
  public RemoveSupUI(String supplierName)
  {
    supName = supplierName;
    GetSupplierDetailsQuery sDQuery = new GetSupplierDetailsQuery(supName);
    supplierEntry = sDQuery.exeQuery();
    supid = (String)supplierEntry.get(0);
    supName = (String)supplierEntry.get(1);

    //editing fields
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(5,1)); 
    supidLabel = new JLabel("Supplier ID:");
    supidTextField = new JTextField(supid);
    supidTextField.setEnabled(false);
    supNameLabel = new JLabel("Supplier:");
    supNameTextField = new JTextField(supName);
    supNameTextField.setEnabled(false);
    confirmDeleteLabel = new JLabel("To confirm delete, press ok.");

    editPanel.add(supidLabel);
    editPanel.add(supidTextField);
    editPanel.add(supNameLabel);
    editPanel.add(supNameTextField);
    editPanel.add(confirmDeleteLabel);    

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
	//pass this arrayList directly to the DeleteStaffEntryQuery class
	//new java query, which removes a tuple from the database      
	DeleteSupplierQuery deleteSup =new DeleteSupplierQuery(supplierEntry);
	deleteSup.exeQuery();
	
	
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

package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Remove Supplier Interface
   
   This allows a manager to remove a new supplier entry, 
   this class automatically updates the Supplier Tables

**/
class RemoveSupUI extends JFrame
{  
  private String supid;
  private String supName;
  private JLabel blankLabel0, blankLabel1;
  private JLabel titleLabel;
  private JLabel supidLabel;
  private JLabel supNameLabel;
  private JLabel confirmDeleteLabel;
  
  private JTextField supidTextField;
  private JTextField supNameTextField;  
  private JButton cancelButton;
  private JButton okayButton;
  
  private JPanel editPanel;
  private JPanel buttonPanel;

  //ArrayList
  ArrayList supplierEntry;

  //Constructor
  public RemoveSupUI(String supplierName)
  {
    supName = supplierName;
    GetSupplierDetailsQuery sDQuery = new GetSupplierDetailsQuery(supName);
    supplierEntry = sDQuery.exeQuery();
    supid = (String)supplierEntry.get(0);
    supName = (String)supplierEntry.get(1);
    
    //Use a query that gets the supplier info for a given 
    //supplier
    //supplierEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(15,1));
    titleLabel = new JLabel("Supplier details:");  
    supidLabel = new JLabel("Supplier Identification Number:");
    supidTextField = new JTextField(supid);
    supidTextField.setEnabled(false);
    supNameLabel = new JLabel("Supplier Name:");
    supNameTextField = new JTextField(supName);
    supNameTextField.setEnabled(false);
    confirmDeleteLabel = new JLabel("To confirm delete, press ok.");

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
    editPanel.add(supidLabel);
    editPanel.add(supidTextField);
    editPanel.add(supNameLabel);
    editPanel.add(supNameTextField);
    editPanel.add(blankLabel1);
    editPanel.add(confirmDeleteLabel);    

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
	
	//if the okay button has been pressed, remove the details for this supplier
	// from the supplierEntry ArrayList(excluding the iid),

	//pass this arrayList directly to the DeleteStaffEntryQuery class
	//new java query, which removes a tuple from the database      
	DeleteSupplierQuery deleteSup =new DeleteSupplierQuery(supplierEntry);
	System.out.println("HELEN" + supplierEntry);
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

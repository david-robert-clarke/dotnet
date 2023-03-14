package I;
import java.awt.*;
import javax.swing.*;

/**
 * StaffOptions
 * 
 * 
 * Created: Fri Mar 21 11:02:32 2003
 * 
 * @author <a href="mailto:msc88drc@acws-3437.cs.bham.ac.uk">David R Clarke</a>
 * @version
 */
 
public class StaffUI extends JFrame 
{

  //Instance variables
  /*
    private JLabel addNewProductLabel;
    private JLabel removeProductLabel; 
    private JLabel editProductLabel;
    private JLabel addNewSupplierLabel;
    private JLabel removeSupplierLabel;
    private JLabel orderNewStockLabel;
    private JLabel viewStockLevelsLabel;
  */
  
  //tabs
  private JTabbedPane tabbedPane;
 
  private JTextArea stockTextArea;

  //panels
  private JPanel stockPanel, supplierPanel, managerPanel;

  private JButton addProductButton, removeProductButton, editProductButton;
  private JButton addSupplierButton, removeSupplierButton, orderStockButton;
  private JButton viewStockLevelsButton;
  
  private JLabel salesSummaryLabel;
  private JComboBox timePeriod;
  private JButton iSalesProfile, aSalesProfile;
  
  public StaffUI()
  {
    /*
      addNewProductLabel = new JLabel("Add New Supplier");
      removeProductLabel; 
      editProductLabel;
      addNewSupplierLabel;
      removeSupplierLabel;
      orderNewStockLabel;
      viewStockLevelsLabel;
    */    

    //Stock Tab
    tabbedPane = new JTabbedPane();

    addProductButton = new JButton("Add");
    removeProductButton = new JButton("Remove");
    editProductButton = new JButton("Edit");
    orderStockButton = new JButton("New Order");
    viewStockLevelsButton = new JButton("View Levels");    
    stockPanel = new JPanel();
    stockPanel.add(addProductButton);
    stockPanel.add(removeProductButton);
    stockPanel.add(editProductButton);
    stockPanel.add(orderStockButton);
    stockPanel.add(viewStockLevelsButton);   
    stockTextArea = new JTextArea(20, 30);
    stockTextArea.setEditable(false);
    
    JPanel replacePanel = new JPanel();
    replacePanel.setLayout(new GridLayout(2,1));
    replacePanel.add(stockPanel);
    replacePanel.add(stockTextArea);
   
    tabbedPane.addTab("STOCK",  replacePanel);
    


    //Supplier Tab
    addSupplierButton = new JButton("Add");
    removeSupplierButton = new JButton("Remove");
    supplierPanel = new JPanel();
    supplierPanel.add(addSupplierButton);
    supplierPanel.add(removeSupplierButton); 
    tabbedPane.addTab("SUPPLIER", supplierPanel);

                
    //Manager Tab
    salesSummaryLabel = new JLabel("Sales Summary");  
    timePeriod = new JComboBox(); //comboBox
    timePeriod.addItem("6 months");
    timePeriod.addItem("12 months");
    timePeriod.addItem("5 years");
    timePeriod.addItem("10 years");

    iSalesProfile = new JButton();
    aSalesProfile = new JButton();
    managerPanel = new JPanel();
    managerPanel.add(salesSummaryLabel);
    managerPanel.add(timePeriod);
    managerPanel.add(iSalesProfile);
    managerPanel.add(aSalesProfile);

    tabbedPane.addTab("MANAGER", managerPanel);


    Container contentPane = getContentPane();
    contentPane.add(tabbedPane,"Center");
    
  }
}// StaffUI

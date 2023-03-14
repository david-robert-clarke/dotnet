package I;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;

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

  private JButton a,b;
  private JPanel sto;

  //Strings
  private String sid, fName, position;

  //Arrays
  private String[] cdData;

  //ArrayList
  private ArrayList cdAttributes;
  private ArrayList theSuppliers;
  
  //tabs
  private JTabbedPane tabbedPane;
  
  //lists
  private JList stockList, supplierList;

  //panels
  private JPanel stockPanel, supplierPanel, managerPanel;
  private JPanel staffOrderPanel;  
  private JPanel topPanel,bottomPanel,areaPanel;

  //Labels  
  private JLabel salesSummaryLabel;
  private JLabel greeting, advice;

  //Buttons  
  private JButton addProductButton, removeProductButton, editProductButton;
  private JButton addSupplierButton, removeSupplierButton;
  private JButton viewSupplierDetailsButton;
  private JButton editSupplierDetailsButton;
  private JButton orderStockButton, viewStockLevelsButton; 
  private JButton iSalesProfile, aSalesProfile; 
  private JButton changePWButton, editConDetButton;
  private JButton addStaffOrderButton;
  private JButton removeStaffOrderButton;

  //ComboBoxes
  private JComboBox timePeriod;


  //CONSTRUCTOR
  public StaffUI(String staffID, String firstName, String posit)
  {

    //required by the staffUI in order to enable or disable the Managerial
    //options tab
    sid = staffID;
    fName = firstName;
    position = posit;
      
    //create a new Tabbed Pane
    tabbedPane = new JTabbedPane();

    //Staff Details Tab
    topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(4,1));
    greeting = new JLabel("Welcome -" +  fName + "- to the Staff User"+
			  " Interface.");
    advice = new JLabel("Choose an Option:");
    topPanel.add(greeting);
    topPanel.add(new JLabel(""));
    topPanel.add(new JLabel(""));
    topPanel.add(advice);
    bottomPanel = new JPanel();
    changePWButton = new JButton("Change Password");
    changePWButton.addActionListener(new StaffDButtonListener());
    editConDetButton = new JButton("Edit Contact Details");
    editConDetButton.addActionListener(new StaffDButtonListener());
    bottomPanel.setLayout(new GridLayout(4,1));
    bottomPanel.add(changePWButton);
    bottomPanel.add(editConDetButton);
    areaPanel = new JPanel();
    areaPanel.setLayout(new GridLayout(2,1));    
    areaPanel.add(topPanel);
    areaPanel.add(bottomPanel);
    tabbedPane.add(areaPanel, "STAFF DETAILS");

    //Stock Tab      
    addProductButton = new JButton("Add");
    addProductButton.addActionListener(new StockListener());
    removeProductButton = new JButton("Remove");
    removeProductButton.addActionListener(new StockListener());      
    editProductButton = new JButton("Edit");
    editProductButton.addActionListener(new StockListener());

    orderStockButton = new JButton("New Order");
    viewStockLevelsButton = new JButton("View Levels");    
    stockPanel = new JPanel();
    stockPanel.add(addProductButton);
    stockPanel.add(removeProductButton);
    stockPanel.add(editProductButton);
    stockPanel.add(orderStockButton);
    stockPanel.add(viewStockLevelsButton);   

    stockList = new JList();
    stockList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    stockList.setSelectedIndex(0);
    JScrollPane listScrollPane = new JScrollPane(stockList);
    
    // get the CD details from the cd table
    // Create a result set containing all data from my_table
    updateList();
    
    JPanel replacePanel = new JPanel();
    replacePanel.setLayout(new GridLayout(2,1));
    replacePanel.add(stockPanel);
    replacePanel.add(stockList);
    tabbedPane.addTab("STOCK",  replacePanel);

    
    //Supplier Tab
    addSupplierButton = new JButton("Add");
    addSupplierButton.addActionListener(new SupplierListener());
    removeSupplierButton = new JButton("Remove");
    removeSupplierButton.addActionListener(new SupplierListener());
    viewSupplierDetailsButton = new JButton("View Details");
    viewSupplierDetailsButton.addActionListener(new SupplierListener());
    editSupplierDetailsButton = new JButton("Edit Details");
    editSupplierDetailsButton.addActionListener(new SupplierListener());
    supplierPanel = new JPanel();
    supplierPanel.add(addSupplierButton);
    supplierPanel.add(removeSupplierButton); 
    supplierPanel.add(viewSupplierDetailsButton);
    supplierPanel.add(editSupplierDetailsButton); 
    supplierList = new JList();
    supplierList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    supplierList.setSelectedIndex(0);
    JScrollPane supListScrollPane = new JScrollPane(supplierList);    
    
    // Get the supplier name from the supplier table
    // Display all the suppliers in a JList
    GetSupplierNameQuery querySuppliers = new GetSupplierNameQuery();
    ArrayList theSuppliers = querySuppliers.exeQuery();  
    Object[] supplierData = new Object[20];//could be more, hopefully less
    supplierData = theSuppliers.toArray();
    supplierList.setListData(supplierData);
    
    JPanel supplierAreaPanel = new JPanel();
    supplierAreaPanel.setLayout(new GridLayout(2,1));
    supplierAreaPanel.add(supplierPanel);
    supplierAreaPanel.add(supplierList);
    tabbedPane.addTab("SUPPLIER", supplierAreaPanel);
       

    //Staff Order Tab
    addStaffOrderButton = new JButton("Add");
    removeStaffOrderButton = new JButton("Remove");
    staffOrderPanel = new JPanel();
    staffOrderPanel.add(addStaffOrderButton);
    staffOrderPanel.add(removeStaffOrderButton); 
    tabbedPane.addTab("STAFF ORDER", staffOrderPanel);
                
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
    tabbedPane.addTab("MANAGERIAL OPTIONS", managerPanel);

    // this is where the enabling disabling of manager tab is completed
    if(position.equals("Manager"))
    {
      tabbedPane.setEnabledAt(4, true);
    }
    else
    {
      tabbedPane.setEnabledAt(4, false);
    }

    Container contentPane = getContentPane();
    contentPane.add(tabbedPane,"Center");
  }

  //method that updates the list
  public void updateList()
  {
    try
    {    
      Connection c = MyConnection.C;
      
      Statement stmt = c.createStatement();
      System.out.println("Created Statement");
      ResultSet rs = stmt.executeQuery("SELECT * FROM cd");  
    
      cdData = new String[10];
      int i=0;
      while (rs.next()) 
      {
	String cd_name = rs.getString(2);
	String artist = rs.getString(3);
	String rowData = (artist + "-" + cd_name);      
	cdData[i]= rowData;
	i++;
      }
      stockList.setListData(cdData);   
    }
    catch (SQLException e) 
    {
    }   
      
  }

  //listeners for all buttons contained within the staff details tab
  public class StaffDButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();
      if(source == changePWButton)//Change password?
      {
	NewPasswordUI frame = new NewPasswordUI(sid);
        frame.setTitle("Change Password");
        frame.setSize(300,300);
	frame.setLocation(650,350);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);  
      }
      else if(source == editConDetButton)//Edit contact details?
      {
	EditContactDetailsUI thisFrame = new EditContactDetailsUI(sid);
	thisFrame.setTitle("Edit Contact Details");
        thisFrame.setSize(300,400);
	thisFrame.setLocation(650,350);
        thisFrame.show();
        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisFrame.setResizable(false);
      }
      
    }
  }

  //listeners for all buttons within the supplier tab
  public class SupplierListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();

      if(source == addSupplierButton)
      {
	AddSupplierUI addSupUI = new AddSupplierUI();
	addSupUI.setTitle("Edit CD Details");
	addSupUI.setSize(250,350);
	addSupUI.setResizable(false);
	addSupUI.setLocation(650,300);
	addSupUI.show();
	addSupUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	System.out.println("Just before updateList() method call");
	updateList();//does nothing
      }
      else if(source == removeSupplierButton)
      {
	//difficult to implement try later
      }
      else if(source == viewSupplierDetailsButton)
      {
      }
      else if(source == editSupplierDetailsButton)
      {
	if (supplierList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  String supName = supplierList.getSelectedValue().toString();
	  EditSupplierUI editSupUI = new EditSupplierUI(supName);
	  editSupUI.setTitle("Edit CD Details");
	  editSupUI.setSize(250,350);
	  editSupUI.setResizable(false);
	  editSupUI.setLocation(650,300);
	  editSupUI.show();
	  editSupUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  System.out.println("Just before updateList() method call");
	  updateList();//does nothing
	}
      }
      
    }
  }
  

  //listeners for all the buttons within the stock tab
  public class StockListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();

      if(source == addProductButton)//add button pressed
      {
	//open up a addStockUI
	AddStockUI addUI = new AddStockUI();
	addUI.setTitle("Edit CD Details");
	addUI.setSize(250,410);
	addUI.setResizable(false);
	addUI.setLocation(650,350);
	addUI.show();
	addUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	System.out.println("Just before updateList() method call");
	updateList();
      }
      
      else if(source == removeProductButton)//remove button pressed
      {
	if (stockList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  //get selection, split the selection up, retrieve cd attributes
	  String cd = stockList.getSelectedValue().toString();	
	  WordSplit thisSplit = new WordSplit(cd);
	  ArrayList cdAttributes = thisSplit.getWords();
	  String artist = (String)cdAttributes.get(0);
	  String cdTitle = (String)cdAttributes.get(1);
	  
	  //use DeleteCDTupleQuery to delete the specified cd item
	  DeleteCDTupleQuery thisQuery =new DeleteCDTupleQuery(artist,cdTitle);
	  thisQuery.exeQuery();

	  updateList();

	}
      }
      
      else if(source == editProductButton)
      {
	
	if (stockList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  //Selection
	  String cd = stockList.getSelectedValue().toString();	
	  WordSplit thisSplit = new WordSplit(cd);
	  cdAttributes = thisSplit.getWords(); //get an arrayList of cd details
	  EditStockUI editUI = new EditStockUI(cdAttributes);
	  editUI.setTitle("Edit CD Details");
	  editUI.setSize(250,350);
	  editUI.setResizable(false);
	  editUI.setLocation(650,350);
	  editUI.show();
	  editUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  updateList();
	  //alternatives HIDE_ON_CLOSE
	  //DO_NOTHING_ON_CLOSE
	  //EXIT_ON_CLOSE
	}
      }
      
    }    
  }

}// StaffUI

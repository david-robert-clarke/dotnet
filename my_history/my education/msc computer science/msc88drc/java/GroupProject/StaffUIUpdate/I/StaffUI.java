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


  //Strings
  private String sid, fName, position, todaysDate ;
 
  //Arrays
  private String[] cdData;

  //ArrayList
  private ArrayList theSuppliers;
  private ArrayList theStaff;
  private ArrayList theCustomers;
  
  //Tabs
  private JTabbedPane tabbedPane;
  
  //Lists
  private JList stockList, supplierList, staffOrderList;
  private JList staffList, customerList;

  //Panels
  private JPanel stockPanel, supplierPanel, managerPanel;
  private JPanel staffOrderPanel;
  private JPanel staffPanel, customerPanel;
  private JPanel topPanel,bottomPanel,areaPanel;
  private JPanel replacePanel;
  private JPanel newPanel;
  private JPanel supplierAreaPanel;
  private JPanel staffAreaPanel; 
  private JPanel staffOrderAreaPanel;
  private JPanel titlePanel;
  private JPanel manBlankPanel0;
  private JPanel manBlankPanel1;
  private JPanel salesSummaryTitlePanel;
  private JPanel salesSummaryPanel;
  private JPanel manBlankPanel2;
  private JPanel individualSalesTitlePanel;
  private JPanel individualSalesPanel;
  private JPanel manBlankPanel3;
  private JPanel relatedProfitsTitlePanel;
  private JPanel relatedProfitsPanel;

  //Scroll Pane
  private JScrollPane listScrollPane;
  private JScrollPane custListScrollPane;
  private JScrollPane supListScrollPane;
  private JScrollPane staffListScrollPane;
  private JScrollPane stafOrListScrollPane;

  //Labels
  private JLabel greeting, advice;
  private JLabel titleLabel;
  private JLabel manBlankLabel0;
  private JLabel manBlankLabel1;
  private JLabel salesLabel;
  private JLabel salesSummaryLabel;
  private JLabel manBlankLabel2;
  private JLabel individualSalesTitleLabel;
  private JLabel individualSalesLabel;
  private JLabel manBlankLabel3;
  private JLabel relatedProfitsTitleLabel;
  private JLabel relatedProfitsLabel;

  //Text Fields
  private JTextField iidTextField;

  //Buttons  
  private JButton addProductButton, removeProductButton, editProductButton;
  private JButton addSupplierButton, removeSupplierButton;
  private JButton editViewSupplierDetailsButton;
  private JButton viewStockLevelsButton; 
  private JButton iSalesProfile, aSalesProfile; 
  private JButton changePWButton, editConDetButton;
  private JButton addStaffButton;
  private JButton removeStaffButton;
  private JButton editStaffButton;
  private JButton editCustomerButton;
  private JButton addStaffOrderButton;
  private JButton removeStaffOrderButton;
  private JButton editViewStaffOrderButton;
  private JButton individualSalesButton;
  private JButton salesSelectButton0;
  private JButton salesSelectButton1;
  

  //ComboBoxes
  private JComboBox timePeriod0;
  private JComboBox timePeriod1;


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
    
    //******************************************************************
    //TABS
    //******************************************************************
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
    //topPanel.setBackground(Color.yellow);
    bottomPanel = new JPanel();
    changePWButton = new JButton("Change Password");
    //changePWButton.setBackground(Color.red);
    changePWButton.addActionListener(new StaffDButtonListener());
    editConDetButton = new JButton("Edit Contact Details");
    //editConDetButton.setBackground(Color.blue);
    editConDetButton.addActionListener(new StaffDButtonListener());
    bottomPanel.setLayout(new GridLayout(4,1));
    bottomPanel.add(changePWButton);
    bottomPanel.add(editConDetButton);
    areaPanel = new JPanel();
    areaPanel.setLayout(new GridLayout(2,1));    
    areaPanel.add(topPanel);
    areaPanel.add(bottomPanel);
    tabbedPane.add(areaPanel, "MY DETAILS");
    tabbedPane.setBackground(Color.yellow);


    //Stock Tab      
    addProductButton = new JButton("Add");
    addProductButton.addActionListener(new StockListener());
    removeProductButton = new JButton("Remove");
    removeProductButton.addActionListener(new StockListener());      
    editProductButton = new JButton("Edit");
    editProductButton.addActionListener(new StockListener());
    viewStockLevelsButton = new JButton("View/Details Levels");   
    viewStockLevelsButton.addActionListener(new StockListener()); 
    stockPanel = new JPanel();
    stockPanel.add(addProductButton);
    stockPanel.add(removeProductButton);
    stockPanel.add(editProductButton);
    stockPanel.add(viewStockLevelsButton);
    stockList = new JList();
    stockList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    stockList.setSelectedIndex(0);
    listScrollPane = new JScrollPane(stockList);    
    // get the CD details from the cd table
    // Create a result set containing all data from my_table
    updateCDList();
    replacePanel = new JPanel();
    replacePanel.setLayout(new GridLayout(2,1));
    replacePanel.add(stockPanel);
    replacePanel.add(stockList);
    tabbedPane.addTab("STOCK",  replacePanel);

    //Customer Tab
    editCustomerButton = new JButton("Edit/View Details");
    editCustomerButton.addActionListener(new CustomerListener());
    customerPanel = new JPanel();
    customerPanel.add(editCustomerButton);
    customerList = new JList();
    customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    customerList.setSelectedIndex(0);
    custListScrollPane = new JScrollPane(customerList);
    // get the customer details from the customer table
    // Create a result set containing all data from my_table
    GetCustomerNameQuery queryCustomers = new GetCustomerNameQuery();
    theCustomers = queryCustomers.exeQuery();
    Object[] customerData = new Object[20];
    customerData = theCustomers.toArray();
    customerList.setListData(customerData);
    newPanel = new JPanel();
    newPanel.setLayout(new GridLayout(2,1));
    newPanel.add(customerPanel);
    newPanel.add(customerList);
    tabbedPane.addTab("CUSTOMER", newPanel);

    
    //Supplier Tab
    addSupplierButton = new JButton("Add");
    addSupplierButton.addActionListener(new SupplierListener());
    removeSupplierButton = new JButton("Remove");
    removeSupplierButton.addActionListener(new SupplierListener());
    editViewSupplierDetailsButton = new JButton("Edit/View Details");
    editViewSupplierDetailsButton.addActionListener(new SupplierListener());
    supplierPanel = new JPanel();
    supplierPanel.add(addSupplierButton);
    supplierPanel.add(removeSupplierButton);
    supplierPanel.add(editViewSupplierDetailsButton); 
    supplierList = new JList();
    supplierList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    supplierList.setSelectedIndex(0);
    supListScrollPane = new JScrollPane(supplierList);   
    // Get the supplier name from the supplier table
    // Display all the suppliers in a JList
    GetSupplierNameQuery querySuppliers = new GetSupplierNameQuery();
    theSuppliers = querySuppliers.exeQuery();  
    Object[] supplierData = new Object[20];//could be more, hopefully less
    supplierData = theSuppliers.toArray();
    supplierList.setListData(supplierData);  
    supplierAreaPanel = new JPanel();
    supplierAreaPanel.setLayout(new GridLayout(2,1));
    supplierAreaPanel.add(supplierPanel);
    supplierAreaPanel.add(supplierList);
    tabbedPane.addTab("SUPPLIER", supplierAreaPanel);
       
    //Staff Tab
    addStaffButton = new JButton("Add");
    addStaffButton.addActionListener(new StaffListener());
    removeStaffButton = new JButton("Remove");
    removeStaffButton.addActionListener(new StaffListener());
    editStaffButton = new JButton("Edit/View Details");
    editStaffButton.addActionListener(new StaffListener());
    staffPanel = new JPanel();
    staffPanel.add(addStaffButton);
    staffPanel.add(removeStaffButton);
    staffPanel.add(editStaffButton);
    staffList = new JList();
    staffList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    staffList.setSelectedIndex(0);
    staffListScrollPane = new JScrollPane(staffList);
    // Get the staff name from the staff table
    // Display all the staff in a JList
    GetStaffNameQuery queryStaff = new GetStaffNameQuery();
    theStaff = queryStaff.exeQuery();
    Object[] staffData = new Object[20];//watch out, array sizes need change
    staffData = theStaff.toArray();
    staffList.setListData(staffData);
    staffAreaPanel = new JPanel();
    staffAreaPanel.setLayout(new GridLayout(2,1));
    staffAreaPanel.add(staffPanel);
    staffAreaPanel.add(staffList);
    tabbedPane.addTab("STAFF", staffAreaPanel);

    //StaffOrder Tab
    addStaffOrderButton = new JButton("Add");
    addStaffOrderButton.addActionListener(new StaffOrderListener());
    editViewStaffOrderButton = new JButton("View");
    editViewStaffOrderButton.addActionListener(new StaffOrderListener());
    staffOrderPanel = new JPanel();
    staffOrderPanel.add(addStaffOrderButton);
    staffOrderPanel.add(editViewStaffOrderButton);
    staffOrderList = new JList();
    staffOrderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    staffOrderList.setSelectedIndex(0);
    stafOrListScrollPane = new JScrollPane(staffOrderList);   
    //Get all the staff orders from the staff_order table
    //Display each staff order as one string, one JList entry
    GetAllStaffOrdersQuery queryStaffOrder = new GetAllStaffOrdersQuery();
    String[] sOrder = new String[100];
    sOrder = queryStaffOrder.exeQuery();
    staffOrderList.setListData(sOrder);  
    staffOrderAreaPanel = new JPanel();
    staffOrderAreaPanel.setLayout(new GridLayout(2,1));
    staffOrderAreaPanel.add(staffOrderPanel);
    staffOrderAreaPanel.add(staffOrderList);
    tabbedPane.addTab("STAFF ORDER", staffOrderAreaPanel);
      
          
    //Manager Sales Figures Tab
    titlePanel = new JPanel();
    titleLabel = new JLabel("Choose an option:");
    titlePanel.setLayout(new GridLayout(1,1));
    titlePanel.add(titleLabel);
    manBlankPanel0 = new JPanel();
    manBlankLabel0 = new JLabel();
    manBlankPanel0.setLayout(new GridLayout(1,1));
    manBlankPanel0.add(manBlankLabel0);   
    manBlankPanel1 = new JPanel();
    manBlankLabel1 = new JLabel();
    manBlankPanel1.setLayout(new GridLayout(1,1));
    manBlankPanel1.add(manBlankLabel1);
    salesSummaryTitlePanel = new JPanel();
    salesLabel = new JLabel("View a Summary of All Sales:"); 
    salesSummaryTitlePanel.setLayout(new GridLayout(1,1));
    salesSummaryTitlePanel.add(salesLabel);   
    salesSummaryPanel = new JPanel();
    salesSummaryPanel.setLayout(new GridLayout(1,3));
    salesSummaryLabel = new JLabel("Select date from:");  
    timePeriod0 = new JComboBox(); //comboBox
    timePeriod0.addItem("1 day");
    timePeriod0.addItem("1 week");
    timePeriod0.addItem("1 month");
    timePeriod0.addItem("6 months");
    timePeriod0.addItem("1 year");    
    salesSelectButton0 = new JButton("SELECT");
    salesSelectButton0.addActionListener(new ManagerListener());//listener
    salesSummaryPanel.add(salesSummaryLabel);
    salesSummaryPanel.add(timePeriod0);
    salesSummaryPanel.add(salesSelectButton0);
    manBlankPanel2 = new JPanel();
    manBlankLabel2 = new JLabel();
    manBlankPanel2.setLayout(new GridLayout(1,1));
    manBlankPanel2.add(manBlankLabel1);
    individualSalesTitlePanel = new JPanel();
    individualSalesTitleLabel 
      = new JLabel("View individual product sales of item ID:");
    individualSalesTitlePanel.setLayout(new GridLayout(1,1));
    individualSalesTitlePanel.add(individualSalesTitleLabel);     
    individualSalesPanel = new JPanel();
    individualSalesPanel.setLayout(new GridLayout(1,3));
    individualSalesLabel = new JLabel("Type in item ID:");
    iidTextField = new JTextField();
    iidTextField.setColumns(6);
    individualSalesButton = new JButton("VIEW");
    individualSalesButton.addActionListener(new ManagerListener());//listener
    individualSalesPanel.add(individualSalesLabel);
    individualSalesPanel.add(iidTextField);
    individualSalesPanel.add(individualSalesButton);
    manBlankPanel3 = new JPanel();
    manBlankLabel3 = new JLabel();
    manBlankPanel3.setLayout(new GridLayout(1,1));
    manBlankPanel3.add(manBlankLabel1);
    relatedProfitsTitlePanel = new JPanel();
    relatedProfitsTitleLabel 
      = new JLabel("View a Summary of All Related Profits:"); 
    relatedProfitsTitlePanel.setLayout(new GridLayout(1,1));
    relatedProfitsTitlePanel.add(relatedProfitsTitleLabel);
    relatedProfitsPanel = new JPanel();
    relatedProfitsPanel.setLayout(new GridLayout(1,3));
    relatedProfitsLabel = new JLabel("Select date from:");
    timePeriod1 = new JComboBox(); //comboBox
    timePeriod1.addItem("1 day");
    timePeriod1.addItem("1 week");
    timePeriod1.addItem("1 month");
    timePeriod1.addItem("6 months");
    timePeriod1.addItem("1 year");
    salesSelectButton1 = new JButton("SELECT");
    salesSelectButton1.addActionListener(new ManagerListener());//listener    
    relatedProfitsPanel.add(relatedProfitsLabel);
    relatedProfitsPanel.add(timePeriod1);
    relatedProfitsPanel.add(salesSelectButton1);
    managerPanel = new JPanel();
    managerPanel.setLayout(new GridLayout(12,1));
    managerPanel.add(titlePanel);
    managerPanel.add(manBlankPanel0);
    managerPanel.add(manBlankPanel1);
    managerPanel.add(salesSummaryTitlePanel);
    managerPanel.add(salesSummaryPanel);
    managerPanel.add(manBlankPanel2);
    managerPanel.add(individualSalesTitlePanel);
    managerPanel.add(individualSalesPanel);
    managerPanel.add(manBlankPanel3);
    managerPanel.add(relatedProfitsTitlePanel);
    managerPanel.add(relatedProfitsPanel);
    tabbedPane.addTab("SALES FIGURES", managerPanel);
    //tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);//// Configure the tabs to scroll

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
  public void updateCDList()
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
  
  //*****************************************************************
  //LISTENERS
  //*****************************************************************
  //listeners for all buttons contained within the STAFF DETAILS tab
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


  //listeners for all the buttons within the STOCK tab
  public class StockListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();

      if(source == addProductButton)//add button pressed
      {
	//open up a addStockUI
	AddStockUI addUI = new AddStockUI();
	addUI.setTitle("New CD Details");
	addUI.setSize(250,410);
	addUI.setResizable(false);
	addUI.setLocation(650,350);
	addUI.show();
	addUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	System.out.println("Just before updateList() method call");
	//updateList();
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

	  //updateList();

	}
      }
      
      else if(source == editProductButton)
      {
	
	if (stockList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  //Selection
	  String cd = stockList.getSelectedValue().toString();	
	  WordSplit thisSplit = new WordSplit(cd);
	  ArrayList cdAttributes = thisSplit.getWords(); //arrayList,cd details
	  EditStockUI editUI = new EditStockUI(cdAttributes);
	  editUI.setTitle("Edit CD Details");
	  editUI.setSize(250,350);
	  editUI.setResizable(false);
	  editUI.setLocation(650,350);
	  editUI.show();
	  editUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  //updateList();
	  //alternatives HIDE_ON_CLOSE
	  //DO_NOTHING_ON_CLOSE
	  //EXIT_ON_CLOSE
	}
      }

      else if(source == viewStockLevelsButton)
      {
	System.out.println("I'm in the viewStockLevelsButton");
	
	if (stockList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  //Selection
	  String cd = stockList.getSelectedValue().toString();	
	  WordSplit viewSplit = new WordSplit(cd);
	  ArrayList cdAttributes = viewSplit.getWords();//arrayList,cd details
	  String artist = (String)cdAttributes.get(0);
	  String cdName = (String)cdAttributes.get(1);
	  ViewStockLevelQuery viewQuery = 
	    new ViewStockLevelQuery(artist, cdName);
	  ArrayList theSupplyLevels = viewQuery.exeQuery();
	  Object [] theSupplies = new Object[100];
	  theSupplies = theSupplyLevels.toArray();
	  ViewStockLevelsUI theseStockLevels = 
	    new ViewStockLevelsUI(theSupplies);
	  theseStockLevels.setTitle("Stock Level Details");
	  theseStockLevels.setSize(450,150);
	  theseStockLevels.setResizable(false);
	  theseStockLevels.setLocation(650,350);
	  theseStockLevels.show();
	  theseStockLevels.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  //updateList();
	  //alternatives HIDE_ON_CLOSE
	  //DO_NOTHING_ON_CLOSE
	  //EXIT_ON_CLOSE
	}
      }
      
    }    
  }

  //listeners for all buttons within the CUSTOMER tab
  public class CustomerListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Object source = e.getSource();

      if(source == editCustomerButton)
      {
	if (customerList.getSelectedIndex() != -1) //does not equal no selection
	{
	  // Selection
	  String customerSurname = customerList.getSelectedValue().toString();
	  EditCustomerUI editCustUI = new EditCustomerUI(customerSurname);
	  editCustUI.setTitle("Edit Customer Details");
	  editCustUI.setSize(250, 350);
	  editCustUI.setResizable(false);
	  editCustUI.setLocation(650, 300);
	  editCustUI.show();
	  editCustUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  System.out.println("Just before customer updateList() method call");
	  //updateList();
	}
      }
    }
  }
      
      

  //listeners for all buttons within the SUPPLIER tab
  public class SupplierListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();

      if(source == addSupplierButton)
      {
	AddSupplierUI addSupUI = new AddSupplierUI();
	addSupUI.setTitle("New Supplier Details");
	addSupUI.setSize(250,350);
	addSupUI.setResizable(false);
	addSupUI.setLocation(650,300);
	addSupUI.show();
	addSupUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	System.out.println("Just before updateList() method call");
	//updateList();//does nothing
      }
      else if(source == removeSupplierButton)
      {
	if (supplierList.getSelectedIndex() != -1) //does not equal no selection
	{
	  String supName = supplierList.getSelectedValue().toString();
	  RemoveSupUI removeSupUI = new RemoveSupUI(supName);
	  removeSupUI.setTitle("Remove Supplier");
	  removeSupUI.setSize(250,350);
	  removeSupUI.setResizable(false);
	  removeSupUI.setLocation(650,300);
	  removeSupUI.show();
	  removeSupUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  System.out.println("Just before updateList() method call");
	  //updateList();//does nothing
	}
      }
      else if(source == editViewSupplierDetailsButton)
      {
	if (supplierList.getSelectedIndex() != -1) //doesnot equal no selection
	{
	  String supName = supplierList.getSelectedValue().toString();
	  EditSupplierUI editSupUI = new EditSupplierUI(supName);
	  editSupUI.setTitle("Edit Existing Supplier");
	  editSupUI.setSize(250,350);
	  editSupUI.setResizable(false);
	  editSupUI.setLocation(650,300);
	  editSupUI.show();
	  editSupUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  System.out.println("Just before updateList() method call");
	  //updateList();//does nothing
	}
      }
      
    }
  }

  //listeners for all buttons within the STAFF tab
  public class StaffListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Object source = e.getSource();
      
      if(source == addStaffButton)
      {
	System.out.println("addStaffButton intiated");
	AddStaffUI addStaffUI = new AddStaffUI();
	addStaffUI.setTitle("New Staff Details"); 
        addStaffUI.setSize(400,500);
        addStaffUI.setResizable(false);
	addStaffUI.setLocation(650,300);
        addStaffUI.show();
        addStaffUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      }
      else if(source == removeStaffButton)
      {
	String staffName = staffList.getSelectedValue().toString();
	System.out.println("removeStaffOrderButton initiated");
	RemoveStaffUI removeStaffUI = new RemoveStaffUI(staffName);
	removeStaffUI.setTitle("Remove Staff");
	removeStaffUI.setSize(400,500);
	removeStaffUI.setResizable(false);
	removeStaffUI.setLocation(650,300);
	removeStaffUI.show();
	removeStaffUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	System.out.println("Just before staff updateList() method call");
	//updateList();
      }
      else if(source == editStaffButton)
      {
	if (staffList.getSelectedIndex() != -1) //does not equal no selection
	{
	  String staffName = staffList.getSelectedValue().toString();
	  EditStaffUI editStaffUI = new EditStaffUI(staffName);
	  editStaffUI.setTitle("Edit Staff Details");
	  editStaffUI.setSize(250,350);
	  editStaffUI.setResizable(false);
	  editStaffUI.setLocation(650,300);
	  editStaffUI.show();
	  editStaffUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  System.out.println("Just before staff updateList() method call");
	  //updateList();//does nothing
	}
      }
    }
  }
  
    
  //listeners for all buttons within the STAFF ORDER tab
  public class StaffOrderListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {

      System.out.println("An action has been performed");

      Object source = e.getSource();
      
      if(source == addStaffOrderButton)
      {
	System.out.println("addStaffOrderButton initiated");
	AddStaffOrderUI frame = new AddStaffOrderUI(sid);
        frame.setTitle("Staff Orders"); 
        frame.setSize(400,500);
        frame.setResizable(false);
	frame.setLocation(650,300);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      }      
      else if(source == editViewStaffOrderButton)
      {
	if (staffOrderList.getSelectedIndex() != -1)
	{
	//get selection, split the selection up, retrieve cd attributes
	String staffOrderNumber = staffOrderList.getSelectedValue().toString(); 
	ViewStaffOrderQuery viewStOrdUI = new ViewStaffOrderQuery(staffOrderNumber);
	ArrayList theOrder = new ArrayList();
	theOrder = viewStOrdUI.exeQuery();

	for(int i=0; i<theOrder.size();i++)
	{
	  System.out.println((String)theOrder.get(i));
	  
	}

	System.out.println("viewStaffOrderButton initiated");
	ViewStaffOrderUI frame = new ViewStaffOrderUI(theOrder);
        frame.setTitle("View a Staff Order"); 
        frame.setSize(400,500);
        frame.setResizable(false);
	frame.setLocation(650,300);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

	}
      }
    }
  }

  //listeners for all buttons within the MANAGER SALES SUMMARY tab
  public class ManagerListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Object source = e.getSource();
      String timeSelectionSales = (String)timePeriod0.getSelectedItem();
      String timeSelectionProfits = (String)timePeriod1.getSelectedItem();
      String dateOfQuery = "";
      SummaryOfAllSalesQuery thisQuery;    
      IProductSalesProfileQuery thisQuery2;
      SummaryOfAllRelatedProfitsQuery thisQuery3;
      ArrayList summaryData = new ArrayList();
      String summaryProfitsData = "";

      //summary of all sales from a given period of time
      if(source == salesSelectButton0)
      {
	System.out.println("salesSelectButton0 Clicked");	
	
	if(timeSelectionSales.equals("1 day"))
	{
	  dateOfQuery = getQueriedDate("1 day");
	  
	}
	else if(timeSelectionSales.equals("1 week"))
	{
	  dateOfQuery = getQueriedDate("1 week");
	  
	}
	else if(timeSelectionSales.equals("1 month"))
	{
	  dateOfQuery = getQueriedDate("1 month");
	}
	else if(timeSelectionSales.equals("6 months"))
	{
	  dateOfQuery = getQueriedDate("6 months");
	}
	else if(timeSelectionSales.equals("1 year"))
	{
	 dateOfQuery = getQueriedDate("1 year"); 
	}
	//use queried date in the SummaryOfAllSalesQuery java file
	//this returns an arrayList of information
	thisQuery = new SummaryOfAllSalesQuery(dateOfQuery);
	summaryData = thisQuery.exeQuery();
	
	//create a new Swing box, insert the data
	Object [] theSummaryDataObject = new Object[100];
	theSummaryDataObject = summaryData.toArray();
	ViewSummaryOfAllSalesUI thisSummary = 
	  new ViewSummaryOfAllSalesUI(theSummaryDataObject);
	thisSummary.setTitle("Summary of all Sales");
	thisSummary.setSize(450,150);
	thisSummary.setResizable(true);
	thisSummary.setLocation(650,350);
	thisSummary.show();
	thisSummary.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	for(int i=0; i<summaryData.size(); i++)             
	{
	  System.out.println((String)summaryData.get(i));
	}
      }
      //individual product sales profiles
      else if(source == individualSalesButton)
      {
	System.out.println("Individual Sales Button Clicked");
	String iidText = iidTextField.getText();
	thisQuery2 
	  = new IProductSalesProfileQuery(iidText);
	ArrayList prodSalesProfile = thisQuery2.exeQuery();
	
	//create a new Swing box, insert the data
	Object [] theSalesProfileDataObject = new Object[100];
	theSalesProfileDataObject = prodSalesProfile.toArray();
	ViewIndProdSalesUI thisProfile = 
	  new ViewIndProdSalesUI(theSalesProfileDataObject);
	thisProfile.setTitle("Individual Product Sales Profile");
	thisProfile.setSize(450,150);
	thisProfile.setResizable(true);
	thisProfile.setLocation(650,350);
	thisProfile.show();
	thisProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }

      //summary of all related profits
      else if(source == salesSelectButton1)
      {
	System.out.println("salesSelectButton1 Clicked");
	if(timeSelectionProfits.equals("1 day"))
	{ 
	  dateOfQuery = getQueriedDate("1 day");
	}
	else if(timeSelectionProfits.equals("1 week"))
	{
	  dateOfQuery = getQueriedDate("1 week");
	}
	else if(timeSelectionProfits.equals("1 month"))
	{
	  dateOfQuery = getQueriedDate("1 month");
	}
	else if(timeSelectionProfits.equals("6 months"))
	{
	  dateOfQuery = getQueriedDate("6 months");
	}
	else if(timeSelectionProfits.equals("1 year"))
	{
	  dateOfQuery = getQueriedDate("1 year");
	}
	//use queried date in the SummaryOfAllRelatedProfits java file
	//this returns an arrayList of information
	thisQuery3 = new SummaryOfAllRelatedProfitsQuery(dateOfQuery);
	summaryProfitsData = thisQuery3.exeQuery();
	
	//create a new Swing box, insert the data
	Object [] theProfitSummaryDataObject = new Object[1];
	theProfitSummaryDataObject[0] = summaryProfitsData;
	ViewSummaryOfAllProfitsUI thisProfitSummary = 
	  new ViewSummaryOfAllProfitsUI(theProfitSummaryDataObject);
	thisProfitSummary.setTitle("Summary of all Profits");
	thisProfitSummary.setSize(620,60);
	thisProfitSummary.setResizable(false);
	thisProfitSummary.setLocation(650,350);
	thisProfitSummary.show();
	thisProfitSummary.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
      
    }
  }

  //SEVERE WARNING, TO CREATE A NEW GREGORIAN CALENDAR YOU MUST ASSUME
  //THE MONTH(AN INTEGER) IS ONE LESS THAN THE ACTUAL INTEGER REPRESENTATION
  //OF THE MONTH. THE MONTH VALUE IS NAUGHT BASED, FOR EXAMPLE 0 EQUALS
  //JANUARY

  //WHEN RETRIEVING THE DATE BY USING THE GET STATEMENTS THE MONTH DOES NOT
  //APPEAR TO BE NAUGHT BASED!!!!!!!!!!!!!!!!!!!!!!!!!!!
  private String getQueriedDate(String subtractDate)
  {
    //this is where the current day, month and year are stored
    //month value is naught based 0 equals january
    Calendar cal = new GregorianCalendar();    
    int day = cal.get(Calendar.DAY_OF_MONTH);            
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);

    //stores selection 
    int queriedDay = 0;
    int queriedMonth = 0;
    int queriedYear = 0;    
    String stringDate = "";
    
    if(subtractDate.equals("1 day"))//get the date a day from today
    {
      if(day == 1)//first day of month
      {
	if(month == 1)//first month of the year
	{
	  queriedYear = year - 1;
	  queriedMonth = 11; //december = (month 11)	  
	  Calendar cal2 = new GregorianCalendar(queriedYear,queriedMonth,1); 
	  queriedDay = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);	  
	}
	else//is not the first month of the year
	{
	  queriedYear = year;
	  queriedMonth = month -1;//would be -1
	  Calendar cal3 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	  queriedDay = cal3.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
      }
      else//is not the first day of the month
      {
	queriedYear = year;
	queriedMonth = month;// adjusted to gregorian month
	queriedDay = day -1;
      }    
    }
    
    else if(subtractDate.equals("1 week"))
    {
      if((day-7) < 1)//today minus a week is into last month
      {
	if(month == 1)//first month of the year
	{
	  queriedYear = year -1;
	  queriedMonth = 11; //gregorian december is the 11 month	  
	  int subFactor = day - 7; //get todays date, minus 7 days
	  //produces negative result used to calculate date into last month  
	  Calendar cal4 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	  queriedDay = (cal4.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    - subFactor;
	  
	}	
	else //is not the first month of the year
	{
	  queriedYear = year;
	  queriedMonth = month - 1;
	  int subFactor = day - 7; //get todays date, minus 7 days
	  //produces negative result used to calculate date into last month  
	  Calendar cal5 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	  queriedDay = (cal5.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    - subFactor;	  
	}	
      }
      else//today minus a week is not less than 1
	//i.e. the month and year do not change
      {
	queriedYear = year;
	queriedMonth = month;
	queriedDay = day - 7;
      }	
    }

    else if(subtractDate.equals("1 month"))
    {
      if(month == 1)//first month of the year
      {
	queriedYear = year - 1;
	queriedMonth = 11; //would be 12
	int subFactor = day - 30;
	Calendar cal6 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	queriedDay = (cal6.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    + subFactor;
      }
      else//not the first month of the year
      {
	queriedYear = year;
	queriedMonth = month -1;
	int subFactor = day - 30;
	Calendar cal7 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	queriedDay = (cal7.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    + subFactor;
      }      
    }

    else if(subtractDate.equals("6 months"))
    {
      if((month - 6) < 1)//into the previous year
      {	
	queriedYear = year - 1;
	int subFactor = month - 6;
	queriedMonth = 12 + subFactor;
	int subFactor2 = day - 30;
	Calendar cal8 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	queriedDay = (cal8.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    + subFactor2;
	
      }
      else
      {	
	queriedYear = year;
	queriedMonth = month - 6;
	int subFactor = day - 30;
	Calendar cal9 = new GregorianCalendar(queriedYear, queriedMonth, 1);
	queriedDay = (cal9.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    + subFactor;	
      }     
      
    }

    else if(subtractDate.equals("1 year"))
    {
      queriedYear = year -1;
      queriedMonth = month;
      int subFactor = day - 30;
      Calendar cal10 = new GregorianCalendar(queriedYear, queriedMonth, 1);
      queriedDay = (cal10.getActualMaximum(Calendar.DAY_OF_MONTH)) 
	    + subFactor;
    }
    
    queriedMonth = queriedMonth + 1;//convert month
    stringDate =(queriedYear + "-" + queriedMonth + "-" + queriedDay);     
    
    return(stringDate);//returns a string in the format required by the JDBC
    //query

    }
  
  } // StaffUI

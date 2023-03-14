package I;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;



class AddStaffOrderUI extends JFrame
{
  private String sid;
  private String supid;
  private String todaysDate;

  private ArrayList staffOrderDetails;

  private JFrame frame;

  private JLabel titleLabel;
  private JLabel blankLabel;  
  private JLabel supplierIDLabel;
  private JLabel supplierBlankLabel0;
  private JLabel supplierBlankLabel1;
  private JPanel headerPanel; 
  private JLabel itemIDLabel; 
  private JLabel sNoBought;
  private JLabel blankLabel0;
  private JLabel blankLabel1;
  private JLabel blankLabel2;
  private JLabel blankLabel3;
  private JLabel blankLabel4;
  private JLabel blankLabel5;
  private JLabel blankLabel6;
  private JLabel blankLabel7;
  private JLabel blankLabel8;
  private JLabel blankLabel9;
  private JLabel blankLabel10;
  private JLabel blankLabel11;
  private JLabel blankLabel12;
  private JLabel blankLabel13;
  private JLabel blankLabel14;
  private JLabel blankLabel15;
  private JLabel blankLabel16;
  private JLabel blankLabel17;
  private JLabel blankLabel18;
  private JLabel blankLabel19;
  private JLabel blankLabel20;
  private JLabel blankLabel21;
  
  private JPanel supplierIDPanel;
  private JPanel titlePanel; 
  private JPanel blankPanel; 
  private JPanel textFieldPanel0; 
  private JPanel textFieldPanel1; 
  private JPanel textFieldPanel2; 
  private JPanel textFieldPanel3; 
  private JPanel textFieldPanel4; 
  private JPanel textFieldPanel5; 
  private JPanel textFieldPanel6; 
  private JPanel textFieldPanel7; 
  private JPanel textFieldPanel8;
  private JPanel textFieldPanel9; 
  private JPanel buttonPanel; 
  private JPanel areaPanel;
  private JPanel blankPanel2; 
  

  private JTextField supplierIDTextField;
  private JTextField blank1; 
  private JTextField blank2; 
  private JTextField blank3; 
  private JTextField blank4; 
  private JTextField blank5; 
  private JTextField blank6;
  private JTextField blank7; 
  private JTextField blank8; 
  private JTextField blank9; 
  private JTextField blank10; 
  private JTextField blank11;
  private JTextField blank12;
  private JTextField blank13;
  private JTextField blank14;
  private JTextField blank15;
  private JTextField blank16;
  private JTextField blank17;
  private JTextField blank18;
  private JTextField blank19;
  private JTextField blank20;
  

  private JButton confirmButton;
  private JButton cancelButton;

  public AddStaffOrderUI(String staffID)
  {
    sid = staffID;
    
    Calendar cal = new GregorianCalendar();    
    int day = cal.get(Calendar.DAY_OF_MONTH);            
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    todaysDate = year+"-"+month+"-"+day;

    staffOrderDetails = new ArrayList(); //initialise ArrayList

    //Staff Order Details Swing Interface Components    
    titlePanel = new JPanel();
    titleLabel=new JLabel("Please enter your staff order " +
				 "details below:");
    titlePanel.setLayout(new GridLayout(1,1));
    titlePanel.add(titleLabel);
    blankPanel = new JPanel();

    supplierIDPanel = new JPanel();
    supplierIDLabel = new JLabel("Supplier ID");
    supplierIDTextField = new JTextField();
    supplierBlankLabel0 = new JLabel();
    supplierBlankLabel1 = new JLabel();
    supplierIDPanel.setLayout(new GridLayout(1,4));
    supplierIDPanel.add(supplierIDLabel);
    supplierIDPanel.add(supplierIDTextField);
    supplierIDPanel.add(supplierBlankLabel0);
    supplierIDPanel.add(supplierBlankLabel1);

    headerPanel = new JPanel();
    blankLabel0 = new JLabel();
    itemIDLabel = new JLabel("Item ID");
    sNoBought = new JLabel ("Quantity");
    blankLabel1 = new JLabel();        
    headerPanel.setLayout(new GridLayout(1,4));
    headerPanel.add(blankLabel0);
    headerPanel.add(itemIDLabel);
    headerPanel.add(sNoBought);
    headerPanel.add(blankLabel1);
        
    textFieldPanel0 = new JPanel();
    blankLabel2 = new JLabel("1");
    blank1 = new JTextField();
    blank2 = new JTextField();
    blankLabel3 = new JLabel();        
    textFieldPanel0.setLayout(new GridLayout(1,4));
    textFieldPanel0.add(blankLabel2);
    textFieldPanel0.add(blank1);
    textFieldPanel0.add(blank2);
    textFieldPanel0.add(blankLabel3);

    textFieldPanel1 = new JPanel();
    blankLabel4 = new JLabel("2");
    blank3 = new JTextField();
    blank4 = new JTextField();
    blankLabel5 = new JLabel();
    textFieldPanel1.setLayout(new GridLayout(1,4));
    textFieldPanel1.add(blankLabel4);
    textFieldPanel1.add(blank3);
    textFieldPanel1.add(blank4);
    textFieldPanel1.add(blankLabel5);
        
    textFieldPanel2 = new JPanel();
    blankLabel6 = new JLabel("3");
    blank5 = new JTextField();
    blank6 = new JTextField();
    blankLabel7 = new JLabel();        
    textFieldPanel2.setLayout(new GridLayout(1,4));
    textFieldPanel2.add(blankLabel6);
    textFieldPanel2.add(blank5);
    textFieldPanel2.add(blank6);
    textFieldPanel2.add(blankLabel7);

    textFieldPanel3 = new JPanel();
    blankLabel8 = new JLabel("4");
    blank7 = new JTextField();
    blank8 = new JTextField();
    blankLabel9 = new JLabel();
    textFieldPanel3.setLayout(new GridLayout(1,4));
    textFieldPanel3.add(blankLabel8);
    textFieldPanel3.add(blank7);
    textFieldPanel3.add(blank8);
    textFieldPanel3.add(blankLabel9);
        
    textFieldPanel4 = new JPanel();
    blankLabel10 = new JLabel("5");
    blank9 = new JTextField();
    blank10 = new JTextField();
    blankLabel11 = new JLabel();
    textFieldPanel4.setLayout(new GridLayout(1,4));
    textFieldPanel4.add(blankLabel10);
    textFieldPanel4.add(blank9);
    textFieldPanel4.add(blank10);
    textFieldPanel4.add(blankLabel11);

    textFieldPanel5 = new JPanel();
    blankLabel12 = new JLabel("6");
    blank11 = new JTextField();
    blank12 = new JTextField();
    blankLabel13 = new JLabel();
    textFieldPanel5.setLayout(new GridLayout(1,4));
    textFieldPanel5.add(blankLabel12);
    textFieldPanel5.add(blank11);
    textFieldPanel5.add(blank12);
    textFieldPanel5.add(blankLabel13);

    textFieldPanel6 = new JPanel();
    blankLabel14 = new JLabel("7");
    blank13 = new JTextField();
    blank14 = new JTextField();
    blankLabel15 = new JLabel();
    textFieldPanel6.setLayout(new GridLayout(1,4));
    textFieldPanel6.add(blankLabel14);
    textFieldPanel6.add(blank13);
    textFieldPanel6.add(blank14);
    textFieldPanel6.add(blankLabel15);

    textFieldPanel7 = new JPanel();
    blankLabel16 = new JLabel("8");
    blank15 = new JTextField();
    blank16 = new JTextField();
    blankLabel17 = new JLabel();
    textFieldPanel7.setLayout(new GridLayout(1,4));
    textFieldPanel7.add(blankLabel16);
    textFieldPanel7.add(blank15);
    textFieldPanel7.add(blank16);
    textFieldPanel7.add(blankLabel17);

    textFieldPanel8 = new JPanel();
    blankLabel18 = new JLabel("9");
    blank17 = new JTextField();
    blank18 = new JTextField();
    blankLabel19 = new JLabel();
    textFieldPanel8.setLayout(new GridLayout(1,4));
    textFieldPanel8.add(blankLabel18);
    textFieldPanel8.add(blank17);
    textFieldPanel8.add(blank18);
    textFieldPanel8.add(blankLabel19);
        
    textFieldPanel9 = new JPanel();
    blankLabel20 = new JLabel("10");
    blank19 = new JTextField();
    blank20 = new JTextField();
    blankLabel21 = new JLabel();
    textFieldPanel9.setLayout(new GridLayout(1,4));
    textFieldPanel9.add(blankLabel20);
    textFieldPanel9.add(blank19);
    textFieldPanel9.add(blank20);
    textFieldPanel9.add(blankLabel21);

    blankPanel2 = new JPanel();

    buttonPanel = new JPanel();
    confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ButtonListener());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.add(confirmButton);
    buttonPanel.add(cancelButton);

    areaPanel = new JPanel();
    areaPanel.setLayout(new GridLayout(16,1));
    areaPanel.add(titlePanel);    
    areaPanel.add(supplierIDPanel);
    areaPanel.add(blankPanel);
    areaPanel.add(headerPanel);
    areaPanel.add(textFieldPanel0);
    areaPanel.add(textFieldPanel1);
    areaPanel.add(textFieldPanel2);
    areaPanel.add(textFieldPanel3);
    areaPanel.add(textFieldPanel4);
    areaPanel.add(textFieldPanel5);
    areaPanel.add(textFieldPanel6);
    areaPanel.add(textFieldPanel7);
    areaPanel.add(textFieldPanel8);
    areaPanel.add(textFieldPanel9);
    areaPanel.add(blankPanel2);
    areaPanel.add(buttonPanel);
        
    Container contentPane = getContentPane();
    contentPane.add(areaPanel, "Center");
  }

  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();

      if (source == confirmButton)
      {
	//get all the data from the text boxes
	//if one piece of data is not present on a row throw an exception

	int numberOfErrors = 0;
	String errorString = "";
	String supid = supplierIDTextField.getText();
	
	String iid1 = blank1.getText();
	String quantity1 = blank2.getText();

	String iid2 = blank3.getText();
	String quantity2 = blank4.getText();

	String iid3 = blank5.getText();
	String quantity3 = blank6.getText();
	
	String iid4 = blank7.getText();
	String quantity4 = blank8.getText();

	String iid5 = blank9.getText();
	String quantity5 = blank10.getText();

	String iid6 = blank11.getText();
	String quantity6 = blank12.getText();
	
	String iid7 = blank13.getText();
	String quantity7 = blank14.getText();

	String iid8 = blank15.getText();
	String quantity8 = blank16.getText();

	String iid9 = blank17.getText();
	String quantity9 = blank18.getText();

	String iid10 = blank19.getText();
	String quantity10 = blank20.getText();

	//ROW1

	if(supid.length()>0)
	{
	  System.out.println("SupID successfully completed");
	}
	else
	{
	  System.out.println("SupID information missing!");
	  errorString +="supID, ";
	  numberOfErrors ++;
	}	

	if((iid1.length()>0) && (quantity1.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row1 successfully completed!");
	  
	}
	  else if(iid1.equals("") && quantity1.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row1 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row1 information missing!");
	      errorString +="row1, ";
	      numberOfErrors ++;
	    }
	
	//ROW2
	if((iid2.length()>0) && (quantity2.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row2 successfully completed!");
	  
	}
	  else if(iid2.equals("") && quantity2.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row2 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row2 information missing!");
	      errorString +="row2, ";
	      numberOfErrors ++;
	    }
	
	
	//ROW3
	if((iid3.length()>0) && (quantity3.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row3 successfully completed!");
	  
	}
	else if(iid3.equals("") && (quantity3.equals("")))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row3 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row3 information missing!");
	      errorString +="row3, ";
	      numberOfErrors ++;
	    }
	
	//ROW4
	if((iid4.length()>0) && (quantity4.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row4 successfully completed!");
	  
	}
	else if(iid4.equals("") && (quantity4.equals("")))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row4 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row4 information missing!");
	      errorString +="row4, ";
	      numberOfErrors ++;
	    }
	
	//ROW5
	if((iid5.length()>0) && (quantity5.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row5 successfully completed!");
	  
	}
	  else if(iid5.equals("") && quantity5.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row5 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row5 information missing!");
	      errorString +="row5, ";
	      numberOfErrors ++;
	    }
	
	//ROW6
	if((iid6.length()>0) && (quantity6.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row6 successfully completed!");
	  
	}
	  else if(iid6.equals("") && quantity6.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row6 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row6 information missing!");
	      errorString +="row6, ";
	      numberOfErrors ++;
	    }

	//ROW7
	if((iid7.length()>0) && (quantity7.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row7 successfully completed!");
	  
	}
	  else if(iid7.equals("") && quantity7.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row7 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row7 information missing!");
	      errorString +="row7, ";
	      numberOfErrors ++;
	    }
	
	//ROW8
	if((iid8.length()>0) && (quantity8.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row8 successfully completed!");
	  
	}
	  else if(iid8.equals("") && quantity8.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row8 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row8 information missing!");
	      errorString +="row8, ";
	      numberOfErrors ++;
	    }
	
	//ROW9
	if((iid9.length()>0) && (quantity9.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row9 successfully completed!");
	  
	}
	  else if(iid9.equals("") && quantity9.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row9 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row9 information missing!");
	      errorString +="row9, ";
	      numberOfErrors ++;
	    }
	
	//ROW10
	if((iid10.length()>0) && (quantity10.length()>0))
	{
	  //all the information has been provided
	  //check if the information is valid i.e. number of characters
	  //format etc.

	  System.out.println("Row10 successfully completed!");
	  
	}
	  else if(iid10.equals("") && quantity10.equals(""))
	  {
	    //do not use pass the blank information from this row to a query
	    System.out.println("Row10 ignored!");
	  }
	    else
	    {
	      //output a warning box stating that one of the fields has not 
	      //been filled in
	      System.out.println("Row10 information missing!");
	      errorString +="row10 ";
	      numberOfErrors ++;
	    }

	//if errors prints out a warning box stating on which row are these 
	//errors
	if(numberOfErrors > 0)
	{
         JOptionPane.showMessageDialog(frame,"Missing data on: " + errorString);
	}
	else
	{
	  //if there are no errors in the data provided then add the data to an arraylist
	  //which is then passed to a query called AddStaffOrderQuery
	  staffOrderDetails.add(sid);
	  staffOrderDetails.add(supid);
	  staffOrderDetails.add(todaysDate);
	  
	  if(iid1.length()>0)
	  {
	    staffOrderDetails.add(iid1);
	    staffOrderDetails.add(quantity1);
	  }
	  if(iid2.length()>0)
	  {
	    staffOrderDetails.add(iid2);
	    staffOrderDetails.add(quantity2);
	  }
	  if(iid3.length()>0)
	  {
	    staffOrderDetails.add(iid3);
	    staffOrderDetails.add(quantity3);
	  }
	  if(iid4.length()>0)
	  {
	    staffOrderDetails.add(iid4);
	    staffOrderDetails.add(quantity4);
	  }
	  if(iid5.length()>0)
	  {
	    staffOrderDetails.add(iid5);
	    staffOrderDetails.add(quantity5);
	  }
	  if(iid6.length()>0)
	  {
	    staffOrderDetails.add(iid6);
	    staffOrderDetails.add(quantity6);
	  }
	  if(iid7.length()>0)
	  {
	    staffOrderDetails.add(iid7);
	    staffOrderDetails.add(quantity7);
	  }
	  if(iid8.length()>0)
	  {
	    staffOrderDetails.add(iid8);
	    staffOrderDetails.add(quantity8);
	  }
	  if(iid9.length()>0)
	  {
	    staffOrderDetails.add(iid9);
	    staffOrderDetails.add(quantity9);
	  }
	  if(iid10.length()>0)
	  {
	    staffOrderDetails.add(iid10);
	    staffOrderDetails.add(quantity10);
	  }
	  
	  AddStaffOrderQuery thisQuery = new AddStaffOrderQuery(staffOrderDetails);
	  thisQuery.exeQuery();
	  System.out.println("Hurrah finished query!");
	  dispose();
	}	
      }
      else if(source == cancelButton)
      {
	dispose();
      }
    }
  }

} 


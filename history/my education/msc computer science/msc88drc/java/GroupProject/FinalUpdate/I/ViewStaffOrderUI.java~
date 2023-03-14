package I;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;



class ViewStaffOrderUI extends JFrame
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

  private JButton closeButton;

  private JPanel staffOrderNoPanel;
  private JLabel staffOrderNoLabel;
  private JTextField staffOrderNoTextField;
  private JLabel staffOrderNoBlankLabel0;
  private JLabel staffOrderNoBlankLabel1;

  private JPanel staffIDPanel;
  private JLabel staffIDLabel;
  private JTextField staffIDTextField;
  private JLabel staffIDBlankLabel0;
  private JLabel staffIDBlankLabel1;
  
  private JPanel staffOrderDatePanel;
  private JLabel staffOrderDateLabel;
  private JTextField staffOrderDateTextField;
  private JLabel staffOrderDateBlankLabel0;
  private JLabel staffOrderDateBlankLabel1;

  private JPanel blankPanelAfterTitle;
  private ArrayList staffOrder;
  
  public ViewStaffOrderUI(ArrayList theStaffOrder)
  {
    staffOrder = new ArrayList();
    staffOrder = theStaffOrder;
    
    String staffON = (String)staffOrder.get(0);
    String staffID = (String)staffOrder.get(1);
    String staffD = (String)staffOrder.get(2);
    String supID = (String)staffOrder.get(3);


    //Staff Order Details Swing Interface Components    
    titlePanel = new JPanel();
    titleLabel=new JLabel("STAFF ORDER DETAILS");
    //titlePanel.setLayout(new GridLayout(1,1));
    titlePanel.add(titleLabel);
    blankPanelAfterTitle = new JPanel();
    blankPanel = new JPanel();

    staffOrderNoPanel = new JPanel();
    staffOrderNoLabel = new JLabel("Staff Order Number");
    staffOrderNoTextField = new JTextField(staffON);
    staffOrderNoTextField.setEnabled(false);
    staffOrderNoBlankLabel0 = new JLabel();
    staffOrderNoBlankLabel1 = new JLabel();
    staffOrderNoPanel.setLayout(new GridLayout(1,3));
    staffOrderNoPanel.add(staffOrderNoLabel);
    staffOrderNoPanel.add(staffOrderNoTextField);
    staffOrderNoPanel.add(staffOrderNoBlankLabel0);
    //staffOrderNoPanel.add(staffOrderNoBlankLabel1);
    
    staffIDPanel = new JPanel();
    staffIDLabel = new JLabel("Staff ID Number");
    staffIDTextField = new JTextField(staffID);
    staffIDTextField.setEnabled(false);
    staffIDBlankLabel0 = new JLabel();
    staffIDBlankLabel1 = new JLabel();
    staffIDPanel.setLayout(new GridLayout(1,3));
    staffIDPanel.add(staffIDLabel);
    staffIDPanel.add(staffIDTextField);
    staffIDPanel.add(staffIDBlankLabel0);
    //staffIDPanel.add(staffIDBlankLabel1);

    staffOrderDatePanel = new JPanel();
    staffOrderDateLabel = new JLabel("Staff Order Date");
    staffOrderDateTextField = new JTextField(staffD);
    staffOrderDateTextField.setEnabled(false);
    staffOrderDateBlankLabel0 = new JLabel();
    staffOrderDateBlankLabel1 = new JLabel();
    staffOrderDatePanel.setLayout(new GridLayout(1,3));
    staffOrderDatePanel.add(staffOrderDateLabel);
    staffOrderDatePanel.add(staffOrderDateTextField);
    staffOrderDatePanel.add(staffOrderDateBlankLabel0);
    //staffOrderDatePanel.add(staffOrderDateBlankLabel1);
    
    supplierIDPanel = new JPanel();
    supplierIDLabel = new JLabel("Supplier ID");
    supplierIDTextField = new JTextField(supID);
    supplierIDTextField.setEnabled(false);
    supplierBlankLabel0 = new JLabel();
    supplierBlankLabel1 = new JLabel();
    supplierIDPanel.setLayout(new GridLayout(1,3));
    supplierIDPanel.add(supplierIDLabel);
    supplierIDPanel.add(supplierIDTextField);
    supplierIDPanel.add(supplierBlankLabel0);
    //supplierIDPanel.add(supplierBlankLabel1);

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
    blank1.setEnabled(false);
    blank2 = new JTextField();
    blank2.setEnabled(false);
    blankLabel3 = new JLabel();        
    textFieldPanel0.setLayout(new GridLayout(1,4));
    textFieldPanel0.add(blankLabel2);
    textFieldPanel0.add(blank1);
    textFieldPanel0.add(blank2);
    textFieldPanel0.add(blankLabel3);

    textFieldPanel1 = new JPanel();
    blankLabel4 = new JLabel("2");
    blank3 = new JTextField();
    blank3.setEnabled(false);
    blank4 = new JTextField();
    blank4.setEnabled(false);
    blankLabel5 = new JLabel();
    textFieldPanel1.setLayout(new GridLayout(1,4));
    textFieldPanel1.add(blankLabel4);
    textFieldPanel1.add(blank3);
    textFieldPanel1.add(blank4);
    textFieldPanel1.add(blankLabel5);
        
    textFieldPanel2 = new JPanel();
    blankLabel6 = new JLabel("3");
    blank5 = new JTextField();
    blank5.setEnabled(false);
    blank6 = new JTextField();
    blank6.setEnabled(false);
    blankLabel7 = new JLabel();        
    textFieldPanel2.setLayout(new GridLayout(1,4));
    textFieldPanel2.add(blankLabel6);
    textFieldPanel2.add(blank5);
    textFieldPanel2.add(blank6);
    textFieldPanel2.add(blankLabel7);

    textFieldPanel3 = new JPanel();
    blankLabel8 = new JLabel("4");
    blank7 = new JTextField();
    blank7.setEnabled(false);
    blank8 = new JTextField();
    blank8.setEnabled(false);
    blankLabel9 = new JLabel();
    textFieldPanel3.setLayout(new GridLayout(1,4));
    textFieldPanel3.add(blankLabel8);
    textFieldPanel3.add(blank7);
    textFieldPanel3.add(blank8);
    textFieldPanel3.add(blankLabel9);
        
    textFieldPanel4 = new JPanel();
    blankLabel10 = new JLabel("5");
    blank9 = new JTextField();
    blank9.setEnabled(false);
    blank10 = new JTextField();
    blank10.setEnabled(false);
    blankLabel11 = new JLabel();
    textFieldPanel4.setLayout(new GridLayout(1,4));
    textFieldPanel4.add(blankLabel10);
    textFieldPanel4.add(blank9);
    textFieldPanel4.add(blank10);
    textFieldPanel4.add(blankLabel11);

    textFieldPanel5 = new JPanel();
    blankLabel12 = new JLabel("6");
    blank11 = new JTextField();
    blank11.setEnabled(false);
    blank12 = new JTextField();
    blank12.setEnabled(false);
    blankLabel13 = new JLabel();
    textFieldPanel5.setLayout(new GridLayout(1,4));
    textFieldPanel5.add(blankLabel12);
    textFieldPanel5.add(blank11);
    textFieldPanel5.add(blank12);
    textFieldPanel5.add(blankLabel13);

    textFieldPanel6 = new JPanel();
    blankLabel14 = new JLabel("7");
    blank13 = new JTextField();
    blank13.setEnabled(false);
    blank14 = new JTextField();
    blank14.setEnabled(false);
    blankLabel15 = new JLabel();
    textFieldPanel6.setLayout(new GridLayout(1,4));
    textFieldPanel6.add(blankLabel14);
    textFieldPanel6.add(blank13);
    textFieldPanel6.add(blank14);
    textFieldPanel6.add(blankLabel15);

    textFieldPanel7 = new JPanel();
    blankLabel16 = new JLabel("8");
    blank15 = new JTextField();
    blank15.setEnabled(false);
    blank16 = new JTextField();
    blank16.setEnabled(false);
    blankLabel17 = new JLabel();
    textFieldPanel7.setLayout(new GridLayout(1,4));
    textFieldPanel7.add(blankLabel16);
    textFieldPanel7.add(blank15);
    textFieldPanel7.add(blank16);
    textFieldPanel7.add(blankLabel17);

    textFieldPanel8 = new JPanel();
    blankLabel18 = new JLabel("9");
    blank17 = new JTextField();
    blank17.setEnabled(false);
    blank18 = new JTextField();
    blank18.setEnabled(false);
    blankLabel19 = new JLabel();
    textFieldPanel8.setLayout(new GridLayout(1,4));
    textFieldPanel8.add(blankLabel18);
    textFieldPanel8.add(blank17);
    textFieldPanel8.add(blank18);
    textFieldPanel8.add(blankLabel19);
        
    textFieldPanel9 = new JPanel();
    blankLabel20 = new JLabel("10");
    blank19 = new JTextField();
    blank19.setEnabled(false);
    blank20 = new JTextField();
    blank20.setEnabled(false);
    blankLabel21 = new JLabel();
    textFieldPanel9.setLayout(new GridLayout(1,4));
    textFieldPanel9.add(blankLabel20);
    textFieldPanel9.add(blank19);
    textFieldPanel9.add(blank20);
    textFieldPanel9.add(blankLabel21);

    blankPanel2 = new JPanel();

    buttonPanel = new JPanel();
    closeButton = new JButton("Close");
    closeButton.addActionListener(new ButtonListener());
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.add(closeButton);

    areaPanel = new JPanel();
    areaPanel.setLayout(new GridLayout(20,1));
    areaPanel.add(titlePanel);
    areaPanel.add(blankPanelAfterTitle);
    areaPanel.add(staffOrderNoPanel);
    areaPanel.add(staffIDPanel);
    areaPanel.add(staffOrderDatePanel);
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

    //the number of item orders viewable for a particular staff order is
    //dependant on how many item orders were originally made
    blank1.setText((String)staffOrder.get(4));
    blank2.setText((String)staffOrder.get(5));

    if(staffOrder.size()>6 && staffOrder.size()<13)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
    }
    else if(staffOrder.size()>12 && staffOrder.size()<19)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
    }
    else if(staffOrder.size()>18 && staffOrder.size()<25)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
    }
    else if(staffOrder.size()>24 && staffOrder.size()<31)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
    }
    else if(staffOrder.size()>30 && staffOrder.size()<37)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
      blank11.setText((String)staffOrder.get(34));
      blank12.setText((String)staffOrder.get(35));
    }
    else if(staffOrder.size()>36 && staffOrder.size()<43)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
      blank11.setText((String)staffOrder.get(34));
      blank12.setText((String)staffOrder.get(35));
      blank13.setText((String)staffOrder.get(40));
      blank14.setText((String)staffOrder.get(41));
    }
    else if(staffOrder.size()>42 && staffOrder.size()<49)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
      blank11.setText((String)staffOrder.get(34));
      blank12.setText((String)staffOrder.get(35));
      blank13.setText((String)staffOrder.get(40));
      blank14.setText((String)staffOrder.get(41));
      blank15.setText((String)staffOrder.get(46));
      blank16.setText((String)staffOrder.get(47));
    }
    else if(staffOrder.size()>48 && staffOrder.size()<55)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
      blank11.setText((String)staffOrder.get(34));
      blank12.setText((String)staffOrder.get(35));
      blank13.setText((String)staffOrder.get(40));
      blank14.setText((String)staffOrder.get(41));
      blank15.setText((String)staffOrder.get(46));
      blank16.setText((String)staffOrder.get(47));
      blank17.setText((String)staffOrder.get(52));
      blank18.setText((String)staffOrder.get(53));
    }
    else if(staffOrder.size()>54 && staffOrder.size()<61)
    {
      blank3.setText((String)staffOrder.get(10));
      blank4.setText((String)staffOrder.get(11));
      blank5.setText((String)staffOrder.get(16));
      blank6.setText((String)staffOrder.get(17));
      blank7.setText((String)staffOrder.get(22));
      blank8.setText((String)staffOrder.get(23));
      blank9.setText((String)staffOrder.get(28));
      blank10.setText((String)staffOrder.get(29));
      blank11.setText((String)staffOrder.get(34));
      blank12.setText((String)staffOrder.get(35));
      blank13.setText((String)staffOrder.get(40));
      blank14.setText((String)staffOrder.get(41));
      blank15.setText((String)staffOrder.get(46));
      blank16.setText((String)staffOrder.get(47));
      blank17.setText((String)staffOrder.get(52));
      blank18.setText((String)staffOrder.get(53));
      blank19.setText((String)staffOrder.get(58));
      blank20.setText((String)staffOrder.get(59));
    }


  }

  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      
      if(source == closeButton)
      {
	dispose();
      }
    }
  }

} 


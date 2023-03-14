package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   A java Swing application that is used to view the Individual Product Sales 
   Profiles
   
   @author David Clarke 
**/
public class ViewIndProdSalesUI extends JFrame
{
  //instance variables
  private JList viewSummaryList;
  private Object[] levels;
  private JScrollPane listScrollPane;

  /**
   * Constructor to create a new individual product sales details viewer UI
   *
   * @param levs the details of a product
   **/
  public ViewIndProdSalesUI(Object[] levs)
  {
    levels = levs;
    viewSummaryList = new JList();
    viewSummaryList.setEnabled(false);
    Container contentPane = getContentPane();
    contentPane.add(new JScrollPane(viewSummaryList),"Center");
    viewSummaryList.setListData(levels);	
  } 
}

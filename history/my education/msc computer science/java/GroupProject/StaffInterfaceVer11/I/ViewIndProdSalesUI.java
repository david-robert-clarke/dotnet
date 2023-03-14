package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   View Individual Product Sales Profiles
   
   @author David Clarke 
**/
public class ViewIndProdSalesUI extends JFrame
{
  JList viewSummaryList;
  Object[] levels;

  //constructor
  public ViewIndProdSalesUI(Object[] levs)
  {
    levels = levs;
    viewSummaryList = new JList();
    viewSummaryList.setEnabled(false);
    JScrollPane listScrollPane = new JScrollPane(viewSummaryList);   

    Container contentPane = getContentPane();
    contentPane.add(viewSummaryList,"Center");

    viewSummaryList.setListData(levels);
	
  } 
}

package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   Stock Level viewer for all members of staff
   
   @author David Clarke 
**/
public class ViewStockLevelsUI extends JFrame
{
  JList viewStockList;
  Object[] levels;

  //constructor
  public ViewStockLevelsUI(Object[] levs)
  {
    levels = levs;
    viewStockList = new JList();
    viewStockList.setEnabled(false);
    //viewStockList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //viewStockList.setSelectedIndex(0);
    JScrollPane stafOrListScrollPane = new JScrollPane(viewStockList);   
    //Get all the staff orders from the staff_order table
    //Display each staff order as one string, one JList entry

    Container contentPane = getContentPane();
    contentPane.add(viewStockList,"Center");

    viewStockList.setListData(levels);
	
  } 
}

package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   Stock Level viewer for all members of staff
   
   @author David Clarke 
**/
public class ViewSummaryOfAllSalesUI extends JFrame
{
  JList viewSummaryList;
  Object[] levels;

  //constructor
  public ViewSummaryOfAllSalesUI(Object[] levs)
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

package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   View a summary of all related profits
   
   @author David Clarke 
**/
public class ViewSummaryOfAllProfitsUI extends JFrame
{
  JList viewSummaryList;
  Object[] levels;

  //constructor
  public ViewSummaryOfAllProfitsUI(Object[] levs)
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

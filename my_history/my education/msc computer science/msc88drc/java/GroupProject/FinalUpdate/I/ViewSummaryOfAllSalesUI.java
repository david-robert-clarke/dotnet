package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   A java Swing application that shows a summary of all cd sales over a given
   period of time.
   
   @author David Clarke 
**/
public class ViewSummaryOfAllSalesUI extends JFrame
{
  //instance variables
  private JList viewSummaryList;
  private Object[] levels;
  private JScrollPane listScrollPane;

  /**
   * Constructor to create a new Summary interface
   *
   * @param levs a list of all cd levels
   **/
  public ViewSummaryOfAllSalesUI(Object[] levs)
  {
    levels = levs;
    viewSummaryList = new JList();
    viewSummaryList.setEnabled(false);
    listScrollPane = new JScrollPane(viewSummaryList);
    Container contentPane = getContentPane();
    contentPane.add(viewSummaryList,"Center");
    viewSummaryList.setListData(levels);
	
  } 
}

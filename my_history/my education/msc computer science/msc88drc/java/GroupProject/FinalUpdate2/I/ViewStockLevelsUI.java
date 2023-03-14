package I;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
/**
   A java Swing application that displays the Stock Levels for a particular
   item of stock
   
   @author David Clarke 
**/
public class ViewStockLevelsUI extends JFrame
{
  //instance variables
  private JList viewStockList;
  private Object[] levels;

  /**
   * Constructor to create a new Stock Level interface
   *
   * @param levs a list of all stock profits
   **/
  public ViewStockLevelsUI(Object[] levs)
  {
    levels = levs;
    viewStockList = new JList();
    viewStockList.setEnabled(false);   
    Container contentPane = getContentPane();
    contentPane.add(new JScrollPane(viewStockList),"Center");
    viewStockList.setListData(levels);	
  } 
}

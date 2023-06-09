/**
   @version 1.01 2001-07-21
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;

/**
   This program demonstrates selection, addition, and removal
   of rows and columns.
*/
public class TableSelectionTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new TableSelectionFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame shows a multiplication table and has menus for
   setting the row/column/cell selection modes, and for 
   adding and removing rows and columns.
*/
class TableSelectionFrame extends JFrame
{  
   public TableSelectionFrame()
   {  
      setTitle("TableSelectionTest");
      setSize(WIDTH, HEIGHT);

      // set up multiplication table

      model = new DefaultTableModel(10, 10);

      for (int i = 0; i < model.getRowCount(); i++)
         for (int j = 0; j < model.getColumnCount(); j++)
            model.setValueAt(
               new Integer((i + 1) * (j + 1)), i, j);

      table = new JTable(model);

      Container contentPane = getContentPane();
      contentPane.add(new JScrollPane(table), "Center");

      removedColumns = new ArrayList();

      // create menu

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu selectionMenu = new JMenu("Selection");
      menuBar.add(selectionMenu);

      final JCheckBoxMenuItem rowsItem 
         = new JCheckBoxMenuItem("Rows");
      final JCheckBoxMenuItem columnsItem 
         = new JCheckBoxMenuItem("Columns");
      final JCheckBoxMenuItem cellsItem 
         = new JCheckBoxMenuItem("Cells");

      rowsItem.setSelected(table.getRowSelectionAllowed());
      columnsItem.setSelected(table.getColumnSelectionAllowed());
      cellsItem.setSelected(table.getCellSelectionEnabled());

      rowsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               table.clearSelection();
               table.setRowSelectionAllowed(
                  rowsItem.isSelected());
               cellsItem.setSelected(
                  table.getCellSelectionEnabled());
            }
         });
      selectionMenu.add(rowsItem);

      columnsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               table.clearSelection();
               table.setColumnSelectionAllowed(
                  columnsItem.isSelected());
               cellsItem.setSelected(
                  table.getCellSelectionEnabled());
            }
         });
      selectionMenu.add(columnsItem);

      cellsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               table.clearSelection();
               table.setCellSelectionEnabled(
                  cellsItem.isSelected());
               rowsItem.setSelected(
                  table.getRowSelectionAllowed());
               columnsItem.setSelected(
                  table.getColumnSelectionAllowed());
            }
         });
      selectionMenu.add(cellsItem);

      JMenu tableMenu = new JMenu("Edit");
      menuBar.add(tableMenu);

      JMenuItem hideColumnsItem = new JMenuItem("Hide Columns");
      hideColumnsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int[] selected = table.getSelectedColumns();
               TableColumnModel columnModel 
                  = table.getColumnModel();

               // remove columns from view, starting at the last
               // index so that column numbers aren't affected


               for (int i = selected.length - 1; i >= 0; i--)
               {  
                  TableColumn column
                     = columnModel.getColumn(selected[i]);
                  table.removeColumn(column);

                  // store removed columns for "show columns" 
                  // command

                  removedColumns.add(column);
               }            
            }
         });
      tableMenu.add(hideColumnsItem);

      JMenuItem showColumnsItem = new JMenuItem("Show Columns");
      showColumnsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // restore all removed columns
               for (int i = 0; i < removedColumns.size(); i++)
                  table.addColumn(
                     (TableColumn)removedColumns.get(i));
               removedColumns.clear();            
            }
         });
      tableMenu.add(showColumnsItem);

      JMenuItem addRowItem = new JMenuItem("Add Row");
      addRowItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // add a new row to the multiplication table in 
               // the model

               Integer[] newCells 
                  = new Integer[model.getColumnCount()];
               for (int i = 0; i < newCells.length; i++)
                  newCells[i] = new Integer((i + 1) 
                     * (model.getRowCount() + 1));
               model.addRow(newCells);
            }
         });
      tableMenu.add(addRowItem);

      JMenuItem removeRowsItem = new  JMenuItem("Remove Rows");
      removeRowsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int[] selected = table.getSelectedRows();

               // remove rows from model, starting at the last
               // index so that the row numbers aren't affected
               

               for (int i = selected.length - 1; i >= 0; i--)
                  model.removeRow(selected[i]);
            }
         });
      tableMenu.add(removeRowsItem);

      JMenuItem clearCellsItem = new  JMenuItem("Clear Cells");
      clearCellsItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // set all selected cells to 0

               for (int i = 0; i < table.getRowCount(); i++)
                  for (int j = 0; j < table.getColumnCount(); j++)
                     if (table.isCellSelected(i, j))
                        table.setValueAt(new Integer(0), i, j);
            }
         });
      tableMenu.add(clearCellsItem);
   }

   private DefaultTableModel model;
   private JTable table;
   private ArrayList removedColumns;

   private static final int WIDTH = 400;
   private static final int HEIGHT = 300;
}

package I;
import java.awt.*;
import javax.swing.*;

/**
 * StaffOptions
 * 
 * 
 * Created: Fri Mar 21 11:02:32 2003
 * 
 * @author <a href="mailto:msc88drc@acws-3437.cs.bham.ac.uk">David R Clarke</a>
 * @version
 */
 
public class StaffUI extends JFrame {

  //Stock staff options
  private JButton addNewProductButton;
  private JButton removeProductButton;
  private JButton editProductButton;
  private JButton addNewSupplierButton;
  private JButton removeSupplierButton;
  private JButton orderNewStockButton;
  private JButton viewStockLevelsButton;
  
  //Managerial staff options
  addNewSupplierButton = new JButton("Add New Supplier");
  removeSupplierButton = new JButton("Remove Supplier");
  orderNewStockButton = new JButton("Order New STOCK");
  viewStockLevelsButton = new JButton("View STOCK Levels");

  //Managerial related options
  summary
  timePeriod; //input time period required for info
  iSalesProfile;
  aSalesProfile;

  //Add Buttons to staff menu
  JPanel staffPanel = new JPanel();
  staffPanel.setLayout(new GridLayout(7,1));
  staffPanel.add(addNewProductButton);
  staffPanel.add(removeProductButton);
  staffPanel.add(editProductButton);
  staffPanel.add(addNewSupplierButton);
  staffPanel.add(removeSupplierButton);
  staffPanel.add(orderNewStockButton);
  staffPanel.add(viewStockLevelsButton);

  Container contentPane = getContentPane();
  contentPane.add(staffPanel,"East");  
}

}// StaffUI

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

    //Instance variables
    /*
    private JLabel addNewProductLabel;
    private JLabel removeProductLabel; 
    private JLabel editProductLabel;
    private JLabel addNewSupplierLabel;
    private JLabel removeSupplierLabel;
    private JLabel orderNewStockLabel;
    private JLabel viewStockLevelsLabel;
    */
    private JButton addNewProductButton;
    private JButton removeProductButton;
    private JButton editProductButton;
    private JButton addNewSupplierButton;
    private JButton removeSupplierButton;
    private JButton orderNewStockButton;
    private JButton viewStockLevelsButton;

    private JLabel salesSummaryLabel;
    private JComboBox timePeriod;
    private JButton iSalesProfile;
    private JButton aSalesProfile;
  
    public StaffUI
    {
        /*
        addNewProductLabel = new JLabel("Add New Supplier");
        removeProductLabel; 
        editProductLabel;
        addNewSupplierLabel;
        removeSupplierLabel;
        orderNewStockLabel;
        viewStockLevelsLabel;
        */

        //Stock Tab
        addNewProductButton = new JButton("Add");
        removeProductButton = new JButton("Remove");
        editProductButton = new JButton("Edit");
        orderNewStockButton = new JButton("New Order");
        viewStockLevelsButton = new JButton("View Levels");
        
        //Supplier Tab
        addNewSupplierButton = new JButton("Add");
        removeSupplierButton = new JButton("Remove");
                
        //Manager Tab
        salesSummaryLabel = new JLabel("Sales Summary");  
        timePeriod; //comboBox
        iSalesProfile ;
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
}

}// StaffUI

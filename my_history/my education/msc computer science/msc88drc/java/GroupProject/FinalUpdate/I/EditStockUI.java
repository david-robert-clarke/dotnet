package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
   The Edit Stock Interface
   
   This allows a staff member to update 
   <ul>
   <il>the retail price of the cds
   <il>the number of stocked items of a particular cd
   <il>the wholesale price of stock for a particular supplier
   <il>the supplier
   </ul>

   @author David Clarke, Helen Loynes
**/
class EditStockUI extends JFrame
{    
  //instance variables
  
  //ArrayLists
  private ArrayList cdEntry, stockEntries;
    
  //Strings
  private String iidText;
  private String cdText;
  private String artistText;
  private String genreText;
  private String typeText;    
  private String rDateText; 
  private String rPriceText;
  private String stockLevelText;
  private String wPriceText;

  //Labels
  private JLabel iidLabel;  
  private JLabel artistLabel;  
  private JLabel cdLabel;  
  private JLabel rPriceLabel;  
  private JLabel supplierLabel; 
  private JLabel wPriceLabel; 
  private JLabel numberItemsLabel;

  //Buttons
  private JButton cancelButton, okayButton;  
  
  //ComboBoxes
  private JComboBox supplierComboBox; 

  //Text Fields
  private JTextField iidTextField;
  private JTextField artistTextField; 
  private JTextField cdTextField;
  private JTextField rPriceTextField;
  private JTextField wPriceTextField;
  private JTextField numberItemsTextField;

  //Panels
  private JPanel buttonPanel;
  private JPanel editPanel;

  /**
   * Constructor to create a new UI that allows the user to edit stock
   *
   * @param cdArtistTitle an arraylist containing the cd title and artist
   **/
  public EditStockUI(ArrayList cdArtistTitle)
  {
    //use SQL statement to get the tuple corresponding to the 2 entries in the
    //arraylist "entry".
    cdEntry = new ArrayList();
    stockEntries = new ArrayList();
   
    String cdTitle = (String)cdArtistTitle.get(1);
    String cdArtist = (String)cdArtistTitle.get(0);

    CDSearchQuery cdSearch =
      new CDSearchQuery(cdArtist,cdTitle);
    GetStockDetailsQuery getStockDetails = 
      new GetStockDetailsQuery(cdArtist,cdTitle);
    cdEntry = cdSearch.exeQuery(); //returns a complete cd entry 
    stockEntries = getStockDetails.exeQuery();//returns the cds stock entries
      
    iidText = (String)cdEntry.get(0);
    cdText = (String)cdEntry.get(1);
    artistText = (String)cdEntry.get(2);
    rPriceText =(String)cdEntry.get(6);

    //editing fields for CD
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(7,1));
    iidLabel = new JLabel("Item ID:");
    iidTextField = new JTextField(iidText);
    iidTextField.setEnabled(false);
    artistLabel = new JLabel("Artist:");
    artistTextField = new JTextField(artistText);
    artistTextField.setEnabled(false);
    cdLabel = new JLabel("CD name:");   
    cdTextField = new JTextField(cdText);
    cdTextField.setEnabled(false);
    rPriceLabel = new JLabel("Retail Price:");
    rPriceTextField = new JTextField(rPriceText);
      
    //editing fields for STOCK
    supplierLabel = new JLabel("Supplier:");
    wPriceLabel = new JLabel("Wholesale Price:");
    wPriceTextField = new JTextField(wPriceText);
    numberItemsLabel = new JLabel("No in stock:");
    numberItemsTextField = new JTextField(stockLevelText);      
    supplierComboBox = new JComboBox();
    supplierComboBox.addActionListener(new ChoiceListener());
    for(int i=0; i<stockEntries.size(); i=i+5)
    {
      supplierComboBox.addItem((String)stockEntries.get(i));
    }

    editPanel.add(iidLabel);
    editPanel.add(iidTextField);
    editPanel.add(artistLabel);
    editPanel.add(artistTextField);  
    editPanel.add(cdLabel);
    editPanel.add(cdTextField);
    editPanel.add(rPriceLabel);
    editPanel.add(rPriceTextField);
    editPanel.add(supplierLabel);
    editPanel.add(supplierComboBox);
    editPanel.add(numberItemsLabel);
    editPanel.add(numberItemsTextField);
    editPanel.add(wPriceLabel);
    editPanel.add(wPriceTextField);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    okayButton = new JButton("OK");
    okayButton.addActionListener(new ButtonListener());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    buttonPanel.add(okayButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");   
  }
    
  public class ChoiceListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      int sI = ((supplierComboBox.getSelectedIndex())*5);
      String a = (String)stockEntries.get(sI + 2);
      String b = (String)stockEntries.get(sI + 3);

      if(a != null)
      {
	numberItemsTextField.setText(a);
	wPriceTextField.setText(b);
      }
    }
  }

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
        
      if(source == okayButton)
      {     
	//if the okay button has been pressed, take all information present
	//on the Edit Stock details page and overwrite the details present in 
	//thecdEntry ArrayList(excluding the iid),
	int s2 = ((supplierComboBox.getSelectedIndex())*5);

	stockEntries.set(s2+2,numberItemsTextField.getText());
	stockEntries.set(s2+3,wPriceTextField.getText());
	cdEntry.set(6,rPriceTextField.getText());

	//pass this arrayList directly to the EditCDEntryQuery class
	//new java query, which then updates the database      
	UpdateCDEntryQuery updateCD = new UpdateCDEntryQuery(cdEntry);
	updateCD.exeQuery();
	UpdateStockEntryQuery updateStock 
	  = new UpdateStockEntryQuery(stockEntries);
	updateStock.exeQuery();
	
	//Then exit this window
	dispose();
      }
      else if(source == cancelButton)
      {
	dispose();//closes this window
      }
    }      
  }
}


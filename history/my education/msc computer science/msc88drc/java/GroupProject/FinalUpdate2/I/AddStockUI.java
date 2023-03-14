package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

/**
   The Add Stock Interface
   
   This allows a staff member to add a new CD entry, this class automatically
   updates the CD and Stock Tables
   @author David Clarke, Helen Loynes

**/
class AddStockUI extends JFrame
{
  //ArrayList
  private ArrayList cdEntry, suppliers;

  //JFrame
  private JFrame frame;

  //Labels
  private JLabel artistLabel;
  private JLabel cdLabel;
  private JLabel genreLabel;
  private JLabel rDateLabel;
  private JLabel typeLabel;
  private JLabel rPriceLabel;
  private JLabel supNameLabel;
  private JLabel stockLevelLabel;
  private JLabel wPriceLabel;
  
  //Text Fields
  private JTextField artistTextField;
  private JTextField cdTextField;
  private JTextField rDateTextField;
  private JTextField rPriceTextField;
  private JTextField stockLevelTextField;
  private JTextField wPriceTextField;

  //Panels
  private JPanel editPanel;
  private JPanel buttonPanel;

  //Strings
  private String cdText;
  private String artistText;
  private String genreText;
  private String typeText;
  private String rDateText; 
  private String rPriceText;

  //Buttons
  private JButton cancelButton, okayButton;

  //Combo Boxes  
  private JComboBox genreComboBox;
  private JComboBox typeComboBox;
  private JComboBox supNameComboBox;

  //constructor
  public AddStockUI()
  {
    cdEntry = new ArrayList();//always initialise these bloody arraylists
    //editing fields
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(9,1));   
    artistLabel = new JLabel("Artist");
    artistTextField = new JTextField();    
    cdLabel = new JLabel("CD name");   
    cdTextField = new JTextField();
    genreLabel = new JLabel("Genre");
    genreComboBox = new JComboBox();
    genreComboBox.addItem("Rock");
    genreComboBox.addItem("Pop");
    genreComboBox.addItem("Heavy Metal");
    genreComboBox.addItem("R&B");
    genreComboBox.addItem("Hip Hop");
    genreComboBox.addItem("Soul");
    genreComboBox.addItem("Dance");
    genreComboBox.addItem("Drum & Base");
    genreComboBox.addItem("Garage");
    genreComboBox.addItem("Classical");
    genreComboBox.addItem("Jazz");
    typeLabel = new JLabel("Type");
    typeComboBox = new JComboBox();
    typeComboBox.addItem("Single");
    typeComboBox.addItem("Album");
    rDateLabel = new JLabel ("Release Date");
    rDateTextField = new JTextField(rDateText);
    rPriceLabel = new JLabel("Retail Price");
    rPriceTextField = new JTextField(rPriceText);
    supNameLabel = new JLabel("Supplier Name");
    supNameComboBox = new JComboBox();
    //add query that fetches an arraylist of suppliers
    System.out.println("I'm here");
    GetSupplierNameQuery thisQuery = new GetSupplierNameQuery();
    suppliers = thisQuery.exeQuery();//query  
    for (int i=0; i<suppliers.size(); i++)
      {
	supNameComboBox.addItem((String)suppliers.get(i));
      }

    stockLevelLabel = new JLabel("Stock Level");
    stockLevelTextField = new JTextField();
    wPriceLabel = new JLabel("Wholesale Price");
    wPriceTextField = new JTextField();
    editPanel.add(cdLabel);
    editPanel.add(cdTextField);
    editPanel.add(artistLabel);
    editPanel.add(artistTextField);
    editPanel.add(genreLabel);
    editPanel.add(genreComboBox);
    editPanel.add(typeLabel);
    editPanel.add(typeComboBox);
    editPanel.add(rDateLabel);
    editPanel.add(rDateTextField);
    editPanel.add(rPriceLabel);
    editPanel.add(rPriceTextField);
    editPanel.add(supNameLabel);
    editPanel.add(supNameComboBox);
    editPanel.add(stockLevelLabel);
    editPanel.add(stockLevelTextField);
    editPanel.add(wPriceLabel);
    editPanel.add(wPriceTextField);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    okayButton = new JButton("OK");
    okayButton.addActionListener(new ButtonListener());
    buttonPanel.add(okayButton);
    buttonPanel.add(cancelButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      int numberOfErrors = 0;
      Object source = event.getSource();
      
      if(source == okayButton)
      {
	//if the cd Text Field is NULL then 
	if(cdTextField.getText().equals("")) numberOfErrors ++;
	if(artistTextField.getText().equals("")) numberOfErrors ++;
	if(rDateTextField.getText().equals("")) numberOfErrors ++;
	if(rPriceTextField.getText().equals("")) numberOfErrors ++;
	if(stockLevelTextField.getText().equals("")) numberOfErrors ++;
	if(wPriceTextField.getText().equals("")) numberOfErrors ++;

	if(numberOfErrors>0)
	{
	  JOptionPane.showMessageDialog(frame,"Blank Fields");
	}
	else
	{
	  //if the okay button has been pressed, take all information present
	  //on the Edit CD details page and overwrite the details present in 
	  //the cdEntry ArrayList(excluding the iid),
	  cdEntry.add(cdTextField.getText());
	  cdEntry.add(artistTextField.getText());
	  cdEntry.add((String)genreComboBox.getSelectedItem());
	  cdEntry.add((String)typeComboBox.getSelectedItem());
	  cdEntry.add(rDateTextField.getText());
	  cdEntry.add(rPriceTextField.getText());
	  cdEntry.add((String)supNameComboBox.getSelectedItem());
	  cdEntry.add(stockLevelTextField.getText());
	  cdEntry.add(wPriceTextField.getText());
	  
	  //pass this arrayList directly to the AddCDTupleQuery class
	  //new java query, which adds a tuple to the database      
	  AddCDTupleQuery addCD = new AddCDTupleQuery(cdEntry);
	  addCD.exeQuery();
	  
	  //Then exit this window
	  dispose();
	}	
      }      
      else if(source == cancelButton)
      {
	dispose();
      }
      
    }      
  }
}

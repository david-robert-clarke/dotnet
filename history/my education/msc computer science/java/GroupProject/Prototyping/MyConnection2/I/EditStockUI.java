package I;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class EditStockUI extends JFrame
{    
  //instance variables
  ArrayList entry;
  ArrayList cdEntry;
  
  
  JLabel blankLabel0, blankLabel1;
  JPanel editPanel;
  JLabel titleLabel;
  JLabel cdLabel;
  JTextField cdTextField;
  String cdText;//
  JLabel artistLabel;
  JTextField artistTextField;
  String artistText;//
  JLabel genreLabel;
  JComboBox genreComboBox;
  String genreText;//
  JLabel typeLabel;
  JComboBox typeComboBox;
  String typeText;//
  JLabel rDateLabel;
  JTextField rDateTextField;
  String rDateText;//  
  JLabel rPriceLabel;
  JTextField rPriceTextField;
  String rPriceText;//
  JPanel buttonPanel;
  JButton cancelButton, okayButton;

  //constructor
  public EditStockUI(ArrayList cdArtistTitle)
  {
    //use SQL statement to get the tuple corresponding to the 2 entries in the
    //arraylist "entry".
    cdEntry = new ArrayList();

    String cdArtist = (String)cdArtistTitle.get(0);
    String cdTitle = (String)cdArtistTitle.get(1);
    CDSearch searchForCD = new CDSearch(cdArtist,cdTitle);
    cdEntry = searchForCD.exeQuery(); //returns a complete cd entry 
    cdText = (String)cdEntry.get(1);
    artistText = (String)cdEntry.get(2);
    genreText = (String)cdEntry.get(3);
    typeText = (String)cdEntry.get(4);
    rDateText =(String)cdEntry.get(5);
    rPriceText = (String)cdEntry.get(6);

    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(15,1));
    titleLabel = new JLabel("Enter your new CD details below");
    cdLabel = new JLabel("CD name");   
    cdTextField = new JTextField(cdText); //
   
    artistLabel = new JLabel("Artist");
    artistTextField = new JTextField(artistText);//

    genreLabel = new JLabel("Genre");
    genreComboBox = new JComboBox();
    genreComboBox.addItem("Rock");
    genreComboBox.addItem("Pop");
    genreComboBox.addItem("Heavy Metal");
    genreComboBox.addItem("R&B");
    genreComboBox.addItem("Hip Hop");
    genreComboBox.addItem("Soul");
    genreComboBox.addItem("Dance");
    genreComboBox.addItem("Garage");
    genreComboBox.addItem("Alternative");
    genreComboBox.addItem("Various");
    genreComboBox.setSelectedItem(genreText);//
    typeLabel = new JLabel("Type");
    typeComboBox = new JComboBox();
    typeComboBox.addItem("Single");
    typeComboBox.addItem("Album");
    typeComboBox.setSelectedItem(typeText);//
    rDateLabel = new JLabel ("Release Date");
    rDateTextField = new JTextField(rDateText);//
    rPriceLabel = new JLabel("Retail Price");
    rPriceTextField = new JTextField(rPriceText);//

    editPanel.add(titleLabel);
    editPanel.add(blankLabel0);
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
    editPanel.add(blankLabel1);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new CancelButtonListener());
    okayButton = new JButton("OK");
    okayButton.addActionListener(new OkayButtonListener());
    buttonPanel.add(cancelButton);
    buttonPanel.add(okayButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  public class CancelButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //if the cancel button has been pressed, close down this window
      System.out.println("I'm CANCELLED");
    }      
  }

  public class OkayButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //if the okay button has been pressed, take all information present
      //on the Edit CD details page and overwrite the details present in the
      //cdEntry ArrayList(excluding the iid),
      cdEntry.set(1,cdTextField.getText());
      cdEntry.set(2,artistTextField.getText());
      cdEntry.set(3,(String)genreComboBox.getSelectedItem());
      cdEntry.set(4,(String)typeComboBox.getSelectedItem());
      cdEntry.set(5,rDateTextField.getText());
      cdEntry.set(6,rPriceTextField.getText());

      for(int i=0;i<cdEntry.size();i++)
      {
	System.out.println((String)cdEntry.get(i));
      }
      
      //pass this arrayList directly to the EditCDEntryQuery class
      //new java query, which then updates the database      
      UpdateCDEntryQuery updateCD = new UpdateCDEntryQuery(cdEntry);
      updateCD.exeQuery();

      //Then exit this window
      System.out.println("This window should close now");
      System.out.println("The list in the stock table should update");
    }      
  }
}

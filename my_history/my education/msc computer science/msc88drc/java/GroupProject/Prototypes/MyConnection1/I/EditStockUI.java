package I;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class EditStockUI extends JFrame
{    
  //instance variables
  ArrayList entry;
  
  JLabel blankLabel0;  
  JLabel blankLabel1;
  JPanel editPanel;
  JLabel titleLabel;
  JLabel cdLabel;
  JTextField cdTextField;
  JLabel artistLabel;
  JTextField artistTextField;
  JLabel genreLabel;
  JComboBox genreComboBox;
  JLabel typeLabel;
  JComboBox typeComboBox;
  JLabel rPriceLabel;
  JTextField rPriceTextField;
  JPanel buttonPanel;
  JButton cdChangeButton;
  JButton artistChangeButton;

  //constructor
  public EditStockUI(ArrayList entry)
  {
    //use SQL statement to get the tuple corresponding to the 2 entries in the
    //arraylist "entry".


    for(int k=0;k<entry.size();k++)
    {
      System.out.println((String)entry.get(k));
    }

    //editing fields
    blankLabel0 = new JLabel();
    blankLabel1 = new JLabel();
    editPanel = new JPanel();
    editPanel.setLayout(new GridLayout(13,1));
    titleLabel = new JLabel("Enter your new CD details below");
    cdLabel = new JLabel("CD name");   
    cdTextField = new JTextField();    
    artistLabel = new JLabel("Artist");
    artistTextField = new JTextField();
    genreLabel = new JLabel("Genre");
    genreComboBox = new JComboBox();
    genreComboBox.addItem("Rock & Pop");
    genreComboBox.addItem("Heavy Metal");
    genreComboBox.addItem("R&B");
    genreComboBox.addItem("Hip Hop");
    genreComboBox.addItem("Soul");
    genreComboBox.addItem("Dance");
    genreComboBox.addItem("Garage");
    genreComboBox.addItem("Alternative");  
    typeLabel = new JLabel("Type");
    typeComboBox = new JComboBox();
    typeComboBox.addItem("Single");
    typeComboBox.addItem("Album");
    rPriceLabel = new JLabel("Retail Price");
    rPriceTextField = new JTextField();

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
    editPanel.add(rPriceLabel);
    editPanel.add(rPriceTextField);
    editPanel.add(blankLabel1);

    //confirmation buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    cdChangeButton = new JButton("Cancel");
    artistChangeButton = new JButton("OK");
    buttonPanel.add(cdChangeButton);
    buttonPanel.add(artistChangeButton);

    Container contentPane = getContentPane();
    contentPane.add(editPanel,"Center");
    contentPane.add(buttonPanel, "South");
    
  }

  //if OK is clicked, 
  //save all the data in a new array.

  //Use SQL statement to edit the entry in question

  //Directly change the data in the database for that particular entry
  //Then exit this window
}


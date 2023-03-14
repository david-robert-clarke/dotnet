package I;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StaffOrderUI extends JFrame
{
  
  private JLabel titleLabel;  
  private JLabel blankLabel;  
  private JPanel headerPanel; 
  private JLabel itemIDLabel ; 
  private JLabel supIDLabel ; 
  private JLabel sNoBought;
  private JLabel blankLabel2;
  

  private JPanel titlePanel; 
  private JPanel blankPanel; 
  private JPanel textFieldPanel0; 
  private JPanel textFieldPanel1; 
  private JPanel textFieldPanel2; 
  private JPanel textFieldPanel3; 
  private JPanel textFieldPanel4; 
  private JPanel textFieldPanel5; 
  private JPanel textFieldPanel6; 
  private JPanel textFieldPanel7; 
  private JPanel textFieldPanel8;
  private JPanel textFieldPanel9; 
  private JPanel buttonPanel; 
  private JPanel areaPanel;
  private JPanel blankPanel2; 
  

  private JTextField blank1; 
  private JTextField blank2; 
  private JTextField blank3; 
  private JTextField blank4; 
  private JTextField blank5; 
  private JTextField blank6;
  private JTextField blank7; 
  private JTextField blank8; 
  private JTextField blank9; 
  private JTextField blank10; 
  private JTextField blank11;
  private JTextField blank12;
  private JTextField blank13;
  private JTextField blank14;
  private JTextField blank15;
  private JTextField blank16;
  private JTextField blank17;
  private JTextField blank18;
  private JTextField blank19;
  private JTextField blank20;
  private JTextField blank21;
  private JTextField blank22;
  private JTextField blank23;
  private JTextField blank24;
  private JTextField blank25;
  private JTextField blank26;
  private JTextField blank27;
  private JTextField blank28;
  private JTextField blank29;
  private JTextField blank30;
  

  private JButton confirmButton;
  private JButton cancelButton;
  


  public StaffOrderUI()
  {
        
    titlePanel = new JPanel();
    titleLabel=new JLabel("Please enter your staff order " +
				 "details below:");
    titlePanel.setLayout(new GridLayout(1,1));
    titlePanel.add(titleLabel);

    blankPanel = new JPanel();
    blankLabel = new JLabel();
    blankPanel.add(blankLabel);

    headerPanel = new JPanel();
    itemIDLabel = new JLabel("Item ID");
    supIDLabel = new JLabel("Supplier ID");
    sNoBought = new JLabel ("Quantity");
        
    headerPanel.setLayout(new GridLayout(1,3));
    headerPanel.add(itemIDLabel);
    headerPanel.add(supIDLabel);
    headerPanel.add(sNoBought);
        
    textFieldPanel0 = new JPanel();
    blank1 = new JTextField();
    blank2 = new JTextField();
    blank3 = new JTextField();        
    textFieldPanel0.setLayout(new GridLayout(1,3));
    textFieldPanel0.add(blank1);
    textFieldPanel0.add(blank2);
    textFieldPanel0.add(blank3);

    textFieldPanel1 = new JPanel();
    blank4 = new JTextField();
    blank5 = new JTextField();
    blank6 = new JTextField();        
    textFieldPanel1.setLayout(new GridLayout(1,3));
    textFieldPanel1.add(blank4);
    textFieldPanel1.add(blank5);
    textFieldPanel1.add(blank6);
        
    textFieldPanel2 = new JPanel();
    blank7 = new JTextField();
    blank8 = new JTextField();
    blank9 = new JTextField();        
    textFieldPanel2.setLayout(new GridLayout(1,3));
    textFieldPanel2.add(blank7);
    textFieldPanel2.add(blank8);
    textFieldPanel2.add(blank9);

    textFieldPanel3 = new JPanel();
    blank10 = new JTextField();
    blank11 = new JTextField();
    blank12 = new JTextField();        
    textFieldPanel3.setLayout(new GridLayout(1,3));
    textFieldPanel3.add(blank10);
    textFieldPanel3.add(blank11);
    textFieldPanel3.add(blank12);
        
    textFieldPanel4 = new JPanel();
    blank13 = new JTextField();
    blank14 = new JTextField();
    blank15 = new JTextField();        
    textFieldPanel4.setLayout(new GridLayout(1,3));
    textFieldPanel4.add(blank13);
    textFieldPanel4.add(blank14);
    textFieldPanel4.add(blank15);

    textFieldPanel5 = new JPanel();
    blank16 = new JTextField();
    blank17 = new JTextField();
    blank18 = new JTextField();        
    textFieldPanel5.setLayout(new GridLayout(1,3));
    textFieldPanel5.add(blank16);
    textFieldPanel5.add(blank17);
    textFieldPanel5.add(blank18);

    textFieldPanel6 = new JPanel();
    blank19 = new JTextField();
    blank20 = new JTextField();
    blank21 = new JTextField();        
    textFieldPanel6.setLayout(new GridLayout(1,3));
    textFieldPanel6.add(blank19);
    textFieldPanel6.add(blank20);
    textFieldPanel6.add(blank21);

    textFieldPanel7 = new JPanel();
    blank22 = new JTextField();
    blank23 = new JTextField();
    blank24 = new JTextField();        
    textFieldPanel7.setLayout(new GridLayout(1,3));
    textFieldPanel7.add(blank22);
    textFieldPanel7.add(blank23);
    textFieldPanel7.add(blank24);

    textFieldPanel8 = new JPanel();
    blank25 = new JTextField();
    blank26 = new JTextField();
    blank27 = new JTextField();        
    textFieldPanel8.setLayout(new GridLayout(1,3));
    textFieldPanel8.add(blank25);
    textFieldPanel8.add(blank26);
    textFieldPanel8.add(blank27);
        
    textFieldPanel9 = new JPanel();
    blank28 = new JTextField();
    blank29 = new JTextField();
    blank30 = new JTextField();        
    textFieldPanel9.setLayout(new GridLayout(1,3));
    textFieldPanel9.add(blank28);
    textFieldPanel9.add(blank29);
    textFieldPanel9.add(blank30);

    blankPanel2 = new JPanel();
    blankLabel2 = new JLabel();
    blankPanel2.add(blankLabel2);

    buttonPanel = new JPanel();
    confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ButtonListener());
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ButtonListener());
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.add(confirmButton);
    buttonPanel.add(cancelButton);

    areaPanel = new JPanel();
    areaPanel.setLayout(new GridLayout(15,1));
    areaPanel.add(titlePanel);
    areaPanel.add(blankPanel);
    areaPanel.add(headerPanel);
    areaPanel.add(textFieldPanel0);
    areaPanel.add(textFieldPanel1);
    areaPanel.add(textFieldPanel2);
    areaPanel.add(textFieldPanel3);
    areaPanel.add(textFieldPanel4);
    areaPanel.add(textFieldPanel5);
    areaPanel.add(textFieldPanel6);
    areaPanel.add(textFieldPanel7);
    areaPanel.add(textFieldPanel8);
    areaPanel.add(textFieldPanel9);
    areaPanel.add(blankPanel2);
    areaPanel.add(buttonPanel);
        
    Container contentPane = getContentPane();
    contentPane.add(areaPanel, "Center");
  }

  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();

      if (source == confirmButton)
      {
      }
      else if(source == cancelButton)
      {
	dispose();
      }
    }
  }

} 



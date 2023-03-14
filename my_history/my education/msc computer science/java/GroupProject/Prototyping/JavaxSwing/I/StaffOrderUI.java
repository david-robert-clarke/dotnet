package I;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffOrderUI
{
    public static void main(String[] args)
    {
        StaffOrdersUI frame = new StaffOrdersUI();
        frame.setTitle("Staff Orders"); 
        frame.setSize(400,500);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);       
    }
}   

class StaffOrdersUI extends JFrame
{
    private String fname;
    private JPanel topPanel,bottomPanel,areaPanel;
    private JLabel greeting, advice;
    private JButton changePWButton, editConDetButton;

    public StaffOrdersUI()
    {
        
        JPanel titlePanel = new JPanel();
        JLabel titleLabel=new JLabel("Please enter your staff order " +
		     "details below:");
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.add(titleLabel);

        JPanel blankPanel = new JPanel();
        JLabel blankLabel = new JLabel();
        blankPanel.add(blankLabel);

        JPanel headerPanel = new JPanel();
        JLabel itemIDLabel = new JLabel("Item ID");
        JLabel supIDLabel = new JLabel("Supplier ID");
        JLabel sNoBought = new JLabel ("Quantity");
        
        headerPanel.setLayout(new GridLayout(1,3));
        headerPanel.add(itemIDLabel);
        headerPanel.add(supIDLabel);
        headerPanel.add(sNoBought);
        
        JPanel textFieldPanel0 = new JPanel();
        JTextField blank1 = new JTextField();
        JTextField blank2 = new JTextField();
        JTextField blank3 = new JTextField();        
        textFieldPanel0.setLayout(new GridLayout(1,3));
        textFieldPanel0.add(blank1);
        textFieldPanel0.add(blank2);
        textFieldPanel0.add(blank3);

        JPanel textFieldPanel1 = new JPanel();
        JTextField blank4 = new JTextField();
        JTextField blank5 = new JTextField();
        JTextField blank6 = new JTextField();        
        textFieldPanel1.setLayout(new GridLayout(1,3));
        textFieldPanel1.add(blank4);
        textFieldPanel1.add(blank5);
        textFieldPanel1.add(blank6);
        
        JPanel textFieldPanel2 = new JPanel();
        JTextField blank7 = new JTextField();
        JTextField blank8 = new JTextField();
        JTextField blank9 = new JTextField();        
        textFieldPanel2.setLayout(new GridLayout(1,3));
        textFieldPanel2.add(blank7);
        textFieldPanel2.add(blank8);
        textFieldPanel2.add(blank9);

        JPanel textFieldPanel3 = new JPanel();
        JTextField blank10 = new JTextField();
        JTextField blank11 = new JTextField();
        JTextField blank12 = new JTextField();        
        textFieldPanel3.setLayout(new GridLayout(1,3));
        textFieldPanel3.add(blank10);
        textFieldPanel3.add(blank11);
        textFieldPanel3.add(blank12);
        
        JPanel textFieldPanel4 = new JPanel();
        JTextField blank13 = new JTextField();
        JTextField blank14 = new JTextField();
        JTextField blank15 = new JTextField();        
        textFieldPanel4.setLayout(new GridLayout(1,3));
        textFieldPanel4.add(blank13);
        textFieldPanel4.add(blank14);
        textFieldPanel4.add(blank15);

        JPanel textFieldPanel5 = new JPanel();
        JTextField blank16 = new JTextField();
        JTextField blank17 = new JTextField();
        JTextField blank18 = new JTextField();        
        textFieldPanel5.setLayout(new GridLayout(1,3));
        textFieldPanel5.add(blank16);
        textFieldPanel5.add(blank17);
        textFieldPanel5.add(blank18);

        JPanel textFieldPanel6 = new JPanel();
        JTextField blank19 = new JTextField();
        JTextField blank20 = new JTextField();
        JTextField blank21 = new JTextField();        
        textFieldPanel6.setLayout(new GridLayout(1,3));
        textFieldPanel6.add(blank19);
        textFieldPanel6.add(blank20);
        textFieldPanel6.add(blank21);

        JPanel textFieldPanel7 = new JPanel();
        JTextField blank22 = new JTextField();
        JTextField blank23 = new JTextField();
        JTextField blank24 = new JTextField();        
        textFieldPanel7.setLayout(new GridLayout(1,3));
        textFieldPanel7.add(blank22);
        textFieldPanel7.add(blank23);
        textFieldPanel7.add(blank24);

        JPanel textFieldPanel8 = new JPanel();
        JTextField blank25 = new JTextField();
        JTextField blank26 = new JTextField();
        JTextField blank27 = new JTextField();        
        textFieldPanel8.setLayout(new GridLayout(1,3));
        textFieldPanel8.add(blank25);
        textFieldPanel8.add(blank26);
        textFieldPanel8.add(blank27);
        
        JPanel textFieldPanel9 = new JPanel();
        JTextField blank28 = new JTextField();
        JTextField blank29 = new JTextField();
        JTextField blank30 = new JTextField();        
        textFieldPanel9.setLayout(new GridLayout(1,3));
        textFieldPanel9.add(blank28);
        textFieldPanel9.add(blank29);
        textFieldPanel9.add(blank30);

        JPanel blankPanel2 = new JPanel();
        JLabel blankLabel2 = new JLabel();
        blankPanel2.add(blankLabel2);

        JPanel buttonPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ButtonListener());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ButtonListener());
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        JPanel areaPanel = new JPanel();
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

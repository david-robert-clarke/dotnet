package I;
import javax.swing.*;
import java.awt.*;

public class StaffDetailsUI
{
    public static void main(String[] args)
    {
        StaffDetailsFrame frame = new StaffDetailsFrame();
        frame.setTitle("Staff Details"); 
        frame.setSize(300,300);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);       
    }
}   

class StaffDetailsFrame extends JFrame
{
    private String fname;
    private JPanel topPanel,bottomPanel,areaPanel;
    private JLabel greeting, advice;
    private JButton changePWButton, editConDetButton;

    public StaffDetailsFrame()
    {
        fname = "Dave";
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4,1));
        greeting = new JLabel("Welcome " +  fname + " to the Staff User"+
		     " Interface.");
        advice = new JLabel("Choose an Option:");
        topPanel.add(greeting);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(advice);
        bottomPanel = new JPanel();
        changePWButton = new JButton("Change Password");
        editConDetButton = new JButton("Edit Contact Details");
        bottomPanel.setLayout(new GridLayout(4,1));
        bottomPanel.add(changePWButton);
        bottomPanel.add(editConDetButton);
        areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(2,1));    
        areaPanel.add(topPanel);
        areaPanel.add(bottomPanel);

        Container contentPane = getContentPane();
        contentPane.add(areaPanel, "Center");
    }
} 

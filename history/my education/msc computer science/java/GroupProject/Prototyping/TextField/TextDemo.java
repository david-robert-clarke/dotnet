/*
 * Swing Version
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JApplet implements ActionListener {

    private JPanel xyPanel,controlPanel;
    private JTextField xField,yField,aField; 

    //Hack to avoid annoying error message (1.1).
    public TextDemo() {
        getRootPane().putClientProperty("defeatSystemEventQueueCheck",
                                        Boolean.TRUE);
    }

    public void init() 
    {

        // Text Fields
        xField = new JTextField("Coldplay");
        xField.addActionListener(this); 
        xField.setToolTipText("Choose the balls starting postion along the x-axis.");
        yField = new JTextField("Rush of Blood to the Head");
        yField.addActionListener(this);
        yField.setToolTipText("Choose the balls starting postion along the y-axis.");
        aField = new JTextField("");
        aField.addActionListener(this);
        aField.setToolTipText("Choose the balls initial angle of projection.");

        // Add components to Panels
        xyPanel = new JPanel();
        xyPanel.setLayout(new GridLayout(1,6));
        xyPanel.add(new JLabel("Artist:"));
        xyPanel.add(xField);
        xyPanel.add(new JLabel("Title:"));
        xyPanel.add(yField);
        xyPanel.add(new JLabel("Song: "));
        xyPanel.add(aField);

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,1));
        controlPanel.add(xyPanel);

        Container contentPane = getContentPane();
        contentPane.add(controlPanel,"South");
    }

    public void actionPerformed(ActionEvent evt) 
    {
        int xValue = 0;
        int yValue = 0;
        int aValue = 0;

        xValue = Integer.parseInt(xField.getText());
        yValue = Integer.parseInt(yField.getText());
        aValue = Integer.parseInt(aField.getText());
    }
}

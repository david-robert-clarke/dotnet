import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class TabbedPaneDemo extends JPanel {
    public TabbedPaneDemo() {
        ImageIcon icon = new ImageIcon("rgtgtreble.gif");
        ImageIcon icon0 = new ImageIcon("javalogo.gif");
        JTabbedPane tabbedPane = new JTabbedPane();

        Component panel0 = makeTextPanel("General Music Selection");
        tabbedPane.addTab("Home", icon0, panel0, "Does nothing at all");

        Component panel1 = makeTextPanel("Music Selection by Album");
        tabbedPane.addTab("Album", icon, panel1, "Does jack");
        tabbedPane.setSelectedIndex(0);

        Component panel2 = makeTextPanel("Music Selection by Single");
        tabbedPane.addTab("Single", icon, panel2, "Does twice as much nothing");

        //Add the tabbed pane to this panel.
        setLayout(new GridLayout(1, 1)); 
        add(tabbedPane);
    }

    protected Component makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        frame.getContentPane().add(new TabbedPaneDemo(), 
                                   BorderLayout.CENTER);
        frame.setSize(400, 125);
        frame.setVisible(true);
    }
}

package I;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ScrollPaneJListDemo
{
    public static void main(String[] args)
    {
        Helen frame = new Helen();
        frame.setTitle("Staff Details"); 
        frame.setSize(300,300);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);       
    }
}   

class Helen extends JFrame
{
    private JList textArea;

    public Helen()
    {
         //Create the list of images and put it in a scroll pane
        Vector dave = new Vector();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        String f = "f";
        String g = "g";
        String h = "h";
        String i = "i";
        String j = "j";
        String k = "k";
        String l = "l";
        String m = "g";
        String n = "h";
        String o = "i";
        String p = "j";
        String q = "k";
        String r = "l";
        dave.add(a);
        dave.add(b);
        dave.add(c);
        dave.add(d);
        dave.add(e);
        dave.add(f);
        dave.add(g);
        dave.add(h);
        dave.add(i);
        dave.add(j);
        dave.add(k);
        dave.add(l);
        dave.add(m);
        dave.add(n);
        dave.add(o);
        dave.add(p);
        dave.add(q);
        dave.add(r);

        textArea = new JList(dave);
        JScrollPane scrollPane = new JScrollPane(textArea);
        Container contentPane = getContentPane();
        //contentPane.setPreferredSize(new Dimension(400, 100));
        contentPane.add(scrollPane, BorderLayout.CENTER);

    }
} 

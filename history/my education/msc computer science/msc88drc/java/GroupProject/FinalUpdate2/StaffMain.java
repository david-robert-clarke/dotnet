import I.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class provides a login screen for the user. 
 * 
 * @author David Clarke
 **/

public class StaffMain
{
    public static void main (String[] args)
    {
        LogInUI thisScreen = new LogInUI();
        thisScreen.setSize(250,250);
        thisScreen.setTitle("Staff Login");
	thisScreen.setLocation(500,350);
        thisScreen.show();
	thisScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	thisScreen.setResizable(false);
    }
}

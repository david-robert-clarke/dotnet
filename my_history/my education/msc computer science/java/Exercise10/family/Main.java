package family;

import family.ui.FamilyTreeBrowser;

/**
 Simple class to start the program.
*/
public class Main
{
   /**
      Creates a new instance of the GUI class <code>FamilyTreeBrowser</code>.
   */
   public static void main(String[] args)
   {
      FamilyTreeBrowser browser = new FamilyTreeBrowser();
      browser.pack();
      browser.setVisible(true);
   }
}

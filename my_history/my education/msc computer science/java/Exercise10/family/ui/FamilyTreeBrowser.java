package family.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


import family.*;
import family.ui.visual.VisualComponent;

public class FamilyTreeBrowser extends JFrame
{
   protected static final String ANCESTORS = "Ancestors";
   protected static final String DESCENDANTS = "Descendants";
   protected static final String PARENTS = "Parents";
   protected static final String CHILDREN = "Children";
   protected static final String SIBLINGS = "Siblings";
   protected static final String COUSINS = "Cousins";
   
   final PersonComparator personComparator = new PersonComparator();
   
   private FamilyTree tree;
   private Person selectedPerson;
   
   private FamilyTreeView treeView;
   private PersonForm personForm;
   private DetailPane personDetails;
   
   private JPopupMenu nodeMenu, 
                      addMenu;
   private JMenu fileMenu,
                 selectionMenu,
                 treeMenu;
   private Point addPersonLocation;
   
   public FamilyTreeBrowser()
   {
      super("Family Tree Browser");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // build the main part of the ui
      tree = new FamilyTree();
      treeView = new FamilyTreeView(tree);
      treeView.addMouseListener(new FTVMouseListener());
      treeView.addSelectionChangeListener(new SelectionHandler());
      personDetails = new DetailPane();
      
      Container content = getContentPane();
      content.setLayout(new BorderLayout());
      content.add(new JScrollPane(personDetails), BorderLayout.EAST);
      content.add(new JScrollPane(treeView), BorderLayout.CENTER);
      
      addPersonLocation = new Point();
      
      // build the menus
      JMenuBar menuBar = new JMenuBar();
      
      // file menu
      fileMenu = new JMenu("File");
      
      fileMenu.add(new AbstractAction("New") {
         public void actionPerformed(ActionEvent e) {
            doNew(); } } );
      fileMenu.add(new AbstractAction("Load") {
         public void actionPerformed(ActionEvent e) {
            doLoad(); } } );
      fileMenu.add(new AbstractAction("Save") {
         public void actionPerformed(ActionEvent e) {
            doSave(); } } );
      fileMenu.addSeparator();
      fileMenu.add(new AbstractAction("Quit") {
         public void actionPerformed(ActionEvent e) {
            doQuit(); } } );
      
      // tree, selection, add and node menus (share some items)
      selectionMenu = new JMenu("Selection");
      treeMenu = new JMenu("Tree");
      nodeMenu = new JPopupMenu();
      addMenu = new JPopupMenu();
      
          
      Action addAction = new AbstractAction("Add Person") {
         public void actionPerformed(ActionEvent e) {
            doAdd(); } };      
      Action layoutAction = new AbstractAction("Layout Tree") {
         public void actionPerformed(ActionEvent e) {
            treeView.layoutTree(); } };
      Action editAction = new AbstractAction("Edit") {
         public void actionPerformed(ActionEvent e) {
            doEdit(); } };
      Action removeAction = new AbstractAction("Remove") { 
         public void actionPerformed(ActionEvent e) {
            doRemove(); } };
      
      
      selectionMenu.add(editAction);
      selectionMenu.add(removeAction);
      selectionMenu.add(buildSetParentMenu(Person.MALE));
      selectionMenu.add(buildSetParentMenu(Person.FEMALE));
      selectionMenu.add(buildHighlightMenu());
      
      treeMenu.add(addAction);
      treeMenu.add(layoutAction);
      
      nodeMenu.add(editAction);
      nodeMenu.add(removeAction);
      nodeMenu.add(buildSetParentMenu(Person.MALE));
      nodeMenu.add(buildSetParentMenu(Person.FEMALE));
      nodeMenu.add(buildHighlightMenu());
      
      addMenu.add(addAction);
      
      // add listeners to those menus that need it.
      selectionMenu.getPopupMenu().addPopupMenuListener(new PopupHandler());
      
      // add menus to menu bar
      menuBar.add(fileMenu);
      menuBar.add(selectionMenu);
      menuBar.add(treeMenu);
      setJMenuBar(menuBar);
   }
   
   // helper for menu init
   private JMenu buildHighlightMenu()
   {
      JMenu menu = new JMenu("Highlight");
      
      menu.add(new HighlightAction(ANCESTORS));
      menu.add(new HighlightAction(DESCENDANTS));
      menu.add(new HighlightAction(PARENTS));
      menu.add(new HighlightAction(CHILDREN));
      menu.add(new HighlightAction(SIBLINGS));
      menu.add(new HighlightAction(COUSINS));
      
      return menu;
   }
   
   // helper for menu init
   private JMenu buildSetParentMenu(boolean parent)
   {
      SetParentNullAction setParentNull = new SetParentNullAction(parent);
      JListMenuPanel setParentList = new JListMenuPanel(new ArrayList(),
                                     new SetParentAction(parent));
      
      String label = (parent == Person.MALE) ? "Set Father"
                                             : "Set Mother";
      JMenu menu = new JMenu(label);
      menu.add(setParentNull);
      menu.addSeparator();
      menu.add(setParentList);
      menu.addMenuListener(new SetParentMenuListener(parent));
      
      return menu;
   }
   
   // create a new blank tree
   protected void doNew()
   {
      tree = new FamilyTree();
      treeView.setTree(tree);
   }
   
   // load a tree from a file
   protected void doLoad()
   {
      JFileChooser chooser = createFileChooser();
      int option = chooser.showOpenDialog(this);
      if (option == JFileChooser.APPROVE_OPTION)
      {
         String filePath = chooser.getSelectedFile().getAbsolutePath();
         try
         {
            
            ObjectInputStream objIn = 
               new ObjectInputStream(new FileInputStream(filePath));
            tree = (FamilyTree)objIn.readObject();
            objIn.close();
            treeView.setTree(tree);
         }
         catch (ClassNotFoundException cnf)
         {
            showError("Internal Error...", "Unable to locate class for " + 
               "serialised FamilyTree object");
         }
         catch (InvalidClassException ic)
         {
            showError("Internal Error...", "Serialised object does not " + 
               "match class descriptor.\nChanges may have been made to " + 
               "the class since serialisation occured.");
         }
         catch (FileNotFoundException fnf)
         {
            showError("File Not Found...", "Unable to locate the " + 
               "specified file: " + filePath);
         }
         catch (IOException io)
         {
            showError("File Error...", "Unable to read file '" + filePath + 
               "'.\nPlease ensure that it is a valid FamilyTree file.");
         }
      }
   }           
   
   // save the current tree to a file
   protected void doSave()
   {
      JFileChooser chooser = createFileChooser();
      int option = chooser.showSaveDialog(this);
      if (option == JFileChooser.APPROVE_OPTION)
      {
         File chosen = chooser.getSelectedFile();
         String filePath = chosen.getAbsolutePath();
         
         if (chosen.exists())
         {
            if (!chosen.canWrite())
            {
               showError("Save Error...", "Unable to write file '" + 
                         filePath + "'. Access denied.");
               return;
            }
            if (!confirm("Save File...", "Overwrite file '" + filePath + "'?"))
               return;
         }
            
            
         try
         {
            ObjectOutputStream objOut = 
               new ObjectOutputStream(new FileOutputStream(filePath));
            objOut.writeObject(tree);
            objOut.close();
         }
         catch (NotSerializableException ns)
         {
            showError("Internal Error...", "Could not serialize tree. " + 
               "FamilyTree or Person class does not correctly support " + 
               "serialization");
         }
         catch (IOException io)
         {
            showError("Save Error...", "An error occurred while trying to " + 
               "write to the file '" + filePath + "'.\nThe tree will not have " + 
               "been saved successfully.");
         }
      }
   }
   
   // add a person to the tree
   protected void doAdd()
   {
      new PersonForm(this, null).setVisible(true);
   }
   
   // called from PersonForm when new person details have been entered
   void addPerson(Person p)
   {
      try
      {
         tree.addPerson(p);
         treeView.setLocationOfData(p, addPersonLocation.x, addPersonLocation.y);
         addPersonLocation.setLocation(0, 0);
      }
      catch (FamilyException fe)
      {
         showError("Add Person...", fe.getMessage());
      }
   }
   
   // remove a person from the tree
   protected void doRemove()
   {
      if (selectedPerson == null)
         return;
         
      try
      {
         tree.removePerson(selectedPerson);
      }
      catch (FamilyException f)
      {
         showError("Remove Person...", f.getMessage());
      }
   }
   
   // edit a person's details
   protected void doEdit()
   {
      if (selectedPerson == null)
         return;
      
      new PersonForm(this, selectedPerson).setVisible(true);
      
      // update details frame and FTView if necessary
      tree.personEdited(selectedPerson);
      personDetails.setSelection(selectedPerson);
   }
   
   // exit
   protected void doQuit()
   {
      if (!tree.isEmpty() && confirm("Quit Program...", "Do you want to " + 
                                     "save the current tree before quitting?"))
            doSave();
            
      System.exit(0);
   }
   
   // popup error message
   protected void showError(String title, String message)
   {
      JOptionPane.showMessageDialog(this, message, title, 
                                    JOptionPane.WARNING_MESSAGE);
   }
   
   // ask the user a yes/no question
   protected boolean confirm(String title, String message)
   {
      int choice = JOptionPane.showConfirmDialog(this, message, title, 
                                                 JOptionPane.YES_NO_OPTION);
      return (choice == JOptionPane.OK_OPTION);   
   }
   
   // build an appropriate JFileChooser
   static JFileChooser createFileChooser()
   {
      JFileChooser chooser=new JFileChooser();

      chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
      {
         public String getDescription()
         {
            return "Family Tree files (*.tree)";
         }
      
         public boolean accept(File f)
         {
            if(f.isDirectory())
	            return true;
	      
            else
            {
               String extension = 
                  f.getName().substring(f.getName().lastIndexOf(".") + 1);
	            return extension.equalsIgnoreCase("tree");
	         }
         }
      });

      return chooser; 
   }
   
   // sort a list of Person objects to make display clearer
   void sortPersonList(List people)
   {
      Collections.sort(people, personComparator);
   } 
  
//*************************** Event Handling *************************

   /*
      Inner class PopupHandler listens for activation of Selection 
      menu and enables / disables menu items depending on whether 
      there is currently a selection in the treeView
   */
   private class PopupHandler implements PopupMenuListener
   {
      public void popupMenuWillBecomeVisible(PopupMenuEvent e)
      {
         if (e.getSource() == selectionMenu.getPopupMenu())
            enableMenu(selectionMenu, selectedPerson != null);
      }  

      // ignore these events
      public void popupMenuWillBecomeInvisible(PopupMenuEvent e) { } 
      public void popupMenuCanceled(PopupMenuEvent e) { }

      private void enableMenu(JMenu menu, boolean enabled)
      {
         Component[] items = menu.getMenuComponents();
         for (int i = 0; i < items.length; i++)
            items[i].setEnabled(enabled);
      }
   } // end PopupHandler
   
   
   /* 
      inner class SetParentMenuListener
	   listens for selection of 'Set Father' or 'Set Mother' JMenu
	   and populates JMenuListPanel with family members
   */
	private class SetParentMenuListener implements MenuListener
	{
      private boolean parentType;
      
      public SetParentMenuListener(boolean parent)
      {
         parentType = parent;
      }
      
		public void menuSelected(MenuEvent e)
		{
         // iterate through the tree and build a list of potential 
         // parents, i.e. the right gender and not the selectedPerson
         Iterator it = tree.getTreeIterator();
         ArrayList familyList = new ArrayList();
         while (it.hasNext())
         {
            Person p = (Person)it.next();
            
            // **** COMMENT OUT THE NEXT LINE to test your program 
            // **** without the checks 
            if (p.getGender() == parentType && p != selectedPerson)
               familyList.add(p);
         }
            
         sortPersonList(familyList);
         
         // find the correct submenu item
         Component[] comps = ((JMenu)e.getSource()).getMenuComponents();
         for (int i = comps.length - 1; i >= 0; i--)
            if (comps[i] instanceof JListMenuPanel)
               ((JListMenuPanel)comps[i]).setListData(familyList);
		}
		
      // ignore
		public void menuCanceled(MenuEvent e) {}
		public void menuDeselected(MenuEvent e) {}
	
   } // end SetParentMenuListener
   
   /*
      Inner class to handle right mouse clicks in the treeView and pop-up 
      appropriate menu depending on whether there is a selectedPerson or 
      not
   */
   private class FTVMouseListener extends MouseAdapter
	{
		private static final int TOLERANCE = 4;
		private MouseEvent pressEvent = null;
		
		public void mousePressed(MouseEvent e)
		{
         if (!SwingUtilities.isRightMouseButton(e))
            return;
			pressEvent = e;
		}
		
		public void mouseReleased(MouseEvent e)
		{
			if(pressEvent != null)
			{
				int pressX = pressEvent.getX();
				int pressY = pressEvent.getY();

				if((Math.abs(pressX-e.getX()) < TOLERANCE) &&
				   (Math.abs(pressY-e.getY()) < TOLERANCE))
			      doAction(e);

				pressEvent = null;
			}
		}
		
		// doAction - in this case popup the appropriate menu
		public void doAction(MouseEvent e)
		{
			if(selectedPerson == null)
			{
				addPersonLocation.setLocation(e.getX(),e.getY());
				addMenu.show(treeView,e.getX(),e.getY());
			}
			else
			{
				Person p = selectedPerson;
            nodeMenu.show(treeView,e.getX(),e.getY());
			}

			treeView.repaint();
		}
	} // FTVMouseListener
   
   
   // handle SelectionChange events from the treeView
   private class SelectionHandler implements SelectionChangeListener
   {
   
      public void componentSelected(SelectionChangeEvent e)
      {
         selectedPerson = (Person)e.getSelection();
         personDetails.setSelection(selectedPerson);
      }
      
      public void selectionCleared(SelectionChangeEvent e)
      {
         selectedPerson = null;
         personDetails.setSelection(null);
      }
      
      public void highlightsCleared(SelectionChangeEvent e)
      {
         personDetails.clearHighlightList();
      }
      
      // ignore because this event originates in the browser anyway
      // and, we need more information than the treeView can tell us
      public void componentsHighlighted(SelectionChangeEvent e) { }
   
   } // end SelectionHandler
   
   
   // highlight a category of relatives
   private class HighlightAction extends AbstractAction
   {
      private String relationType;
      
      public HighlightAction(String relations)
      {
         super(relations);
         relationType = relations;
      }
      
      public void actionPerformed(ActionEvent e)
      {
         if (selectedPerson == null)
            return;
            
         List highlightList = null;
         if (relationType == ANCESTORS)
            highlightList = selectedPerson.getAncestors();
         else if (relationType == DESCENDANTS)
            highlightList = selectedPerson.getDescendants();
         else if (relationType == SIBLINGS)
            highlightList = selectedPerson.getSiblings();
         else if (relationType == COUSINS)
            highlightList = selectedPerson.getCousins();
         else if (relationType == PARENTS)
         {
            highlightList = new ArrayList();
            Person father = selectedPerson.getFather();
            Person mother = selectedPerson.getMother();
            if (father != null) highlightList.add(father);
            if (mother != null) highlightList.add(mother);
         }
            
         else if (relationType == CHILDREN)
         {
            highlightList = new ArrayList();
            int childCount = selectedPerson.getNumberOfChildren();
            for (int i = 0; i < childCount; i++)
               highlightList.add(selectedPerson.getChild(i));
         }
            
         if (highlightList != null) // shouldn't happen unless garbage String
         {                          // is passed to constructor  
            sortPersonList(highlightList);
            treeView.clearHighlights();
            treeView.highlight(highlightList);
            treeView.repaint();
            personDetails.setHighlightList(relationType, highlightList);
         }
      }
   } // end HighlightAction
   
   
   // set one of the parents of the selectedPerson
   private class SetParentAction implements ActionListener
   { 
      boolean parentSet;
      
      public SetParentAction(boolean parent)
      {
         parentSet = parent;
      }
      
      public void actionPerformed(ActionEvent e)
      {
         // shouldn't need to do this but they won't go away otherwise
         if (nodeMenu.isVisible())
            nodeMenu.setVisible(false);
         if (selectionMenu.getPopupMenu().isVisible())
         {
            selectionMenu.getPopupMenu().setVisible(false);
            selectionMenu.setSelected(false);
         }
         
         Person parent = (Person)e.getSource();
         
         try
         {
            if (parentSet == Person.MALE)
               tree.setFatherOf(selectedPerson, parent);
            else
               tree.setMotherOf(selectedPerson, parent);
         }
         catch (Exception ex) // GenderException or IdentityException
         {
            showError("Set Father...", ex.getMessage());
         }
      }
   } // end SetParentAction
   
   // set one of the parents of the selectedPerson to null
   private class SetParentNullAction extends AbstractAction
   {
      boolean parentSet;
      
      public SetParentNullAction(boolean parent)
      {
         parentSet = parent;
      }
      
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            if (parentSet == Person.MALE)
               tree.setFatherOf(selectedPerson, null);
            else
               tree.setMotherOf(selectedPerson, null);
         }
         catch (Exception ex) // GenderException or IdentityException...
         {                    // ...shouldn't occur
            showError("Set Father...", ex.getMessage());
         }
      }
      
      public Object getValue(String key)
      {
         if (key == Action.NAME)
            return "None";
            
         return super.getValue(key);
      }
   } // end setParentNullAction
   

   
//******************** Misc ***************************


   /*
      Inner class to display details of the current selection and 
      any nodes which are highlighted.
   */
   private class DetailPane extends JPanel
   {
      private final int MIN_WIDTH = 200;
      private final int MIN_LIST_WIDTH = 150;
      
      private JLabel nameLabel, genderLabel, birthLabel, deathLabel, 
         occupationLabel, highlightLabel;
      private JTextArea notesArea;
      private JList highlightList;
         
      public DetailPane()
      {
         super();
         setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         setLayout(new BorderLayout());
         
         JPanel top = new JPanel();
         top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
         
         JPanel top1 = new JPanel(new GridLayout(6, 1));
         JLabel header = createHeaderLabel("Current Selection");
         nameLabel = new JLabel(getNameLabelString("NONE"), 
                                SwingConstants.CENTER);
         top1.add(header);
         top1.add(nameLabel);
         top1.add(genderLabel = createLabel("Gender", ""));
         top1.add(birthLabel = createLabel("Born", ""));
         top1.add(deathLabel = createLabel("Died", ""));
         top1.add(occupationLabel = createLabel("Occupation", ""));
         
         JPanel top2 = new JPanel(new BorderLayout());
         top2.add(createLabel("Notes", ""), BorderLayout.NORTH);
         
         notesArea = new JTextArea(4, 20);
         notesArea.setLineWrap(true);
         notesArea.setEditable(false);
         notesArea.setBackground(top2.getBackground());
         top2.add(new JScrollPane(notesArea), BorderLayout.CENTER);
         
         top.add(top1);
         top.add(top2);
         
         add(top, BorderLayout.NORTH);
         
         JPanel body = new JPanel(new BorderLayout());
         body.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         top = new JPanel(new GridLayout(2, 1));
         
         header = createHeaderLabel("Highlighting");
         highlightLabel = createHeaderLabel("NONE");
         top.add(header);
         top.add(highlightLabel);
         body.add(top, BorderLayout.NORTH);
         
         highlightList = new JList() {
            public Dimension getPreferredSize() {
               Dimension dim = super.getPreferredSize();
               dim.width = Math.max(dim.width, MIN_LIST_WIDTH);
               return dim;
            } };
         
         body.add(highlightList, BorderLayout.CENTER);
         highlightList.setEnabled(false);
         
         add(body, BorderLayout.CENTER);
      }
      
      
      /*
       Get the preferred dimension for the panel
      */
      public Dimension getPreferredSize()
      {
         Dimension pref = super.getPreferredSize();
         pref.width = Math.max(pref.width, MIN_WIDTH);
         return pref;
      }
      
      /*
         Display the list of nodes currently highlighted in the treeView.
         The list should show any duplicates
      */
      public void setHighlightList(String type, List elements)
      {
         highlightLabel.setText("<html><strong>" + type + "</strong></html>");
         highlightList.setListData(elements.toArray());
      }
      
      /*
         Clear the highlight list
      */
      public void clearHighlightList()
      {
         highlightLabel.setText("<html><strong>NONE</strong></html>");
         highlightList.setListData(new Object[0]);
      }
      
      /*
         Display detailed information for the currently selected node in 
         the treeView. To clear the display, call this method with a null 
         argument.
      */
      public void setSelection(Person p)
      {
         if (p == null)
         {
            nameLabel.setText(getNameLabelString("NONE"));
            genderLabel.setText(getLabelString("Gender", ""));
            birthLabel.setText(getLabelString("Born", ""));
            deathLabel.setText(getLabelString("Died", ""));
            occupationLabel.setText(getLabelString("Occupation", ""));
            notesArea.setText("");
         }
         else
         {  
            String genderString = (p.getGender() == Person.MALE) ? "Male"
                                                                 : "Female";
            nameLabel.setText(getNameLabelString(p.getName()));
            genderLabel.setText(getLabelString("Gender", genderString));
            birthLabel.setText(getLabelString("Born", p.getBirth()));
            deathLabel.setText(getLabelString("Died", p.getDeath()));
            occupationLabel.setText(getLabelString("Occupation", 
                                                    p.getOccupation()));
            notesArea.setText(p.getNotes());
         }
      }
      
      private JLabel createHeaderLabel(String header)
      {
         String text = getHeaderLabelString(header);
         JLabel label = new JLabel(text, SwingConstants.CENTER);
         return label;
      }
      
      private JLabel createLabel(String labText, String valueText)
      {
         JLabel label = new JLabel();
         label.setText(getLabelString(labText, valueText));
         return label;
      }
      
      private String getLabelString(String label, String value)
      {
         return "<html><strong>" + label + ":</strong> " + 
             value + "</html>";
      }
      
      private String getNameLabelString(String name)
      {
         return "<html><font size=\"+1\">" + name + "</font></html>";
      }
      
      private String getHeaderLabelString(String header)
      {
         return "<html><strong>" + header + "</strong></html>";
      }
      
   } // end DetailPane
   
   /*
      Comparator for sorting lists of Person objects
   */
   private class PersonComparator implements Comparator
   {
      public int compare(Object o1, Object o2)
      {
         String name1 = ((Person)o1).getName();
         String name2 = ((Person)o2).getName();
         return name1.compareTo(name2);
      }
   }
}

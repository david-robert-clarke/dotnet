package family.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import family.ui.utils.Dragable;
import family.ui.utils.DragHandler;
import family.ui.utils.LinkUtils;
import family.ui.visual.*;
import family.*;

/**
   A class used to view individuals stored in a family tree.

   @author B. Wilkins
*/

public class FamilyTreeView extends JPanel
{
	private static final int MIN_WIDTH = 400;
	private static final int MIN_HEIGHT = 500;
	private Dimension prefDims = null;
	private FamilyTree tree = null;
	private HashMap nodeMap = null;					// key=data(Person),value=VisualComponent
	private ArrayList visualComponents = null;	// VisualComponent objects
	private ArrayList visualLinks = null;			// VisualLink objects
	private boolean modified = true;					// see note at top
	private VisualComponentSortComparator vcSortComparator = null;
	private VisualComponentSearchComparator vcSearchComparator = null;
	private Point keyPoint = null;
	private ImageIcon maleIcon = null;
	private ImageIcon femaleIcon = null;
   private EventListenerList listenerList;

   /**
      Constructor - creates a FamilyTreeView

      @param ft - the FamilyTree to be viewed.
   */
	public FamilyTreeView(FamilyTree ft)
	{
		setBackground(Color.white);
      
		// icons for nodes
		maleIcon = new ImageIcon("male.gif");
		femaleIcon = new ImageIcon("female.gif");

		prefDims = new Dimension(MIN_WIDTH,MIN_HEIGHT);

		// misc
		vcSortComparator = new VisualComponentSortComparator();
		vcSearchComparator = new VisualComponentSearchComparator();
		keyPoint = new Point();
      listenerList = new EventListenerList();

		// handle mouse selection
		addMouseListener(new MouseSelectionListener());

		// attach a DragHandler to this view
		new DragHandler(new VCDragHandler());
      
      // now do the important work
      setTree(ft);
	}
	
	
   /**
      Set the family tree model for this view.
      
      @param theTree the FamilyTree
   */
   public void setTree(FamilyTree theTree)
   {
      initTree(theTree);
      repaint();
   }

   /**
      Layout the nodes in the tree
   */
   public void layoutTree()
   {
      layoutNodes();
      repaint();
   }

   /**
      Get the preferred size of this component.
      
      @return the preferred size
   */
	public Dimension getPreferredSize()
	{
		return(prefDims);
	}

   /**
      Get the data that is currently selected in the view.

      @return the data selected in the view, or null if no data is selected
   */
	public Object getSelectedData()
	{
		int listSize = visualComponents.size();
		for(int i=0;i<listSize;i++)
		{
			VisualComponent vc = (VisualComponent)visualComponents.get(i);		

			if(vc.isSelected())
				return(vc.getUserData());
		}

		return(null);
	}
   
   // get the currently selected visual component
   protected VisualComponent getSelectedVC()
   {
      int listSize = visualComponents.size();
      for (int i = 0; i < listSize; i++)
      {
         VisualComponent vc = (VisualComponent)visualComponents.get(i);
         if (vc.isSelected())
            return vc;
      }
      
      return null;
   }

   /**
      Clear all selections in the view.
   */
	public void clearSelections()
	{
		int listSize = visualComponents.size();
		for(int i=0;i<listSize;i++)
			((VisualComponent)visualComponents.get(i)).setSelected(false);
      
      fireSelectionCleared();
	}

   /**
      Clear all highlighted items in the view.
   */
	public void clearHighlights()
	{
		int listSize = visualComponents.size();
		for(int i=0;i<listSize;i++)
		{
			
         VisualComponent vc = (VisualComponent)visualComponents.get(i);
			   vc.setBackground(VisualDefaults.DEFAULT_BACKGROUND);
		}
      
      fireHighlightsCleared();
	}
	
   /**
      Highlight data in the view.

      @param personList - the list of data items (Person objects) to highlight.
   */
	public void highlight(List personList)
	{
		int listSize = personList.size();
		for(int i=0;i<listSize;i++)
		{
			VisualComponent vc = (VisualComponent)nodeMap.get(personList.get(i));
			
         //** JB changed to test for multiple highlights.
         if (vc.getBackground() == VisualDefaults.HIGHLIGHT_COLOUR) 
            vc.setBackground(VisualDefaults.WARNING_COLOUR);
         else
            vc.setBackground(VisualDefaults.HIGHLIGHT_COLOUR);	
		}
      
      fireComponentsHighlighted(personList);
	}

   /**
      Set the location of a data item in the view.

      @param data - the data to be positioned
      @param x - the x position of the data item
      @param y - the y position of the data item
   */
	public void setLocationOfData(Object data,int x,int y)
	{
		VisualComponent vc = (VisualComponent)nodeMap.get(data);
		
		if(vc != null)
		{
			vc.setLocation(x,y);
			checkNewDimensions(vc);
		}
		
		repaint();
	}

   /**
      Paint the view.

      @param g - the Graphics object
   */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// draw the nodes
		int listSize = visualComponents.size();
		for(int i=0;i<listSize;i++)
			((VisualComponent)visualComponents.get(i)).draw(g);

		// draw the links
		g.setColor(Color.black);
		Point startPoint = new Point();
		Point endPoint = new Point();
		listSize = visualLinks.size();
		for(int i=0;i<listSize;i++)
		{
			VisualLink vl = (VisualLink)visualLinks.get(i);

			if(vl.intelliLink(startPoint,endPoint) == VisualLink.LINK_OK)
			{
            //g.setColor(vl.getColour());
				g.drawLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);

				// end block - optional
            //g.setColor(Color.red);
				g.fillRect(endPoint.x-1,endPoint.y-1,3,3);
			}
		}
	}
   
   /**
      Add a SelectionChangeListener. SelectionChangeEvents are fired when 
      there is a change in the selected or highlighted nodes.
      
      @param l the listener
   */
   public void addSelectionChangeListener(SelectionChangeListener l)
   {
      listenerList.add(SelectionChangeListener.class, l);
   }
   
   /**
      Remove a ChangeListener
   */
   public void removeSelectionChangeListener(SelectionChangeListener l)
   {
      listenerList.remove(SelectionChangeListener.class, l);
   }
   
   
   protected void fireComponentSelected(VisualComponent selected)
   {
      SelectionChangeEvent e = new SelectionChangeEvent(this, selected.getUserData());
      Object[] listeners = listenerList.getListenerList();
      for (int i = listeners.length - 1; i >= 1; i -= 2)
         ((SelectionChangeListener)listeners[i]).componentSelected(e);
   }
   
   protected void fireComponentsHighlighted(List highlightList)
   {
      SelectionChangeEvent e = new SelectionChangeEvent(this, highlightList);
      Object[] listeners = listenerList.getListenerList();
      for (int i = listeners.length - 1; i >= 1; i -= 2)
         ((SelectionChangeListener)listeners[i]).componentsHighlighted(e);  
   }
   
   protected void fireSelectionCleared()
   {
      SelectionChangeEvent e = new SelectionChangeEvent(this);
      Object[] listeners = listenerList.getListenerList();
      for (int i = listeners.length - 1; i >= 1; i -= 2)
         ((SelectionChangeListener)listeners[i]).selectionCleared(e);
   }
   
   protected void fireHighlightsCleared()
   {
      SelectionChangeEvent e = new SelectionChangeEvent(this);
      Object[] listeners = listenerList.getListenerList();
      for (int i = listeners.length - 1; i >= 1; i -= 2)
         ((SelectionChangeListener)listeners[i]).highlightsCleared(e);
   }
   
   private void initTree(FamilyTree ft)
   {
      // add a listener to the FamilyTree
		tree = ft;
		tree.addFamilyTreeListener(new FTChangedListener());
      
      // layout nodes and create links between nodes
		initNodes();
		createLinks();
      
		modified = true;
   }
   
   private void initNodes()
   {
      nodeMap = new HashMap();
		visualComponents = new ArrayList();
		
		// create VC's for each Person
		// and set up the node map
      Iterator it = tree.getTreeIterator();
      while (it.hasNext())
      {
			Person p = (Person)it.next();
			addVisualComponent(p);
		}
      
      layoutNodes();
   }
   
	
	private void layoutNodes()
	{
      // for convenience rather than efficiency
		ArrayList familyList = new ArrayList(nodeMap.keySet());
      int familyListSize = familyList.size();
     
		ArrayList levelList = new ArrayList();		// containing VC objects
      HashMap levelMap = new HashMap();
      
      // start by putting the nodes on different levels 0 = root (no parents) 
      for (int i = 0; i < familyListSize; i++)
      {
         Person p = (Person)familyList.get(i);
			if((p.getFather() == null) && (p.getMother() == null))
		   {
            setLevelDescending(levelMap, p, 0);
         }
      }
      
      // then work back up from the leaves (no children) to adjust any 
      // nodes that are still on the wrong levels
      for (int i = 0; i < familyListSize; i++)
      {
         Person p = (Person)familyList.get(i);
			if(p.getNumberOfChildren() == 0)
		   {
            int current = ((Integer)levelMap.get(p)).intValue();
            setLevelAscending(levelMap, p, current);
         }
      }
      
      // put the VCs in the appropriate lists
      Iterator keys = levelMap.keySet().iterator();
      while (keys.hasNext())
      {
         Object nextKey = keys.next();
         int level = ((Integer)levelMap.get(nextKey)).intValue();
         while (level >= levelList.size())
            levelList.add(new ArrayList());
            
         VisualComponent vc = (VisualComponent)nodeMap.get(nextKey);
         ((ArrayList)levelList.get(level)).add(vc);
      }
   
		// now all the nodes are associated with a level, 
      // position the visual components on each level
		
      // optional - does not need return statement
		levelList = adjustNodeLocations(levelList, levelMap);

		// find the level with the nodes that take up the greatest width
		int maxLevelWidth = 0;
		int levelListSize = levelList.size();
		for(int i=0;i<levelListSize;i++)
		{
			ArrayList levelNodes = (ArrayList)levelList.get(i);

			// sum width used by visual nodes
			int totalWidth = 0;
			int lvlListSize = levelNodes.size();
			for(int j=0;j<lvlListSize;j++)
			{
				VisualComponent vc = (VisualComponent)levelNodes.get(j);
				totalWidth += vc.getWidth();
			}

			maxLevelWidth = Math.max(maxLevelWidth,totalWidth+((lvlListSize-1)*40));
		}

		maxLevelWidth += 20;	// margin
		prefDims.width = Math.max(prefDims.width,maxLevelWidth);

		// spread the nodes evenly on each level
		for(int i=0;i<levelListSize;i++)
		{
			ArrayList levelNodes = (ArrayList)levelList.get(i);

			// sum width used by visual nodes
			int totalWidth = 0;
			int lvlListSize = levelNodes.size();
			for(int j=0;j<lvlListSize;j++)
			{
				VisualComponent vc = (VisualComponent)levelNodes.get(j);
				totalWidth += vc.getWidth();
			}

			// now place each node on level
			int gap = (maxLevelWidth-totalWidth)/(lvlListSize+1);
			int x = gap;
			int y = 10+(i*80);
			for(int j=0;j<lvlListSize;j++)
			{
				VisualComponent vc = (VisualComponent)levelNodes.get(j);
				vc.setLocation(x,y);
				x += (vc.getWidth()+gap);
				prefDims.height = Math.max(prefDims.height,y+vc.getHeight()+10);
			}
		}
	}
   
   private void setLevelDescending(HashMap levels, Person p, int level)
   {
      Integer current = (Integer)levels.get(p);
      if (current == null || current.intValue() < level)
         levels.put(p, new Integer(level));
         
      int childCount = p.getNumberOfChildren();
      for (int i = 0; i < childCount; i++)
         setLevelDescending(levels, p.getChild(i), level + 1);
   }
   
   private void setLevelAscending(HashMap levels, Person p, int level)
   {
      List siblings = p.getSiblings();
      int maxDepth = level;
      for (int j = 0; j < siblings.size(); j++)
         maxDepth = Math.max(maxDepth, ((Integer)levels.get(siblings.get(j))).intValue());

      Integer objDepth = new Integer(maxDepth);
      for (int j = 0; j < siblings.size(); j++)
         levels.put(siblings.get(j), objDepth);
      levels.put(p, objDepth);
      
      Person father = p.getFather();
      if (father != null)
         setLevelAscending(levels, father, level - 1);
      Person mother = p.getMother();
      if (mother != null)
         setLevelAscending(levels, mother, level - 1);
   }   
   

	// starting with the deepest nodes, position the node at as low
	// an index as possible on that level, go to the parent node and repeat
	private ArrayList adjustNodeLocations(ArrayList levelList, HashMap levelMap)
	{
		int levelListSize = levelList.size();
		int[] indexes = new int[levelListSize];
		
		// for each level - starting at the lowest level
		for(int i=levelListSize-1;i>-1;i--)
		{
			ArrayList levelNodes = (ArrayList)levelList.get(i);
			int nodeListSize = levelNodes.size();
			
			// for each node on this level
			for(int j=0;j<nodeListSize;j++)
			{
				VisualComponent vc = (VisualComponent)levelNodes.get(j);
				Person p = (Person)vc.getUserData();

				// if the person's mother is not null then position the mother
				// in the left most position (lowest index)
				Person pp = p.getMother();
				if(pp != null)
				{
					VisualComponent pvc = (VisualComponent)nodeMap.get(pp);
					int lvl = ((Integer)levelMap.get(pp)).intValue();
					ArrayList nodes = (ArrayList)levelList.get(lvl);
					int index = nodes.indexOf(pvc);
					// if the current index of the person is > the position we want it
					if(index > indexes[lvl])
					{
						nodes.remove(index);
						nodes.add(indexes[lvl],pvc);
					}

					indexes[lvl]++;	// next available slot
				}

				// if the person's father is not null then position the father
				// in the left most position (lowest index)
				pp = p.getFather();
				if(pp != null)
				{
					VisualComponent pvc = (VisualComponent)nodeMap.get(pp);
					int lvl = ((Integer)levelMap.get(pp)).intValue();
					ArrayList nodes = (ArrayList)levelList.get(lvl);
					int index = nodes.indexOf(pvc);
					// if the current index of the person is > the position we want it
					if(index > indexes[lvl])
					{
						nodes.remove(index);
						nodes.add(indexes[lvl],pvc);
					}

					indexes[lvl]++;	// next available slot
				}
			}
		}

		return(levelList);
	}

	// add a visual component to the view
	private VisualComponent addVisualComponent(Person p)
	{
		ImageIcon genderIcon = null;
		if(p.getGender() == Person.MALE)
			genderIcon = maleIcon;
		else
			genderIcon = femaleIcon;

		LabelVC vl = new LabelVC(this,p.getName(),genderIcon);
		vl.setBorder(Color.lightGray);
		vl.setSelectedColour(VisualDefaults.SELECTED_COLOUR);
		
      vl.setUserData(p);		// could be handy
		visualComponents.add(vl);

		nodeMap.put(p,vl);

		return(vl);
	}

	// create the links between visual components - uses VisualLink object
	private void createLinks()
	{
		ArrayList familyList = new ArrayList();
      Iterator it = tree.getTreeIterator();
      while (it.hasNext())
         familyList.add(it.next());
         
		int listSize = familyList.size();
      int linkCount = (listSize > 0) ? listSize - 1: 0;
		visualLinks = new ArrayList(linkCount);

		for(int i=0;i<listSize;i++)
		{
			Person p = (Person)familyList.get(i);
			VisualComponent parentVC = (VisualComponent)nodeMap.get(p);

			int childCount = p.getNumberOfChildren();
			for(int j=0;j<childCount;j++)
			{
				Person c =  p.getChild(j);
				VisualComponent childVC = (VisualComponent)nodeMap.get(c);

				visualLinks.add(new VisualLink(parentVC,childVC));
			}
		}		
	}

	// try to find a VisualComponent at the specified x,y position
	private VisualComponent getVisualComponentAtXY(int x,int y)
	{
		if(modified)
		{
			Collections.sort(visualComponents,vcSortComparator);
			modified = false;
		}

		// the fast approach - a bit fragile
		// finding by the x position only 
		Rectangle vcBounds = new Rectangle();
		keyPoint.x = x;
		keyPoint.y = y;
		int index = Collections.binarySearch(visualComponents,keyPoint,vcSearchComparator);
		if(index > -1)
		{
			// search for the first match
			while(index > 0)
			{
				VisualComponent vc = (VisualComponent)visualComponents.get(index-1);
				vc.getBounds(vcBounds);
				if((keyPoint.x < vcBounds.x) ||
					(keyPoint.x > (vcBounds.x+vcBounds.width)))
					break;

				index--;
			}

			// now looking to see if the y position matches
			int listSize = visualComponents.size();
			for(int i=index;i<listSize;i++)
			{
				VisualComponent vc = (VisualComponent)visualComponents.get(i);
				if(vc.contains(keyPoint.x,keyPoint.y))		// slightly redundant check
					return(vc);
			}

			return(null);
		}

		return(null);
	}

	// inner class FTChangedListener
	// listens for changes in the structure of the FamilyTree
	// and updates the view accordingly
	private class FTChangedListener implements FamilyTreeListener
	{
		public void fatherSet(FamilyTreeEvent e)
		{
         Person child = e.getSubject();
         Person father = e.getRelative();
			parentSet(child, father, Person.MALE);
		}

		public void motherSet(FamilyTreeEvent e)
		{
         Person child = e.getSubject();
         Person father = e.getRelative();
			parentSet(child, father, Person.FEMALE);
		}
		
		private void parentSet(Person child,Person parent,boolean gender)
		{
			VisualComponent childVC = (VisualComponent)nodeMap.get(child);

			// find the links that have the child as the dst
			ArrayList origParentLinks = LinkUtils.findLinksWithDst(visualLinks,childVC);

			// find the link that represents the parent relationship 
			// (father/mother) that has been removed
			VisualLink origParentLink = null;
			for(int i=0;i<origParentLinks.size();i++)
			{
				origParentLink = (VisualLink)origParentLinks.get(i);
				Person origParent = (Person)((VisualComponent)(origParentLink).getSource()).getUserData();
				if(origParent.getGender() == gender)
					break;
				else
					origParentLink = null;
			}
			
			// remove the original link
			if(origParentLink != null)
			{
				int index = visualLinks.indexOf(origParentLink);
				if(index > -1)
					visualLinks.remove(index);
			}
			
			// add a new link for the parent
			if(parent != null)
			{
				VisualComponent parentVC = (VisualComponent)nodeMap.get(parent);			
				visualLinks.add(new VisualLink(parentVC,childVC));
			}
			
			repaint();	// should this be here?
		}

		public void personAdded(FamilyTreeEvent e)
		{
         Person p = e.getSubject();
			LabelVC vl = (LabelVC)addVisualComponent(p);

			checkNewDimensions(vl);		// probably not necessary (since at 0,0);

			modified = true;

			repaint();	// should this be here?
		}

		public void personRemoved(FamilyTreeEvent e)
		{
         Person p = e.getSubject();
			VisualComponent vc = (VisualComponent)nodeMap.get(p);
			
			// remove visual component
			visualComponents.remove(visualComponents.indexOf(vc));

			// remove all links connected to this VC
			LinkUtils.remove(visualLinks,vc);

			// remove the entry in the person->VC map
			nodeMap.remove(p);

			repaint();	// should this be here?
		}

		public void personEdited(FamilyTreeEvent e)
		{
         Person p = e.getSubject();
			VisualComponent vc = (VisualComponent)nodeMap.get(p);

			((LabelVC)vc).setLabel(p.getName());

			checkNewDimensions(vc);

			repaint();	// should this be here?
		}
	}

	// inner class MouseSelectionListener
	private class MouseSelectionListener extends MouseAdapter
	{
      public void mousePressed(MouseEvent e)
      {
         //storedPress = e;
      }
      
		public void mouseReleased(MouseEvent e)
		{ 
         VisualComponent selected = getSelectedVC();
         VisualComponent clicked = getVisualComponentAtXY(e.getX(), e.getY());
         
         if (clicked == null)
         {
            if (selected != null)
            {
               selected.setSelected(false);
               clearHighlights();
               fireSelectionCleared();
            }
         }
         else
         {
            if (selected != null)
            {
               if (selected != clicked)
               {
                  selected.setSelected(false);
                  fireSelectionCleared();
                  
                  clearHighlights();
                  clicked.setSelected(true);
                  fireComponentSelected(clicked);
               }
            }
            else
            {
               clearHighlights();
               clicked.setSelected(true);
               fireComponentSelected(clicked);
            }
         }
         
         repaint();
		}
	}

	// check if the position and size of the visual component
	// require the preferred size of the view and/or the viewport
	// to be changed/updated
	private void checkNewDimensions(VisualComponent vc)
	{
		boolean resize = false;

		if(vc.getAbsX() < 0)
		{
			int offset = (-1*vc.getAbsX())+4;
			prefDims.width += offset;
			resize = true;
		
			// translate all the VC's by the amount offset
			int listSize = visualComponents.size();
			for(int i=0;i<listSize;i++)
				((VisualComponent)visualComponents.get(i)).translateX(offset);
		}
		else if((vc.getAbsX()+vc.getWidth()) > prefDims.width)
		{
			prefDims.width = vc.getAbsX()+vc.getWidth()+4;
			resize = true;
		}

		if(vc.getAbsY() < 0)
		{
			int offset = (-1*vc.getAbsY())+4;
			prefDims.height += offset;
			resize = true;

			// translate all the VC's by the amount offset
			int listSize = visualComponents.size();
			for(int i=0;i<listSize;i++)
				((VisualComponent)visualComponents.get(i)).translateY(offset);
		}
		else if((vc.getAbsY()+vc.getHeight()) > prefDims.height)
		{
			prefDims.height = vc.getAbsY()+vc.getHeight()+4;
			resize = true;
		}

		// *supposed* to make sure the VC is visible
		// JViewport overrides the scrollRectToVisible (somehow!)
		FamilyTreeView.this.scrollRectToVisible(vc.getBounds(null));

		if(resize)
		{
			// update preferred size
			FamilyTreeView.this.setPreferredSize(prefDims);
			
			// tell ScrollPane it needs to update itself and scrollbars
			FamilyTreeView.this.revalidate();
		}
	}

	// inner class VCDragHandler
	// handles dragging of visual components
	private class VCDragHandler implements Dragable
	{
		public JComponent getOwnerComponent()
		{
			return(FamilyTreeView.this);
		}
		
		public VisualComponent getDragableComponetAtXY(int x,int y)
		{
			return(getVisualComponentAtXY(x,y));
		}
	
		public void componentDragged(VisualComponent vc)
		{
			// check if the drag means a change in preferred size
			checkNewDimensions(vc);

			// make the dragged VC become selected
			clearSelections();
			vc.setSelected(true);
         fireComponentSelected(vc);

			// paint the view
			repaint();
	
			// change modified flag so that next click search will re-sort
			modified = true;

			// informViewChangeListeners(new ViewChangedEvent(
			//		ViewChangedEvent.VISUAL_COMPONENT_MOVED,vc));
		}
	}
}
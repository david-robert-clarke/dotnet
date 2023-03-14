package family.ui;

import java.util.EventListener;

/**
	The listener interface for selection / highlight changes on a FamilyTreeView
*/

public interface SelectionChangeListener extends EventListener
{
   /**
      Invoked when a single node is selected
      
      @param e the event
   */
	public void componentSelected(SelectionChangeEvent e);
   
   /**
      Invoked when a list of nodes are highlighted
      
      @param e the event
   */
	public void componentsHighlighted(SelectionChangeEvent e);
   
   /**
      Invoked when the selection is cleared
      
      @param e the event
   */
	public void selectionCleared(SelectionChangeEvent e);
   
   /**
      Invoked when the highlights are cleared
      
      @param e the event
   */
	public void highlightsCleared(SelectionChangeEvent e);
   
}
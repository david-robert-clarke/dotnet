package family;

import java.util.EventListener;

/**
	The listener interface for receiving changes to a FamilyTree. The class that is interested
	in monitoring changes to a FamilyTree should implement this interface and register iteself
	using the <code>addFamilyTreeListener</code> method in the FamilyTree class.
	
   @author B. Wilkins
*/

public interface FamilyTreeListener extends EventListener
{
   /**
      Invoked when a Person's father is changed
      
      @param e the event
   */
	public void fatherSet(FamilyTreeEvent e);
   
   /**
      Invoked when a Person's mother is changed
      
      @param e the event
   */
	public void motherSet(FamilyTreeEvent e);
   
   /**
      Invoked when a Person is add to the FamilyTree
      
      @param e the event
   */
	public void personAdded(FamilyTreeEvent e);
   
   /**
      Invoked when a Person is removed from the FamilyTree
      
      @param e the event
   */
	public void personRemoved(FamilyTreeEvent e);
   
   /**
      Invoked when a Person's internal state has been changed
      
      @param e the event
   */
	public void personEdited(FamilyTreeEvent e);
}
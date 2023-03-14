package family.ui;

import javax.swing.event.ChangeEvent;

/**
* Class to represent changes in the current selection / highlights on a 
  FamilyTreeView.
**/
public class SelectionChangeEvent extends ChangeEvent
{
   private Object selection;

   /**
      Construct a <code>SelectionChangeEvent</code> with an empty selection, 
      for use when the selection is cleared.
  
      @param source the event source
   **/
   public SelectionChangeEvent(Object source)
   {
      super(source);
   }
   
   /**
      Construct a <code>SelectionChangeEvent</code> with the specified 
      selection. In the case of highlight, where multiple nodes may be 
      selected, the selection will be a <code>List</code>, otherwise it 
      will be a single Object.
  
      @param source the event source
   **/
   public SelectionChangeEvent(Object source, Object sel)
   {
      super(source);
      selection = sel;
   }
   
   /**
      Get the data that was selected.
   
      @return the selected Object, or List of Objects
   */
   public Object getSelection()
   {
      return selection;
   }
}

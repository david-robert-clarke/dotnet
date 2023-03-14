package family;

import java.util.EventObject;

/**
* Class to represent events which change the structure of a 
* <code>FamilyTree</code>, or the state of one of the <code>Person</code>s in 
* the tree.
**/
public class FamilyTreeEvent extends EventObject
{
   private Person subject, relative;

   /**
   * Construct a <code>FamilyTreeEvent</code> for an event which only directly 
   * concerns one <code>Person</code> (though it may have an indirect effect on 
   * several others). Events of this type would be where:
   * <ul>
   *  <li>some element of the <code>Person</code>'s state has changed</li>
   *  <li>a <code>Person</code> has been added to the tree</li>
   *  <li>a <code>Person</code> has been removed from the tree</li>
   * </ul>
   * 
   * @param source the event source
   * @param subj the principle subject of the event
   * @see #getSubject
   **/
   public FamilyTreeEvent(Object source, Person subj)
   {
      super(source);
      subject = subj;
   }
   
   /**
   * Constructs a <code>FamilyTreeEvent</code> for an event which directly 
   * concerns two <code>Person</code>s (and may also have an indirect effect 
   * on others). Events of this type occur when either parent of a 
   * <code>Person</code> has been changed.
   * 
   * @param source the event source
   * @param subj the principle subject of the event
   * @param rel the secondary subject of the event
   * @see #getSubject
   * @see #getRelative 
   **/
   public FamilyTreeEvent(Object source, Person subj, Person rel)
   {
      super(source);
      subject = subj;
      relative = rel;
   }
   
   /**
   * Get the principal <code>Person</code> concerned with this event. For 
   * person added, removed and changed type events this will be the only 
   * person concerned. For parent change events, this will be the child 
   * whose parent has been changed.
   * 
   * @return the subject of the event  
   **/
   public Person getSubject()
   {
      return subject;
   }
   
   /**
   * Get the secondary <code>Person</code> concerned with this event. For 
   * person added, removed and change type events, this should be 
   * <code>null</code>. For parent change events, this will be the new 
   * parent of the <em>subject</em> of the event.
   * 
   * @return the new parent of the <code>Person</code> returned by 
   *  <code>getSubject()</code>, or <code>null</code> if this is not a parent 
   *  change event.
   **/
   public Person getRelative()
   {
      return relative;
   }
}

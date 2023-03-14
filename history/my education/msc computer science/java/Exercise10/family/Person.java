package family;

import java.lang.*;
import java.util.*;

/** 
 * A class representing individuals stored in a family tree. All state-
 * changing operations check if the tree consistency is not compromised. 
 * 
 * Created: Sat 22 15:13:02 2003
 * 
 * @author <a href="mailto:msc88drc@cs.bham.ac.uk">David R Clarke</a>
 * @version
 */
public class Person implements java.io.Serializable
{  
  /**
   * Boolean constant used to specify a person's gender. 
   **/
  static boolean FEMALE = false;
  static boolean MALE = true;
  private String name;

  //instance variables
  private boolean gender;
  private String birth;
  private String death;
  private String notes;
  private String occupation;
  private Person father;
  private Person mother;
  private ArrayList children;
    
  //-----------------------------Constructors--------------------------------
  
  /**
   * The most basic constructor. For all people, at least the gender must 
   * be specified. 
   * @param g gender
   * @see FEMALE, MALE
   **/
  public Person(boolean g)
  {
    gender = g;
    father = null;
    mother = null;
    children = new ArrayList();
  }

  /**
   * Constructing an object with a given name and gender. 
   * @param n person's name (all names concatenated in one string)
   * @param g gender 
   * @throws IllegalArgumentException - when n is null
   * @see FEMALE, MALE
   **/
  public Person(String n, boolean g)throws IllegalArgumentException
  {               
    if (n == null)
      throw new IllegalArgumentException();
    else
      name = n;   
    
    gender = g;
    father = null;
    mother = null;
    children = new ArrayList();
  }

  /**
   * Constructing an object with a given name, gender, birth and death dates. 
   * @param n person's name (all names concatenated in one string)
   * @param g gender
   * @param b birth information, it can be any string containing a date 
   * and/or location, null is allowed
   * @param d death information, it can be any string containing a date 
   * and/or location, null is allowed 
   * @throws IllegalArgumentException - when n is null
   * @see FEMALE, MALE
   **/
  public Person(String n, boolean g,String b,String d)
    throws IllegalArgumentException
  {
    if (n == null)
      throw new IllegalArgumentException();
    else
      name = n; 

    gender = g;
    birth = b;
    death = d; 
    father = null;
    mother = null;
    children = new ArrayList();
  }

  //---------------------------------Methods---------------------------------
  /**
   * Adds a child to the person's child list. It automatically makes this 
   * object the child's parent and removes it from the old parent's children
   * list. 
   * @param child child to be added 
   * @throws IdentityException - when the argument is the same as this 
   * person or when it is one of its ancestors
   **/
  public void addChild(Person child) throws IdentityException
  { 
    ArrayList childsAncestors = (ArrayList)child.getAncestors();
    for(int i=0; i<childsAncestors.size(); i++)
    { 
      Person ancestor = (Person)childsAncestors.get(i);
      if(ancestor == child)
      {throw new IdentityException("Person cannot be is one of its own" +
				   "ancestors");
      }
      
    }
    
    if(child==this)
      throw new IdentityException("Person cannot be ones child!");

    else
      children.add(child);
  }
 
    /**
     * Get all ancestors of this person. 
     * @return a sorted list of Person objects containing all traceable 
     * ancestors. An empty list if none are found.
     **/       
    public List getAncestors() 
      {
        ArrayList ancestors = new ArrayList();//initialises arrayList
        if(father!= null)
	{ancestors.add(father);//add father to list
	ancestors.addAll(father.getAncestors());//appends mother's list
	}
        
        if(mother!= null)
	{ancestors.add(mother);//add mother to list
	ancestors.addAll(mother.getAncestors());//appends mother's list
	}
        return ancestors;
      }

    /**
     * Get the person's birth information. 
     * @return the birth information
     **/
    public String getBirth() 
      {
        return birth;
      }

    /**
     * Get the ith child of this person.
     * @param i - the child number 
     * @return the specified child
     **/
    public Person getChild(int i) 
      {
        if(this.getNumberOfChildren()>0)
	{Person child = (Person)children.get(i);
	return(child);
	}
        else
	  return null;
      }

    /**
     * Get a list of this person's cousins. In this case, cousins means first 
     * cousins only, i.e. the children of the siblings of this person's 
     * parents. 
     * @return a sorted list of Person objects containing all traceable 
     * cousins. An empty list if none are found.
     **/
    public List getCousins() 
      { 
        ArrayList cousins = new ArrayList();
        Person sibling, child;

        if(father!=null)
	{ ArrayList auDadsSide = (ArrayList)father.getSiblings();
	if(auDadsSide.size()>0)//father does have siblings
	{for(int i=0; i<auDadsSide.size();i++)
	{sibling = (Person)auDadsSide.get(i);
	
	if(sibling.getNumberOfChildren()>0)//do siblings have children?
	{ for(int j=0; j<sibling.getNumberOfChildren();j++)
	{
	  child=(Person)sibling.getChild(j);
	  cousins.add(child);
	}
	}
	}
	}
	}
        if(mother!=null)
	{ ArrayList auMomsSide = (ArrayList)mother.getSiblings();
	if(auMomsSide.size()>0)//mother does have siblings
	{for(int i=0; i<auMomsSide.size();i++)
	{sibling = (Person)auMomsSide.get(i);
	
	if(sibling.getNumberOfChildren()>0)//do siblings have children?
	{ for(int j=0; j<sibling.getNumberOfChildren();j++)
	{
	  child=(Person)sibling.getChild(j);
	  cousins.add(child);
	}
	}
	
	}
	}
	}    
        return cousins;         
      }

    /**
     * Get the person's death information. 
     * @return the death information
     **/
    public String getDeath() 
      {    return death;
      }

    /**
     * Get all descendants of this person. 
     * @return a sorted list of Person objects containing all traceable 
     * descendants. An empty list if none are found.
     **/
    public List getDescendants()    
      {
    
        ArrayList des = new ArrayList();
        if(children.size() != 0)
	{
	  for(int i=0;i<children.size();i++)
	  {
	    Person child = (Person)children.get(i);
	    des.add(child);//add child to list
	    des.addAll(child.getDescendants());//appends child list            
	  }
	}
        return des;
      }

    /**
     * Get the person's father.
     * @return the father's object
     **/
    public Person getFather() 
      {
        return father;
      }

    /**
     * Get the person's gender. 
     * @return the gender
     **/
    public boolean getGender() 
      {
        return gender;
      }
  
    /**
     * Get the person's mother. 
     * @return the mother object
     **/
    public Person getMother()     
      {
        return mother;
      }

    /**
     * Get the person's name. 
     * @return the name
     **/
    public String getName() 
      {
        return name;
      }

    /**
     * Get the notes about this person. 
     * @return the notes
     **/
    public String getNotes() 
      {
        return notes;
      }

    /**
     * Get the number of person's children. 
     * @return the number of children
     **/
    public int getNumberOfChildren() 
      {
        return children.size();
      }

    /**
     * Get the person's occupation information. 
     * @return the occupation information
     **/
    public String getOccupation() 
      {
        return occupation;
      }
  
    /**
     * Get all siblings of this person. A sibling is defined here as any 
     * child of either of this person's parents, excluding this person. 
     * @return a sorted list of Person objects containing all traceable 
     * siblings. An empty list if none are found.
     **/
    public List getSiblings() 
      {    
        ArrayList siblings = new ArrayList();

        if(father!= null)
	{    
	  //child size has to be greater than 0
	  for(int i=0;i<father.getNumberOfChildren();i++)
	  {
	    Person child = (Person)father.getChild(i);
	    if(child!= this)
	      if(!siblings.contains(child))//if child is listed
		siblings.add(child);
	  }
	}
  
        if(mother!= null)
	{	
	  for(int i=0;i<mother.getNumberOfChildren();i++)
	  {
	    Person child = (Person)mother.getChild(i);
	    if(child!= this)
	      if(!siblings.contains(child))//if child is listed
		siblings.add(child);
	  }
	}
        return siblings;
      }

    /**
     * Checks if this person has a given child.
     * @param child the child to check 
     * @return true if it does
     **/
    public boolean hasChild(Person child)
      {
        return (children.contains(child));
      }

    /**
     * Remove all children of this person. It automatically sets the the 
     * children's corresponding parents to null. 
     **/
    public void removeAllChildren()
      {boolean parentsGender = this.getGender();
      
      for(int i=0; i<children.size();i++)
      { Person child = (Person)children.get(i);  
      if(parentsGender==MALE)
      { try
      { child.setFather(null);
      }
      catch (IdentityException exception)
      { System.out.println("\n'" + exception.getMessage());
      }
      catch (GenderException exception)
      { System.out.println("\n'" + exception.getMessage());
      }
      }
        
      else
      {
	try
	{child.setMother(null);
	}
	catch (IdentityException exception)
	{ System.out.println("\n'" + exception.getMessage());
	}
	catch (GenderException exception)
	{ System.out.println("\n'" + exception.getMessage());
	}
      }
      }
      children.clear();
      }

    //Remove a child from this person's children list. It automatically sets 
    //the corresponding parent of the child to null. 
    public void removeChild(Person child) 
      {   
        int i = children.indexOf(child);
        children.remove(i);
      }
    /**
     * Set birth information. 
     * @param b birth information, it can be any string containing a date 
     * and/or location, null is allowed
     **/
    public void setBirth(String b) 
      {
        birth = b;
      }
  
    /**
     * Set death information. 
     * @param d death information, it can be any string containing a date 
     * and/or location, null is allowed
     **/
    public void setDeath(String d) 
      {
        death = d;
      }

    /**
     * Set the father of this person. This method automatically removes this 
     * person from the list of children of the previous father and adds it to 
     * the new father's children. 
     * @param f the father object, null is allowed 
     * @throws IdentityException - when the argument is the same as this 
     * person or when it is one of its descendants 
     * @throws GenderException - when the argument is a woman
     **/
    public void setFather(Person f)throws IdentityException,GenderException
      {
        
	//check if the new father is valid
	ArrayList descList = (ArrayList)this.getDescendants();  
	for(int i=0; i<descList.size(); i++)
	{ Person descendant = (Person)descList.get(i);
	if(descendant == f)
	  throw new IdentityException("Person cannot be ones descedant!");
	}
      
	if(f==this)
          throw new IdentityException("Person cannot be ones father!");
      
	if(f!=null)
	{
	  if(f.getGender()==FEMALE)
	    throw new GenderException("Father cannot be female!");
	}
      
	//father is valid, perform addtional operations
	Person previousFather = father; //previous father
	father = f;                     //new father
	if (previousFather ==null && f != null)//adding new father
	{
	  f.addChild(this);
	}
      
        else if(previousFather != null && f != null) //changing fathers
	{
	  f.addChild(this);
	  previousFather.removeChild(this);
	} 

      }
 
    /**
     * Set the mother of this person. This method automatically removes this 
     * person from the list of children of the previous mother and adds it to 
     * the new mother's children. 
     * @param m the mother object, null is allowed 
     * @throws IdentityException - when the argument is the same as this 
     * person or when it is one of its descendants 
     * @throws GenderException - when the argument is a man
     **/
    public void setMother(Person m)throws IdentityException,GenderException
      {  
        //check if the new mother is valid
        ArrayList descList = (ArrayList)this.getDescendants();  
        for(int i=0; i<descList.size(); i++)
	{ Person descendant = (Person)descList.get(i);
	if(descendant == m)
	  throw new IdentityException("Person cannot be ones descedant!");
	}
                
        if(m==this)
	  throw new IdentityException("Person cannot be ones mother!");

        if(m!=null)
	{
	  if(m.getGender()==MALE)
	    throw new GenderException("Mother cannot be male!");
	}

        //mother is valid, perform addtional operations
        Person previousMother = mother; //previous mother
        mother = m;                     //new mother     
        if (previousMother ==null && m!=null)//add new mother
	{
	  m.addChild(this);
	}
        
        else if(previousMother != null && m != null) //changing mothers
	{
	  m.addChild(this);
	  previousMother.removeChild(this);
	}  
      }
 
    /**
     * Set name
     * @param n Person's name 
     * @throws IllegalArgumentException - when n is null
     **/
    public void setName(String n) 
      {
        if (n == null)
	  throw new IllegalArgumentException();
        else
	  name = n;
      }

    /**
     * Set notes. 
     * @param n notes, it can be any string refering to this person, null 
     * is allowed
     **/
    public void setNotes(String n) 
      {
        notes = n;
      }

    /**
     * Set occupation information. 
     * @param o occupation information, it can be any string describing the 
     * person's occupation, null is allowed
     **/
    public void setOccupation(String o)
      {
        occupation = o;
      }

    /**
     * Get a String representation of this person. In this case, only the 
     * person's name is returned. 
     * @return a String representing the person
     **/
    public String toString()
      {
        return name;
      }
  }

/**
   @version 1.00 1999-10-23
   @author Cay Horstmann
*/

import java.security.*;
import java.util.*;

/**
   A permission that checks for bad words.
*/
public class WordCheckPermission extends Permission
{ 
   /**
      Constructs a word check permission
      @param target a comma separated word list
      @param anAction "insert" or "avoid"
   */
   public WordCheckPermission(String target, String anAction)
   {  
      super(target);
      action = anAction;
   }

   public String getActions() { return action; }

   public boolean equals(Object other)
   {  
      if (other == null) return false;
      if (!getClass().equals(other.getClass())) return false;
      WordCheckPermission b = (WordCheckPermission)other;
      if (!action.equals(b.action)) return false;
      if (action.equals("insert"))
         return getName().equals(b.getName());
      else if (action.equals("avoid"))
         return badWordSet().equals(b.badWordSet());
      else return false;
   }

   public int hashCode()
   {  
      return getName().hashCode() + action.hashCode();
   }

   public boolean implies(Permission other)
   {  
      if (!(other instanceof WordCheckPermission)) return false;
      WordCheckPermission b = (WordCheckPermission)other;
      if (action.equals("insert"))
      {  
         return b.action.equals("insert") &&
            getName().indexOf(b.getName()) >= 0;
      }
      else if (action.equals("avoid"))
      {  
         if (b.action.equals("avoid"))
            return b.badWordSet().containsAll(badWordSet());
         else if (b.action.equals("insert"))
         {  
            Iterator iter = badWordSet().iterator();
            while (iter.hasNext())
            { 
               String badWord = (String)iter.next();
               if (b.getName().indexOf(badWord) >= 0)
                  return false;
            }
            return true;
         }
         else return false;
      }
      else return false;
   }

   /**
      Gets the bad words that this permission rule describes.
      @return a set of the bad words
   */
   public Set badWordSet()
   {  
      StringTokenizer tokenizer
         = new StringTokenizer(getName(), ",");
      Set set = new HashSet();
      while (tokenizer.hasMoreTokens())
         set.add(tokenizer.nextToken());
      return set;
   }

   private String action;
}



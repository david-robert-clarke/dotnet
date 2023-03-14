package databook;

/**
* Thrown when an attempt is made to add a duplicate entry into an address book.
**/
public class EntryExistsException extends Exception
{
   /**
   * Constructor to create an <code>EntryExistsException</code> with the 
   * given error message.
   *
   * @param message the error message
   **/
   public EntryExistsException(String message)
   {
      super(message);
   }
}

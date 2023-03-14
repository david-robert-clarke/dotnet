package addressbook;

/**
* Thrown when an attempt is made to access a record that doesn't exist 
* within an address book
**/
public class NoSuchEntryException extends Exception
{
   /**
   * Constructor to create a <code>NoSuchEntryException</code> with the 
   * given error message.
   *
   * @param message the error message
   **/
   public NoSuchEntryException(String message)
   {
      super(message);
   }
}

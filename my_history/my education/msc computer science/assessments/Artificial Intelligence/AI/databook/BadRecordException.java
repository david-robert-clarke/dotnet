package databook;

/**
* Thrown to indicate that an individual record in an address book is 
* malformed.
**/
public class BadRecordException extends Exception
{
   /**
   * Constructor to create a <code>BadRecordException</code> with the 
   * given error message.
   *
   * @param message the error message
   **/
   public BadRecordException(String message)
   {
      super(message);
   }
}

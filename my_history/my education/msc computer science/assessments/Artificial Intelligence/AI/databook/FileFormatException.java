package databook;

/**
* Thrown to indicate that an address book file is invalid in some way.
**/
public class FileFormatException extends Exception
{
   /**
   * Constructor to create a <code>FileFormatException</code> with the 
   * given error message.
   *
   * @param message the error message
   **/
   public FileFormatException(String message)
   {
      super(message);
   }
}

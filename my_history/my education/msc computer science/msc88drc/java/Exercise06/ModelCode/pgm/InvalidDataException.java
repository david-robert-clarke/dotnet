package pgm;

/**
* Thrown to indicate that a file contains invalid data
**/
public class InvalidDataException extends Exception
{
   public InvalidDataException()
   {
      super();
   }
   
   public InvalidDataException(String message)
   {
      super(message);
   }
}

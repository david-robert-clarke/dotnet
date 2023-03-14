package pgm;

/**
* Thrown to indicate that a file opened for reading is not in a 
* format which the particular reader supports
**/
public class UnsupportedFileFormatException extends Exception
{
   public UnsupportedFileFormatException()
   {
      super();
   }
   
   public UnsupportedFileFormatException(String message)
   {
      super(message);
   }
}

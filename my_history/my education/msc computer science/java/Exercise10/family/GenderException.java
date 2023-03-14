package family;

/**
   An exception class signifying a gender conflict between parents,
   such as a female father or a male wife.
*/

public class GenderException extends Exception
{
   GenderException(String message)
   {
      super(message);
   }
}

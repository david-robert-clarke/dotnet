package family;

/**
   An exception class signifying an identity conflict, such as one being
   their own grandfather.
*/

public class IdentityException extends Exception
{
   IdentityException(String message)
   {
      super(message);
   }
}


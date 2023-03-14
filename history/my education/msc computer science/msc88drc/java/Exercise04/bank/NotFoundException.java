package bank;

/**
   An exception class used to notify of a failed attempt to find an account
   in the bank.
*/

public class NotFoundException extends Exception
{
	/**
		Constructor allowing to pass a message string along with the exception

		@param s  the message string
	**/

	public NotFoundException(String s)
	{
		super(s);
	}
}


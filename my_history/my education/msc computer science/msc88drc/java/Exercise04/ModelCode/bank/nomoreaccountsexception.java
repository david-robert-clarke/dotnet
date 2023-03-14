package bank;

/**
   An exception class used to notify that the array of accounts is full.
*/

public class NoMoreAccountsException extends Exception
{
	/**
		Constructor allowing to pass a message string along with the exception

		@param s  the message string
	**/

	public NoMoreAccountsException(String s)
	{
		super(s);
	}
}


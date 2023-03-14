package bank;

/**
   An exception class used to notify of an attempt to exceed the overdraft
   limit on an account.
*/

public class OverdraftException extends Exception
{
	/**
		Constructor allowing to pass a message string along with the exception

		@param s  the message string
	**/

	public OverdraftException(String s)
	{
		super(s);
	}
}

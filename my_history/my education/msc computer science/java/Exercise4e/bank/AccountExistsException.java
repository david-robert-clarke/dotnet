package bank;

/**
   An exception class used at the time of adding a new account to the bank.
   It notifies that an account with the given number already exists.
*/

public class AccountExistsException extends Exception
{
	/**
		Constructor allowing to pass a message string along with the exception

		@param s  the message string
	**/

	public AccountExistsException(String s)
	{
		super(s);
	}
}


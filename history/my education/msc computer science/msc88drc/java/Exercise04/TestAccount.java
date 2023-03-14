import bank.*;
import java.io.*;

/*
	Test the Bank Terminal program
*/
class TestAccount
{
	public static void main (String [] args)throws NumberFormatException,
	NotFoundException, IOException, AccountExistsException, NoMoreAccountsException,
	OverdraftException
	{	
		Account a = new Account(-1, "Dave", 50);
		System.out.println(a);
	}

}

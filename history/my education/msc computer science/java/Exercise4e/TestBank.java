import bank.*;
import java.io.*;

/*
	Test the Bank Terminal program
*/
class TestBank
{
	public static void main (String [] args)throws NumberFormatException,
	NotFoundException, IOException, AccountExistsException, NoMoreAccountsException,
	OverdraftException
	{
		 
		 /*
		 What happens if you now remove the first/last and repeat the above tests. 
		 If the array is full and you add one may generate a NoMoreAccountsException. Try to get info on the account that you just tried to add - it should not be in the array. 
		 The list goes on .... 
		 Basically with the bank, common problems occur when removing accounts from the ends of 
		 the array (first/last) and when you try to over fill the array or remove all the elements. 
		 If your loop never reaches the end of the array or doesn't work if the array is full/empty, 
		 tests similar to the above will hopefully find these problems. 
		 */
			
			Bank Lloyds = new Bank(2);
			Account a = new Account(888);
			Account b = new Account(232);
			Account c = new Account(556);

			Lloyds.addAccount(a);
			Lloyds.removeAccount(a);
			Lloyds.addAccount(b);
			Lloyds.addAccount(c);
			Lloyds.removeAccount(c);
			
			
	}

}

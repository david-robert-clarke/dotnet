/**
 * This class manages details about a single bank account.
 *
 * @author David Clarke
 **/

import java.io.*;
 
public class Account
{ 
	private int accountNumber;
	private String name;
	private int balance;
	private int overdraftLimit;

	/**
	* Constructor to set up the account with some default values
	*
	* @param ac	the account number.
	**/

	public Account(int ac)
	{ 	
		accountNumber = ac;
		name = "Current Account";
		balance = 0;
		overdraftLimit = 0;
	}

	/**
	* Constructor to set up the account with given information.
	*
	* @param ac    the account number.
	* @param n     the account name.
	* @param bal   the starting balance.
	* @param odl   the initial overdraft limit
	**/

	public Account(int ac, String n, int bal, int odl)
	{ 
		accountNumber = ac;
		name = n;
		balance = bal;
		overdraftLimit = odl;
	}
	
	/**
	* Method to set the account name
	*
	* @param n	the account name.
	**/

	public void setName(String n)
	{ 
		name = n;
	}
	
	/**
	* Method to set the starting balance
	*
	* @param bal	the starting balance
	**/
	
	public void setBalance(int bal)
	{ 
		balance = bal;
	}
	
	/**
	* Method to set the overdraft limit
	*
	* @param odl     the overdraft limit.
	**/
	
	public void setODLimit(int odl)
	{
		overdraftLimit = odl;
	}

	/**
	* Return the account number of this account.
	*
	* @return the account number as an integer.
	**/

	public int getAccountNumber()
	{ 
		return accountNumber;
	}

	/**
	* Return the account type of this account.
	*
	* @return the account type as a string.
	**/

	public String getName()
	{ 
		return name;
	}
	
	/**
	* Return the current balance of this account.
	*
	* @return the balance as an integer.
	**/
	
	public int getBalance()
	{ 
		return balance;
	}

	/**
	* Return the overdraft limit of this account.
	*
	* @return the overdraft limit as an integer.
	**/

	public int getODLimit()
	{
		return overdraftLimit;
	}
	
	/**
	* Method to deposit money into an account
	*
	* @param value     value of the deposit
	**/
	
	public void deposit(int value)
	{ 
			balance = balance + value;
	}

	/**
	* Method to withdraw money from an account
	*
	* @param value     value of the withdrawal must not exceed overdraft limit
	**/

	public void withdraw(int value) throws IOException
  	{ 	if ((balance - value) < (0 - overdraftLimit))
		{	
			IOException OverdraftException 
				= new IOException("Not enough cash in account");
			throw OverdraftException;
		}
		balance = balance - value;
	}
  
  	/**
	* Return the account information
	*
	* @return the account information as a string.
	**/
  
  	public String toString()
	{
		String info;
		return info  = accountNumber + " " + name + " " + balance;
	}
}

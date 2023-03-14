//Implementing Methods Program
//Java 2 Essentials
//14_10_2002

public class BankAccount
{	public BankAccount ()
	{	balance = 0;
	}
	
	public BankAccount(double initialBalance)
	{	balance = initialBalance;
	}
	
	public void deposit(double amount)
	{	balance = balance + amount;
	}
	
	public void withdraw(double amount)
	{	balance = balance - amount;
	}
}


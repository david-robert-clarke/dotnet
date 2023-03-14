package bank;

/**
 * This class manages details about a single bank account.
 *
 * @author David Clarke
 **/

public class Account
{ 
  private int accountNumber;
  private String name;
  private int balance;
  
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
  }
  
  /**
   * Constructor to set up the account with given information.
   *
   * @param ac    the account number.
   * @param n     the account name.
   * @param bal   the starting balance.
   * @throws java.lang.IllegalArgumentException if bal is less than zero.
   **/
  
  public Account(int ac, String n, int bal) throws IllegalArgumentException
  { 
    // if the initial set balance is negative throw an IllegalArgumentException
    if (bal < 0)
    {
      IllegalArgumentException a 
	= new IllegalArgumentException();
      throw a;
    }
    
    accountNumber = ac;
    name = n;
    balance = bal;
  }
  
  /**
   * Set the account name
   *
   * @param n	the account name.
   **/
  
  public void setName(String n)
  { 
    name = n;
  }
  
  /**
   * Set the account balance
   *
   * @param bal the starting balance
   * @throws java.lang.IllegalArgumentException if b is less than zero
   **/
  
  public void setBalance(int bal) throws IllegalArgumentException 
  { 
    if (bal < 0)
    {
      IllegalArgumentException b 
	= new IllegalArgumentException();
      throw b;
    }
    balance = bal;
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
   * Return the name of this account.
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
   * Deposit an amount into the account
   *
   * @param value value of the deposit
   * @throws java.lang.IllegalArgumentException when value is negative
   **/
  
  public void deposit(int value) throws IllegalArgumentException
  { 
    // if the value to be deposited is negative throw an IllegalArgException
    if (value < 0)
    {
      IllegalArgumentException c 
	= new IllegalArgumentException();
      throw c;
    }
    // else add the amount to the current balance
    balance = balance + value;
  }
  
  /**
   * Withdraw an amount from the account
   *
   * @param value value of the withdrawal must not exceed overdraft limit
   * @throws java.lang.IllegalArgumentException when value is negative 
   * @throws OverdraftException when value is larger than balance
   **/
  
  public void withdraw(int value) throws IllegalArgumentException, 
					 OverdraftException 
  {	
    // if the amount to be withdrawn is negative throw an IllegalArgException
    if (value < 0)
    {
      IllegalArgumentException d 
	= new IllegalArgumentException();
      throw d;
    }
    
    /*
      else if the amount to be withdrawn is larger than the current balance
      throw an OverdraftException
    */							
    else if (value > balance)
    {
      OverdraftException e 
	= new OverdraftException(" ");
      throw e;
    }
    // else current balance becomes the old balance minus the specified amount
    balance = balance - value;
  }
  
  /**
   * Return the account details as a String.
   *
   * @return the account information as a string.
   **/
  
  public String toString()
  {
    String info = "Name: " + name + "\n" + "Account Number: " 
      + accountNumber + "\n" + "Balance: " + balance;	
    return info;
  }
}

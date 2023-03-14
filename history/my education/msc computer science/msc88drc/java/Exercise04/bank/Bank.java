package bank;
/**
 * This class collects and manipulates a set of Accounts stored in an array.
 *
 * @author David Clarke 
 **/
public class Bank
{
  private Account[] accounts;
  private int size;
  
  /**
   * Constructor to set up the bank with the default number of accounts
   **/
  public Bank()
  {
    accounts = new Account[5];
    for (int i = 0; i < 5; i++)
    {
      accounts[i] = new Account(0);
    }
  }
  
  /**
   * Constructor to set up the bank with the given number of accounts
   *
   * @param n the number of accounts.
   **/
  public Bank(int n)
  {
    size = n;
    accounts = new Account[size];
    for (int i = 0; i < size; i++)
    {
      accounts[i] = new Account(0);
    }
  }
  
  /**
   * Add a new account to the bank.
   *
   * @param a the new account to be added to the bank
   * @throws NoMoreAccountsException when no more accounts are allowed
   * @throws AccountExistsException when an account with the given number 
   * already exists. 
   * The associated message will be the account number as a String.
   **/
  public void addAccount(Account a) throws NoMoreAccountsException,
					   AccountExistsException
  {
    int index = 0;
    boolean freeCell = false;
    int i = 0;
    /*
      search for an avialable array cell to cater for the account
      update the array index of free cell
    */
    do
    {
      /*
	if the account number in array element i is equivalent to 0
	and the balance is equal to 0 then copy its' index and increment 
	the no of free cells
      */
      if (accounts[i].getAccountNumber() == 0 && accounts[i].getBalance() == 0)	 	
      {
	index = i;					
	freeCell = true;
      }
      else if (a.getAccountNumber() == accounts[i].getAccountNumber())
      {
	AccountExistsException e 
	  = new AccountExistsException("" + a.getAccountNumber() + "");
	throw e;  
      }
      i++;
    }while(i < accounts.length);
    
    /* 
       if there are no avialable elements in which to store an account throw an 
       exception
    */
    if (freeCell == false) 
    {
      NoMoreAccountsException e = new NoMoreAccountsException("Sorry");
      throw e;
    }
    
    /*
      else if there are available cells, place the account in the last 
      avialable cell
    */
    
    else if (freeCell == true)
    {
      accounts[index] = a;
    }
  }
  
  /**
   * Get an account from the bank.
   * @param accountNumber the account number
   * @return the Account object
   * @throws NotFoundException when there is no acc. with the specified number.
   * The associated message will be the requested account number as a String.
   **/
  public Account getAccount(int accountNumber) throws NotFoundException
  {
    int i = 0;
    // find the account with this accountNumber
    do
    {
      if (accountNumber == accounts[i].getAccountNumber())
      {
	return accounts[i];
      }
      i++;
    }while (i < accounts.length);
    
    // if the account cannot be found, throw an Exception
    if (i == accounts.length)
    {
      NotFoundException e = new NotFoundException("" + accountNumber + "");
      throw e;
    }
    return accounts[i]; 	// this statement will never be reached
  }
  
  /**
   * Remove an account from the bank.
   * @param accountNumber the account number
   * @throws NotFoundException when there is no acc. with the specified number. 
   * The associated message will be the requested account number as a String.
   **/
  public void removeAccount(int accountNumber) throws NotFoundException
  {
    boolean found = false;
    
    /*
      find the requested account number, when the array element is found
      remove that bank account i.e. initialise that element
    */
    for(int i = 0; i < accounts.length; i++)
    {
      if (accounts[i].getAccountNumber() == accountNumber)
      {
	accounts[i] = new Account(0);
	found = true;
      }
    }
    
    // if the account number was not found then throw an exception
    if (found == false)
    {
      NotFoundException e = new NotFoundException("" + accountNumber + "");
      throw e;
    }
  }
}

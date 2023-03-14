package bank;

/**
   This class collects and manipulates a set of Accounts stored
   in an array.
**/

public class Bank
{
   private Account[] accounts;
   private int size = 0;

   /**
      Constructor to set up the bank with the default number of accounts
   **/

   public Bank()
   {
      accounts = new Account[10];
   }

   /**
      Constructor to set up the bank with the given number of accounts

      @param n  the number of accounts.
   **/

   public Bank(int n)
   {
      accounts = new Account[n];
   }

   /*
      Private method to find the index of the account with the given
      account number.

      @param accountNumber  the account number
      @return the account index in accounts array or -1 if account
         not found
   */
   private int findAccount(int accountNumber)
   {
      for (int i = 0; i < size; i++)
         if (accounts[i].getAccountNumber() == accountNumber)
            return i;

      return -1;
   }

   /**
      Add a new account to the bank.

      @param a the new account to be added to the bank
      @exception NoMoreAccountsException when no more accounts are allowed
      @exception AccountExistsException when an account with the given
         number already exists. The associated message will be the 
         account number as a String.
   **/

   public void addAccount(Account a) throws NoMoreAccountsException,
      AccountExistsException
   {
      // make sure that there's space in the array
      if (size == accounts.length)
         throw new NoMoreAccountsException("The maximum number of accounts (" + 
            accounts.length + ") has been reached.");

      // check that there isn't already an accound with the same number
      int accNumber = a.getAccountNumber();
      if (findAccount(accNumber) != -1)
         throw new AccountExistsException(String.valueOf(accNumber));

      // add the account to the array and then increment size counter
      // n.b. use postfix increment so size is only incremented after the 
      // assignment has been made
      accounts[size++] = a;
   }

   /**
      Get an account from the bank.

      @param accountNumber the account number
      @return the Account object
      @exception NotFoundException when there is no account with the specified 
         number. The associated message will be the requested account number 
         as a String. 
   **/

   public Account getAccount(int accountNumber) throws NotFoundException
   {
      int index = findAccount(accountNumber);

      if (index == -1)
         throw new NotFoundException(String.valueOf(accountNumber));

      return accounts[index];
   }

   /**
      Remove an account from the bank.

      @param accountNumber the account number
      @exception NotFoundException when there is no account with the specified 
         number. The associated message will be the requested account number 
         as a String.
   **/

   public void removeAccount(int accountNumber) throws NotFoundException
   {
      // check that the account exists
      int index = findAccount(accountNumber);

      if (index == -1)
         throw new NotFoundException(String.valueOf(accountNumber));

      // shuffle all of the later accounts down
      for (int i = index; i < size - 1; i++)
         accounts[i] = accounts[i+1];

      // no need to set last account to null, simply decrement size
      size--;
   }
}


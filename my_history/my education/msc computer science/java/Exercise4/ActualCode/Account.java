package bank;

/**
  This class manages details about a single bank account.
  
  @author Bob
**/

public class Account
{
   private int accountNumber;
   private String name;
   private int balance;

   /**
   * Constructor to set up the account with the default name and a balance of 0.
   *
   * @param ac  the account number.
   **/
   public Account(int ac)
   {
      accountNumber = ac;
      name = "Current Account";
      balance = 0;
   }

   /**
   * Constructor to set up the account with given values.
   * 
   * @param ac   the account number.
   * @param n    the account name.
   * @param bal  the starting balance.
   *
   * @exception IllegalArgumentException if <code>bal</code> is less than zero.
   **/
   public Account(int ac, String n, int bal) throws IllegalArgumentException
   {
      if (balance < 0)
         throw new IllegalArgumentException("The initial balance of " + 
            "an account must be zero or greater");

      accountNumber = ac;
      name = n;
      balance = bal;
   }

   /**
   * Set the account name.
   *
   * @param n account name.
   **/
   public void setName (String n)
   {
      name = n;
   }

   /**
   * Set the account balance.
   * 
   * @param b account balance.
   * @exception IllegalArgumentException if <code>b</code> is less than zero
   **/
   public void setBalance (int b) throws IllegalArgumentException
   {
      if (b < 0)
         throw new IllegalArgumentException("The specified balance cannot be " + 
            "less than zero");

      balance = b;
   }

   /**
   * Return the account number of this account.
   * 
   * @return the account number as an integer.
   **/
   public int getAccountNumber ()
   {
      return accountNumber;
   }

   /**
   * Return the account name.
   * 
   * @return the account name.
   **/
   public String getName ()
   {
      return name;
   }

   /**
   * Return the account balance.
   * 
   * @return the account balance.
   **/
   public int getBalance ()
   {
      return balance;
   }

   /**
   * Deposit an amount in the account.
   * 
   * @param value amount of money to deposit.
   * @exception IllegalArgumentException when value is negative
   **/
   public void deposit (int value) throws IllegalArgumentException
   {
      if (value < 0)
         throw new IllegalArgumentException("Cannot deposit a negative " +
            "amount of money!");

      balance = balance + value;
   }

   /**
   * Withdraw an amount from the account.
   *
   * @param value amount of money to withdraw.
   * @exception IllegalArgumentException when value is negative
   * @exception OverdraftException when value is larger than balance
   **/
   public void withdraw (int value) throws IllegalArgumentException,
   OverdraftException
   {
      if (value < 0)
         throw new IllegalArgumentException("Cannot withdraw a negative " +
            "amount of money!");
      if (balance - value < 0)
         throw new OverdraftException("Insufficient credit for withdrawal");

      balance = balance - value;
   }


   /**
   * Return the account details as a string.
   * 
   * @return the account details.
   **/
   public String toString ()
   {
      return "Name: " + name + "\nAccount Number: " + accountNumber +
             "\nBalance: " + balance;
   }
}

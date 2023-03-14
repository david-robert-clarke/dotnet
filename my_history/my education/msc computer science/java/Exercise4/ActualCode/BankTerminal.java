import java.io.*;
import bank.*;

/**
   The interface class for the bank program.
   
   @author Marcin Chady
*/

class BankTerminal
{
   private BufferedReader reader;   // for reading input from System.in
   private Bank bank;

   /**
   * Default constructor which sets up a Bank that can hold 20 Accounts
   * and then displays the main menu.
   * 
   * @see #menu
   **/
   public BankTerminal()
   {
      // initialise the instance variables
      bank = new Bank(20); 
      reader = new BufferedReader(new InputStreamReader(System.in));
      
      // sit and wait for input
      menu();
   }
   
   /*
    The menu method contains a loop which presents the user with a 
    menu of available options and waits for input. When an option is 
    selected, the appropriate method is executed, and any exceptions 
    that occur are handled before going back to the beginning and 
    displaying the menu again. The loop continues until the user 
    types 'q' to quit. This method is invoked by the default constructor.
   */
   private void menu()
   {
      char choice = '\0';
      do
      {
         System.out.print("\nn - New Acc, r - Remove Acc, d - Deposit, " + 
            "w - Withdraw, i - Info, q - Quit --> ");
            
         try
         {
            choice = (char)reader.read(); // read a single character of input
            reader.readLine();	// skip the rest of line
            
            switch (choice)
            {
               case 'I':
               case 'i':   info();
                           break;
               case 'W':
               case 'w':   withdrawal();
                           break;
               case 'D':
               case 'd':   deposit();
                           break;
               case 'R':
               case 'r':   removeAccount();
                           break;
               case 'N':
               case 'n':   newAccount();
                           break;
               case 'Q':
               case 'q':   break;
               
               default :   System.out.println("\nUnrecognised option.");
            }
         }
         catch (NumberFormatException exception)
         {
            // All of the methods require numerical input. If the input 
            // cannot be parsed into a number, the parseInt method will 
            // throw a NumberFormatException with the unparsable String as 
            // the detail message.
            System.err.println("\n'" + exception.getMessage()
               + "' is not a valid number.\nPlease try again.");
         }
         catch (NotFoundException exception)
         {
            // If an invalid account is requested, the Bank will throw 
            // a NotFoundException. The exception's detail message will 
            // be the invalid accountNumber as a String.
            System.err.println("\nThe account '" + exception.getMessage() + 
               "' does not exist.\nPlease try again.");
         }
         catch (AccountExistsException exception)
         {
            // This exception will be thrown if newAccount() is called 
            // for an account with the same number as an account already 
            // present in the bank. The detail message will be the 
            // accountNumber as a String. 
            System.err.println("\nThe Account '" + exception.getMessage() + 
               "' already exists.\nPlease try again.");
         }
         catch (OverdraftException exception)
         {
            // Thrown from Account.withdraw()
            System.err.println("\nCustomer not authorised to take out this "
               + "amount of money.\nPlease try again.");
         }
         catch (IllegalArgumentException exception)
         {
            // Thrown from Account.withdraw() or Account.deposit() if 
            // the argument to the method is negative.
            System.err.println("\nCannot deposit or withdraw a negative amount "
               + "of money.\nPlease try again.");
         }
         catch (NoMoreAccountsException exception)
         {
            // This exception will be thrown if newAccount is called 
            // when the bank is already full.
            System.err.println("\nNo more new accounts allowed. " + 
               exception.getMessage());
         }
         catch (IOException exception)
         {
            // In the unlikey event of an IOException when reading in 
            // values from the user
            System.out.println("\nAn exception occurred during reading:\n" + 
               exception + "\n\nPlease try again.");
         }
      } while (choice != 'q' && choice != 'Q');
   }

   /*
    Request an account number from the user, attempt to retrieve 
    the Account from the bank, and print its details.
    All exceptions are thrown on to caller.
   */
   private void info() throws NumberFormatException, NotFoundException,
      IOException
   {
      System.out.print("\nEnter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      Account account = bank.getAccount(accountNumber);
      System.out.println("\nAccount details:\n" + account);
   }

   /*
    Request an account number and withdrawal amount from the user, 
    attempt to retrieve the Account from the bank and make the 
    withdrawal.
    All exceptions are thrown on to caller.
   */
   private void withdrawal() throws NumberFormatException,
      NotFoundException, IOException, OverdraftException
   {
      System.out.print("\nEnter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      Account account = bank.getAccount(accountNumber);
      System.out.print("Enter amount to withdraw --> ");
      int amount = Integer.parseInt(reader.readLine());
      account.withdraw(amount);
      System.out.println("\nTransaction completed.");
   }

   /*
    Request an account number and deposit amount from the user, 
    attempt to retrieve the Account from the bank and make the 
    deposit.
    All exceptions are thrown on to caller.
   */
   private void deposit() throws NumberFormatException,
      NotFoundException, IOException
   {
      System.out.print("\nEnter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      Account account = bank.getAccount(accountNumber);
      System.out.print("Enter amount to deposit --> ");
      int amount = Integer.parseInt(reader.readLine());
      account.deposit(amount);
      System.out.println("\nTransaction completed.");
   }

   /*
    Request an account number from the user and attempt to remove 
    the Account from the bank.
    All exceptions are thrown on to caller.
   */
   private void removeAccount() throws NumberFormatException,
      NotFoundException, IOException
   {
      System.out.print("\nEnter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      bank.removeAccount(accountNumber);
      System.out.println("\nAccount " + accountNumber + " removed.");
   }

   /*
    Request an account details from the user, create new Account object 
    and attempt to add it to the bank.
    All exceptions are thrown on to caller.
   */
   private void newAccount() throws NumberFormatException,
      NotFoundException, IOException, AccountExistsException,
      NoMoreAccountsException
   {
      System.out.print("\nEnter name --> ");
      String name = reader.readLine();
      System.out.print("Enter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      bank.addAccount(new Account(accountNumber, name, 0));
      System.out.println("\nAccount " + accountNumber + " created.");
   }
   
   /* 
    The main method simply creates a new instance of BankTerminal. The 
    constructor calls the menu() method which will continue to loop and 
    accept input until the user chooses to quit. At which point the 
    main method exits.
   */
   public static void main(String[] args)
   {
      new BankTerminal();
   }
}

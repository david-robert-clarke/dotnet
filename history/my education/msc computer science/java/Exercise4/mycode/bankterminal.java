import java.io.*;
import bank.*;

/**
* The interface class for the bank program.
*
* @author David Clarke   
*/

class BankTerminal
{
   private BufferedReader reader;   // for reading input from System.in
   private Bank bank;

   /**
   * Default constructor which sets up a Bank that can hold 20 Accounts
   * and then displays the main menu.
   **/
   public BankTerminal()
   {
      // initialise the instance variables
      bank = new Bank(20); 
      reader = new BufferedReader(new InputStreamReader(System.in));
      
      // wait for input
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
            // All the methods called above are going to have to 
            // ask the user to input a number. If the input 
            // cannot be parsed into a number, the parseInt method will 
            // throw a NumberFormatException with the unparsable String as 
            // the detail message.
            System.out.println("\n'" + exception.getMessage()
               + "' is not a valid number.\nPlease try again.");
         }
         catch (NotFoundException exception)
         {
            // If an invalid account is requested, the Bank will throw 
            // a NotFoundException. The exception's detail message will 
            // be the invalid accountNumber as a String.
            System.out.println("\nThe account '" + exception.getMessage() + 
               "' does not exist.\nPlease try again.");
         }
         catch (AccountExistsException exception)
         {
            // This exception will be thrown if newAccount() is called 
            // for an account with the same number as an account already 
            // present in the bank. The detail message will be the 
            // accountNumber as a String. 
            System.out.println("\nThe Account '" + exception.getMessage() + 
               "' already exists.\nPlease try again.");
         }
         catch (OverdraftException exception)
         {
            // Thrown from Account.withdraw()
            System.out.println("\nCustomer not authorised to take out this "
               + "amount of money.\nPlease try again.");
         }
         catch (IllegalArgumentException exception)
         {
            // Thrown from Account.withdraw() or Account.deposit() if 
            // the argument to the method is negative.
            System.out.println("\nCannot deposit or withdraw a negative amount "
               + "of money.\nPlease try again.");
         }
         catch (NoMoreAccountsException exception)
         {
            // This exception will be thrown if newAccount is called 
            // when the bank is already full.
            System.out.println("\nNo more new accounts allowed. " + 
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
   
   /**
   * Displays the customers Bank Account information
   * @throws NumberFormatException
   * @throws NotFoundException
   * @throws IOException
   **/
   private void info() throws NumberFormatException, NotFoundException,
      IOException
   {
      System.out.print("\nEnter account number --> ");
      int accountNumber = Integer.parseInt(reader.readLine());
      Account account = bank.getAccount(accountNumber);
      System.out.println("\nAccount details:\n" + account);
   }

   /**
   * Displays an interface that allows the customer to withdraw money
   * from their Bank Account
   * @throws NumberFormatException
   * @throws NotFoundException
   * @throws IOException
   * @throws OverdraftException
   **/
   private void withdrawal() throws NumberFormatException,
      NotFoundException, IOException, OverdraftException
   {	
	   System.out.print("\nEnter account number --> ");
	   int ac = Integer.parseInt(reader.readLine());
	   System.out.print("Enter amount to withdraw --> ");
	   int amt = Integer.parseInt(reader.readLine());
	   Account account = bank.getAccount(ac);
	   account.withdraw(amt);
	   System.out.println("\nTransaction Completed.");
   }
   
   /**
   * Displays an interface that allows the customer to deposit money
   * to their Bank Account
   * @throws NumberFormatException
   * @throws NotFoundException
   * @throws IOException
   **/
   private void deposit() throws NumberFormatException,
      NotFoundException, IOException
   {
	   System.out.print("\nEnter account number --> ");
	   int ac = Integer.parseInt(reader.readLine());
	   System.out.print("Enter amount to deposit --> ");
	   int amt = Integer.parseInt(reader.readLine());
	   Account account = bank.getAccount(ac);
	   account.deposit(amt);
	   System.out.println("\nTransaction Completed.");
   }

   /**
   * Displays an interface that allows the customer to remove their
   * account
   * @throws NumberFormatException
   * @throws NotFoundException
   * @throws IOException
   **/
   private void removeAccount() throws NumberFormatException,
      NotFoundException, IOException
   {
	   System.out.print("\nEnter account number --> ");
	   int ac = Integer.parseInt(reader.readLine());
	   bank.removeAccount(ac);
	   System.out.println("\nAccount " + ac + " removed.");
   }
   
   /**
   * Displays an interface that allows the customer to create a new
   * account
   * @throws NumberFormatException
   * @throws NotFoundException
   * @throws IOException
   * @throws AccountExistsException
   * @throws NoMoreAccountsException
   **/
   private void newAccount() throws NumberFormatException,
      NotFoundException, IOException, AccountExistsException,
      NoMoreAccountsException
   {
	   System.out.print("\nEnter name --> ");
	   String n = reader.readLine();
	   System.out.print("Enter account number --> ");
	   int ac = Integer.parseInt(reader.readLine());
	   Account a = new Account(ac,n,0);
	   bank.addAccount(a);
	   System.out.println("\nAccount " + ac + " created.");    
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


import java.io.*;

public class TestAccount
{
  public static void main (String[] arguments) throws IOException
  {
	BufferedReader reader = 
			new BufferedReader (new InputStreamReader(System.in));
			
    Account yourAccount = new Account(10000001);
	Account myAccount = new Account(74189458);
	int auditCount = 0;
	int amount = 0;
	int choice = 0;
	int choiceNxt = 0;
	int choiceAcc = 0;
	
	//If creating new account for customer, choose option (1). If 
	//customer wants to update their existing account choose option (2).
	System.out.println("\n\n\n");
	System.out.println("******************************");
	System.out.println("**-Welcome to DaveMid Bank-**");
	System.out.println("******************************");
	System.out.println("\n\n\n");
	System.out.println("Please choose one from the following options:");
	System.out.println();
	System.out.println("(1) Create new account");
	System.out.println("(2) Update existing account\n\n\n\n\n\n\n\n\n\n\n");
	System.out.print("Choice: ");
	choice = Integer.parseInt(reader.readLine());

	do 
	{	
		if (choice == 1)
		{//set next choice to option 4 choose new account
			choiceNxt = 4;
		}
	
		else
		{
		//After the account information has been displayed, let the 
		//customer choose from a list of options
		System.out.println();
		System.out.print("Please choose one from the following ");
		System.out.println("options: \n");
		System.out.println("(1) Deposit Money");
		System.out.println("(2) Withdraw Money");
		System.out.println("(3) Display Account Information");
		System.out.println("(4) Change the Account Type");
		System.out.println("(5) Change the Overdraft Limit");
		System.out.println("(6) Quit/Cancel Program \n");
		System.out.println("\n\n\n\n\n\n\n");
		System.out.print("Choice: ");
		choiceNxt = Integer.parseInt(reader.readLine()); 
		}
	
  		if (choiceNxt == 1)
		{
			do
			{
				try
				{ 
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.print("How much would you like to deposit? ");
					amount = Integer.parseInt(reader.readLine());
				}
				catch (NumberFormatException e1)
				{
					System.out.println("Inputted a negative amount, please re-input ");
				}
			}while (amount < 0);
			
			yourAccount.deposit(amount);
			auditCount = auditCount + 1;
		}

		else if (choiceNxt == 2)
		{	
			do
			{
				try
				{ 
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.print("How much would you like to withdraw? ");
					amount = Integer.parseInt(reader.readLine());
				}
				catch (NumberFormatException e1)
				{
					System.out.println("Inputted a negative amount, please re-input ");
				}
			}while (amount < 0);
					
			yourAccount.withdraw(amount);
			auditCount = auditCount + 1;
		}
	  
	  	else if (choiceNxt == 3)
		{	
			System.out.println("\n");
			System.out.println(yourAccount.toString());
		}

		else if (choiceNxt == 4)
		{
			//Setting up the Account
			//Ask the customer which type of account they would like
			System.out.println("\n\n\n\n\n");
			System.out.println("Which type of Account would you like?\n");
			System.out.println("1. Current Account");
			System.out.println("2. First Savers Account");
			System.out.println("3. Student Account");  
			System.out.println("4. Gold Account\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.print("Choice: ");
			choiceAcc = Integer.parseInt(reader.readLine()); 

		}
		
		else if (choiceNxt == 5)
		{
			//Ask customer to choose their overdraft Limit
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			do
			{//If the overdraft limit is below 0 or greater than 1000 ask customer to re-type
				System.out.print("Please enter the overdraft limit you would like (0 -> 1000): ");
				amount = Integer.parseInt(reader.readLine());
				
			}while ((amount < 0) || (amount > 1000));
			yourAccount.setODLimit(amount);
		}
	
    	if (choiceAcc == 1)
	{
		yourAccount.setName("Current Account");
	}
	
    	else if (choiceAcc == 2)
	{
		yourAccount.setName("FirstSavers Account");
	}
	
    	else if (choiceAcc == 3)
	{
		yourAccount.setName("Student Account");
	}
	
    	else if (choiceAcc == 4)
	{
		yourAccount.setName("Gold Account");
	}
		
		if (choiceNxt != 6)
		{
			//Print out the customers information after every Account option
			System.out.println("\n");
			System.out.println("******************************");
			System.out.print("Account No     : ");
			System.out.println(yourAccount.getAccountNumber());
			System.out.print("Name           : ");
			System.out.println(yourAccount.getName());
			System.out.print("Balance        : ");
			System.out.println(yourAccount.getBalance());
			System.out.print("Overdraft Limit: ");
			System.out.println(yourAccount.getODLimit());
			System.out.print("Transaction No : ");
			System.out.println(auditCount);
			System.out.println("******************************");
		}
		choice = 0;//initialise loop selector
	} while(choiceNxt != 6);
  }
}

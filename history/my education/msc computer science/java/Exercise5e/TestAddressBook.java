import addressbook.*;
import java.io.*;

/**
   program that tests each method in the AddrssBook class to see if everything 
   behaves correctly

   @author David Clarke
**/

class TestAddressBook
{
    public static void main (String[] args)
    {
	AddressBook myBook = new AddressBook();

	try
	    {
		System.out.println(myBook.getTodaysDateTime());
		
	    }
	catch (FileFormatException exception)
	    {

		System.out.println("\n'" + exception.getMessage()
			    + "' is not a valid entry.\nPlease try again.");
	    }
	/*		catch (NoSuchEntryException exception)
	    {
		System.out.println("\nThe entry '" + 
				   exception.getMessage() + 
				   "' does not exist.\nPlease try again.");	 
	    }
	*/
	catch (IOException exception)
	    {
		System.out.println("\nAn exception occurred during " + 
				   "reading:\n" + exception + 
				   "\n\nPlease try again.");
	    }
	catch (EntryExistsException exception)
	    {
		System.out.println("\nThe Entry '" + 
				   exception.getMessage() + 
				   "' already exists.\nPlease try again.");
	    }
    } 
}


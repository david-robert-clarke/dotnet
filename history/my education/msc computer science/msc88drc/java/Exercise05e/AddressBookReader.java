import java.io.*;
import addressbook.*;

/**
   The interface for the addressbook program
   
   @author David Clarke
**/

class AddressBookReader
{	
  private BufferedReader reader; // for reading input
  private AddressBook addressbook;
  private String pfn;
  private String pgn;
  private char choice;
    
  /**
   * Default constructor which sets up one address book that stores an
   * unlimited number of people and their personal data
   *
   * @see #menu
   **/
  public AddressBookReader ()
  {
    // initialise the instance variables
    addressbook = new AddressBook();
    reader = new BufferedReader (new InputStreamReader(System.in));
	
    // wait for input
    menu();
  }
    
  /**
   * This constructor is activated when the user specifies the file to be 
   * loaded from the command line
   *
   * @param filename the name of the file to be loaded
   **/
  public AddressBookReader (String filename)
  {
	
    // initialise the instance variables
    addressbook = new AddressBook();
    reader = new BufferedReader (new InputStreamReader(System.in));
		
    try
    {
      int noofrecords = addressbook.load(filename);
      System.out.println("\n" + noofrecords + 
			 " record(s) read in from "  + filename);
    }
		
    catch (IOException exception)
    {
      // In the unlikey event of an IOException when reading 
      // in values from the user
      System.out.println("\nAn exception occurred during " + 
			 "reading:\n" + exception + 
			 "\n\nPlease try again.");
    }
    catch (FileFormatException exception)
    {
      // Only thrown by the load method of the AddressBook 
      // when a BadRecordException is detected.
      System.out.println("\n'" + exception.getMessage()
			 + "' is not a valid entry.\nPlease try again.");
    }
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
    do
    {
      System.out.println("\n a - Add New Entry");
      System.out.println(" r - Remove Entry");
      System.out.println(" e - Edit Entry");
      System.out.println(" f - Find Entry");
      System.out.println(" l - Load Address Book");
      System.out.println(" s - Save Address Book");
      System.out.println(" q - Quit");
      System.out.print("\nPlease choose an option: ");
		
      try
      {
	choice = (char)reader.read(); // read a single char
	reader.readLine(); // skip the rest of line
			
	switch (choice)
	{
	case 'A':
	case 'a':	addEntry();
	  break;
	case 'R':
	case 'r': removeEntry();
	  break;
	case 'E': 
	case 'e':	editEntry();
	  break;
	case 'F':
	case 'f': findEntry();
	  break;
	case 'L':
	case 'l': loadAddressBook();
	  break;
	case 'S':
	case 's': saveAddressBook();
	  break;
	case 'Q':
	case 'q': quit();
	  break;
	default : 
	  System.out.println("\nUnrecognised option.");
	}
      }
      catch (BadRecordException exception)
      {
	// This exception will be thrown if loadAddressBook() 
	// is called for a record in an address book that is 
	// malformed. 
	System.out.println("\n'" + exception.getMessage() +
			   " individual record in address book is malformed.");
      }
      catch (EntryExistsException exception)
      {
			
	// This exception will be thrown if addEntry() is 
	// called for an entry with the same number as an 
	// entry already present in the addressbook. The 
	// detail message will be the entry as a String.
	System.out.println("\nThe Entry '" + 
			   exception.getMessage() + 
			   "' already exists.\nPlease try again.");
      }
      catch (FileFormatException exception)
      {
	// Only thrown by the load method of the AddressBook 
	// when a BadRecordException is detected.
	System.out.println("\n'" + exception.getMessage()
			   + "' is not a valid entry.\nPlease try again.");
      }
      catch (NoSuchEntryException exception)
      {
	// When the find method is used, if the specified 
	// names cannot be found in the address book then a 
	// NoSuchEntryException is thrown.
	System.out.println("\nThe entry '" + exception.getMessage() + 
			   "' does not exist.\nPlease try again.");
      }
      catch (IOException exception)
      {
	// In the unlikey event of an IOException when reading 
	// in values from the user
	System.out.println("\nAn exception occurred during " + "reading:\n" 
			   + exception + "\n\nPlease try again.");
      }
    } while (choice != 'q' && choice != 'Q');
  }
    
  /*
    Requests all the fields of a particular entry to be entered by the user.
    Adds an entry to the AddressBook.
    All exceptions are thrown on to caller.
  */
  private void addEntry() throws IOException, EntryExistsException
  {
    enterNames();
    System.out.print("Please enter their home phone number: ");
    String hpn = reader.readLine();
    System.out.print("Please enter their work phone number: ");
    String wpn = reader.readLine();
    System.out.print("Please enter their mobile phone number: ");
    String mpn = reader.readLine();
    System.out.print("Please enter their email address: ");
    String ema = reader.readLine();
    System.out.print("Please enter their house name or number: ");
    String hnn = reader.readLine();
    System.out.print("Please enter their street name: ");
    String sn = reader.readLine();
    System.out.print("Please enter their town: ");
    String t = reader.readLine();
    System.out.print("Please enter their region: ");
    String r = reader.readLine();
    System.out.print("Please enter their country: ");
    String c = reader.readLine();
    System.out.print("Please enter their postcode: ");
    String pc = reader.readLine();
	
    Person thisPerson = new Person(pfn, pgn, hpn, wpn, mpn, ema);
    Address thisAddress = new Address(hnn, sn, t, r, c ,pc);
    addressbook.addEntry(thisPerson, thisAddress);
	
    System.out.print("\n" + pgn + " " + pfn);
    System.out.println(" added to address book.");
  }
    
  /*
    Requests the names of an address book entry from the user. Attempts to
    to remove the entry from the address book
    All exceptions are thrown on to caller.
  */
  private void removeEntry()throws NoSuchEntryException, IOException
  {
    enterNames();
    addressbook.removeEntry(pfn, pgn);
    System.out.println("\n" + pgn + " " + pfn + 
		       " removed from address book.");
  }
    
  /*
    Requests the names of an address book entry from the user. 
    Allows the user 
    to edit details associated with an entry.
    All exceptions are thrown on to caller.
  */
  private void editEntry() throws NoSuchEntryException, BadRecordException, 
				  FileFormatException, IOException, 
				  EntryExistsException
  {
    // local method variable n, stores the user input as a string
    String n;
	
    enterNames();
    /* 
       all the person's data is stored in the address book. To retrieve 
       this data, objects at the various levels need to be referenced 
       until the lowest level is observed. At the highest level - Address 
       Book, middle level - Entry, lowest level - Address, Person.
    */
    Entry thisEntry = addressbook.getEntry(pfn, pgn);
    Person thisPerson = thisEntry.getPerson();
    Address thisAddress = thisEntry.getAddress();
	
    // change current family name? (Uses the Person Class)
    System.out.print("Current family name: ");
    System.out.println(thisPerson.getFamilyName());
    System.out.print("Enter new family name" + 
		     "(or press RETURN to leave unchanged):");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setFamilyName(n);
    }
	
    // change persons given names?
    System.out.print("Current given name: ");
    System.out.println(thisPerson.getGivenNames());
    System.out.print("Enter new given name " +
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setGivenNames(n);
    }
	
    // change home phone number?
    System.out.print("Current home phone number: ");
    System.out.println(thisPerson.getHomePhone());
    System.out.print("Enter new home phone number " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setHomePhone(n);
    }
	
    // change work phone number?
    System.out.print("Current work phone number: ");
    System.out.println(thisPerson.getWorkPhone());
    System.out.print("Enter new work phone number " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setWorkPhone(n);
    }
		
    // change mobile phone number?
    System.out.print("Current mobile phone number: ");
    System.out.println(thisPerson.getMobilePhone());
    System.out.print("Enter new mobile phone number " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setMobilePhone(n);
    }
		
    // change e-mail address?
    System.out.print("Current email address: ");
    System.out.println(thisPerson.getEMail());
    System.out.print("Enter new email address " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisPerson.setEMail(n);
    }
		
    // change house name or number? (uses the Address Class)
    System.out.print("Current house name or number: ");
    System.out.println(thisAddress.getHouse());
    System.out.print("Enter new house name or number " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setHouse(n);
    }
		
    // change current street?
    System.out.print("Current street: ");
    System.out.println(thisAddress.getStreet());
    System.out.print("Enter new street " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setStreet(n);
    }
		
    // change current town?
    System.out.print("Current town: ");
    System.out.println(thisAddress.getTown());
    System.out.print("Enter new town " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setTown(n);
    }
		
    // change current region?
    System.out.print("Current region: ");
    System.out.println(thisAddress.getRegion());
    System.out.print("Enter new region " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setRegion(n);
    }
		
    // change current country?
    System.out.print("Current country: ");
    System.out.println(thisAddress.getCountry());
    System.out.print("Enter new country " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setCountry(n);
    }
		
    // change current post code?
    System.out.print("Current postcode: ");
    System.out.println(thisAddress.getPostCode());
    System.out.print("Enter new postcode " + 
		     "(or press RETURN to leave unchanged): ");
    n = reader.readLine();
    if (n.equals(""))
    {
    }
    else
    {
      thisAddress.setPostCode(n);
    }
  }
	
  /*
    Requests the names of a particular entrant. Attempts to find their 
    details.
    All exceptions are thrown on to caller.
  */
  private void findEntry() throws NoSuchEntryException, IOException
  {
    char reply;
    do
    {
      System.out.print("Please enter the person's family name: ");
      pfn = reader.readLine();
      System.out.print("Please enter the person's given names: ");
      pgn = reader.readLine();
      Entry thisEntry = addressbook.getEntry(pfn, pgn);
      Person thisPerson = thisEntry.getPerson();
      Address thisAddress = thisEntry.getAddress();
			
      System.out.println("\n" + thisPerson);
      System.out.println(thisAddress);
			
      // Additional, ask if they want to request anymore people
      System.out.print("\nFind another Entry(y/n)?");
      reply = (char)reader.read();
      reader.readLine();

    }while (reply == 'y' || reply == 'Y');
  }
	
  /*
    Requests a filename from the user. Attempts to load a new address book 
    from file
    All exceptions are thrown on to caller.
  */
  private void loadAddressBook() throws FileFormatException, IOException,
					BadRecordException
  {
    System.out.print("Load new address book without saving current one(y/n)?");
    char decide = (char)reader.read();
    reader.readLine(); // skip the rest of line
	  
    if (decide == 'y' || decide == 'Y')
    {
      System.out.print("--Load File--\n" + 
		       "Please enter the filename: ");
      String n = reader.readLine();
      int noofrecords = addressbook.load(n);
      System.out.println("\n" + noofrecords 
			 + " record(s) read in from " + n);
    }
    else
    {
      saveAddressBook();
    }
  }
	
  /*
    Requests a filename from the user. Attempts to save a new address book 
    to a file
    All exceptions are thrown on to caller.
  */
  private void saveAddressBook() throws IOException
  {
    System.out.println("--Save File--");
    System.out.print("Please enter the filename: ");
    String n = reader.readLine();
    addressbook.save(n);
    System.out.println("\nAddress book contents saved to " + n);
  }
	
  /*
    Requests confirmation from the user. Program either quits or continues.
    throws IOException
  */
  private void quit()throws IOException
  {
    System.out.print("Save addressbook before quitting(y/n)? ");
    char decide = (char)reader.read();
    reader.readLine(); // skip the rest of line
	  
    // if yes, save address book first then quit
    if (decide == 'y' || decide == 'Y')
    {
      saveAddressBook();
    }

    choice = 'q';
  }
	
  /*
    Requests given and family names to be inputted by the user
    All exceptions are thrown on to caller.
  */
  private void enterNames()throws IOException
  {
    System.out.print("Please enter the person's family name: ");
    pfn = reader.readLine();
    System.out.print("Please enter the person's given names: ");
    pgn = reader.readLine();
  }
    
  /* 
     The main method simply creates a new instance of AddressBookReader. The 
     constructor calls the menu() method which will continue to loop and 
     accept input until the user chooses to quit. At which point the 
     main method exits.
  */
  public static void main (String [] args)
  {
    // on the command line, the String that is specified after the java file
    // is the filename of the abf to be loaded	
    if (args.length > 0)
    {
      String filename = args[0];
      new AddressBookReader(filename);
    } 
    else
    {
      new AddressBookReader();
    }
  }
}


package addressbook;
import java.io.*;
import java.util.*;

/**
   This class stores and manipulates a set of Entry objects, each of which 
   contains contact details for a single person. For simplicity, records are 
   uniquely identified by the combination of a person's family name and given 
   names, so multiple records with exactly the same name are not allowed. 

   The contents of an AddressBook may be read from and written to a simple
   text file.
  
   @author David Clarke
**/

public class AddressBook
{
  private ArrayList entries;
  private ArrayList tempEntries;
    
  /**
   * Constructor to create an empty AddressBook
   **/	
  public AddressBook()
  {
    entries = new ArrayList();
    tempEntries = new ArrayList();
  }

  /**
   * Load address data from the specified file. 
   * If the specified file exists and is readable, the records are read in, 
   * and any existing records are replaced by the new records. 
   * If the load process fails for any reason, the existing records are 
   * retained.
   *
   * @param filename the name of the file to load the address data from.
   * @return the number of records successfully read in from the file
   * 
   * @exception FileFormatException - if any of the following occurs:
   * <ul>
   * <li> if the file does not appear to be a valid address book file
   * <li> if any of the records is malformed, 
   * <li> if the number of records found in the body of the file is less 
   * than the number specified in the header 
   * </ul>
   * @exception java.io.IOException if the specified file cannot be read, 
   * or if any other error occurs during reading
   **/
  public int load(String filename) throws FileFormatException, IOException
  {
    // local variable declaration
    int NoOfRecords = 0;
    Entry fileEntry;
    String title;

    InputStream in = new FileInputStream(filename);
    BufferedReader myReader = new BufferedReader(new InputStreamReader(in));
	
    // reads in the title
    title = myReader.readLine(); 
	
    // if the length of the title is less than 51 chars (standard title 
    // length) then throw a FileFormatException
    if  (title.length() != 51)  
    {
      throw new FileFormatException ("Invalid header information -" +
				     " File does not appear to be a"+
				     " valid address book file.");
    }
	
    // reads in the number of records
    NoOfRecords = Integer.parseInt(myReader.readLine());
	
    // clear previous data stored in the temporary ArrayList
    tempEntries.clear();

    // add entries from file into the ArrayList entries until all the 
    // records have been processed	
    for (int i = 0; i < NoOfRecords; i++)
    {	
      try
      {
	// Call the read method from the Entry class. Gather 
	// an entrants record.
	fileEntry = Entry.read(myReader);

	if (fileEntry == null)
	{
	  throw new FileFormatException("File contains fewer records than " +
					"indicated in header.' ");
	}

	// when the size of the array list is one element or
	// greater
	for(int j = 0; j < tempEntries.size(); j++)
	{
	  // get the Entry object from each element in 
	  // the Array List tempEntries
	  Entry readEntry = (Entry)tempEntries.get(j);

	  // extract the entrants Family and Given names
	  String familyName = 
	    readEntry.getPerson().getFamilyName();
	  String givenNames = 
	    readEntry.getPerson().getGivenNames();

	  // see if the Entry objects's family and given 
	  // names match that of the new Entry's. If  
	  // they do, throw a FileFormatException
	  if (fileEntry.matchesPerson(familyName, givenNames))
	  {
	    FileFormatException e = 
	      new FileFormatException("Multiple Entries with the same family" +
				      "and given names " + givenNames 
				      + " "+ familyName);
	    throw e;
	  }
	}
	// Append entrant to the end of the temporary storage 
	// ArrayList
	tempEntries.add(fileEntry);


      }
      catch (BadRecordException exception)
      {
	// Print out exception message if the record in the 
	// addressbook is malformed
	System.out.println("\n'" + exception.getMessage()
			   + "' individual record in address " 
			   + " book is malformed.");

	// then throw a File Format Exception
	FileFormatException e = 
	  new FileFormatException(filename);
	throw e;
      }	
    }

    // only copy the entries from the temporary Array List to the 
    // permanent Array List when the entire loading process has been 
    // completed successfully
    entries = tempEntries;

    // return the number of records to the calling program
    return (NoOfRecords);
  }

  /**
   * Save address data into the specified file.
   *
   * @exception java.io.IOException if an error occurs while writing the file
   **/
  public void save(String filename) throws IOException
  {
    // local variable declaration
    String fileTitle = "Java Address Book File ";
    String noEntries = "" + entries.size();

    // create a new instance of a new FileOutputStream, save addressbook
    // entries to the filename
    OutputStream out = new FileOutputStream(filename);
    BufferedWriter myWriter 
      = new BufferedWriter(new OutputStreamWriter(out));

    // save to file, the title of the file and today's date & time on the
    // first line
    myWriter.write(fileTitle, 0, fileTitle.length());
    myWriter.write(getTodaysDateTime());

    // on a new line write the number of records to saved
    myWriter.newLine();
    myWriter.write(noEntries, 0, noEntries.length());
    myWriter.newLine();


    // step through the entries in the address book, and for each entry  
    // call its' write() method
    for (int i = 0; i < entries.size(); i++)
    {
      Entry a = (Entry)entries.get(i);
      a.write(myWriter);
    }


    // make sure the writer is closed, and all the information is flushed 
    // into the file	
    myWriter.close();
  }

  /**
   * Add an entry into the address book.
   *
   * @param p the personal details for the entry
   * @param a the address details for the entry
   * @exception EntryExistsException if there is already an entry in the 
   * address 
   * book whose name matches that stored in <code>p</code> .
   **/
  public void addEntry(Person p, Address a) throws EntryExistsException
  {
    // create a new Entry instance called userReqEntry
    Entry userReqEntry = new Entry(p,a);

    // when the size of the array list is one element or greater
    for(int i = 0; i < entries.size(); i++)
    {
      // get the Entry object from each element
      Entry readEntry = (Entry)entries.get(i);

      // extract the entrants Family and Given names
      String familyName = readEntry.getPerson().getFamilyName();
      String givenNames = readEntry.getPerson().getGivenNames();

      // see if the Entry objects's family and given names match that
      // of the  new Entry's. If they do, throw an 
      // EntryExistsException
      if (userReqEntry.matchesPerson(familyName, givenNames))
      {
	EntryExistsException e = new EntryExistsException("");
	throw e;
      }
    }

    // add the user requested entry to the end of the ArrayList
    entries.add(userReqEntry);

  }
  /**
   * Get an entry from the address book.
   *
   * @param familyName the family name of the person
   * @param givenNames the given name(s) of the person
   * @exception NoSuchEntryException if no entry can be found that matches 
   * the names supplied
   **/
  public Entry getEntry(String familyName, String givenNames) 
    throws NoSuchEntryException
  {
    // local variable declaration
    int index = 0;

    // if there are no Entries in the Array List throw a 
    // NoSuchEntryException
    if (entries.size() == 0)
    {
      NoSuchEntryException e = new NoSuchEntryException("");
      throw e;
    }
    // search through the ArrayList elements, find entry with the given 
    // family name and given names
    do
    {

      // get each object from the ArrayList, using a cast operator, 
      // transform the universal object to an Entry object
      Entry thisEntry = (Entry)entries.get(index);

      // Use the matchesPerson method to test whether the entry's 
      // family name and given names match those specified by the 
      // user
      if (thisEntry.matchesPerson(familyName, givenNames))
      {
	return thisEntry;
      }
      index++;
    }while(index < entries.size());


    //  if the user specified family name and given names cannot be found, 
    //  throw an exception
    if (index == entries.size())
    {
      NoSuchEntryException e = new NoSuchEntryException("");
      throw e;
    }

    // this statement will never be reached
    Entry thisEntry = (Entry)entries.get(0);
    return thisEntry; 
  }

  /**
   * Remove an entry from the address book. 
   *
   * @param familyName the family name of the person
   * @param givenNames the given name(s) of the person
   * @throws NoSuchEntryException if no entry can be found that matches the 
   * names supplied
   **/
  public void removeEntry(String familyName, String givenNames)
    throws NoSuchEntryException
  {
    // local variable declaration
    int index = 0;
    boolean matched = false;

    // if there are no Entries in the Array List throw a 
    // NoSuchEntryException
    if (entries.size() == 0)
    {
      NoSuchEntryException e = new NoSuchEntryException("");
      throw e;
    }

    do
    {
      // get each object from the ArrayList, using a cast operator, 
      // transform the universal object to an Entry object.
      Entry thisEntry = (Entry)entries.get(index);

      // Use the matchesPerson method to test whether the entry's 
      // family name and given names match those specified by the 
      // user
      if (thisEntry.matchesPerson(familyName, givenNames))
      {
	entries.remove(index);
	matched = true;
      }
      index++;
    }while(index < entries.size());


    // if the familyNames and givenNames could not be found, throw a
    // NoSuchEntryException
    if (matched == false)
    {
      NoSuchEntryException e = new NoSuchEntryException("!!");
      throw e;
    }
  }

  private String getTodaysDateTime()
  {
    Calendar cal = Calendar.getInstance(TimeZone.getDefault());

    // saves calendar info in the format Wed Nov 13 19:48:33 GMT 2002
    String DATE_FORMAT = "EEE MMM d HH:mm:ss z yyyy";
    java.text.SimpleDateFormat sdf = 
      new java.text.SimpleDateFormat(DATE_FORMAT);

    // this line of code sets the time zone manually;
    sdf.setTimeZone(TimeZone.getDefault());  
    return(sdf.format(cal.getTime()));
  }
}

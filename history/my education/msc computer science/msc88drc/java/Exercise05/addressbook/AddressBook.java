package addressbook;
import java.io.*;
import java.util.*;

/**
* Constructor to create an empty AddressBook
* */
public class AddressBook
{
	private ArrayList entries;
	private ArrayList tempEntries;
	
	public AddressBook()
	{
		entries = new ArrayList();
		tempEntries = new ArrayList();
	}
	
	/**
	* Load address data from the specified file. 
	* If the specified file exists and is readable, the records are read in, 
	* and any existing records are replaced by the new records. 
	* If the load process fails for any reason, the existing records are retained.
	*
	* @param filename the name of the file to load the address data from.
	* @return the number of records successfully read in from the file
	* @throws FileFormatException if the file does not appear to be a valid 
	* address book file, or if any of the records is malformed, 
	* or if the number of records found in the body of the file is less than the 
	* number specified in the header 
	* @throws java.io.IOException if the specified file cannot be read, 
	* or if any other error occurs during reading
	**/
	public int load(String filename) throws FileFormatException, IOException
	{
		// local variable declaration
		int NoOfRecords = 0;
		Entry a;
		
		InputStream in = new FileInputStream(filename);
		BufferedReader myReader = new BufferedReader(new InputStreamReader(in));
		// reads in the title
		myReader.readLine(); 
		// reads in the number of records
		NoOfRecords = Integer.parseInt(myReader.readLine());
		
		// clear previous data stored in the temporary ArrayList
		tempEntries.clear();
		
		for (int i = 0; i < NoOfRecords; i++)
		{	
			try
			{
				// each line of address fields is loaded into separate entries
				// in the ArrayList 
				a = Entry.read(myReader);
				tempEntries.add(a);
			}
			catch (BadRecordException exception)
			{
				System.out.println("\n'" + exception.getMessage()
				+ "' individual record in address book is malformed.");
				
				// throw FileFormatException
				FileFormatException e = new FileFormatException("!!");
				throw e;
			}	
		}
		
		// only when all the records have been loaded can the entries in ArrayList
		// entries be cleared. Data can then be transfered from the temporary
		// ArrayList to the permanent ArrayList
		entries = tempEntries;
		
		// return the Number of records to the calling program
		return (NoOfRecords);
	}
	
	/**
	* Save address data into the specified file.
	* 
	* @throws java.io.IOException if an error occurs while writing the file.
	**/
	public void save(String filename) throws IOException
	{
		// local variable declaration
		String fileTitle = "Java Address Book File ";
		String noEntries = "" + entries.size();
		
		/*
			create a new instance of a new FileOutputStream, save addressbook
			entries to the filename
		*/
		OutputStream out = new FileOutputStream(filename);
		BufferedWriter myWriter = new BufferedWriter(new OutputStreamWriter(out));
		
		/* 
			save to file, the title of the file and today's date & time on the
			first line
		*/
		myWriter.write(fileTitle, 0, fileTitle.length());
		myWriter.write(getTodaysDateTime());
		
		// on a new line write the number of records to saved
		myWriter.newLine();
		myWriter.write(noEntries, 0, noEntries.length());
		myWriter.newLine();
		
		/* 
			step through the entries in the address book, and for each entry call 
			its' write() method
		*/ 
		for (int i = 0; i < entries.size(); i++)
		{
			Entry a = (Entry)entries.get(i);
			a.write(myWriter);
   }
	 
	 /* 
	 	 make sure the writer is closed, and all the information is flushed into
		 the file
	 */ 
	 myWriter.close();
	}
	
	/**
	* Add an entry into the address book.
	*
	* @param p the personal details for the entry
	* @param a the address details for the entry
	* @throws EntryExistsException if there is already an entry in the address 
	* book whose name matches that stored in p.
	**/
	public void addEntry(Person p, Address a) throws EntryExistsException
	{
		// create a new Entry instance called thisEntry
		Entry thisEntry = new Entry(p,a);
		
		// add thisEntry to the end of the ArrayList
		entries.add(thisEntry);
	}
	/**
	* Get an entry from the address book.
	*
	* @param familyName the family name of the person
	* @param givenNames the given name(s) of the person
	* @throws NoSuchEntryException if no entry can be found that matches the 
	* names supplied
	**/
	public Entry getEntry(String familyName, String givenNames) 
	throws NoSuchEntryException
	{
		// local variable declaration
		int index = 0;
	
		// search through the ArrayList elements, find entry with the given 
		// family name and given names
		do
		{
			/* 
				get each object from the ArrayList, using a cast operator, transform
				the universal object to an Entry object
			*/
			Entry thisEntry = (Entry)entries.get(index);
			/*
				Use the matchesPerson methodto test whether the entry's family name and 
				given names match those specified by the user
			*/
			if (thisEntry.matchesPerson(familyName, givenNames))
			{
				return thisEntry;
			}
			index++;
		}while(index < entries.size());
		
		/*
			if the user specified family name and given names cannot be found, 
			throw an exception
		*/ 
		if (index == entries.size())
		{
				NoSuchEntryException e = new NoSuchEntryException("Help");
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
		
		do
		{
			/* 
				get each object from the ArrayList, using a cast operator, transform
				the universal object to an Entry object.
			*/
			Entry thisEntry = (Entry)entries.get(index);
			/*
				Use the matchesPerson methodto test whether the entry's family name and 
				given names match those specified by the user
			*/
			if (thisEntry.matchesPerson(familyName, givenNames))
			{
				entries.remove(index);
			}
			index++;
		}while(index < entries.size());
		
		/*
			if the familyNames and givenNames could not be found, throw a
			NoSuchEntryException
		*/
		if (index == entries.size())
		{
			NoSuchEntryException e = new NoSuchEntryException("!!");
			throw e;
		}
	}
	
	public String getTodaysDateTime()
	{
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
			
		// saves calendar information in the format Wed Nov 13 19:48:33 GMT 2002
		String DATE_FORMAT = "EEE MMM d HH:mm:ss z yyyy.";
		java.text.SimpleDateFormat sdf = 
          new java.text.SimpleDateFormat(DATE_FORMAT);
					
		// this line of code sets the time zone manually;
		sdf.setTimeZone(TimeZone.getDefault());  
		return(sdf.format(cal.getTime()));
	}
}

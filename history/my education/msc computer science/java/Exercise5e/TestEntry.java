import addressbook.*;
import java.io.*;

/**
   program that tests each method in the Entry class to see if everything 
   behaves correctly

   @author David Clarke
**/

class TestEntry
{
    public static void main (String [] args) throws IOException
    {Person thisPerson = new Person ("Bowen", "Jim");
    Address thisAddress = new Address ("6", "Cutshill Close", 
				       "Castle Bromwich", "West Midlands", 
				       "England", "B36 9SZ");

    Entry thisEntry = new Entry(thisPerson, thisAddress);

	InputStream in = new FileInputStream("bad.abf");
	BufferedReader myReader = new BufferedReader(new InputStreamReader(in));	
	// myReader.readLine(); 

 	try
	    {
		// Call the read method from the Class Entry.
		thisEntry = Entry.read(myReader);
	    }
	catch (BadRecordException exception)
	    {
		System.out.println("\n'" + exception.getMessage()
		+ "' individual record in address book is malformed.");
	    }	
	System.out.println(thisEntry);
	
    }
}


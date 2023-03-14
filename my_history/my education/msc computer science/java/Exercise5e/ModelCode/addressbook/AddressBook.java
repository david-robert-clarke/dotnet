package addressbook;

import java.io.*;
import java.util.*;

/**
* This class stores and manipulates a set of <code>Entry</code> objects, each 
* of which contains contact details for a single person. For simplicity, 
* records are uniquely identified by the combination of a person's family name 
* and given names, so multiple records with exactly the same name are not 
* allowed.
* <p>The contents of an <code>AddressBook</code> may be read from and written 
* to a simple text file.
**/
public class AddressBook
{  
   private List records;
   
   /**
   * Constructor to create an empty <code>AddressBook</code>.
   **/
   public AddressBook()
   {
      records = new ArrayList();
   }
   
   /**
   * Load address data from the specified file. If the specified file exists 
   * and is readable, the records are read in, and any existing records are 
   * replaced by the new records. If the load process fails for any reason, 
   * the existing records are retained.
   * 
   * @param filename the name of the file to load the address data from.
   * @return the number of records successfully read in from the file
   * @exception FileFormatException if any of the following occurs: 
   *   <ul>
   *       <li>if the file does not appear to be a valid address book file</li>
   *       <li>if any of the records is malformed</li>
   *       <li>if the number of records found in the body of the file is 
   *           less than the number specified in the header</li>
   *       <li>if the file contains multiple entries with the same family 
   *           and given names</li>
   *   </ul>
   * @exception IOException if the specified file cannot be read, or if 
   *  any other error occurs during reading
   * @see Entry#read Entry.read
   **/
   public int load(String filename) 
   throws FileFormatException, IOException
   {
      // create a new temporary list to read the records into
      ArrayList newRecords = new ArrayList();
      File file = new File(filename);
      BufferedReader freader = new BufferedReader(new FileReader(file));
      
      // line counter to be used in error messages
      int lineCount = 0;
      
      try
      {
         // read header information
         String comment = freader.readLine();
         int recordCount = Integer.parseInt(freader.readLine());

         lineCount = 2;

         // read the records, if there are less than specified in the 
         // header, then Entry.read() will throw an EOFException when 
         // we try to read past the end of the file.
         for (int i = 0; i < recordCount; i++)
         {
            lineCount++;
            Entry entry = Entry.read(freader);
            Person person = entry.getPerson();
            String family = person.getFamilyName();
            String given = person.getGivenNames();
            
            if (find(newRecords, family, given) >= 0)
               throw new FileFormatException("File contains records with " + 
                     "identical name: '" + given + " " + family + "'"); 
            newRecords.add(entry);
         }
         freader.close();

      }
      catch (NumberFormatException e)
      {
         throw new FileFormatException("Invalid header information - " + 
            "File does not appear to be a valid address book file.");
      }
      catch (BadRecordException e)
      {
         throw new FileFormatException("Bad data at line " + lineCount + 
            ": " + e.getMessage());
      }
      catch (EOFException e)
      {
         throw new FileFormatException("File contains fewer records than " + 
            "indicated in header.");
      }
      
      records = newRecords;
      return records.size();
   }
   
   /**
   * Save address data into the specified file.
   * 
   * @exception IOException if an error occurs while writing the file.
   * @see Entry#write Entry.write
   **/
   public void save(String filename) throws IOException
   {
      File file = new File(filename);
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
         
      //write header information at the start of the file
      writer.write("Java Address Book File " + new Date().toString());
      writer.newLine();
      writer.write(String.valueOf(records.size())); // number of records
      writer.newLine();
      
      // write the body of the file by stepping through the entries one 
      // at a time and calling write()
      Iterator it = records.iterator();
      while (it.hasNext())
      {
         Entry nextEntry = (Entry)it.next();
         nextEntry.write(writer);
      }
      
      // flush and close the writer
      writer.close();
   }
   
   /**
   * Add an entry into the address book.
   * 
   * @param p the personal details for the entry
   * @param a the address details for the entry
   * @exception EntryExistsException if there is already an entry in 
   *  the address book whose name matches that stored in <code>p</code>.
   **/
   public void addEntry(Person p, Address a) throws EntryExistsException
   {
      String family = p.getFamilyName();
      String given = p.getGivenNames();
      
      int index = find(records, family, given);
      if (index >= 0)
         throw new EntryExistsException("An entry already exists for '" + 
            family + " " + given + "'. Multiple records with the same name " + 
            "are not allowed.");
      
      records.add(new Entry(p, a));
   }
   
   /**
   * Get an entry from the address book.
   * 
   * @param familyName the family name of the person
   * @param givenNames the given name(s) of the person
   * @exception NoSuchEntryException if no entry can be found that 
   *  matches the names supplied
   **/
   public Entry getEntry(String familyName, String givenNames) 
   throws NoSuchEntryException
   {
      int index = find(records, familyName, givenNames);
      if (index < 0)
         throw new NoSuchEntryException("No entry found for '" + 
            givenNames + " " + familyName + "'");
            
      return (Entry)records.get(index); 
   }
   
   /**
   * Remove an entry from the address book.
   * 
   * @param familyName the family name of the person
   * @param givenNames the given name(s) of the person
   * @exception NoSuchEntryException if no entry can be found that 
   *  matches the names supplied
   **/
   public void removeEntry(String familyName, String givenNames)
   throws NoSuchEntryException
   {
      int index = find(records, familyName, givenNames);
      if (index < 0)
         throw new NoSuchEntryException("No entry found for '" + 
            givenNames + " " + familyName + "'");
            
      records.remove(index);
   }
   
   /*
    private utility method to find a record in the given list that 
    matches the names supplied as parameters. Returns the index of the 
    requested entry or -1 if no matching entry is found.
    
    list is supplied as an additional parameter so that this method can 
    be used to search both the current list and the temporary list 
    used in load()
   */
   private int find(List list, String familyName, String givenNames)
   {
      for (int i = 0; i < list.size(); i++)
      {
         Entry entry = (Entry)list.get(i);
         if (entry.matchesPerson(familyName, givenNames))
            return i;
      }
      return -1;
   }
}

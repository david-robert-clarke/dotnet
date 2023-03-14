package addressbook;

import java.io.*;
import java.util.*;

/**
* A class to maintain all of the information for a single entry in an 
* <code>AddressBook</code>.
**/
public class Entry
{
   // the number of fields in an address record
   private static final int FIELD_COUNT = 12;
   
   private Person person;
   private Address address;
   
   /**
   * Constructor to create an <code>Entry</code> using the specified 
   * information.
   * 
   * @param pers the personal details for the entry.
   * @param addr the address details for the entry.
   **/
   public Entry(Person pers, Address addr)
   {
      person = pers;
      address = addr;
   }
   
   /**
   * Get the personal details associated with this <code>Entry</code>.
   * This method returns a reference to the <code>Person</code> object 
   * stored in this <code>Entry</code>, so any changes made to that 
   * object will be reflected in the entry.
   *
   * @return the <code>Person</code> object for this entry.
   **/
   public Person getPerson()
   {
      return person;
   }
   
   /**
   * Get the address details associated with this <code>Entry</code>.
   * This method returns a reference to the <code>Address</code> object 
   * stored in this <code>Entry</code>, so any changes made to that 
   * object will be reflected in the entry.
   *
   * @return the <code>Address</code> object for this entry.
   **/
   public Address getAddress()
   {
      return address;
   }
   
   /**
   * Compare the specified family and given names with those of the 
   * <code>Person</code> stored in this <code>Entry</code> to see if 
   * they are the same. The comparison is case sensitive.
   *
   * @return true if <code>familyName</code> is exactly the same as 
   *     <code>getPerson().getFamilyName()</code> AND <code>givenNames</code> 
   *     is exactly the same as <code>getPerson().getGivenNames()</code>.
   *     If there are any differences (including case) between the parameters 
   *     and the stored values, then this method will return false. 
   **/
   public boolean matchesPerson(String familyName, String givenNames)
   {
      return person.getFamilyName().equals(familyName) && 
             person.getGivenNames().equals(givenNames);
   }
   
   /**
   * Write the data for this <code>Entry</code> using the specified 
   * <code>Writer</code>. The entry is written on a single line, with 
   * fields separated by commas. A line separator is written at the end of 
   * the record.
   * <p>The data for the written entry comes from the internally stored 
   * <code>Person</code> and <code>Address</code> objects, and is written in 
   * the following order:
   * <p>family name,given names,home phone,work phone,mobile 
   * phone,e-mail,house name/number,street,town,region,country,post code
   * 
   * @param writer the <code>BufferedWriter</code> used to write the data.
   * @exception IOException if an error occurs while writing
   **/
   public void write(BufferedWriter writer) throws IOException
   {
      // build a StringBuffer containing all of the fields
      StringBuffer buff = new StringBuffer();
      buff.append(person.getFamilyName()).append(",");
      buff.append(person.getGivenNames()).append(",");
      buff.append(person.getHomePhone()).append(",");
      buff.append(person.getWorkPhone()).append(",");
      buff.append(person.getMobilePhone()).append(",");
      buff.append(person.getEMail()).append(",");
      buff.append(address.getHouse()).append(",");
      buff.append(address.getStreet()).append(",");
      buff.append(address.getTown()).append(",");
      buff.append(address.getRegion()).append(",");
      buff.append(address.getCountry()).append(",");
      buff.append(address.getPostCode());
      
      // write the information, followed by a line separator
      writer.write(buff.toString());
      writer.newLine();
   }
   
   /**
   * Create a new <code>Entry</code> object by reading a record from the 
   * specified <code>Reader</code>, and parsing it into the constituent fields.
   *
   * @param reader the <code>BufferedReader</code> from which to read the data.
   * @return an <code>Entry</code> object created from the next complete 
   *     record available from the reader.
   * 
   * @exception BadRecordException if the record contains too few or too many 
   *     fields.
   * @exception EOFException if the reader has no more data to read.
   * @exception IOException if any other i/o error occurs during reading.
   * 
   * @see #write
   **/
   public static Entry read(BufferedReader reader) 
   throws BadRecordException, IOException
   {
      /*
       Note: As of Java 1.4 the majority of this method could be replaced 
       by the statement:
         String[] fields = record.split(",", -1);
      */
      
      String record = reader.readLine();
      // readLine will return null if the end of the file has been 
      // reached
      if (record == null)
         throw new EOFException("Unexpected end of file.");

      String[] fields = new String[FIELD_COUNT];
      int fieldStart = 0;
      int fieldEnd;
      
      // there should be FIELD_COUNT - 1 commas in the record      
      for (int i = 0; i < fields.length - 1; i++)
      {
         // find next comma or throw exception if there isn't one
         fieldEnd = record.indexOf(',', fieldStart);
         if (fieldEnd < 0)
            throw new BadRecordException("Record contained too few fields");
            
         // store field substring in the array
         fields[i] = record.substring(fieldStart, fieldEnd);
         
         // move start index to beginning of next field
         fieldStart = fieldEnd + 1;
      }
      // the rest of the record should be the last field
      fields[FIELD_COUNT - 1] = record.substring(fieldStart);
      
      // check for extra fields and throw exception
      if (record.indexOf(',', fieldStart) > 0)
         throw new BadRecordException("Record contained too many fields");
         

      // build and return the Entry
      Person pers = new Person(fields[0], fields[1], fields[2], 
                               fields[3], fields[4], fields[5]);
      Address addr = new Address(fields[6], fields[7], fields[8], 
                                 fields[9], fields[10], fields[11]);

      return new Entry(pers, addr);
      
   }
   
   /**
   * Get a string representation of this <code>Entry</code>.
   *
   * @return a multi-line string containing all of the entry details.
   **/
   public String toString()
   {
      return person.toString() + "\n" + address.toString();
   }
}

import addressbook.*;
import java.io.*;

public class AddressBookReader
{
   private BufferedReader reader;
   private AddressBook addressBook;
   
   public AddressBookReader()
   {
      addressBook = new AddressBook();
      reader = new BufferedReader(new InputStreamReader(System.in));
      
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
         System.out.print("\n  a - Add New Entry\n  r - Remove Entry" + 
            "\n  e - Edit Entry\n  f - Find Entry\n  l - Load Address Book" + 
            "\n  s - Save Address Book\n  q - Quit\n\n" + 
            "Please choose an option: ");
            
         try
         {
            choice = (char)reader.read(); 
            reader.readLine();
            
            switch (choice)
            {
               case 'a':
               case 'A':   add();
                           break;
               case 'r':
               case 'R':   remove();
                           break;
               case 'e':
               case 'E':   edit();
                           break;
               case 'f':
               case 'F':   find();
                           break;
               case 'l':
               case 'L':   load();
                           break;
                           
               case 's': 
               case 'S':   save();
                           break;
                           
               case 'Q':
               case 'q':   break;
               
               default :   System.out.println("\nUnrecognised option.");
            }
         }
         catch (NoSuchEntryException e)
         {
            System.err.println("\n" + e.getMessage());
         }
         catch (EntryExistsException e)
         {
            System.err.println("\n" + e.getMessage());
         }
         catch (FileFormatException e)
         {
            System.err.println("\nFile format error: " + e.getMessage());
         }
         catch (FileNotFoundException e)
         {
            System.err.println("\nUnable to find the specified file: " + 
                  e.getMessage());
         }
         catch (IOException e)
         {
            System.err.println("\n" + e.getMessage());
         }
         
      } while (choice != 'q' && choice != 'Q');  
   }
   
   /*
    Request family name and given name from the user, and attempt to 
    retrieve matching record from the AddressBook.
    All exceptions are thrown on to caller.
   */
   private void find() throws NoSuchEntryException, IOException
   {
      String familyName = readInput("Please enter the person's family name: ");
      String givenNames = readInput("Please enter the person's given names: ");
      
      Entry entry = addressBook.getEntry(familyName, givenNames);
      System.out.println("\n" + entry);
   }
   
   /*
    Request family name and given name from the user. Check whether there 
    is already a record with the same name. If not, request other details 
    from user and attempt to add the new record to the AddressBook.
    All exceptions are thrown on to caller.
   */
   private void add() throws EntryExistsException, IOException
   {
      String family = readInput("Please enter the person's family name: ");
      String given = readInput("Please enter the person's given names: ");
      
      try
      {
         Entry entry = addressBook.getEntry(family, given);
         throw new EntryExistsException("An entry already exists for '" + 
            family + " " + given + "'. Multiple records with the same name " + 
            "are not allowed.");
      }
      // ignore exception because it means the record doesn't already 
      // exist, which is what we want.
      catch (NoSuchEntryException e) { }
      
      String homePhone = readInput("Please enter their home phone number: ");
      String workPhone = readInput("Please enter their work phone number: ");
      String mobilePhone = 
         readInput("Please enter their mobile phone number: ");
      String mail = readInput("Please enter their email address: ");
      
      String house = readInput("Please enter their house name or number: ");      
      String street = readInput("Please enter their street name: ");      
      String town = readInput("Please enter their town: ");      
      String region = readInput("Please enter their region: ");      
      String country = readInput("Please enter their country: ");      
      String code = readInput("Please enter their postcode: ");
      
      Person p = new Person(family, given, homePhone, workPhone, 
                            mobilePhone, mail);
      Address a = new Address(house, street, town, region, country, code);
      
      addressBook.addEntry(p, a);
      
      System.out.println("\n" + given + " " + family + 
                         " added to address book.");
   }
   
   /*
    Request family name and given name from the user, and attempt to 
    remove matching record from the AddressBook.
    All exceptions are thrown on to caller.
   */
   private void remove() throws NoSuchEntryException, IOException
   {
      String family = readInput("Please enter the person's family name: ");
      String given = readInput("Please enter the person's given names: ");
      
      addressBook.removeEntry(family, given);
      
      System.out.println("\n" + given + " " + family + 
                         " removed from address book.");
   }
   
   /*
    Request family name and given name from the user, and attempt to 
    retrieve matching record from the AddressBook. Step through the 
    fields in the record, allowing the user to change each one or leave 
    it unchanged.
    All exceptions are thrown on to caller.
   */
   private void edit() 
   throws EntryExistsException, NoSuchEntryException, IOException
   {
      String family = readInput("Please enter the person's family name: ");
      String given = readInput("Please enter the person's given names: ");
      
      Entry currentEntry = addressBook.getEntry(family, given);
      Person person = currentEntry.getPerson();
      Address address = currentEntry.getAddress();
      
      String newFamily = editValue("family name", family);
      String newGiven = editValue("given name", given);
         
      try
      {
         if (!(newFamily.equals(family)) || !(newGiven.equals(given)))
         {
            Entry entry = addressBook.getEntry(newFamily, newGiven);
            throw new EntryExistsException("An entry already exists for '" + 
               family + " " + given + "'. Multiple records with the same name " + 
               "are not allowed.");
         }
      }
      // ignore exception because it means the record doesn't already 
      // exist, which is what we want.
      catch (NoSuchEntryException e) { }
      
      person.setFamilyName(newFamily);
      person.setGivenNames(newGiven);
      
      String input = editValue("home phone number", person.getHomePhone());
      person.setHomePhone(input);
      input = editValue("work phone number", person.getWorkPhone());
      person.setWorkPhone(input);
      input = editValue("mobile phone number", person.getMobilePhone());
      person.setMobilePhone(input);
      input = editValue("email address", person.getEMail());
      person.setEMail(input);
      input = editValue("house name or number", address.getHouse());
      address.setHouse(input);
      input = editValue("street", address.getStreet());
      address.setStreet(input);
      input = editValue("town", address.getTown());
      address.setTown(input);
      input = editValue("region", address.getRegion());
      address.setRegion(input);
      input = editValue("country", address.getCountry());
      address.setCountry(input);
      input = editValue("postcode", address.getPostCode());
      address.setPostCode(input);
   }
   
   /*
    Load an address book file specified by the user.
   */
   private void load()
   throws FileFormatException, EOFException, IOException
   {
      String fname = readInput("Please enter the filename: ");
      int recordCount = addressBook.load(fname);
      if (recordCount == 1)
         System.out.println("\n" + recordCount + 
                            " record read in from " + fname);
      else
         System.out.println("\n" + recordCount + 
                            " records read in from " + fname);
   }
   
   /*
    Save the current address book to a file specified by the user.
   */ 
   private void save() throws IOException
   {
      String fname = readInput("Please enter the filename: ");
      addressBook.save(fname);
      System.out.println("\nAddress book contents saved to " + fname);
   }
   
   /*
    Helper method to prompt the user for input, and return their 
    response as a String.
   */
   private String readInput(String question) throws IOException
   {
      System.out.print(question);
      return reader.readLine();
   }
   
   /*
    Helper method to prompt the user for a new value for a field in a 
    record. Returns the new value, or the existing one if the user 
    enters nothing.
   */
   private String editValue(String field, String current) throws IOException
   {
      System.out.print("Current " + field + ": " + current + 
         "\nEnter new " + field + " (or press RETURN to leave unchanged): ");
      String newValue = reader.readLine();
      if (newValue.length() > 0)
         return newValue;
      
      return current;
   }
   
   /*
    Main method just creates a new AddressBookReader instance.
   */
   public static void main(String[] args)
   {
      AddressBookReader abr = new AddressBookReader();
   }
}

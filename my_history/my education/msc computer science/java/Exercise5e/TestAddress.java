import addressbook.*;

/**
   program that tests each method in the Address class to see if everything 
   behaves correctly

   @author David Clarke
**/

class TestAddress
{
    public static void main (String [] args)
    {
	Address  a = new Address
	    ("1", "Mangrow Close", "Castle Swampwich", "West DeadLands", 
	     "England", "B3F 8TY");

	System.out.println(a.toString());

    }
}


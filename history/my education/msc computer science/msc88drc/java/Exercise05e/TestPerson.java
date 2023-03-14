import addressbook.*;

/**
   program that tests each method in the Person class to see if everything 
   behaves correctly

   @author David Clarke
**/

class TestPerson
{
    public static void main (String [] args)
    {
	Person a = new Person
	    ("McMann", "Steve", 
	     "605 5859", "225 5087", 
	     "0782 698 2255", 
	     " steve_McMann@mail.com");
	// Uses the second constructor

	System.out.print(a.toString());
    }
}


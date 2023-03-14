import java.io.*;

public class Count
{	public static void main (String[] args) throws IOException
	{
		/*read characters from standard input one at a time
		  and increment counter, until user hits return*/
		int count = 0;	
		System.out.print("Type anything (Press RETURN when finished): ");
		while ((char)System.in.read() != '\n')
		{	count++;
		}	
		// print summary message
		System.out.println("Input has " + count + " characters.");
		
		
	}
}

		

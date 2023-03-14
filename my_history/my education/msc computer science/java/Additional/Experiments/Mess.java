import java.io.*;

class Mess
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		// read in a line from a specified file
		System.out.print("Name: ");
		
		// 
		int noOfCommas = 0;
		String field = "";
		String line = reader.readLine();
		int lineLength = line.length();
		char[] lineArray = new char[100];
		line.getChars(0, lineLength, lineArray, 0);
		
		// initialise Strings here, say and they before they are used
		String here = "";
		String say = "";
		String they = "";
		
		// sort the line into separate fields until all the characters have been
		// analysed
		for (int n = 0; n != lineLength; n++)
		{
			// if the array item is a comma then add 1 to the number of commas
			if (lineArray[n] == ',')
			{
				noOfCommas += 1;
				
				// if the number of commas equals then goto the corresponding
				// switch statement
				switch (noOfCommas)
				{
					case 1: here = field;
						break;
					case 2: say = field;
						break;
					default : they = "";
						break;
				}
				// delete all the characters from the string, ready for the next field
				// to be analysed
				field = "";
			}
			else
			{
				// add the character taken from the array, and append it 
				// to the string field
				field += lineArray[n];
			}
		}
		// when  
		System.out.println(here);
		System.out.println(say);
	}
}

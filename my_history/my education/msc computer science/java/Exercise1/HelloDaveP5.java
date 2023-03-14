import java.io.*;

class HelloDaveP5
{	public static void main (String [] args) throws IOException
	{	System.out.print("Please enter your name: ");
		String name;
		
			BufferedReader reader = 
				new BufferedReader (new InputStreamReader(System.in));
		
			name = reader.readLine();
		
			System.out.print("Please enter number of iterations: ");
		
			String numberAsString = reader.readLine();
			int number = Integer.parseInt(numberAsString);
		
		for (int i = 0; i < number; i++)
		{
			for (int j = 0; j < i; j++)
			{	System.out.print(" ");
			}
			System.out.println("Hello " + name + "!");
		}
	}
}


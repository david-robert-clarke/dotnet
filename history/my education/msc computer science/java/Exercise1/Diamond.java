import java.io.*;

class Diamond
{	
	public static void main(String[] args) throws IOException

	{		
		System.out.print("Please enter the width/height of the diamond: ");
			BufferedReader reader =
				new BufferedReader(new InputStreamReader (System.in));
		
		int size = Integer.parseInt(reader.readLine());
		int spacing;
		int remain = size%2;
		int starinit;
		int i = 0;
		int j = 0;
		int temp;
		String star = "*";
		String space = " ";  
  
  
    		if (remain == 0) 	//the width of the diamond is an even number 
		{
			spacing = (size/2) - 1;
			starinit = 2;
		}
  
  			else 			//the width of the diamond is an odd number              
			{
				spacing = ((size + 1)/2) - 1;
				starinit = 1;
			}
  
  		// Prints out the upper half of the diamond
		for (i = starinit; i <= size;)	
		{
			// Creates number of spaces before the stars for top half of diamond
			for (temp = spacing; temp > 0; temp--)
			{	
				System.out.print(space);
			}
				// Creates a number of stars on each line for top half of diamond
				for (j = 0; j < i; j++)
				{
					System.out.print(star);
				}
					
			spacing = spacing - 1;
			System.out.println();
			i = i + 2;
		}
		
		spacing = spacing + 2; //value of spacing has dropped to -1, needs to be 1
		
		i = i - 2; 	/*the loop condition value needs to be 2 less, in order to get the
				  correct diamond structure*/
		
		while (i > 0)
		{	
			i = i - 2;	
			// Print out spaces for the bottom half of the diamond
			for (temp = 0; temp <= spacing; temp++)
			{	
				if (temp > 0)
				System.out.print(space);
					
			}
				// Creates the star output on each line for the bottom half of diamond
				for (j = 0; j < i; j++)
				{
					System.out.print(star);
				}
				
			spacing = spacing + 1;
			System.out.println();
		}	
	}
}						

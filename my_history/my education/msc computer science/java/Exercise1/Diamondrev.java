// Program that prints a Diamond of any size
// David Clarke
// 10/2002 

import java.io.*;

class Diamondrev
{	
	public static void main(String[] args) throws IOException

	{		
	System.out.print("Please enter the width/height of the diamond: ");
	BufferedReader reader =
			new BufferedReader(new InputStreamReader (System.in));
	
		
	int size = Integer.parseInt(reader.readLine());
	int nspaces;
	int nstars;
	int lineno;
	int temp;
	int terminate = 0;
	String star = "*";
	String space = " ";  
	
	int rem = size%2; /*the diamond size is even if remainder is equal to zero
			    else it is an odd size*/
  
    	if (rem == 0) 	//the width of the diamond is an even number 
		{
		terminate = (size/2) - 1;
		nstars = 2;
		}
	else 		//the width of the diamond is an odd number              
		{
		terminate = ((size + 1)/2) - 1;
		nstars = 1;
		}
	
	lineno = terminate * -1;
				
	while (lineno <= terminate)	//repeat outputting lines of stars until the the last line has been reached
		{
		for (nspaces = Math.abs(lineno); nspaces > 0; nspaces--)	//print the leading spaces before each line of stars
			{							//the number of spaces is equal to the magnitude of 
			System.out.print(space);				//the line number
			}
			
		for (temp = nstars; temp > 0; temp--)				//print each line of stars 
			{
			System.out.print(star);
			}
		
		System.out.println();	//print a new line
		
		if (lineno >= 0)	//the number of stars is symmetrical about line number zero
			{
			nstars = nstars - 2;
			}
		else
			{
			nstars = nstars + 2;
			}
		
		lineno = lineno + 1;	//move to the next line
  		}
	}
}						

//hexstand.java
//Print a representation of the Hexagon to the standard output
//David Clarke
//17_10_2002

import java.io.*;

public class hexstand
{
		public static void main (String[] args) throws IOException
		{
				System.out.print ("Please type in the size of the Hexagon you want:- ");
				BufferedReader reader = 
												new BufferedReader (new InputStreamReader (System.in));
				int size = Integer.parseInt(reader.readLine());;
				int lineno = -1 *(size - 1);
				int nstars = size;
				String background = "*";
				String foreground = " ";
				
				//Loop prints out one line of the hexagon at a time
				while (lineno <= size)
				{
						// needs to be updated in the loop
						int nspaces = Math.abs(lineno);
						
						//This Loop prints out the number of spaces to the left of the hexagon
						for (int i = nspaces; i > 0; i--)
						{ System.out.print(background);
						}
					
							//This loop prints out the number of stars on each line
							for (int j = nstars;j > 0; j--)
							{ System.out.print(foreground);
							}
							
								//This Loop prints out the number of spaces to the right of the hexagon
								for (int k = nspaces; k > 0; k--)
								{ System.out.print(background);
								}
				
						//This statement increments or decrements nstars dependant on
						//the line number
						if (lineno < 0)
						{ nstars = nstars + 2;
						}
							else 
							{ nstars = nstars - 2;
							}
						//Move to the start of the next line, increment lineno
						System.out.println();
						lineno = lineno + 1;
				}	
		}
}
	
 



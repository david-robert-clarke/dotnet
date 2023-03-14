//hexstand.java
//Print a representation of the Hexagon to the standard output
//David Clarke
//17_10_2002

import java.io.*;

public class HexOutline
{
		public static void main (String[] args) throws IOException
		{
				System.out.print ("Please type in the size of the Hexagon you want:- ");
				BufferedReader reader =
				  new BufferedReader (new InputStreamReader (System.in));
				int size = Integer.parseInt(reader.readLine());;
				int width = (3 * size);
        int lineno = -1 *(size - 1);
				int nstars = size;
				String background = " ";
				String foreground = " ";
				String outline = "O";
				
				//Print the top line of the hexagon
        for (int a = width; a > 0; a--)
        {
				System.out.print(background);
        }
				System.out.println();

				//Loop prints out one line of the hexagon at a time
				while (lineno < size)
				{
						// needs to be updated in the loop
						int nspaces = (Math.abs(lineno) + 1);
						
						//This Loop prints out the number of spaces to the left of the hexagon
						for (int i = nspaces; i > 0; i--)
						
						{ System.out.print(background);
						}
					
							//This loop prints out the number of stars on each line
							for (int j = nstars;j > 0; j--)
							{ 	//if the first or last line line print the outline 
									 	if (lineno == (-1 *(size - 1)) || (lineno == size - 1))
										{	System.out.print(outline);
										}
									
												//elsif it is the start or end of that line print the outline
												else if (j == nstars || j == 1)
												{ System.out.print(outline);
												}
										
														//else print the foreground, which in this method is spaces
														else
														{ System.out.print(foreground);
														}
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
			
				//Print the bottom line of the hexagon
                                for (int z = width; z > 0; z--)
                                {
				  System.out.print(background);
                                }
				System.out.println();
		}
}
	
 



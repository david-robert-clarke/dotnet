/**
* A class to represent Hexagons, which can be printed on a simple character 
* display. A hexagon has a size, and two char values, 
* which are used to print the background and foreground of the figure.
**/
public class Hexagon
{
private int size;
private char background,foreground;

		/**
		* Default constructor to create a Hexagon of size 5, with ' ' as the 
		* background character, and '*' as the foreground character.
		**/
 		Hexagon()
		{
			size = 5;
			background = ' ';
			foreground = '*';
		}

		/**
		* Constructor to create a Hexagon with the specified values.
		*
		* @param s the size of the Hexagon.
		* @param back the character to be used for printing the background.
		* @param fore the character to be used for printing the foreground.
		**/
		Hexagon(int s, char back, char fore)
		{
			size = s;
			background = back;
			foreground = fore;
		}

		/**
		* Set the character to be used for printing the background of the Hexagon.
		* 
		* @param back the background character
		**/
		void setBackground(char back)
		{
				background = back;
		}

		/**
		* Set the character to be used for printing the foreground of the Hexagon.
		* 
		* @param fore the foreground character
		**/
		void setForeground(char fore)
		{
		  foreground = fore;                     
		}	

		/**
		* Set the size of the Hexagon.
		*
		* @param s the new size for the Hexagon
		**/
		void setSize(int s)
		{
		  size = s;
		}

		/**
		* Get the character used for printing the background of the Hexagon.
		*
		* @return the char used for the Hexagon's background.
		**/
		char getBackground()
		{
		  return background;
		}

		/**
		* Get the character used for printing the foreground of the Hexagon.
		*
		* @return the char used for the Hexagon's foreground.
		**/
		char getForeground()
		{
		  return foreground;
		}

		/**
		* Get the current size of the Hexagon.
		*
		* @return the size of the Hexagon as an int.
		**/
		int getSize()
		{
		  return size;
		}

		/**
		* Print a representation of the Hexagon to the standard output 
		* (System.out).
		**/
		void print()
		{
		  	  //System.out.print ("Please type in the size of the Hexagon you want:- ");
 
                                int width = (3 * size);
                                int lineno = -1 *(size - 1);
				int nstars = size;
				
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
			
				//Print the bottom line of the hexagon
                                for (int z = width; z > 0; z--)
                                {
				  System.out.print(background);
                                }
				System.out.println();
				}
  
							
						
		/**
		* Print an inverse representation of the Hexagon to the standard 
		* output - i.e. the background character is used in place of the foreground 
		* character and vice-versa.
		**/
		void printInverse()
		{
		  char y = foreground;
		  foreground = background;
		  background = y;
		  print();
		  
		}

		/**
		* Print an outline representation of the Hexagon to the standard output. 
		**/
		void printOutline()
		{ 
				int width = (3 * size);
        int lineno = -1 *(size - 1);
				int nstars = size;
				char outline = 'O';
				
				//the foreground and backgound characters are initialised to spaces
				foreground = ' ';
				background = ' ';
				
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
				{ System.out.print(background);
				}
				System.out.println();
		}	
}

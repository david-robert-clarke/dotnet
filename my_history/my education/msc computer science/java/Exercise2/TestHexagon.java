//TestHexagon2.java
//A program that tests the Hexagon.java methods
//David Clarke
//21_10_2002

import java.io.*;

class TestHexagon
{
    public static void main(String[] arguments) throws IOException
    {		Hexagon myHexagon = new Hexagon();
    Hexagon yourHexagon = new Hexagon();
    int option = -1;
    int a;			//a & b are temporary storage to be passed to
    char b;			//the set methods 

    //Print a standard hexagon to the screen
    System.out.println();
    yourHexagon.print();
    System.out.println();
				
    do
        {		BufferedReader reader = 
		    new BufferedReader (new InputStreamReader(System.in));	
        BufferedReader reader2 = 
            new BufferedReader (new InputStreamReader(System.in));
        BufferedReader reader3 = 
            new BufferedReader (new InputStreamReader(System.in));
								
        //Print to screen the size, foreground and size parameters used by the hexagon.
        System.out.print("Size: ");
        System.out.println(yourHexagon.getSize());
        System.out.print("Background: ");
        System.out.println(yourHexagon.getBackground());
        System.out.print("Foreground: ");
        System.out.println(yourHexagon.getForeground());
        System.out.println();
						
        //Ask the user how they would like to manipulate the hexagon
        System.out.print("Would you like to Change current hexagon or Quit (c=change, q=quit)? ");
        b = (char)reader3.read();
        System.out.println();
							
        if (b == 'c')
            {	  System.out.println ("**Please enter the number corresponding to the appropriate option**");
            System.out.println();
            System.out.println ("1.	Swap foreground and background characters of the current hexagon");
            System.out.println ("2.	Print the outline of the current hexagon");
            System.out.println ("3.	Change the size of the current hexagon");
            System.out.println ("4.	Change the background characters of the current hexagon");
            System.out.println ("5.	Change the foreground characters of the current hexagon");
            System.out.println ("6.	Use the default hexagon");
            System.out.println ("7.	Quit");
            System.out.println ();
            System.out.print ("Option-> ");
            a = Integer.parseInt(reader.readLine());
									
            System.out.println ();
            if (a == 1)
	{yourHexagon.printInverse();	
	}
            else if (a == 2)
	{	char fg = yourHexagon.getForeground();
	char bg = yourHexagon.getBackground();
	if (bg != ' ' || fg != ' ')
	    { yourHexagon.printOutline();
	    }
	else 
	    {System.out.println();
	    System.out.println("//Rundll error");
	    System.out.println("**Please choose the default hexagon (option 6)!!**");
	    }
	}
            else if (a == 3)
	{//Ask for the side length of the hexagon they would like
	    int n = -1;
	    do
	        {try
	            {System.out.print("Please enter the size of the hexagon (0 ->12): ");
	            n = Integer.parseInt(reader.readLine());
	            yourHexagon.setSize(n);	
	            }
	        catch (NumberFormatException e1)
	            {System.out.println("Input could not be parsed as an integer.");
	            }
	        }while(n < 0 || n > 12);
	    yourHexagon.print();
	}
															
            else if (a == 4)
	{//Ask for the background character
	    System.out.print("Please specify a background character for your hexagon: ");
	    b = (char)reader.read();
	    yourHexagon.setBackground(b);
	    yourHexagon.print();
	}
            else if (a == 5)
	{//Ask for the foreground character
	    System.out.print("Please specify a foreground character for your hexagon: ");
	    b = (char)reader2.read();
	    yourHexagon.setForeground(b);
	    yourHexagon.print();
	}
													
            else if (a == 6)
	{		yourHexagon = myHexagon;
	yourHexagon.print();
	}
            else if (a == 7)
	{option = 7;
	}
            }
							
        else
            {option = 7; //exit the loop
            }
        System.out.println();
												
        }while (option != 7); //when option 7 is chosen then exit the loop, finish program
    }
}


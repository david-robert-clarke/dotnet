import java.util.*;
import java.util.Random;
import java.io.*;

public class TestFile
{	public static void main(String[] args) throws IOException
	{	
		Random generator = new Random(); // the random generator 
		int x0 = -1; 				// The threshold function used as an input 
		int[] xn  = new int[100]; 	// Input (Coll_Bin)
		int[] targ = new int[100]; 	// Target Output (Bin_Diag)
		int[] y	= new int[100];		// Actual Output
		double w0 = generator.nextDouble();			// Initial (random) synaptic weight for the threshold input
		double w1 = generator.nextDouble(); 			// Initial (random) weight >0<1
		final double n = 0.1; 		// constant Learning rate >0<1 
		double a;					// activation
		
		BufferedReader myReader = 
			new BufferedReader( new FileReader( new File( "Coll_Bin.csv" ) ) );
		
		//for loop that gets the input and target data and places it into 2 separate arrays 
		for (int lineNo=0; lineNo < 100; lineNo++)
		{
			String line = myReader.readLine(); 								//Read a line of data at a time
			StringTokenizer myTokenizer = new StringTokenizer(line, ","); 	//Initialise tokenizer, read information on next line
			int numTokens=myTokenizer.countTokens(); 						//Counts the number of tokens (ints) on each line
			
			for (int i = 0; i < numTokens; i++)
			{
				if (i == 0)													//If it's the first data object, store in the Input array
				{
					xn[lineNo] = Integer.parseInt(myTokenizer.nextToken()); 
				}
				
				else 														//Else (if it's the second data object) store in the Target Output array
				{
					targ[lineNo] = Integer.parseInt(myTokenizer.nextToken());
				}
			}
		}	
		
		int passes = 0;
		//do loop while the number of passes is less than 1000
		do
		{
			for (int lineNo=0; lineNo < 100; lineNo++)
			{
				//Calculate the activation
				a = (w0 * x0) + (w1 * xn[lineNo]);
			
				if (a < 0) 						//If the activation (a) is less than 0 (the threshold) 
				{								//then Actual Output (y) becomes 0 else (y) becomes 1
					y[lineNo] = 0;
				}
				else
				{
					y[lineNo] = 1;
				}
			
				if (y[lineNo] != targ[lineNo])	//If the Actual Output doesnot equal the Target Output
				{								//then calculate the new weights
					double nw0;
					double nw1;
					
					nw0= w0 + (n * (targ[lineNo] - y[lineNo]) * x0);
					w0=nw0; //New weights become current weights
					//System.out.print(w0 + " ");
					
					nw1= w1 + (n * (targ[lineNo] - y[lineNo]) * xn[lineNo]);
					w1=nw1; //New weights become current weights	
					//System.out.println(w1);
				}
			}
			passes += 1;
		}while (passes < 1000);
		System.out.println("\n\nw0 = " + w0 + ".");
		System.out.println("w1 = " + w1 + ".");	
	}
}

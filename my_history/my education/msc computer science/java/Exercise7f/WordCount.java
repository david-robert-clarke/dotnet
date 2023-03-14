import word.*;
import java.io.*;
import java.util.*;

class WordCount
{
    private WordBook myWordBook;
    
    public WordCount (String filename, String order) throws IOException
    {
      
        myWordBook = new WordBook();
        try
            {
	myWordBook.load(filename);

	int noOfWords = myWordBook.getWordList().size();
	boolean error = false;
      
	// sort by words in ascending order
	if (order.equals("-wa"))
	    {
	        myWordBook.alphaSort();
	        myWordBook.countNRemove();
	    }

	// sort by words in descending order
	else if (order.equals("-wd"))
	    {
	        myWordBook.alphaSort();
	        myWordBook.countNRemove();
	        myWordBook.descend();
	    }

	// sort by number of occurences in ascending order
	else if (order.equals("-na"))
	    {
	        myWordBook.alphaSort();
	        myWordBook.countNRemove();
	        myWordBook.freqSort();
	    }

	// sort by number of occurences in descending order
	else if (order.equals("-nd"))
	    {
	        myWordBook.alphaSort();
	        myWordBook.countNRemove();
	        myWordBook.freqSort();
	        myWordBook.descend();
	    }

	// if no sorting method has been entered, default to  -wa
	else if (order.equals(""))
	    {
	        myWordBook.alphaSort();
	        myWordBook.countNRemove();
	    }
	       
	else
	    {
	        System.out.println("Invalid Switch Command.");
	        System.out.println("Aborting...");
	        error = true;
	
	    }
      	
	if (error != true)
	    {
	
	        // Print out results to the command line
	        for (int i=0; i < myWordBook.getWordList().size(); i++)
	            {
		Word w = (Word)myWordBook.getWordList().get(i);
		int l = w.getWord().length();
		int noOfTabs = 0;
	  
		if (l <= 7)
		    {
		        noOfTabs = 3;
		    }	          
		else if (l <= 15)
		    {
		        noOfTabs = 2;
		    }
		else if (l <= 23)
		    {
		        noOfTabs = 1;
		    }
		else 
		    {
		        noOfTabs = 0;
		    }
	  
		System.out.print(w.getWord());
		     
		for(int j=0; j <= noOfTabs; j++)
		    {
		        System.out.print("\t"); 
		    }
		System.out.println(w.getFreq());
	            }
	        System.out.println("Total words:" + "\t\t\t" + noOfWords);
	    }
            }

        catch (FileNotFoundException exception)
            {
	System.out.println("'" + exception.getMessage());
            }      

    }
  
    public static void main (String[] args) throws IOException
    {
        if (args.length == 1)
            {
	String order = "";
	String filename = args[0];
	new WordCount(filename, order);
            }

        else if (args.length == 2)
            {
	String order = args[0];
	String filename = args[1];
	new WordCount(filename, order);
            } 
        else
            {
	System.out.println ("You must specify a file to process!");
            }
    
    }
  
}


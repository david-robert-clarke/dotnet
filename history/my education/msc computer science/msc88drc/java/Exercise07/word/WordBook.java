package word;
import java.io.*;
import java.util.*;

/**
 * This class stores and manipulates a set of Word objects, each
 * of which contains words and their frequency.
 *
 * The contents of the WordBook may read only from an English text
 * file
 **/
public class WordBook
{
    private ArrayList wordList;
    private ArrayList copy;

    /**
     * Constructor to create an Empty Wordbook
     **/
    public WordBook()
    {
        wordList = new ArrayList();
        copy = new ArrayList();
    }

    /**
     * Loads data from the specified file, words are all saved in lower case
     **/
    public void load(String filename) throws IOException
    {
        // Initialise local variables
        String line = "";
        int numChars = 0;
        char thisChar;
        int charVal = 0;
        String thisWord = "";
        int wordLength = 0;
        int wLIndex = 0;
        
        // Create a new instance of the BufferedReader myReader
        InputStream in = new FileInputStream(filename);
       BufferedReader myReader = new BufferedReader(new InputStreamReader(in));
       
       do
            {
	// read in a line from file, store as a String
	line = myReader.readLine();
	int offset = 0;

	// if it is not the last line
	if (line != null)
	    {
	        numChars = line.length();
	        //Words
	        for (int i=0; i < numChars; i++)
	            {
		// look at the (i)th letter of the String
		thisChar = line.charAt(offset);
		charVal = (int)thisChar;

		//what is the length of this Word
		wordLength = thisWord.length();
		
		if (Character.isLetterOrDigit(thisChar) ||
		    charVal == 39 || charVal == 45)
		    {
		        thisWord += thisChar;
		    }

		else if (wordLength > 0)
		    {
		        
		        Word wordle = 
		            new Word(thisWord.toLowerCase(), 1);
		        wordList.add(wLIndex, wordle);
		        copy.add(wLIndex, wordle);
		        wLIndex++;
		        
		        // initialise thisWord
		        thisWord = "";
		    }

		offset += 1;      
	            }
	    }
            }
        while (line != null); //when this condition is false, the loop is exited
        
        // if the final word does not have a delimiter after it, it will not be 
        // counted at present
        /*
          if (wordLength > 1)
          { 
          Word wordle2 = new Word(thisWord, 1);
          wordList.add(wLIndex, wordle2);

          // initialise thisWord
          thisWord = "";
          }
        */

       System.out.println("Loaded");
    }

    /**
     * Sorts the data into alphabetical order, word comparisons are not case
     * sensitive
     **/
    public void bubbleSort()
    {
        int n = wordList.size();
        int sorted;

        do 
            {
	sorted = 0;
	for (int i=0; i < (n-1); i++)
	    {
	        int j = (i+1);
	        Word ith = (Word)wordList.get(i);
	        String first = ith.getWord();
	        Word jth = (Word)copy.get(j);
	        String second = jth.getWord();
	        int result = second.compareTo(first);
	        Word temp = new Word ("", 0); 

	        // if the jth word comes before the jth + 1 word then 
	        if (result < 0)
	            {
		// swap array[j] with array[j+1]
		temp = ith;
		wordList.set(i,jth);
		wordList.set(j,temp);
		sorted += 1; 
	            }
	    }
	
	// copy contents of Array wordList into ArrayList copy
	for (int k=0; k < wordList.size(); k++)
	    {
	        Word thisWord = (Word)wordList.get(k);
	        copy.set(k, thisWord);
	    }	
	
            }while(sorted != 0);
        
        
        System.out.println("Sorted");
    }

    /**
     * Obtains the sorted list, calculates the number of times each word 
     * in the data file occurs. Removes duplicated words.
     **/
    public void count ()
    {
        // create a new ArrayList called tempList that holds the 
        // the same values as wordList
        int pointer = 0;
        String theWord = "";
        String nextWord = "";
        boolean wordsSame = false;
        int changes = 0;
        int listSize = wordList.size();    

        do 
            {
	Word now = (Word)(wordList.get(pointer));
	Word next = (Word)(copy.get(pointer + 1));
	theWord = now.getWord();
	nextWord = next.getWord();
	wordsSame = theWord.equals(nextWord);
	
	if(wordsSame)// word exists then
	    {
	        // delete repeated instances
	        wordList.remove(pointer + 1);
	        copy.remove(pointer + 1);

	        // add 1 to the word frequency
	        int freq =  now.getFreq() + 1; 
	        now.setFreq(freq);

	        // subtract 1 from the ArraySize
	        listSize -= 1;
	    }
	else
	    {
	        // add 1 to the pointer position and 
	        // add 1 to no of change made to arra
	        pointer += 1;
	        //changes += 1;
	    }  
	//System.out.println(wordList.size() + "\t" + copy.size());
	//System.out.println(changes + "\t" + listSize);
            } while (pointer != (listSize - 1));   
        
          for (int j=0; j < wordList.size(); j++)
          {
          Word w;
          w = (Word)wordList.get(j);
          System.out.println(w.getWord() + "\t" + w.getFreq());
          }
        
    }
}

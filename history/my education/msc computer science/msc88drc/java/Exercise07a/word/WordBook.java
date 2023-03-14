package word;

import java.io.*;
import java.util.*;

/**
   This class stores and manipulates a set of <code>Word<\code> objects, each
   of which contains details about a particular word read in from a file.
   
   <p>The contents of the <code>WordBook<\code> may be read from a textfile
**/
public class WordBook
{
    private ArrayList wordList;
    private ArrayList copy;

    /**
     * Constructor to create an empty <code>WordBook</code>.
     **/
    public WordBook()
    {
        wordList = new ArrayList();
        copy = new ArrayList();
    }
    
    /**
     * Loads word data from the specified file and stores it as lower case. 
     * If the specified file exists and is readable, the data is read in, 
     * and any existing data is replaced by the new data. 
     * If the load process fails for any reason, the existing data is retained. 
     *
     * @param filename the name of the file to load the word data from
     * @exception IOException if the specified file cannot be read, or if 
     *  any other error occurs during reading
     * words are all saved in lower case
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
		        
		        Word w0 = 
		            new Word(thisWord.toLowerCase(), 1);
		        wordList.add(wLIndex, w0);
		        copy.add(wLIndex, w0);
		        wLIndex++;
		        
		        // initialise thisWord
		        thisWord = "";
		    }

		offset += 1;      
	            }
	    }
	// last line and there's a word present
	else if (wordLength > 1)
	    { 
	        Word w1 = new Word(thisWord, 1);
	        wordList.add(wLIndex, w1);
	        copy.add(wLIndex, w1);
	    }	        
            }
        while (line != null); //when this condition is false, the loop is exite
    }
    

    /**
     * Uses the heap sort to sort the data into alphabetical order, 
     * word comparisons are not case sensitive
     **/
    public void heapsort() 
    {
        /*
        // size of the array
        int n = wordList.size();
        int l, j, ir, i;
        double rra;

        l = (n >> 1) + 1;
        ir = n;
        for (;;) 
            {
	if (l > 1) {
	    rra = ra[--l];
            } else {
	rra = ra[ir];
	ra[ir] = ra[1];
	if (--ir == 1) {
	    ra[1] = rra;
	    return;
	}
            }
            i = l;
            j = l << 1;
            while (j <= ir) {
	if (j < ir && ra[j] < ra[j+1]) { ++j; }
	if (rra < ra[j]) {
	    ra[i] = ra[j];
	    j += (i = j);
	} else {
	    j = ir + 1;
	}
            }
            ra[i] = rra;
        */
        }

        /**
         * Uses the bubble sort to sort the data into alphabetical order, 
         * word comparisons are not case sensitive
         **/
        public void alphaSort()
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

		// if the (jth + 1) word should appear before the jth 
		// word in the alphabetic sequence
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
            }

        /**
         * Obtains the sorted list, calculates the number of times each word 
         * in the data file occurs. Removes duplicated words.
         **/
        public void countNRemove ()
            {
	// initialise local variables
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
	
	        if(wordsSame)// if word exists then
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
		// add 1 to the pointer position
		pointer += 1;
	            } 
	    } while (pointer != (listSize - 1));          
            }

    /**
     * Sort the arrayList by frequency smallest first
     **/
    public void freqSort()
    {
        Collections.sort(wordList);
        Collections.sort(copy);
    }
    
    public void descend()
    {
        int n = wordList.size();
        int b = n-1;

        //copy first element of the copy arraylist into the last element of
        //the original array list
         for(int i=0; i < n; i++)
            {
	Word tmp = (Word)copy.get(i);
	wordList.set((b-i),tmp);
            }               
    }


    
    /**
     * Get the arrayList wordList
     *
     * @return wordList
     **/
    
    public ArrayList getWordList()
    {
        return wordList;
    }
}

package I;
import java.io.*;
import java.util.*;
/**
 * Word Split
 **/
public class WordSplit
{
    private ArrayList wordList;

    /**
     * Constructor to create an Empty Wordsplit
     **/
    public WordSplit(String cdDetails)
    {
      String word = "";
      wordList = new ArrayList();
      int size = cdDetails.length();
      char hyphen = '-';
      
      for(int i=0; i<size; i++)
      {
	char thisChar = cdDetails.charAt(i);
	
	if(thisChar == hyphen)
	  //end of word, add to arraylist, initialise String
	{
	  wordList.add(word);
	  word = "";
	}	
	else //add characters to the String word
	{
	  word = word + thisChar;
	}
	
      }
      //gets the final word
      wordList.add(word);      
    }

  public ArrayList getWords()
  {
    return wordList;
  }
  
}

import word.*;
import java.io.*;
import java.util.*;

class WordCount
{
    private WordBook myWordBook;
    
    public WordCount (String filename) throws IOException
    {
     myWordBook = new WordBook();
     myWordBook.load(filename);
     myWordBook.alphaSort();
     myWordBook.countNRemove();
     myWordBook.freqSort();
     myWordBook.descend();
     
     // Print out results to the command line  
     for (int i=0; i < myWordBook.getWordList().size(); i++)
         {
             Word w;
             w = (Word)myWordBook.getWordList().get(i);
             System.out.println(w.getWord() + "\t\t" + w.getFreq());
         }
    }
  
    public static void main (String[] args) throws IOException
  {
    if (args.length > 0)
        {
            String filename = args[0];
            new WordCount(filename);
        } 
    else
        {
            System.out.println ("Error,Please input a filename!");
        }
  }
}


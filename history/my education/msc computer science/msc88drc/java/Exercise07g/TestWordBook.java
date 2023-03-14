import word.*;
import java.io.*;


class TestWordBook
{
    public static void main (String[] args) throws IOException
    {
        WordBook myWordBook = new WordBook();
        myWordBook.load("DaveCount.txt");
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
        
        System.out.println();
        System.out.println("Total words:" + "\t\t" +
	           myWordBook.getWordList().size());
        
    }
}


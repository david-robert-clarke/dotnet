import word.*;
import java.io.*;


class WordCount
{
    private WordBook myWordBook;
    
    public WordCount (String filename) throws IOException
    {
     myWordBook = new WordBook();
     myWordBook.load(filename);
     myWordBook.bubbleSort();
     myWordBook.count();
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


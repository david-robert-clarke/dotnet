package word;

/**
 * A class to represent a Word. A word object has a String value named word and
 * an integer value named freq used to represent the number of times it has 
 * occured in the text file.
 **/
public class Word
{
  private String word;
  private int freq;

  public Word (String wrd, int fre)
    {
      word = wrd;
      freq = fre;
    }

  public void setWord (String wrd)
    {
      word = wrd;
    }


  public void setFreq (int fre)
    {
      freq = fre;
    }

  public String getWord()
    {
      return word;
    }

  public int getFreq()
    {
      return freq;
  
    }
}

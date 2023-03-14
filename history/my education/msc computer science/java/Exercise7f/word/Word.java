package word;

/**
   A class to represent a Word. A word object is made up of two fields:
   <ul>
   <li>a String value named word and to hold the series of letters/numbers & 
   digits
   <li>an integer value named freq used to represent the number of times it 
   has occured in the text file.
**/
public class Word implements Comparable
{
    private String word;
    private int freq;
    private int alphaVal

    /**
     * Constructor to create a <code>Word</code> using the specified values
     * 
     * @param wrd a series of characters and numbers
     * @param fre the number of times the word has appeared in the passage
     **/   
    public Word (String wrd, int fre)
    {
        word = wrd;
        freq = fre;
    }
    
    /**
     * Return comparitive values (with repect to frequencies of words) to the 
     * calling program
     *
     * @param obj an arraylist object passed from the calling program
     **/
    public int compareTo(Object obj)
    {
        if (this.freq < ((Word)obj).freq) return -1;
        if (this.freq > ((Word)obj).freq) return +1;
        return 0;
    }

    /**
     * Set the word String
     * 
     * @param wrd a series of characters and numbers
     **/
    public void setWord (String wrd)
    {
        word = wrd;
    }


    /**
     * Set the word Frequency
     *
     * @param fre the number of times the word has appeared in the passage
     **/
    public void setFreq (int fre)
    {
        freq = fre;
    }
    
    /**
     * Get the word
     * 
     * @return the word
     **/
    public String getWord()
    {
        return word;
    }

    /**
     * Get the frequency
     * 
     * @return the frequency
     **/
    public int getFreq()
    {
        return freq;
  
    }
}

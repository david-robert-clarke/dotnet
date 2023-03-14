//Table.java
//The outer for loop executes 10 times.
//In each iteration, the inner for loop runs 8 times.
//Therefore, a total of 80 values are computed.
//For each of these values, the while loop is executed to pad the result string
//David Clarke
//16_10_2002

public class Table
{  public static void main(String[] args)
  {  final int COLUMN_WIDTH = 10;
  
  for (int x = 1; x <= 10; x++)
  {  // print table row

    for (int y = 1; y <= 8; y++)
    {  int p = (int)Math.pow(x, y);
 
       // convert value to string

       String pstr = "" + p;
       // pad with spaces

       while (pstr.length() < COLUMN_WIDTH)
	 pstr = " " + pstr;
       
       System.out.print(pstr);
    }
    System.out.println();
  }
  }
}

  
  

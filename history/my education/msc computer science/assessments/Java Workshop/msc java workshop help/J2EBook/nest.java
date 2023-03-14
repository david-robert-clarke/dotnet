//Program nest.java
//Uses nested loops to print an array of numbers
//David Clarke
//16_10_2002

public class nest
{  public static void main (String[] args)
  {  
    for (int x = 1; x <= 10; x++)
    { //print table row

      for (int y = 1; y <= 8; y++)
      {  int p = (int)Math.pow(x, y);
      System.out.print(p + " ");
      }
      System.out.println();
    }
  }
}

    
    
      
    

/**
 * A program to print a square of a fixed width and height:
 *
 *   *******
 *   *     *
 *   *     *
 *   *     *
 *   *     *
 *   *     *
 *   *******
 *
 *  @author Stuart Reynolds ... 1998
 */


public class Square
{
    public static void main(String[] args)
    {
      int length=7;                      //Specifies the length of each side
      
      for (int i=0; i<length; i++)       //Top
	System.out.print('*');
      System.out.println();              //Newline
      
      
      for (int i=2; i<length; i++)       //Middle section
      {
	System.out.print('*');           //  left line
	
	for (int j=2; j<length; j++)     //  horiz. spacing
	  System.out.print(' ');

	System.out.print('*');           //  right line
	
	System.out.println();
      }
      
      
      for (int i=0; i<length; i++)       //Bottom
	System.out.print('*');
      System.out.println();
      
    }
}

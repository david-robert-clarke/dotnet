/**
Circle.class
Displays a circle on standard output.
&copy; Ian Millington 1998
*/
public class Circle
{
  public static void main (String[] args)
    {
      if (args.length < 3) 
	{
	  System.out.println("Displays a Circle on Standard Output");
	  System.out.println("Usage: Circle <radius> <aspect ratio> <border>");
	  System.out.println("Aspect ratio: Radio of character display width/height.");
	  System.out.println("Border width: Fraction of circle size that is the border.");
	  System.exit(-1);
	}

      int radius = Integer.parseInt(args[0]); // get the circle radius
      float aspect = Float.valueOf(args[1]).floatValue(); // the aspect ratio
      float border = Float.valueOf(args[2]).floatValue(); // the border

      int yradius = (int)(radius*aspect);
      for (int y = 0; y <= 2*yradius; y++) 
	{
	  for (int x = 0; x <= 2*radius; x++)
	    {
	      float distance = (float)Math.sqrt((radius - x)*(radius - x) +
						(radius - y/aspect)*
						(radius - y/aspect));
	      float fraction = (radius - distance) / radius;

	      if (fraction > 0.0f && fraction < border)
		System.out.print("*");
	      else
		System.out.print(" ");
	    }
	  System.out.println("");
	}
    }
}

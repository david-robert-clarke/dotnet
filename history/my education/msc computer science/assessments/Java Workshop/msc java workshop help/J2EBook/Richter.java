public class Richter
{	public static void main(String[] args)
	{	ConsoleReader console = new ConsoleReader(System.in);
		System.out.println("Enter a magnitude on the Richter scale: ");
		double magnitude = console.readDouble();
		Earthquake quake = new Earthquake(magnitude);
		System.out.println(quake.getDescription());
	}
}

class Earthquake
{	public Earthquake(double magnitude)
	{ richter = magnitude;
	}
	public String getDescription()
	{	String r;
		if (richter >= 8.0)
			r = "Most structures fall";
		else if (richter >= 7.0)
			r = "Many buildings destroyed";
		else if (richter >= 6.0)
			r = "Many buildings considerably damaged, some collapse";
		else if (richter >= 5.0)
			r = "Damage to poorly constructed buildings";
		else if (richter >= 4.5)
			r = "Generally not felt by people";
		return r;
	}
	private double richter;
}


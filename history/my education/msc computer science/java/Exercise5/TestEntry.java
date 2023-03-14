class TestEntry
/*
  Tests the Entry Class
*/
{
	public static void main (String[] args)
	{
		String pfn = "Clarke";
		String pgn = "Dave";
		String hpn = "684 7454";
		String wpn = "684 7454";
		String mpn = "0789 2255";
		String ema = "davidrjesus@hotmail.com";
		Person thisPerson = new Person(pfn, pgn, hpn, wpn, mpn, ema);
		
		String hnn = "1";
		String sn = "Pounles Close";
		String t = "Castle Bromwich";
		String r = "West Midlands";
		String c = "England";
		String pc = "B39 psx";
		Address thisAddress = new Address(hnn, sn, t, r, c ,pc);
		
		Entry myEntry = new Entry (thisPerson, thisAddress);
		
		myEntry.getPerson().
	}
}
		

import java.io.*;
import java.util.*;

class Clock
{
	public static void main(String[] args)
	{
    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    // saves calendar information in the format Wed Nov 13 19:48:33 GMT 2002
    String DATE_FORMAT = "EEE MMM d HH:mm:ss z yyyy";
    java.text.SimpleDateFormat sdf = 
          new java.text.SimpleDateFormat(DATE_FORMAT);
		
		// this line of code sets the time zone manually;
    sdf.setTimeZone(TimeZone.getDefault());          
		System.out.println(sdf.format(cal.getTime()));
   }

} 


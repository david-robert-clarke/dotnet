/**
   @version 1.01 2001-06-26
   @author Cay Horstmann
*/

import java.net.*;

/**
   This program demonstrates the InetAddress class.
   Supply a host name as command line argument, or run
   without command line arguments to see the address of the
   local host.
*/
public class InetAddressTest
{  
   public static void main(String[] args)
   {  
      try
      {
         if (args.length > 0)
         {  
            String host = args[0];
            InetAddress[] addresses
               = InetAddress.getAllByName(host);
            for (int i = 0; i < addresses.length; i++)
               System.out.println(addresses[i]);
         }
         else
         {  
            InetAddress localHostAddress
               = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
         }
      }
      catch (Exception e)
      {  
         e.printStackTrace();
      }
   }
}

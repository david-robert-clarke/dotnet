package I;
import java.sql.*;
import java.io.*;
import java.util.*;

public class MyConnection 
{
  public static Connection C;
  
  public static void main (String args[])
  {
    // BufferedReader reader = 
    // new BufferedReader (new InputStreamReader(System.in));
        
    try 
    {
      Class driver = Class.forName("org.postgresql.Driver");
      DriverManager.registerDriver((Driver)driver.newInstance());
	
      // get the values required to connect to the database.
	
      System.out.print("Input the database: ");
      String dbname = "msc67lxb";
      String username = "msc88drc";
      String pw = "charlie";

      // the elements of the database connection url are
      // protocol (jdbc:), subprotocol (postgresql:), 
      // server (//dbhost), and database name (/<dbname>)
	
      String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
      System.out.println("Successfully found database!");
      System.out.println();
	
      C = DriverManager.getConnection(dbUrl, username, pw);
      System.out.println("Successfully connected to database!");
      System.out.println();
      
      //new stuff
      /*
      DeleteCDTupleQuery thisSearch = 
          new DeleteCDTupleQuery("Weezer","Maladroit");
      thisSearch.exeQuery();
      */     

      //Adding cd tuples
      String cd_name = "By The Way"; 
      String artist = "Red Hot Chili Peppers";
      String genre = "Rock";
      String type = "Album";
      String release_date = "2002-05-01";
      String r_price = "12.99";  
      String supplier_name = "Verjin";
      String stock_level = "3";
      String w_price = "4.99";
      
      ArrayList cdEntry = new ArrayList();
      cdEntry.add(cd_name);
      cdEntry.add(artist);
      cdEntry.add(genre);
      cdEntry.add(type);
      cdEntry.add(release_date);
      cdEntry.add(r_price);
      cdEntry.add(supplier_name);
      cdEntry.add(stock_level);
      cdEntry.add(w_price);
      AddCDTupleQuery thisQuery = new AddCDTupleQuery(cdEntry);
      thisQuery.exeQuery();
  
      /*
      //cd Search
      ArrayList temp = new ArrayList();
      CDSearch thisSearch = new CDSearch("Red Hot Chili Peppers","By The Way");
      temp = thisSearch.exeQuery();
      */

      /*
	for(int i=0;i<temp.size();i++)
	{
	System.out.println((String)temp.get(i));
	}
      */
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred in MyConnection. " + e);
    }
  }
}


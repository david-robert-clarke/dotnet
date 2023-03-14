package I;

import java.sql.*;
import java.io.*;

public class MyConnection 
{
  public static Connection C;
  
  public MyConnection()
  {
    // BufferedReader reader = 
    //    new BufferedReader (new InputStreamReader(System.in));
        
    try 
    {
      Class driver = Class.forName("org.postgresql.Driver");
      DriverManager.registerDriver((Driver)driver.newInstance());
	
      // get the values required to connect to the database.
	
      System.out.print("Input the database: ");
      String dbname = "msc67lxb";
      String username = "msc64hel";
      String pw = "MICHAEL";

      // the elements of the database connection url are
      // protocol (jdbc:), subprotocol (postgresql:), 
      // server (//dbhost), and database name (/<dbname>)
	
      String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
      System.out.println("Successfully found database!");
      System.out.println();
	
      C = DriverManager.getConnection(dbUrl, username, pw);
      System.out.println("Successfully connected to database!");
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred. " + e);
    }
  }
}


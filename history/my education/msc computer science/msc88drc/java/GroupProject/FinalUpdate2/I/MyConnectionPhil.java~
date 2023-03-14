package I;

import java.sql.*;
import java.io.*;


/**
   This class creates and hardwires a connection to the database

   @author David Clarke
**/
public class MyConnectionPhil 
{
  public static Connection philC;  
  /**
   * Constructor to create a new connnection to the database
   **/
  public MyConnectionPhil()
  {
    // BufferedReader reader = 
    //    new BufferedReader (new InputStreamReader(System.in));
        
    try 
    {
      Class driver = Class.forName("org.postgresql.Driver");
      DriverManager.registerDriver((Driver)driver.newInstance());
	
      // get the values required to connect to the database.
	
      System.out.print("Input the database: ");
      String dbname = "msc33zxz";
      String username = "msc88drc";
      String pw = "charlie";

      // the elements of the database connection url are
      // protocol (jdbc:), subprotocol (postgresql:), 
      // server (//dbhost), and database name (/<dbname>)
	
      String dbUrl = "jdbc:postgresql://dbhost/" + dbname;	
      philC = DriverManager.getConnection(dbUrl, username, pw);

      System.out.println("Connected to phil's database successfully!");
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred. " + e);
    }
  }
}


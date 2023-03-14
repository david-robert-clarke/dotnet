package I;

import java.sql.*;
import java.io.*;


/**
   This class creates and hardwires a connection to Zhong's database

   @author David Clarke
**/
public class MyConnectionZhong 
{
  public static Connection zhongC;  
  /**
   * Constructor to create a new connnection to the database
   **/
  public MyConnectionZhong()
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
      zhongC = DriverManager.getConnection(dbUrl, username, pw);
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred. " + e);
    }
  }
}


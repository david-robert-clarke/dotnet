package I;

import java.sql.*;
import java.io.*;


/**
   This class creates and hardwires a connection to the database

   @author David Clarke
**/
public class MyConnection 
{
  public static Connection C;  
  /**
   * Constructor to create a new connnection to the database
   **/
  public MyConnection()
  { 
    try 
    {
      Class driver = Class.forName("org.postgresql.Driver");
      DriverManager.registerDriver((Driver)driver.newInstance());
	
      // get the values required to connect to the database.
	
      System.out.print("Input the database: ");
      String dbname = "msc67lxb";
      String username = "msc64hel";
      String pw = "MICHAEL";	
      String dbUrl = "jdbc:postgresql://dbhost/" + dbname;	
      C = DriverManager.getConnection(dbUrl, username, pw);
    }
    catch ( Exception e ) 
    {
      System.out.println( "An exception occurred. " + e);
    }
  }
}


package I;
import java.sql.*;
import java.util.ArrayList;

/**
   Used by DataInfo2, retrieves all existing item ID numbers in the 
   Staff table

   @author Helen Loynes
 **/
public class GetSIDQuery
{
  private Connection c;
  private String[] sidData;

  /**
   * Constructor to create a new get staff ID number query
   **/
  public GetSIDQuery()
  {
    c = MyConnection.C;
    sidData = new String[300];
  }
 
  /**
   * Execute the Query
   *
   * @return an array that contains all the staff ID numbers
   **/
  public String[] exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT sid FROM staff");

      int i=0;
      while (rs.next()) 
      {
	String sid = rs.getString("sid");      
	sidData[i]= sid;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSIDQuery " + e);
    }
        
    return(sidData);
    
  }
}

  

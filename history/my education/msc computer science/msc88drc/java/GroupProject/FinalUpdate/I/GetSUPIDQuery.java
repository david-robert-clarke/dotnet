package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * GetSUPIDQuery
 *
 * Used by DataInfo2, retrieves all existing item ID numbers in the 
 * supplier table.
 * 
 **/
public class GetSUPIDQuery
{
  private Connection c;
  private String[] supidData;

  /**
   * Constructor to create a new get all supplier IDs query
   **/
  public GetSUPIDQuery()
  {
    c = MyConnection.C;
    supidData = new String[300];
  }
 
  /**
   * Execute the query
   *
   * @return an array of supplier data
   **/
  public String[] exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT supid FROM supplier");

      int i=0;
      while (rs.next()) 
      {
	String supid = rs.getString("supid");      
	supidData[i]= supid;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSUPIDQuery " + e);
    }
        
    return(supidData);    
  }
}

  

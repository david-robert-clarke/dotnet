package I;
import java.sql.*;
import java.util.ArrayList;


/**
  Used by DataInfo2, retrieves all existing item ID numbers in the 
  Customer table.

  @author Helen Loynes 
 **/
public class GetCIDQuery
{
  private Connection c;
  private String[] cidData;

  /**
   * Constructor to create a get customer IDs query
   **/
  public GetCIDQuery()
  {
    c = MyConnection.C;
    cidData = new String[300];
  }
 
  /**
   * Execute the query 
   *
   * @return an array of customer IDs
   **/
  public String[] exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT cid FROM customer");

      int i=0;
      while (rs.next()) 
      {
	String cid = rs.getString("cid");      
	cidData[i]= cid;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetCIDQuery " + e);
    }
        
    return(cidData);
    
  }
}

  

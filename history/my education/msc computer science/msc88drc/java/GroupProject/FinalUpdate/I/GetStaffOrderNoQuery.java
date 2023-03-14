package I;
import java.sql.*;


/**
  Used by DataInfo2, retrieves all existing staff order numbers in the 
  Staff table.

  @author David Clarke 
 **/
public class GetStaffOrderNoQuery
{
  private Connection c;
  private String[] sOrderNoData;

  /**
   * Constructor to create a new get staff order number query
   **/
  public GetStaffOrderNoQuery()
  {
    c = MyConnection.C;
    sOrderNoData = new String[300];
  }
 
  /**
   * Execute the query
   * 
   * @return an array of stock order numbers
   **/
  public String[] exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT sorder_no FROM staff_order");

      int i=0;
      while (rs.next()) 
      {
	String sorder_no = rs.getString("sorder_no");      
	sOrderNoData[i]= sorder_no;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetStaffOrderNoQuery "+ e);
    }
        
    return(sOrderNoData);
    
  }
}

  

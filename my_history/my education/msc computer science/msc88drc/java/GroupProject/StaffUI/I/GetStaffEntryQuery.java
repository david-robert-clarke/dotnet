package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class GetStaffEntryQuery
{
  private Connection theConnection;  
  private ArrayList staffArrayList;
  private String sid;

  public GetStaffEntryQuery(String staffID)
  {
    theConnection = MyConnection.C;
    staffArrayList = new ArrayList();
    sid = staffID;
  }

  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = theConnection.createStatement();
    
      ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE "+
				       "sid ='" + sid +"'");
      

      while (rs.next()) 
      {
	staffArrayList.add(rs.getString("sfirstname"));
	staffArrayList.add(rs.getString("slastname"));
	staffArrayList.add(rs.getString("staff_addr1"));
	staffArrayList.add(rs.getString("staff_addr2"));
	staffArrayList.add(rs.getString("staff_pcode"));
	staffArrayList.add(rs.getString("staff_mobphone"));
	staffArrayList.add(rs.getString("staff_phone"));
      }	
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in CDSearch. " + e);
    }
        
    return(staffArrayList);
  }
}

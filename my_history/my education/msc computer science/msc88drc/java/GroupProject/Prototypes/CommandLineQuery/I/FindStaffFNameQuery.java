package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class FindStaffFNameQuery
{
  private Connection c;
  private String sid;
  private String firstName;

  public FindStaffFNameQuery(String staffID)
  {
    c = MyConnection.C;
    sid = staffID;
    firstName = "";
  }

  public String exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT sfirstname FROM staff " +
				       "WHERE sid ='" + sid + "'");

      while(rs.next())
      {
	firstName = rs.getString("sfirstname");
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
        
    return(firstName);
  }
}

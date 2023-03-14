package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 * Checks for staffs fname and position
 **/
public class FindStaffFNameQuery
{
  private Connection c;
  private String sid;
  private String firstName, position;

  public FindStaffFNameQuery(String staffID)
  {
    c = MyConnection.C;
    sid = staffID;
    firstName = "";
    position ="";
  }

  // the first method returns a String, the first name of the staff member
  public String exeQuery0()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT sfirstname FROM staff "
				       + "WHERE sid ='" + sid + "'");

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

  //the exeQuery1 method returns the position of the staff member
  public String exeQuery1()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT position FROM staff "
				       + "WHERE sid ='" + sid + "'");

      while(rs.next())
      {
	position = rs.getString("position");
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
        
    return(position);
  }
}

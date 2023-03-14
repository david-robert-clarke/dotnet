package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by the NewPasswordUI, this JDBC query updates the password of the 
   staff member
   
   @author David Clarke
**/
public class EditStaffPWQuery
{
  private Connection c;
  private String sid,password;

  /**
   * Constructor to create a new edit staff password query
   *
   * @param staffID the staffID number
   * @param pass the staff password
   **/
  public EditStaffPWQuery(String staffID, String pass)
  {
    c = MyConnection.C;
    sid = staffID;
    password = pass;
  }

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      int no = stmt.executeUpdate("UPDATE staff SET password ='" + password + 
				  "' WHERE sid ='" + sid + "'");
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
  }
}

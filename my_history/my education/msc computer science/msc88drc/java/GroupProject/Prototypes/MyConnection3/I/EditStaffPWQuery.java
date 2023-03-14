package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class EditStaffPWQuery
{
  private Connection c;
  private String sid,password;

  public EditStaffPWQuery(String staffID, String pass)
  {
    c = MyConnection.C;
    sid = staffID;
    password = pass;
  }

  public void exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      int no = stmt.executeUpdate("UPDATE staff SET password ='" + password + 
				  "' WHERE sid ='" + sid + "'");

      System.out.println("Number of entries updated =" + no);
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
  }
}

package I;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by the StaffUI, this JDBC query deletes the specified staff member from
   the database
   
   @author Helen Loynes  
**/
public class DeleteStaffEntryQuery
{
  private ArrayList staffArrayList;
  private Connection c;

  /**
   * Constructor to create a new delete staff entry query
   *
   * @param staff an arraylist of staff details
   **/
  public DeleteStaffEntryQuery(ArrayList staff)
  {      

    c = MyConnection.C;
    staffArrayList = staff;
  }

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {
      
      String sid = (String)staffArrayList.get(0);
      

      // Remove a result set containing all data from my_table
      Statement stmt = c.createStatement();
      int number = stmt.executeUpdate("DELETE FROM staff WHERE sid = '" 
				      + sid + "'");
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DeleteStaffEntryQuery. " + e);
    }
  }
}

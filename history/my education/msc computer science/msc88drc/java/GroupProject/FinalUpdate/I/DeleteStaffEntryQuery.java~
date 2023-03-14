package I;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class DeleteStaffEntryQuery
{
  private ArrayList staffArrayList;
  private Connection c;

  public DeleteStaffEntryQuery(ArrayList staff)
  {      

    c = MyConnection.C;
    staffArrayList = staff;
  }

  public void exeQuery()
  {
    try 
    {
      
      String sid = (String)staffArrayList.get(0);
      System.out.println(sid);
      

      // Remove a result set containing all data from my_table
      Statement stmt = c.createStatement();
      int number = stmt.executeUpdate("DELETE FROM staff WHERE sid = '" + sid + "'");
      
      System.out.println("Number of staff removed  = " + number);
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DeleteStaffEntryQuery. " + e);
    }
  }
}

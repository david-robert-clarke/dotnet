package I;
import java.sql.*;

/**
 * SQL Query
 *
 * 
 **/
public class StaffUserNamePwQuery
{
  private Connection c;
  private String sid,password;
  private boolean entry;

  public StaffUserNamePwQuery(String staffID, String pw)
  {      

    c = MyConnection.C;
    sid = staffID;
    password = pw;
  }

  public boolean exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      //Use the sup_name field to find out if a row is present for the query
      ResultSet rs0 = stmt.executeQuery("SELECT * FROM staff "+
					"WHERE sid ='" + sid+"'"+
					"AND password ='" + password + "'");

      boolean rowPresent = rs0.first();
      
      if(rowPresent)
      {
	System.out.println("Row is present");
      }
      else
      {
	System.out.println("No cjance mahonay");
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
        
    return(entry);
  }
}

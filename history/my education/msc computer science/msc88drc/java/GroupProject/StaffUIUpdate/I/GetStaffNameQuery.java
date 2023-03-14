package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * Get all staff names
 *
 * 
 * 
 **/
public class GetStaffNameQuery
{
  private Connection c;
  private ArrayList staff;

  public GetStaffNameQuery()
  {
    c = MyConnection.C;
  }

  /**
   * Return an arraylist of staff names
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      staff = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM staff");

      while (rs.next())
      {
	staff.add(rs.getString("slastname"));
      }
      
      for(int i=0;i<staff.size();i++)
      {
	System.out.println((String)staff.get(i));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetStaffNames. " + e);
    }
        
    return(staff);
  }
}


  
  

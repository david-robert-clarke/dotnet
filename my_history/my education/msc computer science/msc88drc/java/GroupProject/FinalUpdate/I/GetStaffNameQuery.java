package I;
import java.sql.*;
import java.util.ArrayList;


/**
   Used by StaffUI, gets a list of all staff names

   @author Helen Loynes   
 **/
public class GetStaffNameQuery
{
  private Connection c;
  private ArrayList staff;

  /**
   * Constructor to create a new get staff name query
   **/
  public GetStaffNameQuery()
  {
    c = MyConnection.C;
  }

  /**
   * Execute the Query
   *
   * @return an arraylist of staff names
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
	String si = rs.getString("sid");
	String sl = rs.getString("slastname");
	staff.add(si + "-" +  sl);
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetStaffNames. " + e);
    }
        
    return(staff);
  }
}


  
  

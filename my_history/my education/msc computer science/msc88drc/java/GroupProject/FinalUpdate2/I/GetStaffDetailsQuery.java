package I;
import java.sql.*;
import java.util.ArrayList;

/**  
     Used by EditStaffUI, takes the staffID as an argument, returns an 
     arraylist of staff details for a particular member of staff

     @author Helen Loynes
 **/
public class GetStaffDetailsQuery
{
  private Connection c;
  private String sid;
  private ArrayList staffDetails;

  /**
   * Constructor to create a new get staff details query
   *
   * @param sID the staff ID number
   **/
  public GetStaffDetailsQuery(String sID)
  {
    c = MyConnection.C;
    sid = sID;
  }

  /**
   * Execute the Query
   *
   * Return an arraylist that contains the queried staff members details
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      staffDetails = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE "+
		       "sid = '" + sid + "'");

      while (rs.next())
      {
	staffDetails.add(rs.getString("sid"));
	staffDetails.add(rs.getString("sfirstname"));
	staffDetails.add(rs.getString("slastname")); 
	staffDetails.add(rs.getString("staff_addr1"));
	staffDetails.add(rs.getString("staff_addr2")); 
	staffDetails.add(rs.getString("staff_pcode"));
	staffDetails.add(rs.getString("staff_phone"));
	staffDetails.add(rs.getString("staff_mobphone"));
	staffDetails.add(rs.getString("position"));
	staffDetails.add(rs.getString("password"));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetStaffNames. " + e);
    }
        
    return(staffDetails);
  }
}

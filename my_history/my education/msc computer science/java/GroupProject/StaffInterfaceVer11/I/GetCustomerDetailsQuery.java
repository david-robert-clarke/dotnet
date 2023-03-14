package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * Get all customer names
 *
 * 
 * 
 **/
public class GetCustomerDetailsQuery
{
  private Connection c;
  private String customerLastName;
  private ArrayList customerDetails;

  public GetCustomerDetailsQuery(String cLastName)
  {
    c = MyConnection.C;
    customerLastName = cLastName;
  }

  /**
   * Return an arraylist of customer names
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      customerDetails = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE "+
				       "clastname = '" + customerLastName + "'");

      while (rs.next())
      {
	customerDetails.add(rs.getString("cid"));
	customerDetails.add(rs.getString("cfirstname"));
	customerDetails.add(rs.getString("clastname")); 
	customerDetails.add(rs.getString("home_addr1"));
	customerDetails.add(rs.getString("home_addr2")); 
	customerDetails.add(rs.getString("home_pcode"));
	customerDetails.add(rs.getString("cphone"));
	customerDetails.add(rs.getString("mob_phone"));
      }
      
      for(int i=0;i<customerDetails.size();i++)
      {
	System.out.println((String)customerDetails.get(i));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetCustomerNames. " + e);
    }
        
    return(customerDetails);
  }
}

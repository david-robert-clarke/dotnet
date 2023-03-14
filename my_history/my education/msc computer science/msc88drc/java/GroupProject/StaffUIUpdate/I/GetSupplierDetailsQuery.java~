package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * Get all supplier names
 *
 * 
 * 
 **/
public class GetSupplierDetailsQuery
{
  private Connection c;
  private String sup_name;
  private ArrayList supplierDetails;

  public GetSupplierDetailsQuery(String sName)
  {
    c = MyConnection.C;
    sup_name = sName;
  }

  /**
   * Return an arraylist of supplier names
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      supplierDetails = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM supplier WHERE "+
				       "sup_name = '" + sup_name + "'");

      while (rs.next())
      {
	supplierDetails.add(rs.getString("sup_name")); 
	supplierDetails.add(rs.getString("sup_addr1"));
	supplierDetails.add(rs.getString("sup_addr2")); 
	supplierDetails.add(rs.getString("sup_pcode"));
	supplierDetails.add(rs.getString("sup_phone"));
      }
      
      for(int i=0;i<supplierDetails.size();i++)
      {
	System.out.println((String)supplierDetails.get(i));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSupplierNames. " + e);
    }
        
    return(supplierDetails);
  }
}

package I;
import java.sql.*;
import java.util.ArrayList;


/**
   Used by EditSupplierUI, returns the details of the queried supplier
   
   @author David Clarke
 **/
public class GetSupplierDetailsQuery
{
  private Connection c;
  private String sup_name;
  private ArrayList supplierDetails;

  /**
   * Constructor to create a new get supplier details query
   * 
   * @param sName the supplier name
   **/
  public GetSupplierDetailsQuery(String sName)
  {
    c = MyConnection.C;
    sup_name = sName;
  }

  /**
   * Execute the query
   *
   * @return an arraylist of supplier names
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
	supplierDetails.add(rs.getString("supid"));
	supplierDetails.add(rs.getString("sup_name")); 
	supplierDetails.add(rs.getString("sup_addr1"));
	supplierDetails.add(rs.getString("sup_addr2")); 
	supplierDetails.add(rs.getString("sup_pcode"));
	supplierDetails.add(rs.getString("sup_phone"));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSupplierNames. " + e);
    }        
    return(supplierDetails);
  }
}

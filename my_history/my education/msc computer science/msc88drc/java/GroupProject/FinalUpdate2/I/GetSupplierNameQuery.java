package I;
import java.sql.*;
import java.util.ArrayList;

/**
   Used by the StaffUI, returns a list of all supplier names
   
   @author David Clarke
 **/
public class GetSupplierNameQuery
{
  private Connection c;
  private ArrayList suppliers;
  
  /**
   * Constructor to create a new get supplier name query
   **/
  public GetSupplierNameQuery()
  {
    c = MyConnection.C;
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
      suppliers = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");
      suppliers.add("");

      while (rs.next())
      {
	suppliers.add(rs.getString("sup_name"));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSupplierNames. " + e);
    }        
    return(suppliers);
  }
}


  
  

package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * Get all supplier names
 *
 * 
 * 
 **/
public class GetSupplierNameQuery
{
  private Connection c;
  private ArrayList suppliers;

  public GetSupplierNameQuery()
  {
    c = MyConnection.C;
  }

  /**
   * Return an arraylist of supplier names
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      suppliers = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");

      while (rs.next())
      {
	suppliers.add(rs.getString("sup_name"));
      }
      
      for(int i=0;i<suppliers.size();i++)
      {
	System.out.println((String)suppliers.get(i));
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetSupplierNames. " + e);
    }
        
    return(suppliers);
  }
}


  
  

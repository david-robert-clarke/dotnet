package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class UpdateSupplierQuery
{
  private ArrayList supplierArrayList;
  private Connection c;

  public UpdateSupplierQuery(ArrayList s_Details)
  {
    c  = MyConnection.C;
    supplierArrayList = s_Details;
  }

  public ArrayList exeQuery()
  {
    try 
    {
      String sup_name = (String)supplierArrayList.get(0);
      String supaddr_1 = (String)supplierArrayList.get(1);
      String supaddr_2  = (String)supplierArrayList.get(2);
      String sup_pcode = (String)supplierArrayList.get(3);
      String sup_phone = (String)supplierArrayList.get(4);

      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      stmt.executeUpdate("UPDATE supplier SET sup_addr1 ='" + supaddr_1 
			 + "', sup_addr2 = '" + supaddr_2 + "', sup_pcode = '" 
			 + sup_pcode + "', sup_phone = '" + sup_phone + "' " +
			 "WHERE sup_name ='" + sup_name + "'" );
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }
        
    return(supplierArrayList);
  }
}

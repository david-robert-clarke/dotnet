package I;
import java.sql.*;

/**
 * SQL Query
 *
 * 
 **/
public class DeleteSupplierQuery
{
  //this class assumes that every supplier name is unique
  private String sup_name;
  private Connection c;

  public DeleteSupplierQuery(String supName)
  { 
    c = MyConnection.C;
    sup_name = supName;
  }

  public void exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      
      System.out.println("The supplier to be deleted is: " + sup_name);
      int deleteCount = stmt.executeUpdate("DELETE FROM supplier " +
					    "WHERE sup_name ='"+sup_name+ "'");

      
      System.out.println("No.of Entries del from supplier Table:"+deleteCount);
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DelQuery. " + e);
    }
  }
}

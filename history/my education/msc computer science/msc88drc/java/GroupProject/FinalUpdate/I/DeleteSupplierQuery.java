package I;
import java.sql.*;
import java.util.ArrayList;

/**
   Used by the StaffUI, this JDBC query deletes the specified supplier from
   the database
   
   @author David Clarke  
**/
public class DeleteSupplierQuery
{
  //this class assumes that every supplier name is unique
  private ArrayList supArrayList;
  private Connection c;

  /**
   * Constructor to create a new delete supplier query
   *
   * @param supplier the supplier name
   **/
  public DeleteSupplierQuery(ArrayList supplier)
  { 
    c = MyConnection.C;
    supArrayList = supplier;
  }

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    { 
      String supid = (String)supArrayList.get(0);
      System.out.println(supid);

      Statement stmt = c.createStatement();
      int deleteCount = stmt.executeUpdate("DELETE FROM supplier WHERE supid ='"+supid+ "'");

      
      System.out.println("Number of suppliers removed = "+deleteCount);
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DeleteSupplierQuery. " + e);
    }
  }
}

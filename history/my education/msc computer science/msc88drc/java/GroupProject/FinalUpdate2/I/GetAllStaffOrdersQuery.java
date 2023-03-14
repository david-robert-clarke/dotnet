package I;
import java.sql.*;
import java.util.ArrayList;


/**
  Used by EditStockUI, inputs artist and cd name returns an array of both
  stock and cd information.
  
  @author David Clarke
 **/
public class GetAllStaffOrdersQuery
{
  private Connection c;
  private String[] staffOrderData;

  /**
   * Constructor to create a get all staff orders query
   **/
  public GetAllStaffOrdersQuery()
  {
    c = MyConnection.C;
    staffOrderData = new String[100];
  }
  
  /**
   * Execute the query 
   *
   * @return an array of staff Order Numbers
   **/
  public String[] exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM staff_order");

      int i=0;
      while (rs.next()) 
      {
	String sorder_no = rs.getString("sorder_no");      
	staffOrderData[i]= sorder_no;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println("An exception occurred in GetAllStaffOrdersQuery "+e);
    }       
    return(staffOrderData);   
  }
}

  

package I;
import java.sql.*;
import java.util.ArrayList;


/**
 * CDSearchQuery
 *
 * Used by EditStockUI, inputs artist and cd name returns an array of both
 * stock and cd information.
 * 
 **/
public class GetAllStaffOrdersQuery
{
  private Connection c;
  private String[] staffOrderData;

  public GetAllStaffOrdersQuery()
  {
    c = MyConnection.C;
    staffOrderData = new String[100];
  }
 
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
	//String sid = rs.getString("sid");
	//String sorder_date = rs.getString("sorder_date");
	//String supid = rs.getString("supid");
	//String rowData= (sorder_no+"-"+sid+"-"+sorder_date+"-"+supid);      
	staffOrderData[i]= sorder_no;
	i++;
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetAllStaffOrdersQuery " + e);
    }
        
    return(staffOrderData);
    
  }
}

  

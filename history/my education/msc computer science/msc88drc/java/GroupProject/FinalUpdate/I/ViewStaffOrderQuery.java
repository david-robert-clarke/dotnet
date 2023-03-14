package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by ViewStaffOrderUI, inputs the staff order number and returns an 
   arraylist containing staff order details

   @author David Clarke 
 **/
public class ViewStaffOrderQuery
{
  private Connection c;
  private String sorder_no;
  private ArrayList staffOrder;

  /**
   * Constructor to create a new staff order query details viewer
   *
   * @param sOrderNo the artist name
   **/
  public ViewStaffOrderQuery(String sOrderNo)
  {      
    c = MyConnection.C; 
    sorder_no = sOrderNo;
    staffOrder = new ArrayList();
  }

  /**
   * Execute the query
   * 
   * @return an arraylist of staff order details
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs0 = stmt.executeQuery("SELECT sod.sorder_no, sid, " +
					"sorder_date, supid, iid, sno_bought "+
					"FROM staff_order AS so, "+
					"sorder_details AS sod "+
					"WHERE so.sorder_no=sod.sorder_no AND"+
					" sod.sorder_no ='" + sorder_no + "'");
        
      while (rs0.next())
      {
	staffOrder.add(rs0.getString("sorder_no"));
	staffOrder.add(rs0.getString("sid"));
	staffOrder.add(rs0.getString("sorder_date"));
	staffOrder.add(rs0.getString("supid"));
	staffOrder.add(rs0.getString("iid"));
	staffOrder.add(rs0.getString("sno_bought"));
      }
    }
    catch (SQLException e)
    {
      System.out.println( "An exception occurred in ViewStaffOrderQuery. "+ e);
    }
    return staffOrder;
  }
}

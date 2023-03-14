package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by StaffUI, allows the user to view the sales profiles of individual
   products

   @author David Clarke
 **/
public class IProductSalesProfileQuery
{
  private Connection c;
  private String iid;
  private ArrayList salesProfiles;
  
  /**
   * Constructor to create a new product item sales profile query
   *
   * @param theDate the current date
   **/
  public IProductSalesProfileQuery(String theiid)
  {
    c = MyConnection.C;
    iid = theiid;
    salesProfiles = new ArrayList();
  }

  /**
   * Execute the query
   * 
   * @return an arraylist containing the sales profile 
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs 
	= stmt.executeQuery("SELECT DISTINCT cd.iid, st.w_price, " +
			    "cu.corder_date, co.cno_bought "+
			    "FROM cd as cd, customer_order as cu, " +
			    "corder_details as co, stock as st "+
			    "WHERE co.iid = cd.iid AND cd.iid = st.iid AND "+
			    "cd.iid = '" + iid + "'");
      

      String title =("Product Sales Profile of item ID: " + iid);
      String underline =("--------------------------------");
      String heading0 = "  iid   | w_price | corder_date | cno_bought ";
      String heading1 = "--------+---------+-------------+------------";
      String a,b,c,d;
      String rowData;

      salesProfiles.add(title);
      salesProfiles.add(underline);
      salesProfiles.add(heading0);
      salesProfiles.add(heading1);

      while(rs.next())
      {
	a = rs.getString("iid");
	b = rs.getString("w_price");
	c = rs.getString("corder_date");
	d = rs.getString("cno_bought");
	rowData = " "+a+"      "+b+"     "+c+"          "+d+"     ";
	salesProfiles.add(rowData);
      }

      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in ProductSalesProfileQuery. "
			  + e);
    }        
    return(salesProfiles);
  }

}

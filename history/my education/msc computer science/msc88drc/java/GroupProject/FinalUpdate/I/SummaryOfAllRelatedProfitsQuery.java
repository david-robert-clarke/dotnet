package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by EditStockUI, retrieves data used to give a summary of all sales 
   from a given time period
 **/
public class SummaryOfAllRelatedProfitsQuery
{
  private Connection c;
  private String date;
  private String profitString;
  
  /**
   * Constructor to create a new sales profits query
   *
   * @param theDate the current date
   **/
  public SummaryOfAllRelatedProfitsQuery(String theDate)
  {
    c = MyConnection.C;
    date = theDate;
    profitString = "";    
  }

  /**
   * Execute the query
   * 
   * @return a string giving details of all related profits
   **/
  public String exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs 
	= stmt.executeQuery("SELECT SUM(st.w_price) AS wholesale," +
			    "SUM(cd.r_price) AS retail " +
			    "FROM cd as cd, customer_order as cu, "+
			    "corder_details as co, stock as st "+
			    "WHERE co.iid = cd.iid AND "+
			    "co.corder_no = cu.corder_no AND "+
			    "cd.iid = st.iid AND " +
			    "cu.corder_date > '" + date +"'");

      
      String title =("Summary of all related profits after " + date + 
	" to the present day = £");
      String a = "";
      String b = "";
      double wholeSalePrice = 0.0;
      double retailPrice = 0.0;
      double profit = 0.0;

      while(rs.next())
      {
	a = rs.getString("wholesale");
	b = rs.getString("retail");	
	
      }
      
      if(a != null)
      {      
	wholeSalePrice = (double)Float.parseFloat(a);
	retailPrice  = (double)Float.parseFloat(b);
	profit = retailPrice - wholeSalePrice;
      }
      else
      {
	profit = 0.0;
      }
      
      profitString = title + profit;
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in SummaryOfAllSalesQuery. " 
			  + e);
    }        
    return(profitString);
  }
}

package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * SQL Query
 *
 * 
 * Retrieves data used to give a summary of all sales from a given time period
 **/
public class SummaryOfAllRelatedProfitsQuery
{
  private Connection c;
  private String date;
  private String profitString;
  

  public SummaryOfAllRelatedProfitsQuery(String theDate)
  {
    c = MyConnection.C;
    date = theDate;
    profitString = "";
    
  }

  // the first method returns a String, the first name of the staff member
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

    // now round result to a maximum of two decimal places
    String roundedString = profitString;
    for (int i=0; i<profitString.length(); i++)
    {
      if (profitString.charAt(i) == '.')
      {
        if ((i+3) > profitString.length())
	  roundedString = profitString.substring(0,profitString.length());
          // this prevents index out of bounds error if
          // profitString has only one decimal place
	else
          // remove any excess characters in the string that are
          // more than two spaces away from the decimal point
	  roundedString = profitString.substring(0,i+3);
      }
    }        
    return(roundedString);
  }

}

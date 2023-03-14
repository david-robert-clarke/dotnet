package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 Used by the staff user interface, returns a summary of all sales from a 
 given time period.

 **/
public class SummaryOfAllSalesQuery
{
  private Connection c;
  private String date;
  private ArrayList summary;

  public SummaryOfAllSalesQuery(String theDate)
  {
    c = MyConnection.C;
    date = theDate;
    summary = new ArrayList();
  }

  
  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs 
	= stmt.executeQuery("SELECT DISTINCT co.corder_no,co.iid,st.w_price,"+ 
                             "cd.r_price,co.cno_bought,cu.corder_date "+
                             "FROM corder_details as co,customer_order as cu,"+
                             "cd as cd, stock as st "+
                             "WHERE co.iid=cd.iid AND "+
			     "co.corder_no=cu.corder_no "+ 
                             "AND co.iid = st.iid AND corder_date >'" +
			     date + "'");

      
      String title ="Summary of all sales after " + date;
      String line = "--------------------------------------------------";
      String heading1 = "corder_no |  iid   | w_price | r_price | cno_bought |"
	+" corder_date";
      String heading2 = "-----------+--------+---------+---------+------------"
	+"+-------------";
      

      summary.add(title);
      summary.add(line);
      summary.add(heading1);
      summary.add(heading2);

      while(rs.next())
      {
	String a = rs.getString("corder_no");
	String b = rs.getString("iid");
	String c = rs.getString("w_price");
	String d = rs.getString("r_price");
	String e = rs.getString("cno_bought");
	String f = rs.getString("corder_date");
	String theSummary = (a+"    "+b+"     "+c+"     "+d+"           "+e
			     +"       "+f);
	summary.add(theSummary);
      }
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in SummaryOfAllSalesQuery. " 
			  + e);
    }        
    return(summary);
  }

}

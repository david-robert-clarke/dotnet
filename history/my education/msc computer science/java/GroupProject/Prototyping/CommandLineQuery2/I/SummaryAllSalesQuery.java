package I;
import java.sql.*;
import java.util.ArrayList;

/**
 * SQL Query
 *
 * 
 **/
public class SummaryAllSalesQuery
{
    private Connection c;
    private String date;

    public SummaryAllSalesQuery(String d)
    {      
        c = MyConnection.C;
        date = d;
    }

    public void exeQuery()
    {
        try 
            {	
	Statement stmt = c.createStatement();
	ResultSet rs 
   = stmt.executeQuery("SELECT co.corder_no,co.iid,st.w_price," +
	       "cd.r_price,co.cno_bought,cu.corder_date "+
	       "FROM corder_details as co, customer_order "+
	       "as cu, cd as cd, stock as st WHERE co.iid=cd.iid AND " +
	       "co.corder_no=cu.corder_no AND co.iid = st.iid "+
	       "AND corder_date > '" + date + "'" );
	while(rs.next())
	    {
	        String corder_no = rs.getString("corder_no");
	        String iid = rs.getString("iid");
	        String w_price = rs.getString("w_price");

	        System.out.println(corder_no);
	        System.out.println(iid);
	        System.out.println(w_price);
	    }
		        
	
            } 
        catch (SQLException e) 
            {
	System.out.println( "An exception occurred in AddTupleQuery. " + e);
            }
    }
}

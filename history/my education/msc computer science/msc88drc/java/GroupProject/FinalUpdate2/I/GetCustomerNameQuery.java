package I;
import java.sql.*;
import java.util.*;


/**
  Used by staffUI, gets a list of all customer's last names

  @author Helen Loynes
 **/
public class GetCustomerNameQuery
{
  private Connection c;
  private ArrayList customer;

  /**
   * Constructor to create a get customer name query
   **/
  public GetCustomerNameQuery()
  {
    c = MyConnection.C;
  }

  /**
   * Execute the Query  
   *
   * @return an arraylist of customer names
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      customer = new ArrayList();
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

      while (rs.next())
      {
	String ci = rs.getString("cid");
	String cl = rs.getString("clastname");
	customer.add(ci + "-" + cl);
      }
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in GetCustomerNames. " + e);
    }
        
    return(customer);
  }
}


  
  

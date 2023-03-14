package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 Used by EditStockUI, inputs artist and cd name returns an array of both
 stock and cd information.

 @author David Clarke
 **/
public class GetStockDetailsQuery
{
  private String artist;
  private String cdName;
  private String iid;
  private String sup_name, w_price;
  private ArrayList stockArrayList;
  private Connection c;

  /**
   * Constructor to create a new get stock details query
   *
   * @param a the artist name
   * @param cd_n the cd name
   **/
  public GetStockDetailsQuery(String a, String cd_n)
  {      
    artist = a;
    cdName = cd_n;
    sup_name ="";
    c = MyConnection.C;
    stockArrayList = new ArrayList();
  }

  /**
   * Execute the query
   * 
   * @return an arraylist of stock details
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      Statement stmt1 = c.createStatement();
      ResultSet rs0 = stmt.executeQuery("SELECT iid FROM cd WHERE artist = '" +
		        artist + "' AND cd_name ='" + cdName 
		        +"'");
      while (rs0.next())
      {
	iid = rs0.getString("iid");
      }
      
      
      ResultSet rs1 =stmt.executeQuery("SELECT * FROM stock WHERE iid='"+
				       iid+"'");
      while(rs1.next())
      {
	String supid = rs1.getString("supid");
	ResultSet rs2 = stmt1.executeQuery("SELECT * FROM supplier WHERE " + 
					  "supid ='"+supid+"'");
	while(rs2.next())
	{
	  sup_name = rs2.getString("sup_name");
	}

	String stock_level = rs1.getString("stock_level");
	String w_price = rs1.getString("w_price");
	
	stockArrayList.add(sup_name);
	stockArrayList.add(supid);
	stockArrayList.add(stock_level);
	stockArrayList.add(w_price);
	stockArrayList.add(iid);
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in ViewStockLevelQu. " + e);
    }
        
    return(stockArrayList);
  } 
}

package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * CDSearchQuery
 *
 * Used by EditStockUI, inputs artist and cd name returns an array of both
 * stock and cd information.
 * 
 **/
public class CDSearchQuery
{
  private String artist;
  private String cdName;
  private String iid;
  private String sup_name;
  private ArrayList cdArrayList, stockArrayList;
  private Connection c;

  public CDSearchQuery(String a, String cd_n)
  {      
    artist = a;
    cdName = cd_n;
    c = MyConnection.C;
    cdArrayList = new ArrayList();
    stockArrayList = new ArrayList();
  }

  /**
   * Return an arraylist of cd details such as
   * <ul>
   * <il>artist
   * <il>cd_name
   * <il>retail_price
   * </ul>
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      ResultSet rs0 = stmt.executeQuery("SELECT iid FROM cd WHERE artist = '" +
		        artist + "' AND cd_name ='" + cdName 
		        +"'");    
      while (rs0.next())
      {
	iid = rs0.getString("iid");
      }
      
      
      ResultSet rs1 =stmt.executeQuery("SELECT * FROM cd WHERE iid='"+iid+"'");
      while(rs1.next())
      {
	cdArrayList.add(rs1.getString("cd_name"));
	cdArrayList.add(rs1.getString("artist"));
	cdArrayList.add(rs1.getString("r_price"));
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in CDSearch. " + e);
    }
        
    return(cdArrayList);
  }
  
}

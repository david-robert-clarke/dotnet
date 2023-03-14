package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * SQL Query
 *
 * 
 **/
public class CDSearch
{
  private String theArtist;
  private String theCD_name;
  private ArrayList cdArrayList;
  private Connection theConnection;

  public CDSearch(String a, String cd_n)
  {      
    theArtist = a;
    theCD_name = cd_n;
    theConnection = MyConnection.C;
    cdArrayList = new ArrayList();
  }

  public ArrayList exeQuery()
  {
    try 
    {
      // Create a result set containing all data from my_table
      Statement stmt = theConnection.createStatement();
      String q1 = "SELECT iid,cd_name,artist,genre,type,release_date,r_price ";
      String q2 = "FROM cd ";
      String q3 = "WHERE artist = '";
      String q4 = "'";
      String q5	= " AND cd_name = '";
      String q6 = "'";
    
      ResultSet rs = stmt.executeQuery(q1 + q2 + q3 + 
				       theArtist + 
				       q4 + q5 +
				       theCD_name 
				       + q6);

      while (rs.next()) 
      {
	String iid = rs.getString("iid");
	String artist = rs.getString("artist");
	String cd_name = rs.getString("cd_name");
	String genre = rs.getString("genre");
	String type = rs.getString("type");
	Date date = rs.getDate("release_date");
	float rp = rs.getFloat("r_price");
	String retail_price = (rp + "");

	cdArrayList.add(iid);
	cdArrayList.add(artist);
	cdArrayList.add(cd_name);
	cdArrayList.add(genre);
	cdArrayList.add(type);
	cdArrayList.add(date);
	cdArrayList.add(retail_price);
      }	
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in CDSearch. " + e);
    }
        
    return(cdArrayList);
  }
}

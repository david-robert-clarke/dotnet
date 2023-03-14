package I;
import java.sql.*;
import java.util.ArrayList;

/**
   Used by the StaffUI, this JDBC query deletes the specified cd from
   the database
   
   @author David Clarke  
**/
public class DeleteCDTupleQuery
{
  private ArrayList cd;
  private String iid;
  private Connection c;

  /**
   * Constructor to create a new delete cd tuple query
   *
   * @param cdEntry an arraylist containing all the cd data
   **/
  public DeleteCDTupleQuery(ArrayList cdEntry)
  { 
    cd = cdEntry;
    c  = MyConnection.C;
  }
 
  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {
      String cdName = (String)cd.get(1);
      String artist = (String)cd.get(2);
      
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT iid FROM cd WHERE artist ='" 
				       + artist +"' AND cd_name = '" + 
				       cdName + "'");

      while(rs.next())
      {
	iid = rs.getString("iid");
      }
      int deleteCount0 = stmt.executeUpdate("DELETE FROM cd " +
					    "WHERE iid ='" + iid + "'");
      int deleteCount1 = stmt.executeUpdate("DELETE FROM stock " +
					    "WHERE iid ='" + iid + "'");
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DelQuery. " + e);
    }
  }
}

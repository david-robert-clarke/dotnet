package I;
import java.sql.*;

/**
 * SQL Query
 *
 * 
 **/
public class DeleteCDTupleQuery
{
  private String artist;
  private String cdName;
  private String iid;
  private Connection c;

  public DeleteCDTupleQuery(String a, String cd_n)
  {      
    artist = a;
    cdName = cd_n;
    c  = MyConnection.C;
  }

  public void exeQuery()
  {
    try 
    {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT iid FROM cd WHERE artist ='" 
				       + artist +"' AND cd_name = '" + 
				       cdName + "'");

      while(rs.next())
      {
	iid = rs.getString("iid");
      }
      
      System.out.println("The iid of the item to be deleted is: " + iid);
      int deleteCount0 = stmt.executeUpdate("DELETE FROM cd " +
					    "WHERE iid ='" + iid + "'");
      int deleteCount1 = stmt.executeUpdate("DELETE FROM stock " +
					    "WHERE iid ='" + iid + "'");

      
      System.out.println("No.of Entries del from cd Table:" + deleteCount0);
      System.out.println("No.of Entries del from stock Table:" + deleteCount1);
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in DelQuery. " + e);
    }
  }
}

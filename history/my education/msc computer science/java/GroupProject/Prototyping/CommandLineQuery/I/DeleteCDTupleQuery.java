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
	int deleteCount = stmt.executeUpdate("DELETE FROM cd " +
			 "WHERE artist = '" + artist +
			 "' AND cd_name = '" + cdName +
			 "'");
	System.out.println("Deleted :" + deleteCount);	
            } 
        catch (SQLException e) 
            {
	System.out.println( "An exception occurred in DelQuery. " + e);
            }
    }
}

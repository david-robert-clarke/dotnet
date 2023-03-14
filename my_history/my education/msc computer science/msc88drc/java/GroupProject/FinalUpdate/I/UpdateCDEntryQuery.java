package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
   Used by EditStockUI, inputs an arraylist of cd data, updates the cd
   entry, returns an arrayList of the updated stock entry details

   @author David Clarke 
 **/
public class UpdateCDEntryQuery
{
  private ArrayList cdArrayList;
  private Connection theConnection;
  private String itemID;
  private String cdName;
  private String artist;
  private String genre;
  private String type;
  private String releaseDate;
  private String rPrice;

  /**
   * Constructor to create a new cd update query
   *
   * @param cd the cd details
   **/
  public UpdateCDEntryQuery(ArrayList cd)
  {      

    theConnection = MyConnection.C;
    cdArrayList = cd;
  }

  /**
   * Execute the query
   * 
   * @return an arraylist of updated cd details
   **/
  public ArrayList exeQuery()
  {
    try 
    {
      itemID = (String)cdArrayList.get(0);
      cdName = (String)cdArrayList.get(1);
      artist = (String)cdArrayList.get(2);
      genre  = (String)cdArrayList.get(3);
      type = (String)cdArrayList.get(4);
      releaseDate = (String)cdArrayList.get(5);
      rPrice = (String)cdArrayList.get(6);

      // Create a result set containing all data from my_table
      Statement stmt = theConnection.createStatement();
      
      String updateString = "UPDATE cd " +
	"SET cd_name = '" + cdName + "', " +
	"artist = '" + artist + "', " +
	"genre ='" + genre + "', " +
	"type ='" + type + "', " +
	"release_date ='" + releaseDate + "', " +
	"r_Price ='" + rPrice + "' " +
	"WHERE iid = '" + itemID + "'";

      stmt.executeUpdate(updateString);
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
    }     
    return(cdArrayList);
  }
}

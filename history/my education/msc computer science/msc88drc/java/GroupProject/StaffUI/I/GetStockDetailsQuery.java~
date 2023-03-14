package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * ViewStockLevelQuery
 *
 * Used by EditStockUI, inputs artist and cd name returns an array of both
 * stock and cd information.
 * 
 **/
public class ViewStockLevelQuery
{
  private String artist;
  private String cdName;
  private String iid;
  private String sup_name;
  private ArrayList cdArrayList, stockArrayList;
  private Connection c;

  public ViewStockLevelQuery(String a, String cd_n)
  {      
    artist = a;
    cdName = cd_n;
    sup_name ="";
    c = MyConnection.C;
    cdArrayList = new ArrayList();
  }

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

      String title ="These are the stock levels for cd title '"+ cdName + "'.";
      String line = "--------------------------------------------------";
      cdArrayList.add(title);
      cdArrayList.add(line);

      while (rs0.next())
      {
	iid = rs0.getString("iid");
	System.out.println(iid);
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
	
	//calculate spaces for list alignment
	System.out.println(sup_name);
	int noOfChars = sup_name.length();
	int noOfSpaces = (30 - noOfChars);
	String blankSpaces = "";

	for(int i=0; i<noOfSpaces; i++)
	{
	  blankSpaces += " ";
	}
	
	cdArrayList.add(sup_name + blankSpaces + stock_level);
	
      }
      
      
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in ViewStockLevelQu. " + e);
    }
        
    return(cdArrayList);
  } 
}

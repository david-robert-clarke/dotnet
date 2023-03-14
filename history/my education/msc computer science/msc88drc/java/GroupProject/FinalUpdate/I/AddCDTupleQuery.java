package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

/**
  Used by AddStockUI, inserts a new cd into the cd table
 
  @author David Clarke
**/
public class AddCDTupleQuery
{
  private JFrame frame;
  private Connection c;
  private Connection cZhong;//extra
  private String iid,cdName,artist,genre,type,releaseDate,rPrice;
  private String sup_name,stock_level,w_price,supid;

  /**
   * Constructor to create a new add cd tuple query
   *
   * @param cdInformation an arraylist containing cd details
   **/
  public AddCDTupleQuery(ArrayList cdInformation)
  {      
    c = MyConnection.C;
    cZhong = MyConnectionPhil.philC;//extra
    iid = "";
    cdName = (String)cdInformation.get(0);
    artist = (String)cdInformation.get(1);
    genre = (String)cdInformation.get(2);
    type = (String)cdInformation.get(3);
    releaseDate = (String)cdInformation.get(4);
    rPrice = (String)cdInformation.get(5);
    sup_name = (String)cdInformation.get(6);
    stock_level = (String)cdInformation.get(7);
    w_price = (String)cdInformation.get(8);
    supid = "";
  }

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {
      //ADDITIONAL FOR QUERYING ZHONG'S DATABASE
      Statement stmtZhong = cZhong.createStatement();
      Statement stmtZhong2 = cZhong.createStatement();
      Statement stmtZhong3 = cZhong.createStatement();
     

	
      Statement stmt = c.createStatement();
      //Initially retrieve the supplierID for the given supplierName
      ResultSet rsX = stmt.executeQuery("SELECT supid FROM supplier"+
					" WHERE sup_name ='"+
					sup_name +"'");
      while (rsX.next()) 
      {
	// Get the data from the row using the column name
	supid = rsX.getString("supid");
      }
	
      //Use the cdName, artist and supID fields to find out if a
      //row is present for the query
      ResultSet rs0 = stmt.executeQuery("SELECT * FROM cd, stock "+
					"WHERE cd.iid = stock.iid "+
					"AND cd_name ILIKE '"+cdName+"'"+
					"AND artist ILIKE '"+artist+"'"+
					"AND supid ILIKE'"+supid+"'");

      boolean rowPresent = rs0.first();

      //if rows are present
      if(rowPresent)
      {
	//Throw an exception, cannot add the same row again 
	JOptionPane.showMessageDialog(frame,"ERROR: Cannot add the same cd item more than once");
      }
      else
      {
	//if there are rows existing for a query 
	ResultSet rs1 = stmt.executeQuery("SELECT * FROM cd "+
					  "WHERE cd_name ='"+cdName+"'"+
					  "AND artist ='"+artist+"'");

	//find item id of queried cds
	while(rs1.next())
	{
	  iid = rs1.getString("iid");
	  System.out.println(iid);
	}

	//if cdName and artist are present
	boolean rowPresent1 = rs1.first();

	if(rowPresent1)
	{
	  //if cd is present, but the supplier provided is 
	  //different then find the supplier for that cd, then
	  //update the stock table
	  stmt.executeUpdate("INSERT INTO stock VALUES ('" +
			     iid + "','"+
			     supid + "'," +
			     stock_level + "," +
			     w_price + ")");

	}
	else
	{
	  ResultSet rs2 = stmt.executeQuery("SELECT MAX(iid) " +
					    "FROM cd;");
	  String sIID ="";
		
	  while (rs2.next()) 
	  {
	    sIID = rs2.getString("max");//string item id
	  }
	  //calculates next iid       
	  int iIID = Integer.parseInt(sIID);//interger item id
	  int niIID = iIID + 1; //new item ID 
		
	  if(niIID < 10)
	  {
	    iid = "00000" + niIID;
	  }
	  else if(niIID < 100)
	  {
	    iid = "0000" + niIID;
	  }
	  else if(niIID < 1000)
	  {
	    iid = "000" + niIID;	
	  }
	  else if(niIID < 10000)
	  {
	    iid = "00" + niIID;
	  }
	  else if(niIID < 100000)
	  {
	    iid = "0" + niIID;	
	  }
	  else
	  {
	    iid = "" + niIID;
	  }
	
	  System.out.println("I'm Here!");
	
	  //add cd entry to lee's cd Table 
	  stmt.executeUpdate("INSERT INTO cd " + 
			     "VALUES ('" + iid + "','" + cdName + "','" +
			     artist + "','" + genre + "','" + type + "'," +
			     "DATE '" + releaseDate + "'," +  rPrice + ")");

	
	  //add cd entry to Zhong's product Table
	  stmtZhong.executeUpdate("INSERT INTO product VALUES (" + iid 
				  + ",'" + cdName + "','" +
				  artist + "'," + rPrice + ", DATE '" + 
				  releaseDate + "')");


	  //add entry to Zhong's category Table
	  ResultSet rsZhong = stmtZhong2.executeQuery("SELECT " + 
						      "MAX(category_id) " +
						      "FROM category;");
	  int catID = 0;
	  String category_id;
	  
	  while(rsZhong.next())
	  {
	    catID = rs2.getInt("max");
	  }
	  catID++; //add one tomax catID
	  System.out.println("This is the catID: " + catID);

	  category_id = catID + "";

	  System.out.println("BEFORE ZHONG 3");
	  
	  stmtZhong3.executeUpdate("INSERT INTO category VALUES (" 
				   + category_id + ",'" + genre + "')");

	  System.out.println("AFTER ZHONG 3");

	  //add stock entry
	  stmt.executeUpdate("INSERT INTO stock VALUES ('" +
			     iid + "','"+
			     supid + "'," +
			     stock_level + "," +
			     w_price + ")");
	  
	}
      }	
    } 
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in AddTupleQuery. " + e);
    }
  }
}    

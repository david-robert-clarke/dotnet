package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * SQL Query
 *
 * 
 **/
public class AddCDTupleQuery
{
    private Connection c;
    private String iid,cdName,artist,genre,type,releaseDate,rPrice;
    private String sup_name,stock_level,w_price,supid;

    public AddCDTupleQuery(ArrayList cdInformation)
    {      
        c = MyConnection.C;
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

    public void exeQuery()
    {
        try 
            {	
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
	
	System.out.println(supid + "\t" + artist + "\t" + cdName);
	
	//Use the cdName, artist and supID fields to find out if a
	//row is present for the query
	ResultSet rs0 = stmt.executeQuery("SELECT * FROM cd, stock "+
			  "WHERE cd.iid = stock.iid "+
			  "AND cd_name ='"+cdName+"'"+
			  "AND artist ='"+artist+"'"+
			  "AND supid ='"+supid+"'");

	boolean rowPresent = rs0.first();
	System.out.println("" + rowPresent);

	System.out.println("Got Here, which is nice");

	//if rows are present
	if(rowPresent)
	    {
	        //Throw an exception, cannot add the same row again 
	        System.out.println("Exception");
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
		else if(niIID < 99)
		    {
		        iid = "0000" + niIID;
		    }
		else if(niIID < 999)
		    {
		        iid = "000" + niIID;	
		    }
		else if(niIID < 9999)
		    {
		        iid = "00" + niIID;
		    }
		else if(niIID < 99999)
		    {
		        iid = "0" + niIID;	
		    }
		else
		    {
		        iid = "" + niIID;
		    }
		
		//add cd entry 
		stmt.executeUpdate("INSERT INTO cd " + 
		"VALUES ('" + iid + "','" + cdName + "','" +
	               artist + "','" + genre + "','" + type + "'," +
	               "DATE '" + releaseDate + "'," +  rPrice + ")");
		
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

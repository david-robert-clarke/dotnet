package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * SQL Query
 *
 * 
 **/
public class AddSupplierQuery
{
  private Connection c;
  private String supid, sup_name,sup_addr1,sup_addr2,sup_pcode,sup_phone;

  public AddSupplierQuery(ArrayList supplierInfo)
  {      
    c = MyConnection.C;    
    supid = "";
    sup_name = (String)supplierInfo.get(0);
    sup_addr1= (String)supplierInfo.get(1);
    sup_addr2 = (String)supplierInfo.get(2);
    sup_pcode = (String)supplierInfo.get(3);
    sup_phone = (String)supplierInfo.get(4);
  }

  public void exeQuery()
  {
    try 
    {	
      Statement stmt = c.createStatement();
      //Use the sup_name field to find out if a row is present for the query
      ResultSet rs0 = stmt.executeQuery("SELECT * FROM supplier "+
					"WHERE sup_name ='" + sup_name+"'");

      boolean rowPresent = rs0.first();
     
      if(rowPresent) //if rows are present
      {
	//Throw an exception, cannot add the same row again 
	System.out.println("Exception");
      }
      else //if not present
      {
	ResultSet rs1 = stmt.executeQuery("SELECT MAX(supid) " +
					  "FROM supplier;");
	String sSUPID ="";
	
	while (rs1.next()) 
	{
	  sSUPID = rs1.getString("max");//string item id
	}
	//calculates next iid       
	int iSUPID = Integer.parseInt(sSUPID);//interger item id
	int niSUPID = iSUPID + 1; //new item ID 
		
	if(niSUPID < 10)
	{
	  supid = "00000" + niSUPID;
	}
	else if(niSUPID < 99)
	{
	  supid = "0000" + niSUPID;
	}
	else if(niSUPID < 999)
	{
	  supid = "000" + niSUPID;	
	}
	else if(niSUPID < 9999)
	{
	  supid = "00" + niSUPID;
	}
	else if(niSUPID < 99999)
	{
	  supid = "0" + niSUPID;	
	}
	else
	{
	  supid = "" + niSUPID;
	}
	
	System.out.println("I'm Here!");
	
	//add supplier entry 
	stmt.executeUpdate("INSERT INTO supplier " + 
			   "VALUES ('" + supid + "','" + sup_name + "','" +
			   sup_addr1 + "','" + sup_addr2 + "','" + sup_pcode + 
			   "','" + sup_phone + "')");
	
      } 
    }
    
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in AddSupplierQuery. " + e);
    }
  }
}
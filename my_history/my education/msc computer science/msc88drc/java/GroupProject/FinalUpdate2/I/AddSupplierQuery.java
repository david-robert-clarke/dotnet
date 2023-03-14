package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

/**
  Used by AddSupplierUI, inserts a new supplier into the staff table
 
  @author David Clarke
**/
public class AddSupplierQuery
{
  private JFrame frame;
  private Connection c;
  private String supid, sup_name,sup_addr1,sup_addr2,sup_pcode,sup_phone;

  /**
   * Constructor to create a new add supplier query
   *
   * @param supplierInfo
   **/
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

  /**
   * Execute query
   **/
  public void exeQuery()
  {
    try 
    {	
      Statement stmt = c.createStatement();
      //Use the sup_name field to find out if a row is present for the query
      ResultSet rs0 = stmt.executeQuery("SELECT * FROM supplier "+
					"WHERE sup_name ILIKE '" +sup_name+"'");

      boolean rowPresent = rs0.first();
     
      if(rowPresent) //if rows are present
      {
	//Throw an exception, cannot add the same row again 
	JOptionPane.showMessageDialog(frame,"ERROR: Cannot add the same supplier more than once");
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
	else if(niSUPID < 100)
	{
	  supid = "0000" + niSUPID;
	}
	else if(niSUPID < 1000)
	{
	  supid = "000" + niSUPID;	
	}
	else if(niSUPID < 10000)
	{
	  supid = "00" + niSUPID;
	}
	else if(niSUPID < 100000)
	{
	  supid = "0" + niSUPID;	
	}
	else
	{
	  supid = "" + niSUPID;
	}
	
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

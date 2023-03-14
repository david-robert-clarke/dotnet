package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * SQL Query
 *
 * 
 **/
public class AddStaffQuery
{
  private Connection c;
  private String sid, sfirstname,slastname;
  private String staff_addr1,staff_addr2,staff_pcode,staff_phone, staff_mobphone;
  private String position, password;

  public AddStaffQuery(ArrayList staffInfo)
  {      
    c = MyConnection.C;    
    sid = "";
    sfirstname = (String)staffInfo.get(0);
    slastname = (String)staffInfo.get(1);
    staff_addr1 = (String)staffInfo.get(2);
    staff_addr2 = (String)staffInfo.get(3);
    staff_pcode = (String)staffInfo.get(4);
    staff_phone = (String)staffInfo.get(5);
    staff_mobphone = (String)staffInfo.get(6);
    position = (String)staffInfo.get(7);
    password = (String)staffInfo.get(8);
  }

  public void exeQuery()
  {
    try 
    {	
      Statement stmt = c.createStatement();
      //Use the staff_name field to find out if a row is present for the query
      ResultSet rs0 = stmt.executeQuery("SELECT * FROM staff "+
					"WHERE slastname ='" + slastname +"'AND sfirstname ='" 
					+ sfirstname + "'");

      boolean rowPresent = rs0.first();
     
      if(rowPresent) //if rows are present
      {
	//Throw an exception, cannot add the same row again 
	System.out.println("This person already exists");
      }
      else //if not present
      {
	ResultSet rs1 = stmt.executeQuery("SELECT MAX(sid) " +
					  "FROM staff;");
	String sSID ="";
	
	while (rs1.next()) 
	{
	  sSID = rs1.getString("max");//string item id
	}
	//calculates next iid       
	int iSID = Integer.parseInt(sSID);//interger item id
	int niSID = iSID + 1; //new item ID 
		
	if(niSID < 10)
	{
	  sid = "00000" + niSID;
	}
	else if(niSID < 99)
	{
	  sid = "0000" + niSID;
	}
	else if(niSID < 999)
	{
	  sid = "000" + niSID;	
	}
	else if(niSID < 9999)
	{
	  sid = "00" + niSID;
	}
	else if(niSID < 99999)
	{
	  sid = "0" + niSID;	
	}
	else
	{
	  sid = "" + niSID;
	}
	
	System.out.println("I'm Here!");
	
	//add staff entry 
	stmt.executeUpdate("INSERT INTO staff " + 
			   "VALUES ('" + sid + "','" + sfirstname + "','" +
			   slastname + "','" +  staff_addr1 + "','" + staff_addr2 + "','" 
			   + staff_pcode + "','" + staff_phone + "','" + staff_mobphone +
			   "','" + position + "','" + password + "')");
	
      } 
    }
    
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in AddStaffQuery. " + e);
    }
  }
}

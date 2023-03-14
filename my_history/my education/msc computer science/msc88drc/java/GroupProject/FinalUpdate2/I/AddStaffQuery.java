package I;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
  Used by AddStaffUI, inserts a new member of staff into the staff table
 
  @author Helen Loynes
**/
public class AddStaffQuery
{
  private Connection c;
  private String sid, sfirstname,slastname;
  private String staff_addr1,staff_addr2,staff_pcode,staff_phone;
  private String staff_mobphone;
  private String position, password;

  /**
   * Constructor to create a new add staff member query
   *
   * @param supplierInfo an arraylist containing staff details
   **/
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

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {
      //A check for repetitions is not performed when adding a new staff 
      //member. This is because people can exist with exactly the same 
      //attributes
      Statement stmt = c.createStatement();
      
	ResultSet rs1 = stmt.executeQuery("SELECT MAX(sid) " +
					  "FROM staff;");
	String sSID ="";
	
	while (rs1.next()) 
	{
	  sSID = rs1.getString("max");//string item id
	}
	//calculates next iid       
	int iSID = Integer.parseInt(sSID);//integer item id
	int niSID = iSID + 1; //new item ID 
		
	if(niSID < 10)
	{
	  sid = "00000" + niSID;
	}
	else if(niSID < 100)
	{
	  sid = "0000" + niSID;
	}
	else if(niSID < 1000)
	{
	  sid = "000" + niSID;	
	}
	else if(niSID < 10000)
	{
	  sid = "00" + niSID;
	}
	else if(niSID < 100000)
	{
	  sid = "0" + niSID;	
	}
	else
	{
	  sid = "" + niSID;
	}
	
	//add staff entry 
	stmt.executeUpdate("INSERT INTO staff " + 
			   "VALUES ('" + sid + "','" + sfirstname + "','" +
			   slastname + "','" +  staff_addr1 + "','" + staff_addr2 + "','" 
			   + staff_pcode + "','" + staff_phone + "','" + staff_mobphone +
			   "','" + position + "','" + password + "')");            
    }
    
    catch (SQLException e) 
    {
      System.out.println( "An exception occurred in AddStaffQuery. " + e);
    }
  }
}

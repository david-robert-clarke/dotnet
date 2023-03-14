package I;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
   Used by EditStaffUI, inputs the staff name, updates a staff entry

   @author Helen Loynes
**/
public class UpdateStaffEntryQuery
{
  private ArrayList staffArrayList;
  private Connection c;
  private String sid;
  private String sfirstname;
  private String slastname;
  private String staff_addr1;
  private String staff_addr2;
  private String staff_pcode;
  private String staff_phone;
  private String staff_mobphone;
  private String position;
  private String password;

  /**
   * Constructor to create a new staff entry update 
   *
   * @param sOrderNo the artist name
   **/
  public UpdateStaffEntryQuery(ArrayList staff)
  {
    c = MyConnection.C;
    staffArrayList = staff;
  }

  /**
   * Execute the query
   **/
  public void exeQuery()
  {
    try 
    {      
      sid = (String)staffArrayList.get(0);
      sfirstname = (String)staffArrayList.get(1);
      slastname = (String)staffArrayList.get(2);
      staff_addr1= (String)staffArrayList.get(3);
      staff_addr2= (String)staffArrayList.get(4);
      staff_pcode= (String)staffArrayList.get(5);
      staff_phone= (String)staffArrayList.get(6);
      staff_mobphone= (String)staffArrayList.get(7);
      position= (String)staffArrayList.get(8);
      password= (String)staffArrayList.get(9);


      // Create a result set containing all data from my_table
      Statement stmt = c.createStatement();
      int number = stmt.executeUpdate("UPDATE staff SET sfirstname ='" + 
				      sfirstname + "', slastname ='" +
				      slastname + "', staff_addr1 ='" +
				      staff_addr1 + "', staff_addr2 ='" + 
				      staff_addr2 + "', staff_pcode ='" + 
				      staff_pcode + "', staff_phone ='" + 
				      staff_phone + "', staff_mobphone ='" + 
				      staff_mobphone + "', position = '" + 
				      position + "', password = '" +
				      password + "' WHERE sid = '" + 
				      sid + "'");
    } 
    catch (SQLException e) 
    {
      System.out.println("An exception occurred in UpdateStaffEntryQuery. "+e);
    }
  }
}

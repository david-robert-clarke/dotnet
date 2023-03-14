package I;
import java.sql.*;
import java.util.ArrayList;

class StaffPWUpdateQuery
{
    private Connection c;
    private String sid,password;

    public StaffPWUpdateQuery(String staffID, String pw)
    {
        c = MyConnection.C;
        sid = staffID;
        password = pw;        
    }
    public void exeQuery()
    {   
        try
            {
	Statement stmt = c.createStatement();
	stmt.executeUpdate("UPDATE staff SET password ='" + password +
		   "' WHERE sid ='" + sid + "'");

	System.out.println("Query Executed");
            } 
        catch (SQLException e) 
            {
	System.out.println( "An exception occurred in UpdateCDEntryQuery. " + e);
            }
    }
}

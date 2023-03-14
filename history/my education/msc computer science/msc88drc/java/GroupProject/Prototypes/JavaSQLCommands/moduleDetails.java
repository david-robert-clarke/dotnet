import java.sql.*;
import java.io.*;

class moduleDetails {
    
    public static void main (String args []) {

	// Variables used to connect to the database - 
	// change these to suit your MySQL database set up
  
	String user = "smx";
	String database = user;
	String password = "********";

	// Create the database
	try {
	    // WARNING - this will overwrite existing tables in the database
	    DatabaseBuilder.createDatabase(user, database, password);
	} catch (SQLException e) {
	    System.out.println("Failed to build database");
	    System.exit(1);
	}

	try {
	    // Load the MySQL JDBC driver
	    DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());

	    // Connect to the database
	    Connection conn =
		DriverManager.getConnection("jdbc:mysql://mysql.cs.nott.ac.uk/"+database, user, password);

	    UserInput.prompt("Code>");
	    String code = UserInput.readString();


	    // Query the database
	    Statement stmt = conn.createStatement();

	    if (code.equals("ALL")) {
		String query = "SELECT Code, Count(*) as count, Avg(Mark) as avg, max(Mark) as max, min(mark) as min FROM Grades GROUP BY Code";
		ResultSet rset = stmt.executeQuery(query);
		while (rset.next()) {
		    System.out.println(rset.getString("Code") + " " +
				       rset.getInt("Count") + " " +
				       Math.round(rset.getDouble("avg"))+" "+
				       rset.getInt("min") + " " +
				       rset.getInt("max"));
		}
	    } else {
		String query = "SELECT * FROM Modules WHERE Code = '" + code + "'";
		ResultSet rset = stmt.executeQuery(query);
	    
		if (rset.next()) {
		    // Do something with the current result
		    System.out.println (rset.getString("Code") + " " +
					rset.getString("Title"));
		    System.out.println ("Credits " + rset.getInt("Credits"));
		    query = "SELECT Count(*) as count, Max(mark) as max," +
			" Min(mark) as min, avg(mark) as avg FROM Grades" +
			" WHERE Code = '" + code + "'";
		    ResultSet rset2 = stmt.executeQuery(query);
		    rset2.next();
		    System.out.println("Students " + rset2.getInt("count"));
		    System.out.println("Marks " + rset2.getInt("min") + " " +
				       Math.round(rset2.getDouble("avg")) + " " + 
				       rset2.getInt("max"));
		    rset2.close();
		    query = "SELECT * FROM Students, Grades " +
			" WHERE Students.ID = Grades.ID " +
			" AND Grades.Code = '" + code + "'";
		    rset2 = stmt.executeQuery(query);
		    while (rset2.next()) {
			System.out.println(rset2.getString("Last") + ", " +
					   rset2.getString("First") + " " +
					   rset2.getInt("Mark"));
		    }
		    rset2.close();
		} else {
		    // No entry for it
		    System.out.println("Module '" + code+ "' not found");
		    System.out.println("The available modules are");
		    ResultSet rset2=stmt.executeQuery("SELECT * FROM Modules");
		    while(rset2.next()) {
			System.out.println(rset2.getString("Code"));
		    }
		    System.out.println("Or 'ALL' to show details of all modules");
		    rset2.close();
		}
		rset.close();
	    }
	    stmt.close();
	    conn.close();
         
	} catch (SQLException e) {
	    System.out.println("Problem reading database");
	}
    }
}

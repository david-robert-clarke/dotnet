import java.sql.*;
import java.io.*;

class readTable {
    
    public static void main (String args []) {

	// Variables used to connect to the database - 
	// change these to suit your MySQL database set up
	
	/**************************************************
	 * PUT YOUR MySQL USERNAME IN THIS STRING         *
	 * IT IS USUALLY THE SAME AS YOUR SCHOOL USERNAME *
	 **************************************************/
	String user = "smx";

	/**************************************************
	 * THE NAME OF THE MySQL DATABASE TO USE          *
	 * IT IS NORMALLY THE SAME AS YOUR MySQL USERNAME *
	 **************************************************/
	String database = user;

	/**************************************************
	 * PUT YOUR MySQL PASSWORD IN THIS STRING         *
	 * YOU WILL BE GIVEN THIS WHEN YOU CREATE YOUR    *
	 * MySQL ACCOUNT. YOU CAN CHANGE IT IN MySQL - IF *
	 * YOU DO YOU WILL NEED TO CHANGE IT HERE AS WELL *
	 **************************************************/
	String password = "********";

	// Create the database
	try {
	    // WARNING - this will overwrite existing tables in the database
	    DatabaseBuilder.createDatabase(user, database, password);
	} catch (SQLException e) {
	    // An SQLException is thrown when something goes wrong in MySQL
	    System.out.println("Failed to build database");
	    // If we can't make the database, there's no point in continuing
	    System.exit(1);
	}

	// Read the Students table
	try {
	    // Load the MySQL JDBC driver
	    DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());

	    // Connect to the database
	    Connection conn =
		DriverManager.getConnection("jdbc:mysql://mysql.cs.nott.ac.uk/"+database, user, password);

	    // Create an SQL statement object to pass queries to the DB
	    Statement stmt = conn.createStatement();

	    // A query to pass through to the database
	    /*************************************
             * PUT YOUR SQL QUERY IN THIS STRING *
	     *************************************/
	    String query = "SELECT * FROM Modules";

	    // Pass this through to the DB, storing a ResultSet
	    ResultSet rset = stmt.executeQuery(query);
	    
	    // Step through the result set, printing out the names
	    while (rset.next()) {
		// While there is still another result, print it out
		System.out.println (rset.getString("Code") + " - " + 
				    rset.getString("Name") + ": " +
				    rset.getInt("Credits"));
	    }

	    // close the result set, the statement and connection
	    rset.close();
	    stmt.close();
	    conn.close();
         
	} catch (SQLException e) {
	    // Again, an SQLException indicates a problem in MySQL
	    System.out.println("Problem reading database");
	}
    }
	

}

import java.sql.*;
import java.io.*;

class studentDetails {
    
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

      /****************************************
       * An example of how to read user input *
       ****************************************/
      String firstName, lastName;
      UserInput.prompt("Please enter the student's first name: ");
      firstName = UserInput.readString();
      UserInput.prompt("Please enter the student's last name: ");
      lastName = UserInput.readString();

      // Query the database
      Statement stmt = conn.createStatement();

      /**************************************
       * How to combine user input with SQL *
       **************************************/
      String query = 
	"SELECT * FROM Students, Modules, Grades" +
	" WHERE Students.ID = Grades.ID" +
	"   AND Modules.Code = Grades.Code" +
	"   AND First = '" + firstName + "'" +
	"   AND Last = '" + lastName + "'";

      ResultSet rset = stmt.executeQuery(query);
	    
      double totalMarks = 0;
      double totalCredits = 0;
      while (rset.next()) {
	// Do something with the current result
	System.out.println(rset.getString("Code") + " " + 
			   rset.getString("Credits") + " " + 
			   rset.getString("Mark"));
	totalMarks += rset.getInt("Mark") * rset.getInt("Credits");
	totalCredits += rset.getInt("Credits");
      }

      if (totalMarks != 0) {
	System.out.println("Average " + 
			   Math.round(totalMarks/totalCredits));
      } else {
	System.out.println("Student not found");
      }

      rset.close();
      stmt.close();
      conn.close();
         
    } catch (SQLException e) {
      System.out.println("Problem reading database");
    }
  }
}

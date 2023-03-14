import java.util.* ;
import java.io.* ;
import java.sql.* ;

public class Customer
{
    public static void main(String[] args)
    {
	Connection con ;
	PreparedStatement pstmt ;
	Statement stmt ;
	ResultSet rs ;

	// in a try block so that we can recover from errors
	try
	{
	    // Load in Database properties from file
	    Properties props = new Properties() ;
	    FileInputStream in = new FileInputStream("Database.Properties") ;
	    props.load(in) ;
	    
	    // load the JDBC driver
	    String drivers = props.getProperty("jdbc.drivers") ;
	    Class.forName(drivers) ;
	    
	    String database = props.getProperty("database.RHCShop") ;

	    // Get a database connection
	    con = DriverManager.getConnection(database) ;
	    
	    // Get a Statement object
	    stmt=con.createStatement() ;

	    // Execute a simple query
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;

	    // Execute a simple insert
	    int count = 0 ;
	    count = stmt.executeUpdate("INSERT INTO Customers " +
				       "(CustomerFirstName, CustomerLastName, CustomerAddress) " + 
				       "VALUES ('Tony', 'Blair', '10 Downing Street, London')") ;
	    System.out.println ("\nInserted " + count + " record(s) successfully\n") ;

	    // Show the results
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;
	    
	    // Execute a simple delete
	    count = stmt.executeUpdate("DELETE FROM Customers " +
				       "WHERE CustomerFirstName = 'Tony' " + 
				       "AND CustomerLastName = 'Blair'") ;
	    System.out.println ("\nDeleted " + count + " record(s) successfully\n") ;

	    // Show the results
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;

	    // Insert 2 records using a PreparedStatement
	    pstmt = con.prepareStatement("INSERT INTO Customers " +
					 "(CustomerFirstName, CustomerLastName, CustomerAddress) " +
					 "VALUES (?, ?, ?)") ;
	    pstmt.clearParameters() ;
	    pstmt.setString(1, "Joan") ;
	    pstmt.setString(2, "D'Arc") ;
	    pstmt.setString(3, "Tower of London") ;
	    count = pstmt.executeUpdate() ;
	    System.out.println ("\nInserted " + count + " record(s) successfully\n") ;

	    pstmt.clearParameters() ;
	    pstmt.setString(1, "John") ;
	    pstmt.setString(2, "D'Orc") ;
	    pstmt.setString(3, "Houses of Parliament, London") ;
	    count = pstmt.executeUpdate() ;
	    System.out.println ("\nInserted " +count + " record(s) successfully\n") ;

	    // Show the results
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;

	    // Delete the extra records
	    count = stmt.executeUpdate("DELETE FROM Customers " +
				       "WHERE CustomerLastName LIKE 'D''%'") ;
	    System.out.println ("\nDeleted " +count + " record(s) successfully\n") ;

	    // Show the results
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;

	    // Note that we need to close any open statements, or resultsets BEFORE
	    // turning autocommit off on any connection that we obtained those 
	    // statements or resultsets from.
	    pstmt.close() ;
	    stmt.close() ;

	    // Try a transaction: Turn off autocommit so that we can group multiple
	    // operations into each transaction
	    con.setAutoCommit(false) ;

	    

	    // Get a Statement object: we HAVE to create a new statement object to get
	    // the non-autocommit behavior
	    
	    pstmt = con.prepareStatement("INSERT INTO Customers (CustomerFirstName, " +
					 "CustomerLastName, CustomerAddress) VALUES (?, ?, ?)") ;
	    // an EXTRA level of try block so that we can handle roll backs
	    try
	    {
		pstmt.setString(1, "Jane") ;
		pstmt.setString(2, "D'Arc") ;
		pstmt.setString(3, "Tower of London") ;
		count = pstmt.executeUpdate() ;
		System.out.println ("\nTransactional insert: " + count + " record(s) successfully entered\n") ;
		
		pstmt.setString(1, "Jean") ;
		pstmt.setString(2, "D'Orc") ;
		pstmt.setString(3, "Houses of Parliament, London") ;
		count = pstmt.executeUpdate() ;
		System.out.println ("Transactional insert: " + count + " record(s) successfully entered\n") ;

		stmt=con.createStatement() ;

		rs = stmt.executeQuery("SELECT * FROM Customers") ;
		printResultSet(System.out, rs) ;
		rs.close() ;

		// Delete the extra records
		count = stmt.executeUpdate("DELETE FROM Customers WHERE CustomerLastName " +
					   "LIKE 'D''%'") ;
		System.out.println ("\nTransactional Delete: " + count + " record(s) successfully deleted\n") ;

		con.commit() ;
		// If we get to here, we have had a successful end of transaction
		// we could continue with more operations which would then be part of a new
		// transaction until the next commit or rollback
	    }
	    catch (Exception e)
	    {
		// if ANY exception has occurred, it could have messed up the transaction so we roll it back
		try
		{
		    con.rollback() ;
		}
		catch (SQLException ignored)
		{
		    // if something is so seriously wrong that rollback fails, then
		    // there is no longer much we can do: at this point we just want
		    // to forward the original exception on so that the normal code
		    // reports it in the normal way
		}
		throw e ;
	    }


	    // back to normal autocommit behaviour
	    con.setAutoCommit(true) ;

	    // Get a Statement object with autocommit behaviour
	    stmt=con.createStatement() ;

	    
	    // show the final results
	    rs = stmt.executeQuery("SELECT * FROM Customers") ;
	    printResultSet(System.out, rs) ;
	    rs.close() ;

	    stmt.close() ;
	    pstmt.close() ;
	    con.close() ;
	}
	catch (SQLException e)
	{
	    do
		System.out.println(e.getMessage()) ;
	    while ((e = e.getNextException()) != null) ;
	}
    	catch (Exception e)
	{
	    e.printStackTrace() ;
	}
    }

    private static void printResultSet(PrintStream out, ResultSet rs)
	throws SQLException
    {
	ResultSetMetaData rsmd = rs.getMetaData() ;
	int colCount = rsmd.getColumnCount() ;
	for (int i = 1 ; i <= colCount ; i++)
	{
	    if (i > 1)
		out.print(", ");
	    out.print(rsmd.getColumnLabel(i)) ;
	}
	out.println() ;
	while (rs.next())
	{
	    for (int i = 1 ; i <= colCount ; i++)
	    {
		if (i > 1)
		    out.print(", ");
		out.print(rs.getObject(i)) ;
	    }
	    out.println() ;
	}
	return ;
    }
}

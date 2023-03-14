package com.cdshop.customer;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.turbine.services.db.TurbineDB;
import org.apache.turbine.util.db.pool.DBConnection;
import org.apache.turbine.util.TurbineConfig;
import com.cdshop.exceptions.CustomerActivityException;
import java.sql.*;
import java.util.ResourceBundle;


/**
 * Implements the address portion of a customer or credit card record.
 * Both the Customer, Order and CreditCard object use this class to
 * store address-specific information.
 *
 * @author       zhao zhong
 */

public class Address implements Cloneable {

    private static ResourceBundle sql_bundle =
	ResourceBundle.getBundle("com.cdshop.customer.SQLQueries");

    protected int addressID;
    protected String firstName;
    protected String lastName;
    protected String street1;
    protected String street2;
    protected String city;
    protected String postalCode;

    /**
     * Returns the unique Address ID, which is an autoincrementing
     * database column used to uniquely identify each address record.
     *
     * @return the address ID
     **/

    public int getAddressID() {
	  return addressID;
    }

    /**
     * Sets the unique Address ID, which is an autoincrementing
     * database column used to uniquely identify each address record.
     *   
     * @param id the address ID
     **/

    public void setAddressID(int id) {
	  addressID = id;
    }

    /**
     * Returns the first name of the person at this address
     *
     * @return The first name as a String
     **/

    public String getFirstName() {
	  return firstName;
    }

    /**
     * Sets the first name of the person at this address
     *
     * @param name The first name as a String
     **/

    public void setFirstName(String name) {
	  firstName = name;
    }

    /**
     * Returns the last name of the person at this address
     *
     * @return The last name as a String
     **/

    public String getLastName() {
	  return lastName;
    }

    /**
     * Sets the last name of the person at this address
     *
     * @param name The last name as a String
     **/

    public void setLastName(String name) {
	  lastName = name;
    }

    /**
     * Returns the first line of the street address
     *
     * @return The first line as a String
     **/

    public String getStreet1 () {
	  return street1;
    }

    /**
     * Sets the first line of the street address
     *
     * @param street The first line as a String
     **/

    public void setStreet1(String street) {
	  street1 = street;
    }

    /**
     * Returns the second line of the street address
     *
     * @return The second line as a String
     **/

    public String getStreet2 () {
	  return street2;
    }

    /**
     * Sets the second line of the street address
     *
     * @param street The second line as a String
     **/

    public void setStreet2(String street) {
	  street2 = street;
    }

    /**
     * Returns the city of the address
     *
     * @return The city as a String
     **/

    public String getCity () {
	  return city;
    }

    /**
     * Sets the city of the address
     *
     * @param street The city as a String
     **/

    public void setCity(String c) {
	  city = c;
    }

    /**
     * Returns the postal code of the address
     *
     * @return The postal code as a String
     **/

    public String getPostalCode () {
	  return postalCode;
    }

    /**
     * Sets the postal code of the address
     *
     * @param street The postal code as a String
     **/

    public void setPostalCode(String pc) {
	  postalCode = pc;
    }

    private HashMap validationErrors = new HashMap();

    /**
     * Returns a validation error against a specific field.  If a field
     * was found to have an error during validating Address, the error message
     * can be accessed via this method.
     *
     * @param fieldname The bean property name of the field
     * @return The error message for the field or null if none is
     * present.
     **/

    public String getFieldError(String fieldname) {
	  return((String)validationErrors.get(fieldname));
    }
    
    /**
     * Sets the validation error against a specific field.  Used by
     * validating Address.
     *
     * @param fieldname The bean property name of the field
     * @param error The error message for the field or null if none is
     * present.
     **/

    public void addFieldError(String fieldname, String error) {
	  validationErrors.put(fieldname, error);
    }

    /**
     * Validates the various properties of the bean to make sure that
     * none of the required fields are blank.
     *
     * @return true if the values validated, otherwise
     * false
     **/

    public boolean validateAddress() {
	validationErrors.clear();
	boolean valid = true;
	if ((lastName == null) ||
	    (lastName.length() == 0)) {
	    addFieldError("lastName", "Last Name is required.");
	    valid = false;
	} 
	if ((firstName == null) ||
	    (firstName.length() == 0)) {
	    addFieldError("firstName", "First Name is required.");
	    valid = false;
	} 
	if ((street1 == null) ||
	    (street1.length() == 0)) {
	    addFieldError("street1", "Street Address is required.");
	    valid = false;
	} 
	if ((city == null) ||
	    (city.length() == 0)) {
	    addFieldError("city", "City is required.");
	    valid = false;
	} 
	if ((postalCode == null) ||
	    (postalCode.length() == 0)) {
	    addFieldError("postalCode", "Postal Code is required.");
	    valid = false;
	} 
	return valid;
    }

    /**
     * Given an address ID, returns a new Address object populated
     * from the database, or null if no such address exists.
     *
     * @param ID The unique ID of the address in the database
     * @return A populated Address object, or null if none found.
     * @throws CustomeryActivityException Thrown on database errors
     **/

    public static Address findAddress(int ID)
	throws CustomerActivityException {
	Address addr = null;
	    DBConnection dbConn = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new CustomerActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("addressQuery"));
		    pstmt.setInt(1, ID);
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
			addr = new Address();
			addr.setFirstName(rs.getString("FIRST_NAME"));
			addr.setLastName(rs.getString("LAST_NAME"));
			addr.setStreet1(rs.getString("STREET_1"));
			addr.setStreet2(rs.getString("STREET_2"));
			addr.setCity(rs.getString("CITY"));
			addr.setPostalCode(rs.getString("POSTAL_CODE"));
			addr.setAddressID(ID);
		    } else {
			System.out.println("Couldn't find record for Address");
		    }
		    rs.close();
		    pstmt.close();
		}
	    catch (Exception e)
		{
		    System.out.println("Error during findAddress");
		    throw new CustomerActivityException();
		}
	    finally
		{
		    try
			{
			    TurbineDB.releaseConnection(dbConn);
			}
		    catch (Exception e)
			{
			    System.out.println("Error during release connection");
			}
		}
	    return addr;
	}

	

    /**
     * Creates a new address in the database and sets the address ID
     * of the object to the newly created record's ID
     *
     * @throws CustomerActivityException Thrown if there is an error
     * inserting the record in the database.
     **/

    public void createAddress() 
	throws CustomerActivityException {
	    DBConnection dbConn = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new CustomerActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("addressInsert"));
		    pstmt.setString(1, getFirstName());
		    pstmt.setString(2, getLastName());
		    pstmt.setString(3, getStreet1());
		    pstmt.setString(4, getStreet2());
		    pstmt.setString(5, getCity());
		    pstmt.setString(6, getPostalCode());
		    pstmt.executeUpdate();
		    pstmt.close();
		    pstmt =
			dbConn.prepareStatement(sql_bundle.getString("addressID"));
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
			addressID = rs.getInt(1);
		    } else {
			System.out.println("Couldn't find record for new Address");
		    }
		    rs.close();
		    pstmt.close();
		}
	    catch (Exception e)
		{
		    System.out.println("Error during createAddress");
		    throw new CustomerActivityException();
		}
	    finally
		{
		    try
			{
			    TurbineDB.releaseConnection(dbConn);
			}
		    catch (Exception e)
			{
			    System.out.println("Error during release connection");
			}
		}
	}

    /**
     * Updates an address in the database.
     *
     * @throws CustomerActivityException Thrown if there is an error
     * updating the record in the database.
     **/

    public void updateAddress() 
	throws CustomerActivityException {
	    DBConnection dbConn = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new CustomerActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("addressUpdate"));
		    pstmt.setString(1, getFirstName());
		    pstmt.setString(2, getLastName());
		    pstmt.setString(3, getStreet1());
		    pstmt.setString(4, getStreet2());
		    pstmt.setString(5, getCity());
		    pstmt.setString(6, getPostalCode());
		    pstmt.setInt(7, getAddressID());
		    pstmt.executeUpdate();
		    pstmt.close();
		}
	    catch (Exception e)
		{
		    System.out.println("Error during updateAddress");
		    throw new CustomerActivityException();
		}
	    finally
		{
		    try
			{
			    TurbineDB.releaseConnection(dbConn);
			}
		    catch (Exception e)
			{
			    System.out.println("Error during release connection");
			}
		}
	}

    /**
     * Deletes an address from the database.
     *
     * @throws CustomerActivityException Thrown if there is an error
     * deleting the record in the database.
     **/

    public void deleteAddress() 
	throws CustomerActivityException {
	    DBConnection dbConn = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new CustomerActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("addressDelete"));
		    pstmt.setInt(1, getAddressID());
		    pstmt.executeUpdate();
		    pstmt.close();
		}
	    catch (Exception e)
		{
		    System.out.println("Error during deleteAddress");
		    throw new CustomerActivityException();
		}
	    finally
		{
		    try
			{
			    TurbineDB.releaseConnection(dbConn);
			}
		    catch (Exception e)
			{
			    System.out.println("Error during release connection");
			}
		}
    }

    /**
     * Returns a copy of the Address object
     *
     * @returns A duplicate of the object
     **/

    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }

}



package com.cdshop.product;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.turbine.services.db.TurbineDB;
import org.apache.turbine.util.db.pool.DBConnection;
import org.apache.turbine.util.TurbineConfig;
import com.cdshop.exceptions.ProductActivityException;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Product is used to hold the contents of CDs
 *
 * @author zhao zhong
 *
 **/
 
public class Product {
    private static ResourceBundle sql_bundle =
	ResourceBundle.getBundle("com.cdshop.product.SQLQueries");

    protected String CdId;
    protected String pTitle;
    protected String artist;
    protected float pPrice;
    protected java.sql.Date pPubDate;
    protected String pDescription;
    protected static HashMap products = new HashMap();

    /**
     * Returns the id number of cd .
     *
     * @return The id number of cd.
     **/
    public String getCdId() {
	  return CdId;
    }

    /**
     * Returns the title of cd.
     *
     * @return The title of cd.
     **/
    public String getTitle() {
	  return pTitle;
    }

    /**
     * Returns the artist of cd.
     *
     * @return The artist of cd.
     **/
    public String getArtist () {
	  return artist;
	}

    /**
     * Returns the price of cd..
     *
     * @return The price of cd.
     **/
    public float getPrice() {
	  return pPrice;
    }

    /**
     * Returns the Pubdate of cd.
     *
     * @return The pubdate of cd.
     **/
    public java.sql.Date getPubDate() {
	  return pPubDate;
    }

    /**
     * Returns the description of cd.
     *
     * @return The description of cd.
     **/
    public String getDescription() {
	  return pDescription;
    }
    
    /**
     * Sets the id number of cd.
     *
     * @param Id -The id number od CD.
     **/
    public void setCdId(String Id) {
	  CdId = Id;
    }

    /**
     * Sets the title of cd.
     *
     * @param Title- the title of cd.
     **/
    public void setTitle(String Title) {
	  pTitle = Title;
    }

    /**
     * Sets the artist of cd..
     *
     * @param Author- The artist od CD.
     **/
    public void setArtist (String Author) {
	  artist = Author ;
	}

    /**
     * Sets the price of cd.
     *
     * @param Price-the price of cd.
     **/
    public void setPrice(float Price) {
	  pPrice = Price;
    }

    /**
     * Sets the publish date of cd.
     *
     * @param PubDate - the publish date of cd.
     **/
    public void setPubDate(java.sql.Date PubDate) {
	  pPubDate = PubDate;
    }

    /**
     * Sets the Description of cd.
     *
     * @param Description- The Description od CD.
     **/
    public void setDescription(String Description) {
	  pDescription = Description;
    }

    /**
     * Given an id number of cd, returns a new product object populated
     * from the database, or null if no such id number exists.
     *
     * @param CdId The id number of cd in the database
     * @return A populated Product object, or null if none found.
     * @throws ProductActivityException Thrown on database errors
     **/
    public static Product findProduct(String CdId)
	throws ProductActivityException {
	    if (products.get(CdId) != null) {
		return (Product) products.get(CdId);
	    }
	    DBConnection dbConn = null;
	    Product prod = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new ProductActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("findQuery"));
		    pstmt.setString(1, CdId);
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
			prod = new Product();
			prod.setCdId(rs.getString("CD_ID"));
			prod.setTitle(rs.getString("TITLE"));
			prod.setArtist(rs.getString("ARTIST"));
			prod.setPrice(rs.getFloat("PRICE"));
			prod.setPubDate(rs.getDate("PUB_DATE"));
			prod.setDescription(rs.getString("DESCRIPTION"));
		    }
		    rs.close();
		    pstmt.close();
			products.put(CdId, prod);

		}
	    catch (Exception e)
		{
		    System.out.println("Error during findProduct,haha");
		    e.printStackTrace();
		    throw new ProductActivityException();
		}
	    finally
		{
		    try
			{
			    TurbineDB.releaseConnection(dbConn);
			}
		    catch (Exception e)
			{
			    System.out.println("Error during releaseConnection");
			}
		}
	    return prod;
	}

	public static void main(String[] args) {
	    TurbineConfig tc = new TurbineConfig("com/cdshop/props/",
						 "TurbineResources.properties");
	    tc.init();

	    try {
		Product p = 
		    findProduct("r00001");
		if (p != null) {
		    System.out.println("Good Test: Find Real Product");
		    System.out.println("Author string is: " + 
				       p.getArtist());
		    System.out.println("Price is " + p.getPrice()); 
		} else {
		    System.out.println("Failed Test: Find Real Product");
		}
	    } catch (Exception e) {
		System.out.println("Failed Test: Find Real Product");
		e.printStackTrace();
	    }
	    try {
		Product p = 
		    findProduct("5");
		if (p != null) {
		    System.out.println("Bad Test: Find Fake Product");
		} else {
		    System.out.println("Good Test: Find Fake Product");
		}
	    } catch (Exception e) {
		System.out.println("Failed Test: Find Fake Product");
		e.printStackTrace();
	    }
	}
}	


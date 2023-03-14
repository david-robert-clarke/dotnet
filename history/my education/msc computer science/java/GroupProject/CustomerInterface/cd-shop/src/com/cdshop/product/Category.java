package com.cdshop.product;

import java.util.Vector;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import org.apache.turbine.services.db.TurbineDB;
import org.apache.turbine.util.db.pool.DBConnection;
import org.apache.turbine.util.TurbineConfig;
import com.cdshop.exceptions.ProductActivityException;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Implements categories, which are collections of products.
 *
 * @author       zhao zhong
 */

public class Category  {
    private static ResourceBundle sql_bundle =
	ResourceBundle.getBundle("com.cdshop.product.SQLQueries");


    protected int pID;
    protected Product pFeaturedProduct;
    protected Vector pProducts = new Vector();
    protected String pName;
    protected static HashMap categories = new HashMap();

    /**
     * Returns the unique category ID
     *
     * @return the category ID
     **/

    public int getID() {
	  return pID;
    }

    /**
     * Sets the category ID
     *
     * @param ID - the category ID.
     **/
     
    private void setID(int ID) {
	  pID = ID;
    }

    /**
     * Returns the category name
     *
     * @return the category name
     **/

    public String getName() {
	  return pName;
    }

    /**
     * Sets the category name.
     *
     * @param name - the category name.
     **/
     
    private void setName(String Name) {
	  pName = Name;
    }

    /**
     * Returns the product which should be featured in a display page for this 
     * category.
     *
     * @return The featured product
     **/

    public Product getFeaturedProduct() {
	  return pFeaturedProduct;
    }

    /**
     * Sets the product which should be featured in a display page for this 
     * category.
     * @param Product - The featured product
     **/
    
    private void setFeaturedProduct(Product Product) {
	pFeaturedProduct = Product;
    }

    /**
     * Returns a vector containing all the products in this category.
     *
     * @return The products in a Vector
     **/

    public Vector getProducts() {
	  return pProducts;
    }

    /**
     * Sets products as a vector containing all the products in this category.
     * @param Products -a vector containing all the products in this category
     **/
    
    private void setProducts(Vector Products) {
	  pProducts = Products;
    }

    /**
     * Returns the categories as a Set
     *
     * @return The categories
     **/

    public static Set getCategories() {
	return categories.keySet();
    }

    /**
     * Returns a category, keyed by the category ID, or null if not found
     *
     * @param Id The ID of the category as an int
     * @return The category
     * @throws ProductActivityException Thrown on database errors
     **/

    public static Category findCategoryById(int Id) throws ProductActivityException {
	loadAllCategories();
	Iterator it = getCategories().iterator();

	while (it.hasNext()) {
	    Category c = findCategory((String)it.next());
	    if (c.getID() == Id) return c;
	}
	return null;
    }

    /**
     * Returns a category, keyed by the category name, or null if not found
     *
     * @param Name The name of the category as a string
     * @return The category
     * @throws ProductActivityException Thrown on database errors
     **/

    public static Category findCategory(String Name)
	throws ProductActivityException {
	    if (categories.get(Name) != null) {
		return (Category) categories.get(Name);
	    }
	    DBConnection dbConn = null;
	    Category cat = null;
	    try
		{
		    dbConn = TurbineDB.getConnection();
		    if (dbConn == null) {
			System.out.println("Can't get database connection");
			throw new ProductActivityException();
		    }
		    PreparedStatement pstmt =
			dbConn.prepareStatement(sql_bundle.getString("findCatQuery"));
		    pstmt.setString(1, Name);
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
			cat = new Category();
			cat.setName(rs.getString("CATEGORY_NAME"));
			cat.setID(rs.getInt("CATEGORY_ID"));
			String feat = rs.getString("FEATURED_PRODUCT");
			if (!rs.wasNull()) {
			    cat.setFeaturedProduct(Product.findProduct(feat));
			}
		    }
		    rs.close();
		    pstmt.close();
		    if (cat != null) {
			pstmt =
			    dbConn.prepareStatement(sql_bundle.getString("catProdQuery"));
			pstmt.setInt(1, cat.getID());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cat.getProducts().add(Product.findProduct(rs.getString("CD_ID")));
			}
			rs.close();
			pstmt.close();
			categories.put(Name, cat);
		    }
		    
		}
	    catch (Exception e)
		{
		    System.out.println("Error during findCategory");
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
	    return cat;
	}

    static boolean allLoaded = false;

    public static void loadAllCategories()
	throws ProductActivityException {
	if (allLoaded) return;
	allLoaded = true;
	DBConnection dbConn = null;
	Category cat = null;
	try
	    {
		dbConn = TurbineDB.getConnection();
		if (dbConn == null) {
		    System.out.println("Can't get database connection");
		    throw new ProductActivityException();
		}
		PreparedStatement pstmt =
		    dbConn.prepareStatement(sql_bundle.getString("findAllCats"));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
		    findCategory(rs.getString("CATEGORY_NAME"));
		}
		rs.close();
		pstmt.close();
	    }
	    catch (Exception e)
		{
		    System.out.println("Error during loadAllCategories");
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
	}

	public static void main(String[] args) {
	    TurbineConfig tc = new TurbineConfig("com/cdshop/props/",
						 "TurbineResources.properties");
	    tc.init();

	    try {
          
        Category.loadAllCategories();
		Category c = 
		    findCategory("Rock");
			
			    Iterator iter = c.getProducts().iterator();
   
	Product prod = (Product) iter.next();
			 
		if (c != null) {
					
		    System.out.println("Good Test: Find Real Category");
			System.out.println(prod.getTitle());
			
		} else {
		    System.out.println("Failed Test: Find Real Category");
		}
	    } catch (Exception e) {
		System.out.println("Failed Test: Find Real Category");
		e.printStackTrace();
	    }
	    try {
		Category c = 
		    findCategory("Pop1");
		if (c != null) {
		    System.out.println("Bad Test: Find Fake Category");
		} else {
		    System.out.println("Good Test: Find Fake Category");
		}
	    } catch (Exception e) {
		System.out.println("Failed Test: Find Fake Category");
		e.printStackTrace();
	    }
	    }
	
	
}	


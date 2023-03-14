package com.cdshop.cart;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.text.NumberFormat;
import com.cdshop.product.Product;
import java.util.ResourceBundle;
import com.cdshop.customer.Address;
import com.cdshop.customer.CreditCard;



/**
 * Cart is used to hold the contents of a shopping cart during a customer's 
 * session.   The cart also knows how to calculate tax and shipping
 * on an order, and how to calculate totals.
 *
 * @author zhao zhong
 *
 **/

public class Cart {

    /**
     * Holds the contents of an individual cart.
     *
     **/

    protected HashMap contents = new HashMap();
    private static ResourceBundle property_bundle =
	               ResourceBundle.getBundle("com.cdshop.cart.Cart");


    /** 
     * Returns an Iterator which will generate each  CartItem in the cart.
     *
     * @return An Iterator which iterates over objects of type CartItem
     *
     **/

    public Iterator getItems() {
	return contents.values().iterator();
    }

    /** 
     * Returns the CartItem for a given Product in the cart.
     *
     * @param item The product to check for in the cart.
     * @param return The CartItem that matches that product, or null
     * if the product is not in the cart.
     *
     **/
    
    
    public CartItem getItem(Product item) {
	return (CartItem)contents.get(item);
    }

    /**
     * Add an given quantity of a given  Product
     * to the cart. If the product is already in the cart, increment
     * the quantity rather than create a new CartItem.
     *
     * @param item The Product to add
     * @param quantity How many of this Product to add
     *
     **/

    public void addItem(Product item, int quantity) {
	if (contents.get(item) != null) {
	    ((CartItem)contents.get(item)).addQuantity(quantity);
	} else {
	    CartItem citem = new CartItem();
	    citem.setQuantity(quantity);
	    citem.setProduct(item);
	    contents.put(item, citem);
	}
    }


    /** 
     * Remove a product entirely from the cart
     *
     * @param item The Product to remove
     *
     **/

    public void removeItem(Product item) {
	  contents.remove(item);

    }

    /** 
     * Returns the number of distinct products in the cart.
     *
     * @return Number of different products in the cart.
     **/

    public int countItems() {
	return contents.size();
    }

    /** 
     * Returns the total cost of the cart but before
     * tax or shipping is calculated.
     *
     * @return The subtotal before shipping and tax
     **/

    public double getTotal() {
	double total = 0;
	Iterator it = contents.values().iterator();
	while (it.hasNext()) {
	    total += ((CartItem)it.next()).getLineItemPrice();
	}
	return total;
    }

    /** 
     * Returns the total cost of the cart  but before
     * tax or shipping is calculated, formatted as a currency string.
     *
     * @return The formatted subtotal before shipping and tax
     **/

    public String getTotalString() {
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	return nf.format(getTotal());
    }
	
	 /** 
     * Returns the calculated tax for the cart.  If the
     * <code>testTaxMode</code> property is set to "yes", the tax is
     * calculated based on a specific rate 
     *
     * @param addr The address of the customer.
     * @return The calculated tax for the cart.
     **/

    public double getTax(Address addr) {
	if ((property_bundle.getString("testTaxMode") != null) && 
	    (property_bundle.getString("testTaxMode").equals("yes"))) {
	    
		return getTotal() * 0.15D;

	} else {
	    System.out.println("No real tax code in place yet");
	    return 0D;
	}
    }
	

    /**
     * Returns a currency-formatted version of the {@link #getTax getTax}
     * method.
     *
     * @return The calculated tax for the cart as a currency string.
     **/

    public String getTaxString(Address addr) {
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	return nf.format(getTax(addr));
    }

    /** 
     * Returns the calculated shipping for the cart.  
	 *
     * @param addr The address of the customer.
     * @return The calculated shipping for the cart.
     **/

    public double getShipping(Address addr) {
	if ((property_bundle.getString("testShippingMode") != null) && 
	    (property_bundle.getString("testShippingMode").equals("yes"))) {
	    if (getTotal()<30.00)	
		 return 1.46D;  		

	}else 
	    System.out.println("Free Delivery");
	    return 0D;
	}

    /**
     * Returns a currency-formatted version of the 
     * {@link #getShipping getShipping} method.
     *
     * @return The calculated shipping for the cart as a currency string.
     **/

    public String getShippingString(Address addr) {
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	return nf.format(getShipping(addr));
    }

    /** 
     * Returns the subtotal + tax and shipping for the cart.
     *
     * @return The grand total cost of the cart.
     **/

    public double getGrandTotal(Address addr) {
	return getTotal() + getShipping(addr) + getTax(addr);
    }

    /**
     * Returns a currency-formatted version of the 
     * {@link #getGrandTotal getGrandTotal} method.
     *
     * @return The grand total cost for the cart as a currency string.
     **/

    public String getGrandTotalString(Address addr) {
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	return nf.format(getGrandTotal(addr));
    }
	
	public boolean authorizeCharge(CreditCard cc)
	{
		return true;
	}
	
	public void clear()
	{
		contents.clear();
	}
	
		
	
   public static void main(String[] args) {
   
   Cart head = new Cart();
   System.out.println(head.countItems());
   }
 }
 
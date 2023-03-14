package com.cdshop.cart;

import java.text.NumberFormat;
import com.cdshop.product.Product;

/**
 * CartItem is used to hold the product and quantity of a specific
 * item in the cart.
 * @author zhao zhong
 *
 **/

public class CartItem { 

    private Product pProduct;

    private int pQuantity;




    /**
     * Returns which Product has been placed in the cart.
     *
     * @return The product for this CartItem.
     **/

    public Product getProduct() {
	return pProduct;
    }

    /**
     * Sets the Product for a CartItem
     *
     * @param product The product for this CartItem.
     **/

    public void setProduct(Product product) {
	pProduct = product;
    }

    /**
     * Returns the quantity of an item that has been placed in the cart.
     *
     * @return The quantity for this CartItem.
     **/

    public int getQuantity() {
	return pQuantity;
    }

    /**
     * Sets the quantity for a CartItem
     *
     * @param quantity The quantity for this CartItem.
     **/

    public void setQuantity(int quantity) {
	pQuantity = quantity;
    }

    /**
     * Adds to the quantity for a CartItem
     *
     * @param quantity The quantity to add to this CartItem.
     **/

    public void addQuantity(int quantity) {
	pQuantity += quantity;
    }



    /**
     * Get the price times the quantity for this item.  
     *
     * @return the quantity times the price
     **/

    public double getLineItemPrice() {
	return getQuantity() * getProduct().getPrice();
    }

    /**
     * Returns a currency formatted version of the line item price.
     *
     * @return A currency-formatted version of the line item price .
     **/

    public String getLineItemPriceString() {
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	return nf.format(getLineItemPrice());
    }
}

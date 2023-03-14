package addressbook;

/**
 * Class to store address details. An address is made up of six fields:
 * <ul>
 * <li> a house number or name 
 * <li> a street 
 * <li> a town (for metropolitan addresses this may be a city borough) 
 * <li> a region (for rural addresses this will be county or similar national 
 * division, for metropolitan addresses, it will be the city) 
 * <li> a country 
 * <li> a postal code 
 * </ul>
 * @author David Clarke
 **/

public class Address
{
    private String houseNumber;
    private String street;
    private String town;
    private String region;
    private String country;
    private String postalCode;
	
    /**
     * Constructor to create an Address using the specified values.
     *
     * @param hse the house number or name
     * @param strt the street name
     * @param twn the town
     * @param rgn the region
     * @param ctry the country
     * @param pcode the postal code
     **/ 
    public Address(String hse, String strt, String twn, String rgn, String ctry, 
		   String pcode)
    {
	houseNumber = hse;
	street = strt;
	town = twn;
	region = rgn;
	country = ctry;
	postalCode = pcode;
    }
	
    /**
     * Set the house number or name
     * 
     * @param hse the house number or name
     **/
    public void setHouse(String hse)
    {
	houseNumber = hse;
    }

    /**
     * Set the street 
     *
     * @param strt the street
     **/
    public void setStreet(String strt)
    {
	street = strt;
    }
	
    /**
     *	Set the town 
     *
     *	@param twn the town
     **/
    public void setTown(String twn)
    {
	town = twn;
    }
	
    /**
     * Set the region 
     *
     * @param rgn the region
     **/
    public void setRegion(String rgn)
    {
	region = rgn;
    }

    /**
     * Set the country 
     *
     * @param ctry the country
     **/
    public void setCountry(String ctry)
    {
	country = ctry;
    }

    /**
     * Set the postal code
     *
     * @param pcode the postal code
     **/
    public void setPostCode(String pcode)
    {
	postalCode = pcode;
    }
	
    /**
     * Get the house number or name
     * 
     * @return hse the house number or name
     **/
    public String getHouse()
    {
	return houseNumber;
    }

    /**
     * Get the street 
     *
     * @return the street
     **/
    public String getStreet()
    {
	return street;
    }
	
    /**
     *	Get the town 
     *
     *	@return the town
     **/
    public String getTown()
    {
	return town;
    }
	
    /**
     * Get the region 
     *
     * @return the region
     **/
    public String getRegion()
    {
	return region;
    }

    /**
     * Get the country 
     *
     * @return the country
     **/
    public String getCountry()
    {
	return country;
    }

    /**
     * Get the postal code
     *
     * @return the postal code
     **/
    public String getPostCode()
    {
	return postalCode;
    }

    /**
     * Get a String representation of this Address
     *
     * @return a multi-line String giving all of the address details
     **/
    public String toString()
    {
	String ln1 = getHouse() + ", " + getStreet() + "\n";
	String ln2 = getTown() + "\n";
	String ln3 = getRegion() + "\n";
	String ln4 = getCountry() + "\n";
	String ln5 = getPostCode();
		
	return (ln1 + ln2 + ln3 + ln4 + ln5);	
    }
}
		

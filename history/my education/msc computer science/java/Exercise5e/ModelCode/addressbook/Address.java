package addressbook;

/**
* Class to store address details. An address is made up of six fields:
* <ul>
*  <li>a house number or name</li>
*  <li>a street</li>
*  <li>a town (for metropolitan addresses this may be a city borough</li>
*  <li>a region (for rural addresses this will be county or similar national 
*        division, for metropolitan addresses, it will be the city)</li>
*  <li>a country</li>
*  <li>a postal code</li>
* </ul>
**/
public class Address
{
   private String house,
                  street,
                  town,
                  region,
                  country,
                  postCode;
   
   /**
   * Constructor to create an <code>Address</code> using the specified values.
   * 
   * @param hse the house number or name
   * @param strt the street name
   * @param twn the town
   * @param rgn the region
   * @param ctry the country
   * @param pcode the postal code
   **/                
   public Address(String hse, String strt, String twn, 
                  String rgn, String ctry, String pcode)
   {
      house = hse;
      street = strt;
      town = twn;
      region = rgn;
      country = ctry;
      postCode = pcode;
   }
   
   /**
   * Set the house number or name
   * 
   * @param hse the house number or name
   **/
   public void setHouse(String hse)
   {
      house = hse;
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
   * Set the town
   * 
   * @param twn the town
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
      postCode = pcode;
   }
   
   /**
   * Get the house number or name
   * 
   * @return the house number or name
   **/
   public String getHouse()
   {
      return house;
   }
   
   /**
   * Get the street
   * 
   * @return the street name
   **/
   public String getStreet()
   {
      return street;
   }
   
   /**
   * Get the town
   * 
   * @return the name of the town
   **/
   public String getTown()
   {
      return town;
   }
   
   /**
   * Get the region
   * 
   * @return the name of the region
   **/
   public String getRegion()
   {
      return region;
   }
   
   /**
   * Get the country
   * 
   * @return the name of the country
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
      return postCode;
   }
   
   /**
   * Get a String representation of this <code>Address</code>
   * 
   * @return a multi-line String giving all of the address details.
   **/
   public String toString()
   {
      StringBuffer rval = new StringBuffer("Address:\n");
      if (house.length() > 0)
         rval.append(house).append(',');
      rval.append(street);
      if (town.length() > 0)
         rval.append('\n').append(town);
      if (region.length() > 0)
         rval.append('\n').append(region);
      if (country.length() > 0)
         rval.append('\n').append(country);
      if (postCode.length() > 0)
         rval.append('\n').append(postCode);
      
      return rval.toString();
   }
} 
      

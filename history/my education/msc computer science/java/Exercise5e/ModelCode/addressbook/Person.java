package addressbook;

/**
* A class to store information about a person.
**/
public class Person
{
   private String familyName,
                  givenNames,
                  homePhone,
                  workPhone,
                  mobilePhone,
                  eMail;
   
   /**
   * Constructor to create a <code>Person</code> with the specified family 
   * and given names. All the remaining fields will be blank.
   *
   * @param family the person's family name
   * @param given the person's given name(s)
   **/               
   public Person(String family, String given)
   {
      familyName = family;
      givenNames = given;
      homePhone = "";
      workPhone = "";
      mobilePhone = "";
      eMail = "";
   }
   
   /**
   * Constructor to create a <code>Person</code> with the specified details.
   * 
   * @param family the person's family name
   * @param given the person's given name(s)
   * @param home their home phone number
   * @param work their work phone number
   * @param mobile their mobile phone number
   * @param mail their e-mail address
   **/
   public Person(String family, String given, String home, String work, 
                 String mobile, String mail)
   {
      familyName = family;
      givenNames = given;
      homePhone = home;
      workPhone = work;
      mobilePhone = mobile;
      eMail = mail;
   }
   
   /**
   * Set the person's family name.
   * 
   * @param name the family name
   **/
   public void setFamilyName(String name)
   {
      familyName = name;
   }
   
   /**
   * Set the person's given name(s).
   * 
   * @param names the given name(s)
   **/
   public void setGivenNames(String names)
   {
      givenNames = names;
   }
   
   /**
   * Set the person's home phone number.
   * 
   * @param number the home phone number
   **/
   public void setHomePhone(String number)
   {
      homePhone = number;
   }
   
   /**
   * Set the person's work phone number.
   * 
   * @param number the work phone number
   **/
   public void setWorkPhone(String number)
   {
      workPhone = number;
   }
   
   /**
   * Set the person's mobile phone number.
   * 
   * @param number the mobile phone number
   **/
   public void setMobilePhone(String number)
   {
      mobilePhone = number;
   }
   
   /**
   * Set the person's e-mail address.
   * 
   * @param mail the e-mail address
   **/
   public void setEMail(String mail)
   {
      eMail = mail;
   }
   
   /**
   * Get the person's family name.
   * 
   * @return the family name
   **/
   public String getFamilyName()
   {
      return familyName;
   }
   
   /**
   * Get the person's given name(s).
   * 
   * @return the given name(s)
   **/
   public String getGivenNames()
   {
      return givenNames;
   }
   
   /**
   * Get the person's home phone number
   * 
   * @return the home phone number
   **/
   public String getHomePhone()
   {
      return homePhone;
   }
   
   /**
   * Get the person's work phone number
   * 
   * @return the work phone number
   **/
   public String getWorkPhone()
   {
      return workPhone;
   }
   
   /**
   * Get the person's mobile phone number
   * 
   * @return the mobile phone number
   **/
   public String getMobilePhone()
   {
      return mobilePhone;
   }
   
   /**
   * Get the person's e-mail address
   * 
   * @return the e-mail address
   **/
   public String getEMail()
   {
      return eMail;
   }
   
   /**
   * Get a string representation of this <code>Person</code>.
   * 
   * @return a multi-line string containing all the person's details
   **/
   public String toString()
   {
      return "Name: " + givenNames + " " + familyName + 
             "\nHome Phone: " + homePhone + 
             "\nWork Phone: " + workPhone + 
             "\nMobile: " + mobilePhone + 
             "\nE-Mail: " + eMail;
   }
}

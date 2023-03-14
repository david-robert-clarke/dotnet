import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;

public class DataInfo1
{
  // JDBC driver name and database URL
  String JDBC_DRIVER = "org.postgresql.Driver";
  String DATABASE_URL = "jdbc:postgresql://dbhost/";
  
  // Connection and Statement for accessing
  // and updating database
  private Connection connection;
  private Statement statement;
  
  // data array sets
  private Random generator;
  private int customer;
  private int staff;
  private int cd;
  private int supplier;
  
  
   private String[] maleFirstName = {"Tom","Dick","Harry","James","Dave","Lee",
                                     	"Phil","Mark","Steve","Simon","Ian","Paul",
					"Rob","Brian","Ryan","Ted","Daniel",
					"Peter","Neil","Mike"}; //20 entries
   
   private String[] femaleFirstName = {"Helen","Anna","Catherine","Linda",
                                     "Emma","Sarah","Jo","Rachel",
                                     "Monica","Phoebe","Simone","Julie","Emily",
                                     "Martha","Mary","Jacqui","Sharon","Victoria",
					"Zoe","Elaine"}; //20 entries
   
   private String[] lastName = {"Mottram","Moore","Atkinson","Roland","Smith",
				"Jones","Eldfield","Thomas","Loynes",
				"Hughes","Hill","Finnett","Partridge","Jamerson",
				"Hinchcliffe","Young","Pugh","Bond","McNiddon",
				"Hanson","East","Jenkins","Fallow","Benvie",
				"Barrymore","Cardigan","Jenkins"}; //25 entries

   private String[] email = {"msc64hel@cs.bham.ac.uk","msc67lxb@cs.bham.ac.uk",
			     "msc88drc@cs.bham.ac.uk","TJL@hotmail.com",
			     "JJWilliams@yahoo.co.uk","WW34@bham.ac.uk",
			     "hel246@sheffield.ac.uk","Batman@batcave.com",
			     "spiderman@theweb.com","Queen@palace.ac.uk",
			     "madman@prison.gov.uk","SH@curry.co.uk",
			     "TJSmith@yahoo.co.uk","12345@DIY.co.uk",
			     "BABaracus@ATeam.co.uk"}; //15 entries

   private String[] home_addr1 = {"1 BlueBerry St","2 St James Sq","3 London Rd",
				"4 Silverdale Ave","5 Green Close","6 Walsall Rd",
				"7 The Arches","8 Turnpike Rd","9 Calthorp Close",
                                "101 Morris Hill","102 Park Lane","103 Oxford St",
				"55 Whitehall","56 Bond Street","57 Regent St",
				"99A Picadilly","TreeTops, Liverpool St",
                                "The Vicarage, Church Street","Flat B, Walkers Rd",
				"Flat A, Divine St"};//20 entries

   private String[] home_addr2 = {"Birmingham","Worcester","Sussex",
                                "Portsmouth","Cardiff","Southend-On-Sea",
                                "Oxford","Great Barr","Cheslyn Hay",
                                "Edinburgh","Brighton","Southampton","Bridgend",
				"Heswall","Aberdeen","Luton","Evesham","Malvern",
				"Chester","London"}; //20 entries

   private String[] home_pcode = {"B12 2SQ","WR5 1PX","SS10 2QQ","S6 1HB",
                                "P26 3WE","CF86 2AJ","SS1 3RT","OX3 4TT",
                                "CH67 9SE","LU2 3QR","BH2 3LJ","WR29 3RY",
				"SE2 3RT","EX2 3RT","B58 8CD"}; //15 entries

   private String[] mob_phone = {"07788 457892","0987 416355","04567 567890","",
				"07788 367255","07987 354221","07980 345678","07890 654321",
				"07887 564321","07980 665544","08877 555444","07780 850863",
				"07980 850863","08897 788988","07889 455445"}; //15 entries

   private String[] cphone = {"01321 554556","01555 555555", "01999 456789","01223 456321",
			      "01789 999999","01564 325456","01654 555555","01111 222222",
			      "01234 987654","01555 333333","01777 888888","01122 334455",
			      "01666 555555","01444 555444"}; 
				//15 entries

   private String[] password = {"Blue","Bridge","Java","Toilet","House","Garden","12345678",
				"Star","Road","HY32456","Natalie","Computer","87654321",
				"Loynes","Helen"}; //15 entries

  private String[] position = {"Staff","Staff","Staff","Staff","Manager","Manager"};
  

   private String[] cdName = {"Angels with Dirty Faces","Busted","Eye Candy","100th Window",
                              "Justified","Stripped","Come Away With Me","Seven years-Ten Weeks",
				"Say You Will","Black Cherry"}; // 10 entries

   private String[] arTist = {"Busted","Mis-teeq","Massive Attack","Chilli Peppers","Sting",
				"Madonna","Justin Timberlake","Sugababes","David Bowie","Cher"};
                              //10 entries
  
  private String[] geNre = {"Pop","R&B","Heavy Metal","Blues","Soul","Rock","Garage",
                              "Dance","Drum & Bass","Hip Hop","Jazz"}; //12 entries
  
  private String[] tyPe = {"Single","Single","Single","Album","Album",
                             "Album","Album","Album"}; //8 entries

  private String[] releasedate = {"2002-04-03","2003-02-28","2003-08-02","2002-01-15",
				  "2002-12-30","2002-06-10","2003-04-28","2003-06-06",
				  "2003-04-01","2003-04-24","2002-03-12","2002-09-25"}; // 5 entries

  private double[] r_price = {1.99,2.99,3.99,4.99,9.99,10.99,14.99}; // 7 entries

  private int[] stock_level = {20,50,10,100,15,20,200,250};

  private double[] w_price = {0.99,1.99,2.99,3.99,6.99,7.99};

  private String[] sup_name = {"VERJIN","EMI","WHSmythe","TenPist","JohnSmith","OfMiceAndCheese",
			       "HisMastersPipe","SOONEE","New Music"};


   // constructor connects to database, and updates data stored there
   public DataInfo1() throws java.io.IOException, SQLException, ClassNotFoundException
   {
         // load database driver class
         Class.forName( JDBC_DRIVER );
         
         // create random number generator
         generator = new Random();

         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         //System.out.print("What is your PostgreSQL username?");
	 //String DATABASE_USERNAME = reader.readLine();
	 //DATABASE_URL = 
	 //System.out.print("What is your PostgreSQL password?");
	 //String DATABASE_PASSWORD = reader.readLine();
	 
	 // establish connection to database
         //connection = DriverManager.getConnection( DATABASE_URL, 
	                                 //DATABASE_USERNAME, DATABASE_PASSWORD);

	 String dbname = "msc67lxb";
	 String username = "msc64hel";
	 String pw = "MICHAEL";
	 String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
	 
	 connection = DriverManager.getConnection(dbUrl,username,pw);
         // create Statement for updating database
         statement = connection.createStatement();
	 System.out.println("Successfully connected to database.");

	 // *************************************************************************
	 // populate customer table
	 // *************************************************************************

	 System.out.print("How many customers?");
         customer = Integer.parseInt(reader.readLine());

	 for(int i = 0 ; i < customer; i++)
         {
	   String cFirstName;
	   if(generator.nextInt(2) == 0)
	   {
	     cFirstName = maleFirstName[generator.nextInt(maleFirstName.length)];
	   }
	   else
	   {
	     cFirstName = femaleFirstName[generator.nextInt(femaleFirstName.length)];
	   }
	   int tempCid = i+1;
	   String cid;
	   
	   if (tempCid < 10)
	   {
	     cid = "00000" + tempCid;
	   }
	   else if(tempCid < 100)
	   {
	     cid = "0000" + tempCid;
	   }
	   else if(tempCid < 1000)
	   {
	     cid = "000" + tempCid;	
	   }
	   else if(tempCid < 10000)
	   {
	     cid = "00" + tempCid;
	   }
	   else if(tempCid < 100000)
	   {
	     cid = "0" + tempCid;	
	   }
	   else
	   {
	     cid = "" + tempCid;
	   }
	     
	   String cLastName = lastName[generator.nextInt(lastName.length)];
	   String eMail = email[generator.nextInt(email.length)];
	   String homeaddr1 = home_addr1[generator.nextInt(home_addr1.length)];
	   String homeaddr2 = home_addr2[generator.nextInt(home_addr2.length)];
	   String homepcode = home_pcode[generator.nextInt(home_pcode.length)];
	   String c_phone = cphone[generator.nextInt(cphone.length)];
	   String mobphone = mob_phone[generator.nextInt(mob_phone.length)];
	   String passWord = password[generator.nextInt(password.length)];
	   
	   String query = "INSERT INTO customer VALUES ('"+cid+"', '"+cFirstName+"', '"+
	     cLastName+"', '"+eMail+"', '"+homeaddr1+"', '"+homeaddr2+"', '"+homepcode
	     +"', '"+c_phone+"', '"+mobphone+"', '"+passWord+"')";
	   statement.executeUpdate(query);
	 }

	 // *************************************************************************
	 // populate cd table
	 // *************************************************************************

	 System.out.print("How many cd?");
	 cd = Integer.parseInt(reader.readLine());

	 for(int i = 0 ; i < cd; i++)
         {
	   int tempIid = i+1;
	   String iid;
	   
	   if (tempIid < 10)
	   {
	     iid = "00000" + tempIid;
	   }
	   else if(tempIid < 100)
	   {
	     iid = "0000" + tempIid;
	   }
	   else if(tempIid < 1000)
	   {
	     iid = "000" + tempIid;	
	   }
	   else if(tempIid < 10000)
	   {
	     iid = "00" + tempIid;
	   }
	   else if(tempIid < 100000)
	   {
	     iid = "0" + tempIid;	
	   }
	   else
	   {
	     iid = "" + tempIid;
	   }
	     
	   String cd_name = cdName[generator.nextInt(cdName.length)];
	   String artist = arTist[generator.nextInt(arTist.length)];
	   String genre = geNre[generator.nextInt(geNre.length)];
	   String type = tyPe[generator.nextInt(tyPe.length)];
	   String release_date = releasedate[generator.nextInt(releasedate.length)];
	   double retail_price = r_price[generator.nextInt(r_price.length)];
	   
	   String query = "INSERT INTO cd VALUES ('"+iid+"', '"+cd_name+"', '"+
	     artist+"', '"+genre+"', '"+type+"', '"+release_date+"', '"+retail_price+"')";
	   statement.executeUpdate(query);
	 }

	 // *************************************************************************
	 // populate supplier table
	 // *************************************************************************

	 System.out.print("How many suppliers?");
         supplier = Integer.parseInt(reader.readLine());

	 for(int i = 0 ; i < supplier; i++)
         {
	   int tempSupid = i+1;
	   String supid;
	   
	   if (tempSupid < 10)
	   {
	     supid = "00000" + tempSupid;
	   }
	   else if(tempSupid < 100)
	   {
	     supid = "0000" + tempSupid;
	   }
	   else if(tempSupid < 1000)
	   {
	     supid = "000" + tempSupid;	
	   }
	   else if(tempSupid < 10000)
	   {
	     supid = "00" + tempSupid;
	   }
	   else if(tempSupid < 100000)
	   {
	     supid = "0" + tempSupid;	
	   }
	   else
	   {
	     supid = "" + tempSupid;
	   }
	     
	   String supName = sup_name[generator.nextInt(sup_name.length)];
	   String supaddr1 = home_addr1[generator.nextInt(home_addr1.length)];
	   String supaddr2 = home_addr2[generator.nextInt(home_addr2.length)];
	   String suppcode = home_pcode[generator.nextInt(home_pcode.length)];
	   String supphone = cphone[generator.nextInt(cphone.length)];
	   
	   String query = "INSERT INTO supplier VALUES ('"+supid+"', '"+supName+"', '"+
	     supaddr1+"', '"+supaddr2+"', '"+suppcode+"', '"+supphone+"')";
	   statement.executeUpdate(query);
	 }

	 // *************************************************************************
	 // populate staff table
	 // *************************************************************************

	 System.out.print("How many staff?");
         staff = Integer.parseInt(reader.readLine());

	 for(int i = 0 ; i < staff; i++)
         {
	   String sFirstName;
	   if(generator.nextInt(2) == 0)
	   {
	     sFirstName = maleFirstName[generator.nextInt(maleFirstName.length)];
	   }
	   else
	   {
	     sFirstName = femaleFirstName[generator.nextInt(femaleFirstName.length)];
	   }
	   int tempSid = i+1;
	   String sid;
	   
	   if (tempSid < 10)
	   {
	     sid = "00000" + tempSid;
	   }
	   else if(tempSid < 100)
	   {
	     sid = "0000" + tempSid;
	   }
	   else if(tempSid < 1000)
	   {
	     sid = "000" + tempSid;	
	   }
	   else if(tempSid < 10000)
	   {
	     sid = "00" + tempSid;
	   }
	   else if(tempSid < 100000)
	   {
	     sid = "0" + tempSid;	
	   }
	   else
	   {
	     sid = "" + tempSid;
	   }
	     
	   String sLastName = lastName[generator.nextInt(lastName.length)];
	   String staffaddr1 = home_addr1[generator.nextInt(home_addr1.length)];
	   String staffaddr2 = home_addr2[generator.nextInt(home_addr2.length)];
	   String staffpcode = home_pcode[generator.nextInt(home_pcode.length)];
	   String s_phone = cphone[generator.nextInt(cphone.length)];
	   String mobphone = mob_phone[generator.nextInt(mob_phone.length)];
	   String sposition = position[generator.nextInt(position.length)];
	   String spassWord = password[generator.nextInt(password.length)];
	   
	   String query = "INSERT INTO staff VALUES ('"+sid+"', '"+sFirstName+"', '"+
	     sLastName+"', '"+staffaddr1+"', '"+staffaddr2+"', '"+staffpcode
	     +"', '"+s_phone+"', '"+mobphone+"', '"+sposition+"','"+spassWord+"')";
	   statement.executeUpdate(query);
	 }
	 // *************************************************************************
	 // populate card_no table
	 // *************************************************************************



         // close connections to the database
         statement.close();
         connection.close();
   }
  
   // launch the application
   public static void main( String args[] ) throws java.io.IOException, SQLException, ClassNotFoundException
   {
      DataInfo1 fillDatabase = new DataInfo1();      
   }

}  



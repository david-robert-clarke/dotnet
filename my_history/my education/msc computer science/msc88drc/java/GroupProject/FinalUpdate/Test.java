import I.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.ArrayList; 

public class Test
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
  private int stock;
  private int corder_details;
  private int card_details;
  private int customer_orders;
  private int sorder_details;
  private int staff_orders;
  
  private ArrayList sid;
  private String[] SID;
  private ArrayList supid;
  private String[] SUPID;
  private ArrayList cid;
  private String[] CID;
  private ArrayList iid;
  private String[] IID;
  private ArrayList corder_no;
  private String[] cORDER_NO;
  private ArrayList sorder_no;
  private String[] sORDER_NO;
  private ArrayList card_NO;
  private ArrayList card_no;

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

  private String[] corderdate = {"2002-04-03","2003-02-28","2003-08-02","2002-01-15",
				 "2002-12-30","2002-06-10","2003-04-28","2003-06-06",
				 "2003-04-01","2003-04-24","2002-03-12","2002-09-25"}; // 5 entries

  private int[] stock_level = {20,50,10,100,15,20,200,250};

  private double[] w_price = {0.99,1.99,2.99,3.99,6.99,7.99};

  //private int[] card_no = {19990117, 20000229, 20000428, 20000913}; generate 16 random numbers

  private String[] card_type = {"VISA", "MASTER CARD", "AMERICAN EXPRESS", "SWITCH", "DELTA"};

  private String[] exp_date = {"2008-04-04","2005-06-06","2008-08-08","2005-01-01","2006-06-06",
			       "2003-10-05","2004-03-03","2008-02-12","2005-07-15","2003-12-06"};

  private int[] issue_no = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			    2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,
			    4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,};

  private int[] cno_bought = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,
			     2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,5,10};

  private int[] sno_bought = {50,50,50,20,20,20,10,10,10,100,100,100,200,500};

  private double[] numbers = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};
  
  

  // constructor connects to database, and updates data stored there
  public Test() throws java.io.IOException, SQLException, ClassNotFoundException
  {
    // load database driver class
    Class.forName( JDBC_DRIVER );
    
    // create random number generator
    generator = new Random();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String dbname = "msc67lxb";
    String username = "msc64hel";
    String pw = "MICHAEL";
    String dbUrl = "jdbc:postgresql://dbhost/" + dbname;
    connection = DriverManager.getConnection(dbUrl,username,pw);

    // create Statement for updating database
    statement = connection.createStatement();
    System.out.println("Successfully connected to database.");
    
    // *************************************************************************
    // populate stock table
    // *************************************************************************
    
    System.out.println("How much stock?");
    stock = Integer.parseInt(reader.readLine());

    //Get supplier id no's from supplier table. Put into an arraylist, then into an array.
    ResultSet rs = statement.executeQuery("SELECT supid FROM supplier");
    supid = new ArrayList();
    int i=0;
    while (rs.next()) 
    {
      String supID = rs.getString("supid");
      supid.add(supID);
      i++;
    }   
    SUPID = new String[supid.size()];
    supid.toArray(SUPID);

    //Get cd id no's from cd table. Put into an arraylist, then into an array.
    ResultSet rs1 = statement.executeQuery("SELECT iid FROM cd");    
    iid = new ArrayList();
    int j=0;
    while (rs1.next()) 
    {
      String iID = rs1.getString("iid");      
      iid.add(iID);
      j++;
    }
    IID = new String[iid.size()];
    iid.toArray(IID);
    
    
    for(int k = 0 ; k < stock; k++)
    {
      String newIID = IID[generator.nextInt(IID.length)];
      String newSUPID = SUPID[generator.nextInt(SUPID.length)];
      int stocklevel = stock_level[generator.nextInt(stock_level.length)];
      double wprice = w_price[generator.nextInt(w_price.length)];

      String query = "INSERT INTO stock VALUES ('"+newIID+"', '"+newSUPID+"', '"+
	stocklevel+"', '"+wprice+"')";
      statement.executeUpdate(query);

      //if (entry already exists, don't put in table)
    }
    
    // *************************************************************************
    // populate staff order table
    // *************************************************************************

    System.out.println("How many staff orders?");
    staff_orders = Integer.parseInt(reader.readLine());
    
    ResultSet rs2 = statement.executeQuery("SELECT sid FROM staff");
    sid = new ArrayList();
    int l=0;
    while (rs2.next()) 
    {
      String sID = rs2.getString("sid");
      sid.add(sID);
      l++;
    }   
    SID = new String[sid.size()];
    sid.toArray(SID);


    for(int m = 0 ; m < staff_orders; m++)
    {
      int tempSOrderNo = m+1;
      String sOrderNo;
      
      if (tempSOrderNo < 10)
      {
	sOrderNo = "00000" + tempSOrderNo;
      }
      else if(tempSOrderNo < 100)
      {
	sOrderNo = "0000" + tempSOrderNo;
      }
      else if(tempSOrderNo < 1000)
      {
	sOrderNo = "000" + tempSOrderNo;	
      }
      else if(tempSOrderNo < 10000)
      {
	sOrderNo = "00" + tempSOrderNo;
      }
      else if(tempSOrderNo < 100000)
      {
	sOrderNo = "0" + tempSOrderNo;	
      }
      else
      {
	sOrderNo = "" + tempSOrderNo;
      }
      
      String newSID = SID[generator.nextInt(SID.length)];
      String sOrderDate = corderdate[generator.nextInt(corderdate.length)];
      String newSUPID = SUPID[generator.nextInt(SUPID.length)];
      
      String query = "INSERT INTO staff_order VALUES ('"+sOrderNo+"', '"
	+newSID+"', '"+sOrderDate+"', '"+newSUPID+"')";
      statement.executeUpdate(query);
    }

    // *************************************************************************
    // populate staff order details table
    // *************************************************************************
   
    System.out.println("How many staff order details?");
    sorder_details = Integer.parseInt(reader.readLine());
    
    ResultSet rs3 = statement.executeQuery("SELECT sorder_no FROM staff_order");
    sorder_no = new ArrayList();
    int m=0;
    while (rs3.next()) 
    {
      String sOrderNo = rs3.getString("sorder_no");
      sorder_no.add(sOrderNo);
      m++;
    }   
    sORDER_NO = new String[sorder_no.size()];
    sid.toArray(SID);
    

    
    GetStaffOrderNoQuery staffQuery = new GetStaffOrderNoQuery();
    sorder_no = staffQuery.exeQuery();
    
    for (int i=0; i<sorder_details; i++)
    { 
    String sorderNo = sorder_no[generator.nextInt(sorder_no.length)];
    String newIID = iid[generator.nextInt(iid.length)];
    int snoBought = sno_bought[generator.nextInt(sno_bought.length)];
    
    String query = "INSERT INTO sorder_details VALUES ('"+sorderNo+"', '"+newIID+
      "', '"+ snoBought+"')";
    statement.executeUpdate(query);
    }

    // close connections to the database
    statement.close();
    connection.close();
  }
  
  // launch the application
  public static void main( String args[] ) throws java.io.IOException, SQLException, ClassNotFoundException
  {
    Test fillDatabase = new Test();      
  }
}  



import I.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.ArrayList; 

public class DataInfo2
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
  
  private String[] sid;
  private String[] supid;
  private String[] cid;
  private String[] iid;
  private String[] corder_no;
  private String[] sorder_no;
  private double[] card_NO;
  private double[] card_no;

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
  public DataInfo2() throws java.io.IOException, SQLException, ClassNotFoundException
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
    
    supid = new String[300];
    GetSUPIDQuery supidQuery = new GetSUPIDQuery();
    supid = supidQuery.exeQuery();

    iid = new String[300];
    GetIIDQuery iidQuery = new GetIIDQuery();
    iid = iidQuery.exeQuery();

    for(int i = 0 ; i < stock; i++)
    {
      String newIID = iid[generator.nextInt(iid.length)];
      String newSUPID = supid[generator.nextInt(supid.length)];
      int stocklevel = stock_level[generator.nextInt(stock_level.length)];
      double wprice = w_price[generator.nextInt(w_price.length)];

      String query = "INSERT INTO stock VALUES ('"+newIID+"', '"+newSUPID+"', '"+
	stocklevel+"', '"+wprice+"')";
      statement.executeUpdate(query);

      //if (entry already exists, don't put in table)
    }

    // *************************************************************************
    // populate card_details table
    // *************************************************************************
    
    System.out.println("How many customers card details?");
    card_details = Integer.parseInt(reader.readLine());
    
    cid = new String[300];
    GetCIDQuery cidQuery = new GetCIDQuery();
    cid = cidQuery.exeQuery();

    card_no = new double[16];
    card_NO = new double[300];
    
    // a generator creates a credit card number. The numbers are stored in
    // an array of size 16. Once this array is full, a credit card number has been
    //been created and this is added to a second array containing all credit card numbers.

    int k=0;
    int n=0;
    for (int i=0; i<card_details; i++)
    {
      for (int j=0; j<16; j++)
      {
	double values = numbers[generator.nextInt(numbers.length)];
	card_no[i] = values;
	i++;
      }
      card_NO[n] = card_no;
      n++;
      //card_no.clear();
    }

    for (int i=0; i<card_details; i++)
    {
      double creditCardNo = card_NO[generator.nextInt(card_NO.length)];
      String newCID = cid[generator.nextInt(cid.length)];
      String cardType = card_type[generator.nextInt(card_type.length)];
      String expDate = exp_date[generator.nextInt(exp_date.length)];
      int issueNo = issue_no[generator.nextInt(issue_no.length)];
    
      String query = "INSERT INTO card_details VALUES ('"+creditCardNo+"', '"+newCID+
	"', '"+ cardType+"', '"+expDate+"', '"+issueNo+"')";
      statement.executeUpdate(query);
    } 

    // *************************************************************************
    // populate customer order table
    // *************************************************************************
    
    System.out.println("How many customer orders?");
    customer_orders = Integer.parseInt(reader.readLine());
    
    for(int i = 0 ; i < customer_orders; i++)
    {
      int tempCOrderNo = i+1;
      String cOrderNo;
      
      if (tempCOrderNo < 10)
      {
	cOrderNo = "00000" + tempCOrderNo;
      }
      else if(tempCOrderNo < 99)
      {
	cOrderNo = "0000" + tempCOrderNo;
      }
      else if(tempCOrderNo < 999)
      {
	cOrderNo = "000" + tempCOrderNo;	
      }
      else if(tempCOrderNo < 9999)
      {
	cOrderNo = "00" + tempCOrderNo;
      }
      else if(tempCOrderNo < 99999)
      {
	cOrderNo = "0" + tempCOrderNo;	
      }
      else
      {
	cOrderNo = "" + tempCOrderNo;
      }
      
      String newCID = cid[generator.nextInt(cid.length)];
      String cOrderDate = corderdate[generator.nextInt(corderdate.length)];
      String delAddr1 = home_addr1[generator.nextInt(home_addr1.length)];
      String delAddr2 = home_addr2[generator.nextInt(home_addr2.length)];
      String delpcode = home_pcode[generator.nextInt(home_pcode.length)];
      double creditCardNo = card_NO[generator.nextInt(card_NO.length)];
      
      String query = "INSERT INTO customer_order VALUES ('"+cOrderNo+"', '"
	+newCID+"', '"+cOrderDate+"', '"+delAddr1+"', '"+delAddr2+"', '"
	+delpcode+"', '"+creditCardNo+"')";
      statement.executeUpdate(query);
    }

    // *************************************************************************
    // populate customer order details table
    // *************************************************************************
   
    System.out.println("How many customer order details?");
    corder_details = Integer.parseInt(reader.readLine());
    
    corder_no = new String[300];
    GetCustomerOrderNoQuery customerQuery = new GetCustomerOrderNoQuery();
    corder_no = customerQuery.exeQuery();
    
    for (int i=0; i<corder_details; i++)
    { 
      String newIID = iid[generator.nextInt(iid.length)];
      String corderNo = corder_no[generator.nextInt(corder_no.length)];
      int cnoBought = cno_bought[generator.nextInt(cno_bought.length)];
    
      String query = "INSERT INTO corder_details VALUES ('"+newIID+"', '"+corderNo+
	"', '"+ cnoBought+"')";
      statement.executeUpdate(query);
    } 

    // *************************************************************************
    // populate staff order table
    // *************************************************************************

    System.out.println("How many staff orders?");
    staff_orders = Integer.parseInt(reader.readLine());
    
    for(int i = 0 ; i < staff_orders; i++)
    {
      int tempSOrderNo = i+1;
      String sOrderNo;
      
      if (tempSOrderNo < 10)
      {
	sOrderNo = "00000" + tempSOrderNo;
      }
      else if(tempSOrderNo < 99)
      {
	sOrderNo = "0000" + tempSOrderNo;
      }
      else if(tempSOrderNo < 999)
      {
	sOrderNo = "000" + tempSOrderNo;	
      }
      else if(tempSOrderNo < 9999)
      {
	sOrderNo = "00" + tempSOrderNo;
      }
      else if(tempSOrderNo < 99999)
      {
	sOrderNo = "0" + tempSOrderNo;	
      }
      else
      {
	sOrderNo = "" + tempSOrderNo;
      }
      
      String newSID = sid[generator.nextInt(sid.length)];
      String sOrderDate = corderdate[generator.nextInt(corderdate.length)];
      String newSUPID = supid[generator.nextInt(supid.length)];
      
      String query = "INSERT INTO staff_order VALUES ('"+sOrderNo+"', '"
	+newSID+"', '"+sOrderDate+"', '"+newSUPID+"')";
      statement.executeUpdate(query);
    }

    // *************************************************************************
    // populate staff order details table
    // *************************************************************************
   
    System.out.println("How many staff order details?");
    sorder_details = Integer.parseInt(reader.readLine());
    
    sorder_no = new String[300];
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
    DataInfo2 fillDatabase = new DataInfo2();      
  }
}  



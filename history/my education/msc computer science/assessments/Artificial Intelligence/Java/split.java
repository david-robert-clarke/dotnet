import databook.*;
import java.io.*;


class split
{

  private static int finalCost = 0;
  private static int noOfFeatures = 23;

  private static int featureValue (int i, Patient p)
  {
    int returnVal = -1;
    
    switch (i)
    {

    case 0: if (Integer.parseInt(p.getAge()) < 45)
    {
      returnVal = 0;
    }
    else
    {
      returnVal = 1;
    }
      break;

    case 1: if (p.getSex().equals("M"))
    {
      returnVal = 0;
    }
    else
    {
      returnVal = 1;
    }
      break;
      
    case 2: returnVal = Integer.parseInt(p.getCollBin());
      break;
      
    case 3: returnVal = Integer.parseInt(p.getBgBin());
      break;
      
    case 4: returnVal = Integer.parseInt(p.getBlDisp());
      break;
      
    case 5: returnVal = Integer.parseInt(p.getBlBlus());
      break;
      
    case 6: returnVal = Integer.parseInt(p.getDerMel());
      break;
       
    case 7: returnVal = Integer.parseInt(p.getDmGlob());
      break;
      
    case 8: returnVal = Integer.parseInt(p.getAsym());
      break;
      
    case 9: returnVal = Integer.parseInt(p.getSym1());
      break;
      
    case 10: returnVal = Integer.parseInt(p.getSym2());
      break;
      
    case 11: returnVal = Integer.parseInt(p.getMelGlob());
      break;  
      
    case 12: returnVal = Integer.parseInt(p.getDispBlus());
      break; 
      
    case 13: returnVal = Integer.parseInt(p.getDiam6());
      break;   	
      
    case 14: returnVal = Integer.parseInt(p.getNoSym2());
      break;   
      
    case 15: if (Integer.parseInt(p.getSize()) == 2)
    {
      returnVal = 1;
    }
    else
    {
      returnVal = 0;
    }
      break;
      
    case 16: if (Integer.parseInt(p.getShape()) == 2)
    {
      returnVal = 1;
    }
    else
    {
      returnVal = 0;
    }
      break;

    case 17: if (Integer.parseInt(p.getColour()) == 2)
    {
      returnVal = 1;
    }
    else
    {
      returnVal = 0;
    }
      break;
      
    case 18: returnVal = Integer.parseInt(p.getInflamed());
      break;
      
    case 19: returnVal = Integer.parseInt(p.getBleed());
      break;
      
    case 20: returnVal = Integer.parseInt(p.getSens());
      break;
      
    case 21: returnVal = Integer.parseInt(p.getDiam7());
      break;

    case 22: returnVal = Integer.parseInt(p.getSuspicious());
      break;
      
    }

    return returnVal;
  }
  
  private static String featureString (int i)
  {
    String returnString = "";
    
    switch (i)
    {
      
    case 0: returnString = "Age";
      break;

    case 1: returnString = "Sex";
	break;
      
    case 2: returnString = "CollBin";
      break;
	  
    case 3: returnString = "BgBin";
      break;
	  
    case 4: returnString = "BlDisp";
      break;
	  
    case 5: returnString = "BlBlus";
      break;

    case 6: returnString = "DerMel";
      break;
	
    case 7: returnString = "DmGlob";
      break;

    case 8: returnString = "Asym";
      break;
    
    case 9: returnString = "Sym1";
      break;
	
    case 10: returnString = "Sym2";
      break;

    case 11: returnString = "MelGlob";
      break;  

    case 12: returnString = "DispBlus";
      break; 

    case 13: returnString = "Diam6";
      break;   	

    case 14: returnString = "NoSym2";
      break;   
      
    case 15: returnString = "Size";
      break; 
      
    case 16: returnString = "Shape";
      break; 

    case 17: returnString = "Colour";
      break;

    case 18: returnString = "Inflamed";
      break; 
 
    case 19: returnString = "Bleed";
      break; 

    case 20: returnString = "Sens";
      break;
      
    case 21: returnString = "Diam7";
      break; 

    case 22: returnString = "Suspicious";
      break;
    }
    return returnString;
  }

  private static void createSplitLists (int row, int column, DataBook temp, ListHolder list, int diagnosis, 
					int cost) throws IOException, NoSuchEntryException, EntryExistsException
  {
    int counter = 0;
    for (int i = 0; i < temp.dataBookSize(); i++)
    {
      if (Integer.parseInt(temp.getPatient(i).getBinDiag()) == diagnosis)
      {
	counter++;
      }
    }
    int total = counter * cost;
    temp.setCost(total);
    
    if (total != 0)
    {
      int summation = 0;
      int[] theCosts = new int[noOfFeatures];
		
      for(int i=0; i<noOfFeatures;i++)
      {
	summation = 0;
	for(int j = 0; j< temp.dataBookSize(); j++)
	{
	  Patient pat = temp.getPatient(j);
	  int clas = featureValue(i, pat);
	  int diag = Integer.parseInt(pat.getBinDiag());
	  
	  if ((clas == 0 && diag == 0) || 
	      (clas == 1 && diag == 1))
	  {
	    summation += 0;
	  }
	  else if (clas == 1 && diag == 0)
	  {
	    summation += 10;
	  }
	  else
	  {
	    summation += 50;
	  }
	}
	theCosts[i] = summation;
      }
      
      String feat = "";
      int fno = 0;
      int fn = 0;
      int inc = 0;
      int smallest = 0;
      String s = null;
      boolean exit = false;
      
      do
      {
	fno = inc;
	feat = featureString(inc);		
	if (!temp.containsFeature(feat))
	{
	  s = feat;
	  smallest = theCosts[inc];
	  fn = fno;
	  exit = true;
	}
	else
	{
	  inc++;
	}
      } while (inc < noOfFeatures && !exit);
      
      for(int i=0; i < theCosts.length; i++)
      {
	if (theCosts[i] < smallest)
	{
	  fno = i;
	  feat = featureString(i);		 
	  if (!temp.containsFeature(feat))
	  {
	    smallest = theCosts[i];
	    fn = fno;
	    s = feat;
	  }
	}
      }
      //temp.setFeatures(s, row); unblock this to go back
      
      DataBook ben = new DataBook();
      DataBook mal = new DataBook();
      
      for (int i = 0; i < temp.dataBookSize(); i++)
      {
	Patient patient = temp.getPatient(i);
	int val = featureValue(fn, patient);
	
	if (val == 0)
	{
	  ben.addPatient(patient);
	}
	else
	{
	  mal.addPatient(patient);
	}
      }
      // delete if is screwed up
      if (column % 2 == 0)
      {
	if (mal.dataBookSize() != temp.dataBookSize())
	{
	  temp.setFeatures(s, row); // delete this to go back to orig
	  for (int i = 0; i <= row; i++)
	  {
	    String f = temp.getFeatures(i);
	    mal.setFeatures(f, i);
	    ben.setFeatures(f, i);
	  }
	  list.addList(mal, row + 1, 2 * column);
	  list.addList(ben, row + 1, (2 * column) + 1);
	}
	else
	{
	  int count = 0;
	  for (int i = 0; i < temp.dataBookSize(); i++)
	  {
	    if (Integer.parseInt(temp.getPatient(i).getBinDiag()) == 0)
	    {
	      count++;
	    }
	  }
	  finalCost += count * 10;
	}
	
      }
      else
      {
	if (ben.dataBookSize() != temp.dataBookSize())
	{
	  temp.setFeatures(s, row); // delete this to go back to orig
	  for (int i = 0; i <= row; i++)
	  {
	    String f = temp.getFeatures(i);
	    mal.setFeatures(f, i);
	    ben.setFeatures(f, i);
	  }
	  list.addList(mal, row + 1, 2 * column);
	  list.addList(ben, row + 1, (2 * column) + 1);
	}
	else
	{
	  int count = 0;
	  for (int i = 0; i < temp.dataBookSize(); i++)
	  {
	    if (Integer.parseInt(temp.getPatient(i).getBinDiag()) == 1)
	    {
	      count++;
	    }
	  }
	  finalCost += count * 50;
	}
      }

      //list.addList(mal, row + 1, 2 * column);
      //list.addList(ben, row + 1, (2 * column) + 1);
    }
  }
  


  public static void main (String[] args)throws IOException, NoSuchEntryException, EntryExistsException
  {
    int[] costs = new int[noOfFeatures];
    DataBook thisBook = new DataBook();
    ListHolder list = new ListHolder();
    //String[] allFeatures = {"CollBin", "BgBin", "BlDisp", "BlBlus"};

    thisBook.load("TrainingData.csv");
    list.addList(thisBook, 0, 0);
    int sum;
    // for loop Features
    for(int i=0; i<noOfFeatures;i++)
    {
      sum=0;
      // for loop Patients
      for(int j=0; j<thisBook.dataBookSize(); j++)
      {
	Patient p = thisBook.getPatient(j);
	int classifier = featureValue(i, p);
	int diagnosis = Integer.parseInt(p.getBinDiag());

	if ((classifier == 0 && diagnosis == 0) || 
	    (classifier == 1 && diagnosis == 1))
	{
	  sum += 0;
	}
	else if (classifier == 1 && diagnosis == 0)
	{
	  sum += 10;
	}
	else
	{
	  sum += 50;
	}
	
      }
      costs[i] = sum;
    }

    String feature = "";
    int fnum = 0;
    
    int lowest = costs[0];
    for(int i=0; i < costs.length; i++)
    {
      if (costs[i] <= lowest)
      {
	lowest = costs[i];
	fnum = i;
	feature = featureString(i);
      }
    }
    thisBook.setFeature(feature);
    
    DataBook benign = new DataBook();
    DataBook malignant = new DataBook();
    
    for (int i = 0; i < thisBook.dataBookSize(); i++)
    {
      Patient p = thisBook.getPatient(i);
      int value = featureValue(fnum, p);

      if (value == 0)
      {
	benign.addPatient(p);
      }
      else
      {
	malignant.addPatient(p);
      }
    }
    
    malignant.setFeatures(feature, 0);
    benign.setFeatures(feature, 0);    

    // System.out.println(feature);
    

    list.addList(malignant, 1, 0);
    list.addList(benign, 1, 1);
    

    for (int row = 1; row < 9; row++) //5 changed to 9
    {
      for (int column = 0; column < (int)Math.pow(2,row); column++)
      {
	if (list.getList(row, column) != null)
	{	  
	  DataBook temp = list.getList(row, column); 
	  
	  // all the benign lists
	  if (column % 2 == 1)
	  {
	    createSplitLists(row, column, temp, list, 1, 50);
	  }
	  // malignant cases
	  else
	  {
	    createSplitLists(row, column, temp, list, 0, 10);
	  }
	}
      } 
    }
    
    System.out.println("0,0 "+ list.getList(0, 0).getFeature());
    
    for (int row = 1; row < 9; row++) //5 changed to 9
    {
      for (int column = 0; column < (int)Math.pow(2,row); column++)
      {
	if (list.getList(row, column) != null)
	{
	  
	  System.out.println(row + ", " + column + " " + 
	  list.getList(row, column).getFeatures(row) + "\t\t" + 
			     list.getList(row,column).dataBookSize());
	}
	
      }
    }
    System.out.println();
    
    System.out.println(finalCost);
    /*
    String [] ray = 
      {
	"02_09_00_04_21",
	"29_07_00_03_37",
	"31_10_00_11_35",
	"23_10_00_08_55",
	"10_10_00_10_09",
	"16_10_00_10_58",
	"02_10_00_09_11",
	"03_07_00_11_47",
	"03_07_00_09_13",
	"26_08_00_04_44",
	"06_11_00_10_46"
      };
    
    for (int x = 0; x < ray.length; x++)
    {
      
      for (int row = 1; row < 9; row++) //5 changed to 9
      {
	for (int column = 0; column < (int)Math.pow(2,row); column++)
	{
	  if (list.getList(row, column) != null)
	  {
	    if (list.getList(row, column).getFeatures(row) == null)
	    {
	      for(int i = 0; i < list.getList(row, column).dataBookSize(); i++)
	      {
		
		String id = list.getList(row, column).getPatient(i).
getIdentifier();
		if (id.equals(ray[x]))
		{
		  System.out.println(ray[x] + "    " + row + ", " + column);
		}
		
	      }	      
	    }
	  }
	}	
      }
    }
    */
  }
}

import databook.*;
import java.io.*;

/* 
   This program generates the decision tree based upon the information 
   contained within the training data file
*/

class TreeGen
{
  private static int finalCost = 0;          // used to hold the final cost of
                                             // the generated tree
  private static int noOfFeatures = 23;      // the number of features

  /*
    This method returns the (integer) value of the required feature for the 
    specified patient. If the specified integer is out of bounds then -1 is 
    returned. 
    This method was created in order to convert the feature values for each 
    patient from a string to an int value and also to simplify the program
  */

  private static int featureValue (int i, Patient p)
  {
    int returnVal = -1;
    
    switch (i)
    {

    case 0: if (Integer.parseInt(p.getAge()) < 45)
            {
	      returnVal = 0; // if the patient is younger than 45 
	    }
            else
	    {
	      returnVal = 1; // if the patient is at least 45 years old
	    }
      break;

    case 1: if (p.getSex().equals("M"))
            {
	      returnVal = 0;  // patient is male
	    }
            else
	    {
	      returnVal = 1;  // patient is female
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
  
  /* 
     This method returns the specified feature name as a string. This was 
     created in order to simplify the program. If i is out of bounds then an 
     empty string is returned.
  */

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

  /*
    This method splits the patients at a particular node (indicated by the 
    supplied row and column variables) if it is beneficial.
    The dataBook supplied is that corresponding to the node that is being 
    processed and state refers to the position of the node - if state is 0 then
    the node is a malignant one (ie the left hand child of its parent node), 
    if it is 1 then the node is a benign one and if it is 2 then it is the 
    root node
  */

  private static void createSplitLists (int row, int column, DataBook dataBook,
					ListHolder list, int state) 
    throws IOException, NoSuchEntryException, EntryExistsException
  {
    int total = 0;
    int cost = 0;

    if (state == 0)          // malignant node
    {
      cost = 10;             // cost of benign patient at malignant node
    }
    else if (state == 1)     // benign node
    {
      cost = 50;             // cost of malignant patient at benign node
    }
    
    if (state != 2) // not root node
    {
      int counter = 0;  // holds number of incorrectly placed patients
      for (int i = 0; i < dataBook.dataBookSize(); i++)
      {
	if (Integer.parseInt(dataBook.getPatient(i).getBinDiag()) == state)
	{
	  counter++; // found misdiagnosed patient
	}
      }
      total = counter * cost; // total cost of all incorrectly placed patients
      dataBook.setCost(total);
    }
    
    if (total != 0 || state == 2) 
    {
      int sum = 0;
      int[] featureCost = new int[noOfFeatures];  // holds cost of selecting
                                                  // each particular feature
      for(int i=0; i<noOfFeatures;i++) 
      {	// work out cost associated with each feature
	sum = 0;
	for(int j = 0; j< dataBook.dataBookSize(); j++)
	{
	  Patient patient = dataBook.getPatient(j);
	  int feature = featureValue(i, patient);
	  int diagnosis = Integer.parseInt(patient.getBinDiag());
	  
	  if ((feature == 0 && diagnosis == 0) || 
	      (feature == 1 && diagnosis == 1))
	  {
	    sum += 0;
	  }
	  else if (feature == 1 && diagnosis == 0)
	  {
	    sum += 10;
	  }
	  else
	  {
	    sum += 50;
	  }
	}
	featureCost[i] = sum;
      }
      
      int inc = 0;
      String feat = "";
      int featNo = 0;
      int chosenFeatNo = 0;
      int smallest = 0;
      String chosenFeat = null;
      boolean exit = false;
      
      // find a valid feature (ie one that hasnt already been used in the path 
      // to get to the current node being processed) 
      do
      {
	featNo = inc;
	feat = featureString(inc);		
	if (!dataBook.containsFeature(feat)) // feature not already used used
	{
	  chosenFeat= feat;
	  smallest = featureCost[inc];
	  chosenFeatNo = featNo;
	  exit = true;
	}
	else
	{
	  inc++;
	}
      } while (inc < noOfFeatures && !exit);
      
      // check if this is lowest cost feature - if another feature is found 
      // that hasn't already been used and has a smaller cost then use that
      for(int i = 0; i < featureCost.length; i++)
      {
	if (featureCost[i] < smallest) // this feature has a better cost then 
	{                              //the currently selected one
	  featNo = i;
	  feat = featureString(i);		 
	  if (!dataBook.containsFeature(feat)) // feature hasn't been used
	  {
	    smallest = featureCost[i];
	    chosenFeatNo = featNo;
	    chosenFeat= feat; // select feature
	  }
	}
      }
     
      DataBook benign = new DataBook();    // benign child node of current node
      DataBook malignant = new DataBook(); // malignant child node
      
      // split the patients based on the chosen feature
      for (int i = 0; i < dataBook.dataBookSize(); i++)
      {
	Patient patient = dataBook.getPatient(i);
	int value = featureValue(chosenFeatNo, patient);
	
	if (value == 0)
	{
	  benign.addPatient(patient);
	}
	else
	{
	  malignant.addPatient(patient);
	}
      }
    
      DataBook temp = new DataBook();
      
      if (state == 0) // choose relevant child node
      {
	temp = malignant;
      }
      else
      {
	temp = benign;
      }

      if (temp.dataBookSize() != dataBook.dataBookSize()) // ie split is useful
      {
	dataBook.setFeatures(chosenFeat, row); // update the features used list
	for (int i = 0; i <= row; i++)
	{ // make a note of all features used so far to obtain the child nodes 
	  // in the child nodes' features list
	  String previousFeat = dataBook.getFeatures(i); 
	  malignant.setFeatures(previousFeat, i);
	  benign.setFeatures(previousFeat, i);
	}
	list.addList(malignant, row + 1, 2 * column);   // add child nodes to
	list.addList(benign, row + 1, (2 * column) + 1);// listholder
      }
      else // split hasn't improved the tree as all patients are split into 
      {	   // same child node
	int count = 0;
	for (int i = 0; i < dataBook.dataBookSize(); i++)
	{ // work out cost of all incorrect patients at the node
	  if (Integer.parseInt(dataBook.getPatient(i).getBinDiag()) == state)
	  {
	    count++;
	  }
	}
	finalCost += count * cost; // update cost of decision tree so far
      }
    }
  }
  
  public static void main (String[] args)throws IOException, 
						NoSuchEntryException, 
						EntryExistsException
  {
    DataBook thisBook = new DataBook();
    ListHolder list = new ListHolder();
    
    thisBook.load("TrainingData.csv"); // load in the training data
    list.addList(thisBook, 0, 0);
    
    createSplitLists(0, 0, thisBook, list, 2); // split the root node

    for (int row = 1; row <= 5; row++) // generate tree
    {
      for (int column = 0; column < (int)Math.pow(2,row); column++)
      {
	if (list.getList(row, column) != null)
	{	  
	  DataBook dataBook = list.getList(row, column); 
	  
	  // all the benign nodes
	  if (column % 2 == 1)
	  {
	    createSplitLists(row, column, dataBook, list, 1);
	  }
	  // malignant nodes
	  else
	  {
	    createSplitLists(row, column, dataBook, list, 0);
	  }
	}
      } 
    }
    
    // print out details of generated tree and no of patients at each node
    System.out.println("0,0 "+ list.getList(0, 0).getFeatures(0));
    
    for (int row = 1; row <= 5; row++) 
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
    // print out the final cost of the generated tree
    System.out.println(finalCost);
  }
}

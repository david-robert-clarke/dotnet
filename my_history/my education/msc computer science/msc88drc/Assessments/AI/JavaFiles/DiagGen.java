import databook.*;
import java.io.*;


/**
   Main program that utilises the decision tree to generates the output

   @author David Clarke Asim Farooq
**/
class DiagGen
{
  public static void main (String[] args) throws IOException, 
						 NoSuchEntryException
  {
    // initialise instance variables
    DataBook data = new DataBook();
    // Load test data from a specified file
    data.load("testingdata.csv");


    // Utilise decision tree
    for (int i = 0; i < data.dataBookSize(); i++)
    {
      
      if (Integer.parseInt(data.getPatient(i).getAge()) >= 45)
      {
	if(data.getPatient(i).getDerMel().equals("0"))
	{
	  data.getPatient(i).setBinDiag("0");
	}
	else
	{
	  if(data.getPatient(i).getBgBin().equals("0"))
	  {
	    data.getPatient(i).setBinDiag("0");
	  }
	  else
	  {
	    data.getPatient(i).setBinDiag("1");
	  }
	}
      }
      else
      {
	if(data.getPatient(i).getDiam7().equals("0"))
	{
	  if(data.getPatient(i).getDiam6().equals("0"))
	  {
	    data.getPatient(i).setBinDiag("0");
	  }
	  else
	  {
	    if(data.getPatient(i).getAsym().equals("0"))
	    {
	      data.getPatient(i).setBinDiag("0");
	    }
	    else
	    {
		data.getPatient(i).setBinDiag("1");

	    }
	  }
	}
	else
	{
	  if(data.getPatient(i).getDispBlus().equals("0"))
	  {
	    data.getPatient(i).setBinDiag("0");
	  }
	  else
	  {
	      data.getPatient(i).setBinDiag("1");
	  }
	}
      }
    }
    

    // write the Diagnosis results to a specified file
    FileWriter thisWriter = new FileWriter("melanoma.diag");
    BufferedWriter writer = new BufferedWriter(thisWriter);
    
    
    for(int i = 0; i < data.dataBookSize(); i++)
    {
      
      writer.write( data.getPatient(i).getBinDiag(),0,1);
      writer.flush();
      
      writer.newLine();
      
    }
      

  }
  
}


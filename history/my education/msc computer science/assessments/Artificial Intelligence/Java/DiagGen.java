import databook.*;
import java.io.*;


/**
   @uthor 
**/
class DiagGen
{
  public static void main (String[] args) throws IOException, NoSuchEntryException
  {
    DataBook data = new DataBook();
    data.load("TrainingData.csv");


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
	      //if(data.getPatient(i).getSize().equals("0"))
	      //{
	      //data.getPatient(i).setBinDiag("0");
	      //}
	      //else
	      //{
		data.getPatient(i).setBinDiag("1");
		//}
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
	    /*if(data.getPatient(i).getSex().equals("M"))
	    {
	      data.getPatient(i).setBinDiag("0");
	    }
	    else
	    {*/
	      data.getPatient(i).setBinDiag("1");
	      //}
	  }
	}
      }
    }

    //OutputStream out = new FileOutputStream("Results.txt");
    //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

    
    FileWriter thisWriter = new FileWriter("Results.txt");
    BufferedWriter writer = new BufferedWriter(thisWriter);
    
    
    for(int i = 0; i < data.dataBookSize(); i++)
    {
      
      writer.write( data.getPatient(i).getBinDiag(),0,1);
      writer.flush();
      
      writer.newLine();
      
    }
      

  }
  
}


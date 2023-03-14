package databook;
import java.util.*;
import java.io.*;

/*
  This class creates a structure that holds all the relevant patient data at 
  each node of the tree and also the cost of the node (based upon the number of
  incorrectly classified patients at that particular node) and all the features
  that have been used in arriving at that node
*/

public class DataBook
{
  private Vector vector;      // will hold all the patient details at the node
  private int cost;
  private Patient patient;
  private String[] features;  // all features used to arrive at this node
  
  /* initialise all variables */

  public DataBook()
  {
    vector = new Vector();
    cost = 0;
    features = new String[50]; // large enough to hold all features
  }

  /* set the specified feature at the specified position in the array */

  public void setFeatures(String feature, int pos)
  {
    features[pos] = feature;
  }

  /* get the feature at the specified position in the array */

  public String getFeatures(int pos)
  {
    return features[pos];
  }
  
  /* check if the specified feature already exists in the array */

  public boolean containsFeature(String feature)
  {
    int i = 0;
    do
    {
      if (feature.equals(features[i])) // found the feature in the array
      {
	return true;
      }
      else
      {
      	i++;
      }
    } while(i < features.length);
    return false; // feature does not exist in the array
  }
  
  /* return the size of the databook (ie the number of patients) */

  public int dataBookSize()
  {
    return vector.size();
  }
  
  /* set the cost */ 

  public void setCost(int c)
  {
    cost = c;
  }
  
  /* add the specified patient to the databook. 
     this method contains a check to ensure that multiple additions of the SAME
     patient cannot occur within the same databook
  */

  public void addPatient(Patient p) throws EntryExistsException
  {
    if (findPatient(p, vector)) // patients already exists
    {
      throw new EntryExistsException("A patient has been added twice.");
    }
    else
    {
      vector.add(p); // partient not found so is added
    }
  }
  
  /* returns the specified patient - throws an exception if the supplied 
     integer doesn't correspond to a valid patient
  */

  public Patient getPatient(int number) throws NoSuchEntryException
  {
    if (number < vector.size()) // number within bounds
    {
      Patient p = (Patient)vector.get(number);
      return p;
    }
    else // number too big
    {
      throw new NoSuchEntryException("Patient not found.");
    }
  }
  
  /* loads the specified file if it exists */

  public Vector load(String filename) throws IOException
  {
    FileReader r = new FileReader(filename);
    BufferedReader reader = new BufferedReader(r);
    
    reader.readLine(); //read first line containing all column names and ignore
    int size = 100;    // number of patients in file (for DiagGen.java this 
                       // was changed to reflect the size of the test data file

    Vector v = new Vector();
    for (int i = 0; i < size; i++)
    {
      Patient p = Line.read(reader);
      v.add(p);
    }
    vector = v;
    reader.close();
    return vector;
  }

  /* private method used only within this class to find a patient in the vector
     Returns true if the patient exists already, false otherwise
  */

  private boolean findPatient(Patient p, Vector vec)
  {
    if (vec.isEmpty()) // deal with simplist case first (ie no patients)
    {
      return false;
    }   
    
    int i = 0;
    do
    {
      patient = (Patient)vec.get(i);
      if (patient.getIdentifier().equals(p.getIdentifier()))
      {
	return true;
      }
      else
      {
      	i++;
      }
    } while(i < vec.size());
    return false;
  }
  
  /* lists all the patients in the databook */

  public Vector listPatients()
  {
    Vector v = new Vector();
    if (vector.isEmpty())
    {
      return v;
    } 

    int i = 0;
    do
    {
      patient = (Patient)vector.get(i);
      String identifier = patient.getIdentifier();
      v.add(identifier);
      i++;
    } while(i < vector.size());
    return v;
  }
}

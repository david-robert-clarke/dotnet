package databook;
import java.util.*;
import java.io.*;

/*
  This class the data structure to hold the tree being built
*/

public class ListHolder
{
  private DataBook[][] tree;
  private Vector vector;
  private int depth;
  private int width;
  
  /* default constructor that creates a tree-like structure to hold all the 
   necessary information for each node of the decision tree
  */
  
  public ListHolder()
  {
    depth = 10;
    tree = new DataBook[depth][];
    for (int i = 0; i < depth; i++)
    {
      tree[i] = new DataBook[(int)Math.pow(2,i)];	//create sub-array
    }
  }
  
  /* add relevant data to the specified node in the tree */

  public void addList(DataBook data, int i, int j)
  {
    tree[i][j] = data;
  }

  /* retrieve data from the specified node in the tree */
  
  public DataBook getList(int i, int j)
  {
    return tree[i][j];
  }
}

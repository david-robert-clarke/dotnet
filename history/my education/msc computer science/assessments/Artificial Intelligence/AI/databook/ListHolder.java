package databook;
import java.util.*;
import java.io.*;


public class ListHolder
{
  private DataBook[][] tree;
  private Vector vector;
  private int depth;
  private int width;
  
  public ListHolder()
  {
    depth = 10;  // 6 changed to 10
    tree = new DataBook[depth][];
    for (int i = 0; i < depth; i++)
    {
      tree[i] = new DataBook[(int)Math.pow(2,i)];	//create sub-array
    }
  }
  
  public void addList(DataBook data, int i, int j)
  {
    tree[i][j] = data;
  }
  
  public DataBook getList(int i, int j)
  {
    return tree[i][j];
  }
}

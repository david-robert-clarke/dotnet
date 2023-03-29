using System;

class Program
{
    private static void Main(string[] args)
    {
        int[] firstArray = { 4, 5, 1, 6, 8 };
        int[] secondArray = { -4, -8, -7 };
        int numberProduct = GetLargestNumberInArray(firstArray) * GetLargestNumberInArray(secondArray);
        Console.WriteLine(numberProduct.ToString());
    }
    
    private static int GetLargestNumberInArray(int[] a) {

        int largestNumber = 0;

        foreach(int number in a){
            
            if(Math.Abs(number) > Math.Abs(largestNumber)){
                largestNumber = number;
            }
        }

        return largestNumber;
    }

}
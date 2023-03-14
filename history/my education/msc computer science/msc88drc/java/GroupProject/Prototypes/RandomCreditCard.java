import java.util.Random;
  
public class RandomCreditCard
{
  public static void main(String [] args)
  { 
    Random myRandom = new Random();
    int randomNumber = myRandom.nextInt();
    
    if(randomNumber < 0) //if random number is negative, make it positive
    {
      randomNumber *= -1;
    }    
    System.out.println("Next random number is:" + randomNumber);


    String randomNumberString = "" + randomNumber;
    int stringLength = randomNumberString.length();//get length of number
    
    //if the number of characters in the random number is less than 16, append
    //zeros at the end
    if(stringLength == 1) randomNumberString += "000000000000000";
    else if(stringLength == 2) randomNumberString += "00000000000000";
    else if(stringLength == 3) randomNumberString += "0000000000000";
    else if(stringLength == 4) randomNumberString += "000000000000";
    else if(stringLength == 5) randomNumberString += "00000000000";
    else if(stringLength == 6) randomNumberString += "0000000000";
    else if(stringLength == 7) randomNumberString += "000000000";
    else if(stringLength == 8) randomNumberString += "00000000";
    else if(stringLength == 9) randomNumberString += "0000000";
    else if(stringLength == 10) randomNumberString += "000000";
    else if(stringLength == 11) randomNumberString += "00000";
    else if(stringLength == 12) randomNumberString += "0000";
    else if(stringLength == 13) randomNumberString += "000";
    else if(stringLength == 14) randomNumberString += "00";
    else if(stringLength == 15) randomNumberString += "0";
    else if(stringLength == 16) randomNumberString += "";

    System.out.println(randomNumberString);
    
  }
}

package StringOperations;

import java.util.List;

public class NumberPalindrome {
}

class NumberPalindromeImpl{
    public void isTheNumberPalindrome(int number, int actualNumber){

       int firstNumbers = number /10;
       int lastDigit = actualNumber%10;
       if(firstNumbers%10 == firstNumbers){
           if(lastDigit != firstNumbers){
               System.out.println("Not palindrome.");
               return;
           }
           else{
               actualNumber = actualNumber/10;
           }
       }
       isTheNumberPalindrome(firstNumbers, actualNumber);
    }
}

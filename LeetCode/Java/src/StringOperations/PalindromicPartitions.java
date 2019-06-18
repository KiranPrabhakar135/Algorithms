package StringOperations;

import java.util.HashSet;

public class PalindromicPartitions {
    public static void main(String[] args){
        PalindromicPartitionsImpl impl = new PalindromicPartitionsImpl();
        //testPalindrome(impl);
        String input = "sdfeferserdddsdrsfsadfasasces";
        impl.partitions(input);
        impl.printPalindromesFromSet();
    }

    private static void testPalindrome(PalindromicPartitionsImpl impl) {
        String input = "malayalam";
        if(impl.isPalindrome(input)){
            impl.printPalindromicPartitions(input);
        }
        else {
            System.out.println("The string is NOT a palindrome");
        }
    }

}

class PalindromicPartitionsImpl{
    public static HashSet<String> partitions = new HashSet();
    public void partitions(String input){
        if(input.length() > 1){
            if(!partitions.contains(input) && isPalindrome(input)){
                partitions.add(input);
                //printPalindromicPartitions(input);
            }
            partitions(input.substring(0,input.length()-1));
            partitions(input.substring(1));
        }
    }
    public boolean isPalindrome(String input){
        int length = input.length();
        if(length <= 1){
            return true;
        }
        if(input.charAt(0) == input.charAt(length-1)){
            return isPalindrome(input.substring(1,length - 1));
        }
        else {
            return false;
        }
    }
    public void printPalindromicPartitions(String input){
        if(input.length() > 1){
            System.out.println(input);
            printPalindromicPartitions(input.substring(1,input.length()-1));
        }
    }

    public void printPalindromesFromSet(){
        for (String s :
                partitions) {
            System.out.println(s);
        }
    }
}

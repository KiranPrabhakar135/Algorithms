package StringOperations;

import java.util.ArrayList;
import java.util.List;

public class EvenOddJump {
    public  static void main(String[] args){

    }
    public int EvenOddJumpString(int[] inputArray){
        int inputLength = inputArray.length;
        List<Integer> possiblePositions = new ArrayList<>();
        int[] evenDPArray = new int[inputLength];
        int[] oddDPArray = new int [inputLength];
        evenDPArray[inputLength - 1] = 1;
        oddDPArray[inputLength - 1] = 1;
        for (int i = inputLength-2; i >= 0; i--){
            if(inputArray[i] < 0){

            }
        }
        return 0;
    }
}

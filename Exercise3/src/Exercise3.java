import java.util.*;

/**
 * Created by Brandon Braun on 3/2/2015.
 * This program will:
 * 1. generate 10,000 random numbers between 1 and 30,000
 * 2. save these numbers in Integer [] and in java.util.ArrayList
 * 3. show the CPU time used to sort these number stored in Integer []
 * 4. show the CPU time used to sort these numbers stored in ArrayList
 */
public class Exercise3 {
    public static void main(String[] args) {
        Random r = new Random();
        Integer temp;
        Integer[] randomNumbersIntegerArray = new Integer[10000];
        ArrayList<Integer> randomNumbersArrayList = new ArrayList<Integer>();

        // set random numbers
        for (int k = 0; k < 10000; k++) {
            randomNumbersIntegerArray[k] = r.nextInt(30000) + 1;
            randomNumbersArrayList.add(k, randomNumbersIntegerArray[k]);
        }

        // time bubble sort on Integer Array
        long startTimeIntegerArray = System.currentTimeMillis(); // start time
        for (int i = 0; i < 9999; i++) {
            for (int j = 1; j < 10000-i; j++) {
                if (randomNumbersIntegerArray[j-1] > randomNumbersIntegerArray[j]) {
                    temp = randomNumbersIntegerArray[j - 1];
                    randomNumbersIntegerArray[j - 1] = randomNumbersIntegerArray[j];
                    randomNumbersIntegerArray[j] = temp;
                }
            }
        }
        long endTimeIntegerArray = System.currentTimeMillis(); // end time

        // tune bubble sort on Array List
        long startTimeArrayList = System.currentTimeMillis();
        for (int i =0; i < 9999; i++) {
            for (int j = 1; j < 10000-i; j++) {
                temp = randomNumbersArrayList.get(j - 1);
                randomNumbersArrayList.set(j-1, randomNumbersArrayList.get(j));
                randomNumbersArrayList.set(j, temp);
            }
        }
        long endTimeArrayList = System.currentTimeMillis();

        System.out.println("CPU time used for bubble sort on Integer Array: " + (endTimeIntegerArray - startTimeIntegerArray) + " ms");
        System.out.println("CPU time used for bubble sort on Array List: " + (endTimeArrayList - startTimeArrayList) + " ms");
    } // main
}

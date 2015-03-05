import java.util.*;

/**
 * Created by Brandon Braun on 3/4/2015.
 * Develop a Java program to compare the CPU efficiency between the use of
 * java.util.ArrayList and java.util.Vector in sorting 100,000 numbers.
 * This program will:
 *      1. generate 100,000 random numbers between 1 and 300,000
 *      2. save these numbers in
 *          Vector <Integer>
 *          ArrayList <Integer>
 *      3. show the CPU time used to sort these numbers stored in Vector
 *      4. show the CPU time used to sort these numbers stored in ArrayList
 * The program is expected to generate 2 lines as its output
 */
public class Project1 {
    public static void main(String[] args) {
        Random r = new Random();
        Vector<Integer> numbersVect = new Vector<Integer>(100000);
        ArrayList<Integer> numbersArryList = new ArrayList<Integer>(100000);
        long startTimeVect;
        long endTimeVect;
        long startTimeArryLst;
        long endTimeArryLst;
        Integer temp;

        for (int i = 0; i < 100000; i++) {
            numbersVect.addElement(r.nextInt(300000) + 1);
            numbersArryList.add(numbersVect.get(i));
        }

        // time sort for vector
        startTimeVect = System.currentTimeMillis();
        Collections.sort(numbersVect);
        endTimeVect = System.currentTimeMillis();

        //time sort for arraylist
        startTimeArryLst = System.currentTimeMillis();
        Collections.sort(numbersArryList);
        endTimeArryLst = System.currentTimeMillis();

        System.out.println("CPU time used for sort on Integer Vector: " + (endTimeVect - startTimeVect) + " ms");
        System.out.println("CPU time used for sort on Integer Array List: " + (endTimeArryLst - startTimeArryLst) + " ms");
    }
}

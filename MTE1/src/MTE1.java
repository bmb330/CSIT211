import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Brandon Braun on 3/14/2015.
 * This program will:
 *      generate 100,000 random numbers and save them into
 *          Vector <Integer>
 *          ArrayList <Integer>
 *      show the memory used to store these numbers in Vector
 *      show the memory used to store these numbers in ArrayList
 * The program is expected to generate 2 lines as its output.
 *
 * Conclusion: in this case, Vector<Integer> uses less memory then ArrayList<Integer>
 */
public class MTE1 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Random r = new Random();
        Vector<Integer> numbersVect = new Vector<Integer>();
        ArrayList<Integer> numbersArryList = new ArrayList<Integer>();
        long mem = rt.totalMemory() - rt.freeMemory();

        for (int i = 0; i < 100000; i++) {
            numbersVect.addElement(r.nextInt());
        }
        System.out.println("100,000 Integers in Vector used: " + ((rt.totalMemory() - rt.freeMemory()) - mem) + " bytes");
        mem = rt.totalMemory() - rt.freeMemory();

        numbersArryList = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            numbersArryList.add(r.nextInt());
        }
        System.out.println("100,000 Integers in ArrayList used: " + ((rt.totalMemory() - rt.freeMemory()) - mem) + " bytes");
    }
}

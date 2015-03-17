import java.util.*;

/**
 * Created by Brandon Braun on 3/14/2015.
 *
 * This program will:
 *      1. generate 100,000 random numbers and save them into
 *          ArrayList <Integer>
 *          LinkedList <Integer>
 *      2. show the memory used to store these numbers in ArrayList
 *      3. show the memory used to store these numbers in LinkedList
 *      4. show the CPU time used to sort these numbers stored in ArrayList using Insertion sort
 *      5. show the CPU time used to sort these numbers stored in LinkedList using Insertion sort
 * Insertion sort must be used to sort these numbers.)
 *
 * The program is expected to generate 4 lines as its output.
 */
public class MTE2 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Random r = new Random();
        LinkedList<Integer> numbersLinkList = new LinkedList<Integer>();
        ArrayList<Integer> numbersArryList = new ArrayList<Integer>();
        long cpuTimeStart;
        long cpuTimeEnd;
        long mem;
        Integer n;

        // test ArrayList
        mem = rt.totalMemory() - rt.freeMemory(); //start memory usage
        cpuTimeStart = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            insert(numbersArryList, r.nextInt());
        }
        cpuTimeEnd = System.currentTimeMillis();

        System.out.println("Memory used for ArrayList of 100,000 items: " +
                ((rt.totalMemory() - rt.freeMemory()) - mem));

        System.out.println("CPU time for insertion sort on ArrayList of 100,000 items: " +
                (cpuTimeEnd - cpuTimeStart));

        // test LinkedList
        mem = rt.totalMemory() - rt.freeMemory(); //start memory usage
        cpuTimeStart = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            insert(numbersLinkList, r.nextInt());
        }
        cpuTimeEnd = System.currentTimeMillis();

        System.out.println("Memory used for LinkedList of 100,000 items: " +
                ((rt.totalMemory() - rt.freeMemory()) - mem));

        System.out.println("CPU time for insertion sort on LinkedList of 100,000 items: " +
                (cpuTimeEnd - cpuTimeStart));
    }

    static void insert(List<Integer> nList, Integer number) {
        if (nList.size() < 1) {
            nList.add(number);
        }
        int index = 0;
        for (Integer i : nList) {
            if (i.intValue() > number.intValue()) {
                nList.add(index, number);
            }
            ++index;
        }
        if (index >= nList.size()) {
            nList.add(number);
        }
    }
}
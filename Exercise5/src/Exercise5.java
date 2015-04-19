import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Brandon Braun on 4/19/15.
 * This program will:
 *      1. Generate 200,000 random numbers between 1 and 500,000
 *      2. Store these 200,000 random numbers in two data structures
 *              HashMap<Integer, Integer> map = new HashMap<integer, Integer>();
 *              Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
 *      3. Show the memory used by HashMap
 *      4. Show the memory used by Hashtable
 *      5. For each data structure, show the total time used to search for 5 numbers:
 *              270199, 702988, 67747, 5002, 32666
 */

public class Exercise5{
    public static void main(String[] args) {
        final int[] numbers = new int[]{270199, 702988, 67747, 5002, 32666 };
        Runtime rt = Runtime.getRuntime();
        long mem;
        long cpuTimeStart;
        long cpuTimeStop;
        Random rand = new Random();
        HashMap<Integer, Integer> map;
        Hashtable<Integer, Integer> hash;
        Integer[] randNumbs = new Integer[200000];

        for (int i = 0; i < 200000; i++) {
            randNumbs[i] = rand.nextInt(500000);
        }

        mem = rt.totalMemory() - rt.freeMemory();
        map = new HashMap<Integer, Integer>(1000);
        for (int i : randNumbs) {
            map.put(i, i);
        }
        System.out.println("Memory used by HashMap : " + ((rt.totalMemory() - rt.freeMemory()) - mem) + " bytes");

        mem = rt.totalMemory() - rt.freeMemory();
        hash = new Hashtable<Integer, Integer>(1000);
        for (int i : randNumbs) {
            hash.put(i, i);
        }
        System.out.println("Memory used by HashMap : " + ((rt.totalMemory() - rt.freeMemory()) - mem) + " bytes");

        cpuTimeStart = System.currentTimeMillis();
        for (int i : numbers) {
            map.containsValue(i);
        }
        cpuTimeStop = System.currentTimeMillis();
        System.out.println("CPU time used by HashMap : " + (cpuTimeStop - cpuTimeStart) + " milliseconds.");

        cpuTimeStart = System.currentTimeMillis();
        for (int i : numbers) {
            hash.containsValue(i);
        }
        cpuTimeStop = System.currentTimeMillis();
        System.out.println("CPU time used by HashMap : " + (cpuTimeStop - cpuTimeStart) + " milliseconds.");
    }
}

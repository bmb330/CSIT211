import java.io.*;
import java.util.*;

/**
 * Created by Brandon Braun on 2/15/15 for CSIT211.
 *
 * Objective:
 *      Read one line at a time from a text file
 *      (Input file name can be hard-coded.)
 *      You may use ex2input.txt to test your program.
 *      Divide each line into tokens
 *      Identify each token as one of the following
 *          Street number
 *          Street name
 *          City name
 *          State
 *          Zip code
 *      Validate the state, ignoring the case sensitivity
 *          display an error message if the state is invalid
 *
 * Input line format:
 *      StreetNumber StreetName, CityName, State ZipCode
 */
public class Exercise2 {
    

    public static void main(String[] args) {
        ArrayList<String> states;
        BufferedReader inFile;
        String nextLine;

        if (args.length != 1) {
            System.err.println("Usage: java Exercise2 filename");
            System.exit(1);
        }
        states = getStateList("states.txt");

        try {
            inFile = new BufferedReader(new FileReader(args[0]));

            while ((nextLine = inFile.readLine()) != null) {
                addAddress(nextLine);
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            // error finding file
            e.printStackTrace();
        } catch (IOException e) {
            // error closing file
            e.printStackTrace();
        }
    }

    protected static ArrayList<String> getStateList(String stateListFile) {
        // returns ArrayList<String> containing the state abbreviation

        ArrayList<String> stateList = new ArrayList<String>();

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(stateListFile));
            String nextLine;

            while ((nextLine = inFile.readLine()) != null) {
                StringTokenizer strtkn = new StringTokenizer(nextLine,",");
                stateList.add(strtkn.nextToken());
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            // error finding file
            e.printStackTrace();
        } catch (IOException e) {
            // error reading line or closing file
            e.printStackTrace();
        }

        return stateList;
    }

    protected static ArrayList<String> tokenizeAddress(String line) {
        // returns StringTokenizer containing the tokenized address
        ArrayList<String> address;

        address = new ArrayList<String>();

        for (String s : line.split(",")) {
            if (s.matches("\\d+\\s+\\w+") || s.matches("\\w+\\s+\\d+")) {
                for (String splitString : s.split("\\s+", 2)) {
                    address.add(splitString);
                }
            }
            else {
                address.add(s);
            }
        }

        return address;
    }

    protected static
}

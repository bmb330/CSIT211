import javax.swing.*;
import java.io.*;

/**
 * Created by Brandon Braun on 2/7/15 for CSIT211.
 *
 * Objective:
 *      Develop a Java program to perform a file merge operation.
 *
 * This program will:
 *      (1) prompt the user to enter two input file names and an output file name.
 *      (2) merge the two input files into the output file.
 *
 * Sample run:
 *      Enter the first input file name: FileA
 *      Enter the second input file name: FileB
 *      Enter the output file name: OutFile
 *      Files merged!
 */
public class Exercise1 {

    // main function
    public static void main(String[] args) {
        mergeFiles(getUserInput("Enter the first input file name"), getUserInput("Enter the second input file name"), getUserInput("Enter the output file name"));

        System.out.println("Files merged");
    }

    static void mergeFiles(String firstFile, String secondFile, String mergeFile) {
        try {
            File file = new File(mergeFile);
            file.createNewFile();

            writeFileToFile(firstFile, file);
            writeFileToFile(secondFile, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeFileToFile(String inputFile, File toFile) {
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(inputFile));
            FileWriter fileWriter = new FileWriter(toFile, true);
            String nextLine;
            while((nextLine = inFile.readLine()) != null) {
                fileWriter.write(nextLine + "\n");
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ask user for input and return that input
    static String getUserInput(String question) {
        String value = null;
        try {
            BufferedReader bufferedRead;
            System.out.println(question + ": ");
            bufferedRead = new BufferedReader(new InputStreamReader(System.in));
            value = bufferedRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return value;
        }
    }
}

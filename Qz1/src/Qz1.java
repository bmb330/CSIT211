import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Brandon Braun on 3/26/2015.
 *
 * This program
 *      1. Reads data records from the input file. Books.txt, into a java.util.ArrayList object
 *      2. Prompts the user to enter a publish year
 *      3. Displays all books that match the user entered publish year
 *
 * Each book record has four attributes:
 *      ID Title YearPublished Author
 *
 * Assuming the book records are saved in the file “books.txt”.
 * Each book record has 3 lines. Shown below is a sample record.
 *      1200 2011
 *      Java For Beginners
 *      Jane Doe
 *
 * Sample Run:
 *      C:\> java Qz1
 *      Which publish year are you looking for? 2009
 *      1300 Home Sweet Home 2009 Elva Smith
 *      1100 C++ Programming 2009 James Doe
 *
 */
public class Qz1 {
    public static void main(String[] args) {
        ArrayList<Book> bookList;
        int year;

        bookList = readBooks("books.txt");
        year = Integer.parseInt(getUserInput("Which publish year are you looking for"));
        printBookByYear(bookList, year);

    }

    private static ArrayList<Book> readBooks(String bookFile) {
        ArrayList<Book> bookList = new ArrayList<Book>();
        BufferedReader inFile;
        String nextLine;
        int counter = 0;
        String[] temp;

        try {
            //inFile = new BufferedReader(new FileReader(args[0]));
            inFile = new BufferedReader(new FileReader(bookFile));
            Book book = null;

            while ((nextLine = inFile.readLine()) != null) {
                if (nextLine.matches("\\d+\\s+\\d+")) {
                    counter = 0;
                    temp = nextLine.split("\\s+");
                    book = new Book(Integer.parseInt(temp[0]), "", Integer.parseInt(temp[1]), "");
                    bookList.add(book);
                }
                else {
                    switch (counter) {
                        case 0:
                            book.setTitle(nextLine);
                            counter++;
                            break;
                        case 1:
                            book.setAuthor(nextLine);
                    }
                }
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            // error finding file
            e.printStackTrace();
        } catch (IOException e) {
            // error closing file
            e.printStackTrace();
        }

        return bookList;
    }

    private static void printBookByYear(ArrayList<Book> bookList, int year) {
        String books = "";
        for (Book book : bookList) {
            if (book.getYear() == year) {
                System.out.println(book.getID() + " " + book.getTitle() + " " + book.getYear() + " " + book.getAuthor());
            }
        }
    }

    private static String getUserInput(String question) {
        String value = null;
        try {
            BufferedReader bufferedRead;
            System.out.println(question + ": ");
            bufferedRead = new BufferedReader(new InputStreamReader(System.in));
            value = bufferedRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}

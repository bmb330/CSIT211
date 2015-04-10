import java.io.*;
import java.util.*;

/**
 * Created by Brandon Braun on 4/8/15.
 */
public class Qz2 {
    public static void main(String[] args) {
        Map<Integer, List<Book>> hmap;
        int year;

        hmap = createMap("books.txt");
        year = Integer.parseInt(getUserInput("Which publish year are you looking for"));
        printBookByYear(hmap, year);
    }

    private static Map<Integer, List<Book>> createMap(String bookFile) {
        BufferedReader inFile;
        String nextLine;
        int counter = 0;
        String[] temp;
        Map<Integer, List<Book>> hmap;
        hmap = new HashMap<Integer, List<Book>>();

        try {
            inFile = new BufferedReader(new FileReader(bookFile));
            Book book = null;

            while ((nextLine = inFile.readLine()) != null) {
                if (nextLine.matches("\\d+\\s+\\d+")) {
                    counter = 0;
                    temp = nextLine.split("\\s+");
                    book = new Book(Integer.parseInt(temp[0]), "", Integer.parseInt(temp[1]), "");
                    if (!hmap.containsKey(book.getYear())) {
                        hmap.put(book.getYear(), new ArrayList<Book>());
                        hmap.get(book.getYear()).add(book);
                    }
                    else {
                        hmap.get(book.getYear()).add(book);
                    }
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

        return hmap;
    }

    private static void printBookByYear(Map<Integer, List<Book>> bookList, int year) {
        for(Book book : (bookList.get(year))) {
            System.out.println(book.getID() + " " + book.getTitle() + " " + book.getYear() + " " + book.getAuthor());
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

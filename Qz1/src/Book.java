/**
 *	The Book class has 4 attributes:
 *	ID, Title, Year Published, Author.
 */
public class Book implements java.io.Serializable {
    int ID; String title;
    int year;
    String author;

    public Book(int i, String t, int y, String a) {
        ID = i; title = t; year = y; author = a;	}
        public int getID() { return ID; }
        public String getTitle() { return title; }
        public int getYear() { return year;}
        public String getAuthor() { return author; }
        public void setTitle(String t) { title = t; }
        public void setYear(int y) { year = y; }
        public void setAuthor(String a) { author = a; }
        public String toString() {return ID + " " + title + " " + year + " " + author; }
} // Book
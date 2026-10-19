public class Book {
    String title;
    String author;
    int year;

    public String describe() {
        return String.format("%s by %s (%d)", title, author, year);
    }
}

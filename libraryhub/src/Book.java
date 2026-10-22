public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private boolean available;

    private static int nextId = 1;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;

        this.id = nextId;
        nextId += 1;

        // book is not put of shelf yet
        this.available = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("%d. %s - %s (%d) : %s", id, title, author, year, available ? "Available" : "Unavailable");
    }
}

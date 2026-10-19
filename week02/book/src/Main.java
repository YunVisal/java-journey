public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Atomic Habit";
        book1.author = "James Clear";
        book1.year = 2018;
        System.out.println(book1.describe());

        Book book2 = new Book();
        book2.title = "48 rules of Powers";
        book2.author = "Robert Green";
        book2.year = 1982;
        System.out.println(book2.describe());

        Book book3 = new Book();
        book3.title = "Psychology of Money";
        book3.author = "Robert Green";
        book3.year = 1982;
        System.out.println(book3.describe());
    }
}

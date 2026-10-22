import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[100];
        int bookCursor = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Library Management System =====");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Add book");
            System.out.println("2. List books");
            System.out.println("3. Find by title");
            System.out.println("4. Exit");

            System.out.print("Enter option: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    if(bookCursor >= books.length) {
                        System.out.println("Cannot add more book");
                        break;
                    }

                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    books[bookCursor] = new Book(bookTitle, author, year);
                    bookCursor += 1;
                    break;
                case 2:
                    if(bookCursor == 0) {
                        System.out.println("No books added yet!");
                        break;
                    }
                    for(int i = 0; i < bookCursor; i++) {
                        System.out.println(books[i]);
                    }
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String searchTitle = scanner.nextLine();
                    System.out.println("==========");
                    System.out.println("Search result:");
                    int matchedTitle = 0;
                    for(int i = 0; i < bookCursor; i++) {
                        if(books[i].getTitle().toLowerCase(Locale.ROOT).contains(searchTitle.toLowerCase(Locale.ROOT))) {
                            System.out.println(books[i]);
                            matchedTitle += 1;
                        }
                    }
                    if(matchedTitle == 0) {
                        System.out.println("No book title matched!");
                    }
                    break;
                case 4:
                    System.out.println("Bye bye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            System.out.println("==========");
        }
    }
}

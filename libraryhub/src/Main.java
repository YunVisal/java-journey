import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] books = new String[100];
        int bookCursor = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Library Management System =====");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Add book");
            System.out.println("2. List books");
            System.out.println("3. Exit");

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
                    books[bookCursor] = bookTitle;
                    bookCursor += 1;
                    break;
                case 2:
                    if(bookCursor == 0) {
                        System.out.println("No books added yet!");
                        break;
                    }
                    for(int i = 0; i < bookCursor; i++) {
                        System.out.printf("%d. %s%n", i+1, books[i]);
                    }
                    break;
                case 3:
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

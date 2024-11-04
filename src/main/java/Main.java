import java.util.ArrayList;
import java.util.List;

/**
 * Main class that serves as the entry point for the library system application.
 */
public class Main {

    /**
     * The main method where the application logic is executed.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Ex1: Check if arrays are sorted
        int[] array1 = {1, 3, 7, 10}; // An array sorted in ascending order
        int[] array2 = {9, 5, 3, 1};  // An array sorted in descending order
        int[] array3 = {10, 9, 3, 12}; // An array not sorted

        // Print the results of the isSorted method for each array
        System.out.println(IsSorted.isSorted(array1)); // Expected output: true
        System.out.println(IsSorted.isSorted(array2)); // Expected output: true
        System.out.println(IsSorted.isSorted(array3)); // Expected output: false

        // Ex2: Library management
        List<Book> library = new ArrayList<>(); // Create a list to hold books
        Librarian librarian = new Librarian("Dan", "L1"); // Create a librarian
        Member member = new Member("Sara", "M1"); // Create a library member

        // Adding books to the library
        Book book1 = new Book("Java ", "AAA", "B1"); // Create a book
        Book book2 = new Book("C#", "BBB", "B2"); // Create another book

        // Librarian adds books to the library
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        // Member borrows a book
        member.borrowBook(book1);
        member.displayInfo(); // Display member's info after borrowing

        // Member returns the book
        member.returnBook(book1);
        member.displayInfo(); // Display member's info after returning

        // Display the librarian's information
        librarian.displayInfo();
    }
}

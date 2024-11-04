import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library member who can borrow and return books.
 * Inherits from the User class.
 */
public class Member extends User {
    private List<Book> borrowedBooks; // List of books borrowed by the member
    private static final int MAX_BOOKS = 3; // Maximum number of books a member can borrow

    /**
     * Constructs a Member with a name and ID.
     *
     * @param name The name of the member.
     * @param id   The unique identifier for the member.
     */
    public Member(String name, String id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>(); // Initializes the list of borrowed books
    }

    /**
     * Allows the member to borrow a book if they have not exceeded the limit and the book is available.
     *
     * @param book The book to be borrowed.
     * @return true if the book was successfully borrowed, false otherwise.
     */
    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < MAX_BOOKS && book.isAvailable()) {
            book.setAvailability(false); // Mark the book as unavailable
            borrowedBooks.add(book); // Add the book to the list of borrowed books
            System.out.println("Book borrowed: " + book.getTitle());
            return true;
        } else {
            System.out.println("Cannot borrow book: " + book.getTitle());
            return false;
        }
    }

    /**
     * Allows the member to return a book they have borrowed.
     *
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) { // Remove the book from the borrowed list
            book.setAvailability(true); // Mark the book as available
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book not found in borrowed list: " + book.getTitle());
        }
    }

    /**
     * Displays the member's information, including the number of books borrowed.
     */
    @Override
    public void displayInfo() {
        System.out.println("Member Name: " + name + ", ID: " + id + ", Borrowed Books: " + borrowedBooks.size());
    }
}

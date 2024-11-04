import java.util.ArrayList;
import java.util.List;

/**
 * Represents a librarian in the library system.
 * This class allows librarians to manage books in the library.
 * It inherits from the User class.
 */
public class Librarian extends User {

    /**
     * Constructs a Librarian with a specified name and ID.
     *
     * @param name The name of the librarian.
     * @param id   The unique identifier for the librarian.
     */
    public Librarian(String name, String id) {
        super(name, id); // Initialize the user with name and ID
    }

    /**
     * Adds a book to the library.
     *
     * @param library The list representing the library.
     * @param book    The book to be added to the library.
     */
    public void addBook(List<Book> library, Book book) {
        library.add(book); // Add the book to the library list
        System.out.println("Book added: " + book.getTitle());
    }

    /**
     * Removes a book from the library.
     *
     * @param library The list representing the library.
     * @param book    The book to be removed from the library.
     */
    public void removeBook(List<Book> library, Book book) {
        if (library.remove(book)) { // Attempt to remove the book from the library
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found in library: " + book.getTitle());
        }
    }

    /**
     * Displays the librarian's information, including their name and ID.
     */
    @Override
    public void displayInfo() {
        System.out.println("Librarian Name: " + name + ", ID: " + id);
    }
}

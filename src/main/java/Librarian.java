import java.util.ArrayList;
import java.util.List;
public class Librarian extends User{
    public Librarian(String name, String id) {
        super(name, id);
    }

    public void addBook(List<Book> library, Book book) {
        library.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(List<Book> library, Book book) {
        if (library.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found in library: " + book.getTitle());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Librarian Name: " + name + ", ID: " + id);
    }
}
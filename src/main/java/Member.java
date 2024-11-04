import java.util.ArrayList;
import java.util.List;
public class Member extends User{
    private List<Book> borrowedBooks;
    private static final int MAX_BOOKS = 3;

    public Member(String name, String id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < MAX_BOOKS && book.isAvailable()) {
            book.setAvailability(false);
            borrowedBooks.add(book);
            System.out.println("Book borrowed: " + book.getTitle());
            return true;
        } else {
            System.out.println("Cannot borrow book: " + book.getTitle());
            return false;
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailability(true);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book not found in borrowed list: " + book.getTitle());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Member Name: " + name + ", ID: " + id + ", Borrowed Books: " + borrowedBooks.size());
    }
}

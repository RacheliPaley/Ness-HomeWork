import java.util.ArrayList;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        // Creating a list to represent the library
        List<Book> library = new ArrayList<>();

        // Creating a librarian and a member
        Librarian librarian = new Librarian("Dan", "11");
        Member member = new Member("Sara", "22");

        // Adding books to the library
        Book book1 = new Book("Java", "AAA", "11");
        Book book2 = new Book("C#", "BBB", "22");

        // Librarian adds books to the library
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        // Member borrows a book
        member.borrowBook(book1);
        member.displayInfo(); // Displaying member information after borrowing

        // Member returns the book
        member.returnBook(book1);
        member.displayInfo(); // Displaying member information after returning the book

        // Displaying librarian's information
        librarian.displayInfo();
    }
}

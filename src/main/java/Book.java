/**
 * Represents a book in the library system.
 * This class contains information about the book, including its title, author, availability status, and ID.
 */
public class Book {
    private String title;        // The title of the book
    private String author;       // The author of the book
    private boolean isAvailable; // Indicates whether the book is available for borrowing
    private String id;           // The unique identifier for the book

    /**
     * Constructs a Book with a specified title, author, and ID.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @param id     The unique identifier for the book.
     */
    public Book(String title, String author, String id) {
        this.title = title;       // Initialize the book's title
        this.author = author;     // Initialize the book's author
        this.isAvailable = true;  // The book is available by default
        this.id = id;             // Initialize the book's ID
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Checks if the book is available for borrowing.
     *
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param isAvailable The new availability status of the book.
     */
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable; // Update the book's availability status
    }

    /**
     * Displays the information about the book, including title, author, ID, and availability.
     */
    public void displayInfo() {
        System.out.println("Book Title: " + title + ", Author: " + author +
                ", ID: " + id + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

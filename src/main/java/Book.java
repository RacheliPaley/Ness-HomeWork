public class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    private String id;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // הספר זמין בהתחלה
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title + ", Author: " + author + ", ID: " + id + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

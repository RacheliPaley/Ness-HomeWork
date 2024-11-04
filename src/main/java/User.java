/**
 * Abstract class representing a user in the library system.
 * This class serves as a base for different types of users, such as members and librarians.
 */
public abstract class User {
    protected String name; // The name of the user
    protected String id;   // The unique identifier for the user

    /**
     * Constructs a User with a specified name and ID.
     *
     * @param name The name of the user.
     * @param id   The unique identifier for the user.
     */
    public User(String name, String id) {
        this.name = name; // Initialize the user's name
        this.id = id;     // Initialize the user's ID
    }

    /**
     * Abstract method to display user information.
     * This method must be implemented by subclasses to provide specific user details.
     */
    public abstract void displayInfo();
}

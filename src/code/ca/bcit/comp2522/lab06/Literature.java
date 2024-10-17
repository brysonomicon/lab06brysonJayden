package ca.bcit.comp2522.lab06;

// Literature is the abstract parent class for all types that
// will fit into the BookStore

/**
 * The {@code Literature} class is an abstract class that serves as the parent class
 * for all types of literature that will be used in the {@code BookStore}.
 *
 * <p>
 * This class defines a contract through the abstract method {@code getTitle()},
 * which must be implemented by any subclass of {@code Literature} to return the title
 * of the specific piece of literature.
 * </p>
 *
 * <p>
 * Subclasses of {@code Literature} might include various forms of written works, such as
 * books, comic books, and other types that will be handled within the {@code BookStore}.
 * </p>
 *
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 */
public abstract class Literature
{

    /**
     * Returns the title of the piece of literature.
     *
     * <p>
     * This is an abstract method that must be implemented by subclasses to provide
     * the title of the specific piece of literature.
     * </p>
     *
     * @return the title of the literature
     */
    public abstract String getTitle();
}
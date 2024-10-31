package ca.bcit.comp2522.lab06;

/**
 * Represents a magazine in the bookstore system, inheriting from the {@link Literature} superclass.
 * Each magazine has a title, which is set at instantiation and cannot be changed afterward.
 * The class also contains a predefined list of magazine titles as a constant.
 *
 * <p>Examples of magazine titles include "Time", "National Geographic", and "The New Yorker".
 * This class provides methods to retrieve the title of a magazine and a string representation
 * for display purposes.</p>
 *
 * <p>The {@code Magazine} class overrides the {@code getTitle()} method from the {@code Literature}
 * superclass to provide a specific implementation for magazine titles. It also includes an
 * overridden {@code toString()} method for a formatted string output of magazine details.</p>
 *
 * <p>This class is primarily used to create instances of magazine objects that can be
 * managed and displayed within a bookstore system.</p>
 *
 * @version 1.0
 * @see Literature
 * @since 1.0
 */
public class Magazine
        extends Literature
{

    /**
     * A constant array of popular magazine titles. These titles serve as examples or defaults
     * that may be associated with {@code Magazine} objects. The array includes a variety of
     * well-known publications, ranging from lifestyle to scientific journals.
     */
    public static final String[] TITLES = {
            "Time", "National Geographic", "The New Yorker", "Vogue", "Forbes", "Sports Illustrated", "Rolling Stone",
            "Scientific American", "The Atlantic", "Harper's Bazaar", "Wired", "GQ", "Esquire", "The Economist",
            "Newsweek", "Popular Mechanics", "National Review", "Vanity Fair", "Nature", "Smithsonian", "People",
            "Good Housekeeping", "Reader's Digest", "Cosmopolitan", "Entertainment Weekly", "Men's Health",
            "Women's Health", "Seventeen", "Better Homes & Gardens", "Family Circle", "PC Magazine", "Car and Driver",
            "Architectural Digest", "Fortune", "Bloomberg Businessweek", "The Nation", "New Scientist", "Mother Jones",
            "Travel + Leisure", "Motor Trend", "Outdoor Life", "Southern Living", "Cooking Light", "Food & Wine",
            "Field & Stream", "Inc.", "Entrepreneur", "Golf Digest", "Condé Nast Traveler"
    };


    private final String title;

    /**
     * Constructs a {@code Magazine} object with the specified title.
     *
     * @param title the title of the magazine. This should be one of the popular titles from
     *              the {@link #TITLES} array, though any title is technically allowed.
     */
    public Magazine(final String title)
    {
        this.title = title;
    }

    /**
     * Returns the title of the magazine.
     *
     * @return a {@code String} representing the title of this magazine instance.
     */
    @Override
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns a string representation of the magazine, including the class name and title.
     *
     * @return a formatted {@code String} that identifies the object as a {@code Magazine}
     * and displays its title.
     */
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + title;
    }
}
package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Represents a novel in the bookstore system, inheriting from the {@link Literature} superclass
 * and implementing the {@link Listable} interface to support listing operations.
 * Each novel has a title, which is set upon creation and cannot be modified afterward.
 *
 * <p>This class contains a predefined list of popular novel titles, accessible through a constant array.
 * The titles span a wide range of genres and styles, representing classic and modern works.</p>
 *
 * <p>The {@code Novel} class includes methods to retrieve the title of the novel and a formatted string
 * representation of the object. Additionally, it provides a method for creating a list of {@code Novel}
 * objects based on an array of titles and a specified constructor function.</p>
 *
 * @version 1.0
 * @see Literature
 * @see Listable
 * @since 1.0
 */
public class Novel
        extends Literature
        implements Listable< Novel >
{

    /**
     * A constant array of popular novel titles. This array can be used to instantiate
     * {@code Novel} objects by selecting titles from this list. The titles include a
     * diverse range of well-known novels such as "1984" and "To Kill a Mockingbird".
     */
    public static final String[] TITLES = { "The Adventures of Augie March", "All the King's Men", "American " +
            "Pastoral", "An American Tragedy", "Animal Farm", "Appointment in Samarra",
                                            "Are You There God? It's Me " + "Margaret.", "The Assistant", "At " +
                                                    "Swim-Two-Birds", "Atonement", "Beloved", "The Berlin Stories",
                                            "The Big Sleep", "The Blind Assassin", "Blood Meridian", "Brideshead " +
                                                    "Revisited", "The Bridge of San Luis Rey", "Call It Sleep",
                                            "Catch-22", "The Catcher in the Rye", "A Clockwork " + "Orange", "The " +
                                                    "Confessions of Nat Turner", "The Corrections", "The Crying of " +
                                                    "Lot 49", "A Dance to the Music of Time", "The Day of the " +
                                                    "Locust", "Death Comes for the Archbishop", "A Death in the " +
                                                    "Family", "The Death of the Heart", "Deliverance", "Dog Soldiers"
            , "Falconer", "The French Lieutenant's Woman", "The Golden Notebook", "Go Tell It on the Mountain", "Gone"
                                                    + " with the Wind", "The Grapes of Wrath", "Gravity's Rainbow",
                                            "The Great Gatsby", "A Handful of Dust", "The Heart Is a Lonely Hunter",
                                            "The Heart of the Matter", "Herzog", "Housekeeping",
                                            "A House for Mr. " + "Biswas", "I Claudius", "Infinite Jest", "Invisible " +
                                                    "Man", "Light " + "in August", "The Lion The Witch and the " +
                                                    "Wardrobe", "Lolita", "Lord of the Flies", "The Lord of the " +
                                                    "Rings", "Loving", "Lucky Jim", "The" + " Man Who Loved Children"
            , "Midnight's Children", "Money", "The " + "Moviegoer", "Mrs. Dalloway", "Naked Lunch", "Native Son",
                                            "Neuromancer", "Never Let Me Go", "1984", "On the Road",
                                            "One Flew Over " + "the Cuckoo's Nest", "The Painted Bird", "Pale Fire",
                                            "A Passage " + "to India", "Play It as It Lays", "Portnoy's Complaint",
                                            "Possession", "The Power and the Glory", "The Prime of Miss Jean Brodie",
                                            "Rabbit Run", "Ragtime", "The Recognitions", "Red Harvest",
                                            "Revolutionary Road", "The Sheltering Sky", "Slaughterhouse-Five", "Snow "
                                                    + "Crash", "The Sot-Weed Factor", "The Sound and the Fury", "The "
                                                    + "Sportswriter", "The Spy Who Came in from the Cold",
                                            "The Sun " + "Also Rises", "Their Eyes Were Watching God", "Things Fall " +
                                                    "Apart", "To Kill a Mockingbird", "To the Lighthouse", "Tropic of" +
                                                    " Cancer", "Ubik", "Under the Net", "Under the " + "Volcano",
                                            "Watchmen", "White Noise", "White Teeth", "Wide " + "Sargasso Sea" };

    private final String title;

    /**
     * Constructs a {@code Novel} object with the specified title.
     *
     * @param title the title of the novel. It is expected to be one of the titles from
     *              the {@link #TITLES} array, though any title can be provided.
     */
    public Novel(final String title)
    {
        this.title = title;
    }

    /**
     * Returns the title of the novel.
     *
     * @return a {@code String} representing the title of this novel instance.
     */
    @Override
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns a string representation of the novel, including the class name and title.
     *
     * @return a formatted {@code String} that identifies the object as a {@code Novel}
     * and displays its title.
     */
    @Override
    public String toString()
    {
        return this.getClass()
                   .getSimpleName() + ": " + this.title;
    }

    /**
     * Creates a list of {@code Novel} objects from the provided array of titles.
     * This method uses the provided constructor function to generate new {@code Novel} objects.
     *
     * @param titles      an array of {@code String} titles to be converted into {@code Novel} objects
     * @param constructor a {@code Function} that takes a {@code String} and returns a {@code Novel} instance
     *
     * @return a {@code List} of {@code Novel} objects, each created from the titles array
     */
    @Override
    public List< Novel > createLiteratureList(final String[] titles,
                                              final Function< String, Novel > constructor)
    {
        List< Novel > novels = new ArrayList<>();
        for( String title : titles )
        {
            novels.add( constructor.apply( title ) );
        }
        return novels;
    }
}
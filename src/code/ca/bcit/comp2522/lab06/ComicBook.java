package ca.bcit.comp2522.lab06;

/**
 * The {@code ComicBook} class represents a type of literature that extends the {@link Literature} class.
 * This class includes a predefined list of popular comic book titles and allows setting and getting the title
 * of an individual comic book.
 *
 * <p>
 * It overrides the {@code getTitle()} method from the {@code Literature} class to return the title of the comic book,
 * and also overrides the {@code toString()} method to return a string representation of the comic book.
 * </p>
 *
 * <p>
 * The list of popular comic books is stored in the {@code TITLES} array as a collection of famous comic titles,
 * such as "Watchmen", "The Dark Knight Returns", and others.
 * </p>
 *
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 */
public class ComicBook
        extends Literature
{
    private             String   title;
    public static final String[] TITLES = { "Watchmen", "The Dark Knight Returns", "Maus", "V for Vendetta",
                                            "The " + "Sandman", "Y: The Last Man", "Persepolis", "Batman: Year One",
                                            "Bone", "Black Panther", "Hellboy: Seed " + "of Destruction", "The " +
                                                    "Walking Dead", "Saga", "Ms. Marvel", "Locke & Key", "Ghost " +
                                                    "World", "300", "Fun Home", "Blankets", "Sin City",
                                            "A Contract " + "with God", "Akira", "Nausicaä of the Valley of the Wind"
            , "Astro" + " Boy", "Scott Pilgrim's Precious Little Life", "Fables", "Transmetropolitan", "The " +
                                                    "Invisibles", "Sandman Mystery Theatre", "Judge " + "Dredd",
                                            "Swamp Thing", "Preacher", "Marvels", "Planetary", "The " + "Ultimates",
                                            "Invincible", "Runaways", "The Boys", "Powers", "The" + " Authority",
                                            "Lucifer", "American Vampire", "Chew", "Hellblazer", "DMZ", "100 Bullets"
            , "Spawn", "Wytches", "Sex Criminals", "East of West" };

    /**
     * Constructs a new {@code ComicBook} object with the specified title.
     *
     * @param title the title of the comic book
     */
    public ComicBook(final String title)
    {
        this.title = title;
    }

    /**
     * Returns the title of the comic book.
     *
     * @return the title of this comic book
     */
    @Override
    public String getTitle() { return this.title; }

    /**
     * Returns a string representation of the comic book.
     *
     * @return a string that includes the class name and the title of the comic book
     */
    @Override
    public String toString()
    {
        return this.getClass()
                   .getSimpleName() + ": " + this.getTitle();
    }
}
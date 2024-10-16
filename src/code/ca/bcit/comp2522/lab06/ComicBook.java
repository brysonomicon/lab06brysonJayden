package ca.bcit.comp2522.lab06;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 *
 * @version 1.0
 */
public class ComicBook
        extends Literature
{
    public static final String[] TITLES = {
            "Watchmen", "The Dark Knight Returns", "Maus", "V for Vendetta",
            "The Sandman", "Y: The Last Man", "Persepolis", "Batman: Year One",
            "Bone", "Black Panther", "Hellboy: Seed of Destruction",
            "The Walking Dead", "Saga", "Ms. Marvel", "Locke & Key",
            "Ghost World", "300", "Fun Home", "Blankets", "Sin City",
            "A Contract with God", "Akira", "Nausicaä of the Valley of the Wind",
            "Astro Boy", "Scott Pilgrim's Precious Little Life", "Fables",
            "Transmetropolitan", "The Invisibles", "Sandman Mystery Theatre",
            "Judge Dredd", "Swamp Thing", "Preacher", "Marvels",
            "Planetary", "The Ultimates", "Invincible", "Runaways",
            "The Boys", "Powers", "The Authority", "Lucifer",
            "American Vampire", "Chew", "Hellblazer", "DMZ",
            "100 Bullets", "Spawn", "Wytches", "Sex Criminals", "East of West"
    };

    private String title;

    public ComicBook(final String title)
    {
        this.title = title;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + this.getTitle();
    }
}
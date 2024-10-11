package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

public class ComicBook
        extends Literature
        implements Listable<ComicBook>
{
    private static final String[] TITLES = {
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
    public List<ComicBook> createList()
    {
        final List<ComicBook> comicBooks;

        comicBooks = new ArrayList<>();

        for(String title : TITLES)
        {
            final ComicBook comicBook;

            comicBook = new ComicBook(title);

            comicBooks.add(comicBook);
        }

        return comicBooks;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

}

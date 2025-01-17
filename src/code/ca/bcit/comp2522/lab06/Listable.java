package ca.bcit.comp2522.lab06;

import java.util.List;
import java.util.function.Function;

/**
 * The {@code Listable} interface is a functional interface that defines a method for creating a list of literature
 * items.
 * It is parameterized with a type {@code T}, which must extend the {@link Literature} class.
 *
 * <p>
 * This interface uses a functional approach by accepting an array of titles and a {@link Function}.
 * It is designed to instance a subclass of {@link Literature} by calling the constructor of the subclass and passing
 * the title String to it. It returns a List of {@code T extends Literature} containing one Object for every String in
 * the array that is passed in.
 * </p>
 * <p>
 * The interface is annotated with {@code @FunctionalInterface}, meaning it is intended to be used in lambda expressions
 * or method references.
 * </p>
 *
 *
 * @param <T> the type of literature that extends {@link Literature}
 *
 *            Example usage:
 *            <pre>{@code
 *                       Listable<ComicBook> listable = (titles, constructor) -> {
 *                           List<ComicBook> comics = new ArrayList<>();
 *                           for (String title : titles) {
 *                               comics.add(constructor.apply(title));
 *                           }
 *                           return comics;
 *                       };
 *                       }</pre>
 *
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 * @see Literature
 * @see ComicBook
 * @see Magazine
 * @see Novel
 */
@FunctionalInterface
public interface Listable< T extends Literature >
{
    /**
     * Creates a list of literature items from the provided array of titles and a constructor function.
     *
     * @param titles      an array of titles for the literature items
     * @param constructor a {@link Function} that takes a title as input and returns an instance of type {@code T}
     *
     * @return a list of literature items created from the titles
     */
    List< T > createLiteratureList(final String[] titles,
                                   final Function< String, T > constructor);
}
package ca.bcit.comp2522.lab06;

import java.util.List;

/**
 * The {@code BookStore} class represents a store containing a collection of novels.
 * It provides methods to search, sort, and print information about the novels.
 *
 * @author Bryson Lindy
 * @author Richard Ho
 * @author Phyo Thu Kha
 *
 * @version 1.0
 */
public class BookStore<T extends Literature>
{
    private final String storeName;

    /**
     * Constructs a {@code BookStore} with the given store name.
     * Initializes the list of novels using {@code Novel.createNovelList()}.
     *
     * @param storeName the name of the bookstore
     */
    public BookStore(final String storeName)
    {
        validateName(storeName);

        this.storeName = storeName;
    }

    /**
     * Returns the name of the bookstore.
     *
     * @return the name of the bookstore
     */
    public String getStoreName()
    {
        return storeName;
    }

    /*
    Checks to make sure the store name is not null or empty.
     */
    private static void validateName(final String storeName)
    {
        final boolean storeNameIsEmpty = storeName.trim().isEmpty();

        if(storeName == null || storeNameIsEmpty)
        {
            throw new IllegalArgumentException("Store name cannot be null or empty");
        }
    }

    /**
     * TODO use lambda expression instead of for each loop
     */
    public void printAllTitles()
    {
    }

    /**
     * TODO use lambda expression to perform title match
     * items.forEach(item -> {}
     * like a callback function in javascript almost
     */
    public void printBookTitle(final String title)
    {
    }

    /**
     *  TODO use method reference to String::compareToIgnoreCase when sorting
     */
    public void printTitlesInAlphaOrder()
    {
    }

    /**
     * TODO implement lambda expressions for search/matching
     */
    public void printGroupByDecade(final int decade)
    {
    }

    /**
     * Initializes the longestTitle variable to the first book in the book list.
     * Iterates through all novels to find the longest title and prints the result.
     */
    public void printLongest()
    {
    }

    /**
     * Iterates through the book list to see if any were published in the year passed
     * as a parameter. Returns true if one is found, false if not.
     *
     * @param year to check if
     * @return boolean
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        return false;
    }

    /**
     * Increments a counter for each title in the book list that contains the
     * word passed as a parameter.
     *
     * @param word String to check if contained in each book title
     * @return number
     */
    public int howManyBooksContain(final String word)
    {
        return 0;
    }

    /**
     * Returns a double value of the ratio of novels between the ranges passed as
     * parameters and the total number of novels.
     *
     * @param lowerBound int that indicates the lower limit of years
     * @param upperBound int that indicates the upper limit of years
     * @return double representing the percentage of novels between the lower and upper bounds
     */
    public double whichPercentWrittenBetween(final int lowerBound,
                                             final int upperBound)
    {
        return 0.0;
    }

    /**
     * Returns the oldest book from the book list.
     * @return Book object that is oldest
     */
    public Novel getOldestBook()
    {
        return null;
    }

    /**
     * Returns a list of novels with titles of the specified length.
     *
     * @param length the desired title length
     * @return a list of novels with titles of the given length
     */
    public List<Novel> getBooksThisLength(final int length)
    {
        return null;
    }

}
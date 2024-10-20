package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * The {@code BookStore} class represents a store containing a collection of literature items, such as novels.
 * It provides methods to search, sort, and print information about the books in its collection.
 * This class is generic, accepting any type that extends the {@link Literature} class.
 *
 * <p>
 * The class supports operations such as adding items, displaying information, counting books with specific
 * characteristics,
 * and finding books based on title length or keyword.
 * </p>
 *
 * @param <T> the type of literature that extends {@link Literature}
 *
 *            <p>
 *            Nested classes include:
 *            <ul>
 *                <li>{@link BookStore.BookStoreInfo} for displaying information about the store</li>
 *                <li>{@link BookStore.NovelStatistics} for calculating statistics related to novels</li>
 *            </ul>
 *            </p>
 *
 * @author Bryson Lindy
 * @author Jayden Hutchinson
 * @author Richard Ho
 * @author Phyo Thu Kha
 * @version 1.1
 */
class BookStore< T extends Literature >
{
    private static final int NONE  = 0;

    private final String    storeName;
    private final List< T > bookList;

    /**
     * Constructs a {@code BookStore} with the given store name.
     *
     * @param storeName the name of the bookstore
     *
     * @throws IllegalArgumentException if the store name is null or empty
     */
    BookStore(final String storeName)
    {
        validateName( storeName );

        this.storeName = storeName;
        this.bookList  = new ArrayList<>();
    }

    /**
     * Validates that the store name is not null or empty.
     *
     * @param storeName the name of the bookstore
     *
     * @throws IllegalArgumentException if the store name is null or empty
     */
    private static void validateName(final String storeName)
    {
        final boolean storeNameIsEmpty;

        storeNameIsEmpty = storeName.trim()
                                    .isEmpty();

        if( storeName == null || storeNameIsEmpty )
        {
            throw new IllegalArgumentException( "Store name cannot be null or empty" );
        }
    }

    /**
     * The {@code BookStoreInfo} class is a nested class that provides a method to display information
     * about the bookstore, including the number of books in its collection.
     *
     * @author Jayden Hutchinson
     * @author Bryson Lindy
     * @version 1.0
     */
    class BookStoreInfo
    {
        /**
         * Displays information about the bookstore, including the store name and the number of books.
         */
        public void displayInfo()
        {
            final int bookCount;

            bookCount = bookList.size();

            System.out.println( "\n\nPrint info about BookStore using nested class:" );
            System.out.println( storeName + " has " + bookCount + " books" );
        }
    }

    /**
     * The {@code NovelStatistics} class is a nested class that provides a method to calculate
     * statistics related to the novels in the bookstore, such as the average title length.
     *
     * @author Jayden Hutchinson
     * @author Bryson Lindy
     * @version 1.0
     */
    class NovelStatistics
    {
        /**
         * Calculates and returns the average length of the titles of all novels in the bookstore.
         *
         * @return the average title length of novels
         */
        public double averageTitleLength()
        {
            final int listSize;
            int       totalLength;
            
            totalLength = NONE;

            listSize = bookList.size();

            for (final T book : bookList )
            {
                if ( book instanceof Novel )
                {
                    final int bookTitleLength;

                    bookTitleLength = book.getTitle().length();

                    totalLength += bookTitleLength;
                }

            }

            return totalLength / ( double ) listSize;
        }
    }

    /**
     * Returns the list of books in the bookstore.
     *
     * @return the list of books in the bookstore
     */
    List< T > getBookList()
    {
        return this.bookList;
    }

    /**
     * Returns the number of books in the bookstore.
     *
     * @return the number of books in the bookstore
     */
    int getNumOfBooks()
    {
        return this.bookList.size();
    }

    /**
     * Returns the name of the bookstore.
     *
     * @return the name of the bookstore
     */
    String getStoreName()
    {
        return this.storeName;
    }

    /**
     * Adds a book to the bookstore collection.
     *
     * @param item the book to be added to the collection
     */
    void addItem(final T item)
    {
        bookList.add( item );
    }

    /**
     * Adds all novels from the bookstore to a given collection.
     *
     * @param novelCollection a collection to which novels will be added
     */
    void addNovelsToCollection(final List< ? super Novel > novelCollection)
    {
        for(final T book : bookList )
        {
            if( book instanceof Novel )
            {
                novelCollection.add( ( Novel ) book );
            }
        }
    }

    /**
     * Prints all books in the bookstore.
     */
    void printItems()
    {
        System.out.println( "Print all items:" );
        bookList.forEach( System.out::println );
    }

    /**
     * Prints all books that contain the specified title in their name.
     *
     * @param title the title to search for
     */
    void printBookTitle(final String title)
    {
        System.out.println( "\n\nPrint all items containing \"" + title + "\":" );

        bookList.forEach( book ->
                          {
                              final String bookTitle;

                              bookTitle = book.getTitle();

                              if( bookTitle.contains( title ) )
                              {
                                  System.out.println( book );
                              }
                          } );
    }

    /**
     * Prints the titles of all books in alphabetical order.
     * Uses the {@code String::compareToIgnoreCase} method reference for sorting.
     */
    void printTitlesInAlphaOrder()
    {
        final List< String >       titles;
        final Comparator< String > ignoreCaseComparator;
        final Consumer< String >   print;

        titles               = new ArrayList<>();
        ignoreCaseComparator = (String::compareToIgnoreCase);
        print                = (System.out::println);


        System.out.println( "\n\nPrint items in alphabetical order:" );

        for( final T book : bookList )
        {
            final String bookTitle;

            bookTitle = book.getTitle();

            titles.add( bookTitle );
        }

        titles.sort( ignoreCaseComparator );

        titles.forEach( print );
    }

    /**
     * Prints the longest title in the bookstore's collection.
     */
    public void printLongest()
    {
        String longestTitle;

        longestTitle = null;

        for( final T book : bookList )
        {
            final String bookTitle;

            bookTitle = book.getTitle();

            if( longestTitle == null || bookTitle.length() > longestTitle.length() )
            {
                longestTitle = bookTitle;
            }
        }

        if ( longestTitle != null )
        {
            System.out.println("\n\nThe longest title in the list is:\n" + longestTitle);
        }
        else
        {
            System.out.println("\n\nThere are no titles in the list.");
        }
    }

    /**
     * Returns the number of books that contain a specified word in their title.
     *
     * @param word the word to search for in the titles
     *
     * @return the number of books containing the word
     */
    int howManyBooksContain(final String word)
    {
        int counter = NONE;

        for( final T book : bookList )
        {
            final String bookTitle;

            bookTitle = book.getTitle();

            if( bookTitle.contains( word ) )
            {
                ++counter;
            }
        }

        return counter;
    }

    /**
     * Returns a list of books with titles of the specified length.
     *
     * @param length the desired title length
     *
     * @return a list of books with titles of the given length
     */
    List< Literature > getBooksThisLength( final int length )
    {
        final List< Literature > litList;

        litList = new ArrayList<>();

        this.bookList.forEach( book ->
                               {
                                   final String bookTitle;

                                   bookTitle = book.getTitle();

                                   if( bookTitle.length() == length )
                                   {
                                       litList.add( book );
                                   }
                               } );

        return litList;
    }
}
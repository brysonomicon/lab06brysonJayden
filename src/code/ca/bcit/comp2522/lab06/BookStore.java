package ca.bcit.comp2522.lab06;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * The {@code BookStore} class represents a store containing a collection of novels.
 * It provides methods to search, sort, and print information about the novels.
 *
 * @author Bryson Lindy
 * @author Jayden Hutchinson
 * @author Richard Ho
 * @author Phyo Thu Kha
 * @version 1.1
 */
class BookStore< T extends Literature >
{
    private final String    storeName;
    private final List< T > bookList;

    /**
     * Constructs a {@code BookStore} with the given store name.
     *
     * @param storeName the name of the bookstore
     */
    BookStore(final String storeName)
    {
        validateName( storeName );

        this.storeName = storeName;
        this.bookList  = new ArrayList<>();
    }

    /*
    Checks to make sure the store name is not null or empty.
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
     * @author Jayden Hutchinson
     * @author Bryson Lindy
     * @version 1.0
     */
    class BookStoreInfo
    {
        /**
         *
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
     * @author Jayden Hutchinson
     * @author Bryson Lindy
     * @version 1.0
     */
    class NovelStatistics
    {
        /**
         * @return
         */
        public double averageTitleLength()
        {
            final int listSize;
            int[]     totalLength = { 0 };

            listSize = bookList.size();

            bookList.forEach( book ->
                              {
                                  if( book instanceof Novel )
                                  {
                                      totalLength[0] += book.getTitle()
                                                            .length();
                                  }
                              } );

            return totalLength[0] / ( double ) listSize;
        }
    }

    List< T > getBookList()
    {
        return this.bookList;
    }

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

    void addItem(final T item)
    {
        bookList.add( item );
    }

    void addNovelsToCollection(final List< ? super Novel > novelCollection)
    {
        for( T book : bookList )
        {
            if( book instanceof Novel )
            {
                novelCollection.add( ( Novel ) book );
            }
        }
    }

    /**
     *
     */
    void printItems()
    {
        System.out.println( "Print all items:" );
        bookList.forEach( System.out::println );
    }

    /**
     * TODO use lambda expression to perform title match
     * bookList.forEach(item -> {}
     * like a callback function in javascript almost
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
     * TODO use method reference to String::compareToIgnoreCase when sorting
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
        for( T book : bookList )
        {
            final String bookTitle;

            bookTitle = book.getTitle();

            titles.add( bookTitle );
        }

        titles.sort( ignoreCaseComparator );
        
        titles.forEach( print );
    }

    /**
     * Initializes the longestTitle variable to the first book in the book list.
     * Iterates through all novels to find the longest title and prints the result.
     */
    public void printLongest()
    {
        String longestTitle;

        longestTitle = this.bookList.getFirst()
                                    .getTitle();

        for( T book : bookList )
        {
            final String bookTitle;

            bookTitle = book.getTitle();

            if( bookTitle.length() > longestTitle.length() )
            {
                longestTitle = bookTitle;
            }
        }

        System.out.println( "The longest title in the list is:\n" + longestTitle );
    }

    /**
     * Increments a counter for each title in the book list that contains the
     * word passed as a parameter.
     *
     * @param word String to check if contained in each book title
     *
     * @return number
     */
    int howManyBooksContain(final String word)
    {
        int counter = 0;

        for( T book : bookList )
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
     * Returns a list of novels with titles of the specified length.
     *
     * @param length the desired title length
     *
     * @return a list of novels with titles of the given length
     */
    List< Literature > getBooksThisLength(final int length)
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
package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 */
public class Main
{
    public static void main( final String[] args )
    {
        final BookStore< Literature >                 jaysonBookStore;
        final BookStore< Literature >.NovelStatistics novelStatistics;
        final BookStore< Literature >.BookStoreInfo   jaysonInfo;
        final List< Literature >                      literatureList;
        final List< List < Literature > >             listList;
        final List< Novel >                           testList;
        final Listable< Literature >                  listable;
        final List< Literature >                      listOfBooksOfLength;
        final double                                  averageTitleLength;
        final int                                     numOfBookContaining;


        jaysonBookStore = new BookStore<>( "jayson Book Store: It's Jayden and Bryson, isn't it?" );

        listList = new ArrayList<>();
        listable = ( titles, constructor ) ->
        {
            final List< Literature > list;
            list = new ArrayList<>();

            for( String title : titles )
            {
                list.add( constructor.apply( title ) );
            }
            return list;
        };

        // lists of instance data for each subclass of Literature, using the Listable functional interface
        listList.add( listable.createLiteratureList( Novel.TITLES, Novel::new ) );
        listList.add( listable.createLiteratureList( ComicBook.TITLES, ComicBook::new ) );
        listList.add( listable.createLiteratureList( Magazine.TITLES, Magazine::new ) );


        // add all items from jaysonBookStore to literature list
        literatureList = new ArrayList<>();
        listList.forEach( literatureList::addAll );
        literatureList.forEach( jaysonBookStore::addItem );


        novelStatistics = jaysonBookStore.new NovelStatistics();
        jaysonInfo      = jaysonBookStore.new BookStoreInfo();


        jaysonBookStore.printItems();

        jaysonBookStore.printBookTitle( "The" );

        jaysonBookStore.printTitlesInAlphaOrder();

        jaysonInfo.displayInfo();

        System.out.println( "\n\nAverage length of Novel titles:" );
        System.out.printf( "%.2f letters", novelStatistics.averageTitleLength() );

        System.out.println( "\n\nAdd Novels from this BookStore to other Collection:" );
        testList = new ArrayList<>();
        jaysonBookStore.addNovelsToCollection( testList );
        testList.forEach( System.out::println );

        System.out.println( "\n\njaysonBookStore average Novel title length:" );
        averageTitleLength = novelStatistics.averageTitleLength();
        System.out.printf( "%.2f letters", averageTitleLength );

        jaysonBookStore.printLongest();

        numOfBookContaining = jaysonBookStore.howManyBooksContain("The");
        System.out.println( "\nThere are " + numOfBookContaining + " books containing \"The\"" );

        listOfBooksOfLength = jaysonBookStore.getBooksThisLength(15);
        System.out.println( "List of Books of length 15" );
        listOfBooksOfLength.forEach( System.out::println );

        // anonymous inner class to sort by length
        jaysonBookStore.getBookList().sort( new Comparator< Literature >()
        {
            @Override
            public int compare( Literature book1, Literature book2 )
            {
                return Integer.compare( book1.getTitle().length(),
                                        book2.getTitle().length() );
            }
        });

        System.out.println( "\n\nBooks sorted by title length" );
        jaysonBookStore.printItems();
    }
}
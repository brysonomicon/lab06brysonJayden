package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        final BookStore< Literature >                 jaysonBookStore;
        final BookStore< Literature >.NovelStatistics novelStatistics;
        final BookStore< Literature >.BookStoreInfo   jaysonInfo;
        final List< Literature >                      literatureList;
        final List< List >                            listList;
        final List< Novel >                           testList;
        final Listable< Literature >                  listable;
        final List< Literature >                      listOfBooksOfLength;
        final double                                  averageTitleLength;
        final int                                     numOfBookContaining;


        jaysonBookStore = new BookStore<>( "jayson Book Store: It's Jayden and Bryson, isn't it?" );

        listList = new ArrayList<>();
        listable = (titles, constructor) ->
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


        // Average novel title length
        System.out.println( "\n\nAverage length of Novel titles:" );
        System.out.printf( "%.2f letters", novelStatistics.averageTitleLength() );


        // add novel to other collection and print
        System.out.println( "\n\nAdd Novels from this BookStore to other Collection:" );
        testList = new ArrayList<>();
        jaysonBookStore.addNovelsToCollection( testList );
        testList.forEach( System.out::println );


        // jaysonBookStore average novel title length
        System.out.println( "\n\njaysonBookStore average Novel title length:" );
        averageTitleLength = novelStatistics.averageTitleLength();
        System.out.printf( "%.2f letters", averageTitleLength );

        // print the longest book title
        jaysonBookStore.printLongest();

        // how many books contain "The"
        numOfBookContaining = jaysonBookStore.howManyBooksContain("The");
        System.out.println( "\nThere are " + numOfBookContaining + " books containing \"The\"" );

        listOfBooksOfLength = jaysonBookStore.getBooksThisLength(15);
        System.out.println( "List of Books of length 15" );
        listOfBooksOfLength.forEach( System.out::println );
    }
}
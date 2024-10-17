package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        final BookStore< Literature >   jaysonBookStore;
        final List< Literature >        literatureList;
        final List< List >              listList;
        final List< Novel >             testList;
        final Listable< Literature >    listable;
        final BookStore.NovelStatistics novelStatistics;
        final BookStore.BookStoreInfo   jaysonInfo;
        final double                    averageTitleLength;


        jaysonBookStore = new BookStore<>( "jayson Book Store: It's Jayden and Bryson, isn't it?" );

        listList = new ArrayList<>();
        listable = (titles, constructor) ->
        {
            List< Literature > list;
            list = new ArrayList<>();

            for( String title : titles )
            {
                list.add( constructor.apply( title ) );
            }
            return list;
        };

        /*
         * We use the illustrious Listable interface to create lists of titles for our Literature objects.
         * We add each list to a List of lists called listList. Then we initialist the List literatureList as
         * an ArrayList and for each list in listList we add all list elements to the List literatureList.
         *
         * what's really cool is that the compiler knows that we want to select the addAll function from the list
         * of functions so that we easily add each list from listList to literatureList a single line of list. I mean
         *  code.
         */
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
    }
}
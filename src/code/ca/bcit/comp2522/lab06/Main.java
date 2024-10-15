package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 *
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        final BookStore<Literature> jaysonBookStore;
        final List<Literature>      literatureList;
        final List<List>            listList;
        final List<Novel>           testList;

        jaysonBookStore = new BookStore<>("jayson Book Store: It's Jayden and Bryson, isn't it?");

        listList = new ArrayList<>();

        /*
        * We use the illustrious Listable interface to create lists of titles for our Literature objects.
        * We add each list to a List of lists called listList. Then we initialist the List literatureList as
        * an ArrayList and for each list in listList we add all list elements to the List literatureList.
        *
        * what's really cool is that the compiler knows that we want to select the addAll function from the list
        * of functions so that we easily add each list from listList to literatureList a single line of list. I mean code.
        */
        listList.add(Listable.createLiteratureList(Novel.TITLES, Novel::new));
        listList.add(Listable.createLiteratureList(ComicBook.TITLES, ComicBook::new));
        listList.add(Listable.createLiteratureList(Magazine.TITLES, Magazine::new));

        literatureList = new ArrayList<>();

//        listList.forEach(list -> {
//            literatureList.addAll(list);
//        });
        listList.forEach(literatureList::addAll);

        literatureList.forEach(jaysonBookStore::addItem);

        System.out.println("Print all items:");
        jaysonBookStore.printItems();

        System.out.println("\n\nPrint all items containing \"The\":");
        jaysonBookStore.printBookTitle("The");

        System.out.println("\n\nPrint items in alphabetical order:");
        jaysonBookStore.printTitlesInAlphaOrder();

        System.out.println("\n\nPrint info about BookStore using nested class:");
        jaysonBookStore.new BookStoreInfo().displayInfo();

        System.out.println("\n\nAverage length of Novel titles:");
        System.out.printf("%.2f letters", jaysonBookStore.new NovelStatistics().averageTitleLength());

        System.out.println("\n\nAdd Novels from this BookStore to other Collection:");
        testList = new ArrayList<>();
        jaysonBookStore.addNovelsToCollection(testList);
        testList.forEach(System.out::println);
    }
}
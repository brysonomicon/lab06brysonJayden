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
        final List<Novel>           novelList;
        final List<ComicBook>       comicList;
        final List<Magazine>        magazineList;
        final List<Literature>      literatureList;

        final List<Novel>           testList;

        jaysonBookStore = new BookStore<>("jayson Book Store: It's Jayden and Bryson, isn't it?");

        novelList    = Listable.createLiteratureList(Novel.TITLES,
                                                     Novel::new);
        comicList    = Listable.createLiteratureList(ComicBook.TITLES,
                                                     ComicBook::new);
        magazineList = Listable.createLiteratureList(Magazine.TITLES,
                                                     Magazine::new);

        literatureList = new ArrayList<>();
        literatureList.addAll(novelList);
        literatureList.addAll(comicList);
        literatureList.addAll(magazineList);

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
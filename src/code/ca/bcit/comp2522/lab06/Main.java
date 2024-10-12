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
        final List<Novel> novelList;
        final List<ComicBook> comicList;
        final List<Magazine> magazineList;
        final List<Literature> literatureList;

        jaysonBookStore = new BookStore<>("Pages Through The Ages");

        novelList    = Listable.createList(Novel.TITLES, Novel::new);
        comicList    = Listable.createList(ComicBook.TITLES, ComicBook::new);
        magazineList = Listable.createList(Magazine.TITLES, Magazine::new);

        literatureList = new ArrayList<>();
        literatureList.addAll(novelList);
        literatureList.addAll(comicList);
        literatureList.addAll(magazineList);

        literatureList.forEach(jaysonBookStore::addItem);

        System.out.println("Print all items");
        jaysonBookStore.printItems();

        System.out.println("Print all items containing \"The\"");
        jaysonBookStore.printBookTitle("The");

        System.out.println("SORTED");
        jaysonBookStore.printTitlesInAlphaOrder();
        
    }
}
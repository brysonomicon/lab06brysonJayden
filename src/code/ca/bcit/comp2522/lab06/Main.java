package ca.bcit.comp2522.lab06;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        BookStore<Literature> store;
        List<Novel> novels;
        List<ComicBook> comics;
        List<Magazine> magazines;

        store     = new BookStore<>("Pages Through The Ages");
        novels    = Listable.createList(Novel.TITLES, Novel::new);
        comics    = Listable.createList(ComicBook.TITLES, ComicBook::new);
        magazines = Listable.createList(Magazine.TITLES, Magazine::new);
    }
}

package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 *
 * @version 1.0
 */
public interface Listable <T extends Literature>
{
    static <T extends Literature> List<T> createList(final String[] titles,
                                                     final Function<String, T> creator)
    {
        List<T> list;

        list = new ArrayList<T>();

        for(String title : titles)
        {
            list.add(creator.apply(title));
        }

        return list;
    }
}

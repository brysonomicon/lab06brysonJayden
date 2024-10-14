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
    static <T extends Literature> List<T> createLiteratureList(final String[] titles,
                                                               final Function<String, T> constructor)
    {
        List<T> list;

        list = new ArrayList<>();

        for(String title : titles)
        {
            list.add(constructor.apply(title));
        }

        return list;
    }
}

package ca.bcit.comp2522.lab06;

import java.util.List;

public interface Listable <T extends Literature>
{
    List<T> createList();
}

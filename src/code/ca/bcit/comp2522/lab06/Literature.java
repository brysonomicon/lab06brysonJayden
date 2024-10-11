package ca.bcit.comp2522.lab06;

// Literature is the abstract parent class for all types that
// will fit into the BookStore
public abstract class Literature
{
    public abstract String getTitle();
    public abstract String getAuthor();
    public abstract int getYearPublished();
}

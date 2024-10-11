package ca.bcit.comp2522.lab06;

public class Novel extends Literature
{
    private String title;
    private String author;
    private int yearPublished;

    public Novel(final String title,
                 final String author,
                 final int    yearPublished)
    {
        this.title         = title;
        this.author        = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String getAuthor()
    {
        return this.author;
    }

    @Override
    public int getYearPublished()
    {
        return this.yearPublished;
    }
}

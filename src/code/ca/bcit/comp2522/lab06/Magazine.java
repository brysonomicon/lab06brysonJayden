package ca.bcit.comp2522.lab06;

public class Magazine extends Literature
{
    private String title;


    public Magazine(final String title)
    {
        this.title         = title;

    }

    @Override
    public String getTitle()
    {
        return this.title;
    }
}

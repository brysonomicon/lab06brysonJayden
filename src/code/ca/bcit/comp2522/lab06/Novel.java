package ca.bcit.comp2522.lab06;

public class Novel extends Literature
{
    private String title;


    public Novel(final String title)
    {
        this.title         = title;

    }

    @Override
    public String getTitle()
    {
        return this.title;
    }
}

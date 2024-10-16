package ca.bcit.comp2522.lab06;

/**
 * @author Jayden Hutchinson
 * @author Bryson Lindy
 *
 * @version 1.0
 */
public class Magazine
        extends Literature
{
    public static final String[] TITLES = {
            "Time", "National Geographic", "The New Yorker", "Vogue",
            "Forbes", "Sports Illustrated", "Rolling Stone", "Scientific American",
            "The Atlantic", "Harper's Bazaar", "Wired", "GQ",
            "Esquire", "The Economist", "Newsweek", "Popular Mechanics",
            "National Review", "Vanity Fair", "Nature", "Smithsonian",
            "People", "Good Housekeeping", "Reader's Digest", "Cosmopolitan",
            "Entertainment Weekly", "Men's Health", "Women's Health", "Seventeen",
            "Better Homes & Gardens", "Family Circle", "PC Magazine", "Car and Driver",
            "Architectural Digest", "Fortune", "Bloomberg Businessweek", "The Nation",
            "New Scientist", "Mother Jones", "Travel + Leisure", "Motor Trend",
            "Outdoor Life", "Southern Living", "Cooking Light", "Food & Wine",
            "Field & Stream", "Inc.", "Entrepreneur", "Golf Digest", "Condé Nast Traveler"
    };

    private String title;

    public Magazine(final String title)
    {
        this.title = title;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + title;
    }
}
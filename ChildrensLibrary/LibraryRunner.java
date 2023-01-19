package ChildrensLibrary;
import java.util.ArrayList;

public class LibraryRunner
{
  public static void main(String[] arg)
  {
    //Step 5
    Library library = new Library();
    ArrayList<Book> childrensBooks = library.getChildrensBooks();

    //Step 6
    String authorToFind = "L. Frank Baum";

    //Step 7
    for (Book x : childrensBooks)
    {
        if (x.getAuthor().equals(authorToFind))
        {
            System.out.println(x.getTitle());
        }
    }

    //Step 8
    String bookToFind = "Sky Island";
    double minimumRating = 0.0;

    //Step 9
    for (Book x : childrensBooks)
    {
        if (x.getTitle().equals(bookToFind))
        {
            minimumRating = x.getRating();
        }
    }

    //Step 10
    System.out.println(minimumRating); //Should print 4.14

    //Step 11
    for (Book x : childrensBooks)
    {
        if (x.getRating() >= minimumRating)
        {
            System.out.println(x.getTitle());
        }
    }
  }

}
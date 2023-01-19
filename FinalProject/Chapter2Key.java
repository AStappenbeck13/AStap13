package FinalProject;
import java.util.ArrayList;

public class Chapter2Key {

    public static void main(String[] args)
    {
        
        //Example Step 1
        //Make sure to import ArrayLists above the class
        ArrayList<String> books = new ArrayList<String>();


        //Example Step 2
        books.add("Fahrenheit 451");
        books.add("1984");
        books.add("The Great Gatsby");
        books.add("All Quiet on the Western Front");
        books.add("In Cold Blood");

        System.out.println("The 2nd book is " + books.get(1));

        books.set(4, "Don Quixote");
        System.out.println("The new 4th book is " + books.get(4));

        books.remove(0);
        
        System.out.println("\nWith the first book removed:");
        for(int i = 0; i < books.size(); i++)
        {
            System.out.println(books.get(i));
        }
        System.out.println();

        System.out.println("The new first book is " + books.get(0));

    }
    
}

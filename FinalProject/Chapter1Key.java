package FinalProject;

public class Chapter1Key {

    public static void main(String[] args)
    {

        //Example Step 1
        String[] books = {"Fahrenheit 451", "1984", "The Great Gatsby", "All Quiet on the Western Front", "In Cold Blood"};

        //Example Step 2
        System.out.println("The 4th book is " + books[3]);

        System.out.println();


        //Example Step 3
        books[1] = "The Iliad";
        books[3] = "To Kill a Mockingbird";
        System.out.println("The new 2nd book is " + books[1]);
        System.out.println("The new 4th book is " + books[3]);

        System.out.println();
        for(int i = 0; i < books.length; i++)
        {
            System.out.println(books[i]);
        }

        System.out.println();

        //Swap books - must store a temporary variable
        String temp = books[0];
        books[0] = books[2];
        books[2] = temp;
        System.out.println("The new 1st book is " + books[0]);
        System.out.println("The new 3rd book is " + books[2]);

    }

}
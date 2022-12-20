import java.util.ArrayList;

public class Chapter3Key {
    
    public static void main(String[] args)
    {
        String[] authors = {"Orwell", "Fitzgerald", "Shakespeare", "Hemingway", "Dickens", "Kafka", "Capote", "Bradbury", "Rowling"};
        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("Hemingway");
        authorList.add("Fitzgerald");
        authorList.add("Shakespeare");
        authorList.add("Orwell");
        authorList.add("Dickens");
        authorList.add("Kafka");
        authorList.add("Capote");
        authorList.add("Bradbury");
        authorList.add("Rowling");
        
        int counter = 0;

        //example insertion sort algorithm
        for (int i = 0; i < authors.length - 1; i++)
        {
            for (int j = i + 1; j < authors.length; j++)
            {
                counter++;
                if (authors[i].charAt(0) > authors[j].charAt(0))
                {
                    String temp = authors[i];
                    authors[i] = authors[j];
                    authors[j] = temp;
                }
            }
        }

        for (int i = 0; i < authors.length; i++)
        {
            System.out.println(authors[i]);
        }
        System.out.println("This algorithm took " + counter + " comparisons to sort the books");

        System.out.println();

        //Quick sort algorithm - just two insertion sorts in one
        //Works faster because not every book has to be compared to each other
        
        String middle = authorList.get(0);
        ArrayList<String> newList = new ArrayList<String>();
        int half1 = 0;
        int half2 = 0;
        int counter2 = 0;

        ArrayList<String> newList1 = new ArrayList<String>();
        for (int i = 0; i < authorList.size(); i++)
        {
            if (middle.charAt(0) > authorList.get(i).charAt(0))
            {
                newList1.add(authorList.get(i));
                half1++;
            }
        }
        for (int i = 0; i < newList1.size() - 1; i++)
        {
            for (int j = i + 1; j < newList1.size(); j++)
            {
                counter2++;
                if (newList1.get(i).charAt(0) > newList1.get(j).charAt(0))
                {
                    String temp = newList1.get(i);
                    newList1.set(i, newList1.get(j));
                    newList1.set(j, temp);
                }
            }
        }

        ArrayList<String> newList2 = new ArrayList<String>();
        for (int i = 0; i < authorList.size(); i++)
        {
            if (middle.charAt(0) < authorList.get(i).charAt(0))
            {
                newList2.add(authorList.get(i));
                half2++;
            }
        }
        for (int i = 0; i < newList2.size() - 1; i++)
        {
            for (int j = i + 1; j < newList2.size(); j++)
            {
                counter2++;
                if (newList2.get(i).charAt(0) > newList2.get(j).charAt(0))
                {
                    String temp = newList2.get(i);
                    newList2.set(i, newList2.get(j));
                    newList2.set(j, temp);
                }
            }
        }

        for (int i = 0; i < half1; i++)
        {
            newList.add(newList1.get(i));
        }
        newList.add(middle);
        for (int i = 0; i < half2; i++)
        {
            newList.add(newList2.get(i));
        }


        for (int i = 0; i < authorList.size(); i++)
        {
            System.out.println(newList.get(i));
        }
        System.out.println("Not counting partitiong the books, this algorithm took only " 
                            + counter2 + " comparisons to sort the books");


    }

}

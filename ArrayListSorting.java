import java.util.ArrayList;

public class ArrayListSorting {
    
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Kent");
        names.add("Andrew");
        names.add("Mason");
        names.add("Rohan");
        names.add("Jeremy");

        for (int i = 0; i < names.size() - 1; i++)
        {
            for (int j = i + 1; j < names.size(); j++)
            {

                System.out.println(names.get(i).charAt(0));

                System.out.println(names.get(j).charAt(0));

                if (names.get(i).charAt(0) > names.get(j).charAt(0))
                {
                    String temp = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }

        for(int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }


    }

}

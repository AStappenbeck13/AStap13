import java.util.ArrayList;

public class SelectionSort {

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
        {
            int rand = (int)(15 * Math.random() + i);
            numbers.add(rand);
        }

        for (int x : numbers)
        {
            System.out.println(x);
        }

        System.out.println();

        //PLTW way of showing selection sort
        for (int i = 0; i < numbers.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < numbers.size(); j++)
            {
                if (numbers.get(j) < numbers.get(minIndex))
                {
                    minIndex = j;
                }
            }

            int temp = numbers.get(i);
            numbers.set(i, numbers.get(minIndex));
            numbers.set(minIndex, temp);
        }
        //num of comparisons
        // n * (n-1) / 2 --> n^2/2 - n/2
        //O(n) is n^2 - ONLY USE DOMINANT TERMS, NO COEFFICIENTS

        for (int x : numbers)
        {
            System.out.println(x);
        }

    }

}
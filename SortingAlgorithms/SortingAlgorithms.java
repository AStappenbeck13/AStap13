package SortingAlgorithms;
import java.util.ArrayList;

public class SortingAlgorithms
{
    //Perform a selection sort an ArrayList of integers
    //parameter intList an ArrayList of integers
    //return intList sorted from smallest to largest
    public static ArrayList<Integer> selectionSortInt(ArrayList<Integer> intList)
    {
        for (int i = 0; i < intList.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < intList.size(); j++)
            {
                if (intList.get(j) < intList.get(minIndex))
                {
                    minIndex = j;
                }
            }

            int temp = intList.get(i);
            intList.set(i, intList.get(minIndex));
            intList.set(minIndex, temp);
        }

        return intList;
    }

    //Perform a selection sort an ArrayList of doubles
    //parameter doubleList an ArrayList of doubles
    //return doubleList sorted from smallest to largest
    public static ArrayList<Double> selectionSortDouble(ArrayList<Double> doubleList)
    {
        for (int i = 0; i < doubleList.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < doubleList.size(); j++)
            {
                if (doubleList.get(j) < doubleList.get(minIndex))
                {
                    minIndex = j;
                }
            }

            double temp = doubleList.get(i);
            doubleList.set(i, doubleList.get(minIndex));
            doubleList.set(minIndex, temp);
        }

        return doubleList;
    }

    //Perform an insertion sort an ArrayList of integers
    //parameter intList an ArrayList of integers
    //return intList sorted from smallest to largest
    public static ArrayList<Integer> insertionSortInt(ArrayList<Integer> intList)
    {
        for (int i = 1; i < intList.size(); i++)
        {
            //int firstUnsorted = intList.get(i + 1);

            int j = i - 1; 
            while(i>0 && intList.get(j) > intList.get(i)){
                int temp = intList.get(i);
                intList.set(i, j);
                intList.set(j, temp);
            }

        }

        return intList;
    }

    //Perform an insertion sort an ArrayList of doubles
    //parameter doubleList an ArrayList of doubles
    //return doubleList sorted from smallest to largest
    public static ArrayList<Double> insertionSortDouble(ArrayList<Double> doubleList)
    {
        for (int i = 0; i < doubleList.size() - 1; i++)
        {
            double firstUnsorted = doubleList.get(i + 1);

            for (int j = i; j >= 0; j--)
            {
                double sortedValue = doubleList.get(j);
                
                if (sortedValue > firstUnsorted) 
                {
                    doubleList.set(j + 1, sortedValue);
                    doubleList.set(j, firstUnsorted);
                }
            }

        }

        return doubleList;
    }

}
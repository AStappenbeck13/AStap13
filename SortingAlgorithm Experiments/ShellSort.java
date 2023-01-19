public class ShellSort {
    
    public static void main(String[] args)
    {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * 5000);
            System.out.println(arr[i]);
        }

        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr2.length; i++)
        {
            arr2[i] = arr[i];
        }

        System.out.println();

        shellSort(arr, arr.length);

        /*
        for (int x : arr)
        {
            System.out.println(x);
        }
        */

        System.out.println();

        insertionSort(arr2, arr2.length);

        /*
        for (int x : arr2)
        {
            System.out.println(x);
        }
        */
    }

    public static void shellSort(int[] arr, int length)
    {
        int numComparisons = 0;
        int numSwaps = 0;
        
        int incr = 1;
        while (2 * incr <= length)
        {
            incr *= 2;
        }

        while (incr >= 1)
        {
            for (int i = incr; i < length; i++)
            {
                numComparisons++;
                if (arr[i] < arr[i - incr])
                {
                    int temp = arr[i];

                    int j = i;
                    while (j > incr - 1 && temp < arr[j - incr])
                    {
                        numComparisons++;
                        numSwaps++;
                        
                        arr[j] = arr[j - incr];
                        j -= incr;
                    }
                    arr[j] = temp;
                }
            }
            incr /= 2;
        }

        System.out.println("Total number of comparisons for shell sort: " + numComparisons);
        System.out.println("Total number of swaps for shell sort: " + numSwaps);
    }

    public static void insertionSort(int[] arr, int length)
    {
        int numComparisons = 0;
        int numSwaps = 0;
        
        for (int i = 1; i < arr.length; i++)
        {
            numComparisons++;
            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--)
            {
                numComparisons++;
                numSwaps++;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }

        System.out.println("Total number of comparisons for insertion sort: " + numComparisons);
        System.out.println("Total number of swaps for insertion sort: " + numSwaps);
    }

}

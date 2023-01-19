import java.util.ArrayList;

public class BogoSortExperiment {
    
    public static void main(String[] args)
    {
        
        int sortCounter = 0;
        int numSorts = 1;

        String ANSI_GREEN = "\u001B[32m";
        System.out.print(ANSI_GREEN);

        ArrayList<Integer> count = new ArrayList<Integer>();
        while (sortCounter < numSorts)
        {
            int[] arr = {0, -13, 200, 57, 32, 131, 54, -64, 3};
            int counter = 0;

            System.out.println(isSorted(arr));

            while(!isSorted(arr))
            {
                shuffle(arr);
                for (int x : arr)
                {
                    System.out.println(x);
                }
                System.out.println(isSorted(arr));
                counter++;
                System.out.println(counter + "\n");
            }
            System.out.println("Final count: " + counter + "\n");
            count.add(counter);

            sortCounter++;
        }

        int total = 0;
        for (int x : count)
        {
            total += x;
            System.out.println(x);
        }
        System.out.println("\nAverage: " + (total/numSorts));

    }

    public static void shuffle(int[] arr){
        for(int i = arr.length - 1;i > 0;i--){
            int j = (int) (i * Math.random());

            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[i])
                {
                    return false;
                }
            }
        }
        return true;
    }

}

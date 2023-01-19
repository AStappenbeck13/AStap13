public class InsertionSort {
    
    public static void main(String[] args)
    {
        int[] arr = {5,4,3,2,1};
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--)
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            
            }
        }
        for(int x = 0; x < arr.length; x++)
        {
            System.out.println(arr[x]);   
        }
    }

}

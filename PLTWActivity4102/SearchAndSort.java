package PLTWActivity4102;

public class SearchAndSort
{
    public static void main(String[] args) 
    { 
      final int SIZE = 100;
      final int RANGE = 1000;
      
      int[] arr = new int[SIZE];
      
      for (int i = 0; i < SIZE; i++)
        arr[i] = (int)(Math.random() * RANGE) + 1;
        
      // search for a random array element
      int intSearch = arr[(int)(Math.random() * SIZE)];
      
      long startTime = System.nanoTime();
      int result = iSearch(arr, intSearch, 0); 
      long endTime = System.nanoTime();
        
      System.out.println("Execution time: " +  (endTime - startTime) / 1e6  + " seconds");
      
      if (result == -1) 
        System.out.println(intSearch +" not found"); 
      else
        System.out.println(intSearch + " found at index  " + result);


      mergeSort(arr, 0, arr.length - 1);
      printArray(arr);
      for (int i = 0; i < 50; i++)
      {
        System.out.println(i + " " + binarySearchIterative(arr, 0, arr.length - 1, i));
      }

    }

    /*
    * Returns index of x if x's value is present in arr[], else return -1
    */
  public static int iSearch(int x[], int intSearch, int position)
  {
    if (position < x.length)
    {
      if (x[position] == intSearch)
        return position;
      else
        return iSearch(x, intSearch, position + 1);
    }
    return -1;
  }

      /**
   * Sorts arr[l..r] using merge()
   */
  public static void mergeSort(int arr[], int lt, int rt) 
  { 
    if (lt < rt) 
    { 
      // Find the middle point 
      int m = (lt + rt) / 2; 

      // Sort first and second halves 
      mergeSort(arr, lt, m); 
      mergeSort(arr , m + 1, rt); 

      // Merge the sorted halves 
      merge(arr, lt, m, rt); 
    } 
  } 

  /*
   * Helper method for mergeSort
   */
  private static void merge(int arr[], int lt, int m, int rt) 
  { 
    // Find sizes of two subarrays to be merged 
    int n1 = m - lt + 1; 
    int n2 = rt - m; 
    
    // Create temp arrays 
    int left[] = new int[n1]; 
    int right[] = new int[n2]; 
    
    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i) 
      left[i] = arr[lt + i]; 
    for (int j = 0; j < n2; ++j) 
      right[j] = arr[m + 1 + j]; 
    
    /* merge the temp arrays */
    
    // Initial indexes of first and second subarrays 
    int i = 0;
    int j = 0; 
    
    // Initial index of merged subarry array 
    int k = lt; 
    while (i < n1 && j < n2) 
    { 
      if (left[i] <= right[j]) 
      { 
        arr[k] = left[i]; 
        i++; 
      } 
      else
      { 
        arr[k] = right[j]; 
        j++; 
      } 
      k++; 
    } 
    
    // Copy remaining elements of L[] if any
    while (i < n1) 
    { 
      arr[k] = left[i]; 
      i++; 
      k++; 
    } 
    
    // Copy remaining elements of R[] if any 
    while (j < n2) 
    { 
        arr[k] = right[j]; 
        j++; 
        k++; 
    } 
  } 

  /**
   * Sorts int[] num using a bubble sort algorithm
   */
  public static void bubbleSort(int[] num )
  {
    boolean flag = true;   // set flag to true to begin first pass
    int temp;   //holding variable
    
    while (flag)
    {
      flag = false;    //set flag to false awaiting a possible swap
      for(int j = 0;  j < num.length - 1;  j++ )
      {
        if (num[j] > num[j + 1] )   // change to < for descending sort
        {
          temp = num[j];                //swap elements
          num[j] = num[j + 1];
          num[j + 1] = temp;
          flag = true;              //shows a swap occurred 
        }
      }
    }
  }

  /**
   * Print the array
   */
  public static void printArray(int arr[]) 
  { 
    int n = arr.length; 
    for (int i = 0; i < n; ++i) 
      System.out.print(arr[i] + " "); 
    System.out.println(); 
  }

  public static int binarySearch(int arr[], int lt, int rt, int x) 
  { 
    if (rt >= lt)
    { 
      int mid = lt + (rt - lt) / 2; 

      if (arr[mid] == x) 
        return mid; 
          
      if (arr[mid] > x) 
        return binarySearch(arr, lt, mid - 1, x); 

      return binarySearch(arr, mid + 1, rt, x); 
    } 
    return -1; 
  }

  public static int binarySearchIterative(int arr[], int lt, int rt, int x) 
  { 
    while (rt >= lt)
    { 
      int mid = lt + (rt - lt) / 2; 

      if (arr[mid] == x) 
      {
        return mid;
      } 
          
      else if(arr[mid] > x)
      {
        rt = mid - 1;
      }
      else
      {
        lt = mid + 1;
      }
    } 
    return -1; 
  }
}
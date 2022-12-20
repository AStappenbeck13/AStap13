public class MaxMinVal {
    
    public static void main(String[] args)
    {
        int nums[] = {0, -6, 1232, 34, 0, 23, -12};

        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
            }
        }

        System.out.println("The max value is: " + max);

        int min = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if (nums[i] < min)
            {
                min = nums[i];
            }
        }

        System.out.println("The min value is: " + min);

    }

}

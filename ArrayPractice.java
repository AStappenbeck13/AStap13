public class ArrayPractice {
    
    public static void main(String[] args)
    {
        int[] nums = {0, 7, 324, 112, -32};
        String[] names = {"Andrew", "Max", "Aric", "Mason", "mrJ"};
        char[] letters = {'a', 'r', '4', 'w', 'Q'};


        int index = 0;
        while(index < nums.length)
        {
            System.out.println(nums[index]);
            index++;
        }

        System.out.println();

        for(int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }

        System.out.println();

        for (char x : letters)
        {
            System.out.println(x);
        }


    }

}

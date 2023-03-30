package PLTWActivity4101;

public class ReverseString {
    
    public static void main(String[] args)
    {
        String s = "abcdefghijklmnopqrstuvwxyz";
        //System.out.println(s.substring(2,3));
        System.out.println(reverse(s));
    }

    /**
    * Reverse a string using an iterative algorithm
    */
    public static String reverse(String str)
    {
        String newstr = "";

        for(int i = str.length(); i > 0; i--)
        {
            newstr += str.substring(i - 1, i);
        }

        return newstr;
    }
}

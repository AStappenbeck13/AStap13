public class StringParseTest {
    
    public static void main(String[] args)
    {
        String a = "3423";
        String b = "Hello";

        try {
            int val = Integer.parseInt(b);
            System.out.println(val);
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }

        int test1 = 3;
        int test2 = 5;
        System.out.println(test1/test2);




    }

}

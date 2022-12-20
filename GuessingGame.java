import java.util.Scanner;

public class GuessingGame {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        char[] phrase = new char[20];

        String s = "abcdefghijklmnopqrstuvwxyz";
        char[] letters = s.toCharArray();

        for (int i = 0; i < phrase.length; i++)
        {
            phrase[i] = letters[(int)(Math.random() * 26)];
        }

        System.out.println(phrase);

        int pts = 0;

        boolean playing = true;

        int lettersGuessing = 1;

        while(playing)
        {


            for (int i = 0; i < lettersGuessing; i++)
            {
                System.out.print(phrase[i]);
            }
            System.out.println();

            System.out.println("\nEnter a string with a length of " + lettersGuessing);
            String in = sc.nextLine();
            while (in.length() != lettersGuessing)
            {
                System.out.println("Please enter a string with a length of " + lettersGuessing);
                in = sc.nextLine();
            }
            char[] guess = in.toCharArray();

            for (int i = 0; i < lettersGuessing; i++)
            {
                if (phrase[i] == guess[i])
                {
                    pts++;
                    System.out.println("Correct!");
                }
                else
                {
                    playing = false;
                }
            }
            System.out.println(pts);
            lettersGuessing++;


            //playing = false;
        }



        sc.close();
    }

}

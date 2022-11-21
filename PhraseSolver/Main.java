package PhraseSolver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        
        Board board = new Board();

        System.out.println("Input player 1's name:");
        String name1 = sc.nextLine();
        Player player1 = new Player(name1, 0);

        System.out.println("Input player 2's name:");
        String name2 = sc.nextLine();
        Player player2 = new Player(name2, 0);

        // allows users to play again
        boolean playing = true;
        while(playing)
        {
            //System.out.println("Player 1: " + player1.getName() + ", Current score: " + player1.getScore());
            //System.out.println("Player 2: " + player2.getName() + ", Current score: " + player2.getScore());
            System.out.println("\nPlayer 1:" + player1);
            System.out.println("\nPlayer 2:" + player2);

            // this is the "key" - the phrase the players are guessing
            String actualPhrase = board.loadPhrase();
            board.setPhrase(actualPhrase);

            // this is the phrase with letters filled in for correct guesses
            // and underscores for letters not yet guessed
            String phrase = board.setBoard(actualPhrase);
            board.setCurrentPhrase(phrase);
            System.out.println(board.getCurrentPhrase());

            // True if its player1's turn, false if player2's
            boolean playerTurn = true;

            // ends when the board is completely filled in
            while(!board.getPhrase().equals(board.getCurrentPhrase()))
            {

                if(playerTurn)
                {
                    System.out.println("\nIt is " + player1.getName() + "'s turn!");
                }
                else
                {
                    System.out.println("\nIt is " + player2.getName() + "'s turn!");
                }
                
                
                int pts = 100 * (int)(Math.random() * 5 ) + 100;
                System.out.println("Point value for this guess: " + pts);
                
                System.out.println("Enter a letter to guess");


                String x = sc.nextLine();

                //makes sure there is an actual guess
                if (x.length() > 0)
                {
                    System.out.println();
                    // random number of pts are added if correct
                    // or substracted if incorrect
  

                    /*
                    if(x.equals("a") || x.equals("e") || x.equals("i")
                    || x.equals("o") || x.equals("u") || x.equals("y"))
                    {
                        pts = 100 * (int)(Math.random() * 6 ) + 100;
                    }
                    else
                    {
                        pts = 100 * (int)(Math.random() * 2 ) + 100;
                    }*/

                    x = x.toLowerCase();

                    char letter = x.charAt(0);
                    if(x.length() == 1 && Character.isLetter(letter) && !board.getLettersGuessed().contains(x))
                    {
                        board.setLettersGuessed(board.getLettersGuessed() + x);
                    }
                    System.out.println("Letters guessed: " + board.getLettersGuessed());

                    // this changes whose turn it is if there is an incorrect guess
                    System.out.println(board.processGuess(x, phrase));
                    if (phrase.equals(board.getCurrentPhrase()))
                    {
                        System.out.println("Incorrect guess!");
                        if (playerTurn)
                        {
                            player1.setScore(player1.getScore() - pts);
                        }
                        else
                        {
                            player2.setScore(player2.getScore() - pts);
                        }
                        System.out.println(player1);
                        System.out.println(player2);
                        playerTurn = !playerTurn;
                        if (playerTurn)
                        {
                            System.out.println("It's now " + player1.getName() + "'s turn!");
                        }
                        else
                        {
                            System.out.println("It's now " + player2.getName() + "'s turn!");
                        }
                    }
                    else
                    {
                        System.out.println("Correct guess!");
                        if (playerTurn)
                        {
                            player1.setScore(player1.getScore() + pts);
                        }
                        else
                        {
                            player2.setScore(player2.getScore() + pts);
                        }
                        System.out.println(player1);
                        System.out.println(player2);
                    }
                    phrase = board.getCurrentPhrase();

                    System.out.println();

                }
            }

            // runs once the board is completely filled in
            if (actualPhrase.equals(phrase))
            {
                System.out.println("Phrase solved");
            }

            // determining the winner
            if (player1.getScore() > player2.getScore())
            {
                System.out.println(player1.getName() + " wins!");
            }
            else if (player1.getScore() < player2.getScore())
            {
                System.out.println(player2.getName() + " wins!");
            }
            else
            {
                System.out.println(player1.getName() + " and " + player2.getName() + " tied!");
            }

            System.out.println("Press p to play again, press anything else to stop");
            String next = sc.nextLine();
            next = next.toLowerCase();
            if (next.equals("p"))
            {
                player1.setScore(0);
                player2.setScore(0);
                System.out.println("Play again!");
            }
            else
            {
                playing = false;
            }
        }

        sc.close();
    }
    
}

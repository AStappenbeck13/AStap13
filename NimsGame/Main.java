package NimsGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is player1's name? ");
        //TO DO: Create Player 1
        String n1 = sc.nextLine();
        Player p1 = new Player(n1);

        //Asks the user to input their name for the player.
        System.out.println("What is player2's name? ");
        //TO DO: Create Player 2
        String n2 = sc.nextLine();
        Player p2 = new Player(n2);

        String again = "Literally any string";
        Player currentPlayer;
        
        boolean playing = true;
        //Runs the game
        while (playing && !again.equals("q")){
            //Generates the game
            //TO DO: Create "game"
            Game game = new Game(p1, p2);


            //resets scores if they play again
            p1.setScore(0);
            p2.setScore(0);

            //TO DO: Set the a random player as the current player
            int p = (int)(Math.random() * 2) + 1;
            if (p == 1)
            {
                currentPlayer = p1;
            }
            else
            {
                currentPlayer = p2;
            }
            

            game.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!game.isComplete())
            {
                System.out.println("It is " + currentPlayer.getName() + "'s turn!");
                game.takePiece();
                currentPlayer = game.getNextPlayer();
                
            }

            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
            if (again.equals("q"))
            {
                playing = false;
            }
        }
        System.out.println("Thank you for playing!");

        sc.close();
    }
}

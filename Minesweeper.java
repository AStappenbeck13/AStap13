import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        System.out.print(blue);

        boolean inGame = true;
        while(inGame)
        {
            int numRows = 8;
            int numCols = numRows;

            String[][] masterBoard = new String[numRows][numCols];
            String[][] userBoard = new String[numRows][numCols];

            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < numCols; j++)
                {
                    masterBoard[i][j] = "0";
                    userBoard[i][j] = "-";
                }
            }

            int numMines = 0;
            // randomizes location of mines
            for (int i = 0; i < numRows + 4; i++)
            {
                int mine = (int)(Math.random() * numCols) + 10 * (int)(Math.random() * numRows);
                // ones digit corresponds to column, tens digit corresponds to row
                while (masterBoard[mine / 10][mine % 10].equals("X"))
                {
                    mine = (int)(Math.random() * numCols) + 10 * (int)(Math.random() * numRows);
                }
                masterBoard[mine / 10][mine % 10] = "X";
                numMines++;
            }

            checkBoard(masterBoard);
            //printBoard(masterBoard);

            printBoard(userBoard);
            boolean playing = true;
            while (playing)
            {
                boolean flag = false;
                boolean invalid = true;

                int rowGuess = 0;
                int colGuess = 0;
                
                //ensure that input is within board
                while (invalid)
                {
                    System.out.println("Press F to flag/unflag a spot, press anything else to guess a spot");
                    String g = sc.nextLine();
    
                    if (g.equals("f") || g.equals("F"))
                    {
                        flag = true;
                    }

                    System.out.println("Input a spot to guess: First input the row number");

                    boolean invalid1 = true;
                    g = sc.nextLine();

                    while (invalid1)
                    {
                        try {
                            int val = Integer.parseInt(g);

                            if(val >= 1 && val <= numRows)
                            {
                                rowGuess = val - 1;
                                invalid1 = false;
                            }
                            else
                            {
                                System.out.println("Please enter a number between 1 and " + numRows);
                                g = sc.nextLine();
                            }
                        } 
                        catch (NumberFormatException e) {
                            System.out.println("Please input an integer");
                            g = sc.nextLine();
                        }
                    }

                    System.out.println("Now input a column number");

                    boolean invalid2 = true;
                    g = sc.nextLine();

                    while (invalid2)
                    {
                        try {
                            int val = Integer.parseInt(g);

                            if(val >= 1 && val <= numCols)
                            {
                                colGuess = val - 1;
                                invalid2 = false;
                            }
                            else
                            {
                                System.out.println("Please enter a number between 1 and " + numCols);
                                g = sc.nextLine();
                            }
                        } 
                        catch (NumberFormatException e) {
                            System.out.println("Please input an integer");
                            g = sc.nextLine();
                        }
                    }
                    if (flag)
                    {
                        if (!(userBoard[rowGuess][colGuess].equals("-") || userBoard[rowGuess][colGuess].equals("F")))
                        {
                            System.out.println("Spot already checked. Please guess another spot.");
                        }
                        else
                        {
                            invalid = false;
                        }
                    }
                    else
                    {
                        if (!userBoard[rowGuess][colGuess].equals("-"))
                        {
                            System.out.println("Spot already checked. Please guess another spot.");
                        }
                        else
                        {
                            invalid = false;
                        }
                    }
                }

                if (flag)
                {
                    if (userBoard[rowGuess][colGuess].equals("F"))
                    {
                        userBoard[rowGuess][colGuess] = "-";
                    }
                    else
                    {
                        userBoard[rowGuess][colGuess] = "F";
                    }
                }
                else
                {
                    userBoard[rowGuess][colGuess] = masterBoard[rowGuess][colGuess];
                }

                checkAdjacent(userBoard, masterBoard, rowGuess, colGuess);
                printBoard(userBoard);

                if (userBoard[rowGuess][colGuess].equals("X"))
                {
                    playing = false;
                    System.out.println(red + "You idiot! You hit a mine :( Game over." + blue);
                }

                int blankCounter = 0;
                for (int i = 0; i < userBoard.length; i++)
                {
                    for (int j = 0; j < userBoard[i].length; j++)
                    {
                        if(userBoard[i][j].equals("-"))
                        {
                            blankCounter++;
                        }
                    }
                }
                blankCounter += incorrectFlags(userBoard, masterBoard);

                if (blankCounter == numMines && playing)
                {
                    System.out.println(green + "Congrats. Against all odds, you won." + blue);
                    playing = false;
                }
            }

            System.out.println("Press y to play again");
            String in = sc.nextLine();
            if (!(in.equals("Y") || in.equals("y")))
            {
                inGame = false;
            }

        }
        sc.close();
    }

    public static void printBoard(String[][] board)
    {
        //String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String white = "\u001B[37m";
        
        System.out.print("  ");
        for (int i = 0; i < board.length; i++)
        {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        
        for (int i = 0; i < board.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board[i].length; j++)
            {
                String temp = board[i][j];
                
                // colors text based on proximity to mine
                if (!temp.equals("-"))
                {
                    if (temp.equals("0"))
                    {
                        System.out.print(green);
                    }
                    else if (temp.equals("X"))
                    {
                        System.out.print(red);
                    }
                    else if (temp.equals("F"))
                    {
                        System.out.print(white);
                    }
                    else
                    {
                        System.out.print(yellow);
                    }
                }

                System.out.print(board[i][j] + blue + " ");
            }
            System.out.println();
        }
    }

    //will get squares labeled with how many mines it borders
    public static void checkBoard(String[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (!board[i][j].equals("X"))
                {
                    int numAdjMines = 0;
                    for (int row = i - 1; row <= i + 1; row++)
                    {
                        for (int col = j - 1; col <= j + 1; col++)
                        {
                            if(row >= 0 && row < board.length 
                            && col >= 0 && col < board[i].length)
                            {
                                if(board[row][col].equals("X"))
                                {
                                    numAdjMines++;
                                }
                            }
                        }
                    }
                    board[i][j] = "" + numAdjMines;
                }
            }
        }
    }

    //in the event that a 0 square is explored, this will reveal surrounding squares
    public static void checkAdjacent(String[][] userBoard, String[][] masterBoard, int i, int j)
    {
        if (userBoard[i][j].equals("0"))
        {
            for (int row = i - 1; row <= i + 1; row++)
            {
                for (int col = j - 1; col <= j + 1; col++)
                {
                    if (row >= 0 && row < masterBoard.length
                    &&  col >= 0 && col < masterBoard.length)
                    {
                        if (userBoard[row][col].equals("-"))
                        {
                            userBoard[row][col] = masterBoard[row][col];
                            if (masterBoard[row][col].equals("0"))
                            {
                                checkAdjacent(userBoard, masterBoard, row, col);
                            }
                        }
                    }
                }
            }
        }
    }

    // counts incorrect flags - necessary to end game
    public static int incorrectFlags(String[][] userBoard, String[][] masterBoard)
    {
        int count = 0;
        for (int i = 0; i < userBoard.length; i++)
        {
            for (int j = 0; j < userBoard[i].length; j++)
            {
                if (userBoard[i][j].equals("F") && !masterBoard.equals("X"))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
import java.util.*;

public class MinesweeperOld {
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String[][] userBoard = {{"-", "-", "-", "-", "-"},
                            {"-", "-", "-", "-", "-"},
                            {"-", "-", "-", "-", "-"},
                            {"-", "-", "-", "-", "-"},
                            {"-", "-", "-", "-", "-"}};

    int[][] board = {{0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0}};  

    //int numRows = 5;
    //int numCols = 5;
    for (int i = 0; i < board.length; i++)
    {
      int mine = (int)(Math.random() * 5);
      board[i][mine] = 9;
      // 9 corresponds to mine
    }


    printBoardString(userBoard);

   // System.out.println();

    checkBoard(board);
    //printBoard(board);

    String[][] masterBoard = new String[5][5];
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        masterBoard[i][j] = "" + board[i][j];
        if(masterBoard[i][j].equals("9"))
        {
          masterBoard[i][j] = "X";
        }
      }
    }
    
    //printBoardString(masterBoard);

      /*String[] validRows = new String[numRows];
      for (int i = 0; i < numRows; i++)
      {
          validRows[i] = "" + i;
      }
      String[] validCols = new String[numCols];
      for (int i = 0; i < numCols; i++)
      {
          validCols[i] = "" + i;
      }*/

      boolean playing = true;
      while (playing)
      {
        System.out.println("Guess a spot to guess: First input the row number");
  
      boolean invalid1 = true;
      String w = sc.nextLine();
  
      // while loop until the user enters a valid input for difficulty
      while (invalid1)
      {
        if (w.equals("1") || w.equals("2") || w.equals("3") || w.equals("4") || w.equals("5")) 
        {
          invalid1 = false;
        }  
        else
        {
          System.out.println("Please enter a valid integer");
          w = sc.nextLine();
        }
      }
      int rowGuess = Integer.parseInt(w)-1;
  
        System.out.println("Now input a column number");
      boolean invalid2 = true;
      w = sc.nextLine();
  
      // while loop until the user enters a valid input for difficulty
      while (invalid2)
      {
        if (w.equals("1") || w.equals("2") || w.equals("3") || w.equals("4") || w.equals("5")) 
        {
          invalid2 = false;
        }  
        else {
          System.out.println("Please enter a valid integer");
          w = sc.nextLine();
        }
      }
      int colGuess = Integer.parseInt(w)-1;

      
      userBoard[rowGuess][colGuess] = masterBoard[rowGuess][colGuess];

      printBoardString(userBoard);
      
      if (userBoard[rowGuess][colGuess].equals("X"))
      {
        playing = false;
        System.out.println("You hit a mine. Game over.");
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
      if (blankCounter == 5)
      {
        System.out.println("You won!");
        playing = false;
      }
      
    }

  }

  public static void printBoard(int[][] board)
  {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void printBoardString(String[][] board)
  {
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
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void checkBoard(int[][] board)
  {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        if (board[i][j] != 9)
        {
          for (int row = i - 1; row <= i + 1; row++)
          {
            for (int col = j - 1; col <= j + 1; col++)
            {
              if(row >= 0 && row < board.length 
                 && col >= 0 && col < board[i].length)
              {
                if(board[row][col] == 9)
                {
                  board[i][j]++;
                }
              }
            }
          }
        }
      }
    }
  }

  /*public static void checkAdjacent(String[][] board, String[][] masterBoard, int row, int col)
  {
    ArrayList<Integer> checkIndices = new ArrayList<Integer>();
    checkIndices.add(row);
    checkIndices.add(col);
    
    for (int i = 0; i < checkIndices.size(); i += 2)
    {
        for (int j = 1; j < checkIndices.size(); j += 2)
        {
            
        }
    }
    if (row - 1 >= 0 && masterBoard[row - 1][col].equals("0"))
    {
      board[row - 1][col] = "0";
    }
  }*/
}
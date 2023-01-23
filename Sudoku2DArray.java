public class Sudoku2DArray {
    
    public static void main(String[] args)
    {
        int[][] board = new int[9][9];
        System.out.println(board.length);
    }


    public static void guess(int[][] board)
    {
        //while (!legalGuess())
    }

    public static boolean legalGuess(int[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            int[] checkColumn = new int[board[i].length];
            for (int j = 0; j < board[i].length; j++)
            {
                checkColumn[j] = board[i][j];
            }
            if(checkIssues(checkColumn))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIssues(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 1 || arr[i] > 9)
            {
                return true;
            }
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}

public class LotteryRunner {
    
    public static void main(String[] args)
    {
        LotteryNums num1 =      new LotteryNums("09/25/2020",2036374867,16,02);
        LotteryNums num2 =      new LotteryNums("09/29/2020",1439434467,19,03);
        LotteryNums num3 =      new LotteryNums("10/02/2020", 938474968,25,02);
        LotteryNums num4 =      new LotteryNums("10/06/2020",1516183959,17,03);
        LotteryNums num5 =      new LotteryNums("10/09/2020",0511252764,13,02);
        LotteryNums num6 =      new LotteryNums("10/13/2020",1144454670,25,02);
        //LotteryNums num7 =      new LotteryNums("10/16/2020",2732505257,12,05); //outside int limit
        //LotteryNums num8 =      new LotteryNums("10/20/2020",4654575866,10,03); //outside int limit
        LotteryNums num9 =      new LotteryNums("10/23/2020",1834446069,22,02);
        LotteryNums num10 =     new LotteryNums("10/27/2020",0613344662,01,03);

        int guess = (int)(Math.random()*2147483647);
        int[] guesses = new int[100000];
        for (int i = 0; i < guesses.length; i++)
        {
            guesses[i] = guess;
            guess = (int)(Math.random()*2147483647);
        }

        int counter = 0;
        boolean guessed = false;
        for (int x : guesses)
        {
            System.out.println(x);
            if (x == num1.getNumber() || 
                x == num2.getNumber() ||
                x == num3.getNumber() ||
                x == num4.getNumber() ||
                x == num5.getNumber() ||
                x == num6.getNumber() ||
                //x == num7.getNumber() ||
                //x == num8.getNumber() ||
                x == num9.getNumber() ||
                x == num10.getNumber())
                {
                    System.out.println("There is a chance of guessing a month's lottery numbers in + " 
                    + counter + " guesses");
                    guessed = true;
                    break;
                }
                counter++;
        }
        if (!guessed)
        {
            System.out.println("After " + counter + " guesses, it is still unlikelty a month's worth of lottery numbers will be guessed");
        }

    }

}

public class LotteryNums {
    
    private String date;
    private int number;
    private int megaBall;
    private int multiplier;

    public LotteryNums(String d, int n, int mb, int mp)
    {
        date = d;
        number = n;
        megaBall = mb;
        multiplier = mp;
    }

    public int getNumber()
    {
        return number;
    }

}

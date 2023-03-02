package PLTWActivity492;

public class Penguin extends Bird
{
    public Penguin()
    {
        
    }
    
    public Penguin(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
    }
    
    public void fish()
    {
        System.out.println("The penguin searches for fish.");
    }

    public void speak()
    {
      System.out.println("Squawk");
    }
}

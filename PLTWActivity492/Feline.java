package PLTWActivity492;

public class Feline extends Animal
{
    public Feline()
    {
        
    }
    
    public Feline(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
        System.out.println("A feline arrives.");
    }

    public void roar()
    {
        System.out.println("The feline roars.");
    }

    public void growl()
    {
        System.out.println("The feline growls");
    }

    public void speak()
    {
      System.out.println("Purr");
    }
}

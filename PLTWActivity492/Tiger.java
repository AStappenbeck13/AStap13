package PLTWActivity492;

public class Tiger extends Feline
{
    public Tiger()
    {
        
    }
    
    public Tiger(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
        System.out.println("The new arrival to the zoo is a tiger.");
    }
    
    public void huntAlone()
    {
        System.out.println("The tiger hunts alone.");
    }

    public void swim()
    {
        System.out.println("The tiger swims.");
    }

    public void speak()
    {
        System.out.println("Roar");
    }
}

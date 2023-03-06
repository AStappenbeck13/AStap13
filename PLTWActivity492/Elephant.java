package PLTWActivity492;

public class Elephant extends Animal
{
    public Elephant()
    {
        
    }
    
    public Elephant(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
        System.out.println("The new arrival to the zoo is an elephant.");
    }
    
    public void trumpet()
    {
        System.out.println("The elephant trumpets.");
    }

    public void forage()
    {
        System.out.println("The elephant forages for food");
    }

    public void speak()
    {
      System.out.println("Trumpet");
    }

    public String toString()
    {
        return "This is an object of the Elephant class.";
    }
}

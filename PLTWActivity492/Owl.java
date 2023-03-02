package PLTWActivity492;

public class Owl extends Bird
{
    public Owl()
    {
        
    }
    
    public Owl(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
    }
    
    public void hunt()
    {
        System.out.println("The owl hunts for food.");
    }

    /*public void eat()
    {
        System.out.println("The owl eats.");
    }*/

    public void speak()
    {
      System.out.println("Hoot");
    }
}

package PLTWActivity492;

public class Hooved extends Animal
{
  public Hooved()
  {
    
  }
  
  public Hooved(String food, boolean nocturnal, double aveLifeSpan)
  {
    super(food, nocturnal, aveLifeSpan);
  }

  public void forage()
  {
    System.out.println("The hooved animal forages for food.");
  }

  public void speak()
  {
    System.out.println("Clop clop");
  }
}
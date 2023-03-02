package PLTWActivity492;

public class Giraffe extends Hooved
{
  public Giraffe()
  {
    
  }
  
  public Giraffe(String food, boolean nocturnal, double aveLifeSpan)
  {
    super(food, nocturnal, aveLifeSpan);
  }
  
  public void hum()
  {
    System.out.println("The giraffe hums.");
  }

  public void speak()
  {
    System.out.println("Hum");
  }
}
package HorseBarnActivity374;
import java.util.ArrayList;

public class HorseBarnRunner
{
  public static void main(String[] args)
  { 
    ArrayList<Horse> horses = new ArrayList<Horse>();
    horses.add(new Horse("Trigger", 1340));
    horses.add(new Horse("Silver", 1210));
    horses.add(new Horse("Lady", 1575));
    horses.add(new Horse("Patches", 1350));
    horses.add(new Horse("Duke", 1410));
    horses.add(new Horse("Major", 1495));
    horses.add(new Horse("Misty", 1425));
    horses.add(new Horse("Buddy", 1340));
    horses.add(new Horse("Autumn", 1460));
    horses.add(new Horse("Spirit", 1295));

    ArrayList<Horse> randHorses = horses;

    System.out.println("Original order of horses:");
    for (Horse x : randHorses)
    {
        System.out.println(x);
    }
    
    randHorses = RandomPermutation.next(randHorses, randHorses.size());
    
    System.out.println("\nNew randomized order of horses:");
    for (Horse x : randHorses)
    {
        System.out.println(x);
    }

    randHorses = RandomPermutation.next(randHorses, randHorses.size());
    int counter = 1;
    for (int i = 0; i < randHorses.size() - 1; i += 2)
    {
        System.out.println("\nPair " + counter + " of horses:");
        System.out.println(randHorses.get(i) + " and " + randHorses.get(i + 1));

        counter++;
    }
    if (randHorses.size() % 2 == 1)
    {
        System.out.println("\nThe unpaired horse is " + randHorses.get(randHorses.size() - 1));
    }
    else
    {
        System.out.println("\nThere are no unpaired horses");
    }
  }
} 

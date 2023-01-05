package HorseBarnActivity374;
import java.util.ArrayList;

public class RandomPermutation
{
    public static ArrayList<Horse> next(ArrayList<Horse> horses, int size)
    {
        ArrayList<Horse> oldHorses = horses;
        ArrayList<Horse> newHorses = new ArrayList<Horse>();

        while (oldHorses.size() > 0)
        {
            int pos = (int) (Math.random() * oldHorses.size());

            newHorses.add(oldHorses.get(pos));
            oldHorses.remove(pos);
        }
        
        return newHorses;
    }

}
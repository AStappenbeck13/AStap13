import java.util.ArrayList;

public class HorseBarnFRQ {
    
    private ArrayList<HorseFRQ> spaces;

    public HorseBarnFRQ(ArrayList<HorseFRQ> s)
    {
        spaces = s;
    }

    //PART A
    public int findHorseSpace(String name)
    {
        for (int i = 0; i < spaces.size(); i++)
        {
            if (spaces.get(i) != null)
            {
                String horseName = spaces.get(i).getName();

                if (horseName.equals(name))
                {
                    return i;
                }
            }
        }
        return -1;
    }
    
    //PART B
    public void consolidate()
    {
        int counter = 0;

        for (int i = 0; i < spaces.size(); i++)
        {
            if (spaces.get(i) == null)
            {
                spaces.remove(null);
                counter++;
            }
        }
        for (int i = 0; i < counter; i++)
        {
            spaces.add(null);
        }
    }

    public String toString()
    {
        String s = "";
        for (HorseFRQ x : spaces)
        {
            if (x != null)
            {
                s += x.getName() + "\n";
            }
            else
            {
                s += null + "\n";
            }
        }

        return s;
    }

}

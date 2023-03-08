package InheritanceMiniProject;

public class Poles extends Earth
{
    private boolean northPole;

    public Poles()
    {

    }

    public boolean getNorthPole()
    {
        return northPole;
    }

    public void setNorthPole(boolean n)
    {
        northPole = n;
    }

    public void temperatureInfo()
    {
        System.out.println("It's cold!");
    }

    public void animalInhabitants()
    {
        if(northPole)
        {
            System.out.println("Arctic foxes live here");
        }
        else
        {
            System.out.println("Penguins and seals live here");
        }
    }

    public void size()
    {
        System.out.println("Earth's poles have a surface area of about 11 million square miles");
    }

    public void population()
    {
        System.out.println("Only a few scientists live on Earth's poles");
    }
}

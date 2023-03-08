package InheritanceMiniProject;

public class Earth
{
    private int distFromSun;

    public Earth()
    {

    }

    public int getDistFromSun()
    {
        return distFromSun;
    }

    public void setDistFromSun(int d)
    {
        distFromSun = d;
    }

    public void rotate()
    {
        System.out.println("The Earth rotates once a day");
    }

    public void revolve()
    {
        System.out.println("The Earth revoles around the Sun once a year");
    }

    public void size()
    {
        System.out.println("The Earth's total surface area is 197 million square miles");
    }

    public void population()
    {
        System.out.println("Earth's population is 8 billion");
    }
}

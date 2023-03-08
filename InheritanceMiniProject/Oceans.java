package InheritanceMiniProject;

public class Oceans extends Earth
{
    private boolean storming;

    public Oceans()
    {

    }

    public boolean getStorming()
    {
        return storming;
    }

    public void setStorming(boolean s)
    {
        storming = s;
    }

    public void navigate()
    {
        System.out.println("You are navigating across the ocean");
    }

    public void capsize()
    {
        System.out.println("Your boat capsizes and sinks in the ocean");
    }

    public void size()
    {
        System.out.println("The total surface area of Earth's water is roughly 140 million square miles");
    }

    public void population()
    {
        System.out.println("No people live in the oceans");
    }
}

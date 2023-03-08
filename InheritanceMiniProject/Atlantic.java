package InheritanceMiniProject;

public class Atlantic extends Oceans
{
    private int distAcross;

    public Atlantic()
    {

    }

    public int getDistAcross()
    {
        return distAcross;
    }

    public void setDistAcross(int d)
    {
        distAcross = d;
    }

    public void bermudaTriangle()
    {
        System.out.println("Your boat travels in the bermuda triangle and mysterious disappears");
    }

    public void iceOver()
    {
        System.out.println("The frigid waters of the Atlantic ice over, making travel difficult");   
    }

    public void size()
    {
        System.out.println("The Atlantic Ocean has a surface area of 41 million square miles");
    }

    public void population()
    {
        System.out.println("No one lives in the Atlantic Ocean itself");
    }
}

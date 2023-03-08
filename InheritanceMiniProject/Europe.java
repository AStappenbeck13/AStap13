package InheritanceMiniProject;

public class Europe extends Continents
{
    private boolean inEU;

    public Europe()
    {

    }

    public boolean getInEU()
    {
        return inEU;
    }

    public void setinEU(boolean i)
    {
        inEU = i;
    }

    public void languagesSpoken()
    {
        System.out.println("The European Union recognizes 24 official languages, with more spoken inside and outside the EU");
    }

    public void coastlineLength()
    {
        System.out.println("Europe has a coastline of roughly 42,000 miles");
    }

    public void size()
    {
        System.out.println("Europe is has a land area of 4 million square miles");
    }

    public void population()
    {
        System.out.println("Europe has a population of 746 million people");
    }
}

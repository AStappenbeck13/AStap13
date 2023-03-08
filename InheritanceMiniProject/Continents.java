package InheritanceMiniProject;

public class Continents extends Earth
{    
    private int temperature;

    public Continents()
    {

    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int t)
    {
        temperature = t;
    }

    public void biomes()
    {
        System.out.println("The four main biomes on land are grassland, forest, desert, and tundra");
    }

    public void speaksEnglish()
    {
        System.out.println("English is spoken on every continent to some degree");
    }

    public void size()
    {
        System.out.println("The total surface area of Earth's land is roughly 57 million square miles");
    }

    public void population()
    {
        System.out.println("8 billion people live on Earth's continents");
    }

}

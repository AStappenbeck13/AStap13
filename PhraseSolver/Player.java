package PhraseSolver;

public class Player {
    
    private String name;
    private int score;

    public Player (String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int s)
    {
        score = s;
    }

    public String toString()
    {
        String x = "";

        x += "\nName: " + name + "\n";
        x += "Score: " + score;

        return x;
    }

}

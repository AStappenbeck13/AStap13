public class Cereal {

    private String name;
    //private char type;
    private int calories;
    //private int protein;
    //private int fat;
    //private int sodium;
    //private double fiber;
    //private double carbohydrates;
    private int sugar;
    //private int potassium;
    //private int vitamins;
    //private int shelf;
    //private double weight;
    //private double cups;
    //private double rating;

    public Cereal (String n, int c, int s)
    {
        name = n;
        calories = c;
        sugar = s;
    }

    /*
    public Cereal (String n, char t, int cal, int p, int f, int na, double fib, double carb, int s, int k, int v, int sh, double w, double c, double r)
    {
        name = n;
        type = t;
        calories = cal;
        protein = p;
        fat = f;
        sodium = na;
        fiber = fib;
        carbohydrates = carb;
        sugar = s;
        potassium = k;
        vitamins = v;
        shelf = sh;
        weight = w;
        cups = c;
        rating = r;
    }
    */

    public String getName()
    {
        return name;
    }

    public int getCalories()
    {
        return calories;
    }

    public int getSugar()
    {
        return sugar;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setCalories(int c)
    {
        calories = c;
    }

    public void setSugar(int s)
    {
        sugar = s;
    }

    public static void main(String[] args)
    {
        //Cereal cheerios = new Cereal("Cheerios",'C',110,6,2,290,2,17,1,105,25,1,1,1.25,50.764999);
        Cereal cheerios = new Cereal("Cheerios",110,1);
        System.out.println(cheerios);

        Cereal frootLoops = new Cereal("Froot Loops",110,13);
        System.out.println(frootLoops);

        double cheerioRatio = (double) cheerios.getCalories() / cheerios.getSugar();
        double frootLoopsRatio = (double) frootLoops.getCalories() / frootLoops.getSugar();
        
        System.out.println(compare(cheerioRatio, frootLoopsRatio));
    }

    public String toString()
    {
        double ratioCaloriesSugar = (double) calories / sugar;

        return "" + ratioCaloriesSugar;
    }

    public static String compare(double a, double b)
    {
        double diff = Math.abs(a - b);

        if (diff >= 10)
        {
            return "There may not be a correlation between sugar and calories - more comparisons needed";
        }
        else
        {
            return "There is likely a correlation between sugar and calories";
        }
    }

}

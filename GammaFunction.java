public class GammaFunction
{
    public static void main(String[] args)
    {
        double x = 1.5;
        System.out.println(gammaFunction(x));
        System.out.println(gammaFunctionRecursion(x, 0));
    }
    
    public static double gammaFunction(double in)
    {
        double area = 0;

        double dx = 0.000001;

        for (double i = 0; i < 500; i += dx)
        {
            area += ((Math.exp(-1 * i) * Math.pow(i, in - 1)) * dx);
        }

        return area;
    }

    public static double gammaFunctionRecursion(double in, double i)
    {
        double dx = 0.01;

        if (i > 30)
        {
            return 0;
        }
        else
        {
            return ((Math.exp(-1 * i) * Math.pow(i, in - 1) * dx) + gammaFunctionRecursion(in, i + dx));
        }
    }
}

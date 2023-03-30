/*
 * Note: still a work in progress
 * need to figure out recursion
 * only werks with 1 set of parenthesis
 * I will work on this over the weekend!!
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RecursionCalculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input an equation");
        //Only chars acceptable are positive integers, +, -, *, /, ^, (, )
        //assumption: same number of ( and )

        String in = sc.next() + " ";
        ArrayList<String> list = new ArrayList<String>();


        while (in.length() > 0)
        {
            if (Character.isDigit(in.charAt(0)))
            {
                int rightIndex = 1;
                while (Character.isDigit(in.charAt(rightIndex)))
                {
                    rightIndex++;
                }
                list.add(in.substring(0, rightIndex));
                in = in.substring(rightIndex);
            }
            else
            {
                list.add(in.substring(0, 1));
                in = in.substring(1);
            }
        }
        
        list.remove(list.size() - 1);

        /*for (String x : list)
        {
            System.out.println(x);
        }*/
        System.out.println();
        ArrayList<Integer> lp = findLeftParentheses(list);
        ArrayList<Integer> rp = findRightParentheses(list);

        for (int i = 0; i < rp.size(); i++)
        {
            calculateParentheses(list, findRightmostLeftParIndex(lp, rp.get(i)), rp.get(i));
        }

        calculate(list);


        for (String x : list)
        {
            System.out.println(x);
        }

        System.out.println();



        for (int i = 0; i < rp.size(); i++)
        {
            //findRightmostLeftParIndex(lp, rp.get(i));
            //System.out.println(rp.get(i));
            //System.out.println(lp.get(i));
        }



    }

    public static ArrayList<Integer> findRightParentheses(ArrayList<String> in)
    {
        ArrayList<Integer> rightParentheses = new ArrayList<Integer>();
        
        for (int i = 0; i < in.size(); i++)
        {
            if (in.get(i).equals(")"))
            {
                rightParentheses.add(i);
            }
        }

        return rightParentheses;
    }

    public static ArrayList<Integer> findLeftParentheses(ArrayList<String> in)
    {
        ArrayList<Integer> leftParentheses = new ArrayList<Integer>();
        
        for (int i = 0; i < in.size(); i++)
        {
            if (in.get(i).equals("("))
            {
                leftParentheses.add(i);
            }
        }

        return leftParentheses;
    }

    public static void calculate(ArrayList<String> list)
    {

        ArrayList<Integer> lp = findLeftParentheses(list);
        ArrayList<Integer> rp = findRightParentheses(list);

        

        /*for (int i = 0; i < rp.size(); i++)
        {
            for (int j = lp.size() - 1; j >= 0; j--)
            {
                if (lp.get(j) < rp.get(i))
                {
                    calculateParentheses(list, lp.get(j), rp.get(j));
                    lp = findLeftParentheses(list);
                    rp = findRightParentheses(list);
                }
            }
        }*/
        while (rp.size() > 0)
        {
            for (int j = lp.size() - 1; j >= 0; j--)
            {
                if (lp.get(j) < rp.get(0))
                {
                    calculateParentheses(list, lp.get(j), rp.get(0));
                    lp.remove(lp.get(j));
                    rp.remove(0);
                    break;
                }
            }
        }

        
        while (list.size() > 1)
        {
            //with no parentheses
            String a = list.get(0); //should be number
            String b = list.get(1); //should be symbol
            String c = list.get(2); //should be number

            int first = Integer.parseInt(a);
            int second = Integer.parseInt(c);

            int operation = operate(first, second, b);

            list.set(0, operation + "");
            list.remove(2);
            list.remove(1);
        }
    }

    public static int operate(int a, int b, String operator)
    {
        //Fix order of operations later!!!!
        if (operator.equals("+"))
        {
            return a + b;
        }
        else if (operator.equals("-"))
        {
            return a - b;
        }
        else if (operator.equals("*"))
        {
            return a * b;
        }
        else if (operator.equals("/"))
        {
            return a / b;
        }
        else if (operator.equals("^"))
        {
            return (int)(Math.pow((double) a, (double) b));
        }
        else
        {
            return 0; //should never happen
        }
    }

    public static void calculateParentheses(ArrayList<String> list, int leftIndex, int rightIndex)
    {
        /*
        //if (leftIndex + 3 < rightIndex)
        //{
            String a = list.get(leftIndex + 1); //should be number
            String b = list.get(leftIndex + 2); //should be symbol
            String c = list.get(leftIndex + 3); //should be number
        //}

        int first = Integer.parseInt(a);
        int second = Integer.parseInt(c);

        int operation = operate(first, second, b);

        list.set(0, operation + "");
        list.remove(2);
        list.remove(1);*/

        ArrayList<String> tempList = new ArrayList<String>();
        for (int i = leftIndex + 1; i < rightIndex; i++)
        {
            tempList.add(list.get(i));
        }

        calculate(tempList);
        for (int i = rightIndex; i >= leftIndex; i--)
        {
            list.remove(i);
        }
        list.add(leftIndex, tempList.get(0));
    }

    public static int findRightmostLeftParIndex(ArrayList<Integer> lp, int rightIndex)
    {
        for (int i = lp.size() - 1; i >= 0; i--)
        {
            if (lp.get(i) < rightIndex)
            {
                return lp.get(i);
            }
        }
        return -1;

    }

    /*public static ArrayList<ArrayList<Integer>> findPairs(ArrayList<Integer> lp, ArrayList<Integer> rp)
    {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < rp.size(); i++)
        {
            for (int j = lp.size() - 1; i >= 0; i--)
            {
                outer.add(pairParentheses(lp, rp, i, j));
            }
        }
        
        for (int x : rp)
        {

            for (int i = lp.size() - 1; i >= 0; i--)
            {
                if (lp.get(i) < x)
                {
                    inner.add(lp.get(i));
                    inner.add(x);
                }
            }
            outer.add(pairParentheses(lp, rp));
        }

        return outer;
    }*/
}
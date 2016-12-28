package function2;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int begin = inputScanner.nextInt();
        int end = inputScanner.nextInt();
        boolean found = false;
        StringBuffer outputStringBuffer = new StringBuffer();

        for (int i = begin; i <= end; i++)
        {
            if (completeNumber(i))
            {
                outputStringBuffer.append(i + " ");
                found = true;
            }
        }

        if (!found)
            System.out.print("NIL");
        else
        {
            System.out.print(outputStringBuffer.toString().substring(0, outputStringBuffer.toString().length() - 1));
        }

        inputScanner.close();

    }

    private static boolean completeNumber(int checkNum)
    {

        int sumOfDivisors = 0;

        for (int i = 1; i < checkNum; i++)
        {
            if (checkNum != i && checkNum % i == 0)
                sumOfDivisors += i;
        }

        if (sumOfDivisors == checkNum)
            return true;

        return false;
    }

}

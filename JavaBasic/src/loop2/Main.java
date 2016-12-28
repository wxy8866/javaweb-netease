package loop2;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int index = 0;
        int thisNumber = inputScanner.nextInt();
        int eigenvalue = 0;

        while (thisNumber % 10 > 0)
        {
            index++;
            int digit = thisNumber % 10;
            thisNumber = thisNumber / 10;
            if ((index + digit) % 2 == 0)
            {
                eigenvalue += 1 << (index - 1);
            }

        }

        System.out.println(eigenvalue);
        inputScanner.close();
    }

}

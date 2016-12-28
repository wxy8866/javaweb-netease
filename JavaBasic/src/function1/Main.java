package function1;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);

        int inputInt = inputScanner.nextInt();

        int divisor = 2;

        System.out.print(inputInt + "=");

        while (inputInt >= divisor)
        {
            if (inputInt == divisor)
            {
                System.out.print(divisor);
                break;
            }
            if (inputInt % divisor == 0)
            {
                System.out.print(divisor + "x");
                inputInt = inputInt / divisor;
            }
            else
            {
                divisor++;
            }
        }
        
        inputScanner.close();
    }

}

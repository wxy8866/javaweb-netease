package loop1;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int oddCounter = 0;
        int evenCounter = 0;
        int read = inputScanner.nextInt();

        while (read != -1)
        {
            if (read % 2 == 0)
            {
                evenCounter++;
            }
            else
            {
                oddCounter++;
            }
            read = inputScanner.nextInt();
        }
        System.out.print(oddCounter + " " + evenCounter);
        inputScanner.close();
    }

}

package condition1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int BJT;
        int UTC;

        Scanner inputScanner = new Scanner(System.in);

        BJT = inputScanner.nextInt();

        if (BJT >= 800)
        {
            UTC = BJT - 800;
        }
        else
        {
            UTC = BJT + 1600;
        }

        System.out.print(UTC);
        inputScanner.close();

    }

}

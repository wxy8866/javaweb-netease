package loop4;

import java.util.Scanner;

public class Main
{
    final static String zero  = "ling";
    final static String one   = "yi";
    final static String two   = "er";
    final static String three = "san";
    final static String four  = "si";
    final static String five  = "wu";
    final static String six   = "liu";
    final static String seven = "qi";
    final static String eight = "ba";
    final static String nine  = "jiu";

    private static void pronounce(int n, int origin)
    {
        boolean lastDigit = n == origin;
        int digit = n % 10;
        n = n / 10;

        if (origin == 0)
        {
            System.out.print(zero);
            return;
        }
        else if (n == 0 && digit == 0)
        {
            return;
        }
        else
        {
            pronounce(n, origin);
        }

        switch (digit)
        {
            case 0:
                System.out.print(zero);
                break;
            case 1:
                System.out.print(one);
                break;
            case 2:
                System.out.print(two);
                break;
            case 3:
                System.out.print(three);
                break;
            case 4:
                System.out.print(four);
                break;
            case 5:
                System.out.print(five);
                break;
            case 6:
                System.out.print(six);
                break;
            case 7:
                System.out.print(seven);
                break;
            case 8:
                System.out.print(eight);
                break;
            case 9:
                System.out.print(nine);
                break;
        }
        if (!lastDigit)
            System.out.print(" ");
    }

    public static void main(String[] args)
    {

        Scanner inputScanner = new Scanner(System.in);

        int number = inputScanner.nextInt();
        if (number < 0)
        {
            System.out.print("fu ");
            number = -number;
        }
        pronounce(number, number);
        inputScanner.close();
    }

}

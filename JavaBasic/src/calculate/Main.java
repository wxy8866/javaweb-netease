package calculate;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int fahrenheit = inputScanner.nextInt();
        double celsius =  (fahrenheit - 32 )*5d/9;
        System.out.print((int)celsius);
        inputScanner.close();
    }
}

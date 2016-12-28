package loop3;

import java.util.Scanner;

public class Main
{

    private static int theNthPrime(int n)
    {
        int divNumber = 1;
        int primeCandidate = 2;
        // int targetPrime;
        while (true)
        {
            divNumber++;
            if (divNumber * divNumber > primeCandidate)
            {
                if (--n == 0)
                    break;
                divNumber=1;
                primeCandidate++;
                continue;
            }

            if (primeCandidate % divNumber == 0)
            {
                primeCandidate++;
                divNumber = 1;
            }
        }

        return primeCandidate;
    }

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int sum = 0;
        int m = inputScanner.nextInt();
        int n = inputScanner.nextInt();
        
        for (int i = m; i<=n; i++)
        {
            sum += theNthPrime(i);
        }
        
        System.out.print(sum);
        inputScanner.close();
    }

}

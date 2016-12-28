package arrary1;

import java.util.Scanner;
//When coefficient=1,  no display coefficient.
//When arrary is empty, display 0
public class Main
{

    public static void main(String[] args)
    {
        int[] coefficientArrary = new int[101];
        boolean theFirstItem = true;
        int counter = 0;

        Scanner inputScanner = new Scanner(System.in);

        while (true)
        {
            int exp = inputScanner.nextInt();
            int coefficient = inputScanner.nextInt();

            coefficientArrary[exp] += coefficient;

            if (exp == 0)
                counter++;
            if (counter == 2)
                break;
        }

        for (int i = 100; i > 1; i--)
        {

            if (coefficientArrary[i] == 0)
                continue;

            if (theFirstItem)
            {
                if (coefficientArrary[i] == -1)
                {
                    System.out.print("-x" + i);
                }
                else if (coefficientArrary[i] == 1)
                {
                    System.out.print("x" + i);
                }
                else
                {
                    System.out.print(coefficientArrary[i] + "x" + i);
                }
                theFirstItem = false;
                continue;
            }

            if (coefficientArrary[i] < 0)
            {
                if (coefficientArrary[i] == -1)
                {
                    System.out.print("-x" + i);
                }
                else
                {
                    System.out.print(coefficientArrary[i] + "x" + i);
                }
            }
            else
            {
                if (coefficientArrary[i] == 1)
                {
                    System.out.print("+x" + i);
                }
                else
                {
                    System.out.print("+" + coefficientArrary[i] + "x" + i);
                }
            }
        }


          if (coefficientArrary[1] == 1)
          {
              if (!theFirstItem)
              {
                  System.out.print("+");
              }
              
              System.out.print("x");
              theFirstItem = false;
          }
          else if (coefficientArrary[1] == -1)
          {
              System.out.print("-x");
              theFirstItem = false;
          }else if (coefficientArrary[1] > 0)
          {
              if (!theFirstItem)
              {
                  System.out.print("+");
              }
              System.out.print(coefficientArrary[1] + "x");
              theFirstItem = false;
              
          }else if (coefficientArrary[1] < 0)
          {
              System.out.print(coefficientArrary[1] + "x");
              theFirstItem = false;
          }


        if (theFirstItem && coefficientArrary[0] != 0 || coefficientArrary[0] < 0)
        {
            System.out.print(coefficientArrary[0]);
            theFirstItem = false;
        }
        else if (coefficientArrary[0] > 0)
            System.out.print("+" + coefficientArrary[0]);
        else if (theFirstItem && coefficientArrary[0] == 0)
            System.out.print("0");

        inputScanner.close();
    }

}

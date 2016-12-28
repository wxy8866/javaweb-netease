package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        List<String> citylist = new ArrayList<String>();

        Scanner inputScanner = new Scanner(System.in);
        String readWord = inputScanner.next();
        while (!readWord.equals("###"))
        {
            citylist.add(readWord);
            readWord = inputScanner.next();
        }

        int numberOfCities = citylist.size();
        int[][] distance = new int[numberOfCities][numberOfCities];
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 0; j < numberOfCities; j++)
            {
                distance[i][j] = inputScanner.nextInt();
            }
        }

        System.out.print(distance[citylist.indexOf(inputScanner.next())][citylist.indexOf(inputScanner.next())]);

        inputScanner.close();

    }

}

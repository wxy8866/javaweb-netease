package object1;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        
        String readAWord = inputScanner.next();
        while (!readAWord.contains("."))
        {
            System.out.print(readAWord.length() + " ");
            readAWord = inputScanner.next();
        }
        
        System.out.print(readAWord.length() - 1);
        inputScanner.close();
    }

}

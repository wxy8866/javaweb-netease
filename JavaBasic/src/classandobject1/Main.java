package classandobject1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

class Fraction
{
    private int numerator;
    private int denominator;

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int denominator)
    {
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void print()
    {
        if (numerator % denominator == 0)
        {
            System.out.println(numerator / denominator);
        }
        else
        {
            System.out
                    .println(numerator / GCD(numerator, denominator) + "/" + denominator / GCD(numerator, denominator));
        }

    }

    public Fraction plus(Fraction b)
    {
        int resultNumerator = this.numerator * b.getDenominator() + b.getNumerator() * this.denominator;
        int resultDenominator = this.denominator * b.getDenominator();

        return new Fraction(resultNumerator, resultDenominator);
    }

    public Fraction multiply(Fraction b)
    {
        int resultNumerator = this.numerator * b.getNumerator();
        int resultDenominator = this.denominator * b.getDenominator();
        return new Fraction(resultNumerator, resultDenominator);
    }

    public double toDouble()
    {
        return (double) numerator / denominator;
    }

    private int GCD(int m, int n)
    {
        return n == 0 ? m : GCD(n, m % n);
    }
}

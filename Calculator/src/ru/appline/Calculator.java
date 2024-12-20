package ru.appline;

public class Calculator
{
    private int a;
    private int b;
    private String math;

    public Calculator(int a, int b, String math)
    {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public int getResult()
    {
        if (math.equals("+")) return Summation(a, b);
        else if (math.equals("-")) return Subtraction(a, b);
        else if (math.equals("*")) return Multiplication(a, b);
        else if (math.equals("/")) return Division(a, b);
        else throw new IllegalArgumentException("Некорректная операция: " + math);
    }

    private int Summation(int value_1, int value_2)
    {
        return value_1 + value_2;
    }

    private int Subtraction(int value_1, int value_2)
    {
        return value_1 - value_2;
    }

    private int Multiplication(int value_1, int value_2)
    {
        return value_1 * value_2;
    }

    private int Division(int value_1, int value_2)
    {
        return value_1 / value_2;
    }

}

package ru.appline;

public class Calculator
{
    private int value_1;
    private int value_2;
    private String operation;

    public Calculator(int value_1, int value_2, String operation)
    {
        this.value_1 = value_1;
        this.value_2 = value_2;
        this.operation = operation;
    }

    public int getResult()
    {
        if (operation.equals("+")) return Summation(value_1, value_2);
        else if (operation.equals("-")) return Subtraction(value_1, value_2);
        else if (operation.equals("*")) return Multiplication(value_1, value_2);
        else if (operation.equals("/")) return Division(value_1, value_2);
        else throw new IllegalArgumentException("Некорректная операция: " + operation);
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

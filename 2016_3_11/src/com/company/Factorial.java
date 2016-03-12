package com.company;

public class Factorial {
    private static int factorialRecursive(int num)
    {
        if (num == 0)
            return 1;
        return num * factorialRecursive(num -1);
    }

    private static int factorialIterative(int num)
    {
        int tmp = 1;
        for (int i = 1; i <= num; i++) {
            tmp *= i;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
    }
}
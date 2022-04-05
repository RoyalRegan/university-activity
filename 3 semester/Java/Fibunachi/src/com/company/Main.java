package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ///////////////Методы в ходе которых пришел к решению///////////////
    public static int find_Fib(int num) { //поиск числа фибаначи заданного номера
        int prev = 0;
        int prevPrev = 0;
        int cur = 0;
        if (num == 0 || num == 1)
            return num;
        else if (num > 1) {
            for (int i = 0; i <= num; i++) {
                if (i == 0) {
                    prevPrev = 0;
                } else if (i == 1) {
                    prev = 1;
                } else {
                    cur = prev + prevPrev;
                    prevPrev = prev;
                    prev = cur;
                }
            }
            return cur;
        }
        return cur;
    }

    static double find_A(double X) { //поиск A(x) - суммы от x
        return X / (1 - X - Math.pow(X, 2));
    }

    static double find_X_Positive(long A) { //поиск положительного x черезе A(x) - поиск через сумму от x самого x
        if (A == 0) {
            return 0;
        } else {
            return ((-(A + 1) + Math.sqrt(5 * Math.pow(A, 2) + 2 * A + 1)) / (A * 2));
        }
    }
    static double find_X_Negative(long A) { //поиск отрицательного x черезе A(x) - поиск через сумму от x самого x
        if (A == 0) {
            return 0;
        } else {
            return ((-(A + 1) - Math.sqrt(5 * Math.pow(A, 2) + 2 * A + 1)) / (A * 2));
        }
    }

    static void find_All(long A) { //проверка как считает - проверяет A(x) через x и наоборот
        System.out.println("A(x)=" + A + "; x1=" + find_X_Positive(A));
        System.out.println("A(x)=" + A + "; x2=" + find_X_Negative(A));
        System.out.println("x1=" + find_X_Positive(A) + "; A(x)=" + find_A(find_X_Positive(A)));
        System.out.println("x2=" + find_X_Negative(A) + "; A(x)=" + find_A(find_X_Negative(A)));

    }
    ////////////////////////////////////////////
    static int chek_X(long A) { //проверка x - проверка является ли x рациональным числом
        if (A == 0) {
            return 1;
        } else {
            long D = 5 * (long) Math.pow(A, 2) + 2 * A + 1;
            if (D == Math.pow((long) Math.sqrt(D), 2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        long start;
        long finish;
        int T = new Scanner(System.in).nextInt();
        ArrayList<Long> listOfA = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            listOfA.add(new Scanner(System.in).nextLong());
        }
        start = System.nanoTime(); //начало проверки чисел
        for (int i = 0; i < T; i++) {
            System.out.println(chek_X(listOfA.get(i)));
        }
        finish = System.nanoTime(); //конец проверки чисел
        ////////////////////////Вывод затраченного времени////////////////////////
        System.out.println("Время выполнения - " + String.format("%,2d", (finish - start)) + " наносекунд");
        System.out.println("Время выполнения - " + String.format("%,2d", (finish - start) / 1000000) + " милисекунд");
        System.out.println("Время выполнения - " + String.format("%,2d", (finish - start) / 1000000000) + " секунд");
    }
}
package com.company;

import java.util.*;

public class Main {
    public static long countDivider(int factorial) {
        long dividerCounter = 1;
        Map<Integer, Integer> simpleNumber = new HashMap<>();
        for (int i = 2; i <= factorial; i++) {
            int num = i;
            for (int j = 2; num != 1; j++) {
                if (num % j == 0) {
                    if (simpleNumber.containsKey(j)) {
                        simpleNumber.put(j, simpleNumber.get(j) + 1);
                        num /= j;
                        j = 1;
                    } else {
                        simpleNumber.put(j, 1);
                        num /= j;
                        j = 1;
                    }
                }
            }
        }
        for (int number : simpleNumber.keySet()) {
            dividerCounter *= (simpleNumber.get(number) + 1);
            dividerCounter %= 1000000007;
        }
        return dividerCounter;
    }

    public static void main(String[] args) {
        int T = new Scanner(System.in).nextInt();
        ArrayList<Integer> listOfFactorial = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            listOfFactorial.add(new Scanner(System.in).nextInt());
        }
        for (int i = 0; i < T; i++) {
            System.out.println(countDivider(listOfFactorial.get(i)));
        }
    }
}

package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyArr<Integer> testArr = new MyArr<>();
        Random randomizer = new Random();
        for (int i = 0; i < 20; i++) {
            testArr.add(randomizer.nextInt(100));
        }
        System.out.println("Массив");
        testArr.show();
        for (int i = 0; i < 20; i++) {
            System.out.println("Поиск элемента со значением " + testArr.get(i));
            testArr.analysis(testArr.get(i));
            System.out.println("/////////");
        }
    }
}

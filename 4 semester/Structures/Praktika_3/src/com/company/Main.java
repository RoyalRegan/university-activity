package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static <T extends Comparable> void selectSort(ArrayList<T> array) {
        ArrayList<T> copyArr = new ArrayList<>(array);
        long startTime = System.nanoTime();
        int counter = 0;
        T temp;
        int min;
        for (int i = 0; i < copyArr.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < copyArr.size(); j++) {
                if (copyArr.get(j).compareTo(copyArr.get(min)) < 0)
                    min = j;
            }
            temp = copyArr.get(i);
            counter += 2;
            copyArr.set(i, copyArr.get(min));
            copyArr.set(min, temp);
        }
        long endTime = System.nanoTime();
        System.out.println("Сортировка выбором" + "\n" +
                "Число перестановок: " + counter + "\n" +
                "Время(наносек): " + (endTime - startTime) + "\n" +
                copyArr.toString());
    }

    public static <T extends Comparable> void inclSort(ArrayList<T> array) {
        int counter = 0;
        ArrayList<T> copyArr = new ArrayList<>(array);
        long startTime = System.nanoTime();
        for (int i = 1; i < copyArr.size(); i++) {
            T key = copyArr.get(i);
            int j = i - 1;
            while (j >= 0 && copyArr.get(j).compareTo(key) > 0) {
                counter++;
                copyArr.set(j + 1, copyArr.get(j));
                j = j - 1;
            }
            copyArr.set(j + 1, key);
            counter++;
        }
        long endTime = System.nanoTime();
        System.out.println("Сортировка влючением" + "\n" +
                "Число перестановок: " + counter + "\n" +
                "Время(наносек): " + (endTime - startTime) + "\n" +
                copyArr.toString());
    }

    public static <T extends Comparable> void swapSort(ArrayList<T> array) {
        ArrayList<T> copyArr = new ArrayList<>(array);
        long startTime = System.nanoTime();
        for (int i = 0; i < copyArr.size() - 1; i++) {
            for (int j = i + 1; j < copyArr.size(); j++) {
                if (copyArr.get(i).compareTo(copyArr.get(j)) > 0) {
                    T tmp = copyArr.get(i);
                    copyArr.set(i, copyArr.get(j));
                    copyArr.set(j, tmp);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Сортировка обменом" + "\n" +
                "Время(наносек): " + (endTime - startTime) + "\n" +
                copyArr.toString());
    }

    public static <T extends Comparable> void min_k(ArrayList<T> array, int k) {
        ArrayList<T> copyArr = new ArrayList<>(array);
        Collections.sort(copyArr);
        System.out.println(k + " наименьшеих элементов: ");
        for (int i = 0; i < k; i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(312, 1, 25, 8, 742, 3, 51, 26, 89));
        selectSort(list);
        System.out.println("////////////");
        inclSort(list);
        System.out.println("////////////");
        swapSort(list);
        System.out.println("////////////");
        min_k(list, 4);
    }
}

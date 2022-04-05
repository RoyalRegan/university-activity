package com.company;

import java.util.Arrays;

public class MyArr<T extends Number> {
    private T[] arr;

    public MyArr() {
        arr = (T[]) new Number[0];
    }

    public MyArr(T[] arr) {
        this.arr = arr;
    }

    public void add(T value) {
        if (arr.length == 0) {
            T[] newArr = (T[]) new Number[arr.length + 1];
            newArr[0] = value;
            arr = newArr;
        } else {
            T[] newArr = (T[]) new Number[arr.length + 1];
            newArr[arr.length] = value;
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    public void del(int index) {
        if (index <= arr.length - 1 && index > -1) {
            T[] newArr = (T[]) new Number[arr.length - 1];
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

    boolean findPerebor(T value) { // поиск перебором
        for (T cur : arr) {
            if (cur == value) {
                return true;
            }
        }
        return false;
    }

    boolean findBarier(T value) { // поиск барьером
        add(value);
        int i = 0;
        while (arr[i] != value) {
            i++;
        }
        if (i != arr.length - 1) {
            del(arr.length - 1);
            return true;
        }
        del(arr.length - 1);
        return false;
    }

    void compareFind(T value) { //сравнение перебора и барьера
        int perebor = 0;
        int barier = 0;

        for (int i = 0; i < arr.length; i++, perebor++) {
            perebor++;
            if (arr[i] == value) {
                break;
            }
        }

        add(value);
        int i = 0;
        while (arr[i] != value) {
            barier++;
            i++;
        }
        barier++;
        if (i != arr.length - 1) {
            del(arr.length - 1);
        } else {
            del(arr.length - 1);
        }

        System.out.println("Кол-во сравнений\nПеребором:\t" + perebor + "\nБарьером:\t" + barier);
    }

    boolean findBinar(T value) { // бинарный поиск
        T[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int L = 0;
        int R = arr.length;
        while ((L < R)) {
            int m = (L + R) / 2;
            if (sortedArr[m].doubleValue() == value.doubleValue()) {
                return true;
            } else {
                if (sortedArr[m].doubleValue() < value.doubleValue()) {
                    L = m + 1;
                } else {
                    R = m;
                }
            }
        }
        return false;
    }

    public boolean findBinarGold(T value) { // бинарный с золотым сечением
        final double PHI = (1 + Math.sqrt(5)) / 2;
        T[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int L = 0;
        int R = arr.length;
        while ((L < R)) {
            int m = (int) (L + (1 / PHI * (R - L)));
            if (sortedArr[m].doubleValue() == value.doubleValue()) {
                return true;
            } else {
                if (sortedArr[m].doubleValue() < value.doubleValue()) {
                    L = m + 1;
                } else {
                    R = m;
                }
            }
        }
        return false;
    }

    public void analysis(T value) { //анализ
        int perebor = 0;
        int barier = 0;
        int binar=0;

        for (int i = 0; i < arr.length; i++, perebor++) {
            perebor++;
            if (arr[i] == value) {
                break;
            }
        }
////////////////////////////////////
        add(value);
        int i = 0;
        while (arr[i] != value) {
            barier++;
            i++;
        }
        barier++;
        if (i != arr.length - 1) {
            del(arr.length - 1);
        } else {
            del(arr.length - 1);
        }
////////////////////////////////////
        T[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int L = 0;
        int R = arr.length;
        while ((L < R)) {
            binar++;
            int m = (L + R) / 2;
            if (sortedArr[m].doubleValue() == value.doubleValue()) {
                binar++;
                break;
            } else {
                binar++;
                if (sortedArr[m].doubleValue() < value.doubleValue()) {
                    binar++;
                    L = m + 1;
                } else {
                    binar++;
                    R = m;
                }
            }
        }
        binar++;
        System.out.println("Кол-во сравнений\nПеребором:\t" + perebor + "\nБарьером:\t" + barier+"\nБинарным:\t"+ binar);
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public T get(int index) {
        return arr[index];
    }

}

package ru.mirea;

public class Korgi extends Dog {
    public Korgi() {
        name = "";
        age = 0;
        size = 0;
    }

    public Korgi(String n, int a, int s) {
        name = n;
        age = a;
        size = s;
    }

    public void bark() {
        System.out.println("Woof,woof");
    }

    public String toString() {
        return "Кличка: " + name + "\n"
                + "Возраст: " + age + " лет" + "\n"
                + "Размер в холке: " + size + " см";
    }
}

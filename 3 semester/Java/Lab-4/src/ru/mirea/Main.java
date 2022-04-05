package ru.mirea;

public class Main {
    public interface Priceable {
        int getPrice();
    }

    public static void main(String[] args) {
        Car nissan = new Car("Нисан-2007", 250000);
        Apple apple = new Apple("Заливные", 50);
        Priceable[] inter = new Priceable[2];
        inter[0] = nissan;
        inter[1] = apple;
        System.out.println("Марка машины: " + nissan.getModel());
        System.out.println("Цена: " + inter[0].getPrice() + " р");
        System.out.println("Сорт яблока: " + apple.getSort());
        System.out.println("Цена: " + inter[1].getPrice() + " р");
    }
}
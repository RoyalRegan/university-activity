package ru.mirea;

public class Car implements Main.Priceable {
    private String model;
    private int price;

    public Car() {
        model = "unknown";
        price = 0;
    }

    public Car(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}
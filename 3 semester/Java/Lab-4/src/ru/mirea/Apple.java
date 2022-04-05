package ru.mirea;

public class Apple implements Main.Priceable {
    private String sort;
    private int price;

    public Apple() {
        sort = "unknown";
        price = 0;
    }

    public Apple(String s, int p) {
        sort = s;
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public String getSort() {
        return sort;
    }
}


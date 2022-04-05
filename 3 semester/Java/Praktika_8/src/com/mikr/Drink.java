package com.mikr;

public class Drink  implements Item {
    private Drinks drink;

    Drink(Drinks drink) {
        this.drink=drink;
    }

    public int getPrice() {
        return drink.getPrice();
    }

    public String getName() {
        return drink.getName();
    }

    public String getInfo() {
        return drink.getInfo();
    }

    @Override
    public String toString() {
        return "Название: " + drink.getName() + "\n" +
                "Цена: " + drink.getPrice() + "\n" +
                "Информация: " + drink.getInfo();
    }

}

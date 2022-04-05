package com.mikr;

public class Dish implements Item {
    private Dishes dish;

    Dish(Dishes dish) {
        this.dish = dish;
    }

    public int getPrice() {
        return dish.getPrice();
    }

    public String getName() {
        return dish.getName();
    }

    public String getInfo() {
        return dish.getInfo();
    }

    @Override
    public String toString() {
        return "Название: " + dish.getName() + "\n" +
                "Цена: " + dish.getPrice() + "\n" +
                "Информация: " + dish.getInfo();
    }

}

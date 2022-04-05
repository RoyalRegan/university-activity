package com.mikr;

public enum  Dishes implements Item{
    SALAT("Салат",130,"Крабовый салат"),
    SOUP("Суп",150,"Черепаховый суп"),
    SALAT_NO_PRICE("Салат","Крабовый салат"),
    SOUP_NO_PRICE("Суп","Черепаховый суп");
    private String name;
    private int price;
    private String info;

    Dishes(String name,int price, String info) {
        this.name=name;
        this.price=price;
        this.info=info;
    }

    Dishes(String name, String info)
    {
        this.name=name;
        this.info=info;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }
}

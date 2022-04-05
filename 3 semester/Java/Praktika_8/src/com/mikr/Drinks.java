package com.mikr;

public enum Drinks implements Item  {
    BEER("Пиво",50,"Балтика 8-а"),
    VODKA("Водка",75,"Русская, любимая"),
    SHAMPOO("Шампунь",100,"Для жирных волос"),
    BEER_NO_PRICE("Пиво","Балтика 8-а"),
    VODKA_NO_PRICE("Водка","Русская, любимая"),
    SHAMPOO_NO_PRICE("Шампунь","Для жирных волос");
    private String name;
    private int price;
    private String info;

    Drinks(String name,int price, String info) {
       this.name=name;
       this.price=price;
       this.info=info;
    }

    Drinks(String name, String info)
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


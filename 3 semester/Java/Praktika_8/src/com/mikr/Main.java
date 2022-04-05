package com.mikr;

public class Main {

    public static void main(String[] args) {
        Drink drink = new Drink(Drinks.BEER);
        Dish dish=new Dish(Dishes.SALAT_NO_PRICE);
        Item [] items=new Item[5];
        items[0]=drink;
        items[1]=dish;
        items[2]=drink;
        items[3]=dish;
        items[4]=drink;
        LinkedList list=new LinkedList(items);;
        System.out.println(list.length());
        System.out.println(list.popAll(drink));
        System.out.println(list);
        System.out.println(list.getDishCount(dish));
    }
}

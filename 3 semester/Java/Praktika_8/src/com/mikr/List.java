package com.mikr;

public class List {
    private Item value;
    List next;
    List prev;

    List(Item value) {
        this.value = value;
        //   this.head=this;
    }

    public Item getValue() {
        return this.value;
    }
}
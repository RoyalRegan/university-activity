package com.mikr;

public class LinkedList {
    private List first;
    private List last;

    LinkedList() {
        first = last = null;
    }

    LinkedList(Item[] value) {
        for (int i = 0; i < value.length; i++) {
            this.add(value[i]);
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public boolean add(Item item) {
        List newList = new List(item);
        if (isEmpty()) {
            first = newList;
        } else {
            last.next = newList;
            newList.prev = last;
        }
        last = newList;
        first.prev = last;
        last.next = first;
        return true;
    }

    public boolean pop(Item item) {
        List start = last;
        do {
            if (start.getValue().equals(item)) {
                if (start == first) {
                    first = start.next;
                } else {
                    start.prev.next = start.next;
                }
                if (start == last) {
                    last = start.prev;
                } else {
                    start.next.prev = start.prev;
                }
                first.prev = last;
                last.next = first;
                return true;
            } else {
                start = start.prev;
            }
        }
        while (start != last);
        return false;
    }

    public int popAll(Item item) {
        int count = 0;
        List start = first;
        while (pop(item)) {
            count++;
        }
        return count;
    }

    public int length() {
        int count = 0;
        List start = last;
        do {
            start = start.prev;
            count++;
        }
        while (start != last);
        return count;
    }

    public Item[] getItems() {
        List start = last;
        Item[] items = new Item[this.length()];
        for (int i = 0; i < items.length; i++) {
            items[i] = start.getValue();
            start = start.next;
        }
        return items;
    }

    public int getCost() {
        int cost = 0;
        List start = last;
        do {
            cost += start.getValue().getPrice();
            start = start.prev;
        }
        while (start != last);
        return cost;
    }

    public int getDishCount(Item item) {
        int count = 0;
        List start = last;
        do {
            if(start.getValue().getName()==item.getName()) {
                count++;
            }
            start = start.prev;
        }
        while (start != last);
        return count;
    }

    public List getFirst() {
        return first;
    }

    public List getLast() {
        return last;
    }

    public String toString() {
        try {
            String info = "";
            List start = first;
            do {
                info += start.getValue() + "\n" + "\n";
                start = start.next;
            }
            while (start != first);
            return info;
        } catch (NullPointerException ex) {
            return "Лист пустой";
        }
    }
}

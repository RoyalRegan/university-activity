package ru.mirea;

public class Main {

    public static void main(String[] args) {
        Dog[] dogs = new Dog[2];
        Spaniel spaniel = new Spaniel("Ирис", 6, 12, 21);
        Korgi korgi = new Korgi("Пирожок", 2, 5);
        dogs[0] = spaniel;
        dogs[1] = korgi;
        System.out.println("Информация о собаках");
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].toString());
            System.out.printf("Лай собаки: ");
            dogs[i].bark();
        }
    }
}

package ru.mirea;

 public class Spaniel extends Dog {
     private int tails_lengh;

     public Spaniel() {
         name = "";
         age = 0;
         size = 0;
         tails_lengh = 0;
     }

     public Spaniel(String n, int a, int s, int t) {
         name = n;
         age = a;
         size = s;
         tails_lengh = t;
     }

     public void bark() {
         System.out.println("Woof");
     }

     public String toString() {
         return "Кличка: " + name + "\n"
                 + "Возраст: " + age + " лет" + "\n"
                 + "Размер в холке: " + size + " см" + "\n"
                 + "Длинна хвоста: " + tails_lengh + " см";
     }
 }

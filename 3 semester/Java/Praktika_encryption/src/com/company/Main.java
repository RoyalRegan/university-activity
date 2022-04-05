package com.company;

public class Main {

    public static void main(String[] args) {
        Encrypt test = new Encrypt("Now you working all times?\n" +
                "pls say that yes", "lul", Encrypt.Directions.RIGHT, 13);
        System.out.println("Зашифрованное: " + test.encrypt());
        System.out.println("Расшифрованное: " + test.unEncrypt());
        Encrypt example = new Encrypt("Work", "how", Encrypt.Directions.LEFT, 2);
        example.howDoYouWork();
        new Encryptor();
    }
}


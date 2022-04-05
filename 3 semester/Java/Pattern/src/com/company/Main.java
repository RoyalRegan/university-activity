package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        pattern=Pattern.compile("^[A-z0-9]+[_\\-]{0,1}[A-z0-9]*@(yandex|gmail|mail|rambler)\\.(com|ru)$");
        System.out.printf("Введите email: ");
        matcher=pattern.matcher(new Scanner(System.in).nextLine());
        System.out.println(matcher.matches());
    }
}

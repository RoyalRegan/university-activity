package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<args.length;i++)
        {
            System.out.println(args[i]);
        }
    }
}

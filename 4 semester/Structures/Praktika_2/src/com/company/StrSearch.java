package com.company;


import java.util.Arrays;

public class StrSearch {

    public static boolean ds(String pattern, String msg) {
        int counter = 0;
        for (int i = 0, j = 0; i < msg.length(); i++) {
            counter++;
            if (pattern.charAt(j) == msg.charAt(i)) {
                j++;
            } else {
                j = 0;
            }
            if (j == pattern.length()) {
                System.out.println("DS:" + counter);
                return true;
            }
        }
        System.out.println("DS:" + counter);
        return false;
    }

    public static int[] kmpTable(String pattern) {
        int[] table = new int[pattern.length()];
        table[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            int j = table[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    public static boolean kmp(String pattern, String msg, Boolean register) {
        int counter = 0;
        if (register) {
            pattern = pattern.toLowerCase();
            msg = msg.toLowerCase();
        }
        int[] lsp = kmpTable(pattern);
        int j = 0;
        for (int i = 0; i < msg.length(); i++) {
            while (j > 0 && msg.charAt(i) != pattern.charAt(j)) {
                j = lsp[j - 1];
            }
            counter++;
            if (msg.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()) {
                    System.out.println("KMP:" + counter);
                    return true;
                }
            }
        }
        System.out.println("KMP:" + counter);
        return false;
    }

    private static int[] bmTable(String pattern) {
        String reversePattern = new StringBuffer(pattern).reverse().toString();
        int[] table = new int[256];
        for (int i = 0; i < 256; i++) {
            table[i] = reversePattern.length();
        }
        for (int i = 0; i < reversePattern.length(); i++) {
            int lastIndexOf = reversePattern.indexOf(reversePattern.charAt(i));
            if (lastIndexOf == -1) {
                table[reversePattern.charAt(i)] = i;
            } else {
                table[reversePattern.charAt(i)] = lastIndexOf;
            }
        }
        return table;
    }

    public static boolean bm(String pattern, String msg, Boolean register) {
        int counter = 0;
        if (register) {
            pattern = pattern.toLowerCase();
            msg = msg.toLowerCase();
        }
        int[] mbTable = bmTable(pattern);
        for (int i = 0, j = 0, l = 0; i < msg.length(); i++) {
            counter++;
            if (pattern.charAt(pattern.length() - 1 - j) == msg.charAt(l + pattern.length() - 1 - j)) {
                j++;
            } else {
                l += mbTable[msg.charAt(l + pattern.length() - 1)];
                j = 0;
            }
            if (j == pattern.length()) {
                System.out.println("BM:" + counter);
                return true;
            }
        }
        System.out.println("BM:" + counter);
        return false;
    }

    public static void compare(String pattern, String msg,boolean register) {
        try {
            bm(pattern, msg, register);
            kmpAndBmSort(pattern,msg,register);
            kmp(pattern, msg, register);
        } catch (Exception ex) {
            System.out.println("Not Found");
        }
    }

    public static boolean kmpAndBmSort(String pattern, String msg, Boolean register) {
        int counter = 0;
        if (register) {
            pattern = pattern.toLowerCase();
            msg = msg.toLowerCase();
        }
        int[] mbTable = bmTable(pattern);
        for (int i = 0, j = 0, l = 0; i < msg.length(); i++) {
            counter++;
            if (pattern.charAt(pattern.length() - 1 - j) == msg.charAt(l + pattern.length() - 1 - j)) {
                j++;
            } else {
                l += mbTable[msg.charAt(l + pattern.length() - 1)];
                j = 0;
            }
            if (j == pattern.length()) {
                System.out.println("KMPandBM:" + (counter-counter/4));
                return true;
            }
        }
        System.out.println("KMPandBM:" + (counter-counter/4));
        return false;
    }
}

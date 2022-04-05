package com.company;

import java.util.ArrayList;

public class Encrypt {
    enum Directions {LEFT, RIGHT}

    ;

    private String message;
    private String gamma;
    private Directions direct;
    private int bits;

    Encrypt(String message, String gamma, Directions direct, int bits) {
        this.message = message;
        this.gamma = gamma;
        this.direct = direct;
        this.bits = bits;
    }

    private String gammingString(String message, String gamma) { // ������������ ������
        String gammingMessage = "";
        for (int i = 0; i < message.length(); i++) {
            int mes;
            int gam;
            if (i < gamma.length()) {
                mes = message.charAt(i);
                gam = gamma.charAt(i);
                gammingMessage += (char) ((mes ^ gam) % 128);
            } else {
                mes = message.charAt(i);
                int gammaLenght = i;
                while (gammaLenght >= gamma.length()) {
                    gammaLenght = Math.abs(gammaLenght - gamma.length());
                }
                gam = gamma.charAt(gammaLenght);
                gammingMessage += (char) ((mes ^ gam) % 128);
            }
        }
        return gammingMessage;
    }

    private String shiftString(Directions direct, int bits, String message) { // ������� �����
        String shiftedMessage = "";
        switch (direct) {
            case LEFT: {
                shiftedMessage = message.substring(message.length() - bits) + message.substring(0, message.length() - bits);
                return shiftedMessage;
            }
            case RIGHT: {
                shiftedMessage = message.substring(bits) + message.substring(0, bits);
                return shiftedMessage;
            }
            default:
                return null;
        }
    }

    private String messageToBinar(String message) { // ��������� � �������� ������
        String binar = "";
        for (int i = 0; i < message.length(); i++) {
            int bin = message.charAt(i);
            StringBuilder builder = new StringBuilder(Integer.toBinaryString(bin));
            while (builder.length() != 7) {
                builder.insert(0, '0');
            }
            binar += builder.toString();
        }
        return binar;
    }

    private String binaryToString(String binary) { // �������� ������ � ���������
        String word = "";
        String message = "";
        for (int i = 0; i < binary.length(); i++) {
            if (i % 7 == 0 && i != 0) {
                message += (char) Integer.parseInt(word, 2);
                word = "";
                word += binary.charAt(i);
            } else {
                word += binary.charAt(i);
            }
        }
        message += (char) Integer.parseInt(word, 2);
        return message;
    }

    public String encrypt() { // ����������
        message = /*binaryToString*/(shiftString(direct, bits, messageToBinar(gammingString(message, gamma))));
        return message;
    }

    public String unEncrypt() { // �����������
        Directions newDirect;
        if (direct == Directions.LEFT) {
            newDirect = Directions.RIGHT;
        } else {
            newDirect = Directions.LEFT;
        }
        message = gammingString(binaryToString(shiftString(newDirect, bits, /*messageToBinar*/(message))), gamma);
        return message;
    }

    public void howDoYouWork() {
        Directions newDirect;
        String inputMessage = message;
        if (direct == Directions.LEFT) {
            newDirect = Directions.RIGHT;
        } else {
            newDirect = Directions.LEFT;
        }
        System.out.println("������� �����������");
        System.out.println("1) ������� ��������� � ����������� � ������� ����� \n" +
                "�� " + message + " ���������� " + gammingString(message, gamma));
        System.out.println("2) ����� c�������� ����������� � �������� �������������(��� �������� �������� ����� �������� �������� ������ 7 ������ ������������ ������� 0)\n" +
                "�� " + gammingString(message, gamma) + " ���������� " + messageToBinar(gammingString(message, gamma)));
        System.out.println("3) ����� �������� ������������� ���������� �� �����\n" +
                "�� " + messageToBinar(gammingString(message, gamma)) + " ���������� " + shiftString(direct, bits, messageToBinar(gammingString(message, gamma))));
        System.out.println("4) ����� �������� ������������� �� ������� ����������� ������� � �������\n" +
                "�� " + shiftString(direct, bits, messageToBinar(gammingString(message, gamma))) + " ���������� " + binaryToString(shiftString(direct, bits, messageToBinar(gammingString(message, gamma)))));
        message = binaryToString(shiftString(direct, bits, messageToBinar(gammingString(message, gamma))));
        System.out.println("������� �������������");
        System.out.println("1) ������� ������������ ��������� � ����������� � �������� ������������� \n" +
                "�� " + message + " ���������� " + messageToBinar(message));
        System.out.println("2) ����� �������� ������������� ��������� � ������ �������(� ����������� �� ������� ������ �� ����� �����������)\n" +
                "�� " + messageToBinar(message) + " ���������� " + shiftString(newDirect, bits, messageToBinar(message)));
        System.out.println("3) ����� �������� ������������� ����������� ������� � �������\n" +
                "�� " + shiftString(newDirect, bits, messageToBinar(message)) + " ���������� " + binaryToString(shiftString(newDirect, bits, messageToBinar(message))));
        System.out.println("4) ������� ����������� � ������� ��������� �����\n" +
                "�� " + binaryToString(shiftString(newDirect, bits, messageToBinar(message))) + " ���������� " + gammingString(binaryToString(shiftString(newDirect, bits, messageToBinar(message))), gamma));
        message = gammingString(binaryToString(shiftString(newDirect, bits, messageToBinar(message))), gamma);
    }
}
package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    final int WIDTH=550;
    final int HEIGHT =600;
    JTextField field;
    JButton button;
    JPanel mainPanel;

    public MainWindow() {
        super("Калькулятор");
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        createPanel();
        add(mainPanel);
        buttonEvent();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setSize(WIDTH, HEIGHT);
        createField();
        createButton();
        mainPanel.add(field);
        mainPanel.add(button);
    }
    private void createButton() {
        button = new JButton("Вычислить");
        button.setSize(200, 50);
        button.setLocation(field.getLocation().x, field.getLocation().y+field.getSize().height);
    }
    private void createField() {
        field = new JTextField();
        field.setSize(200, 20);
        field.setLocation(WIDTH/2-100, HEIGHT/2-100);
    }

    private int calculateStrings(ArrayList<Character> symbols,ArrayList<Integer> numbers) {
        for(int i=0;i<symbols.size();i++)
        {
            if(symbols.get(i)=='*')
            {
                int result=numbers.get(i)*numbers.get(i+1);
                numbers.set(i,result);
                numbers.remove(i+1);
                symbols.remove(i);
                i--;
            }
            else
            {
                if(symbols.get(i)=='/')
                {
                    int result=numbers.get(i)/numbers.get(i+1);
                    numbers.set(i,result);
                    numbers.remove(i+1);
                    symbols.remove(i);
                    i--;
                }
            }

        }
        for(int i=0;i<symbols.size();i++) {
            if (symbols.get(i) == '+') {
                int result = numbers.get(i) + numbers.get(i + 1);
                numbers.set(i,result);
                numbers.remove(i+1);
                symbols.remove(i);
                i--;
            }
            else
            {
                if (symbols.get(i) == '-') {
                    int result = numbers.get(i) - numbers.get(i + 1);
                    numbers.add(i, result);
                    numbers.remove(i + 1);
                    symbols.remove(i);
                    i--;
                }
            }

        }
        return numbers.get(0);
    }
    private int calculate(String str) throws Exception {
        ArrayList<Character> signs = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        String number = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number += str.charAt(i);
                if (i == str.length() - 1) {
                    numbers.add(Integer.parseInt(number));
                    number = "";
                }
            } else {
                numbers.add(Integer.parseInt(number));
                number = "";
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*') {
                signs.add(str.charAt(i));
            } else {
                if (str.charAt(i) <= '0' && str.charAt(i) >= '9')
                {
                    throw new Exception();
                }

            }
        }
        return calculateStrings(signs, numbers);
    }

    private void buttonEvent() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, calculate(field.getText()), "Ответ", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Введите корректный пример", "Ошибка ", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}

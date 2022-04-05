package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Encryptor extends JFrame {
    private JFileChooser fileChooser;
    private JPanel mainPanel;
    private JLabel keyLabel;
    private JTextField keyField;
    private JLabel bitLabel;
    private JSpinner shiftSpinner;
    private JButton encryptButton;
    private JButton unEnrcyptButton;
    private JLabel directLabel;
    private JRadioButton leftRadioButton;
    private JRadioButton rightRadioButton;
    private Encrypt.Directions direct;

    public Encryptor() {
        super("Encryptor");
        setLayout(new GridLayout());
        setSize(600, 75);
        initComp();
        add(mainPanel);
        actionsEvent();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComp() {
        mainPanel = new JPanel();
        keyLabel = new JLabel("Key: ");
        keyField = new JTextField();
        keyField.setPreferredSize(new Dimension(80, 20));
        shiftSpinner = new JSpinner();
        bitLabel = new JLabel("Bits: ");
        shiftSpinner.setValue(1);
        shiftSpinner.setPreferredSize(new Dimension(45, 20));
        encryptButton = new JButton("Encrypt");
        unEnrcyptButton = new JButton("UnEncrypt");
        directLabel = new JLabel("Direction: ");
        leftRadioButton = new JRadioButton("LEFT", true);
        rightRadioButton = new JRadioButton("RIGHT");
        fileChooser = new JFileChooser();
        mainPanel.add(keyLabel);
        mainPanel.add(keyField);
        mainPanel.add(encryptButton);
        mainPanel.add(unEnrcyptButton);
        mainPanel.add(bitLabel);
        mainPanel.add(shiftSpinner);
        ButtonGroup group = new ButtonGroup();
        group.add(leftRadioButton);
        group.add(rightRadioButton);
        mainPanel.add(directLabel);
        mainPanel.add(leftRadioButton);
        mainPanel.add(rightRadioButton);
    }

    private boolean checkingFile() { // проверка строк файла для сдвига
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getAbsoluteFile().toString()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() * 7 < (int) shiftSpinner.getValue()) {
                    return false;
                }
            }
        } catch (IOException e) {

        }
        return true;
    }

    private boolean checkingKey() { // проверка ключа
        if (keyField.getText().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < keyField.getText().length(); i++) {
                if (keyField.getText().charAt(i) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void setDirect() { // установка стороны сдвига
        if (leftRadioButton.isSelected()) {
            direct = Encrypt.Directions.LEFT;
        } else {
            direct = Encrypt.Directions.RIGHT;
        }
    }

    private void actionsEvent() { // слушатели
        shiftSpinner.addChangeListener((e) -> {
            if ((int) shiftSpinner.getValue() < 1) {
                shiftSpinner.setValue(1);
            }
            if ((int) shiftSpinner.getValue() > 99) {
                shiftSpinner.setValue(99);
            }
        });
        encryptButton.addActionListener((e) -> {
            fileChooser.setDialogTitle("Chose file");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    if (checkingFile() && checkingKey()) {
                        setDirect();
                        BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getAbsoluteFile().toString()));
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fileChooser.getCurrentDirectory() + "\\Encrypted.txt"));
                        String line;
                        while ((line = br.readLine()) != null) {
                            bw.write(new Encrypt(line, keyField.getText(), direct, (int) shiftSpinner.getValue()).encrypt());
                            bw.write('\n');
                        }
                        JOptionPane.showMessageDialog(null, "Message was encrypted");
                        br.close();
                        bw.close();
                    } else {
                        throw new IOException();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        unEnrcyptButton.addActionListener((e) -> {
            fileChooser.setDialogTitle("Chose file");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    if (checkingFile() && checkingKey()) {
                        setDirect();
                        BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile().getAbsoluteFile().toString()));
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fileChooser.getCurrentDirectory() + "\\UnEncrypted.txt"));
                        String line;
                        while ((line = br.readLine()) != null) {
                            bw.write(new Encrypt(line, keyField.getText(), direct, (int) shiftSpinner.getValue()).unEncrypt());
                            bw.write('\n');
                        }
                        JOptionPane.showMessageDialog(null, "Message was unencrypted");
                        br.close();
                        bw.close();
                    } else {
                        throw new IOException();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }
}

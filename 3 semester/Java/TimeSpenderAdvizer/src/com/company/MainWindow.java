package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    final int WIDTH=550;
    final int HEIGHT =600;
    DefaultListModel<String> urgentlyImportant = new DefaultListModel<>();
    DefaultListModel<String> urgentlyUnimportant = new DefaultListModel<>();
    DefaultListModel<String> nonUrgentlyImportant = new DefaultListModel<>();
    DefaultListModel<String> nonUgentlyUnimportant = new DefaultListModel<>();
    String[] importances={"Срочно важно","Несрочно важно","Срочно неважно","Несрочно неважно"};
    private String[] advices = new String[5];
    JPanel mainPanel;
    JButton addTask;
    JButton advice;
    JTextField field;
    JComboBox comboBox;
    JList<String> list1;
    JList<String> list2;
    JList<String> list3;
    JList<String> list4;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    MainWindow() {
        super("Как мы управляем своими делами: учимся устанавливать приоритеты");
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        createPanel();
        add(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setSize(WIDTH, HEIGHT);
        addAdvices();
        createLists();
        createField();
        createButton();
        createComboBox();
        JScrollPane pane1=new JScrollPane(list1);
        pane1.setSize(list1.getSize());
        pane1.setLocation(list1.getLocation());
        JScrollPane pane2=new JScrollPane(list2);
        pane2.setSize(list2.getSize());
        pane2.setLocation(list2.getLocation());
        JScrollPane pane3=new JScrollPane(list3);
        pane3.setSize(list3.getSize());
        pane3.setLocation(list3.getLocation());
        JScrollPane pane4=new JScrollPane(list4);
        pane4.setSize(list4.getSize());
        pane4.setLocation(list4.getLocation());
        mainPanel.add(pane1);
        mainPanel.add(label2);
        mainPanel.add(pane2);
        mainPanel.add(label3);
        mainPanel.add(pane3);
        mainPanel.add(label4);
        mainPanel.add(pane4);
        mainPanel.add(label5);
        mainPanel.add(field);
        mainPanel.add(addTask);
        mainPanel.add(advice);
        mainPanel.add(comboBox);
    }

    private void createComboBox(){
        comboBox=new JComboBox<>(importances);
        comboBox.setSize(field.getSize());
        comboBox.setLocation(field.getX()+ addTask.getWidth()+20,field.getY());
    }

    private void createField()
    {
        field=new JTextField();
        field.setToolTipText("Введите задачу");
        field.setSize(list3.getSize().width,20);
        field.setLocation(list3.getX(),list3.getY()+list3.getSize().height+5);
    }

    private void addAdvices() {
        advices[0]="Не Вы управляете дедлайнами, а дедлайны управляют Вами. Не шаришь в решение проблем и \n" +
                "распределение времени. А в итоге, усталый и бедный валишься в кроватку со слезами на глазах.\n" +
                "'Ничего не успеваю!' Как часто люди от тебя это слышат? Научись распределять время сбалансированно:\n" +
                "'И поржать и покекать'. Нельзя жить в постоянном стрессе и кризисе!\n" +
                "В противном случае Вы рискуете превратиться в «рабочую лошадку», живущую только работой.\n" +
                "Вспомни песню Ленинграда - Менеджер... Хочешь быть таким же?\n" +
                "Продолжая изо дня в день тянуть воз задач, которые нежадные коллеги будут регулярно Вам подкидывать.\n" +
                "Планируйте свою жизнь, расставляйте по местам свои дела, учитесь делегировать обязанности!\n";
        advices[1]="Вас можно искренне поздравить!\n" +
                "Вы умеете «отделять зерна от плевел». У Вас достаточно времени, чтобы задуматься о своей\n" +
                "жизни, строить планы на будущее, а главное – выбирать, чем и когда заняться." +
                "Очевидно, у Вас налажен контакт с коллегами и друзьями, поскольку у Вас всегда находится\n" +
                "время на дружеские посиделки или звонки. Если Вы сталкиваетесь с трудным вопросом – Вам\n" +
                "есть к кому обратиться за советом. \n" +
                "Вы не тратите время на решение чужих проблем, умеете делегировать свои обязанности.\n" +
                "Вы цените свое время, и, похоже, нашли именно Ваш темп жизни. \n" +
                "╰( ͡° ͜ʖ ͡° )つ──☆*:・ﾟ";
        ;
        advices[2]="'ПОЧЕМУ Я???' Судя по всему, ты часто задаешься этим вопросом.\n" +
                "Тебе дают форматировать чужой код или заниматься работой 'На уровень ниже',\n" +
                "а ты же достоин большего? \n" +
                "А если ты об этом задумался, значит тебе бы следовало также подумать,\n" +
                "почему же ты тратишь время на выполнение неважных задач.\n" +
                "Для начала приведите в порядок свои дела, станьте незаменимым и по-\n" +
                "настоящему нужным. Немедленно пересмотрите весь список своих\n" +
                "приоритетов и время, которое Вы тратите на выполнение обязанностей.\n" +
                "А не то будешь овощем по жизни, а не только дома.\n" +
                "( ͡o ͜ʖ ͡o)";
        advices[3]="Работай и не скули! У всех есть проблемы и загоны, не будь как \n" +
                "стадо. Будь лучше него! Найди себе цели и иди к ним.\n" +
                "Желания сбивают Вас с намеченного пути, а потому действительно\n" +
                "значимые жизненные результаты постоянно откладываются." +
                "(͠≖ ͜ʖ͠≖)";
        advices[4]="Ты – целеустремленный человек, грамотно планирующий свое\n" +
                "будущее. Ты умеешь правильно распределять свое время, не\n" +
                "погружаясь в рутину. Ты на верном пути, так держать!\n" +
                "ЧМАФфФфФкИ\n" +
                " ( ͡° ͜ʖ ͡ °)";
    }

    private boolean chechTasks()
    {
        if(urgentlyImportant.size()==0&&urgentlyUnimportant.size()==0&&nonUgentlyUnimportant.size()==0&&nonUrgentlyImportant.size()==0)
        {
            return false;
        }
        return true;
    }

    private boolean checkTask(String task,DefaultListModel<String> list)
    {
        for(int i=0;i<list.size();i++)
        {
            String check=list.getElementAt(i).substring((list.getElementAt(i).indexOf(")")+2));
            if(check.equals(task))
            {
                return false;
            }
        }
        return true;
    }

    private boolean fieldCheck(String task)
    {
        if(checkTask(task,urgentlyImportant))
        {
            if(checkTask(task,urgentlyUnimportant))
            {
                if(checkTask(task,nonUrgentlyImportant))
                {
                    if(checkTask(task,nonUgentlyUnimportant))
                    {
                        return true;
                    }
                }
            }
        }
        return  false;
    }

    private void refresh(DefaultListModel<String> list) {
        for (int i = 0; i < list.getSize(); i++) {
            StringBuilder task = new StringBuilder(list.getElementAt(i));
            while (task.charAt(0) != ')') {
                task.deleteCharAt(0);
            }
            String num = new Integer(i + 1).toString();
            list.setElementAt(num + task.toString(), i);
        }
    }

    private void createButton() {
        addTask = new JButton("Добавить задачу");
        addTask.setSize(list1.getSize().width, 40);
        addTask.setLocation(list1.getX(), field.getY() + field.getSize().height + 5);
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (field.getText().length() > 0) {
                    if (fieldCheck(field.getText())) {
                        switch ((String) comboBox.getSelectedItem()) {
                            case "Срочно важно": {
                                Integer num = new Integer(urgentlyImportant.getSize() + 1);
                                String number = num.toString() + ") ";
                                urgentlyImportant.addElement(number + field.getText());
                                field.setText("");
                                break;
                            }
                            case "Несрочно важно": {
                                Integer num = new Integer(nonUrgentlyImportant.getSize() + 1);
                                String number = num.toString() + ") ";
                                nonUrgentlyImportant.addElement(number + field.getText());
                                field.setText("");

                                break;
                            }
                            case "Срочно неважно": {
                                Integer num = new Integer(urgentlyUnimportant.getSize() + 1);
                                String number = num.toString() + ") ";
                                urgentlyUnimportant.addElement(number + field.getText());
                                field.setText("");
                                break;
                            }
                            case "Несрочно неважно": {
                                Integer num = new Integer(nonUgentlyUnimportant.getSize() + 1);
                                String number = num.toString() + ") ";
                                nonUgentlyUnimportant.addElement(number + field.getText());
                                field.setText("");
                                break;
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Задача уже добавлена");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Заполните строку");
                }
            }
        });
        advice = new JButton("Совет");
        advice.setSize(list1.getSize().width, 40);
        advice.setLocation(addTask.getX() + addTask.getWidth() + 20, addTask.getY());
        advice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chechTasks()) {
                    int sizeUrgentlyImportant = urgentlyImportant.getSize();
                    int sizeUrgentlyUnimportant = urgentlyUnimportant.getSize();
                    int sizeNonUrgentlyImportant = nonUrgentlyImportant.getSize();
                    int sizeNonUrgentlyUnImportant = nonUgentlyUnimportant.getSize();
                    if ((sizeUrgentlyImportant == 0 || sizeUrgentlyImportant == 1) && sizeNonUrgentlyImportant > sizeUrgentlyUnimportant && (sizeNonUrgentlyUnImportant == 0 || sizeNonUrgentlyUnImportant == 1)) {
                        JOptionPane.showMessageDialog(null, advices[4], "Результаты и рекомендации", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (sizeUrgentlyImportant >= sizeUrgentlyUnimportant && sizeUrgentlyImportant >= sizeNonUrgentlyImportant && sizeUrgentlyImportant > sizeNonUrgentlyUnImportant) {
                            JOptionPane.showMessageDialog(null, advices[0], "Результаты и рекомендации", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if (sizeNonUrgentlyImportant > sizeUrgentlyImportant && sizeNonUrgentlyImportant >= sizeUrgentlyUnimportant && sizeNonUrgentlyImportant >= sizeNonUrgentlyUnImportant) {
                                JOptionPane.showMessageDialog(null, advices[1], "Результаты и рекомендации", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (sizeUrgentlyUnimportant > sizeUrgentlyImportant && sizeUrgentlyUnimportant > sizeNonUrgentlyImportant && sizeUrgentlyUnimportant >= sizeNonUrgentlyUnImportant) {
                                    JOptionPane.showMessageDialog(null, advices[2], "Результаты и рекомендации", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    if (sizeNonUrgentlyUnImportant >= sizeUrgentlyImportant && sizeNonUrgentlyUnImportant >= sizeUrgentlyUnimportant && sizeNonUrgentlyUnImportant >= sizeNonUrgentlyImportant) {
                                        JOptionPane.showMessageDialog(null, advices[3], "Результаты и рекомендации", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Введите задачи","Ошика",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void createLists() {
        Dimension size = new Dimension(200, 200);
        list1 = new JList<>(urgentlyImportant);
        list1.setDragEnabled(true);
        list1.setDropMode(DropMode.ON);
        list1.setSize(size);
        list1.setLocation(50, 50);
        list1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (list1.getSelectedIndex() != -1) {
                        urgentlyImportant.remove(list1.getSelectedIndex());
                        refresh(urgentlyImportant);
                    }

                }
            }
        });
        label2 = new JLabel("Срочно важно");
        label2.setSize(200, 15);
        label2.setLocation(list1.getX(), list1.getY() - 15);
        list2 = new JList<>(nonUrgentlyImportant);
        list2.setSize(size);
        list2.setLocation(list1.getX() + list1.getSize().width + 20, list1.getY());
        list2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (list2.getSelectedIndex() != -1) {
                        nonUrgentlyImportant.remove(list2.getSelectedIndex());
                        refresh(nonUrgentlyImportant);
                    }
                }
            }
        });
        label3 = new JLabel("Несрочно важно");
        label3.setSize(200, 15);
        label3.setLocation(list2.getX(), list2.getY() - 15);
        list3 = new JList<>(urgentlyUnimportant);
        list3.setSize(size);
        list3.setLocation(list1.getX(), list1.getY() + list1.getSize().height + 20);
        list3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (list3.getSelectedIndex() != -1) {
                        urgentlyUnimportant.remove(list3.getSelectedIndex());
                        refresh(urgentlyUnimportant);
                    }

                }
            }
        });
        label4 = new JLabel("Срочно неважно");
        label4.setSize(200, 15);
        label4.setLocation(list3.getX(), list3.getY() - 15);
        list4 = new JList<>(nonUgentlyUnimportant);
        list4.setSize(size);
        list4.setLocation(list3.getX() + list3.getSize().width + 20, list1.getY() + list1.getSize().height + 20);
        list4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (list4.getSelectedIndex() != -1) {
                        nonUgentlyUnimportant.remove(list4.getSelectedIndex());
                        refresh(nonUgentlyUnimportant);
                    }
                }
            }
        });
        label5 = new JLabel("Несрочно неважно");
        label5.setSize(200, 15);
        label5.setLocation(list4.getX(), list4.getY() - 15);
    }
}


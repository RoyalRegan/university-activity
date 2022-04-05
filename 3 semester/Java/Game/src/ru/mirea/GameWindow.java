package ru.mirea;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameWindow extends  JFrame {
    protected static final int WINDOW_WIGHT =800;
    protected static final int WINDOW_HEIGHT =600;


    public GameWindow() {

        initUI();
    }

    private void initUI() {
        setTitle("Space Fish Attack - SFA");
        setSize(WINDOW_WIGHT, WINDOW_HEIGHT);
        add(new Board(WINDOW_WIGHT /2, WINDOW_HEIGHT -HEIGHT/2));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GameWindow ex = new GameWindow();
            ex.setVisible(true);
        });
    }
}

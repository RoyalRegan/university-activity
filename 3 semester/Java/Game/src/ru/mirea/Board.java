package ru.mirea;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Image background_1;
    private Image background_2;
    private SpaceShip spaceShip;
    private ArrayList<AlienShip> alienShips;
    private ArrayList<Integer> directions;
    protected static Boss boss;
    int y1 = 0;
    int y2 = -600;
    private final int DELAY = 8;
    protected static int ticks = 0;

    protected enum status {AlienFight, BossFight, Win, Die}

    protected enum stages {STAGE_1, STAGE_2};

    protected static status gameStatus;
    protected static stages stage;
    protected static int kill_count = 0;

    public Board(int x, int y) {

        initBoard(x, y);
    }

    private void restart() {
        deleteAll();
        background_1 = new ImageIcon("Sprites/Фон.jpg").getImage();
        background_2 = new ImageIcon("Sprites/Фон.jpg").getImage();
        ticks = 1;
        kill_count = 0;
        Boss.isInitialize = false;
        stage = stages.STAGE_1;
        initSpaceShip(GameWindow.WINDOW_WIGHT / 2, GameWindow.WINDOW_HEIGHT - GameWindow.HEIGHT / 2);
        initAliensShips();
        timer.start();
    }

    private void deleteAll() {
        for (int i = 0; i < alienShips.size(); i++) {
            alienShips.remove(i);
        }
        for (int i = 0; i < spaceShip.getShells().size(); i++) {
            spaceShip.getShells().remove(i);
        }
        if (Boss.isInitialize) {
            for (int i = 0; i < boss.getShells().size(); i++) {
                boss.getShells().remove(i);
            }
        }
    }

    private void initBoard(int x, int y) {
        setFocusable(true);
        setOpaque(false);
        setDoubleBuffered(true);
        addKeyListener(new EventTick());
        background_1 = new ImageIcon("Sprites/Фон.jpg").getImage();
        background_2 = new ImageIcon("Sprites/Фон.jpg").getImage();
        stage = stages.STAGE_1;
        initSpaceShip(x, y);
        initAliensShips();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initSpaceShip(int x, int y) { //спавн корабля
        spaceShip = new SpaceShip(x, y);
    }

    private void initAliensShips() {
        alienShips = new ArrayList<>();
        int direct = new Random().nextInt(600) + 60;
        for (int i = 0; i < 5; i++) {
            alienShips.add(new AlienShip(direct, -GameWindow.WINDOW_HEIGHT / 20));
        }
        directions = new ArrayList<>();
        for (int i = 0; i < alienShips.size(); i++) {
            directions.add(i, 3);
        }
    }

    private void initBoss() { //спавн босса
        boss = new Boss(GameWindow.WINDOW_WIGHT / 2, -GameWindow.WINDOW_HEIGHT / 2);
    }

    private void addAliens() {
        int direct = new Random().nextInt(600) + 60;
        for (int i = 0; i < 5; i++) {
            alienShips.add(new AlienShip(direct, -GameWindow.WINDOW_HEIGHT / 20));
        }
        for (int i = alienShips.size() - 5; i < alienShips.size(); i++) {
            directions.add(i, 3);
        }
    }

    private void newAliens() {
        if (gameStatus != status.BossFight) {
            if (ticks % 350 == 0) {
                if (alienShips.size() < 20) {
                    addAliens();
                }
            }
        }
    }

    private void startBossFight() {
        if (kill_count > 24) {
            for (int i = 0; i < alienShips.size(); i++) {
                alienShips.get(i).visible = false;
            }
            kill_count = 0;
            gameStatus = status.BossFight;
            initBoss();
        }
    }

    private void backGroundAnimation() {

        y1 += 2;
        if (y1 == 600) {
            y1 = y2 - 600 + 2;
            switch (stage) {
                case STAGE_1: {
                    background_1 = new ImageIcon("Sprites/Фон.jpg").getImage();
                    break;
                }
                case STAGE_2: {
                    background_1 = new ImageIcon("Sprites/Фон2.png").getImage();
                    break;
                }
            }
        }
        y2 += 2;
        if (y2 == 600) {
            y2 = y1 - 600 + 2;
            switch (stage) {
                case STAGE_1: {
                    background_2 = new ImageIcon("Sprites/Фон.jpg").getImage();
                    break;
                }
                case STAGE_2: {
                    background_2 = new ImageIcon("Sprites/Фон2.png").getImage();
                    break;
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background_1, 0, y1, this);
        g.drawImage(background_2, 0, y2, this);
        doDrawing(g);
        if (gameStatus == status.Die) {
            if (ticks % 90 == 0) {
                g.drawImage(new ImageIcon("Sprites/Смерть.png").getImage(), 0, 0, this);
            }
        }
        if (gameStatus == status.Win) {
            if (ticks % 90 == 0) {
                g.drawImage(new ImageIcon("Sprites/Вин.png").getImage(), 0, 0, this);
            }
        }
        g.dispose();
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
        for (AlienShip alienShip : alienShips) {
            g2d.drawImage(alienShip.getImage(), alienShip.getX(), alienShip.getY(), this);
            for (Shells alien_shell : alienShip.getShells()) {
                g2d.drawImage(alien_shell.getImage(), alien_shell.getX(), alien_shell.getY(), this);
            }
        }
        for (Shells space_shell : spaceShip.getShells()) {
            g2d.drawImage(space_shell.getImage(), space_shell.getX(), space_shell.getY(), this);
        }
        if (Boss.isInitialize) {
            g2d.drawImage(boss.getImage(), boss.getX(), boss.getY(), this);
            for (Shells boss_shell : boss.getShells()) {
                g2d.drawImage(boss_shell.getImage(), boss_shell.getX(), boss_shell.getY(), this);
            }
        }
    }

    private class EventTick extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e) {
            if (gameStatus != status.Die) {
                spaceShip.keyReleased(e);
            }
            if (gameStatus == status.Die && e.getKeyCode() == KeyEvent.VK_ENTER) {
                restart();
            }
            if (gameStatus == status.Win && e.getKeyCode() == KeyEvent.VK_ENTER) {
                restart();
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(1);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (gameStatus != status.Die) {
                spaceShip.keyPressed(e);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        if (gameStatus != status.Die && gameStatus != status.Win) {
            backGroundAnimation();
            tickAlienShip(directions);
            tickAlienShells();
            tickSpaceShip();
            tickSpaceShells();
            checkCollisions();
            startBossFight();

            if (gameStatus == status.BossFight) {
                tickBoss();
                tickBossShells();
            }
        }
        if (gameStatus == status.Die) {
            tickSpaceShip();
            if (ticks % 90 == 0)
                timer.stop();
        }
        if (gameStatus == status.Win) {
            tickBoss();
            if (ticks % 90 == 0) {
                timer.stop();
            }
        }
        repaint();
    }

    private void tickSpaceShip() {
        if (spaceShip.visible) {
            if (ticks % 35 == 0) {
                spaceShip.fire();
            }
            if(Board.ticks%15==0) {
                spaceShip.animation();
            }
            spaceShip.direct();
            spaceShip.move();
        } else {
            if (ticks % 14 == 0) {
                spaceShip.animation();
            }
        }
    }

    private void tickAlienShip(ArrayList<Integer> directions) {
        newAliens();
        for (int i = 0; i < alienShips.size(); i++) {
            if (alienShips.get(i).visible) {
                if (ticks % 60 == 0) {
                    alienShips.get(i).fire();
                }
                alienShips.get(i).move(directions.get(i));
            } else {
                if (ticks % 20 == 0) {
                    alienShips.get(i).animation();
                }
                {
                    if (alienShips.get(i).getDieAnimation() == 9) {
                        alienShips.remove(i);
                        directions.remove(i);
                    }
                }
            }

        }
        aliensDirection();
    }

    private void tickBoss() {
        if (gameStatus == status.BossFight) {
            if (!boss.spawned) {
                boss.spawn();
            } else {
                if (boss.visible) {
                    if(15<boss.getHP())
                    {
                        switch (stage)
                        {
                            case STAGE_1:
                            {
                                if (ticks % 210 == 0) {
                                    boss.fire();
                                }
                                break;
                            }
                            case STAGE_2:
                            {
                                if (ticks % 400 == 0) {
                                    boss.fire();
                                }
                                break;
                            }
                        }
                    }
                    else
                    {
                        switch (stage)
                        {
                            case STAGE_1:
                            {
                                if (ticks % 110 == 0) {
                                    boss.fire();
                                }
                                break;
                            }
                            case STAGE_2:
                            {
                                if (ticks % 400 == 0) {
                                    boss.fire();
                                }
                                break;
                            }
                        }
                    }
                    if(ticks%65==0)
                    {
                        boss.animation();
                    }
                    if (ticks % 14 == 0) {

                        boss.hitAnimation();
                        if (boss.hitAnimation % 2 != 0) {
                            boss.hitAnimation++;
                        }
                    }
                    boss.move(bossDirection());
                }
                else
                {
                    if(boss.animation_step!=9)
                    {
                        if(ticks%20==0)
                        {
                            boss.die();
                        }
                    }
                    else
                    {
                        if(stage!=stages.STAGE_2)
                        {
                            stage=stages.STAGE_2;
                            gameStatus=status.AlienFight;
                            boss.spawned=false;
                            Boss.isInitialize=false;
                        }
                        else
                        {
                            gameStatus=status.Win;
                        }
                    }
                }
            }
        }
    }

    private void tickSpaceShells() {
        for (int i = 0; i < spaceShip.getShells().size(); i++) {
            if (spaceShip.getShells().get(i).visible) {
                spaceShip.getShells().get(i).move(0);
                if (Board.ticks % 12 == 0) {
                    spaceShip.getShells().get(i).animation();
                }
            } else {
                spaceShip.getShells().remove(i);
            }
        }
    }

    private void tickAlienShells() {
        for (AlienShip alienShip : alienShips) {
            for (int j = 0; j < alienShip.getShells().size(); j++) {
                if (alienShip.getShells().get(j).visible) {
                    alienShip.getShells().get(j).move(1);
                } else {
                    alienShip.getShells().remove(j);
                }
            }
        }
    }

    private void tickBossShells() {
        for (int i = 0; i < boss.getShells().size(); i++) {
            if (boss.getShells().get(i).visible) {
                boss.getShells().get(i).move(2);
            } else {
                boss.getShells().remove(i);
            }
        }
    }

    private void aliensDirection() {
        if (ticks % 80 == 0) {
            for (int i = 0; i < alienShips.size(); i++) {
                directions.add(i, new Random().nextInt(8));
            }
        }
    }

    private int bossDirection() {
        if (ticks % 80 == 0) {

            return new Random().nextInt(8);
        }
        return -1;
    }

    private void checkCollisions() {
        Rectangle space_ship = spaceShip.getBounds();
        if (gameStatus != status.BossFight) {
            for (AlienShip alienShip : alienShips) {
                for (Shells shells : alienShip.getShells()) {
                    Rectangle space_shell = shells.getBounds();
                    if (space_ship.intersects(space_shell)) {
                        spaceShip.visible = false;
                        shells.visible = false;
                        spaceShip.die();
                    }
                }
                if (spaceShip.visible) {
                    Rectangle alien_ship = alienShip.getBounds();
                    if (space_ship.intersects(alien_ship)&&alienShip.visible) {
                        spaceShip.visible = false;
                        alienShip.visible = false;
                        spaceShip.die();
                    }
                }

            }
        } else {
            Rectangle boss_fish = boss.getBounds();
            for (Shells shells : boss.getShells()) {
                Rectangle boss_shells = shells.getBounds();
                if (space_ship.intersects(boss_shells)) {
                    spaceShip.visible = false;
                    shells.visible = false;
                    spaceShip.die();
                }
                if (spaceShip.visible) {
                    if (space_ship.intersects(boss_fish)) {
                        spaceShip.visible = false;
                        spaceShip.die();
                    }
                }
            }
        }
        for (Shells shells : spaceShip.getShells()) {
            Rectangle space_shell = shells.getBounds();
            if (gameStatus != status.BossFight) {
                for (AlienShip alienShip : alienShips) {
                    Rectangle alien_ship = alienShip.getBounds();
                    if (space_shell.intersects(alien_ship) && alienShip.visible) {
                        shells.visible = false;
                        alienShip.visible = false;
                        kill_count++;
                    }
                }
            } else {
                Rectangle boss_fish = boss.getBounds();
                if (boss.spawned&&boss.visible) {
                    if (boss_fish.intersects(space_shell)) {
                        boss.hit();
                        shells.visible = false;
                    }
                }
            }
        }
    }
}
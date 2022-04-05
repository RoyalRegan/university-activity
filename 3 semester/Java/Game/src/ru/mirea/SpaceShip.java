package ru.mirea;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SpaceShip extends Sprite {
    private boolean up=false;
    private boolean down=false;
    private boolean left=false;
    private boolean right=false;
    private ArrayList<Shells> shells = new ArrayList<>();

    public SpaceShip(int x, int y) {
        super(x, y);
        visible=true;
        Board.gameStatus = Board.status.AlienFight;
    }

    public void loadImage() {
        images = new Image[13];
        images[0] = new ImageIcon("Sprites/НовыйКорабль1.png").getImage();
        images[1] = new ImageIcon("Sprites/НовыйКорабль2.png").getImage();
        images[2] = new ImageIcon("Sprites/НовыйКорабль3.png").getImage();
        images[3] = new ImageIcon("Sprites/НовыйКорабль-влево1.png").getImage();
        images[4] = new ImageIcon("Sprites/НовыйКорабль-влево2.png").getImage();
        images[5] = new ImageIcon("Sprites/НовыйКорабль-влево3.png").getImage();
        images[6] = new ImageIcon("Sprites/НовыйКорабль-вправо1.png").getImage();
        images[7] = new ImageIcon("Sprites/НовыйКорабль-вправо2.png").getImage();
        images[8] = new ImageIcon("Sprites/НовыйКорабль-вправо3.png").getImage();
        images[9] = new ImageIcon("Sprites/Взрыв1.png").getImage();
        images[10] = new ImageIcon("Sprites/Взрыв2.png").getImage();
        images[11] = new ImageIcon("Sprites/Взрыв3.png").getImage();
        images[12] = new ImageIcon("Sprites/Взрыв4.png").getImage();
        image = images[0];
        wight = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void animation() {
        if (Board.gameStatus != Board.status.Die) {
            if (left) {
                image = images[animation_step];
                animation_step--;
            } else if (right) {
                image = images[animation_step];
                animation_step--;
            }
            if (!left && !right) {
                image = images[animation_step];
                if (animation_step < 2) {
                    animation_step++;
                } else {
                    animation_step = 0;
                }
            }
        } else {
            image = images[animation_step];
            if (animation_step < 12) {
                animation_step++;
            }
        }
    }

    public void move() {
        super.move();
        if (x <= wight / 2) {
            x = wight / 2;
        }
        if (x >= 800 - wight * 2) {
            x = 800 - wight * 2;
        }
        if (y <= height / 2) {
            y = height / 2;
        }
        if (y >= 520 - height / 2) {
            y = 520 - height / 2;
        }
    }

    protected void die() {
        Board.ticks =1;
        animation_step=9;
        Board.gameStatus = Board.status.Die;
    }

    public void fire() {
        shells.add(new Shells(x + wight / 2, y-15));
    }

    public ArrayList<Shells> getShells() {
        return shells;
    }

    public void direct() {
        if (up) {
            dy = -2;
        } else if (down) {
            dy = 2;
        } else {
            dy = 0;
        }
        if (left) {
            dx = -2;
            if (animation_step < 5) {
                animation_step++;
            } else {
                animation_step = 3;
            }
        } else if (right) {
            dx = 2;
            if (animation_step < 8) {
                animation_step++;
            } else {
                animation_step = 6;
            }
        } else {
            dx = 0;
        }
        if (up && down) {
            dy = 0;
        }
        if (left && right) {
            dx = 0;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT :{

                left=true;
                break;
            }
            case KeyEvent.VK_RIGHT :{

                right=true;
                break;
            }
            case KeyEvent.VK_UP :{
                up=true;
                break;
            }
            case KeyEvent.VK_DOWN :{
                down=true;
                break;
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left=false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right=false;
        }
        if (key == KeyEvent.VK_UP) {
            up=false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down=false;
        }
    }
}

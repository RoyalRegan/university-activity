package ru.mirea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlienShip extends Sprite {
    private ArrayList<Shells> shells = new ArrayList<>();
    private int dieAnimation =0;

    public AlienShip(int x, int y) {
        super(x, y);
        visible = true;
    }

    public void loadImage() {
        images = new Image[4];
        images[0] = new ImageIcon("Sprites/Взрыв1.png").getImage();
        images[1] = new ImageIcon("Sprites/Взрыв2.png").getImage();
        images[2] = new ImageIcon("Sprites/Взрыв3.png").getImage();
        images[3] = new ImageIcon("Sprites/Взрыв4.png").getImage();
        switch (Board.stage)
        {
            case STAGE_1: {
                image = new ImageIcon("Sprites/Инопланет.png").getImage();
                break;
            }
            case STAGE_2: {
                image = new ImageIcon("Sprites/Инопланет2.png").getImage();
                break;
            }
        }
        wight = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move(int direction) {
        switch (direction) {
            case 0: {
                dx = 0;
                dy = 0;
                break;
            }
            case 1: {
                dx = 2;
                break;
            }
            case 2: {
                dx = -2;
                break;
            }
            case 3: {
                dy = 1;
                break;
            }
            case 4: {
                dy = -1;
                break;
            }
            case 5: {
                dx = 2;
                dy = 1;
                break;
            }
            case 6: {
                dx = 2;
                dy = -1;
                break;
            }
            case 7: {
                dx = -2;
                dy = 1;
                break;
            }
            case 8: {
                dx = -2;
                dy = -1;
                break;
            }

        }
        super.move();
        if (x <= -65) {
            x = -65;
        }
        if (x >= 770) {
            x = -65;
        }
        y += dy;
        if (y < -30) {
            y = -30;
        }
        if (y > 570) {
            y = -30;
        }
    }

    public void fire() {
        shells.add(new Shells(x + wight / 2, y+height));
    }

    public ArrayList<Shells> getShells() {
        return shells;
    }

    public void animation() {
        dieAnimation++;
        image = images[animation_step];
        if (animation_step < 3) {
            animation_step++;
        } else {
            animation_step = 0;
        }
    }

    public int getDieAnimation() {
        return dieAnimation;
    }
}

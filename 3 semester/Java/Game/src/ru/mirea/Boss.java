package ru.mirea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Boss extends Sprite {
    private int HP;
    protected boolean spawned=false;
    protected static boolean isInitialize =false;
    protected int hitAnimation =0;
    private ArrayList<Shells> shells = new ArrayList<>();

    public Boss(int x, int y) {
        super(x, y);
        visible = true;
        dy=1;
        HP=25;
        isInitialize =true;
    }

    public void loadImage() {
        images = new Image[8];
        images[0] = new ImageIcon("Sprites/Взрыв1.png").getImage();
        images[1] = new ImageIcon("Sprites/Взрыв2.png").getImage();
        images[2] = new ImageIcon("Sprites/Взрыв3.png").getImage();
        images[3] = new ImageIcon("Sprites/Взрыв4.png").getImage();
        switch (Board.stage)
        {
            case STAGE_1: {
                image = new ImageIcon("Sprites/Босс.png").getImage();
                break;
            }
            case STAGE_2: {
                image = new ImageIcon("Sprites/Босс-2.png").getImage();
                break;
            }
        }
        wight = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void animation()
    {
        if(animation_step %2==0)
        {
            if(HP>=15)
            {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/Босс.png").getImage();
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/Босс-2.png").getImage();
                        break;
                    }
                }
            }
            else {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/БоссРейдж.png").getImage();
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/БоссРейдж-2.png").getImage();
                        break;
                    }
                }

            }

        }
        else {
            if(HP>=15) {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/Босс2.png").getImage();
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/Босс2-2.png").getImage();
                        break;
                    }
                }
            }
            else
            {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/БоссРейдж2.png").getImage();
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/БоссРейдж2-2.png").getImage();
                        break;
                    }
                }
            }
        }
        animation_step++;
    }

    public void hitAnimation() {
        if (hitAnimation % 2 == 0) {
            if (HP <= 15) {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/БоссРейдж.png").getImage(); //смена спрайта
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/БоссРейдж-2.png").getImage(); //смена спрайта
                        break;
                    }
                }

            } else {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/Босс.png").getImage(); //смена спрайта
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/Босс-2.png").getImage(); //смена спрайта
                        break;
                    }
                }

            }

        } else {
            if (HP <= 15) {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/БоссРейдж-хит.png").getImage(); //смена спрайта
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/БоссРейдж-2Хит.png").getImage(); //смена спрайта
                        break;
                    }
                }

            } else {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/Босс-хит.png").getImage(); //смена спрайта
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/Босс-2Хит.png").getImage(); //смена спрайта
                        break;
                    }
                }
            }
        }
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

    protected void spawn() {
        if (y < 90) {
            y += dy;
        } else {
            Board.ticks=1;
            spawned = true;
        }
    }

    public void fire() {
        switch (Board.stage)
        {
            case STAGE_1: {
                shells.add(new Shells(x +10, y+height));
                shells.add(new Shells(x + wight / 2+10, y+height));
                shells.add(new Shells(x + wight+10, y+height));
                break;
            }
            case STAGE_2: {
                if(shells.size()<1)
                {
                    shells.add(new Shells(x +10, y+height));
                }
                break;
            }
        }
    }

    public ArrayList<Shells> getShells() {
        return shells;
    }

    protected void hit() {
        if (HP > 0) {
            HP--;
            hitAnimation++;
        } else {
            visible = false;
            hitAnimation = 0;
            animation_step=0;
            Board.ticks = 1;
        }
    }

    protected void die() {
        animation_step++;
        image = images[hitAnimation];
        if (hitAnimation < 3) {
            hitAnimation++;
        } else {
            hitAnimation = 0;
        }
    }

    protected  int getHP() {
        return HP;
    }
}

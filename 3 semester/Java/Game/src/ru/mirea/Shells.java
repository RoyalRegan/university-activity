package ru.mirea;

import javax.swing.*;

public class Shells extends Sprite {
    public static int pause=0;

    public Shells(int x, int y) {
        super(x, y);
        dy=3;
        dx=3;
        visible=true;
    }

    public void loadImage() {
        image = new ImageIcon("Sprites/Выстрел-1.png").getImage();
        wight = image.getWidth(null);
        height = image.getHeight(null);
    }

    void animation() {
        if (animation_step % 2 == 0) {
            image = new ImageIcon("Sprites/Выстрел-1.png").getImage();
        } else {
            image = new ImageIcon("Sprites/Выстрел-2.png").getImage();
        }
        animation_step++;
    }

    public void move(int enemyType) {
        switch (enemyType) {
            case 0: {
                y -= dy;
                if (y <= 0) {
                    dy = 0;
                    visible = false;
                }
                break;
            }
            case 1: {
                switch (Board.stage) {
                    case STAGE_1: {
                        image = new ImageIcon("Sprites/Выстрел.png").getImage();
                        break;
                    }
                    case STAGE_2: {
                        image = new ImageIcon("Sprites/Выстрел2.png").getImage();
                        break;
                    }
                }

                wight = image.getWidth(null);
                height = image.getHeight(null);
                y += dy;
                if (y >= GameWindow.WINDOW_HEIGHT) {
                    dy = 0;
                    visible = false;
                }
                break;
            }
            case 2: {
                switch (Board.stage)
                {
                    case STAGE_1:
                    {
                        image = new ImageIcon("Sprites/Выстрел3.png").getImage();
                        wight = image.getWidth(null);
                        height = image.getHeight(null);
                        switch (animation_step) {
                            case 0:
                            {
                                dy=2;
                                dx=0;
                                break;
                            }
                            case 1:
                            {
                                dy=2;
                                dx=-5;
                                break;
                            }
                            case 2:
                            {
                                dy=2;
                                dx=5;
                                break;
                            }
                        }
                        if(Board.ticks %30==0)
                        {
                            if(animation_step<2)
                            {
                                animation_step++;
                            }
                            else {
                                animation_step=0;
                            }
                        }
                        y+=dy;
                        if (y >= GameWindow.WINDOW_HEIGHT) {
                            dy = 0;
                            visible = false;
                        }
                        x+=dx;
                        break;
                    }
                    case STAGE_2:
                    {
                        pause++;
                        if(Board.ticks%8==0)
                        {
                            animation_step++;
                        }
                        if(animation_step==1)
                        {
                            image = new ImageIcon("Sprites/Лазер.png").getImage();
                            wight = image.getWidth(null);
                            height = image.getHeight(null);
                            animation_step-=2;
                        }
                        if(animation_step==0)
                        {
                            image = new ImageIcon("Sprites/Лазер2.png").getImage();
                            wight = image.getWidth(null);
                            height = image.getHeight(null);
                        }
                        if(pause==200)
                        {
                            visible=false;
                            pause=0;
                        }
                        x=Board.boss.getX()+Board.boss.getImage().getWidth(null)/2;
                        y=Board.boss.getY()+Board.boss.getImage().getHeight(null);
                        break;
                    }
                }

            }
        }
    }
}

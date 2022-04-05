package ru.mirea;

import java.awt.*;


  abstract class Sprite {
    protected boolean visible;
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int wight;
    protected int height;
    protected Image image;
    protected Image [] images;
    protected int animation_step=0;

    protected Sprite(int x,int y) {
        loadImage();
        this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null) / 2;
    }

    protected Rectangle getBounds() {
        return new Rectangle(x, y, wight, height);
    }

     abstract protected void loadImage();
      public void move() {
          x += dx;
          y += dy;
      }

    protected Image getImage() {
        return image;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

}

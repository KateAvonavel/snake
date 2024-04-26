package com.mygdx.game;

public class SnakeHead {
    Direction direction = Direction.UP;
    int xPos = 5;
    int yPos = 5;

    public void move() {
        switch (direction) {
            case UP:
                yPos++;
                break;
            case DOWN:
                yPos--;
                break;
            case LEFT:
                xPos--;
                break;
            case RIGHT:
                xPos++;
                break;
        }
    }
}

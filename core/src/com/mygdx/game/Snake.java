package com.mygdx.game;

public class Snake {
    private Direction direction = Direction.UP;
    Cell snakeHead = new Cell(5,5);

    public void setDirection (Direction direction) {
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case UP:
                snakeHead.yPos++;
                break;
            case DOWN:
                snakeHead.yPos--;
                break;
            case LEFT:
                snakeHead.xPos--;
                break;
            case RIGHT:
               snakeHead.xPos++;
                break;
        }
    }
}

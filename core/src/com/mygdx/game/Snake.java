package com.mygdx.game;

import java.util.LinkedList;

public class Snake {
    private Direction direction = Direction.UP;
    Cell snakeHead = new Cell(5,5);
    LinkedList <Cell> snakeBody = new LinkedList<>();

    public Snake() {
        snakeBody.add(new Cell(snakeHead.xPos, snakeHead.yPos));
    }

    public void setDirection (Direction direction) {
        if (this.direction.canChangeInto(direction)) {
            this.direction = direction;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(Apple apple) {
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
        snakeBody.add(new Cell(snakeHead.xPos, snakeHead.yPos));
        if (!snakeHead.equals(apple.cell)) {
            snakeBody.removeFirst();
        }
    }
}

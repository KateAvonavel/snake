package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.Nullable;

import static com.mygdx.game.GameProperties.*;

public class SnakeApplicationAdapter extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture cellTexture;
    private Texture snakeTexture;
    private Texture appleTexture;

    private Apple apple = new Apple();
    private SnakeHead snakeHead = new SnakeHead();

    @Override
    public void create() {
        batch = new SpriteBatch();
        appleTexture = new Texture("apple.png");
        cellTexture = new Texture("cell.png");
        snakeTexture = new Texture("snake.png");
    }

    @Override
    public void render() {

        batch.begin();

        drawGameField();
        drawApple();
        drawSnake();

        batch.end();

        Direction direction = recognazeDirection();
        if (direction != null) {
            snakeHead.setDirection(direction);
        }

        snakeHead.move();

        if (isAppleCollision()){
            apple = new Apple();
        }
        if (isSnakeOutOfGameBounds()) {
            snakeHead = new SnakeHead();
        }
    }

    @Nullable
    private static Direction recognazeDirection() {
        Direction direction = null;
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
            direction = Direction.UP;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            direction = Direction.LEFT;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)){
            direction = Direction.RIGHT;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            direction = Direction.DOWN;
        }
        return direction;
    }

    private boolean isAppleCollision() {
        return apple.yPos == snakeHead.yPos && apple.xPos == snakeHead.xPos;
    }

    private boolean isSnakeOutOfGameBounds() {
        return snakeHead.xPos >= WIDTH || snakeHead.yPos >= HEIGHT || snakeHead.xPos < 0 || snakeHead.yPos < 0;
    }

    private void drawSnake() {
        batch.draw(snakeTexture, snakeHead.xPos * CELL_SIZE, snakeHead.yPos * CELL_SIZE);
    }

    private void drawApple() {
        batch.draw(appleTexture, apple.xPos * CELL_SIZE, apple.yPos * CELL_SIZE);
    }

    private void drawGameField(){
        for (int xPos = 0; xPos < WIDTH; xPos++) {
            for (int yPos = 0; yPos < HEIGHT; yPos++) {
                batch.draw(
                        cellTexture,
                        xPos * CELL_SIZE,
                        yPos * CELL_SIZE
                );
            }
        }
    }
}

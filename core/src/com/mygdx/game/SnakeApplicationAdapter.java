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
    private Snake snake = new Snake();

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
            snake.setDirection(direction);
        }

        snake.move();

        if (isAppleCollision()){
            apple = new Apple();
        }
        if (isSnakeOutOfGameBounds()) {
            snake = new Snake();
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
        return snake.snakeHead.equals(apple.cell);
    }

    private boolean isSnakeOutOfGameBounds() {
        return snake.snakeHead.xPos >= WIDTH
                || snake.snakeHead.yPos >= HEIGHT
                || snake.snakeHead.xPos < 0
                || snake.snakeHead.yPos < 0;
    }

    private void drawSnake() {
        batch.draw(snakeTexture, snake.snakeHead.xPos * CELL_SIZE, snake.snakeHead.yPos * CELL_SIZE);
    }

    private void drawApple() {
        batch.draw(appleTexture, apple.cell.xPos * CELL_SIZE, apple.cell.yPos * CELL_SIZE);
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

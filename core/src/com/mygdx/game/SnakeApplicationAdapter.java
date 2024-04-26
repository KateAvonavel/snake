package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.GameProperties.*;

public class SnakeApplicationAdapter extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture cellTexture;
    private Texture snakeTexture;
    private Texture appleTexture;

    private final Apple apple = new Apple();
    private final SnakeHead snakeHead = new SnakeHead();

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

        snakeHead.move();

        batch.end();
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

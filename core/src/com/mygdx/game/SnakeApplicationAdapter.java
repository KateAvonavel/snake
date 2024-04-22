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

        batch.draw(snakeTexture, 10 * CELL_SIZE, 10 * CELL_SIZE);

        batch.end();
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

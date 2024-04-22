package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.GameProperties.*;

public class SnakeApplicationAdapter extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture cell;
    private Texture snake;
    private Texture apple;

    @Override
    public void create() {
        batch = new SpriteBatch();
        apple = new Texture("apple.png");
        cell = new Texture("cell.png");
        snake = new Texture("snake.png");
    }

    @Override
    public void render() {
        batch.begin();

        for (int xPos = 0; xPos < WIDTH; xPos++) {
            for (int yPos = 0; yPos < HEIGHT; yPos++) {
                batch.draw(
                        cell,
                        xPos * CELL_SIZE,
                        yPos * CELL_SIZE
                );
            }
        }

        batch.draw(snake, 10 * CELL_SIZE, 10 * CELL_SIZE);
        batch.draw(apple, 2 * CELL_SIZE, 0);

        batch.end();
    }
}

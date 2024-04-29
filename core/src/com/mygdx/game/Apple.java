package com.mygdx.game;

import java.util.Random;

public class Apple {
    private static final Random random = new Random();
    Cell cell;

    public Apple() {
        cell = new Cell(
                random.nextInt(GameProperties.WIDTH),
                random.nextInt(GameProperties.HEIGHT)
        );
    }
}

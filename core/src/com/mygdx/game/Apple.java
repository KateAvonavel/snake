package com.mygdx.game;

import java.util.Random;

public class Apple {
    private static Random random = new Random();
    final int xPos;
    final int yPos;

    public Apple() {
        xPos = random.nextInt(GameProperties.WIDTH);
        yPos = random.nextInt(GameProperties.HEIGHT);
        System.out.println(xPos + " " + yPos);
    }
}

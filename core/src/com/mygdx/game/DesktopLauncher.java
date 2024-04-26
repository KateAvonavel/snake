package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import static com.mygdx.game.GameProperties.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(4); //частота
		config.setTitle("Snake"); // заголовок
		config.setWindowedMode(
				WIDTH * CELL_SIZE,
				HEIGHT * CELL_SIZE
		);
		config.setResizable(false); // разрешено ли менять размер окна
		new Lwjgl3Application(new SnakeApplicationAdapter(), config);
	}
}

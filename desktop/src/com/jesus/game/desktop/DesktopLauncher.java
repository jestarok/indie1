package com.jesus.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jesus.game.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		int fps = 600;
		config.width = 800;
		config.height = 620;
		config.foregroundFPS = fps;
		config.backgroundFPS = fps;
		config.vSyncEnabled =false;
		new LwjglApplication(new GdxGame(), config);
	}
}

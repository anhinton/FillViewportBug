package com.mygdx.fillviewportbug.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.fillviewportbug.FillViewportBug;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("my-gdx-game");
		config.setWindowedMode(1280, 720);

		new Lwjgl3Application(new FillViewportBug(), config);
	}
}

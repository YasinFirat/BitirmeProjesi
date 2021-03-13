package com.pixempires.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pixempires.game.PixEmpires;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=PixEmpires.WIDTH;
		config.height=PixEmpires.HEIGHT;
		new LwjglApplication(new PixEmpires(), config);

	}
}

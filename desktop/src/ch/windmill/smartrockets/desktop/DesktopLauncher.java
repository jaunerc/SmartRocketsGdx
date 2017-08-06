package ch.windmill.smartrockets.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ch.windmill.smartrockets.gdx.SmartRocketsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("app_icon.png", FileType.Internal);
		new LwjglApplication(new SmartRocketsGame(), config);
	}
}

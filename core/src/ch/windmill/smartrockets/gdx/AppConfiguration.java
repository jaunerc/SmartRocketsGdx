package ch.windmill.smartrockets.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class AppConfiguration {

	public int VIEWPORT_WIDTH;
	public int VIEWPORT_HEIGHT;
	public int DNA_SIZE;
	public int POPULATION_SIZE;
	public float TARGET_POS_X;
	public float TARGET_POS_Y;
	public float ROCKET_START_POS_X;
	public float ROCKET_START_POS_Y;
	
	public static void initConfig(AppConfiguration conf) {
		conf.setVIEWPORT_WIDTH(800);
		conf.setVIEWPORT_HEIGHT(800);
		conf.setDNA_SIZE(50);
		conf.setPOPULATION_SIZE(10);
		conf.setTARGET_POS_X(400f);
		conf.setTARGET_POS_Y(400f);
		conf.setROCKET_START_POS_X(400f);
		conf.setROCKET_START_POS_Y(10f);
	}
	
	public static AppConfiguration fromConfigFile() {
		final Json json = new Json();
		AppConfiguration appConfig;
		try {
			appConfig = json.fromJson(AppConfiguration.class, Gdx.files.internal("data/appconfig.json"));
		} catch (Exception e) {
			System.err.println("Could not load external config file. Use default config instead.");
			appConfig = new AppConfiguration();
			AppConfiguration.initConfig(appConfig);
		}
		return appConfig;
	}
	
	public AppConfiguration() {}

	public int getVIEWPORT_WIDTH() {
		return VIEWPORT_WIDTH;
	}

	public void setVIEWPORT_WIDTH(int vIEWPORT_WIDTH) {
		VIEWPORT_WIDTH = vIEWPORT_WIDTH;
	}

	public int getVIEWPORT_HEIGHT() {
		return VIEWPORT_HEIGHT;
	}

	public void setVIEWPORT_HEIGHT(int vIEWPORT_HEIGHT) {
		VIEWPORT_HEIGHT = vIEWPORT_HEIGHT;
	}

	public int getDNA_SIZE() {
		return DNA_SIZE;
	}

	public void setDNA_SIZE(int dNA_SIZE) {
		DNA_SIZE = dNA_SIZE;
	}

	public int getPOPULATION_SIZE() {
		return POPULATION_SIZE;
	}

	public void setPOPULATION_SIZE(int pOPULATION_SIZE) {
		POPULATION_SIZE = pOPULATION_SIZE;
	}

	public float getTARGET_POS_X() {
		return TARGET_POS_X;
	}

	public void setTARGET_POS_X(float tARGET_POS_X) {
		TARGET_POS_X = tARGET_POS_X;
	}

	public float getTARGET_POS_Y() {
		return TARGET_POS_Y;
	}

	public void setTARGET_POS_Y(float tARGET_POS_Y) {
		TARGET_POS_Y = tARGET_POS_Y;
	}

	public float getROCKET_START_POS_X() {
		return ROCKET_START_POS_X;
	}

	public void setROCKET_START_POS_X(float rOCKET_START_POS_X) {
		ROCKET_START_POS_X = rOCKET_START_POS_X;
	}

	public float getROCKET_START_POS_Y() {
		return ROCKET_START_POS_Y;
	}

	public void setROCKET_START_POS_Y(float rOCKET_START_POS_Y) {
		ROCKET_START_POS_Y = rOCKET_START_POS_Y;
	}
}

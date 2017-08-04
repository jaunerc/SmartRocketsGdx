package ch.windmill.smartrockets.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;

import ch.windmill.smartrockets.entities.MatingPool;
import ch.windmill.smartrockets.entities.Population;
import ch.windmill.smartrockets.entities.PopulationInterface;

public class SmartRocketsGame extends Game {
	
	private final static int POPULATION_SIZE = 10;
	private final static float TARGET_POS_X = 50;
	private final static float TARGET_POS_Y = 50;
	
	public SpriteBatch batch;
	public AppConfiguration appConfig;
	
	private PopulationInterface population;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		loadAppConfig();
		initGame();
		startRocketScreen();
	}
	
	private void loadAppConfig() {
		final Json json = new Json();
		try {
			appConfig = json.fromJson(AppConfiguration.class, Gdx.files.internal("data/appconfig.json"));
		} catch (Exception e) {
			System.err.println("Could not load external config file. Use default config instead.");
			appConfig = new AppConfiguration();
			AppConfiguration.initConfig(appConfig);
		}
	}
	
	private void initGame() {
		final Vector2 target = new Vector2(appConfig.TARGET_POS_X, appConfig.TARGET_POS_Y);
		final MatingPool matingPool = new MatingPool(target);
		population = new Population(matingPool);
		population.generateRandomPopulation(appConfig.POPULATION_SIZE);
		
	}
	
	private void startRocketScreen() {
		RocketScreen rocketScreen = new RocketScreen(this);
		setScreen(rocketScreen); 
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	
	public void updateRockets(final float screenWidth, final float screenHeight) {
		population.updatePopulation(screenWidth, screenHeight);
	}
	
	public void renderRockets() {
		population.drawPopulation(batch);
	}
}

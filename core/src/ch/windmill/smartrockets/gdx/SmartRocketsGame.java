package ch.windmill.smartrockets.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Preferences;
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
	
	private PopulationInterface population;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		initGame();
		startRocketScreen();
		
		
		
		Json json = new Json();
		AppConfiguration acBefore = new AppConfiguration();
		AppConfiguration.initConfig(acBefore);
		String j = json.toJson(acBefore);
		System.out.println(j);
		AppConfiguration ac = json.fromJson(AppConfiguration.class, j);
	}
	
	private void initGame() {
		final Vector2 target = new Vector2(TARGET_POS_X, TARGET_POS_Y);
		final MatingPool matingPool = new MatingPool(target);
		population = new Population(matingPool);
		population.generateRandomPopulation(POPULATION_SIZE);
		
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

package gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.windmill.smartrockets.MatingPoolInterface;
import ch.windmill.smartrockets.Population;
import ch.windmill.smartrockets.PopulationInterface;

public class SmartRocketsGame extends Game {
	
	private final static int POPULATION_SIZE = 20;
	
	public SpriteBatch batch;
	
	private PopulationInterface population;
	private MatingPoolInterface matingPool;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		initGame();
		startRocketScreen();
	}
	
	private void initGame() {
		population = new Population();
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
	
	public void updateRockets() {
		
	}
	
	public void renderRockets() {
		
	}
}

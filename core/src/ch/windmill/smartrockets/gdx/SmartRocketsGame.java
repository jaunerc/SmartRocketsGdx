package ch.windmill.smartrockets.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.MatingPool;
import ch.windmill.smartrockets.entities.Population;
import ch.windmill.smartrockets.entities.PopulationInterface;
import ch.windmill.smartrockets.entities.RocketTarget;
import ch.windmill.smartrockets.helper.SpriteManager;

public class SmartRocketsGame extends Game {

	public SpriteBatch batch;
	public AppConfiguration appConfig;

	private PopulationInterface population;
	private RocketTarget rocketTarget;

	@Override
	public void create() {
		batch = new SpriteBatch();
		loadAppConfig();
		initGame();
		startRocketScreen();
	}

	private void loadAppConfig() {
		appConfig = AppConfiguration.fromConfigFile();
	}

	private void initGame() {
		final Vector2 target = new Vector2(appConfig.TARGET_POS_X, appConfig.TARGET_POS_Y);
		final MatingPool matingPool = new MatingPool(target, appConfig.VIEWPORT_WIDTH);
		final SpriteManager spriteManager = new SpriteManager();
		
		rocketTarget = new RocketTarget(target);
		rocketTarget.initTexture();
		
		spriteManager.createTargetSprite(rocketTarget.getTexture());
		spriteManager.setTargetSpritePosition(rocketTarget.getCenterPosition());
		
		population = new Population(matingPool, spriteManager);
		population.generateRandomPopulation(appConfig.POPULATION_SIZE);
	}

	private void startRocketScreen() {
		RocketScreen rocketScreen = new RocketScreen(this);
		setScreen(rocketScreen);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	public void updateRockets(final float screenWidth, final float screenHeight) {
		population.updatePopulation(screenWidth, screenHeight);
	}

	public void renderRockets() {
		population.drawPopulation(batch);
	}

	public void renderTarget() {
		rocketTarget.draw(batch);
	}
}

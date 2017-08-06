package ch.windmill.smartrockets.entities;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.helper.RocketTargetCollision;
import ch.windmill.smartrockets.helper.SpriteManager;
import ch.windmill.smartrockets.industry.RocketFactory;

/**
 * This class represents a population of rockets.
 */
public class Population implements PopulationInterface {

	private final static String TEXTURE_NAME = "rocket_tiny.png";

	private ArrayList<RocketInterface> rockets;
	private ArrayList<RocketInterface> lastGeneration;
	private MatingPoolInterface matingPool;
	private Texture rocketTexture;
	private SpriteManager spriteManager;

	public Population() {
		this(new MatingPool(), new SpriteManager());
	}
	
	public Population(final MatingPoolInterface matingPool, final SpriteManager spriteManager) {
		this.matingPool = matingPool;
		this.spriteManager = spriteManager;
		rockets = new ArrayList<>();
		lastGeneration = new ArrayList<>();
	}

	@Override
	public void evolve() {
		matingPool.fillPool(lastGeneration);
		for (int i = 0; i < lastGeneration.size(); i++) {
			rockets.add(selectDnaGenes());
		}
		lastGeneration.clear();
	}

	private RocketInterface selectDnaGenes() {
		final RocketFactory factory = new RocketFactory();
		final RocketInterface parentA = matingPool.getRandomRocket();
		final RocketInterface parentB = matingPool.getRandomRocket();
		final Dna childDna = Dna.crossover(parentA.getDna(), parentB.getDna());
		return factory.makeRocketAtDefaultPosition(childDna);
	}

	@Override
	public void updatePopulation(final float screenWidth, final float screenHeight) {
		checkRocketTextureLoad();
		handleRocketUpdate(screenWidth, screenHeight);
		handleGenerationDeath();
	}

	private void handleRocketUpdate(final float screenWidth, final float screenHeight) {
		final Iterator<RocketInterface> iterator = rockets.iterator();
		RocketInterface rocket;
		while (iterator.hasNext()) {
			rocket = iterator.next();
			rocket.update(screenWidth, screenHeight, rocketTexture);
			handleTargetCollision(rocket);
			removeRocketIfDone(rocket, iterator);
		}
	}

	private void handleTargetCollision(final RocketInterface rocket) {
		if (isCollidedWithTarget(rocket)) {
			rocket.handleTargetHit();
		}
	}
	
	private boolean isCollidedWithTarget(final RocketInterface rocket) {
		boolean result = false;
		final Sprite rocketSprite = spriteManager.getRocketSprite();
		final Sprite targetSprite = spriteManager.getTargetSprite();
		rocketSprite.setPosition(rocket.getPos().x, rocket.getPos().y);
		
		if(rocketSprite.getBoundingRectangle().overlaps(targetSprite.getBoundingRectangle())) {
			result = true;
		}
		
		return result;
	}

	private void removeRocketIfDone(final RocketInterface rocket, final Iterator<RocketInterface> iterator) {
		if (rocket.isCrashed() || rocket.isCompleted() || rocket.isEndOfDna()) {
			lastGeneration.add(rocket);
			iterator.remove();
		}
	}

	private void handleGenerationDeath() {
		if (rockets.size() == 0) {
			evolve();
		}
	}

	@Override
	public void generateRandomPopulation(final int populationSize) {
		if (populationSize <= 0) {
			throw new IllegalArgumentException("The population size must be greater than 0.");
		}
		rockets.clear();
		lastGeneration.clear();
		createRocketsWithRandomDna(populationSize);
	}

	private void createRocketsWithRandomDna(final int populationSize) {
		final RocketFactory factory = new RocketFactory();
		for (int i = 0; i < populationSize; i++) {
			rockets.add(factory.makeRocketWithRandomDna());
		}
	}

	@Override
	public void drawPopulation(final SpriteBatch batch) {
		checkRocketTextureLoad();
		Sprite sprite = new Sprite(rocketTexture);
		Vector2 pos;
		for (RocketInterface rocket : rockets) {
			pos = rocket.getPos();
			sprite.setPosition(pos.x, pos.y);
			sprite.setRotation(rocket.getVelocity().angle() -45);
			sprite.draw(batch);
		}
	}

	private void checkRocketTextureLoad() {
		if (rocketTexture == null) {
			rocketTexture = new Texture(Gdx.files.internal(TEXTURE_NAME));
			spriteManager.createRocketSprite(rocketTexture);
		}
	}

}

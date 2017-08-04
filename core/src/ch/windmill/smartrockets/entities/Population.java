package ch.windmill.smartrockets.entities;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.industry.RocketFactory;

public class Population implements PopulationInterface {

	private final static String TEXTURE_NAME = "rocket_tiny.png";

	private ArrayList<RocketInterface> rockets;
	private ArrayList<RocketInterface> lastGeneration;
	private MatingPoolInterface matingPool;
	private Texture rocketTexture;
	private Vector2 rocketTarget;

	public Population() {
		this(new MatingPool(), new Vector2());
	}

	public Population(final MatingPoolInterface matingPool, final Vector2 rocketTarget) {
		this.matingPool = matingPool;
		this.rocketTarget = rocketTarget;
		rockets = new ArrayList<>();
		lastGeneration = new ArrayList<>();
	}
	
	@Override
	public void setRocketTarget(final Vector2 rocketTarget) {
		this.rocketTarget = rocketTarget;
	}

	@Override
	public void evolve() {
		final RocketFactory factory = new RocketFactory();
		RocketInterface child, parentA, parentB;
		Dna childDna;
		matingPool.fillPool(lastGeneration);
		for (int i = 0; i < lastGeneration.size(); i++) {
			parentA = matingPool.getRandomRocket();
			parentB = matingPool.getRandomRocket();
			childDna = Dna.crossover(parentA.getDna(), parentB.getDna());
			child = factory.makeRocketAtDefaultPosition(childDna);
			rockets.add(child);
		}
		lastGeneration.clear();
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
			rocket.handleTargetHit(rocketTarget);
			if (rocket.isCrashed() || rocket.isCompleted() || rocket.isEndOfDna()) {
				lastGeneration.add(rocket);
				iterator.remove();
			}
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
		Vector2 pos;
		for (RocketInterface rocket : rockets) {
			pos = rocket.getPos();
			batch.draw(rocketTexture, pos.x, pos.y);
		}
	}

	private void checkRocketTextureLoad() {
		if (rocketTexture == null) {
			rocketTexture = new Texture(Gdx.files.internal(TEXTURE_NAME));
		}
	}

}

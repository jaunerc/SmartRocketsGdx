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
	
	private ArrayList<Rocket> rockets;
	private MatingPoolInterface matingPool;
	private Texture rocketTexture;
	
	public Population() {
		rockets = new ArrayList<>();
		matingPool = new MatingPool();
	}
	
	@Override
	public void evolve() {
		
	}

	@Override
	public void updatePopulation(final float screenWidth, final float screenHeight) {
		checkRocketTextureLoad();
		final Iterator<Rocket> iterator = rockets.iterator();
		Rocket rocket;
		while(iterator.hasNext()) {
			rocket = iterator.next();
			rocket.update(screenWidth, screenHeight, rocketTexture);
			if(rocket.isCrashed() || rocket.isCompleted()) {
				iterator.remove();
			}
		}
	}

	@Override
	public void generateRandomPopulation(int populationSize) {
		if(populationSize <= 0) {
			throw new IllegalArgumentException("The population size must be greater than 0.");
		}
		final RocketFactory factory = new RocketFactory();
		rockets.clear();
		for(int i = 0; i < populationSize; i++) {
			rockets.add(factory.makeRocketWithRandomDna());
		}
	}

	@Override
	public void drawPopulation(SpriteBatch batch) {
		checkRocketTextureLoad();
		Vector2 pos;
		for(Rocket rocket : rockets) {
			pos = rocket.getPos();
			batch.draw(rocketTexture, pos.x, pos.y);
		}
	}

	private void checkRocketTextureLoad() {
		if(rocketTexture == null) {
			rocketTexture = new Texture(Gdx.files.internal(TEXTURE_NAME));
		}
	}
}

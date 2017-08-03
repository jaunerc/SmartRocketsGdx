package ch.windmill.smartrockets.entities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.windmill.smartrockets.industry.RocketFactory;

public class Population implements PopulationInterface {

	private ArrayList<Rocket> rockets;
	private MatingPoolInterface matingPool;
	
	public Population() {
		rockets = new ArrayList<>();
		matingPool = new MatingPool();
	}
	
	@Override
	public void evolve() {
		
	}

	@Override
	public void updatePopulation() {
		for(RocketInterface rocket : rockets) {
			rocket.update();
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
		for(Rocket rocket : rockets) {
			rocket.draw(batch);
		}
	}

}

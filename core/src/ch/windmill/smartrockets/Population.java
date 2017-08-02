package ch.windmill.smartrockets;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.windmill.smartrockets.interfaces.MatingPoolInterface;
import ch.windmill.smartrockets.interfaces.PopulationInterface;
import ch.windmill.smartrockets.interfaces.RocketInterface;

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
		rockets.clear();
		for(int i = 0; i < populationSize; i++) {
			rockets.add(new Rocket());
		}
	}

	@Override
	public void drawPopulation(SpriteBatch batch) {
		for(Rocket rocket : rockets) {
			rocket.draw(batch);
		}
	}

}

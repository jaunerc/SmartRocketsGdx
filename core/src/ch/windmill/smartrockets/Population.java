package ch.windmill.smartrockets;

import java.util.ArrayList;

public class Population implements PopulationInterface {

	private ArrayList<RocketInterface> rockets;
	
	public Population() {
		rockets = new ArrayList<RocketInterface>();
	}
	
	@Override
	public void evolve() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePopulation() {
		// TODO Auto-generated method stub

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

}

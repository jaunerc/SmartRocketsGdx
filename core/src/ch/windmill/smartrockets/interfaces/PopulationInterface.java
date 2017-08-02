package ch.windmill.smartrockets.interfaces;

public interface PopulationInterface {

	/**
	 * Evolves the population to the next evolution.
	 */
	void evolve();
	
	/**
	 * Updates the entire population of rockets.
	 */
	void updatePopulation();
	
	/**
	 * Generates a random population of rockets. This method removes all existing rockets.
	 * @param populationSize The number of rockets.
	 */
	void generateRandomPopulation(int populationSize);
}

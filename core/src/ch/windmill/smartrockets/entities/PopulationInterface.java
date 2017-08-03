package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface PopulationInterface {

	/**
	 * Evolves the population to the next evolution.
	 */
	void evolve();
	
	/**
	 * Updates the entire population of rockets.
	 */
	void updatePopulation();
	
	void drawPopulation(SpriteBatch batch);
	
	/**
	 * Generates a random population of rockets. This method removes all existing rockets.
	 * @param populationSize The number of rockets.
	 */
	void generateRandomPopulation(int populationSize);
}

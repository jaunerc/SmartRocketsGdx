package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface PopulationInterface {

	/**
	 * Evolves the population to the next evolution.
	 */
	void evolve();

	/**
	 * Updates the entire population of rockets.
	 */
	void updatePopulation(float screenWidth, float screenHeight);

	/**
	 * Draws the entire population.
	 * 
	 * @param batch
	 *            to draw with.
	 */
	void drawPopulation(SpriteBatch batch);

	/**
	 * Generates a random population of rockets. This method removes all existing
	 * rockets.
	 * 
	 * @param populationSize
	 *            The number of rockets.
	 */
	void generateRandomPopulation(int populationSize);
}

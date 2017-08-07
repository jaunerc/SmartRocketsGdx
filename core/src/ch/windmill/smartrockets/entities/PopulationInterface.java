package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * This interface provides methods for a rocket population. It holds rockets and
 * manages physical updates and drawing for them. It also handles the evolution
 * of rockets.
 */
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
	
	/**
	 * Gets the count of generations.
	 * @return Generation count.
	 */
	int getGenerationNumber();
}

package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.math.Vector2;

public interface RocketInterface {

	/**
	 * Handles collisions with the target and the screen borders.
	 * @param targetPosition
	 */
	void handleCollision(Vector2 targetPosition);
	
	/**
	 * Updates this rocket.
	 */
	void update();
	
	/**
	 * Calculates the fitness value of this rocket.
	 * @param targetPosition
	 */
	void calcFitness(Vector2 targetPosition);
	
	float getFitness();
	
	Vector2 getPos();
}

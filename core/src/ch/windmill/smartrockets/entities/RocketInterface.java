package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.Texture;
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
	void update(float screenWidth, float screenHeight, Texture texture);
	
	/**
	 * Calculates the fitness value of this rocket.
	 * @param targetPosition
	 */
	void calcFitness(Vector2 targetPosition);
	
	void setFitness(float fitness);
	
	float getFitness();
	
	Vector2 getPos();
}

package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * This interface provides methods for a smart rocket. A rocket holds a dna,
 * motion vectors and a fitness value.
 */
public interface RocketInterface {

	/**
	 * Updates this rocket.
	 */
	void update(float screenWidth, float screenHeight, Texture texture);

	/**
	 * Handles the hit with the rocket target.
	 * 
	 * @param target
	 */
	void handleTargetHit();
	
	void handleBarrierHit();

	/**
	 * Calculates the fitness value of this rocket.
	 * 
	 * @param targetPosition
	 */
	void calcFitness(Vector2 targetPosition);

	void setFitness(float fitness);
	
	float getFitness();

	Vector2 getPos();
	
	Vector2 getVelocity();

	Dna getDna();

	boolean isCrashed();

	boolean isCompleted();

	boolean isEndOfDna();
}

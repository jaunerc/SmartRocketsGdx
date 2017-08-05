package ch.windmill.smartrockets.entities;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

/**
 * This interface provides methods to manage a mating pool. The mating pool
 * considers the fitness of rockets to affect their probability by choosing from the pool.
 */
public interface MatingPoolInterface {

	/**
	 * Fills the pool with rockets from the given list.
	 * 
	 * @param rockets
	 */
	void fillPool(List<RocketInterface> rockets);

	/**
	 * Gets a random rocket from the pool.
	 * 
	 * @return
	 */
	RocketInterface getRandomRocket();

	/**
	 * Sets the position of the rocket target.
	 * 
	 * @param target
	 */
	void setRocketTarget(Vector2 target);
}

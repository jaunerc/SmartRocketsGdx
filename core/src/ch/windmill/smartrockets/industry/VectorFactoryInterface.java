package ch.windmill.smartrockets.industry;

import com.badlogic.gdx.math.Vector2;

public interface VectorFactoryInterface {

	/**
	 * Creates a vector with random x and y components and the given length.
	 * @return Random generated Vector.
	 */
	Vector2 makeRandomVector(float length);
	
	/**
	 * Creates a vector with random x and y components and the default length of this implementation.
	 * @return Random generated Vector.
	 */
	Vector2 makeRandomVector();
}

package ch.windmill.smartrockets.industry;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class VectorFactory implements VectorFactoryInterface {

	private Random random;
	private float defaultLength;
	
	public VectorFactory() {
		this(new Random(), 0f);
	}
	
	public VectorFactory(final float defaultLength) {
		this(new Random(), defaultLength);
	}
	
	public VectorFactory(final Random random, final float defaultLength) {
		this.random = random;
		this.defaultLength = defaultLength;
	}

	@Override
	public Vector2 makeRandomVector(float length) {
		final float x = mapFloat(random.nextFloat());
		final float y = mapFloat(random.nextFloat());
		final Vector2 vector = new Vector2(x, y);
		vector.setLength(length);
		return vector;
	}

	@Override
	public Vector2 makeRandomVector() {
		return makeRandomVector(defaultLength);
	}

	/**
	 * Maps a float in the range of [0, 1] into [-1, 1].
	 * @param value to map.
	 * @return Mapped float.
	 */
	private float mapFloat(final float value) {
		return value * 2 - 1;
	}
}

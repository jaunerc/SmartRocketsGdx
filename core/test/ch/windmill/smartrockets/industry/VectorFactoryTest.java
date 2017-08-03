package ch.windmill.smartrockets.industry;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class VectorFactoryTest {

	/**
	 * {@link VectorFactory#makeRandomVector(float)}
	 */
	@Test
	public void testMakeRandomVectorWithLength() {
		VectorFactory factory = new VectorFactory();
		Vector2 vector = factory.makeRandomVector(0.3f);
		assertEquals(0.3f, vector.len(), 0.001f);
	}

	/**
	 * {@link VectorFactory#makeRandomVector}
	 */
	@Test
	public void testMakeRandomVector() {
		VectorFactory factory = new VectorFactory(0.4f);
		Vector2 vector = factory.makeRandomVector();
		assertEquals(0.4f, vector.len(), 0.001f);
	}
}

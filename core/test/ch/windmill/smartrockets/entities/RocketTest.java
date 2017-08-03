package ch.windmill.smartrockets.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Rocket;

public class RocketTest {

	/**
	 * {@link Rocket#handleCollision(Vector2)}
	 */
	@Test
	public void testHandleCollision() {
		final Rocket rocket = new Rocket();
		rocket.handleCollision(new Vector2());
		final Vector2 position = rocket.getPos();
		assertTrue(position.x >= 0 && position.y >= 0);
	}

	/**
	 * {@link Rocket#calcFitness(Vector2)}
	 */
	@Test
	public void testCalcFitness() {
		final Rocket rocket = new Rocket();
		rocket.calcFitness(new Vector2());
		assertTrue(rocket.getFitness() >= 0.0000000f);
	}
}

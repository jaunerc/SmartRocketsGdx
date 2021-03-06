package ch.windmill.smartrockets.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Rocket;

public class RocketTest {

	/**
	 * {@link Rocket#calcFitness(Vector2)}
	 */
	@Test
	public void testCalcFitnessPositive() {
		final Rocket rocket = new Rocket();
		rocket.calcFitness(new Vector2(400, 400));
		System.out.println("fitness: " + rocket.getFitness());
		assertTrue(rocket.getFitness() >= 0.0f);
	}

	/**
	 * {@link Rocket#calcFitness(Vector2)}
	 */
	@Test
	public void testCalcFitness() {
		final Rocket rocket = new Rocket(100, 50, new Dna());
		rocket.calcFitness(new Vector2(100, 100));
		System.out.println("fitness: " + rocket.getFitness());
		assertEquals((1 / 50f), rocket.getFitness(), 0.01f);
	}
}

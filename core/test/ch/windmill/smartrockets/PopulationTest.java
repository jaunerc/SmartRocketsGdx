package ch.windmill.smartrockets;

import static org.junit.Assert.*;

import org.junit.Test;

public class PopulationTest {

	/**
	 * {@link Population#generateRandomPopulation(int)}
	 */
	@Test
	public void testNegativePopulationSize() {
		final Population population = new Population();
		try {
			population.generateRandomPopulation(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	/**
	 * {@link Population#generateRandomPopulation(int)}
	 */
	@Test
	public void testZeroPopulation() {
		final Population population = new Population();
		try {
			population.generateRandomPopulation(0);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}

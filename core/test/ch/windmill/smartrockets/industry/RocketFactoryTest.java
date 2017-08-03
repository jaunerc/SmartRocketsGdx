package ch.windmill.smartrockets.industry;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class RocketFactoryTest {

	/**
	 * {@link RocketFactory#generateRandomGenes(int)}
	 */
	@Test
	public void testGenerateRandomGenes() {
		RocketFactory rocketFactory = new RocketFactory();
		List<Vector2> genes = rocketFactory.generateRandomGenes(10);
		assertEquals(10, genes.size());
	}

	/**
	 * {@link RocketFactory#generateRandomGenes(int)}
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateRandomGenesWithZero() {
		RocketFactory rocketFactory = new RocketFactory();
		List<Vector2> genes = rocketFactory.generateRandomGenes(0);
	}
	
	/**
	 * {@link RocketFactory#generateRandomGenes(int)}
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateRandomGenesWithNegative() {
		RocketFactory rocketFactory = new RocketFactory();
		List<Vector2> genes = rocketFactory.generateRandomGenes(-10);
	}
}

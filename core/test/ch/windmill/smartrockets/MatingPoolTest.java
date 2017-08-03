package ch.windmill.smartrockets;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ch.windmill.smartrockets.entities.MatingPool;
import ch.windmill.smartrockets.entities.Rocket;
import ch.windmill.smartrockets.entities.RocketInterface;

public class MatingPoolTest {

	/**
	 * {@link MatingPool#getRandomRocket()}
	 */
	@Test
	public void testGetRandomRocket() {
		final MatingPool matingPool = new MatingPool();
		final ArrayList<RocketInterface> rockets = new ArrayList<>();
		rockets.add(new Rocket());
		matingPool.fillPool(rockets);
		
		try {
			matingPool.getRandomRocket();
			assertTrue(true);
		} catch (IndexOutOfBoundsException e) {
			assertFalse(true);
		}
	}

	/**
	 * {@link MatingPool#getRandomRocket()}
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetRandomRocketFromEmptyPool() {
		final MatingPool matingPool = new MatingPool();
		matingPool.getRandomRocket();
	}
}

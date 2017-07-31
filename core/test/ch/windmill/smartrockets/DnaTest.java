package ch.windmill.smartrockets;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class DnaTest {

	/**
	 * {@link Dna#crossover(DnaInterface)}
	 */
	@Test
	public void testCrossover() {
		final Dna dna = Dna.crossover(new Dna());
		assertTrue(dna.getGenes().length > 0);
	}

}

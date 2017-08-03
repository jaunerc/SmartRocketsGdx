package ch.windmill.smartrockets.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Dna;

public class DnaTest {

	/**
	 * {@link Dna#crossover(DnaInterface)}
	 */
	@Test
	public void testCrossover() {
		final List<Vector2> genes = new ArrayList<>();
		final Dna dna = Dna.crossover(new Dna(genes), new Dna(genes));
		assertEquals(genes.size(), dna.getGenes().size());
	}

	/**
	 * {@link Dna#getGeneAtPos(int)}
	 */
	@Test
	public void testGetGeneAtExistingPos() {
		final ArrayList<Vector2> genes = generateRandomGenes(25);
		final Dna dna = new Dna(genes);
		try {
			dna.getGeneAtPos(20);
			assertTrue(true);
		} catch (IndexOutOfBoundsException e) {
			assertFalse(true);
		}
	}
	
	/**
	 * {@link Dna#getGeneAtPos(int)}
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetGeneAtNonExistingPos() {
		final ArrayList<Vector2> genes = generateRandomGenes(25);
		final Dna dna = new Dna(genes);
		dna.getGeneAtPos(25);
	}
	
	private ArrayList<Vector2> generateRandomGenes(final int size) {
		final ArrayList<Vector2> genes = new ArrayList<>();
		final Random random = new Random();
		for(int i = 0; i < size; i++) {
			genes.add(new Vector2(random.nextFloat(), random.nextFloat()));
		}
		return genes;
	}
	
	/**
	 * {@link Dna#getSize()}
	 */
	@Test
	public void testGetSize() {
		final ArrayList<Vector2> genes = generateRandomGenes(25);
		final Dna dna = new Dna(genes);
		assertEquals(25, dna.getSize());
	}
	
	/**
	 * {@link Dna#getCurrentGene()}
	 */
	@Test
	public void testGetCurrentGene() {
		final ArrayList<Vector2> genes = generateRandomGenes(5);
		final Dna dna = new Dna(genes);
		assertNotNull(dna.getCurrentGene());
	}
	
	/**
	 * {@link Dna#getCurrentGene()}
	 */
	@Test
	public void testGetCurrentGeneFromEmptyList() {
		final ArrayList<Vector2> genes = generateRandomGenes(0);
		final Dna dna = new Dna(genes);
		assertNull(dna.getCurrentGene());
	}
}

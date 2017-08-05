package ch.windmill.smartrockets.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

/**
 * This class represents a dna implementation. It uses an ArrayList to handle the genes.
 */
public class Dna implements DnaInterface {

	private final static double MUTATION_THRESHOLD = 0.01;

	private List<Vector2> genes;
	private Iterator<Vector2> geneIterator;

	public Dna(final List<Vector2> genes) {
		this.genes = genes;
	}

	public Dna() {
		this(new ArrayList<>());
	}

	/**
	 * Generates a new genes list based on this and the given dna.
	 * 
	 * @param dnaInterface
	 *            The partner dna.
	 */
	public static Dna crossover(final DnaInterface dnaA, final DnaInterface dnaB) {
		final ArrayList<Vector2> nextGenes = new ArrayList<>();
		final int randomMidPos = (int) (Math.random() * dnaA.getGenes().size());

		for (int i = 0; i < dnaA.getGenes().size(); i++) {
			if (i < randomMidPos) {
				nextGenes.add(dnaA.getGeneAtPos(i));
			} else {
				nextGenes.add(dnaB.getGeneAtPos(i));
			}
		}
		return new Dna(nextGenes);
	}

	@Override
	public void mutation() {
		final Random random = new Random();
		for (int i = 0; i < genes.size(); i++) {
			final double choice = random.nextDouble();
			if (choice < MUTATION_THRESHOLD) {
				Vector2 vectorToMutate = genes.get(i);
				setRandomVectorValues(vectorToMutate);
			}
		}
	}

	private void setRandomVectorValues(final Vector2 vector) {
		final Random random = new Random();
		vector.set(random.nextFloat(), random.nextFloat());
	}

	@Override
	public List<Vector2> getGenes() {
		return genes;
	}

	@Override
	public Vector2 getCurrentGene() {
		if (geneIterator == null) {
			geneIterator = genes.iterator();
		}
		return geneIterator.next();
	}

	@Override
	public Vector2 getGeneAtPos(int index) {
		return genes.get(index);
	}

	@Override
	public int getSize() {
		return genes.size();
	}

}

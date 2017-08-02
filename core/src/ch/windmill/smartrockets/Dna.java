package ch.windmill.smartrockets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class Dna implements DnaInterface {
	
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
	 * @param dnaInterface The partner dna.
	 */
	public static Dna crossover(final DnaInterface dnaA, final DnaInterface dnaB) {
		final ArrayList<Vector2> nextGenes = new ArrayList<>();
		final int randomMidPos = (int) (Math.random() * dnaA.getGenes().size());
		
		for(int i = 0; i < dnaA.getGenes().size(); i++) {
			if(i < randomMidPos) {
				nextGenes.add(dnaA.getGeneAtPos(i));
			} else {
				nextGenes.add(dnaB.getGeneAtPos(i));
			}
		}
		
		return new Dna(nextGenes);
	}

	@Override
	public void mutation() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vector2> getGenes() {
		return genes;
	}

	@Override
	public Vector2 getCurrentGene() {
		// TODO Auto-generated method stub
		return null;
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

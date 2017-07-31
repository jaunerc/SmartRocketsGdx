package ch.windmill.smartrockets;

import com.badlogic.gdx.math.Vector2;

public class Dna implements DnaInterface {
	
	private Vector2[] genes;
	
	public Dna() {
		genes = new Vector2[1];
	}

	/**
	 * Generates a new genes list based on this and the given dna.
	 * @param dnaInterface The partner dna.
	 */
	public static Dna crossover(DnaInterface dnaInterface) {
		return new Dna();

	}

	@Override
	public void mutation() {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector2[] getGenes() {
		// TODO Auto-generated method stub
		return genes;
	}

	@Override
	public Vector2 getCurrentGene() {
		// TODO Auto-generated method stub
		return null;
	}

}

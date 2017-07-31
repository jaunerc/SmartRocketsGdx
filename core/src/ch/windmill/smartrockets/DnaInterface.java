package ch.windmill.smartrockets;

import com.badlogic.gdx.math.Vector2;

public interface DnaInterface {
	
	/**
	 * Randomly choose genes to mutate.
	 */
	void mutation();
	
	Vector2[] getGenes();
	
	Vector2 getCurrentGene();
}

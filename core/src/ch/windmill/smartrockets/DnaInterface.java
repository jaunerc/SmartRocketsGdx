package ch.windmill.smartrockets;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public interface DnaInterface {
	
	/**
	 * Choose genes randomly to mutate.
	 */
	void mutation();
	
	/**
	 * @return The list of genes.
	 */
	List<Vector2> getGenes();
	
	/**
	 * Gets the current gene from the iterator.
	 * @return The current gene.
	 */
	Vector2 getCurrentGene();
	
	/**
	 * Gets the gene at the given position in the list.
	 * @param index List position.
	 * @return Gene from the list.
	 */
	Vector2 getGeneAtPos(int index);
	
	/**
	 * @return The number of genes in the list.
	 */
	int getSize();
}

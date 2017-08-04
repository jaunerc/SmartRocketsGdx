package ch.windmill.smartrockets.industry;

import ch.windmill.smartrockets.entities.Dna;
import ch.windmill.smartrockets.entities.Rocket;

public interface RocketFactoryInterface {

	/**
	 * Creates a rocket with random dna genes.
	 * @return Random rocket.
	 */
	Rocket makeRocketWithRandomDna();
	
	Rocket makeRocketAtDefaultPosition(Dna dna);
}

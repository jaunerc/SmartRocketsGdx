package ch.windmill.smartrockets.industry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Dna;
import ch.windmill.smartrockets.entities.Rocket;
import ch.windmill.smartrockets.gdx.AppConfiguration;

public class RocketFactory implements RocketFactoryInterface{
	
	private final static float MAX_FORCE = 0.2f;
	private final static float START_POS_X = 500f;
	private final static float START_POS_Y = 0f;
	private final static int DNA_SIZE = 50;
	
	private VectorFactory vectorFactory;
	private AppConfiguration appConfig;
	
	public RocketFactory() {
		vectorFactory = new VectorFactory(MAX_FORCE);
		appConfig = AppConfiguration.fromConfigFile();
	}

	@Override
	public Rocket makeRocketWithRandomDna() {
		final Dna dna = new Dna(generateRandomGenes(appConfig.DNA_SIZE));
		final Rocket rocket = new Rocket(appConfig.ROCKET_START_POS_X, appConfig.ROCKET_START_POS_Y, dna);
		return rocket;
	}

	public List<Vector2> generateRandomGenes(final int numGenes) {
		if(numGenes <= 0) {
			throw new IllegalArgumentException("numGenes must be greater than zero.");
		}
		ArrayList<Vector2> genes = new ArrayList<>();
		for(int i = 0; i < numGenes; i++) {
			genes.add(vectorFactory.makeRandomVector());
		}
		return genes;
	}

	@Override
	public Rocket makeRocketAtDefaultPosition(final Dna dna) {
		return new Rocket(appConfig.ROCKET_START_POS_X, appConfig.ROCKET_START_POS_Y, dna);
	}
}

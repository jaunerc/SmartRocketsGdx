package ch.windmill.smartrockets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

/**
 * This class represents a mating pool for Rockets.
 */
public class MatingPool implements MatingPoolInterface {

	private int screenSize;
	private ArrayList<RocketInterface> pool;
	private Vector2 target;

	public MatingPool() {
		this(new Vector2(), 0);
	}

	public MatingPool(final Vector2 target, final int screenSize) {
		this.target = target;
		this.screenSize = screenSize;
		pool = new ArrayList<>();
	}

	@Override
	public void fillPool(final List<RocketInterface> rockets) {
		addRocketsBasedOnFitness(rockets);
	}

	private void addRocketsBasedOnFitness(final List<RocketInterface> rockets) {
		int rocketWeight = 0;
		float maxFitness = 0;
		for(RocketInterface rocket : rockets) {
			rocket.calcFitness(target);
			if(rocket.getFitness() > maxFitness) {
				maxFitness = rocket.getFitness();
			}
		}
		
		for(RocketInterface rocket : rockets) {
			rocket.setFitness(rocket.getFitness() / maxFitness);
			System.out.println("current fitness: " + rocket.getFitness());
		}
		System.out.println("maxFitness: " + maxFitness);
		
		for (RocketInterface rocket : rockets) {
			
			rocketWeight = (int) (rocket.getFitness() * 100);
			for (int i = 0; i < rocketWeight; i++) {
				pool.add(rocket);
			}
		}
	}

	@Override
	public RocketInterface getRandomRocket() {
		final Random random = new Random();
		return pool.get(random.nextInt(pool.size()));
	}

	@Override
	public void setRocketTarget(Vector2 target) {
		this.target = target;
	}

}

package ch.windmill.smartrockets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class MatingPool implements MatingPoolInterface {

	private ArrayList<RocketInterface> pool;
	private Vector2 target;
	
	public MatingPool() {
		this(new Vector2());
	}
	
	public MatingPool(final Vector2 target){
		this.target = target;
		pool = new ArrayList<>();
	}
	
	@Override
	public void fillPool(final List<RocketInterface> rockets) {
		addRocketsBasedOnFitness(rockets);
	}
	
	private void addRocketsBasedOnFitness(final List<RocketInterface> rockets) {
		int rocketWeight = 0;
		for(RocketInterface rocket : rockets) {
			rocket.calcFitness(target);
			rocketWeight = (int) (rocket.getFitness() * 1000);
			for(int i = 0; i < rocketWeight; i++) {
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

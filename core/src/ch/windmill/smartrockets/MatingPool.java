package ch.windmill.smartrockets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.windmill.smartrockets.interfaces.MatingPoolInterface;
import ch.windmill.smartrockets.interfaces.RocketInterface;

public class MatingPool implements MatingPoolInterface {

	private ArrayList<RocketInterface> pool;
	
	public MatingPool() {
		pool = new ArrayList<>();
	}
	
	@Override
	public void fillPool(final List<RocketInterface> rockets) {
		for(RocketInterface rocket : rockets) {
			pool.add(rocket);
		}
	}

	@Override
	public RocketInterface getRandomRocket() {
		final Random random = new Random();
		return pool.get(random.nextInt(pool.size()));
	}

}

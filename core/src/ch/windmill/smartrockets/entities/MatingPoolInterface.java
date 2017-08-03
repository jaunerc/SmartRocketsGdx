package ch.windmill.smartrockets.entities;

import java.util.List;

public interface MatingPoolInterface {

	void fillPool(List<RocketInterface> rockets);
	
	RocketInterface getRandomRocket();
}

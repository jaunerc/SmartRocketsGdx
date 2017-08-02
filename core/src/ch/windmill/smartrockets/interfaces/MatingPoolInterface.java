package ch.windmill.smartrockets.interfaces;

import java.util.List;

public interface MatingPoolInterface {

	void fillPool(List<RocketInterface> rockets);
	
	RocketInterface getRandomRocket();
}

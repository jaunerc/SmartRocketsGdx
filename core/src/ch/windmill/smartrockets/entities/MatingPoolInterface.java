package ch.windmill.smartrockets.entities;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public interface MatingPoolInterface {

	void fillPool(List<RocketInterface> rockets);
	
	RocketInterface getRandomRocket();
	
	void setRocketTarget(Vector2 target);
}

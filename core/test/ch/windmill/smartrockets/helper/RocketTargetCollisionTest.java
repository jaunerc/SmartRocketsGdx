package ch.windmill.smartrockets.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Dna;
import ch.windmill.smartrockets.entities.Rocket;
import ch.windmill.smartrockets.entities.RocketInterface;
import ch.windmill.smartrockets.entities.RocketTarget;

public class RocketTargetCollisionTest {

	private RocketInterface rocket;
	private RocketTarget target;
	private RocketTargetCollision collision;
	
	@Before
	public void setUp() {
		rocket = new Rocket(10, 10, new Dna());
		target = new RocketTarget(new Vector2(70, 70));
		collision = new RocketTargetCollision(rocket, target);
	}
	
	/**
	 * {@link RocketTargetCollision#isCollided()}
	 */
	@Test
	public void testCollision() {
		collision.calcExtraRocketVectors(60, 60);
		collision.setTargetsRadius(10);
		assertTrue(collision.isCollided());
	}
	
	/**
	 * {@link RocketTargetCollision#isCollided()}
	 */
	@Test
	public void testNoCollision() {
		collision.calcExtraRocketVectors(30, 30);
		collision.setTargetsRadius(10);
		assertFalse(collision.isCollided());
	}
}

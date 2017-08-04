package ch.windmill.smartrockets.entities;

import java.util.NoSuchElementException;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Rocket implements RocketInterface {

	private final static int TARGET_BOUNDARY = 10;
	private final static float MAX_VELOCITY = 4f;

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private Dna dna;
	private float fitness;
	private boolean crashed;
	private boolean completed;
	private boolean endOfDna;

	public Rocket(final float posX, final float posY, final Dna dna) {
		this.dna = dna;
		position = new Vector2(posX, posY);
		velocity = new Vector2();
		acceleration = new Vector2();
		fitness = 0f;
		crashed = false;
		completed = false;
		endOfDna = false;
	}

	public Rocket() {
		this(0, 0, new Dna());
	}

	@Override
	public boolean isCrashed() {
		return crashed;
	}

	@Override
	public boolean isCompleted() {
		return completed;
	}
	
	@Override
	public boolean isEndOfDna() {
		return endOfDna;
	}

	@Override
	public Dna getDna() {
		return dna;
	}

	@Override
	public float getFitness() {
		return fitness;
	}

	@Override
	public Vector2 getPos() {
		return position;
	}

	@Override
	public void calcFitness(final Vector2 target) {
		final float distanceToTarget = position.dst(target);
		fitness = 1 / distanceToTarget;
		if (completed) {
			fitness *= 10;
		}
		if (crashed) {
			fitness /= 10;
		}
	}

	@Override
	public void update(final float screenWidth, final float screenHeight, final Texture texture) {
		applyForce();
		handleBoundaries(screenWidth, screenHeight, texture);
	}

	private void applyForce() {
		if (!(completed || crashed)) {
			try {
				newtonsSecondLawOfMotion(dna.getCurrentGene());
				limitVelocity();
				acceleration.setZero();
			} catch (NoSuchElementException e) {
				endOfDna = true;
			}
		}
	}

	private void newtonsSecondLawOfMotion(final Vector2 force) {
		acceleration.add(force);
		velocity.add(acceleration);
		position.add(velocity);
	}

	private void limitVelocity() {
		if (velocity.len() > MAX_VELOCITY) {
			velocity.setLength(MAX_VELOCITY);
		}
	}

	private void handleBoundaries(float screenWidth, float screenHeight, Texture texture) {
		final Vector2 upperRightRocketCorner = new Vector2(position.x + texture.getWidth(),
				position.y + texture.getHeight());
		if (position.x <= 0 || position.y <= 0 || upperRightRocketCorner.x >= screenWidth
				|| upperRightRocketCorner.y >= screenHeight) {
			crashed = true;
		}
	}

	@Override
	public void handleTargetHit(final Vector2 target) {
		final float distanceToTarget = position.dst(target);
		if (distanceToTarget < 20) {
			completed = true;
		}
	}

}

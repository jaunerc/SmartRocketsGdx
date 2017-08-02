package ch.windmill.smartrockets;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.interfaces.RocketInterface;

public class Rocket implements RocketInterface {
	
	private final static int TARGET_BOUNDARY = 10;
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private Dna dna;
	private float fitness;
	private boolean crashed;
	private boolean completed;
	
	public Rocket(final float posX, final float posY, final Dna dna) {
		this.dna = dna;
		position = new Vector2(posX, posY);
		velocity = new Vector2();
		acceleration = new Vector2();
		fitness = 0f;
		crashed = false;
		completed = false;
	}
	
	public Rocket() {
		this(0, 0, new Dna());
	}

	@Override
	public void handleCollision(final Vector2 target) {
		final float distanceToTarget = position.dst(target);
		if(distanceToTarget < TARGET_BOUNDARY) {
			completed = true;
		}
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
	public void calcFitness(Vector2 target) {
		final float distanceToTarget = position.dst(target);
		fitness = distanceToTarget;
		if(completed) {
			fitness *= 10;
		}
		if(crashed) {
			fitness /= 10;
		}
	}

	@Override
	public void update() {
		applyForce();
	}

	private void applyForce() {
		if(!(completed || crashed)) {
			newtonsSecondLawOfMotion(dna.getCurrentGene());
			acceleration.setZero();
		}
	}
	
	private void newtonsSecondLawOfMotion(final Vector2 force) {
		acceleration.add(force);
		velocity.add(acceleration);
		position.add(velocity);
	}
}

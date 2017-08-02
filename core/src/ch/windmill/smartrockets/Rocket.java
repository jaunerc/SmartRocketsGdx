package ch.windmill.smartrockets;

import com.badlogic.gdx.math.Vector2;

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

	private void applyForce(final Vector2 force) {
		if(!(completed || crashed)) {
			final Vector2 ff = dna.getCurrentGene();
			newtonsSecondLawOfMotion(ff);
			acceleration.setZero();
		}
	}
	
	private void newtonsSecondLawOfMotion(final Vector2 force) {
		acceleration.add(force);
		velocity.add(acceleration);
		position.add(velocity);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int geneIndex) {
		// TODO Auto-generated method stub
		
	}
}

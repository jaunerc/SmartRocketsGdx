package ch.windmill.smartrockets;

import com.badlogic.gdx.math.Vector2;

public class Rocket implements RocketInterface {
	
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
		// TODO Auto-generated method stub

	}

	private void applyForce(final Vector2 force) {
		// TODO Auto-generated method stub

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

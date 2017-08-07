package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Barrier implements BarrierInterface {

	private final static String TEXTURE_NAME = "barrier.png";
	
	private Vector2 position;
	private Texture barrierTexture;

	public Barrier() {
		this(new Vector2());
	}
	
	public Barrier(final Vector2 position) {
		this.position = position;
		barrierTexture = null;
	}
	
	@Override
	public void initTexture() {
		barrierTexture = new Texture(Gdx.files.internal(TEXTURE_NAME));
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(barrierTexture, position.x, position.y, 200, 50);
		
	}

	@Override
	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	@Override
	public Texture getTexture() {
		return barrierTexture;
	}
	

}

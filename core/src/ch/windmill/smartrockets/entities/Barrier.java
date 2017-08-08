package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Barrier implements BarrierInterface {

	private final static String TEXTURE_NAME = "barrier.png";
	
	private Vector2 position;
	private Texture barrierTexture;
	private Sprite barrierSprite;

	public Barrier() {
		this(new Vector2());
	}
	
	public Barrier(final Vector2 position) {
		this.position = position;
		barrierTexture = null;
		barrierSprite = null;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public Sprite getBarrierSprite() {
		return barrierSprite;
	}

	@Override
	public void initTexture() {
		barrierTexture = new Texture(Gdx.files.internal(TEXTURE_NAME));
		barrierSprite = new Sprite(barrierTexture);
		barrierSprite.setPosition(position.x, position.y);
		barrierSprite.setScale(12, 1);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		barrierSprite.draw(batch);
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

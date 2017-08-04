package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class RocketTarget {
	
	private final static String TEXTURE_NAME = "target.png";

	private Vector2 centerPosition;
	private Texture texture;
	
	public RocketTarget(final Vector2 centerPosition) {
		this.centerPosition = centerPosition;
		texture = null;
	}
	
	public void initTexture() {
		texture = new Texture(Gdx.files.internal(TEXTURE_NAME));
	}
	
	public Vector2 getCenterPosition() {
		return centerPosition;
	}
	
	public void draw(final SpriteBatch batch) {
		batch.draw(texture, centerPosition.x - 25, centerPosition.y - 25);
	}
}

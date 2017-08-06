package ch.windmill.smartrockets.helper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * This class represents a manager for all ingame sprites.
 */
public class SpriteManager {

	private Sprite rocketSprite;
	private Sprite targetSprite;
	
	public SpriteManager() {
		rocketSprite = null;
		targetSprite = null;
	}
	
	public SpriteManager(final Texture rocketTexture, final Texture targetTexture) {
		rocketSprite = new Sprite(rocketTexture);
		targetSprite = new Sprite(targetTexture);
	}

	public Sprite getRocketSprite() {
		return rocketSprite;
	}

	public Sprite getTargetSprite() {
		return targetSprite;
	}
	
	public void createRocketSprite(final Texture rocketTexture) {
		rocketSprite = new Sprite(rocketTexture);
	}
	
	public void createTargetSprite(final Texture targetTexture) {
		targetSprite = new Sprite(targetTexture);
	}
	
	public void setTargetSpritePosition(final Vector2 center) {
		targetSprite.setCenter(center.x, center.y);
	}
}

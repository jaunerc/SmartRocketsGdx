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
	private Sprite barrierSprite;
	
	public SpriteManager() {
		rocketSprite = null;
		targetSprite = null;
		barrierSprite = null;
	}
	
	public SpriteManager(final Texture rocketTexture, final Texture targetTexture, final Texture barrierTexture) {
		rocketSprite = new Sprite(rocketTexture);
		targetSprite = new Sprite(targetTexture);
		barrierSprite  = new Sprite(barrierTexture);
	}

	public Sprite getRocketSprite() {
		return rocketSprite;
	}

	public Sprite getTargetSprite() {
		return targetSprite;
	}
	
	public Sprite getBarrierSprite() {
		return barrierSprite;
	}
	
	public void setBarrierSprite(Sprite barrierSprite) {
		this.barrierSprite = barrierSprite;
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

package ch.windmill.smartrockets.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface BarrierInterface {

	void draw(SpriteBatch batch);
	
	void setPosition(float x, float y);

	void initTexture();
	
	Texture getTexture();
}

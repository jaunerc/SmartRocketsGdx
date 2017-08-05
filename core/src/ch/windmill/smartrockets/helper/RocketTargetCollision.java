package ch.windmill.smartrockets.helper;

import com.badlogic.gdx.math.Vector2;

import ch.windmill.smartrockets.entities.Rocket;
import ch.windmill.smartrockets.entities.RocketInterface;
import ch.windmill.smartrockets.entities.RocketTarget;

public class RocketTargetCollision {

	private RocketInterface rocket;
	private RocketTarget target;
	private Vector2 rocketsCenter;
	private Vector2 rocketsUpperRightCorner;
	private float targetsRadius;
	
	public RocketTargetCollision() {
		this(new Rocket(), new RocketTarget(new Vector2()));
	}

	public RocketTargetCollision(RocketInterface rocket, RocketTarget target) {
		this.rocket = rocket;
		this.target = target;
		rocketsCenter = new Vector2();
		rocketsUpperRightCorner = new Vector2();
		targetsRadius = 0f;
	}

	public void setRocket(RocketInterface rocket) {
		this.rocket = rocket;
	}

	public void setTarget(RocketTarget target) {
		this.target = target;
	}

	public void calcExtraRocketVectors(final float rocketWidth, final float rocketHeight) {
		calcRocketsCenter(rocketWidth, rocketHeight);
		calcRocketsUpperRightCorner(rocketWidth, rocketHeight);
	}

	private void calcRocketsCenter(final float rocketWidth, final float rocketHeight) {
		rocketsCenter = new Vector2(rocket.getPos());
		rocketsCenter.add(rocketWidth / 2, rocketHeight / 2);
	}

	private void calcRocketsUpperRightCorner(final float rocketWidth, final float rocketHeight) {
		rocketsUpperRightCorner = new Vector2(rocket.getPos());
		rocketsUpperRightCorner.add(rocketWidth, rocketHeight);
	}

	public void setTargetsRadius(float targetsRadius) {
		this.targetsRadius = targetsRadius;
	}

	public boolean isCollided() {
		boolean result = false;

		final Vector2 distance = new Vector2(rocketsCenter).sub(target.getCenterPosition());
		final Vector2 closest = new Vector2();
		final float x_extent = (rocketsUpperRightCorner.x - rocket.getPos().x) / 2;
		final float y_extent = (rocketsUpperRightCorner.y - rocket.getPos().y) / 2;

		closest.set(RocketMath.clamp(distance.x, -x_extent, x_extent),
				RocketMath.clamp(distance.y, -y_extent, y_extent));

		final Vector2 indicator = new Vector2(distance).sub(closest);
		if (indicator.len2() <= targetsRadius * targetsRadius) {
			result = true;
		}

		return result;
	}
}

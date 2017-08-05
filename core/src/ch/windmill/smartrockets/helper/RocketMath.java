package ch.windmill.smartrockets.helper;

public class RocketMath {

	private RocketMath() {
		
	}
	
	public static float clamp(float d, float min, float max) {
        return (d < min ? min : (d > max ? max : d));
    }
}

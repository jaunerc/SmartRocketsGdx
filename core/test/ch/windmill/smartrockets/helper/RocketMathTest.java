package ch.windmill.smartrockets.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class RocketMathTest {

	/**
	 * {@link RocketMath#clamp(float, float, float)}
	 */
	@Test
	public void testClampWithLowNumber() {
		assertEquals(-10f, RocketMath.clamp(-15f, -10f, 10f), 0.1f);
	}

	/**
	 * {@link RocketMath#clamp(float, float, float)}
	 */
	@Test
	public void testClampWithHighNumber() {
		assertEquals(10f, RocketMath.clamp(15f, -10f, 10f), 0.1f);
	}
	
	/**
	 * {@link RocketMath#clamp(float, float, float)}
	 */
	@Test
	public void testClampWithMidNumber() {
		assertEquals(5f, RocketMath.clamp(5f, -10f, 10f), 0.1f);
	}
}

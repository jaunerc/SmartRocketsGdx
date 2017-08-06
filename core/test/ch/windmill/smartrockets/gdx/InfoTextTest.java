package ch.windmill.smartrockets.gdx;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfoTextTest {

	private final static int TEST_POP_SIZE = 10;
	private final static int TEST_DNA_SIZE = 500;
	
	private InfoText infoText;
	
	@Before
	public void setUp() {
		infoText = new InfoText(TEST_POP_SIZE, TEST_DNA_SIZE);
	}

	/**
	 * {@link InfoText#getPopulationSizeInfo()}
	 */
	@Test
	public void testPopulationInfoText() {
		assertTrue(infoText.getPopulationSizeInfo().equals("Population size: " + TEST_POP_SIZE));
	}


	/**
	 * {@link InfoText#getDnaSizeInfo()}
	 */
	@Test
	public void testDnaInfoText() {
		assertTrue(infoText.getDnaSizeInfo().equals("DNA size: " + TEST_DNA_SIZE));
	}
}

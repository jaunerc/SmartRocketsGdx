package ch.windmill.smartrockets.gdx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InfoText {

	private String populationSizeInfo;
	private String dnaSizeInfo;
	private BitmapFont font;
	
	public InfoText() {
		this(0, 0);
	}

	public InfoText(final int populationSize, final int dnaSize) {
		makePopulationInfo(populationSize);
		makeDnaInfo(dnaSize);
	}
	
	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public void makePopulationInfo(final int populationSize) {
		populationSizeInfo = "Population size: " + populationSize;
	}

	public void makeDnaInfo(final int dnaSize) {
		dnaSizeInfo = "DNA size: " + dnaSize;
	}

	public String getPopulationSizeInfo() {
		return populationSizeInfo;
	}

	public String getDnaSizeInfo() {
		return dnaSizeInfo;
	}
	
	public void draw(final SpriteBatch batch, final float viewportWidth, final float viewportHeight) {
		if(font != null) {
			final float x = viewportWidth / 8;
			float y = viewportHeight / 8;
			font.draw(batch, populationSizeInfo, x, y);
			y -= font.getLineHeight();
			font.draw(batch, dnaSizeInfo, x, y);
		}
	}
}

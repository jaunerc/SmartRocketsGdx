package gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import ch.windmill.smartrockets.MatingPool;
import ch.windmill.smartrockets.MatingPoolInterface;
import ch.windmill.smartrockets.PopulationInterface;

public class RocketScreen implements Screen {
	
	private final static int VIEWPORT_WIDTH = 100;
	private final static int VIEWPORT_HEIGHT = 100;
	
	private final SmartRocketsGame game;
	private OrthographicCamera camera;
	
	public RocketScreen(final SmartRocketsGame game) {
		this.game = game;
		initCamera();
	}
	
	private void initCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		clearScreen();
		updateCamera();
		game.updateRockets();
		renderWithSpriteBatch();
	}
	
	private void clearScreen() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
	}
	
	private void updateCamera() {
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
	}
	
	private void renderWithSpriteBatch() {
		game.batch.begin();
		game.renderRockets();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
 
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

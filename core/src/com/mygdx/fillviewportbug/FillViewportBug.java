package com.mygdx.fillviewportbug;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FillViewportBug extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Stage stage;
	private Texture bannerLeftTexture;
	private Texture bannerRightTexture;
	private Viewport fitViewport;

	@Override
	public void create () {
		Viewport fillViewport = new FillViewport(1280, 720);
		stage = new Stage(fillViewport);

		bannerLeftTexture = new Texture("banner_left.jpg");
		bannerRightTexture = new Texture("banner_right.jpg");
		Image bannerLeftImage = new Image(bannerLeftTexture);
		bannerLeftImage.setPosition(0, 0);
		stage.addActor(bannerLeftImage);
		Image bannerRightImage = new Image(bannerRightTexture);
		bannerRightImage.setPosition(stage.getWidth() - bannerRightTexture.getWidth(), 0);
		stage.addActor(bannerRightImage);

		OrthographicCamera camera = new OrthographicCamera(720, 1280);
		camera.setToOrtho(false, 720, 1280);
		fitViewport = new FitViewport(720, 1280, camera);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(fitViewport.getCamera().combined);
		fitViewport.apply();
		batch.begin();
		batch.draw(img, fitViewport.getWorldWidth() / 2 - img.getWidth() / 2f,
				fitViewport.getWorldHeight() / 2 - img.getHeight() / 2f);
		batch.end();

		stage.getViewport().apply();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		fitViewport.update(width, height, true);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		bannerLeftTexture.dispose();
		bannerRightTexture.dispose();
	}
}

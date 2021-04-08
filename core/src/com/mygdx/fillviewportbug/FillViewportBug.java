package com.mygdx.fillviewportbug;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FillViewportBug extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture bannerLeftTexture;
	private Texture bannerRightTexture;
	private Viewport fitViewport;
	private Viewport fillViewport;

	@Override
	public void create () {
		fillViewport = new FillViewport(1280, 720);

		fitViewport = new FitViewport(720, 1280);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		bannerLeftTexture = new Texture("banner_left.jpg");
		bannerRightTexture = new Texture("banner_right.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Draw "game" area
		fitViewport.apply();
		batch.setProjectionMatrix(fitViewport.getCamera().combined);
		batch.begin();
		batch.draw(img, fitViewport.getWorldWidth() / 2 - img.getWidth() / 2f,
				fitViewport.getWorldHeight() / 2 - img.getHeight() / 2f);
		batch.end();

		// Draw "banner" down sides
		fillViewport.apply();
		batch.setProjectionMatrix(fillViewport.getCamera().combined);
		batch.begin();
		batch.draw(bannerLeftTexture, 0, 0, fillViewport.getWorldWidth(), fillViewport.getWorldHeight());
//		batch.draw(bannerRightTexture, fillViewport.getWorldWidth() - bannerRightTexture.getWidth(), 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		fitViewport.update(width, height, true);
		fillViewport.update(width, height, true);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		bannerLeftTexture.dispose();
		bannerRightTexture.dispose();
	}
}

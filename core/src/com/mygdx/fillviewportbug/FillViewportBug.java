package com.mygdx.fillviewportbug;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FillViewportBug extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture bannerTexture;
	private Viewport fillViewport;

	@Override
	public void create () {
		fillViewport = new FillViewport(1280, 720);

		batch = new SpriteBatch();

		bannerTexture = new Texture("banner.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(fillViewport.getCamera().combined);
		batch.begin();
		batch.draw(bannerTexture, 0, 0, fillViewport.getWorldWidth(), fillViewport.getWorldHeight());
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		fillViewport.update(width, height, true);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bannerTexture.dispose();
	}
}

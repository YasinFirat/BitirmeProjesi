package com.pixempires.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixempires.game.states.MenuState;
import com.pixempires.game.states.StateManager;

public class PixEmpires extends ApplicationAdapter {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	SpriteBatch sprite_batch;

	private static StateManager state_manager;
	
	@Override
	public void create () {
		state_manager=new StateManager();
		sprite_batch=new SpriteBatch();
		state_manager.push(new MenuState(state_manager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		state_manager.render(sprite_batch);
		state_manager.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		sprite_batch.dispose();
	}
}

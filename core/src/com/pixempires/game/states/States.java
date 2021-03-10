package com.pixempires.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class States {
    public abstract void create();
    public abstract void render(SpriteBatch sprite_batch);
    public abstract void update(float delta);
}

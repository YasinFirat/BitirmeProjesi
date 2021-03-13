package com.pixempires.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pixempires.game.PixEmpires;

public class PlayState extends State {
    private TextureRegion back_ground_reg;
    public PlayState(StateManager state_manager) {
        super(state_manager);
        Texture back_ground=new Texture("map_1.png");
        back_ground_reg=new TextureRegion(back_ground);
        camera.setToOrtho(false,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);
    }
    public void create() {

    }
    public void render(SpriteBatch sprite_batch) {
        sprite_batch.setProjectionMatrix(camera.combined);
        sprite_batch.begin();
        sprite_batch.draw(back_ground_reg,0,0,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);

        sprite_batch.end();
    }
    public void update(float delta) {

    }

    protected void handleInput() {

    }
    public void dispose() {

    }
}

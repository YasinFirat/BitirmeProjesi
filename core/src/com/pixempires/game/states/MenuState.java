package com.pixempires.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.PixEmpires;
import com.pixempires.game.buttons.Button;
import com.pixempires.game.buttons.StartButton;

public class MenuState extends State {
    private StartButton button_start;
    private Texture texture;
    private Vector2 touch_position;
    public MenuState(StateManager state_manager) {
        super(state_manager);
        //camera.setToOrtho(false, PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);
        texture=new Texture("btn_attack.png");
        button_start=new StartButton(new Vector2(10,10),new TextureRegion(texture));
    }


    public void create() {

    }
    public void render(SpriteBatch sprite_batch) {
        //sprite_batch.setProjectionMatrix(camera.combined);
        button_start.render(sprite_batch);
    }
    public void update(float delta) {
        handleInput();

    }

    protected void handleInput() {
        if(Gdx.input.justTouched()){
            touch_position=new Vector2(Gdx.input.getX(),Gdx.input.getY());
            button_start.openNewState(state_manager,touch_position);
        }
    }
    public void dispose() {
        texture.dispose();
    }
}

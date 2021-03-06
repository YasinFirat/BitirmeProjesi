package com.pixempires.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pixempires.game.GameWorld;
import com.pixempires.game.PixEmpires;
import com.pixempires.game.animations.Animation;

public class PlayState extends State {

    private GameWorld gameWorld;


    private TextureRegion back_ground_reg;
    private TextureRegion[] archers=new TextureRegion[4];
    private Animation archer_animation;



    public PlayState(StateManager state_manager) {
        super(state_manager);
        gameWorld=new GameWorld();


        Texture back_ground=new Texture("map_3.png");

        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");
        back_ground_reg=new TextureRegion(back_ground);

        camera.setToOrtho(false,PixEmpires.WIDTH,PixEmpires.HEIGHT);

    }
    public void create() {


    }
    public void render(SpriteBatch sprite_batch) {

        sprite_batch.setProjectionMatrix(camera.combined);



        sprite_batch.begin();

        sprite_batch.draw(back_ground_reg,0,0,PixEmpires.WIDTH,PixEmpires.HEIGHT);

        sprite_batch.end();

        gameWorld.render(sprite_batch);

    }
    public void update(float delta) {
        gameWorld.update(delta);
    }

    protected void handleInput() {

    }
    public void dispose() {

    }
}

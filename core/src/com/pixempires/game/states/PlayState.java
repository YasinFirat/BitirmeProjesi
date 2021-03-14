package com.pixempires.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pixempires.game.PixEmpires;
import com.pixempires.game.sprites.SpriteLoader;

public class PlayState extends State {
    private TextureRegion back_ground_reg;
    private TextureRegion[] archers=new TextureRegion[4];
    private SpriteLoader archer;
    public PlayState(StateManager state_manager) {
        super(state_manager);
        Texture back_ground=new Texture("map_1.png");
        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");
        back_ground_reg=new TextureRegion(back_ground);
        archer=new SpriteLoader(archer_tex)
                .Split1D(0,0,128,128,14,180).circleTime(.5f);
        camera.setToOrtho(false,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);
    }
    public void create() {

    }
    public void render(SpriteBatch sprite_batch) {
        sprite_batch.setProjectionMatrix(camera.combined);
        sprite_batch.begin();
        sprite_batch.draw(back_ground_reg,0,0,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);
        sprite_batch.draw(archer.getFrame(),100,130);
        sprite_batch.draw(archer.getFrame(),100,100);
        sprite_batch.end();
    }
    public void update(float delta) {
        archer.update(delta);
    }

    protected void handleInput() {

    }
    public void dispose() {

    }
}

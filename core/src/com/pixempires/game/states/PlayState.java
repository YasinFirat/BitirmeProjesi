package com.pixempires.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.PixEmpires;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.Arrow;
import com.pixempires.game.gameobjects.Component;
import com.pixempires.game.gameobjects.GameObject;

public class PlayState extends State {

    private GameWorld gameWorld;


    private TextureRegion back_ground_reg;
    private TextureRegion[] archers=new TextureRegion[4];
    private Animation archer;
    private Component<Animation> ar;
    private GameObject arrow;

    public PlayState(StateManager state_manager) {
        super(state_manager);
        gameWorld=new GameWorld();


        Texture back_ground=new Texture("map_1.png");
        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");
        back_ground_reg=new TextureRegion(back_ground);
        archer=new Animation(archer_tex)
                .Split1D(45,37,46,39,9,180).circleTime(1f).setPosition(100,100);
        camera.setToOrtho(false,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);
        arrow=new Arrow();

    }
    public void create() {


    }
    public void render(SpriteBatch sprite_batch) {

        sprite_batch.setProjectionMatrix(camera.combined);



        sprite_batch.begin();

        sprite_batch.draw(back_ground_reg,0,0,PixEmpires.WIDTH/2,PixEmpires.HEIGHT/2);



      //  sprite_batch.draw(archer.getFrame(),100,100);
        sprite_batch.end();
        archer.render(sprite_batch);
        arrow.render(sprite_batch);


        gameWorld.render(sprite_batch);

    }
    public void update(float delta) {
        archer.update(delta);

        if(archer.GetIsLastFrame()){
            arrow.setPosition(115,123);
        }else{
            System.out.println(delta);
            arrow.move(new Vector2(1,0),200*delta);
        }



    }

    protected void handleInput() {

    }
    public void dispose() {

    }
}

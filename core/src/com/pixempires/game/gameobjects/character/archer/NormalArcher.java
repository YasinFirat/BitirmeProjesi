package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.other.CommandPositions;

public class NormalArcher extends Archer {


    public NormalArcher(GameWorld game_world){
        this();
        this.game_world=game_world;
        setCommandPositions(game_world.getPlayerCommandPositions());
        setPosition(getCommandPositions().getBackoff_position().x,getCommandPositions().getBackoff_position().y);

    }

    public NormalArcher() {
        super();
        System.out.println("NormaArcher");
        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");

        setAnimation(new Animation(archer_tex)
                .Split1D(45,37,46,39,9,180)
                .circleTime(1f)
                .setPosition(-(int)(Math.random()*10),(int)(Math.random()*100+200))
        );
    }

    public NormalArcher(Texture texture) {
        super(texture);
    }

    public NormalArcher(Texture texture, int begin_x, int
            begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }

    @Override
    public void render(SpriteBatch sprite_batch) {
        getAnimation().render(sprite_batch);
    }
    @Override
    public void update(float delta) {
        getAnimation().update(delta);
        switch (game_world.getCommand()){
            case attack:
                move(getAnimation().getPosition(),getCommandPositions().getAttack_position(),getSpeed(),1);
                break;
            case defance:
                move(getAnimation().getPosition(),getCommandPositions().getDefance_position(),getSpeed(),1);
                break;
            case backoff:
                move(getAnimation().getPosition(),getCommandPositions().getBackoff_position(),getSpeed(),1);
                break;
        }
        getAnimation().setPosition(getPosition());
    }
    @Override
    public void dispose() {

    }
}

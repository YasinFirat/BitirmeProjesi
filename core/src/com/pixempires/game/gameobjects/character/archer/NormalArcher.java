package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.other.CommandPositions;

public class NormalArcher extends Archer {
    public NormalArcher() {
        super();

    }
    public NormalArcher(GameWorld game_world, CommandPositions command_positions,boolean flibX){
        super(game_world,command_positions);
        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");

        setAnimation(new Animation(archer_tex)
                .split1D(45,37,46,39,9,180,flibX)
                .circleTime(1f)
        );

        setScale(50,50);
        getAttack().setAttackDistance(50);
        getAttack().setDamage(1);
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
        /*ShapeRenderer shapeRenderer=new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1,0,0,1);
        shapeRenderer.line(getPosition(),new Vector2(getPosition().x+getAttack().getAttackDistance(),getPosition().y));
        shapeRenderer.setColor(0,1,0,1);
        shapeRenderer.circle(getPosition().x,getPosition().y,getAttack().getAttackDistance());

        shapeRenderer.end();*/
    }
    @Override
    public void update(float delta) {
        getAnimation().update(delta);
        switch (game_world.getPlayerCommand()){
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

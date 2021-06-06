package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.other.CommandPositions;

/**
 * Oyunda korunması gereken obje, eger bu obje ka ybedilirse oyunda kaybedilir.(Simdilik heykel olarak gorev yapacak.)
 */
public  class Statue extends Soldier {
    public Statue(GameWorld game_world, CommandPositions command_positions,boolean isLookRight) {
        super(game_world, command_positions,isLookRight);
    }

    public Statue() {
        setSprite(new Texture("castle_1.png"));
        setScale(80,200);
    }

    public Statue(Texture texture) {
        super(texture);
    }

    public Statue(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }

    @Override
    public Soldier setCommandPositions(CommandPositions commandPositions) {
       // setPosition(commandPositions.getBackoff_position());
        position=commandPositions.getBackoff_position();
        return super.setCommandPositions(commandPositions);

    }

    @Override
    public void render(SpriteBatch sprite_batch) {
        sprite_batch.begin();
        sprite_batch.draw(getSprite(),getPosition().x-scale.x/2,getPosition().y-scale.y/2,scale.x,scale.y);
        sprite_batch.end();
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

    }

    @Override
    public void dispose() {

    }



    @Override
    public void attackRightAnimation() {

    }

    @Override
    public void runRightAnimation() {

    }

    @Override
    public void idleRightAnimation() {

    }

    @Override
    public void dieRightAnimation() {

    }

    @Override
    public void hurtRightAnimation() {

    }

    @Override
    public void attackLeftAnimation() {

    }

    @Override
    public void runLeftAnimation() {

    }

    @Override
    public void idleLeftAnimation() {

    }

    @Override
    public void dieLeftAnimation() {

    }

    @Override
    public void hurtLeftAnimation() {

    }

}

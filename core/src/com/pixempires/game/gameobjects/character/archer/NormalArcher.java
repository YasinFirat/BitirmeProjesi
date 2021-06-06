package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.assetManagers.Assets;
import com.pixempires.game.other.CommandPositions;

public class NormalArcher extends Archer {
    public NormalArcher() {
        super();

    }
    public NormalArcher(GameWorld game_world, CommandPositions command_positions,boolean isLookRight){
        super(game_world,command_positions,isLookRight);


        setScale(100,100);
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
        super.update(delta);
    }

    @Override
    public void dispose() {

    }
    @Override
    public void attackRightAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_attack_right);
    }

    @Override
    public void runRightAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_run_right);
    }

    @Override
    public void idleRightAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_idle_right);
    }

    @Override
    public void dieRightAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_die_right);
    }

    @Override
    public void hurtRightAnimation() {

    }

    @Override
    public void attackLeftAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_attack_left);
    }

    @Override
    public void runLeftAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_run_left);
    }

    @Override
    public void idleLeftAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_idle_left);
    }

    @Override
    public void dieLeftAnimation() {
        getAnimation().setSprite(Assets.sprite_warrior_die_left);
    }

    @Override
    public void hurtLeftAnimation() {

    }

}

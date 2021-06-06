package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.pixempires.game.GameWorld;
import com.pixempires.game.animations.ISoldierAnimations;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.other.CommandPositions;
import com.pixempires.game.skills.Attack;

public abstract class Soldier extends Character implements ISoldierAnimations {

    protected Attack attack= new Attack();
    protected CommandPositions command_positions;
    public Soldier(GameWorld game_world,CommandPositions command_positions,boolean isLookRight){
        
        this.game_world=game_world;
        this.command_positions=command_positions;
        getAnimation().isLookRight=isLookRight;
        runRightAnimation();

        setPosition(getCommandPositions().getBackoff_position().x,getCommandPositions().getBackoff_position().y);
    }

    public Soldier(){
        super();
    }
    public Soldier(Texture texture){
        super(texture);
    }
    public Soldier(Texture texture,int begin_x,int begin_y,int width,int heigth) {
        super(texture,begin_x,begin_y,width,heigth);
    }
    public Attack getAttack(){
        return  attack;
    }
    public Soldier setAttack(Attack attack){
        this.attack=attack;
        return this;
    }

    @Override
    public GameObject setScale(int x, int y) {
        getAnimation().setScale(x,y);
        return super.setScale(x, y);
    }

    @Override
    public GameObject setScale(Vector2 scale) {
        getAnimation().setScale(scale);
        return super.setScale(scale);
    }

    public CommandPositions getCommandPositions() {
        return command_positions;
    }

    public Soldier setCommandPositions(CommandPositions commandPositions) {
        this.command_positions = commandPositions;
        return this;
    }

    /**
     *Attack kontrolu yapilir
     * @param soldier
     * @param distance
     * @return
     */
    public boolean checkAttack(Soldier soldier, float distance){

        if(distance<=getAttack().getAttackDistance()){

            System.out.println("Yeterince yaklaştın ateş et. Mesafe : " + distance);
            getAttack().setIsAttacking(true);

            soldier.getHealth().subtractHealth(getAttack().getDamage());
            if(soldier.getHealth().isHealthFinish()){
                getAttack().setIsAttacking(false);
            }
            return true;
        }
        else{
            getAttack().setIsAttacking(false);
            System.out.println( "Uzaksın");

            return false;
        }

    }

    @Override
    public void update(float delta) {
        getAnimation().update(delta);

        switch (game_world.getPlayerCommand()){
            case attack:
                move(getAnimation().getPosition(),getCommandPositions().getAttack_position(),movement.speed,1);
                break;
            case defance:

                move(getAnimation().getPosition(),getCommandPositions().getDefance_position(),movement.speed,1);
                break;
            case backoff:
                move(getAnimation().getPosition(),getCommandPositions().getBackoff_position(),movement.speed,1);
                break;
        }
        getAnimation().setPosition(getPosition());
        System.out.println("Attacking : " + getAttack().getIsAttacking());
        if(getAttack().getIsAttacking()){
            attackRightAnimation();
           movement.speed=0;
            return;
        }
        movement.speed=1;

        if(movement.is_move){
            movement.speed=1;

            if(movement.x_direction==-1){
                runLeftAnimation();

            }else{
                runRightAnimation();
            }
        }
        else{
            if(!getAnimation().isLookRight)
                idleRightAnimation();
            else
                idleLeftAnimation();
        }
    }
}

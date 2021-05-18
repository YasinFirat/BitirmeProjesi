package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.other.CommandPositions;
import com.pixempires.game.skills.Attack;

public abstract class Soldier extends Character {

    protected Attack attack= new Attack();
    protected CommandPositions command_positions;
    public Soldier(GameWorld game_world,CommandPositions command_positions){
        
        this.game_world=game_world;
        this.command_positions=command_positions;
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
    public Soldier checkAttack(Soldier soldier, float distance){

        if(distance<=getAttack().getAttackDistance()){

            System.out.println("Yeterince yaklaştın ateş et. Mesafe : " + distance);
            soldier.getHealth().subtractHealth(getAttack().getDamage());
        }
        return this;

    }


}

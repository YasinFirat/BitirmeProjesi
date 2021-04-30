package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.other.CommandPositions;
import com.pixempires.game.skills.Attack;

public abstract class Soldier extends Character {
    private Attack attack;
    private CommandPositions commandPositions;

    public Soldier(){
        super();
        System.out.println("Soldier ");
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

    public CommandPositions getCommandPositions() {
        return commandPositions;
    }

    public Soldier setCommandPositions(CommandPositions commandPositions) {
        this.commandPositions = commandPositions;
        return this;
    }
}

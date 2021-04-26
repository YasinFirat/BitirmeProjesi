package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.skills.Attack;

public abstract class Soldier extends Character {
    private Attack attack;

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
}

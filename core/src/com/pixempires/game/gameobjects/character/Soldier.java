package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.skills.Attack;

public abstract class Soldier extends Character {
    public Attack attack;

    public Soldier(){
        super();
    }
    public Soldier(Texture texture){
        super(texture);
    }
    public Soldier(Texture texture,int begin_x,int begin_y,int width,int heigth) {
        super(texture,begin_x,begin_y,width,heigth);
    }
}

package com.pixempires.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;

public abstract class Soldier extends Character {
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

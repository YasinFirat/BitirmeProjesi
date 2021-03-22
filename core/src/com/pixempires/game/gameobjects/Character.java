package com.pixempires.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;

public abstract class Character extends GameObject {

    public Character(){
        super();
    }
    public Character(Texture texture){
        super(texture);
    }
    public Character(Texture texture,int begin_x,int begin_y,int width,int heigth) {
        super(texture,begin_x,begin_y,width,heigth);
    }
}

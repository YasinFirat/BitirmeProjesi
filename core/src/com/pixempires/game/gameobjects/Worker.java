package com.pixempires.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;

public abstract class Worker extends Character {

    public Worker(){
        super();
    }
    public Worker(Texture texture){
        super(texture);
    }
    public Worker(Texture texture,int begin_x,int begin_y,int width,int heigth) {
        super(texture,begin_x,begin_y,width,heigth);
    }
}

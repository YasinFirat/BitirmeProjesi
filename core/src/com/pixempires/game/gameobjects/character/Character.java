package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.skills.Health;

import java.awt.Rectangle;

public abstract class Character extends GameObject {

    private Health health=new Health();
    private Animation animation=new Animation();


    public Character(){
        super();
    }
    public Character(Texture texture){
        super(texture);
    }
    public Character(Texture texture,int begin_x,int begin_y,int width,int heigth) {
        super(texture,begin_x,begin_y,width,heigth);
    }
    public Character setHealth(Health health){
        this.health=health;
        return this;
    }
    public Health getHealth(){
        return health;
    }
    public Animation getAnimation() {
        return animation;
    }
    public Character setAnimation(Animation animation) {
        this.animation = animation;
        return this;
    }


}

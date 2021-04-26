package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.skills.Health;

public abstract class Character extends GameObject {

    private Health health=new Health();
    private Animation animation;

    public Character(){
        super();
        System.out.println("Character ");
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

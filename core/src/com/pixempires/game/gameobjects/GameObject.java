package com.pixempires.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 *
 */
public abstract class GameObject {
    protected Texture texture;
    protected TextureRegion sprite;
    protected Vector2 position;
    protected Vector2 scale;



    public GameObject(Texture texture,int begin_x,int begin_y,int width,int heigth){
        this.texture=texture;
        sprite=new TextureRegion(texture,begin_x,begin_y,width,heigth);
        position=new Vector2(100,150);
        scale=new Vector2(width,heigth);
    }
    protected GameObject(Texture texture){
        this.texture=texture;
        sprite=new TextureRegion(texture);
        position=new Vector2(100,150);
        scale=new Vector2(texture.getWidth(),texture.getHeight());
    }

    protected GameObject() {
    }

    public Vector2 getScale() {
        return scale;
    }
    public GameObject setScale(Vector2 scale) {
        this.scale = scale;
        return this;
    }
    public GameObject setScale(int x,int y) {
        this.scale.x = x;
        this.scale.y= y;
        return this;
    }
    public Vector2 getPosition() {
        return position;
    }
    public GameObject setPosition(Vector2 position) {
        this.position.x=position.x-scale.x/2;
        this.position.y=position.y-scale.y/2;
        return this;
    }
    public GameObject setPosition(float x,float y) {

        this.position.x = x-scale.x/2;
        this.position.y = y-scale.y/2;
        return this;
    }
    public GameObject move(Vector2 direction,float speed){
        position.x+=direction.x*speed;
        position.y+=direction.y*speed;
        return this;
    }





    public void render(SpriteBatch sprite_batch){
        sprite_batch.begin();
        sprite_batch.draw(sprite,getPosition().x,getPosition().y,getScale().x,getScale().y);
        sprite_batch.end();
    }
    public TextureRegion getTextureRegion(){
        return sprite;
    }
    public  void update(){

    }
}

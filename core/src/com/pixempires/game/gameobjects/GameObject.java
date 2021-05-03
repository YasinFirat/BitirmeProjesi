package com.pixempires.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;

/**
 * Her bir nesne bir GameObject'tir.
 */
public abstract class GameObject extends Component{
    protected GameWorld game_world;
    protected Texture texture;
    protected TextureRegion sprite;
    protected Vector2 position;
    protected Vector2 scale;
    protected float speed=1;

    protected GameObject() {

        position=new Vector2();
        scale=new Vector2();
    }
    protected GameObject(Texture texture){

        this.texture=texture;
        sprite=new TextureRegion(texture);
        position=new Vector2(100,100);
        scale=new Vector2(texture.getWidth(),texture.getHeight());
    }

    protected GameObject(Texture texture,int begin_x,int begin_y,int width,int heigth){
        this.texture=texture;
        sprite=new TextureRegion(texture,begin_x,begin_y,width,heigth);
        position=new Vector2(begin_x,begin_y);
        scale=new Vector2(width,heigth);
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

    /**
     * Nesne'nin hareket etmesini sağlar
     * @param direction hareket yönü belirlenir.
     * @param speed hız belirler. (kare hızı ile çarpmayı unutmayın.)
     * @return
     */
    public GameObject move(Vector2 direction,float speed){

        direction.x=direction.x==0?0:direction.x>0?1:-1;
        direction.y=direction.y==0?0:direction.y>0?1:-1;



        position.x+=direction.x*speed;
        position.y+=direction.y*speed;
        return this;
    }
    public GameObject move(Vector2 position,Vector2 target,float speed,float distance){

        if(Vector2.dst(position.x,position.y,target.x,target.y)<=distance){
            return this;
        }
        move(new Vector2(target.x-position.x,target.y-position.y),speed);
        return this;
    }

    public abstract void render(SpriteBatch sprite_batch);
    /**
     * sonsuz bir döngü
     * @param delta kare hızı
     */
    public abstract void update(float delta);
    public abstract void dispose();
    public TextureRegion getTextureRegion(){
        return sprite;
    }

    public float getSpeed() {
        return speed;
    }

    public GameObject setSpeed(float speed) {
        this.speed = speed;
        return this;
    }
}

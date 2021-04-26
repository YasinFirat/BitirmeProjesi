package com.pixempires.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Her bir nesne bir GameObject'tir.
 */
public abstract class GameObject extends Component{

    protected Texture texture;
    protected TextureRegion sprite;
    protected Vector2 position;
    protected Vector2 scale;

    protected GameObject() {
        System.out.println("GameObject");
    }
    protected GameObject(Texture texture){

        this.texture=texture;
        sprite=new TextureRegion(texture);
        position=new Vector2(100,150);
        scale=new Vector2(texture.getWidth(),texture.getHeight());
    }

    protected GameObject(Texture texture,int begin_x,int begin_y,int width,int heigth){
        this.texture=texture;
        sprite=new TextureRegion(texture,begin_x,begin_y,width,heigth);
        position=new Vector2(100,150);
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
        position.x+=direction.x*speed;
        position.y+=direction.y*speed;
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



}

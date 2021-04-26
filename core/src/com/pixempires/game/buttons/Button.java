package com.pixempires.game.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class Button {
    private TextureRegion button_image;
    private Rectangle button_rect;
    private Vector2 position;
    private Vector2 scale;

    public TextureRegion getButton_image() {
        return button_image;
    }

    public void setButton_image(TextureRegion button_image) {
        this.button_image = button_image;
    }

    private Button(){}

    public Button(Vector2 position,TextureRegion button_image){

        this.position=position;
        scale=new Vector2(128,128);
        this.position=new Vector2(0,100);
        this.button_image=button_image;
        System.out.println(Gdx.graphics.getHeight());


        button_rect=new Rectangle(this.position.x,this.position.y,
               this.scale.x,this.scale.y);
    }
    public Button(Vector2 position,Vector2 scale,TextureRegion button_image){
        this.position=position;
        this.scale=scale;

        this.button_image=button_image;

        button_rect=new Rectangle(position.x,position.y,scale.x,scale.y);
    }

    public void render(SpriteBatch sprite_batch){
        sprite_batch.begin();
        sprite_batch.draw(button_image,position.x,position.y,scale.x,scale.y);
        sprite_batch.end();
    }

    public Rectangle getButtonRect(){
        return  button_rect;
    }
    public Vector2 getPosition(){
        return position;
    }
    public Vector2 getScale(){
        return scale;
    }
    public void setPosition(Vector2 position){
        this.position=position;
    }
    public void setScale(Vector2 scale){
        this.scale=scale;
    }

    /**
     * Eğer duruma göre farklılık gösteren bir olay varsa kullanılır.
     * @param touchPosition tıklanma pozisyonu
     * @return
     */
    public boolean isClicked(Vector2 touchPosition){
        if(getButtonRect().contains(new Vector2(touchPosition.x,(Gdx.graphics.getHeight())- touchPosition.y))){
            return true;
        }else{
            return false;
        }

    }

    /**
     * Eğer sürekli kullanmak istediğiniz bir olay varsa buraya yazılır.Default olarak kendi olayınızı yazabilirsiniz.
     * @param touchPosition tıklanma pozisyonu
     */
    public abstract void doSomething(Vector2 touchPosition);
    public abstract void doSomething();
    protected  void handleInput(){
        if(Gdx.input.justTouched()){
            doSomething();
        }
    }

}

package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


public class Button {
    private TextureRegion button_image;
    private Rectangle button_rect;
    private float x_kord,y_kord,width,height;

    private Button(){}

    public Button(float x_kord,float y_kord,TextureRegion button_image){
        this.x_kord=x_kord;
        this.y_kord=y_kord;
        width=100;
        height=100;
        this.button_image=button_image;

        button_rect=new Rectangle(x_kord,y_kord,width,height);
    }
    public Button(float x_kord,float y_kord,float width,float height,TextureRegion button_image){
        this.x_kord=x_kord;
        this.y_kord=y_kord;
        this.width=width;
        this.height=height;
        this.button_image=button_image;

        button_rect=new Rectangle(x_kord,y_kord,width,height);
    }

    public void render(SpriteBatch sprite_batch){
        sprite_batch.begin();
        sprite_batch.draw(button_image,x_kord,y_kord,width,height);
        sprite_batch.end();
    }

    public Rectangle getButtonRect(){
        return  button_rect;
    }

}

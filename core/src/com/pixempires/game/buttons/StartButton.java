package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class StartButton extends Button {

    public StartButton(Vector2 position, TextureRegion button_image) {
        super(position, button_image);
    }

    public StartButton(Vector2 position, Vector2 scale, TextureRegion button_image) {
        super(position, scale, button_image);
    }


    public void doSomething(Vector2 touch_position) {
        if(isClicked(touch_position)){
            System.out.println("Start Button");
        }
    }
}

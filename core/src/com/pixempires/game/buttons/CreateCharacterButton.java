package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class CreateCharacterButton extends Button {

    public CreateCharacterButton(Vector2 position, TextureRegion button_image) {
        super(position, button_image);
    }

    public CreateCharacterButton(Vector2 position, Vector2 scale, TextureRegion button_image) {
        super(position, scale, button_image);
    }

    @Override
    public void doSomething(Vector2 touchPosition) {

    }


    public void doSomething() {

    }

    public CreateCharacterButton(Vector2 position, TextureRegion button_image,int a){
        super(position, button_image);
    }
}

package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class DefanceButton extends Button {
    public DefanceButton(Vector2 position, TextureRegion button_image) {
        super(position, button_image);
    }

    public DefanceButton(Vector2 position, Vector2 scale, TextureRegion button_image) {
        super(position, scale, button_image);
    }

    @Override
    public void doSomething(Vector2 touchPosition) {

    }

    @Override
    public void doSomething() {

    }
}

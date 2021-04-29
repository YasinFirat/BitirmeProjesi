package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.enums.Command;

public class AttackButton extends CommandButtons {
    public AttackButton(Vector2 position, TextureRegion button_image, GameWorld game_world) {
        super(position, button_image,game_world);
    }

    public AttackButton(Vector2 position, Vector2 scale, TextureRegion button_image,GameWorld game_world) {
        super(position, scale, button_image,game_world);
    }

    @Override
    public void doSomething(Vector2 touch_position) {
        if(isClicked(touch_position)){
            getGameWorld().setCommand(Command.attack);
        }
    }

    @Override
    public void doSomething() {

    }
}

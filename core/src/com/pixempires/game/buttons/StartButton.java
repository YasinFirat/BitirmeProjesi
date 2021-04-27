package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.states.PlayState;
import com.pixempires.game.states.StateManager;

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
    public void openNewState(StateManager state_manager,Vector2 touch_position){
        if(isClicked(touch_position)){
            state_manager.set(new PlayState(state_manager));
        }
    }

    @Override
    public void doSomething() {

    }
}

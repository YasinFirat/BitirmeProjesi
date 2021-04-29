package com.pixempires.game.buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.enums.Command;

public abstract class CommandButtons extends Button {

    private GameWorld game_world;
    public CommandButtons(Vector2 position,TextureRegion button_image,GameWorld game_world){
        super(position,button_image);
        this.game_world=game_world;
    }
    public CommandButtons(Vector2 position, Vector2 scale, TextureRegion button_image,GameWorld game_world) {
        super(position, scale, button_image);
        this.game_world=game_world;
    }
    public GameWorld getGameWorld(){
        return game_world;
    }
}

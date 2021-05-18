package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixempires.game.GameWorld;
import com.pixempires.game.other.CommandPositions;

/**
 * Oyunda korunması gereken obje, eger bu obje kaybedilirse oyunda kaybedilir.(Simdilik heykel olarak gorev yapacak.)
 */
public class Statue extends Soldier {
    public Statue(GameWorld game_world, CommandPositions command_positions) {
        super(game_world, command_positions);
    }

    public Statue() {
        setSprite(new Texture("statue.png"));
    }

    public Statue(Texture texture) {
        super(texture);
    }

    public Statue(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }



    @Override
    public void render(SpriteBatch sprite_batch) {
        sprite_batch.begin();
        sprite_batch.draw(getSprite(),command_positions.getBackoff_position().x,command_positions.getBackoff_position().y,80,80);
        sprite_batch.end();


    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }
}

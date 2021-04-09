package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.gameobjects.character.Character;

/**
 * Oyunda korunması gereken obje, eger bu obje kaybedilirse oyunda kaybedilir.(Simdilik heykel olarak gorev yapacak.)
 */
public class Statue extends Character {
    public Statue() {
    }

    public Statue(Texture texture) {
        super(texture);
    }

    public Statue(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }

    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }
}

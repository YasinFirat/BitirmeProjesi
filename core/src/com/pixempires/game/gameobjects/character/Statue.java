package com.pixempires.game.gameobjects.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixempires.game.gameobjects.character.Character;

/**
 * Oyunda korunması gereken obje, eger bu obje kaybedilirse oyunda kaybedilir.(Simdilik heykel olarak gorev yapacak.)
 */
public class Statue extends Character {
    public Statue() {
        System.out.println("Statue");

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
        sprite_batch.draw(getTextureRegion(),getPosition().x,getPosition().y,getScale().x,getScale().y);
        sprite_batch.end();
        System.out.println("pos"+getPosition());

    }

    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }
}

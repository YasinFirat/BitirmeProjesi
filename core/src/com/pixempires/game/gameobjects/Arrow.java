package com.pixempires.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Arrow extends Soldier {


    public Arrow(){
        super(new Texture("spr_ArcherAttack_strip_NoBkg.png"),
                792,49,19,8);
    }
    public Arrow(Texture texture){
        super(texture);
    }
    public Arrow(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }
    public void update(float delta) {

    }

    public void dispose() {

    }


   
}

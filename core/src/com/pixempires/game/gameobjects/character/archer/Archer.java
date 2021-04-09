package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.character.Soldier;

public class Archer extends Soldier {


    public Archer(){
        super();
    }
    public Archer(Texture texture){
        super(texture);
    }
    public Archer(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }
    public void update(float delta) {

    }

    public void dispose() {

    }


   
}

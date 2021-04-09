package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.pixempires.game.animations.Animation;

public class NormalArcher extends Archer {
    public NormalArcher() {
        Texture archer_tex=new Texture("spr_ArcherAttack_strip_NoBkg.png");
        setAnimation(new Animation(archer_tex))
                .getAnimation()
                .Split1D(45,37,46,39,9,180)
                .setPosition(getPosition());

    }

    public NormalArcher(Texture texture) {
        super(texture);

    }

    public NormalArcher(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }
}

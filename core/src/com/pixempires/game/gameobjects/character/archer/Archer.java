
package com.pixempires.game.gameobjects.character.archer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixempires.game.GameWorld;
import com.pixempires.game.animations.Animation;
import com.pixempires.game.gameobjects.character.Soldier;
import com.pixempires.game.other.CommandPositions;

public abstract class Archer extends Soldier {
    public Archer(GameWorld game_world, CommandPositions command_positions,boolean isLookRight){
        super(game_world,command_positions,isLookRight);

    }
    public Archer(){
        super();
        System.out.println("Archer");
    }
    public Archer(Texture texture){
        super(texture);

    }
    public Archer(Texture texture, int begin_x, int begin_y, int width, int heigth) {
        super(texture, begin_x, begin_y, width, heigth);
    }
}

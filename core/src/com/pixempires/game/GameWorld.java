package com.pixempires.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.buttons.AttackButton;
import com.pixempires.game.buttons.BackOffButton;
import com.pixempires.game.buttons.Button;
import com.pixempires.game.buttons.DefanceButton;
import com.pixempires.game.gameobjects.character.Statue;

public  class GameWorld {
    private Texture texture;
    public Button btn_attack;
    public Button btn_defense;
    public Button btn_backOff;

    public Statue statue_player;


    public GameWorld(){
        texture=new Texture("btn_attack.png");
        btn_attack=new AttackButton(new Vector2(PixEmpires.WIDTH/2-50,PixEmpires.HEIGHT/2-48),
                new Vector2(16,16), new TextureRegion(texture));

        texture=new Texture("btn_defense.png");
        btn_defense=new DefanceButton(new Vector2(PixEmpires.WIDTH/2-66,PixEmpires.HEIGHT/2-32),
                new Vector2(16,16), new TextureRegion(texture));

        texture=new Texture("btn_castle.png");
        btn_backOff=new BackOffButton(new Vector2(PixEmpires.WIDTH/2-82,PixEmpires.HEIGHT/2-16),
                new Vector2(16,16), new TextureRegion(texture));

        texture=new Texture("statue.png");
        statue_player=new Statue(texture);
        statue_player.setPosition(100,150);
        statue_player.setScale(25,50);


    }
    public void render(SpriteBatch sprite_batch){
        btn_attack.render(sprite_batch);
        btn_defense.render(sprite_batch);
        btn_backOff.render(sprite_batch);
        statue_player.render(sprite_batch);
    }
}

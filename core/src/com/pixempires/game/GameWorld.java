package com.pixempires.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.buttons.AttackButton;
import com.pixempires.game.buttons.BackOffButton;
import com.pixempires.game.buttons.Button;
import com.pixempires.game.buttons.DefanceButton;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.gameobjects.character.Statue;
import com.pixempires.game.gameobjects.character.archer.Archer;
import com.pixempires.game.gameobjects.character.archer.NormalArcher;

import java.util.ArrayList;

public  class GameWorld {
    private Texture texture;
    public Button btn_attack;
    public Button btn_defense;
    public Button btn_backOff;

    public Statue statue_player;

    public ArrayList<Archer> archer;
    float timer=1;
    boolean test=false;



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

        archer=new ArrayList<Archer>();
        archer.add(new NormalArcher());
        archer.add(new NormalArcher());
        archer.add(new NormalArcher());

    }
    public void render(SpriteBatch sprite_batch){

        for (int i=0; i<archer.size(); i++){
            archer.get(i).render(sprite_batch);
        }
        btn_attack.render(sprite_batch);
        btn_defense.render(sprite_batch);
        btn_backOff.render(sprite_batch);
        statue_player.render(sprite_batch);
    }
    public void update(float delta){
        timer+=delta;

        btn_attack.doSomething(new Vector2(Gdx.input.getX(),Gdx.input.getY()));
        if(btn_attack.isClicked(new Vector2(Gdx.input.getX(),Gdx.input.getY()))){
            System.out.println( "TikTik");
        }

        if((int)timer%5==1){
            test=false;
        }
        if((int)timer%5==0&&!test&&archer.size()>0){ //burada health test edildi.
            test=true;
          archer.get(0).getHealth().subtractHealth(100);
        }

        for (int i=0; i<archer.size(); i++){
            archer.get(i).update(delta);
            if(archer.get(i).getHealth().isHealthFinish()){
                archer.remove(i);
            }
        }
    }
}

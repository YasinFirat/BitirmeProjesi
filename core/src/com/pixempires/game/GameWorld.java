package com.pixempires.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.buttons.AttackButton;
import com.pixempires.game.buttons.BackOffButton;
import com.pixempires.game.buttons.Button;
import com.pixempires.game.buttons.CreateCharacterButton;
import com.pixempires.game.buttons.DefanceButton;
import com.pixempires.game.enums.Command;
import com.pixempires.game.gameobjects.GameObject;
import com.pixempires.game.gameobjects.character.Statue;
import com.pixempires.game.gameobjects.character.archer.Archer;
import com.pixempires.game.gameobjects.character.archer.NormalArcher;

import java.util.ArrayList;

public  class GameWorld {
    private Command command=Command.defance;
    private Vector2 touch_position;
    private Texture texture;
    //region Button values
    public Button btn_attack;
    public Button btn_defense;
    public Button btn_backOff;
    public CreateCharacterButton<NormalArcher> normalArcherCreateCharacterButton;

    //endregion

    public Statue statue_player;
    public ListOfCharacters listOfCharacters;

    float timer=1;
    boolean test=false;

    public GameWorld(){

        //region Castle,Defence,Attack Buttons

        texture=new Texture("btn_castle.png");
        btn_backOff=new BackOffButton(new Vector2(PixEmpires.WIDTH-128,PixEmpires.HEIGHT-48),
                new Vector2(32,32), new TextureRegion(texture),this);

        texture=new Texture("btn_defense.png");
        btn_defense=new DefanceButton(new Vector2(PixEmpires.WIDTH-90,PixEmpires.HEIGHT-80),
                new Vector2(32,32), new TextureRegion(texture),this);

        texture=new Texture("btn_attack.png");
        btn_attack=new AttackButton(new Vector2(PixEmpires.WIDTH-50,PixEmpires.HEIGHT-112),
                new Vector2(32,32), new TextureRegion(texture),this);
        //endregion

        //region Create Character Buttons
        texture=new Texture("btn_castle.png");
        normalArcherCreateCharacterButton=new CreateCharacterButton<NormalArcher>(new Vector2(PixEmpires.WIDTH-512,PixEmpires.HEIGHT-48),
                new Vector2(32,32), new TextureRegion(texture));

        //endregion

       // statue_player=new Statue(new Texture("statue.png"),100,500,32,64);
        //region Test deneme amacli
        texture=new Texture("statue.png");
        statue_player=new Statue(texture);
        statue_player.setPosition(150,350);
        statue_player.setScale(64,96);


       listOfCharacters=new ListOfCharacters();

        //endregion

    }
    public void render(SpriteBatch sprite_batch){


        //region ButtonRenders
        btn_attack.render(sprite_batch);
        btn_defense.render(sprite_batch);
        btn_backOff.render(sprite_batch);
        //endregion
        listOfCharacters.render(sprite_batch);
        normalArcherCreateCharacterButton.render(sprite_batch);
        statue_player.render(sprite_batch);
    }
    public void handleInput() {
        if(Gdx.input.justTouched()){
            touch_position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            //region ButtonHandles
            btn_attack.doSomething(touch_position);
            btn_defense.doSomething(touch_position);
            btn_backOff.doSomething(touch_position);
            //endregion
            normalArcherCreateCharacterButton.AddChacter(listOfCharacters.normalArchers,new NormalArcher(),touch_position);

        }
    }
    public void update(float delta){

        handleInput();
        //region Her 5 saniyede bir herhangi bir karakterin sağlığı 100 duser

        timer+=delta;
        if((int)timer%5==1){
            test=false;
        }
        if((int)timer%5==0&&!test&&listOfCharacters.normalArchers.size()>0){ //burada health test edildi.her 5 saniyede bir bir elemanın healthi sifirlaniyor
            test=true;
          listOfCharacters.normalArchers.get(0).getHealth().subtractHealth(100);
        }
        //endregion
        listOfCharacters.update(delta);




    }

    public GameWorld setCommand(Command command){
        this.command=command;
        return this;
    }
}

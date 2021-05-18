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
import com.pixempires.game.gameobjects.character.Soldier;
import com.pixempires.game.gameobjects.character.Statue;
import com.pixempires.game.gameobjects.character.archer.NormalArcher;
import com.pixempires.game.other.CommandPositions;
import com.pixempires.game.other.ListOfCharacters;
import com.pixempires.game.other.Military;

public  class GameWorld {
    public Military player;
    public Military artificial_intelligence;

    private Vector2 touch_position;
    private Texture texture;
    //region Button values
    public Button btn_attack;
    public Button btn_defense;
    public Button btn_backOff;
    public CreateCharacterButton<Soldier> normalArcherCreateCharacterButton;

    //endregion

    public Statue statue_player;



    float timer=1;
    boolean test=false;

    public GameWorld(){
        //region Military
         player=new Military();
         player.setCommandPositions(
                new CommandPositions(new Vector2(800,350),new Vector2(150,350)))
                .setCharacters(new ListOfCharacters(4,player.getCommandPositions()));
         //AI eklendi.
         artificial_intelligence=new Military();
         artificial_intelligence.setCommandPositions(
                 new CommandPositions(new Vector2(150,350),new Vector2(800,350)))
                 .setCharacters(new ListOfCharacters(4,artificial_intelligence.getCommandPositions()));

         //endregion

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
        normalArcherCreateCharacterButton=new CreateCharacterButton<Soldier>(new Vector2(PixEmpires.WIDTH-512,PixEmpires.HEIGHT-48),
                new Vector2(32,32), new TextureRegion(texture));

        //endregion

    }
    public void render(SpriteBatch sprite_batch){

        //region ButtonRenders
        btn_attack.render(sprite_batch);
        btn_defense.render(sprite_batch);
        btn_backOff.render(sprite_batch);
        //endregion

        //region CreateButtons
        normalArcherCreateCharacterButton.render(sprite_batch);
        //endregion

        //region Military
        player.getCharacters().render(sprite_batch);
        artificial_intelligence.getCharacters().render(sprite_batch);
        //endregion

    }
    public void handleInput() {
        if(Gdx.input.justTouched()){
            touch_position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            //region ButtonHandles
            btn_attack.doSomething(touch_position);
            btn_defense.doSomething(touch_position);
            btn_backOff.doSomething(touch_position);
            //endregion
            //region Create Characters

            normalArcherCreateCharacterButton.AddChacter(
                    player.getCharacters().soldiers,new NormalArcher(this,player.getCommandPositions()),touch_position
            );
            //endregion
        }
    }
    public void update(float delta){
        handleInput();

        //region Military
        player.getCharacters().update(delta);
        artificial_intelligence.getCharacters().update(delta);
        //endregion
    }

    public GameWorld setPlayerCommand(Command player_command){
        player.setCommand(player_command);
        return this;
    }
    public Command getPlayerCommand(){
        return player.getCommand();
    }
    public  CommandPositions getPlayerCommandPositions(){
        return player.getCommandPositions();
    }
}

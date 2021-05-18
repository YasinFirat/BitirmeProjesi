package com.pixempires.game.other;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.collision.Trigger;
import com.pixempires.game.gameobjects.character.Soldier;
import com.pixempires.game.gameobjects.character.Statue;

import java.util.ArrayList;
//Daha sonradan optimizasyon yapılacak.
public class ListOfCharacters {
    public CommandPositions command_position;
    /**
     * Tüm birliklerin listesi okçu,savaşçı,büyücü ...
     */
    public ArrayList<Soldier> soldiers =new ArrayList<>();
    public Statue statue;
    /**
     * askerlerin sırasını hesaplar
     */
    private int position_counter;
    /**
     * Maximum Hizalama
     */
    private int max_alignment=1;

    private ListOfCharacters(){}
    private Trigger collision=new Trigger();
    public ListOfCharacters(int max_alignment,CommandPositions command_position) {
        this.command_position=command_position;
        if(max_alignment>1){
            this.max_alignment=max_alignment;
        }
        statue=new Statue();
        statue.setCommandPositions(command_position);

        soldiers.add(statue);
    }

    public void render(SpriteBatch sprite_batch){
        for (int i = 0; i< soldiers.size(); i++){
            soldiers.get(i).render(sprite_batch);
        }
    }
    public void update(float delta){
        for (int i = 0; i< soldiers.size(); i++){
            soldiers.get(i).update(delta);

            soldiers.get(i).getCommandPositions().setDefance_position(new Vector2((position_counter/max_alignment)*30+200,(position_counter%max_alignment)*50+250));

            if(soldiers.get(i).getHealth().isHealthFinish()){
                soldiers.remove(i); //health biten karakter yok olur.
            }
            position_counter++;
        }
        position_counter=0;
    }
}

package com.pixempires.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.gameobjects.character.archer.NormalArcher;

import java.util.ArrayList;
//Daha sonradan optimizasyon yapılacak.
public class ListOfCharacters {

    public ArrayList<NormalArcher> normalArchers=new ArrayList<>();
    private int position_counter;
    private int max_alignment=4;

    public void render(SpriteBatch sprite_batch){
        for (int i=0; i<normalArchers.size(); i++){
            normalArchers.get(i).render(sprite_batch);
        }
    }
    public void update(float delta){
        for (int i=0; i<normalArchers.size(); i++){
            normalArchers.get(i).update(delta);

            normalArchers.get(i).setDefancePosition(new Vector2((position_counter/max_alignment)*30+200,(position_counter%max_alignment)*50+250));

            if(normalArchers.get(i).getHealth().isHealthFinish()){
                normalArchers.remove(i); //health biten karakter yok olur.
            }
            position_counter++;
        }
        position_counter=0;
    }
}

package com.pixempires.game.collision;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.gameobjects.character.Soldier;

import java.util.ArrayList;

/**
 * İstenilen uzaklığı hesaplar ve duruma göre işlem yapar.
 */
public class Trigger {
    private float distance;
    private Vector2 pos1=new Vector2().setZero();
    private Vector2 pos2=new Vector2().setZero();
    public Trigger onTriggerEnter(ArrayList<Soldier> soldiers){
        for(int i=0; i<soldiers.size()-1; i++){
            for (int j=i+1; j<soldiers.size(); j++){
                onTriggerEnter(soldiers.get(i),soldiers.get(j));
            }
        }
        return this;
    }
    public Trigger onTriggerEnter(ArrayList<Soldier> soldiers1, ArrayList<Soldier> soldiers2){
        for(int i=0; i<soldiers1.size()-1; i++){
            for (int j=0; j<soldiers2.size(); j++){
                onTriggerEnter(soldiers1.get(i),soldiers2.get(j));
            }
        }
        return this;
    }
    public Trigger onTriggerEnter(Soldier soldier1, Soldier soldier2){
        pos1=soldier1.getPosition();
        pos2=soldier2.getPosition();
        distance=Vector2.dst(pos1.x,pos1.y,pos2.x,pos2.y);
        soldier1.checkAttack(soldier2,distance);
        soldier2.checkAttack(soldier1,distance);
        return this;
    }
    public float getDistance(){
        return  distance;
    }
}

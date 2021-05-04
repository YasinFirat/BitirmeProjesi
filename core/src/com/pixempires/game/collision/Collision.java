package com.pixempires.game.collision;
import com.pixempires.game.gameobjects.character.Soldier;

public class Collision {

    public static void onTriggerEnter(Soldier[] soldiers){
        for(int i=0; i<soldiers.length-1; i++){
            for (int j=i+1; j<soldiers.length; j++){
                soldiers[i].bouncing(soldiers[j]);
                onTriggerEnter(soldiers[i],soldiers[j]);
                
            }
        }
    }
    public static void onTriggerEnter(Soldier[] soldiers1,Soldier[] soldiers2){
        for(int i=0; i<soldiers1.length-1; i++){
            for (int j=0; j<soldiers2.length; j++){
                onTriggerEnter(soldiers1[i],soldiers2[j]);
            }
        }
    }
    public static void onTriggerEnter(Soldier soldier1,Soldier soldier2){
        soldier1.bouncing(soldier2);
        soldier2.bouncing(soldier1);
    }
}

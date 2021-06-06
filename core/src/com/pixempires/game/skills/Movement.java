package com.pixempires.game.skills;

import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.gameobjects.GameObject;

public class Movement {
    public float speed=1;
    public boolean is_move;
    public int x_direction;
    private int keep_direction=0;



    public Movement(){
        speed=1;
    }

    /**
     * Nesne'nin istenilen yöne hareket etmesini sağlar
     * @param direction hareket yönü belirlenir.
     * @param speed hız belirler. (kare hızı ile çarpmayı unutmayın.)
     * @return aynı sınıfı döndürür
     */
    public Vector2 move(Vector2 current,Vector2 direction, float speed){

        //x değeri 0 ise 0 ; sıfırdan büyük ise 1, değilse -1 değerini alır
        x_direction=findDirection(direction.x);

        direction.x=x_direction;
        //y değeri 0 ise 0 ; sıfırdan büyük ise 1, değilse -1 değerini alır
        direction.y=findDirection(direction.y);
        //belirtilen yöne doğru speed hızında ilerleyecektir.
        current.add(direction.x*speed,direction.y*speed);

        return current;
    }
    public int findDirection(float value){
       return value==0?0:value>0?1:-1;
    }

    /**
     * Karakter istenilen konuma hareket eder. Vardığında ise durur
     * @param current karakterin anlık pozisyonu
     * @param target hedef
     * @param speed speed
     * @param distance karakterin hedefe ulaştığında duracağı konum
     * @return
     */
    public Vector2 move(Vector2 current,Vector2 target,float speed,float distance){

        if(Vector2.dst(current.x,current.y,target.x,target.y)<=distance){

            is_move=false;
            return current;
        }
        is_move=true;
        //current= move(current,new Vector2(target.x-current.x,target.y-current.y),speed);
        return move(current,new Vector2(target.x-current.x,target.y-current.y),speed);
    }
}

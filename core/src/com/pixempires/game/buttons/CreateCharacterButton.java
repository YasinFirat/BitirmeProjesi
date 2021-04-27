package com.pixempires.game.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.gameobjects.character.Soldier;

import java.util.ArrayList;
import java.util.List;

public class CreateCharacterButton<T> extends Button {

    private T t;
    public CreateCharacterButton(Vector2 position, TextureRegion button_image) {
        super(position, button_image);
    }

    public CreateCharacterButton(Vector2 position, Vector2 scale, TextureRegion button_image) {
        super(position, scale, button_image);
    }

    @Override
    public void doSomething(Vector2 touch_position) {
        if(isClicked(touch_position)){
            System.out.println("Character Added");
        }

    }

    /**
     * Liste'ye ekleme islemini yapar.
     * @param list
     * @param member
     * @param touch_position
     */
    public void AddChacter(List<T> list,T member,Vector2 touch_position){
        if(isClicked(touch_position)){
            System.out.println("Character Added" +list.size());
            list.add(member);
        }

    }


    public void doSomething() {

    }

    public CreateCharacterButton(Vector2 position, TextureRegion button_image,int a){
        super(position, button_image);
    }
}

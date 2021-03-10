package com.pixempires.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * State ile ilgili kontroller yapılacak.
 */

public class StateManager {
    private Stack<State> states;

    /**
     * Default olarak stack atandı.
     */
    public StateManager(){
        states=new Stack<State>();
    }

    /**
     * Açılması istenen state eklenir.
     * @param state
     */
    public void push(State state){
        states.push(state);
    }

    /**
     * En son tanımlanan state kaldırılır.
     */
    public void pop(){
        states.pop().dispose();
    }

    /**
     * Once pop ile en son state çıkarılır(dispose), sonra parametre olarak girilen değişken tanımlanır.
     * @param state
     */
    public void set(State state){
        states.pop().dispose();
        push(state);
    }
    public void update(float delta){
        states.peek().update(delta);
    }
    public void render(SpriteBatch sprite_batch){
        states.peek().render(sprite_batch);
    }
}

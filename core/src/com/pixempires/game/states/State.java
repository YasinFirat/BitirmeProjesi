package com.pixempires.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.pixempires.game.PixEmpires;

public abstract class State {
    protected OrthographicCamera camera;
    protected StateManager state_manager;
    protected Vector3 touch_position;

    public State(StateManager state_manager){
        camera=new OrthographicCamera();

        this.state_manager=state_manager;
        touch_position=new Vector3();
    }

    /**
     * Obje çağrıldığında bir defa çalışır.
     */
    public abstract void create();
    /**
     * Çizim ve görüntü işlemleri burada yapılır.
     */
    public abstract void render(SpriteBatch sprite_batch);
    /**
     * Saniye'de delta kadar çalışır ve birçok hesaplama işlemleri burada yapılır.
     */
    public abstract void update(float delta);

    /**
     * Touch işlemleri yapılacak.
     */
    protected abstract void handleInput();

    /**
     * State'den çıkacağımız zaman çağırmalıyız.
     */
    public abstract void dispose();
}

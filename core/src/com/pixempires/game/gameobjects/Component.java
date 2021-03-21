package com.pixempires.game.gameobjects;

public class Component<T> {
    private T t;

    public T getComponent(T t){
        this.t=t;
        return this.t;
    }
}

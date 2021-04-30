package com.pixempires.game.other;

import com.badlogic.gdx.math.Vector2;

/**
 * Oyun icinde attack,defance,backoff gibi komutlar geldiginde karakterin haraket edecegi konumları referas alır.
 * Oyun basinda atamasi yapilmasi onerilir.
 */
public class CommandPositions {
    private Vector2 attack_position=new Vector2().setZero();
    private Vector2 defance_position=new Vector2().setZero();;
    private Vector2 backoff_position=new Vector2().setZero();;

    public CommandPositions(Vector2 attack_position,Vector2 backoff_position) {
        this.attack_position = attack_position;
        this.backoff_position = backoff_position;
    }

    public Vector2 getAttack_position() {
        return attack_position;
    }

    public CommandPositions setAttack_position(Vector2 attack_position) {
        this.attack_position = attack_position;
        return this;
    }

    public Vector2 getDefance_position() {
        return defance_position;
    }

    public CommandPositions setDefance_position(Vector2 defance_position) {
        this.defance_position = defance_position;
        return this;
    }

    public Vector2 getBackoff_position() {
        return backoff_position;
    }

    public CommandPositions setBackoff_position(Vector2 backoff_position) {
        this.backoff_position = backoff_position;
        return this;
    }
}

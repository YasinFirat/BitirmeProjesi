package com.pixempires.game.enums;

public enum Command {
    attack( 1),
    defance(0),
    backoff(-1);
    private int move_direction;

    public int getMoveDirection(){
        return move_direction;
    }

     Command(int move_direction) {
        this.move_direction=move_direction;
    }
}

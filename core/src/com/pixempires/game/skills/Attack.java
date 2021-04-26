package com.pixempires.game.skills;

public class Attack {
    private int damage=10;
    private int attack_speed=1;
    private int attack_distance=1;

    /**
     * Saldiri hasarini olusturur.
     * @param damage saldiri hasari giriniz
     * @return
     */
    public Attack setDamage(int damage){
        this.damage=damage;
        return this;
    }

    /**
     * Saldiri hasarini dondurur.
     * @return
     */
    public int getDamage(){
        return damage;
    }

    /**
     * Saldiri hizi eklenir.
     * @param attack_speed saldiri hizi giriniz.
     * @return
     */
    public Attack setAttackSpeed(int attack_speed){
        this.attack_speed=attack_speed;
        return this;
    }

    /**
     * Saldiri hizi dodurulur.
     * @return
     */
    public int getAttackSpeed(){
        return attack_speed;
    }
    public int getAttack_distance() {
        return attack_distance;
    }

    public Attack setAttackDistance(int attack_distance) {
        this.attack_distance = attack_distance;
        return this;
    }

}
